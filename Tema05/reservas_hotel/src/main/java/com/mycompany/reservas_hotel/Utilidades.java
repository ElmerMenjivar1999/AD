package com.mycompany.reservas_hotel;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

/**
 *
 * @author pr0cell
 */
public class Utilidades {
    private static final Scanner input = new Scanner(System.in);
    private static final DateTimeFormatter FMT = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static void mostrarMenu() {
        System.out.println("=================================");
        System.out.println("        GESTOR DE RESERVAS");
        System.out.println("=================================");
        System.out.println("1. Registrar una reserva");
        System.out.println("2. Mostrar todas las reservas");
        System.out.println("3. Buscar reservas por aula");
        System.out.println("4. Eliminar una reserva");
        System.out.println("0. Salir");
    }

    public static int leerEntero(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                return Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Introduce un número válido.");
            }
        }
    }

    public static String leerTexto(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String texto = input.nextLine();
            if (!texto.isBlank()) {
                return texto;
            }
            System.out.println("No puede estar vacío.");
        }
    }

    public static Date leerFecha(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                return Date.valueOf(LocalDate.parse(input.nextLine(), FMT));
            } catch (DateTimeParseException e) {
                System.out.println("Formato de fecha no válido, usa dd/MM/yyyy.");
            }
        }
    }
}
