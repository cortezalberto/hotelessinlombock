package personas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
public class Habitacion {
    private final int numero;
    private final String tipo;
    private final Hotel hotel;
    private final List<Reserva> reservas = new ArrayList<>();

    Habitacion(int numero, String tipo, Hotel hotel) {
        this.numero = numero;
        Objects.requireNonNull(tipo, "El tipo de habitación no puede ser nulo");
        Objects.requireNonNull(hotel, "El hotel no puede ser nulo");
        this.tipo = tipo;
        this.hotel = hotel;
    }

    public int getNumero() {
        return numero;
    }

    public String getTipo() {
        return tipo;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public List<Reserva> getReservas() {
        return Collections.unmodifiableList(reservas);
    }

    public void agregarReserva(Reserva reserva) {
        if (reserva != null && !reservas.contains(reserva)) {
            reservas.add(reserva);
        }
    }

    @Override
    public String toString() {
        return "Habitacion{" +
                "numero=" + numero +
                ", tipo='" + tipo + '\'' +
                ", hotel=" + hotel.getNombre() +
                '}';
    }
}

