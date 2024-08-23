abstract class Dispositivo {
    private int id;
    private int añoFabricacion;
    private int ram;
    private int rom;
    private int bateria;
    private int puertos;
    private int resolucionPantalla;
    private String marca, modelo, cpu, tipoPantalla, so, estado;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAñoFabricacion() {
        return añoFabricacion;
    }

    public void setAñoFabricacion(int añoFabricacion) {
        this.añoFabricacion = añoFabricacion;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getRom() {
        return rom;
    }

    public void setRom(int rom) {
        this.rom = rom;
    }

    public int getBateria() {
        return bateria;
    }

    public void setBateria(int bateria) {
        this.bateria = bateria;
    }

    public int getPuertos() {
        return puertos;
    }

    public void setPuertos(int puertos) {
        this.puertos = puertos;
    }

    public int getResolucionPantalla() {
        return resolucionPantalla;
    }

    public void setResolucionPantalla(int resolucionPantalla) {
        this.resolucionPantalla = resolucionPantalla;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getTipoPantalla() {
        return tipoPantalla;
    }

    public void setTipoPantalla(String tipoPantalla) {
        this.tipoPantalla = tipoPantalla;
    }

    public String getSo() {
        return so;
    }

    public void setSo(String so) {
        this.so = so;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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
        System.out.println("\n----------------------------------------------");
    }
}

class DispositivoMovil extends Dispositivo {
    DispositivoMovil(int id, int añoFabricacion, String so, int ram, int rom, int bateria, int puertos,
            int resolucionPantalla, String marca, String modelo, String cpu, String tipoPantalla) {
        this.setId(id);
        this.setAñoFabricacion(añoFabricacion);
        this.setSo(so);
        this.setRam(ram);
        this.setRom(rom);
        this.setBateria(bateria);
        this.setPuertos(puertos);
        this.setResolucionPantalla(resolucionPantalla);
        this.setMarca(marca);
        this.setModelo(modelo);
        this.setCpu(cpu);
        this.setTipoPantalla(tipoPantalla);
        this.setEstado("Pendiente");
    }
}

class Laptop extends Dispositivo {
    Laptop(int id, int añoFabricacion, String so, int ram, int rom, int bateria, int puertos, int resolucionPantalla,
            String marca, String modelo, String cpu, String tipoPantalla) {
        this.setId(id);
        this.setAñoFabricacion(añoFabricacion);
        this.setSo(so);
        this.setRam(ram);
        this.setRom(rom);
        this.setBateria(bateria);
        this.setPuertos(puertos);
        this.setResolucionPantalla(resolucionPantalla);
        this.setMarca(marca);
        this.setModelo(modelo);
        this.setCpu(cpu);
        this.setTipoPantalla(tipoPantalla);
    }
}