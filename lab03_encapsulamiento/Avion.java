public class Avion extends Vehiculo {
    private int numMotores;
    private double altitudMaxima;
    private String aerolinea;

    public Avion(String marca, String modelo, int anio, double velocidadMax,
                 int numMotores, double altitudMaxima, String aerolinea) {
        super(marca, modelo, anio, velocidadMax);
        setNumMotores(numMotores);
        setAltitudMaxima(altitudMaxima);
        this.aerolinea = aerolinea;
    }

    public int getNumMotores() {
        return numMotores;
    }

    public double getAltitudMaxima() {
        return altitudMaxima;
    }

    public String getAerolinea() {
        return aerolinea;
    }

    public void setNumMotores(int numMotores) {
        if (numMotores > 0) {
            this.numMotores = numMotores;
        } else {
            System.out.println("Error: número de motores no válido.");
        }
    }

    public void setAltitudMaxima(double altitudMaxima) {
        if (altitudMaxima > 0) {
            this.altitudMaxima = altitudMaxima;
        } else {
            System.out.println("Error: altitud máxima no válida.");
        }
    }

    public void setAerolinea(String aerolinea) {
        if (aerolinea != null && !aerolinea.isBlank()) {
            this.aerolinea = aerolinea;
        } else {
            System.out.println("Error: aerolínea no válida.");
        }
    }

    @Override
    public String toString() {
        return super.toString()
            + String.format("%nMotores: %d | Altitud máx.: %.0f m | Aerolínea: %s",
                numMotores, altitudMaxima, aerolinea);
    }
}
