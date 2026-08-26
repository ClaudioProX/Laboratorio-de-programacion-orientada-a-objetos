public class Vehiculo {
    private String marca;
    private String modelo;
    private int anio;
    protected double velocidadMax;

    public Vehiculo(String marca, String modelo, int anio, double velocidadMax) {
        this.marca = marca;
        this.modelo = modelo;
        setAnio(anio);
        setVelocidadMax(velocidadMax);
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAnio() {
        return anio;
    }

    public double getVelocidadMax() {
        return velocidadMax;
    }

    public void setAnio(int anio) {
        if (anio >= 1885 && anio <= 2100) {
            this.anio = anio;
        } else {
            System.out.println("Error: año no válido.");
        }
    }

    public void setVelocidadMax(double vel) {
        if (vel > 0) {
            this.velocidadMax = vel;
        } else {
            System.out.println("Error: velocidad máxima no válida.");
        }
    }

    public void describir() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return String.format(
            "Marca: %s | Modelo: %s | Año: %d | Vel. Máx: %.1f km/h",
            marca, modelo, anio, velocidadMax
        );
    }
}
