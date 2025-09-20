import personas.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;

public class Main {


            public static void main(String[] args) {
                // Crear ciudades
                Ciudad mendoza = new Ciudad("Mendoza");
                Ciudad sanJuan = new Ciudad("San Juan");

                // Crear hoteles
                Hotel hotelSolAndino = new Hotel("Sol Andino");
                Hotel hotelCordillera = new Hotel("Cordillera Suites");
                Hotel hotelOeste = new Hotel("Oeste");

                // Asignar hoteles a ciudades
                mendoza.agregarHotel(hotelSolAndino);
                mendoza.agregarHotel(hotelCordillera);
                sanJuan.agregarHotel(hotelOeste);

                // Crear habitaciones
                Habitacion hab101 = hotelSolAndino.crearHabitacion(101, "Doble");
                Habitacion hab102 = hotelSolAndino.crearHabitacion(102, "Suite");
                Habitacion hab201 = hotelCordillera.crearHabitacion(201, "Doble");
                Habitacion hab301 = hotelOeste.crearHabitacion(301, "Suite");

                // Crear cliente y asignar pasaporte y obra social
                Cliente cliente1 = new Cliente("Ana", "Gomez", ObraSocial.OSDE);
                cliente1.setPasaporte(new Pasaporte("AR-123456"));

                // Crear reservas
                Reserva reserva1 = new Reserva(cliente1, hab101, LocalDate.of(2025, 9, 10), LocalDate.of(2025, 9, 15), new BigDecimal("250000.00"));
                reserva1.asignar();
                Reserva reserva2 = new Reserva(cliente1, hab102, LocalDate.of(2025, 12, 1), LocalDate.of(2025, 12, 3), new BigDecimal("180000.00"));
                reserva2.asignar();

                // Crear empleado y asignar legajo
                Empleado empleadoJuan = new Empleado("Juan", "Perez", Cargos.Gerente);
                Legajo legajoJuan = new Legajo("LEG-001");
                empleadoJuan.setLegajo(legajoJuan);
                hotelSolAndino.agregarEmpleado(empleadoJuan);

                // Imprimir datos
                System.out.println("----- Datos de las Ciudades -----");
                System.out.println(mendoza);
                System.out.println(sanJuan);

                System.out.println("\n----- Hoteles en Mendoza -----");
                for (Hotel h : mendoza.getHoteles()) {
                    System.out.println(h);
                    for (Habitacion hab : h.getHabitaciones()) {
                        System.out.println("  " + hab);
                    }
                }

                System.out.println("\n----- Cliente y Reservas -----");
                System.out.println(cliente1);
                for (Reserva r : cliente1.getReservas()) {
                    System.out.println(r);
                }

                System.out.println("\n----- Empleado y Legajo -----");
                System.out.println(empleadoJuan);
                System.out.println(legajoJuan);

                System.out.println("\n----- Reservas en Habitaciones -----");
                for (Habitacion hab : Arrays.asList(hab101, hab102, hab201, hab301)) {
                    System.out.println(hab);
                    for (Reserva r : hab.getReservas()) {
                        System.out.println("  " + r);
                    }
                }
            }
        }

