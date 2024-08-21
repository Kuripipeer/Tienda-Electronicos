import java.util.Stack;

public class App {
    public static void main(String[] args) throws Exception {
        Stack <Integer> inventario = new Stack<Integer>();
        DispositivoMovil movil1 = new DispositivoMovil(1, 2021, "Android", 8, 128, 4000, 1, 1080, "Samsung", "Galaxy A51", "Exynos 9611", "AMOLED");
        verificarMantenimiento(movil1,inventario);
        Mantenimiento mantenimiento1 = new Mantenimiento(movil1);
        mantenimiento1.mostrarDatos(movil1);
        movil1.mostrarDatos();
    }

    private static boolean verificarMantenimiento(Dispositivo dispositivo, Stack<Integer> inventario){
        if(dispositivo.añoFabricacion < 2010){
            dispositivo.estado = "Descontinuado";
            return false;
        }else if (inventario.contains(dispositivo.id)){
            System.out.println("El dispositivo ya está en mantenimiento");
            return false;
        }
        dispositivo.estado = "En mantenimiento";
        return true;
    }
}
