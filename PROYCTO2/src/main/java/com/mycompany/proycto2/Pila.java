/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proycto2;



/**
 *
 * @author aleja
 */
public class Pila {
    public Nodo cima; 

    public Pila() {
        this.cima = null; 
    }

    public boolean estaVacia() {
        return cima == null;
    }

    public void apilar(Cliente cliente) {
        Nodo nuevoNodo = new Nodo(cliente); 
        nuevoNodo.siguiente = cima;  
        cima = nuevoNodo; 
    }

    public Cliente desapilar() {
        if (estaVacia()) {
            System.out.println("La pila esta vacía");
            return null;
        }
        
        Cliente clienteAtendido = cima.cliente;  
        cima = cima.siguiente;  
        return clienteAtendido;  
    }
    
}
