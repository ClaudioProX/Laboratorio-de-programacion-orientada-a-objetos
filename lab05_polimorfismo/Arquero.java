public class Arquero extends Personaje {
    private String tipoArco;
    private int flechasDisponibles;
    private int precision;

    public Arquero(String nombre, int nivel, int puntosVida,
                   String tipoArco, int flechasDisponibles, int precision) {
        super(nombre, nivel, puntosVida);
        this.tipoArco = tipoArco;
        this.flechasDisponibles = flechasDisponibles;
        this.precision = precision;
    }

    public String getTipoArco() { return tipoArco; }
    public int getFlechasDisponibles() { return flechasDisponibles; }
    public int getPrecision() { return precision; }

    @Override
    public int calcularDanio() {
        return precision * flechasDisponibles;
    }

    @Override
    public void atacar() {
        super.atacar();
        if (flechasDisponibles > 0) {
            flechasDisponibles--;
            System.out.println(getNombre() + " dispara una flecha con su " + tipoArco
                    + ". Flechas restantes: " + flechasDisponibles);
        } else {
            System.out.println(getNombre() + " no tiene flechas disponibles.");
        }
    }

    @Override
    public void defender() {
        System.out.println(getNombre() + " esquiva rápidamente el ataque.");
    }

    @Override
    public String toString() {
        return super.toString()
                + " | Arco: " + tipoArco
                + " | Flechas: " + flechasDisponibles
                + " | Precisión: " + precision + "%";
    }
}
