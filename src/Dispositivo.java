abstract class Dispositivo {
    int id, añoFabricacion, ram, rom, bateria, puertos, resolucionPantalla;
    String marca, modelo, cpu, tipoPantalla, so, estado;
}

class DispositivoMovil extends Dispositivo {
    DispositivoMovil(int id, int añoFabricacion, String so, int ram, int rom, int bateria, int puertos,
            int resolucionPantalla, String marca, String modelo, String cpu, String tipoPantalla) {
        this.id = id;
        this.añoFabricacion = añoFabricacion;
        this.so = so;
        this.ram = ram;
        this.rom = rom;
        this.bateria = bateria;
        this.puertos = puertos;
        this.resolucionPantalla = resolucionPantalla;
        this.marca = marca;
        this.modelo = modelo;
        this.cpu = cpu;
        this.tipoPantalla = tipoPantalla;
        this.estado = "Pendiente";
    }

    public void mostrarDatos() {
        System.out.println("\nID: " + id);
        System.out.println("Año de fabricación: " + añoFabricacion);
        System.out.println("Sistema operativo: " + so);
        System.out.println("RAM: " + ram);
        System.out.println("ROM: " + rom);
        System.out.println("Batería: " + bateria);
        System.out.println("Puertos: " + puertos);
        System.out.println("Resolución de pantalla: " + resolucionPantalla);
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("CPU: " + cpu);
        System.out.println("Tipo de pantalla: " + tipoPantalla);
        System.out.println("Estado: " + estado);
    }
}

class Laptop extends Dispositivo {
    Laptop(int id, int añoFabricacion, String so, int ram, int rom, int bateria, int puertos, int resolucionPantalla,
            String marca, String modelo, String cpu, String tipoPantalla) {
        this.id = id;
        this.añoFabricacion = añoFabricacion;
        this.so = so;
        this.ram = ram;
        this.rom = rom;
        this.bateria = bateria;
        this.puertos = puertos;
        this.resolucionPantalla = resolucionPantalla;
        this.marca = marca;
        this.modelo = modelo;
        this.cpu = cpu;
        this.tipoPantalla = tipoPantalla;
    }

    public void mostrarDatos() {
        System.out.println("\nID: " + id);
        System.out.println("Año de fabricación: " + añoFabricacion);
        System.out.println("Sistema operativo: " + so);
        System.out.println("RAM: " + ram);
        System.out.println("ROM: " + rom);
        System.out.println("Batería: " + bateria);
        System.out.println("Puertos: " + puertos);
        System.out.println("Resolución de pantalla: " + resolucionPantalla);
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("CPU: " + cpu);
        System.out.println("Tipo de pantalla: " + tipoPantalla);
        System.out.println("Estado: " + estado);
    }

}