public class Barco extends Vehiculo {
    private String tipoCasco;
    private double tonelajeMaximo;
    private int numTripulantes;

    public Barco(String marca, String modelo, int anio, double velocidadMax,
                 String tipoCasco, double tonelajeMaximo, int numTripulantes) {
        super(marca, modelo, anio, velocidadMax);
        this.tipoCasco = tipoCasco;
        setTonelajeMaximo(tonelajeMaximo);
        setNumTripulantes(numTripulantes);
    }

    public String getTipoCasco() {
        return tipoCasco;
    }

    public double getTonelajeMaximo() {
        return tonelajeMaximo;
    }

    public int getNumTripulantes() {
        return numTripulantes;
    }

    public void setTipoCasco(String tipoCasco) {
        if (tipoCasco != null && !tipoCasco.isBlank()) {
            this.tipoCasco = tipoCasco;
        } else {
            System.out.println("Error: tipo de casco no válido.");
        }
    }

    public void setTonelajeMaximo(double tonelajeMaximo) {
        if (tonelajeMaximo > 0) {
            this.tonelajeMaximo = tonelajeMaximo;
        } else {
            System.out.println("Error: tonelaje máximo no válido.");
        }
    }

    public void setNumTripulantes(int numTripulantes) {
        if (numTripulantes > 0) {
            this.numTripulantes = numTripulantes;
        } else {
            System.out.println("Error: número de tripulantes no válido.");
        }
    }

    @Override
    public String toString() {
        return super.toString()
            + String.format("%nCasco: %s | Tonelaje máx.: %.1f t | Tripulantes: %d",
                tipoCasco, tonelajeMaximo, numTripulantes);
    }
}
