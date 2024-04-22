import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Uso: java Main <archivo config.csv>");
            return;
        }

        String configFile = args[0];
        Mascota mascota = null;
        Inventario inventario = new Inventario();

        try (BufferedReader br = new BufferedReader(new FileReader(configFile))) {
            String line = br.readLine(); // Nombre 
            mascota = new Mascota(line);

            while ((line = br.readLine()) != null) {
                String[] partes = line.split(";");
                int id = Integer.parseInt(partes[0]);
                String tipo = partes[1];
                String nombre = partes[2];
                int cantidad = Integer.parseInt(partes[3]);

                if (tipo.equals("Comida")) {
                    inventario.agregarItem(new Comida(id, nombre, cantidad));
                } else if (tipo.equals("Medicina")) {
                    inventario.agregarItem(new Medicina(id, nombre, cantidad));
                } else if (tipo.equals("Juguete")) {
                    inventario.agregarItem(new Juguete(id, nombre, cantidad));
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
            return;
        }

        Scanner scanner = new Scanner(System.in);
        float tiempoSimulado = 0.5f;

        // Simular el tiempo 
        mascota.incrementarEdad(tiempoSimulado);
        mascota.reducirIndicadores(5);

        while (true) {
            System.out.printf("Tiempo simulado: %.1f%n", tiempoSimulado);
            mascota.mostrarAtributos();
            inventario.mostrarItems();
            System.out.print("Seleccione un elemento del inventario, 'c' para dormir, o 'x' para salir: ");
            
            String opcion = scanner.nextLine().trim();
            
            if (opcion.equals("x")) {
                System.out.println("Simulación terminada.");
                break;
            } else if (opcion.equals("c")) {
                //aumententa paso del tiempo
                tiempoSimulado += 0.5f;
                mascota.incrementarEdad(0.5f);
                mascota.reducirIndicadores(5);
            } else {
                try {
                    int indice = Integer.parseInt(opcion);

                    if (indice == 0) {
                        System.out.println("La mascota duerme para recuperar energía.");
                        mascota.setEnergia(mascota.getEnergia() + 10);
                    } else {
                        Item item = inventario.obtenerItem(indice);

                        if (item != null) {
                            item.usar();  // Disminuye la cantidad de items
                            System.out.println("Usando " + item.getNombre());
                            if (item instanceof Comida) {
                                mascota.setSalud(mascota.getSalud() + 10);
                            } else if (item instanceof Medicina) {
                                mascota.setSalud(mascota.getSalud() + 15);
                            } else if (item instanceof Juguete) {
                                mascota.setFelicidad(mascota.getFelicidad() + 10);
                            }
                        } else {
                            System.out.println("Índice inválido. Inténtelo nuevamente.");
                        }
                    }

                } catch (NumberFormatException e) {
                    System.out.println("Entrada inválida. Por favor, intente nuevamente.");
                }
            }

            // confirma si la mascota se murio
            if (mascota.getEstado() == Mascota.Estado.MUERTO) {
                System.out.println("La mascota ha muerto. Fin del juego.");
                break;
            }
        }
        
        scanner.close(); // 
    }
}
