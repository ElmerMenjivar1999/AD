package com.mycompany.reservas_hotel;


import java.sql.Date;

/**
 *
 * @author pr0cell
 */
public class Main {
   
    
    public static void main(String[] args) {
        ReservaDAO dao = new ReservaDAO();
        int op;
        do{
            Utilidades.mostrarMenu();
            op = Utilidades.leerEntero("\nSeleccione una opción: ");
            ejecutarOpcion(op, dao);
            
        }while(op != 0);
        
    }
    
    private static void ejecutarOpcion(int op, ReservaDAO dao) {
        switch (op) {
            case 1 ->  {
                String nombre = Utilidades.leerTexto("Nombre del alumno: ");
                String aula = Utilidades.leerTexto("Nombre del aula: ");
                Date fecha = Utilidades.leerFecha("Fecha de la reserva (dd/MM/yyyy): ");
                dao.registrarReserva(nombre, aula, fecha);
            }
            case 2 -> dao.mostrarTodasReservas();
            case 3 ->  {
                String aula = Utilidades.leerTexto("Nombre del aula: ");
                dao.buscarReservaPorAula(aula);
            }
            case 4 ->  {
                int id = Utilidades.leerEntero("Id de la reserva a eliminar: ");
                dao.eliminarReserva(id);
            }
            case 0 -> System.out.println("Hasta pronto!");
            default -> System.out.println("Opción inválida");
        }
    }
  
}
