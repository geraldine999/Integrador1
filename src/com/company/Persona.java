package com.company;

public class Persona {
    private String dni;
    private String nombre;
    private String direccion;
    private Boolean propietario;

    public Persona(String dni, String nombre, String direccion, Boolean propietario) {
        this.dni = dni;
        this.nombre = nombre;
        this.direccion = direccion;
        this.propietario = propietario;
    }

    public String getNombre() {
        return nombre;
    }
}
