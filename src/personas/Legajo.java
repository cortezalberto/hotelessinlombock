package personas;

import java.util.Objects;
// Clase Legajo
public class Legajo {
    private final String numero;
    private Empleado empleado;

    public Legajo(String numero) {
        Objects.requireNonNull(numero, "El número de legajo no puede ser nulo");
        if (numero.trim().isEmpty()) {
            throw new IllegalArgumentException("El número de legajo no puede estar vacío");
        }
        this.numero = numero;
    }

    public String getNumero() {
        return numero;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        if (this.empleado != empleado) {
            this.empleado = empleado;
            if (empleado != null && empleado.getLegajo() != this) {
                empleado.setLegajo(this);
            }
        }
    }

    @Override
    public String toString() {
        return "Legajo{" +
                "numero='" + numero + '\'' +
                ", empleado=" + (empleado != null ? empleado.getNombre() + " " + empleado.getApellido() : "null") +
                '}';
    }
}