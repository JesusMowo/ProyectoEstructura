
package com.mycompany.mavenproject2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ListaCircular {
    private Nodo cabeza;
    
    public void agregarJugador(Jugador jugador) {
        Nodo nuevoNodo = new Nodo(jugador);
        if (cabeza == null) {
            cabeza = nuevoNodo;
            cabeza.siguiente = cabeza;
        } else {
            Nodo temp = cabeza;
            while (temp.siguiente != cabeza) {
                temp = temp.siguiente;
            }
            temp.siguiente = nuevoNodo;
            nuevoNodo.siguiente = cabeza; 
        }
    }
    
    public void cargarJugadoresDesdeArchivo(String archivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String nombre;
            while ((nombre = br.readLine()) != null) {
                Jugador jugador = new Jugador(nombre);
                agregarJugador(jugador);
            }
        } catch (IOException e) {
            System.out.println("Hubo un error al momento de leer el archivo papu: " + e.getMessage());
        }
    }
}
