package entidades;

import java.util.Objects;
public class Pasaporte {
    private final String numero;

    public Pasaporte(String numero) {
        Objects.requireNonNull(numero, "El número de pasaporte no puede ser nulo");
        if (!numero.matches("[A-Z]{2}-\\d{6}")) { // Ejemplo de formato, ajusta según necesidad
            throw new IllegalArgumentException("Formato de pasaporte inválido. Debe ser como XX-123456");
        }
        this.numero = numero;
    }

    public String getNumero() {
        return numero;
    }

    @Override
    public String toString() {
        return "Pasaporte{" +
                "numero='" + numero + '\'' +
                '}';
    }
}