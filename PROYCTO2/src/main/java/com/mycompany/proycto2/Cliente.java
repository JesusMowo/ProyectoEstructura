/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proycto2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author aleja
 */
public class Cliente {
    public String nombre;
    public List<String> solicitudes;
    public int tiempoTotalSolicitudes;
    // Constructor
    public Cliente(String nombre) {
        this.nombre = nombre;
        this.solicitudes = new ArrayList<>();
        this.tiempoTotalSolicitudes = 0;
    }

    public void agregarSolicitud(String solicitud) {
        solicitudes.add(solicitud);
        actualizarTiempoTotal(solicitud);
    }

    private void actualizarTiempoTotal(String solicitud) {
        switch (solicitud.toLowerCase()) {
            case "retiro" -> tiempoTotalSolicitudes += 4;
            case "deposito" -> tiempoTotalSolicitudes += 3;
            case "consulta de movimientos" -> tiempoTotalSolicitudes += 2;
            case "actualizacion de libretas" -> tiempoTotalSolicitudes += 5;
            case "pago de servicios" -> tiempoTotalSolicitudes += 2;
            default -> System.out.println("Solicitud no reconocida: " + solicitud);
        }
    }
     
    public static List<Cliente> cargarClientesDesdeArchivo(String rutaArchivo) {
        List<Cliente> clientes = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                String nombre = partes[0].trim(); 
                Cliente cliente = new Cliente(nombre);

                // Agregar solicitudes
                for (int i = 1; i < partes.length; i++) {
                    cliente.agregarSolicitud(partes[i].trim()); 
                }

                clientes.add(cliente);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return clientes;
    }
    
    @Override
    public String toString() {
        return "Cliente: " + nombre + ", Tiempo Total Solicitudes: " + tiempoTotalSolicitudes + " minutos";
    }
}