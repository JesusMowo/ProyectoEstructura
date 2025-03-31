/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proycto2;

/**
 *
 * @author aleja
 */
public class ListaSimple {
      public NodoSolicitud cabeza;  

    // Constructor
    public ListaSimple() {
        this.cabeza = null; 
    }

    public boolean estaVacia() {
        return cabeza == null;
    }

    public void agregar(String solicitud) {
        NodoSolicitud nuevoNodo = new NodoSolicitud(solicitud);

        if (estaVacia()) {
            cabeza = nuevoNodo; 
        } else {
            NodoSolicitud actual = cabeza;
            while (actual.siguiente != null) {  
                actual = actual.siguiente;
            }
            actual.siguiente = nuevoNodo;  
        }
    }
    @Override
    public String toString() {
        StringBuilder resultado = new StringBuilder();
        NodoSolicitud actual = cabeza;

        while (actual != null) {
            resultado.append(actual.solicitud);
            if (actual.siguiente != null) {
                resultado.append(", ");
            }
            actual = actual.siguiente;
        }
        return resultado.toString();
    }
}
