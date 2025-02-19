package com.mycompany.mavenproject2;

public class Nodo {
    Jugador jugador;
    Nodo siguiente;
    
    public Nodo(Jugador jugador){
        this.jugador = jugador;
        this.siguiente = null;
    }
}
