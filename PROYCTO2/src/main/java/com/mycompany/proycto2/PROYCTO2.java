/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proycto2;
import java.io.*;
/**
 *
 * @author aleja
 */
public class PROYCTO2 {

    public static void main(String[] args) {
        Cola cola = new Cola();  
        Pila pila = new Pila();  

        cargarClientesEnCola("archivos/clientes.in", cola);

        // Tiempo total disponible en minutos (de 8:00 am a 3:30 pm 450 minutos)
        int tiempoDisponible = 450;  

        while (tiempoDisponible > 0 && !cola.estaVacia()) {
            Cliente cliente = cola.desencolar(); 

            // comprobacion si hay suficiente tiempo para atender a este cliente
            if (cliente.tiempoTotalSolicitudes <= tiempoDisponible) {
                // Atendemos al cliente
                System.out.println("Atendiendo a: " + cliente.nombre);
                System.out.println("Solicitudes: " + cliente.solicitudes);
                System.out.println("Tiempo total de atencion: " + cliente.tiempoTotalSolicitudes + " minutos");

                // reduciendo el tiempo disponible segun el tiempo que se tardo en atender al cliente
                tiempoDisponible -= cliente.tiempoTotalSolicitudes;

                // guardando al cliente en la pila
                pila.apilar(cliente);
                System.out.println("Tiempo restante: " + tiempoDisponible + " minutos");
            } else {
                System.out.println("No hay suficiente tiempo para atender a: " + cliente.nombre);
                break;  
            }
        }

        pila.guardarClientesAtendidos();

        if (tiempoDisponible == 0) {
            System.out.println("Se ha alcanzado el tiempo limite de atencion (3:30 PM).");
        } else {
            System.out.println("La jornada de atencion ha finalizado.");
        }
    }

    private static void cargarClientesEnCola(String archivo, Cola cola) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");  
                String nombre = partes[0].trim();
                Cliente cliente = new Cliente(nombre);

                for (int i = 1; i < partes.length; i++) {
                    cliente.agregarSolicitud(partes[i].trim());
                }

                cola.encolar(cliente);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
