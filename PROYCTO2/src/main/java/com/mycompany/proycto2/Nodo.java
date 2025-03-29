/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proycto2;

/**
 *
 * @author aleja
 */
public class Nodo {
    public Cliente cliente;  
    Nodo siguiente;   

    // Constructor para el nodo
    public Nodo(Cliente cliente) {
        this.cliente = cliente;
        this.siguiente = null; 
    }
}
