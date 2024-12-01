package com.springboot.backend.alam.clientes.clientes_backend.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.springboot.backend.alam.clientes.clientes_backend.entities.Client;
import com.springboot.backend.alam.clientes.clientes_backend.services.ClientService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/clientes")
public class ClientController {
    private static final Logger logger = (Logger) LoggerFactory.getLogger(ClientController.class);

    @Autowired
    private ClientService service;

    @GetMapping
    public ResponseEntity<?> consultarCliente(
        @RequestParam(required = false) String numeroDocumento,
        @RequestParam(required = false) String tipoDocumento) {
            logger.info("Consultando cliente con tipoDocumento={} y numeroDocumento={}", tipoDocumento, numeroDocumento);
        try {
            // Validación de los parámetros de entrada (400 Bad Request)
            if (tipoDocumento == null || numeroDocumento == null) {
                logger.warn("Los parámetros: tipoDocumento={}, numeroDocumento={} son obligatorios.", tipoDocumento, numeroDocumento);
                return ResponseEntity.badRequest().body("Los parámetros 'numeroDocumento' y 'tipoDocumento' son obligatorios.");
            }

            if (!tipoDocumento.equals("C") && !tipoDocumento.equals("P")) {
                logger.warn("El parámetro: tipoDocumento={} debe ser 'C' o 'P'.", tipoDocumento);
                return ResponseEntity.badRequest().body("El parámetro 'tipoDocumento' debe ser 'C' o 'P'.");
            }

            // Llamada al servicio para buscar el cliente
            Client cliente = service.findClient(numeroDocumento, tipoDocumento);

            // Validación de cliente no encontrado (404 Not Found)
            if (cliente == null) {
                logger.info("Cliente no encontrado");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado.");
            }

            // Respuesta exitosa (200 OK)
            logger.info("Cliente encontrado: {}", cliente);
            return ResponseEntity.ok(cliente);

        } catch (Exception e) {
            // Manejo de errores inesperados (500 Internal Server Error)
            logger.error("Error al consultar cliente", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("Ocurrió un error interno en el servidor.");
        }
    }
    
    
}
