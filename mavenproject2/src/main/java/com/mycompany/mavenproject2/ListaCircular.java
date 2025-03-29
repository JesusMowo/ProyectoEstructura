
package com.mycompany.mavenproject2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class ListaCircular {
    Nodo cabeza;
    int tamanio;

    public ListaCircular() {
        this.cabeza = null;
        this.tamanio = 0;
    }
    public void AgregarJugador(Jugador jugador) {
        Nodo nuevoNodo = new Nodo(jugador);
        
        if (cabeza == null) { 
            cabeza = nuevoNodo;
            cabeza.siguiente = cabeza;  
            cabeza.anterior = cabeza;   
        } else {  
            Nodo ultimo = cabeza.anterior;  
            ultimo.siguiente = nuevoNodo;
            nuevoNodo.anterior = ultimo;
            nuevoNodo.siguiente = cabeza; 
            cabeza.anterior = nuevoNodo;  
        }
        tamanio++;
    }

    // Cargar jugadores desde un archivo
    public void CargarJugadoresDesdeArchivo(String archivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String nombre;
            while ((nombre = br.readLine()) != null) {
                Jugador jugador = new Jugador(nombre);
                AgregarJugador(jugador);
            }
        } catch (IOException e) {
            System.out.println("Hubo un error al momento de leer el archivo papu: " + e.getMessage());
        }
    }

    // Eliminar un jugador de la lista
    public void EliminarJugador(Nodo jugadorEliminado) {
        if (cabeza == null) {
            return;
        }

        Nodo temp = cabeza;
        
        // Si el jugador a eliminar es el único nodo en la lista
        if (temp == jugadorEliminado && temp.siguiente == cabeza) {
            cabeza = null;
        } else {
            // Caso donde el jugador eliminado es la cabeza
            if (temp == jugadorEliminado) {
                Nodo ultimo = cabeza.anterior;
                cabeza = cabeza.siguiente;
                cabeza.anterior = ultimo;  
                ultimo.siguiente = cabeza; 
            } else {
                while (temp != null && temp != jugadorEliminado) {
                    temp = temp.siguiente;
                }

                if (temp != null) {
                    temp.anterior.siguiente = temp.siguiente;
                    temp.siguiente.anterior = temp.anterior;
                }
            }
        }
        tamanio--;
    }
    
    public static Nodo SeleccionarJugadorAlAzar(ListaCircular lista) {
        if (lista.tamanio == 0) {
            return null;  
        }
        Random random = new Random();
        int indiceAleatorio = random.nextInt(lista.tamanio);
        Nodo jugador = lista.cabeza;
        for (int i = 0; i < indiceAleatorio; i++) {
            jugador = jugador.siguiente;
        }
        return jugador;  
    }
    
    public void EliminarJugadorYGuardar(Nodo jugadorEliminado, String perdedores, int ronda) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(perdedores, true))) {
            writer.write(jugadorEliminado.jugador.getNombre() + " - Ronda " + ronda + "\n");
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo de perdedores: " + e.getMessage());
        }
        EliminarJugador(jugadorEliminado);
    }
}
