package entidades;

import java.util.Objects;

public abstract class Persona {
    protected String nombre;
    protected String apellido;

    public Persona(String nombre, String apellido) {
        Objects.requireNonNull(nombre, "El nombre no puede ser nulo");
        Objects.requireNonNull(apellido, "El apellido no puede ser nulo");
        if (nombre.trim().isEmpty() || apellido.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre y el apellido no pueden estar vacíos");
        }
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                '}';
    }
}