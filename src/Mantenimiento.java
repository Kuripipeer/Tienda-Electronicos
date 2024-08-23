import java.util.*;

public class Mantenimiento {
    static Scanner sc = new Scanner(System.in);
    Date fechaHoraActual;
    float Precio, manoObra, cancelacion, costoPieza;
    int id;
    String cambios = "", estado = "";

    Mantenimiento() {
    }

    Mantenimiento(Dispositivo Dispositivo) {
        this.id = Dispositivo.id;
        this.estado = Dispositivo.estado;
        this.manoObra = 400;
        this.cancelacion = 400;
        this.Precio = calcularPrecio();
        this.fechaHoraActual = new Date();
    }

    private float calcularPrecio() {
        int op = 1;
        do {
            System.out.println("¿Qué se le va a hacer?");
            cambios += sc.nextLine() + "\n";
            System.out.println("¿Cual es el costo de la pieza?");
            costoPieza += sc.nextFloat();

            System.out.println("¿Desea agregar otro cambio? 1. Sí 2. No");
            op = sc.nextInt();
        } while (op == 1);
        return costoPieza + manoObra;
    }

    public void mostrarDatos() {
        System.out.println("\n----------------------------------------------");
        System.out.println("\tTicket de mantenimiento");
        // System.out.println("Dispositivo: " + Dispositivo.modelo);
        System.out.println("Cambios: " + cambios);
        System.out.println("Precio total: " + Precio);
        System.out.println("Fecha y hora: " + fechaHoraActual);
        System.out.println("Estado: " + estado);
    }

    public void modificarMantenimiento() {
        System.out.println("¿Qué se le va a hacer?");
        cambios += sc.nextLine() + "\n";
        System.out.println("¿Cual es el costo de la pieza?");
        costoPieza += sc.nextFloat();
        Precio = costoPieza + manoObra;
    }

    public boolean cancelarMantenimiento(Stack<Mantenimiento> inventario, Stack<Mantenimiento> auditorias,
            Stack<DispositivoMovil> inventarioDMovil, Stack<Laptop> inventarioDLaptop) {
        System.out.println("Inserta el id del dispositivo");
        int id = sc.nextInt();
        for (DispositivoMovil movil : inventarioDMovil) {
            if (movil.id == id) {
                for (Mantenimiento mantenimiento : inventario) {
                    if (mantenimiento.id == id) {
                        mantenimiento.estado = "Mantenimiento cancelado";
                        mantenimiento.fechaHoraActual = new Date();
                        auditorias.push(mantenimiento);
                        inventario.remove(mantenimiento);
                        inventarioDMovil.remove(movil);
                        return true;
                    }
                }
            }
        }
        for (Laptop laptop : inventarioDLaptop) {
            if (laptop.id == id) {
                return true;
            }
        }
        return false;
    }

    public void entregarDispositivo() {
        System.out.println("Dispositivo entregado");
    }

}
