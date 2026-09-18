package org.example;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Tarea> tareas = new ArrayList<>();
        int opcion;

        do {
            System.out.println("\n--- BIENVENIDO AL GESTOR DE TAREAS ---");
            System.out.println("1. Añadir una tarea");
            System.out.println("2. Ver la lista de tareas");
            System.out.println("3. Marcar tarea como completada");
            System.out.println("4. Eliminar una tarea");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el salto de línea

            switch (opcion) {
                case 1:
                    System.out.print("Escribe la descripción de la tarea: ");
                    String descripcion = scanner.nextLine();
                    tareas.add(new Tarea(descripcion));
                    System.out.println("Tarea añadida correctamente.");
                    break;

                case 2:
                    System.out.println("\n--- Lista de Tareas ---");
                    if (tareas.isEmpty()) {
                        System.out.println("No hay tareas registradas.");
                    } else {
                        for (int i = 0; i < tareas.size(); i++) {
                            System.out.println((i + 1) + ". " + tareas.get(i));
                        }
                    }
                    break;

                case 3:
                    if (tareas.isEmpty()) {
                        System.out.println("No hay tareas para marcar.");
                    } else {
                        System.out.print("Introduce el número de la tarea a completar: ");
                        int indice = scanner.nextInt() - 1;
                        scanner.nextLine();

                        if (indice >= 0 && indice < tareas.size()) {
                            tareas.get(indice).marcarCompletada();
                            System.out.println("Tarea marcada como completada.");
                        } else {
                            System.out.println("Número de tarea no válido.");
                        }
                    }
                    break;

                case 4:
                    if (tareas.isEmpty()) {
                        System.out.println("No hay tareas para eliminar.");
                    } else {
                        System.out.print("¿Qué número de tarea quieres borrar?: ");
                        int indiceBorrar = scanner.nextInt() - 1;
                        scanner.nextLine();

                        if (indiceBorrar >= 0 && indiceBorrar < tareas.size()) {
                            tareas.remove(indiceBorrar);
                            System.out.println("Tarea eliminada correctamente.");
                        } else {
                            System.out.println("Número de tarea no válido.");
                        }
                    }
                    break;

                case 5:
                    System.out.println("Gracias y hasta luego.");
                    break;

                default:
                    System.out.println("Opción no válida. Escriba un número del 1 al 5.");
                    break;
            }
        } while (opcion != 5);

        scanner.close();
    }
}