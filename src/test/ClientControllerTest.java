package com.springboot.backend.alam.clientes.clientes_backend.controllers;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

import com.springboot.backend.alam.clientes.clientes_backend.entities.Client;
import com.springboot.backend.alam.clientes.clientes_backend.services.ClientService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

class ClientControllerTest {

    private MockMvc mockMvc;

    @Mock
    private ClientService clientService;

    @InjectMocks
    private ClientController clientController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(clientController).build();
    }

    @Test
    void consultarCliente_ParametrosValidos() throws Exception {
        
        String numeroDocumento = "23445322";
        String tipoDocumento = "C";
        Client mockClient = new Client("Alam", "Crhistopher", "Alvarez", "Vargas", "3143577288", 
                                       "Calle 123 #45-67", "Bogotá");

        when(clientService.findClient(numeroDocumento, tipoDocumento)).thenReturn(mockClient);

        
        mockMvc.perform(get("/clientes")
                .param("numeroDocumento", numeroDocumento)
                .param("tipoDocumento", tipoDocumento)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").value("Alam"))
                .andExpect(jsonPath("$.middleName").value("Crhistopher"))
                .andDo(print());
    }

    @Test
    void consultarCliente_ClienteNoEncontrado() throws Exception {
        
        String numeroDocumento = "12345678";
        String tipoDocumento = "C";

        when(clientService.findClient(numeroDocumento, tipoDocumento)).thenReturn(null);

        
        mockMvc.perform(get("/clientes")
                .param("numeroDocumento", numeroDocumento)
                .param("tipoDocumento", tipoDocumento)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(content().string("Cliente no encontrado."))
                .andDo(print());
    }

    @Test
    void consultarCliente_ParametrosInvalidos() throws Exception {
        
        mockMvc.perform(get("/clientes")
                .param("numeroDocumento", "23445322"))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Los parámetros 'numeroDocumento' y 'tipoDocumento' son obligatorios."))
                .andDo(print());
    }

    @Test
    void consultarCliente_ErrorInterno() throws Exception {
        
        String numeroDocumento = "23445322";
        String tipoDocumento = "C";

        when(clientService.findClient(numeroDocumento, tipoDocumento)).thenThrow(new RuntimeException("Database error"));

        
        mockMvc.perform(get("/clientes")
                .param("numeroDocumento", numeroDocumento)
                .param("tipoDocumento", tipoDocumento)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isInternalServerError())
                .andExpect(content().string("Ocurrió un error interno en el servidor."))
                .andDo(print());
    }
}
