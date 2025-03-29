/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proycto2;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
/**
 *
 * @author aleja
 */
public class PROYCTO2 {

    public static void main(String[] args) {
        Cola cola = new Cola(); 

        // Cargar los clientes desde el archivo directamente a la cola
        cargarClientesEnCola("archivos/Clientes.in", cola);

        // Tiempo total de atención disponible en minutos (de 8:00 AM a 3:30 PM, es decir, 450 minutos)
        int tiempoDisponible = 450;  

        while (tiempoDisponible > 0 && !cola.estaVacia()) {
            Cliente cliente = cola.desencolar(); 

            if (cliente.tiempoTotalSolicitudes <= tiempoDisponible) {
                System.out.println("Atendiendo a: " + cliente.nombre);
                System.out.println("Solicitudes: " + cliente.solicitudes);
                System.out.println("Tiempo total de atencion: " + cliente.tiempoTotalSolicitudes + " minutos");

                tiempoDisponible -= cliente.tiempoTotalSolicitudes;

                guardarClienteAtendido(cliente);
                System.out.println("Tiempo restante: " + tiempoDisponible + " minutos");
            } else {
                System.out.println("No hay suficiente tiempo para atender a: " + cliente.nombre);
                break;  
            }
        }

        if (tiempoDisponible == 0) {
            System.out.println("Se ha alcanzado el tiempo límite de atencion (3:30 PM).");
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

    private static void guardarClienteAtendido(Cliente cliente) {
        LocalDate fechaActual = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String fechaFormateada = fechaActual.format(formatter);

        String nombreArchivo = "taquilla" + fechaFormateada + ".log";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo, true))) {
            writer.write(cliente.toString());
            writer.newLine();  
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
