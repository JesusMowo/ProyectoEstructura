/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proycto2;

/**
 *
 * @author aleja
 */
public class Cola {
    public Nodo frente;
    public Nodo finalCola;  

    public Cola() {
        this.frente = null;
        this.finalCola = null;
    }

    public boolean estaVacia() {
        return frente == null;
    }

    public void encolar(Cliente cliente) {
        Nodo nuevoNodo = new Nodo(cliente);
        
        if (estaVacia()) {
            frente = nuevoNodo;  
        } else {
            finalCola.siguiente = nuevoNodo;  
        }
        
        finalCola = nuevoNodo; 
    }

    public Cliente desencolar() {
        if (estaVacia()) {
            System.out.println("La cola esta vacía");
            return null;
        }
        
        Cliente clienteAtendido = frente.cliente;
        frente = frente.siguiente; 
        
        if (frente == null) {
            finalCola = null; 
        }

        return clienteAtendido;
    }
}
