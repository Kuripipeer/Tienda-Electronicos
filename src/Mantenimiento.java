import java.util.Scanner;

public class Mantenimiento {
    float Precio, manoObra, cancelacion, costoPieza;
    String cambios = "";

    Mantenimiento(Dispositivo Dispositivo) {
        this.manoObra = 400;
        this.cancelacion = 400;
        this.Precio = calcularPrecio();
    }

    private float calcularPrecio() {
        Scanner sc = new Scanner(System.in);
        int op = 1;
        do {
            System.out.println("¿Qué se le va a hacer?");
            cambios += sc.nextLine() + "\n";
            System.out.println("¿Cual es el costo de la pieza?");
            costoPieza += sc.nextFloat();

            System.out.println("¿Desea agregar otro cambio? 1. Sí 2. No");
            op = sc.nextInt();
        } while (op == 1);
        sc.close();
        return costoPieza + manoObra;
    }

    public void mostrarDatos(Dispositivo Dispositivo) {
        System.out.println("Dispositivo: " + Dispositivo.modelo);
        System.out.println("Cambios: " + cambios);
        System.out.println("Precio total: " + Precio);
    }

}
