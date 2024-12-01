package com.springboot.backend.alam.clientes.clientes_backend.services;

import org.springframework.stereotype.Service;

import com.springboot.backend.alam.clientes.clientes_backend.entities.Client;

@Service
public class ClientService {


    public Client findClient(String numeroDocumento, String tipoDocumento){
        if ("C".equals(tipoDocumento) && "23445322".equals(numeroDocumento)) {
            return new Client("Alam", "Crhistopher", "Alvarez", "Vargas", "3143577288", 
                               "Calle 123 #45-67", "Bogotá");
        }
        
        return null;
    }

}
