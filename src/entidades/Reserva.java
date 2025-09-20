package entidades;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

// Clase asociativa N–N con datos propios
public class Reserva {
    private final Cliente cliente;
    private final Habitacion habitacion;
    private final LocalDate checkIn;
    private final LocalDate checkOut;
    private final BigDecimal precio;

    public Reserva(Cliente cliente, Habitacion habitacion, LocalDate checkIn, LocalDate checkOut, BigDecimal precio) {
        Objects.requireNonNull(cliente, "El cliente no puede ser nulo");
        Objects.requireNonNull(habitacion, "La habitación no puede ser nula");
        Objects.requireNonNull(checkIn, "La fecha de check-in no puede ser nula");
        Objects.requireNonNull(checkOut, "La fecha de check-out no puede ser nula");
        Objects.requireNonNull(precio, "El precio no puede ser nulo");

        if (checkOut.isBefore(checkIn)) {
            throw new IllegalArgumentException("Check-out no puede ser antes del check-in");
        }

        this.cliente = cliente;
        this.habitacion = habitacion;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.precio = precio;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void asignar() {
        cliente.agregarReserva(this);
        habitacion.agregarReserva(this);
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "cliente=" + cliente.getNombre() + " " + cliente.getApellido() +
                ", habitacion=" + habitacion.getNumero() +
                ", checkIn=" + checkIn +
                ", checkOut=" + checkOut +
                ", precio=" + precio +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reserva reserva = (Reserva) o;
        return Objects.equals(cliente, reserva.cliente) &&
                Objects.equals(habitacion, reserva.habitacion) &&
                Objects.equals(checkIn, reserva.checkIn) &&
                Objects.equals(checkOut, reserva.checkOut);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cliente, habitacion, checkIn, checkOut);
    }
}
