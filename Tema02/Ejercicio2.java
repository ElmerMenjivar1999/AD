/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author pr0cell
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class Ejercicio2 {


    public static void main(String[] args) {
        
        try {
            
            PipedOutputStream salida = new PipedOutputStream();
            PipedInputStream entrada = new PipedInputStream(salida);
            
            File originFile = new File("/home/pr0cell/Documentos/test.txt");
            File myNewFile = new File("/home/pr0cell/Documentos/copy_test.txt");
            final int[] totalLineas = {0}, totalChars = {0};
            Thread contentFile = new Thread(() -> {
                try {
                    
                    FileInputStream f = new FileInputStream(originFile);
                    int linea;
                    while((linea = f.read()) != -1){
                        if((char) linea == '\n'){
                            totalLineas[0]++;
                        }
                        totalChars[0]++;
                        salida.write(linea);
                    }
                    f.close();
                    salida.close();
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            });
            
            
            Thread copyContentFile = new Thread(()->{
                FileOutputStream fo = null;
                try {
                    
                    if(!myNewFile.exists()){
                        try {
                            myNewFile.createNewFile();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                    fo = new FileOutputStream("/home/pr0cell/Documentos/copy_test.txt");
                    
                    int dato;
                    try {
                        while((dato = entrada.read()) != -1){
                            fo.write(dato);
                            System.out.print((char) dato);
                        }
                        fo.close();
                        entrada.close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                } finally {
                    try {
                        fo.close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            });
            
            contentFile.start();
            copyContentFile.start();
            contentFile.join();
            copyContentFile.join();
            
            System.out.println("--- PROCESO TERMINADO ---");
            System.out.println("Fichero origen: " + originFile.getName());
            System.out.println("Fichero destino: " + myNewFile.getName());
            System.out.println("Tamaño origen: " + originFile.length());
            System.out.println("Tamaño destino: " + myNewFile.length());
            System.out.println("Lineas procesadas: " + totalLineas[0]);
            System.out.println("Caracteres procesados: " + totalChars[0]);
            
        } catch (Exception e) {
        }
        
    }
    
}
