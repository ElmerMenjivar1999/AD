/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.tema4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author pr0cell
 */
public class Tema4 {
    private static final String url = "jdbc:mysql://localhost:3306/AD";
    private static final String usuario = "elmer";
    private static final String password = "elmer123";

    
    public static Connection conectar() throws SQLException{
        return DriverManager.getConnection(url,usuario,password);
    }
    
    //1. Mostrar todos los empleados
    public static void listarEmpleados(){
        String sql = "select * from empleados";
        
        try {
            Connection conexion = conectar();
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            System.out.println(
                    "Id" + " | " + 
                    "Nombre" + " | " + 
                    "Departamento" + " | " + 
                    "Salario" + " | " + 
                    "Edad"
            );
            
            while(rs.next()){
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String departamento = rs.getString("departamento");
                double salario = rs.getDouble("salario");
                int edad = rs.getInt("edad");
                
                System.out.println(
                        id + "  | " 
                        + nombre + " |\t " 
                        + departamento + " | " 
                        + salario + " | " 
                        + edad);
            }
            
        } catch (SQLException e) {
            System.out.println("ERROR DE CONEXIÓN");
            System.out.println(e.getMessage());
        }
        
    }
    
    //2. Buscar por identificador
    public static void buscarPorId(int id){
        String sql = "select * from empleados where id = ?";
        
        try {
            Connection conexion = conectar();
            PreparedStatement ps = conexion.prepareStatement(sql);
            //Seting de parametros
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            System.out.println(
                    "Id" + " | " + 
                    "Nombre" + " | " + 
                    "Departamento" + " | " + 
                    "Salario" + " | " + 
                    "Edad"
            );
            
            while(rs.next()){
                String nombre = rs.getString("nombre");
                String departamento = rs.getString("departamento");
                double salario = rs.getDouble("salario");
                int edad = rs.getInt("edad");
                
                System.out.println(
                        id + "  | " 
                        + nombre + " |\t " 
                        + departamento + " | " 
                        + salario + " | " 
                        + edad);
            }
            
        } catch (SQLException e) {
            System.out.println("ERROR DE CONEXIÓN");
            System.out.println(e.getMessage());
        }
    }
    
    public static void actualizarSalario(int id, double salario){
        String sql = "update empleados set salario = ? where id = ?";
        
        try {
            Connection conexion = conectar();
            PreparedStatement ps = conexion.prepareStatement(sql);
            //Seting de parametros
            ps.setDouble(1, salario);
            ps.setInt(2, id);
            int rs = ps.executeUpdate();
            System.out.println("Salario Actualizado del empleado con el ID: " + id);
            
        } catch (SQLException e) {
            System.out.println("ERROR DE CONEXIÓN");
            System.out.println(e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        System.out.println("Listar todos los empleados");
        listarEmpleados();
        System.out.println("Listar empleado cuyo Identificador es 2");
        buscarPorId(2);
        actualizarSalario(1, 46.000);
    }
    
}
