import java.util.Scanner;
import java.util.Stack;

public class App {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        Stack<DispositivoMovil> inventarioDMovil = new Stack<DispositivoMovil>();
        Stack<Laptop> inventarioDLaptop = new Stack<Laptop>();
        Stack<Mantenimiento> inventario = new Stack<Mantenimiento>();
        Stack<Mantenimiento> auditorias = new Stack<Mantenimiento>();
        Mantenimiento mantenimientos = new Mantenimiento();
        int op, id, op2;
        String nombre;
        do {
            op = menu();
            if (op == 1) {
                System.out.println("Inserte el id del dispositivo");
                id = sc.nextInt();
                DispositivoMovil movil1 = new DispositivoMovil(id, 2022, "Android", 8, 128, 4000, 1, 1080, "Samsung",
                        "Galaxy A51", "Exynos 9611", "AMOLED");
                if (verificarMantenimiento(movil1, inventario)) {
                    mantenimientos = new Mantenimiento(movil1);
                    mantenimientos.mostrarDatos();
                    inventario.push(mantenimientos);
                    inventarioDMovil.push(movil1);
                    movil1.mostrarDatos();
                }
            } else if (op == 2) {
                if (inventario.empty()) {
                    System.out.println("\nNo hay dispositivos en mantenimiento\n");
                    continue;
                }
                System.out.println("Inserta el nombre del técnico");
                nombre = sc.nextLine();
                if (validarCredencial(nombre)) {
                    System.out.println("Bienvenido");
                    System.out.println("¿Que desea hacer?");
                    System.out.println("1. Modificar mantenimiento");
                    System.out.println("2. Cancelar mantenimiento");
                    System.out.println("3. Entregar dispositivo");
                    System.out.println("4. Volver al menu principal");
                    op2 = sc.nextInt();
                    if (op2 == 1) {
                        mantenimientos.modificarMantenimiento();
                        ;
                    } else if (op2 == 2) {
                        System.out
                                .println(mantenimientos.cancelarMantenimiento(inventario, auditorias, inventarioDMovil,
                                        inventarioDLaptop) ? "Mantenimiento cancelado"
                                                : "No se encontró el dispositivo");
                    } else if (op2 == 3) {
                        mantenimientos.entregarDispositivo();
                    } else if (op2 == 4) {
                        continue;
                    }
                } else {
                    System.out.println("No tienes acceso, credencial incorrecta");
                    continue;
                }
            }
            for (Mantenimiento mantenimiento : auditorias) {
                mantenimiento.mostrarDatos();
            }

        } while (op != 3);
    }

    private static boolean verificarMantenimiento(Dispositivo dispositivo, Stack<Mantenimiento> inventario) {
        if (dispositivo.añoFabricacion < 2010) {
            dispositivo.estado = "Descontinuado";
            System.out.println("\nEl dispositivo está descontinuado\n");
            return false;
        }
        for (Mantenimiento mantenimiento : inventario) {
            if (!inventario.empty() && mantenimiento.id == dispositivo.id) {
                System.out.println("\nEl dispositivo ya está en mantenimiento\n");
                return false;
            }
        }
        dispositivo.estado = "En mantenimiento";
        return true;
    }

    private static int menu() {
        System.out.println("\n\tBienvenido a reparaciones Tacomovil");
        System.out.println("----------------------------------------------");
        System.out.println("¿Que desea hacer?");
        System.out.println("1. Validar dispositivo");
        System.out.println("2. Modificar o entregar dispositivo");
        System.out.println("3. Salir");

        int opcion = sc.nextInt();
        sc.nextLine(); // Consumir el salto de línea residual
        return opcion;
    }

    private static boolean validarCredencial(String nombre) {
        if (nombre.equals("Juan")) {
            return true;
        }
        return false;
    }
}
