package personas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
// Clase Cliente
public class Cliente extends Persona {
    private Pasaporte pasaporte;
    private final List<Reserva> reservas = new ArrayList<>();
    private ObraSocial obraSocial;

    public Cliente(String nombre, String apellido, ObraSocial obraSocial) {
        super(nombre, apellido);
        this.obraSocial = Objects.requireNonNull(obraSocial, "La obra social no puede ser nula");
    }

    public void setPasaporte(Pasaporte pasaporte) {
        this.pasaporte = pasaporte;
    }

    public Pasaporte getPasaporte() {
        return pasaporte;
    }

    public void agregarReserva(Reserva reserva) {
        if (reserva != null && !reservas.contains(reserva)) {
            reservas.add(reserva);
        }
    }

    public List<Reserva> getReservas() {
        return Collections.unmodifiableList(reservas);
    }

    public ObraSocial getObraSocial() {
        return obraSocial;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", pasaporte=" + pasaporte +
                ", obraSocial=" + obraSocial +
                '}';
    }
}