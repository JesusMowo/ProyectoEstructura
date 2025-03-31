/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proycto2;

/**
 *
 * @author aleja
 */
public class NodoSolicitud {
    public String solicitud;
    public NodoSolicitud siguiente;  

    // Constructor
    public NodoSolicitud(String solicitud) {
        this.solicitud = solicitud;
        this.siguiente = null;
    }
}
