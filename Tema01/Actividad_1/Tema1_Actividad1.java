

package com.mycompany.tema1;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.io.IOException;

/**
 *
 * @author Jesús Guillén Encinas
 */
public class Tema1_Actividad1 {
   static final String myPath = "/home/pr0cell/Documentos/ad_java/";
    
   public static void main(String[] args) throws IOException {

        /*
         * ============================================================
         * TEMA 1 - INTRODUCCIÓN AL MANEJO DE FICHEROS
         * ACCESO A DATOS - EJERCICIOS
         * ============================================================
         *
         * INSTRUCCIONES:
         * - Completa cada apartado donde aparece TODO.
         * - No borres los enunciados.
         * - Puedes crear variables y código auxiliar dentro de cada apartado.
         *
         * CONTENIDOS:
         * 1. Clase File
         * 2. Información de un fichero
         * 3. Crear directorios y mover ficheros
         * 4. FileWriter
         * 5. FileReader
         * 6. Acceso secuencial o aleatorio
         * 7. FileInputStream / FileOutputStream
         * 8. RandomAccessFile
         * 9. Ejercicio Final
         */

        // ============================================================
        // EJERCICIO 1 - CREAR UN FICHERO
        // ============================================================

        /*
         * Crea un programa que:
         *
         * 1. Cree un objeto File asociado al fichero "datos.txt".
         * 2. Compruebe si el fichero existe.
         * 3. Si no existe, créalo.
         * 4. Muestra por pantalla el nombre del fichero.
         */

        // TODO: EJERCICIO 1
        // Escribe aquí tu solución.
        File f = new File(myPath + "datos.txt");
        if(!f.exists()){
            f.createNewFile();
        }
        System.out.println("El nombre del archivo es: " + f.getName());
        // ============================================================
        // EJERCICIO 2 - INFORMACIÓN DEL FICHERO
        // ============================================================

        /*
         * Utilizando un objeto File asociado a "datos.txt",
         * muestra por pantalla:
         *
         * - Nombre del fichero.
         * - Ruta.
         * - Ruta absoluta.
         * - Directorio padre.
         * - Si existe.
         * - Si se puede leer.
         * - Si se puede escribir.
         */

        // TODO: EJERCICIO 2
        // Escribe aquí tu solución.

        System.out.println("Nombre del fichero: " + f.getName());
        System.out.println("Ruta del fichero: " + f.getPath());
        System.out.println("Ruta absoluta del fichero: " + f.getAbsolutePath());
        System.out.println("Directorio padre del fichero: " + f.getParent());
        System.out.println("Existe el fichero? " + f.exists());
        System.out.println("Se puede leer el fichero? " + f.canRead());
        System.out.println("Se puede escribir el fichero? " + f.canWrite());
        
        // ============================================================
        // EJERCICIO 3 - CREAR DIRECTORIO Y MOVER UN FICHERO
        // ============================================================

        /*
         * Tenemos un fichero llamado "datos.txt".
         *
         * El programa debe:
         *
         * 1. Crear un directorio llamado "backup".
         * 2. Comprobar que el directorio existe.
         * 3. Mover "datos.txt" dentro de "backup".
         *
         * Resultado final:
         *
         * backup/
         *     datos.txt
         */

        // TODO: EJERCICIO 3
        // Escribe aquí tu solución.
        File myDir = new File(myPath + "backup");
        myDir.mkdirs();
        if (myDir.exists()){
            f.renameTo(myDir);
        }
        
        // ============================================================
        // EJERCICIO 4 - ESCRIBIR TEXTO CON FileWriter
        // ============================================================

        /*
         * Crea un fichero llamado "alumnos.txt" y escribe dentro:
         *
         * Juan
         * María
         * Pedro
         * Ana
         *
         * Debes utilizar FileWriter.
         *
         * Recuerda:
         * - Instanciar FileWriter.
         * - Utilizar write().
         * - Cerrar el flujo.
         */

        // TODO: EJERCICIO 4
        // Escribe aquí tu solución.
        File alumnos = new File(myPath + "alumnos.txt");
        if(!alumnos.exists()){
            alumnos.createNewFile();
        }
        FileWriter escritor = new FileWriter(myPath + "alumnos.txt");
        escritor.write("Juan\nMaría\nPedro\nAna");
        escritor.close();
        
        // ============================================================
        // EJERCICIO 5 - LEER UN CARÁCTER CON FileReader
        // ============================================================

        /*
         * Crea previamente un fichero llamado "mensaje.txt" que contenga:
         *
         * Hola
         *
         * Utiliza FileReader para:
         *
         * 1. Abrir el fichero.
         * 2. Leer el primer carácter mediante read().
         * 3. Mostrarlo por pantalla.
         * 4. Cerrar el lector.
         *
         * Resultado esperado:
         * H
         */

        // TODO: EJERCICIO 5
        // Escribe aquí tu solución.
        File mensaje = new File(myPath + "mensaje.txt");
        if(!mensaje.exists()){
            alumnos.createNewFile();
        }
        FileWriter escritorEj5 = new FileWriter(myPath + "mensaje.txt");
        escritorEj5.write("Hola");
        escritorEj5.close();
        
        FileReader lectura = new FileReader(myPath + "mensaje.txt");
        int dato = lectura.read();
        System.out.println("Primer carácter del archivo mensaje.txt: " + (char) dato);
        lectura.close();

        // ============================================================
        // EJERCICIO 6 - ¿ACCESO SECUENCIAL O ALEATORIO?
        // ============================================================

        /*
         * Para cada situación indica si utilizarías:
         *
         *     ACCESO SECUENCIAL
         *     o
         *     ACCESO ALEATORIO / DIRECTO
         *
         * y explica brevemente por qué.
         *
         * A) Tenemos un fichero con 500 nombres y queremos mostrar
         *    todos los nombres desde el primero hasta el último.
         *
         * B) Tenemos un fichero enorme y queremos acceder directamente
         *    a una posición concreta.
         *
         * C) Queremos recorrer un fichero de texto completo y copiar
         *    su contenido a otro fichero.
         *
         * D) Queremos modificar información situada en una posición
         *    concreta del fichero.
         *
         * E) Queremos leer un fichero de texto completo.
         *
         * Recuerda:
         *
         * - Secuencial: recorremos la información en orden.
         * - Aleatorio/directo: podemos posicionarnos directamente
         *   en una posición concreta.
         */

        // TODO: EJERCICIO 6
        // Escribe tus respuestas aquí mediante comentarios.
        //
        // A)Secuencial, por que es todo el archivo, no elegimos un  punto en concreto.
        // B)Aleatorio/Directo, estamos eligiendo en que posición concreta queremos acceder.
        // C)Secuencial, ya que copiaremos todo, no solo una parte en concreto.
        // D)Aleatorio/Directo, ya que modificaremos una posición en concreto del archivo.
        // E)Secuencial, recorreremos toda la información del archivo, no solo una parte.


        // ============================================================
        // EJERCICIO 7 - LECTURA DE BYTES
        // ============================================================

        /*
         * Crea un fichero llamado "bytes.txt" que contenga algún texto.
         *
         * Utiliza FileInputStream para:
         *
         * 1. Abrir el fichero.
         * 2. Leer un byte utilizando read().
         * 3. Mostrar por pantalla el valor obtenido.
         * 4. Cerrar el flujo.
         *
         */

        // TODO: EJERCICIO 7
        // Escribe aquí tu solución.
        File myBytes = new File(myPath + "bytes.txt");
        if(!myBytes.exists()){
            myBytes.createNewFile();
        }
        FileWriter escritorEj7 = new FileWriter(myPath + "bytes.txt");
        escritorEj7.write("Prueba");
        escritorEj7.close();
        FileInputStream fs = new FileInputStream(myPath + "bytes.txt");
        int datoEj7 = fs.read();
        System.out.println("El byte de bytes.txt es: " + datoEj7);
        fs.close();
        
        // ============================================================
        // EJERCICIO 8 - ESCRITURA DE BYTES
        // ============================================================

        /*
         * Utiliza FileOutputStream para crear/escribir el fichero:
         *
         * "salidaBytes.txt"
         *
         * Escribe mediante write() el valor 68.
         *
         * Recuerda que 68 es la letra 'D' en ASCII.
         *
         * Después cierra el flujo.
         */

        // TODO: EJERCICIO 8
        // Escribe aquí tu solución.
        FileOutputStream salidaBytes = new FileOutputStream(myPath + "salidaBytes.txt");
        salidaBytes.write(68);
        salidaBytes.close();
        
        
        // ============================================================
        // EJERCICIO 9 - RandomAccessFile
        // ============================================================

        /*
         * Crea un fichero llamado "letras.txt" que contenga:
         *
         * ABCDEFGHIJ
         *
         * Utiliza RandomAccessFile para:
         *
         * 1. Abrir el fichero en modo "rw".
         * 2. Situarte en la posición 5 mediante seek().
         * 3. Leer el carácter que hay en esa posición.
         * 4. Mostrarlo por pantalla.
         * 5. Mostrar también la posición actual del puntero.
         *
         * Resultado esperado:
         *
         * F 6
         *
         */

        // TODO: EJERCICIO 9
        // Escribe aquí tu solución.
        RandomAccessFile rf = new RandomAccessFile(myPath + "letras.txt", "rw");
        rf.writeBytes("ABCDEFGHIJ");
        rf.seek(6);
        int datoEj9 = rf.read();
        System.out.println("El carácter en la posición 6 es: " + (char) datoEj9);
        System.out.println("Posición actual del puntero: " + rf.getFilePointer());
        rf.close();
        
        
        // ============================================================
        // EJERCICIO 10 - ESCRIBIR CON RandomAccessFile
        // ============================================================

        /*
         * Utiliza el fichero "letras.txt" del ejercicio anterior.
         *
         * 1. Abre el fichero con RandomAccessFile en modo "rw".
         * 2. Coloca el puntero en la posición 5.
         * 3. Escribe el byte correspondiente a la letra 'D'
         *    utilizando write().
         * 4. Cierra el fichero.
         *
         * Comprueba después cómo ha quedado el contenido del fichero.
         *
         */

        // TODO: EJERCICIO 10
        // Escribe aquí tu solución.
        RandomAccessFile rfEj10 = new RandomAccessFile(myPath + "letras.txt", "rw");
        rfEj10.seek(5);
        rfEj10.write(68);
        rfEj10.close();
        
        
        // ============================================================
        // EJERCICIO 11 - LEER VARIOS BYTES
        // ============================================================

        /*
         * Utiliza RandomAccessFile con un fichero que contenga texto.
         *
         * Crea un array de bytes de tamaño 10.
         *
         * Utiliza read(byte[], inicio, cantidad) para leer varios
         * bytes del fichero y almacenarlos en el array.
         *
         * Finalmente muestra cuántos bytes se han leído.
         *
         */

        // TODO: EJERCICIO 11
        // Escribe aquí tu solución.
        RandomAccessFile rfEj11 = new RandomAccessFile(myPath + "ejercicio11.txt", "rw");
        rfEj11.writeBytes("Texto de prueba");
        rfEj11.seek(0);
        byte[] myArray = new byte[10];
        int bytesLeidos = rfEj11.read(myArray, 1, 5);
        System.out.println("Bytes leídos: " + bytesLeidos);
        rfEj11.close();
            
        
        // ============================================================
        // EJERCICIO 12 - Ejercicio FINAL: GESTOR DE FICHEROS
        // ============================================================

        /*
         * Crea un pequeño gestor de ficheros.
         *
         * El programa debe gestionar un fichero llamado:
         *
         * alumnos.txt
         *
         * Debe realizar las siguientes operaciones:
         *
         * 1. Crear el fichero si no existe.
         *
         * 2. Mostrar:
         *    - Nombre.
         *    - Ruta.
         *    - Ruta absoluta.
         *    - Si existe.
         *    - Si se puede leer.
         *    - Si se puede escribir.
         *
         * 3. Escribir en el fichero:
         *
         *    Juan
         *    Ana
         *    Pedro
         *    Laura
         *
         *    Utiliza FileWriter.
         *
         * 4. Utilizar FileReader para leer el primer carácter
         *    y mostrarlo por pantalla.
         *
         * 5. Crear un directorio llamado "backup".
         *
         * 6. Mover el fichero a:
         *
         *    backup/alumnos.txt
         *
         * 7. Mostrar la fecha de última modificación utilizando
         *    lastModified().
         *
         * IMPORTANTE:
         * Recuerda cerrar los flujos de lectura y escritura
         * utilizando close().
         *
         */

        // TODO: Ejercicio FINAL
        // Escribe aquí tu solución completa.

        File myFinalFile = new File(myPath + "alumnos.txt");
        if(!myFinalFile.exists()){
            myFinalFile.createNewFile();
        }
        
        System.out.println("Nombre del archivo final: " + myFinalFile.getName());
        System.out.println("Ruta del archivo final: " + myFinalFile.getPath());
        System.out.println("Ruta absoluta del archivo final: " + myFinalFile.getAbsolutePath());
        System.out.println("Existe el archivo final alumnos.txt? " + myFinalFile.exists());
        System.out.println("Se puede leer el archivo final alumnos.txt? " + myFinalFile.canRead());
        System.out.println("Se puede escribir el archivo final alumnos.txt? " + myFinalFile.canWrite());
        
        FileWriter myFinalWriter = new FileWriter(myPath + "alumnos.txt");
        myFinalWriter.write("Juan\nAna\nPedro\nLaura");
        myFinalWriter.close();
        
        FileReader myFinalReader = new FileReader(myPath + "alumnos.txt");
        int finalData = myFinalReader.read();
        System.out.println("El primer carácter es: " + (char) finalData);
        myFinalReader.close();
        
        
    }
}
