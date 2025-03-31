/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proycto2;


/**
 *
 * @author aleja
 */
public class Cliente {
    public String nombre;
    public ListaSimple solicitudes;
    public int tiempoTotalSolicitudes;
    // Constructor
    public Cliente(String nombre) {
        this.nombre = nombre;
        this.solicitudes = new ListaSimple();
        this.tiempoTotalSolicitudes = 0;
    }

    public void agregarSolicitud(String solicitud) {
        solicitudes.agregar(solicitud);
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
    
    @Override
    public String toString() {
        return "Cliente: " + nombre + ", Solicitudes: [" + solicitudes.toString() + "], Tiempo Total: " + tiempoTotalSolicitudes + " minutos";
    }
}