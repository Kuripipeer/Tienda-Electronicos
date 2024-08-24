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
        int op, op2;
        String nombre;
        do {
            op = menu();
            switch (op) {
                case 1:
                    DispositivoMovil movil1 = new DispositivoMovil(1, 2022, "Android", 8, 128, 4000, 1, 1080, "Samsung",
                            "Galaxy A51", "Exynos 9611", "AMOLED");
                    if (verificarMantenimiento(movil1, inventario)) {
                        mantenimientos = new Mantenimiento(movil1);
                        mantenimientos.mostrarDatos();
                        inventario.push(mantenimientos);
                        inventarioDMovil.push(movil1);
                        auditorias.push(mantenimientos);
                        movil1.mostrarDatos();
                    }
                    Laptop laptop1 = new Laptop(2, 2019, "Windows 10", 8, 256, 8000, 5, 1080, "Asus",
                            "Rog", "Amd 5", "AMOLED");
                    if (verificarMantenimiento(laptop1, inventario)) {
                        mantenimientos = new Mantenimiento(laptop1);
                        mantenimientos.mostrarDatos();
                        inventario.push(mantenimientos);
                        inventarioDLaptop.push(laptop1);
                        auditorias.push(mantenimientos);
                        laptop1.mostrarDatos();
                    }
                    break;
                case 2:
                    if (inventario.empty()) {
                        System.out.println("\nNo hay dispositivos en mantenimiento\n");
                        continue;
                    }
                    System.out.println("\nInserta el nombre del técnico");
                    nombre = sc.next().toLowerCase();
                    if (validarCredencial(nombre)) {
                        System.out.println("\nBienvenido");
                        System.out.println("¿Que desea hacer?");
                        System.out.println("1. Modificar mantenimiento");
                        System.out.println("2. Cancelar mantenimiento");
                        System.out.println("3. Entregar dispositivo");
                        System.out.println("4. Volver al menu principal");

                        String option = sc.next();
                        while (!IsInteger(option)) {
                            System.out.print(
                                    "El valor ingresado no es un entero\n\nIntente nuevamente: ");
                            option = sc.next();
                        }
                        op2 = Integer.parseInt(option);
                        switch (op2) {
                            case 1:
                                if (mantenimientos.modificarMantenimiento(inventario, auditorias)) {
                                    System.out.println("Mantenimiento modificado");
                                } else {
                                    System.out.println("No se encontró el dispositivo");
                                }
                                break;
                            case 2:
                                System.out
                                        .println(mantenimientos.cancelarMantenimiento(inventario, auditorias,
                                                inventarioDMovil,
                                                inventarioDLaptop) ? "Mantenimiento cancelado"
                                                        : "No se encontró el dispositivo");
                                break;
                            case 3:
                                System.out.println(
                                        mantenimientos.entregarDispositivo(inventario, auditorias, inventarioDMovil,
                                                inventarioDLaptop) ? "Dispositivo entregado"
                                                        : "No se encontró el dispositivo");
                                break;
                            case 4:
                                continue;
                            default:
                                System.out.println("Opción no válida");
                                break;
                        }
                    } else {
                        System.out.println("No tienes acceso, credencial incorrecta");
                        continue;
                    }
                    break;
                case 3:
                    System.out.println("Inserta el nombre del técnico");
                    nombre = sc.next().toLowerCase();
                    if (validarCredencial(nombre)) {
                        System.out.println("\nBienvenido");
                        System.out.println("¿Que deseas ver?");
                        System.out.println("1. Auditorias");
                        System.out.println("2. Dispositivos en mantenimiento");
                        System.out.println("3. Dispositivos Moviles");
                        System.out.println("4. Laptops");
                        System.out.println("5. Salir");
                        String option = sc.next();
                        while (!IsInteger(option)) {
                            System.out.print(
                                    "El valor ingresado no es un entero\n\nIntente nuevamente: ");
                            option = sc.next();
                        }
                        op2 = Integer.parseInt(option);
                        switch (op2) {
                            case 1:
                                mostrarAuditorias(auditorias);
                                break;
                            case 2:
                                mostrarInventario(inventario);
                                break;
                            case 3:
                                mostrarInventarioDMovil(inventarioDMovil);
                                break;
                            case 4:
                                mostrarInventarioDLaptop(inventarioDLaptop);
                                break;
                            case 5:
                                continue;
                            default:
                                System.out.println("Opción no válida");
                                break;
                        }
                    } else {
                        System.out.println("No tienes acceso, credencial incorrecta");
                        continue;
                    }
                    break;
                case 4:
                    System.out.println("Gracias por usar el sistema");
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (op != 4);
    }

    private static void mostrarInventarioDLaptop(Stack<Laptop> inventarioDLaptop) {
        for (Laptop laptop : inventarioDLaptop) {
            laptop.mostrarDatos();
        }
    }

    private static void mostrarInventarioDMovil(Stack<DispositivoMovil> inventarioDMovil) {
        for (DispositivoMovil movil : inventarioDMovil) {
            movil.mostrarDatos();
        }
    }

    private static void mostrarInventario(Stack<Mantenimiento> inventario) {
        for (Mantenimiento mantenimiento : inventario) {
            mantenimiento.mostrarDatos();
        }
    }

    private static void mostrarAuditorias(Stack<Mantenimiento> auditorias) {
        for (Mantenimiento mantenimiento : auditorias) {
            mantenimiento.mostrarDatos();
        }
    }

    private static boolean verificarMantenimiento(Dispositivo dispositivo, Stack<Mantenimiento> inventario) {
        if (dispositivo.getAñoFabricacion() < 2010) {
            dispositivo.setEstado("Descontinuado");
            System.out.println("\nEl dispositivo está descontinuado\n");
            return false;
        }
        for (Mantenimiento mantenimiento : inventario) {
            if (!inventario.empty() && mantenimiento.getId() == dispositivo.getId()) {
                System.out.println("\nEl dispositivo ya está en mantenimiento\n");
                return false;
            }
        }
        dispositivo.setEstado("En mantenimiento");
        return true;
    }

    private static int menu() {
        System.out.println("\n\tBienvenido a reparaciones Tacomovil");
        System.out.println("----------------------------------------------");
        System.out.println("¿Que desea hacer?");
        System.out.println("1. Validar dispositivo");
        System.out.println("2. Modificar o entregar dispositivo");
        System.out.println("3. Ver datos");
        System.out.println("4. Salir");

        String option = sc.next();
        while (!IsInteger(option)) {
            System.out.print(
                    "El valor ingresado no es un entero\n\nIntente nuevamente: ");
            option = sc.next();
        }
        return Integer.parseInt(option);
    }

    private static boolean validarCredencial(String nombre) {
        if (nombre.equals("juan")) {
            return true;
        }
        return false;
    }

    public static boolean IsInteger(String text) {
        int v;
        try {
            v = Integer.parseInt(text);
            if (v < 0) {
                return false;
            }
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
}
