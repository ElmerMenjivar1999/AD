/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.tema3xml;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.NodeList;

/**
 *
 * @author pr0cell
 */
public class TiendaXML {

    public Document cargarXML() throws Exception{
        File archivo = new File("alumnos.xml");
        
        //Creamos la factoria del lector de DOM
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();    
        
        //Creamos el objeto que va a leer el DOM
        DocumentBuilder builder = factory.newDocumentBuilder();
        
        //Java lee el XML y crea el arbol de DOM
        Document document = builder.parse(archivo);
        
        return document;
    }
    
    public NodeList obtenerNombres(Document document) throws Exception{
        //Creamos la factoria para usar xpath
        XPath xpath = XPathFactory.newInstance().newXPath();
        
        //String expresion = "/tienda/producto/nombre";
        String expresion2 = "/alumnos/alumno[1]/nombre";
        //XPathConstants.NODESET => Espera que el resultado sea un conjunto de nodos
        NodeList nombres = (NodeList) xpath.evaluate(expresion2, document,XPathConstants.NODESET);
        /* 
          nombres
          |---- [1] <nombre>Teclado</nombre>
          |---- [2] <nombre>Ratón</nombre>
          |---- [3] <nombre>Monitor</nombre>
        */
        
        return nombres;
    }
}
