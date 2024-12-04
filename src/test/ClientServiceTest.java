package com.springboot.backend.alam.clientes.clientes_backend.services;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.springboot.backend.alam.clientes.clientes_backend.entities.Client;

class ClientServiceTest {

    private final ClientService clientService = new ClientService();

    @Test
    void testFindClient_ValidDocumentAndType() {
        
        String numeroDocumento = "23445322";
        String tipoDocumento = "C";

        Client client = clientService.findClient(numeroDocumento, tipoDocumento);

        assertNotNull(client, "El cliente no debería ser nulo");
        assertEquals("Alam", client.getFirstName());
        assertEquals("Crhistopher", client.getMiddleName());
        assertEquals("Alvarez", client.getLastName());
        assertEquals("Vargas", client.getSecondLastName());
        assertEquals("3143577288", client.getPhone());
        assertEquals("Calle 123 #45-67", client.getAddress());
        assertEquals("Bogotá", client.getCity());
    }

    @Test
    void testFindClient_InvalidDocumentOrType() {
        
        String numeroDocumento = "12345678";
        String tipoDocumento = "C";

        Client client = clientService.findClient(numeroDocumento, tipoDocumento);

        assertNull(client, "El cliente debería ser nulo");
    }

    @Test
    void testFindClient_InvalidType() {
        
        String numeroDocumento = "23445322";
        String tipoDocumento = "P";

        Client client = clientService.findClient(numeroDocumento, tipoDocumento);

        assertNull(client, "El cliente debería ser nulo para tipo de documento inválido");
    }
}
