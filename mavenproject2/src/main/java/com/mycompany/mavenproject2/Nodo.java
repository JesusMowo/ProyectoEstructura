package com.mycompany.mavenproject2;

public class Nodo {
    Jugador jugador;
    Nodo siguiente;
    Nodo anterior;
    public Nodo(Jugador jugador){
        this.jugador = jugador;
        this.siguiente = null;
        this.anterior = null;
    }
}
