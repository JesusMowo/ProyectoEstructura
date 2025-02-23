
package com.mycompany.mavenproject2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class Utils {
    
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
}
