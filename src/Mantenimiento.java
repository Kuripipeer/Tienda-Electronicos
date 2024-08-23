import java.util.*;

public class Mantenimiento {
    static Scanner sc = new Scanner(System.in);
    private Date fechaHoraActual;
    private float Precio, manoObra = 400, cancelacion = 400, costoPieza;
    private int id;
    private String cambios = "", estado = "";

    Mantenimiento() {
    }

    Mantenimiento(Dispositivo Dispositivo) {
        this.id = Dispositivo.getId();
        this.estado = Dispositivo.getEstado();
        this.Precio = calcularPrecio();
        this.fechaHoraActual = new Date();
    }

    public Date getFechaHoraActual() {
        return fechaHoraActual;
    }

    public void setFechaHoraActual(Date fechaHoraActual) {
        this.fechaHoraActual = fechaHoraActual;
    }

    public float getPrecio() {
        return Precio;
    }

    public void setPrecio(float Precio) {
        this.Precio = Precio;
    }

    public float getCostoPieza() {
        return costoPieza;
    }

    public void setCostoPieza(float costoPieza) {
        this.costoPieza = costoPieza;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCambios() {
        return cambios;
    }

    public void setCambios(String cambios) {
        this.cambios = cambios;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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
        System.out.println("id del dispositivo: " + getId());
        System.out.println("Cambios: " + getCambios());
        System.out.println("Precio total: " + getPrecio());
        System.out.println("Fecha y hora: " + getFechaHoraActual());
        System.out.println("Estado: " + getEstado());
        System.out.println("\n----------------------------------------------");
    }

    public boolean modificarMantenimiento(Stack<Mantenimiento> inventario) {
        String cambio = "";
        int id, op;
        System.out.println("Inserta el id del dispositivo");
        id = sc.nextInt();
        for (Mantenimiento mantenimiento : inventario) {
            if (mantenimiento.getId() == id) {
                cambio = mantenimiento.getCambios();
                do {
                    System.out.println("¿Qué se le va a hacer?");
                    cambio += sc.nextLine() + "\n";
                    cambio += sc.nextLine() + "\n";
                    System.out.println("¿Cual es el costo de la pieza?");
                    costoPieza = sc.nextFloat();
                    setPrecio(costoPieza + getPrecio());
                    System.out.println("¿Desea agregar otro cambio? 1. Sí 2. No");
                    op = sc.nextInt();
                } while (op == 1);
                mantenimiento.setCambios(cambio);
                mostrarDetallesMantenimiento(id, inventario);
                return true;
            }
            return false;
        }
        return false;
    }

    public boolean cancelarMantenimiento(Stack<Mantenimiento> inventario, Stack<Mantenimiento> auditorias,
            Stack<DispositivoMovil> inventarioDMovil, Stack<Laptop> inventarioDLaptop) {
        System.out.println("Inserta el id del dispositivo");
        int id = sc.nextInt();
        for (DispositivoMovil movil : inventarioDMovil) {
            if (movil.getId() == id) {
                for (Mantenimiento mantenimiento : inventario) {
                    if (mantenimiento.getId() == id) {
                        mantenimiento.setEstado("Mantenimiento cancelado");
                        mantenimiento.setFechaHoraActual(new Date());
                        auditorias.push(mantenimiento);
                        inventario.remove(mantenimiento);
                        inventarioDMovil.remove(movil);
                        return true;
                    }
                }
            }
        }
        for (Laptop laptop : inventarioDLaptop) {
            if (laptop.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public boolean entregarDispositivo(Stack<Mantenimiento> inventario, Stack<Mantenimiento> auditorias,
            Stack<DispositivoMovil> inventarioDMovil, Stack<Laptop> inventarioDLaptop) {
        System.out.println("Inserta el id del dispositivo");
        int id = sc.nextInt();
        for (DispositivoMovil movil : inventarioDMovil) {
            if (movil.getId() == id) {
                for (Mantenimiento mantenimiento : inventario) {
                    if (mantenimiento.getId() == id) {
                        mantenimiento.setEstado("Entregado");
                        mantenimiento.setFechaHoraActual(new Date());
                        auditorias.push(mantenimiento);
                        inventario.remove(mantenimiento);
                        inventarioDMovil.remove(movil);
                        return true;
                    }
                }
            }
        }
        for (Laptop laptop : inventarioDLaptop) {
            if (laptop.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public void mostrarDetallesMantenimiento(int id, Stack<Mantenimiento> inventario) {
        for (Mantenimiento mantenimiento : inventario) {
            if (mantenimiento.getId() == id) {
                mantenimiento.mostrarDatos();
            }
        }
    }

}
