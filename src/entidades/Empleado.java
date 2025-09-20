package entidades;

import java.util.Objects;

// Clase Empleado
public class Empleado extends Persona {
    private Cargos cargo;
    private Legajo legajo;

    public Empleado(String nombre, String apellido, Cargos cargo) {
        super(nombre, apellido);
        this.cargo = Objects.requireNonNull(cargo, "El cargo no puede ser nulo");
    }

    public Cargos getCargo() {
        return cargo;
    }

    public void setCargo(Cargos cargo) {
        this.cargo = Objects.requireNonNull(cargo, "El cargo no puede ser nulo");
    }

    public Legajo getLegajo() {
        return legajo;
    }

    public void setLegajo(Legajo legajo) {
        if (this.legajo != legajo) {
            if (this.legajo != null) {
                this.legajo.setEmpleado(null);
            }
            this.legajo = legajo;
            if (legajo != null) {
                legajo.setEmpleado(this);
            }
        }
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", cargo=" + cargo +
                ", legajo=" + (legajo != null ? legajo.getNumero() : "null") +
                '}';
    }
}