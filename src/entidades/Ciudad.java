package entidades;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

// Clase Ciudad
public class Ciudad {
    private final String nombre;
    private final List<Hotel> hoteles = new ArrayList<>();

    public Ciudad(String nombre) {
        Objects.requireNonNull(nombre, "El nombre de la ciudad no puede ser nulo");
        if (nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre de la ciudad no puede estar vacío");
        }
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarHotel(Hotel hotel) {
        if (hotel != null && !hoteles.contains(hotel)) {
            hoteles.add(hotel);
            hotel.setCiudad(this);
        }
    }

    public List<Hotel> getHoteles() {
        return Collections.unmodifiableList(hoteles); // Retorna una vista no modificable
    }

    // Método para obtener la lista interna (para uso interno de la clase)
    List<Hotel> getInternalHoteles() {
        return hoteles;
    }

    @Override
    public String toString() {
        return "Ciudad{" +
                "nombre='" + nombre + '\'' +
                '}';
    }
}