package personas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
public class Hotel {
    private final String nombre;
    private Ciudad ciudad;
    private final List<Habitacion> habitaciones = new ArrayList<>();
    private final List<Empleado> empleados = new ArrayList<>();

    public Hotel(String nombre) {
        Objects.requireNonNull(nombre, "El nombre del hotel no puede ser nulo");
        if (nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del hotel no puede estar vacío");
        }
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        if (this.ciudad != ciudad) {
            if (this.ciudad != null) {
                this.ciudad.getInternalHoteles().remove(this);
            }
            this.ciudad = ciudad;
            if (ciudad != null) {
                ciudad.getInternalHoteles().add(this);
            }
        }
    }


    public Habitacion crearHabitacion(int numero, String tipo) {
        Habitacion habitacion = new Habitacion(numero, tipo, this);
        habitaciones.add(habitacion);
        return habitacion;
    }

    public void agregarEmpleado(Empleado empleado) {
        if (empleado != null && !empleados.contains(empleado)) {
            empleados.add(empleado);
        }
    }

    public List<Habitacion> getHabitaciones() {
        return Collections.unmodifiableList(habitaciones);
    }

    public List<Empleado> getEmpleados() {
        return Collections.unmodifiableList(empleados);
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "nombre='" + nombre + '\'' +
                ", ciudad=" + (ciudad != null ? ciudad.getNombre() : "null") +
                '}';
    }
}