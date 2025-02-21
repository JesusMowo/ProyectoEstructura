package com.mycompany.mavenproject2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Mavenproject2 {

    public static void VaciarArchivo(String nombreArchivo) {
        try (FileWriter writer = new FileWriter(nombreArchivo, false)) {
        } catch (IOException e) {
            System.out.println("Error al vaciar el archivo: " + e.getMessage());
        }
    }
    
    public class LimpiarConsola {
        public static void Clr() {
            for (int i = 0; i < 50; i++) { 
                System.out.println();
            }
        }
        public static void Limpiar(){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Presione enter para continuar!");
            scanner.nextLine();
            LimpiarConsola.Clr();
        }
    }
    public static int ValidarNumero() {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        
        while (true) {
            System.out.print("Elige una opcion: ");
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();  
                break;  
            } else {
                System.out.println("Error: No es un numero valido. Intenta nuevamente.");
                scanner.next();
            }
        }
        
        return opcion;
    }
    
    public static void main(String[] args) {
        
        String rutaArchivoEntrada = "archivos\\jugadores.in";
        ListaCircular lista = new ListaCircular();
        lista.CargarJugadoresDesdeArchivo(rutaArchivoEntrada);

        int opcion;
        
        do {
            System.out.println("----- MENU -----");
            System.out.println("1. Jugar");
            System.out.println("2. Salir");
            opcion = ValidarNumero();
            LimpiarConsola.Clr();
            switch (opcion) {
                case 1 -> jugar(lista);
                case 2 -> System.out.println("Chaito!!");
                default -> System.out.println("Opcion no valida, intenta de nuevo.");
            }
        } while (opcion != 2);
    }
    
    public static void jugar(ListaCircular lista) {
        

        String perdedores = "archivos\\perdedores.out";
        String ganadores = "archivos\\ganadores.out";
        VaciarArchivo(perdedores);
        VaciarArchivo(ganadores);
        System.out.println("Bienvenidos al juego de la Papa Caliente!");
        System.out.println("Jugadores actuales en el juego:");
        Nodo temp = lista.cabeza;
        do {
            System.out.println(temp.jugador.getNombre());
            temp = temp.siguiente;
        } while (temp != lista.cabeza);
        LimpiarConsola.Limpiar();
        // Instrucciones del juego
        System.out.println("\n--- INSTRUCCIONES DEL JUEGO ---");
        System.out.println("1. Los jugadores estaran en un circulo.");
        System.out.println("2. Un jugador sera elegido al azar para comenzar.");
        System.out.println("3. El jugador pasara la 'papa caliente' en una direccion: horario o antihorario.");
        System.out.println("4. El jugador que termine con la papa caliente en las manos sera eliminado.");
        System.out.println("5. Este proceso se repetira hasta que quede un solo jugador.");
        System.out.println("6. El ultimo jugador restante sera el ganador.");
     }

}

