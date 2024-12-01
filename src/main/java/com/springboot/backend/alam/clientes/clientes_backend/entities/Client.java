package com.springboot.backend.alam.clientes.clientes_backend.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "clientes")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String numeroDocumento;

    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private String telefono;
    private String direccion;
    private String ciudadResidencia;


    // Constructor, getters y setters

    public Client(String primerNombre, String segundoNombre, String primerApellido, 
                   String segundoApellido, String telefono, String direccion, String ciudadResidencia) {
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.telefono = telefono;
        this.direccion = direccion;
        this.ciudadResidencia = ciudadResidencia;
    }

    // Clase para devolver el json para el log
    @Override
    public String toString() {
        return "Cliente{" +
                "\nPrimer Nombre='" + primerNombre + '\'' +
                ", \nSegundo Nombre='" + segundoNombre + '\'' +
                ", \nPrimer Apellido='" + primerApellido + '\'' +
                ", \nSegundo Apellido='" + segundoApellido + '\'' +
                ", \nTelefono='" + telefono + '\'' +
                ", \nDireccion='" + direccion + '\'' +
                ", \nCiudad de Residencia='" + ciudadResidencia + '\'' +
                '}';
    }


    // Getters y Setters
    public String getPrimerNombre() { return primerNombre; }
    public void setPrimerNombre(String primerNombre) { this.primerNombre = primerNombre; }

    public String getSegundoNombre() { return segundoNombre; }
    public void setSegundoNombre(String segundoNombre) { this.segundoNombre = segundoNombre; }

    public String getPrimerApellido() { return primerApellido; }
    public void setPrimerApellido(String primerApellido) { this.primerApellido = primerApellido; }

    public String getSegundoApellido() { return segundoApellido; }
    public void setSegundoApellido(String segundoApellido) { this.segundoApellido = segundoApellido; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public String getCiudadResidencia() { return ciudadResidencia; }
    public void setCiudadResidencia(String ciudadResidencia) { this.ciudadResidencia = ciudadResidencia; }
    
}
