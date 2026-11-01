/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tema3xml;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

/**
 *
 * @author pr0cell
 */
public class Main {
    public static void main(String[] args) {
        try {
            TiendaXML tienda = new TiendaXML();
            Document document = tienda.cargarXML();
            NodeList nombres = tienda.obtenerNombres(document);
            //Para sacar cada uno de los items de un NodeList se usa .item(n).getTextContent()
            //PAra sacar longitud .getLength()
            
            for (int i = 0; i < nombres.getLength() ; i ++){
                System.out.println(nombres.item(i).getTextContent());
            }
            //System.out.println(nombres.item(1).getTextContent());
        } catch (Exception e) {
        }
    }
    
}
