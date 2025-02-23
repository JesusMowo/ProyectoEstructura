package com.mycompany.mavenproject2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Mavenproject2 {

    public static void main(String[] args) {
        
        ListaCircular lista = new ListaCircular();

        int opcion;
        System.out.println("BIENVENIDO A EL JUEGO DE LA PAPA CALIENTE BRO");
        do {
            System.out.println("----- MENU -----");
            System.out.println("1. Jugar");
            System.out.println("2. Salir");
            opcion = Utils.ValidarNumero();
            Utils.LimpiarConsola.Clr();
            switch (opcion) {
                case 1 -> jugar(lista);
                case 2 -> System.out.println("Chaito!! Gracias por jugar :3");
                default -> System.out.println("Opcion no valida, intenta de nuevo.");
            }
        } while (opcion != 2);
    }
    
    public static void jugar(ListaCircular lista) {
        
        String rutaArchivoEntrada = "archivos\\jugadores.in";
        lista.CargarJugadoresDesdeArchivo(rutaArchivoEntrada); //carga los jugadores desde archivos
        String perdedores = "archivos\\perdedores.out";
        String ganadores = "archivos\\ganadores.out";
        Utils.VaciarArchivo(perdedores);   //limpia el archivo perdedores
        Utils.VaciarArchivo(ganadores);    // limpia ganadores
        System.out.println("Bienvenidos al juego de la Papa Caliente!");
        System.out.println("Jugadores actuales en el juego:");
        
        Nodo temp = lista.cabeza;
        do {                                   // este ciclo enseña a los jugadores
            System.out.println(temp.jugador.getNombre());
            temp = temp.siguiente;
        } while (temp != lista.cabeza);
        Utils.LimpiarConsola.Limpiar();
        // Instrucciones del juego
        
        System.out.println("\n--- INSTRUCCIONES DEL JUEGO ---");
        System.out.println("1. Los jugadores estaran en un circulo.");
        System.out.println("2. Un jugador sera elegido al azar para comenzar.");
        System.out.println("3. El jugador pasara la 'papa caliente' en una direccion: horario o antihorario.");
        System.out.println("4. El jugador que termine con la papa caliente en las manos sera eliminado.");
        System.out.println("5. Este proceso se repetira hasta que quede un solo jugador.");
        System.out.println("6. El ultimo jugador restante sera el ganador.");
        
        Utils.LimpiarConsola.Limpiar();

        int ronda = 1;
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        
        while (lista.tamanio > 1) {
            Nodo jugadorActual = ListaCircular.SeleccionarJugadorAlAzar(lista);
            
            // Generar numero aleatorio entre 2 y 10 
            int pasosAleatorios = random.nextInt(9) + 2;  

            Nodo jugadorFinal = jugadorActual;

            // Mover según la dirección elegida
            for (int i = 0; i < pasosAleatorios; i++) {
                System.out.println("Jugador con la papa caliente: " + jugadorFinal.jugador.getNombre());
                System.out.print("Quieres pasar la papa caliente hacia la derecha (horario) o hacia la izquierda (antihorario)? (D/I): ");
                String direccion = scanner.next().toUpperCase();
                if (direccion.equals("D")) {
                    jugadorFinal = jugadorFinal.siguiente; // Mover hacia la derecha (horario)
                } else if (direccion.equals("I")) {
                    jugadorFinal = jugadorFinal.anterior; // Mover hacia la izquierda (antihorario)
                }
            }
            Utils.LimpiarConsola.Clr();
            System.out.println("Se quemo! Eliminado! " + jugadorFinal.jugador.getNombre() + " en la ronda " + ronda);

            // Guardamos al jugador eliminado y lo eliminamos de la lista
            lista.EliminarJugadorYGuardar(jugadorFinal, perdedores, ronda);
            ronda++;
        }

        // Cuando queda un solo jugador, lo guardamos como el ganador
        Nodo ganador = lista.cabeza;
        System.out.println("\nEl ganador es: " + ganador.jugador.getNombre());

        // Guardamos al ganador en el archivo
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ganadores, true))) {
            writer.write("Ganador: " + ganador.jugador.getNombre() + "\n");
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo de ganadores: " + e.getMessage());
        }
     }

}

