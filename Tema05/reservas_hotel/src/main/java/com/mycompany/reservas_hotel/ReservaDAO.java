package com.mycompany.reservas_hotel;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author pr0cell
 */
public class ReservaDAO {
    private static final String URL = "jdbc:postgresql://localhost:5432/reservas";
    private static final String USUARIO = "alumno";
    private static final String PASSWORD = "alumno123";
    
    
    private static Connection conectar() throws SQLException{
        return DriverManager.getConnection(URL,USUARIO,PASSWORD);
    }
    
    public  void registrarReserva(String nombre, String aula, Date fecha){
        String sql = "insert into reserva (alumno,aula,fecha) VALUES (?,?,?)";
        try (Connection con = conectar();
                PreparedStatement ps = con.prepareStatement(sql)){
            
            ps.setString(1, nombre);
            ps.setString(2, aula);
            ps.setDate(3, fecha);
            int create = ps.executeUpdate();
            if(create > 0){
                System.out.println("Reserva registrada con exito!");
            }
            Utilidades.leerTexto("Presione cualquier tecla para continuar....");
        } catch (SQLException e) {
            System.err.println("Error en la base de datos: " + e.getMessage());
        }
    }
    
    public  void mostrarTodasReservas(){
        String sql = "select * from reserva";
        try (Connection con = conectar();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()){
            boolean hayResultados = false;
            System.out.println("ID\tAlumno\tAula\tFecha");
            while (rs.next()) {
                hayResultados = true;
                long id = rs.getLong("id");
                String alumno = rs.getString("alumno");
                String aula = rs.getString("aula");
                Date fecha = rs.getDate("fecha");
                System.out.println(id + "\t" + alumno + "\t" + aula + "\t" + fecha);
                
            }
            if(!hayResultados){
                System.out.println("No se han encontrado reservas.");
            }
            Utilidades.leerTexto("Presione cualquier tecla para continuar....");
        } catch (SQLException e) {
            System.err.println("Error en la base de datos: " + e.getMessage());
        }
    }
    
    public  void buscarReservaPorAula(String aula){
        String sql = "select * from reserva where aula = ?";
        try (Connection con = conectar();
                PreparedStatement ps = con.prepareStatement(sql)){
            
            ps.setString(1, aula);
            boolean hayResultados = false;
            try(ResultSet rs = ps.executeQuery()){
                while(rs.next()){
                    hayResultados = true;
                    long id = rs.getLong("id");
                    String alumno = rs.getString("alumno");
                    String aulaDB = rs.getString("aula");
                    Date fecha = rs.getDate("fecha");
                    System.out.println(id + " " + alumno + " " + aulaDB + " " + fecha);
                }
                if(!hayResultados){
                    System.out.println("No se han encontrado reservas con ese nombre de aula.");
                }
                Utilidades.leerTexto("Presione cualquier tecla para continuar....");
            }
            
        }catch(SQLException e){
            System.err.println("Error en la base de datos: " + e.getMessage());

        }  
       
    }
    
    public  void eliminarReserva(long id){
        String sql = "DELETE from reserva where id = ?";
        try (Connection con = conectar();
                PreparedStatement ps = con.prepareStatement(sql)){
            
            
            ps.setLong(1, id);
            int eliminarReserva = ps.executeUpdate();
            if(eliminarReserva > 0){
                System.out.println("Reserva eliminada con exito!");
            }else{
                System.out.println("No existe ninguna reserva con ese id.");
            }
            Utilidades.leerTexto("Presione cualquier tecla para continuar....");
            
        }catch(SQLException e){
            System.err.println("Error en la base de datos: " + e.getMessage());
        }  
        
    }
    
}
