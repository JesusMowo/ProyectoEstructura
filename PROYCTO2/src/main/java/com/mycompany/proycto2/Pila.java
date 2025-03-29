/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proycto2;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


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
    
    public void guardarClientesAtendidos() {
        // Obtener la fecha actual para el nombre del archivo
        LocalDate fechaActual = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String fechaFormateada = fechaActual.format(formatter);

        // Crear el nombre del archivo con la fecha
        String nombreArchivo = "taquilla" + fechaFormateada + ".log";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo, true))) {
            while (!estaVacia()) {
                Cliente clienteAtendido = desapilar();  // Obtener y eliminar el cliente de la cima
                // Escribir la información del cliente en el archivo
                writer.write(clienteAtendido.toString());
                writer.newLine();  // Salto de línea después de cada cliente
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
