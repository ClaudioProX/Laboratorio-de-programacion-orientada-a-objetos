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

    @Override
    public void atacar() throws RpgException {
        if (!estaVivo) {
            throw new PersonajeDerrotadoException(nombre);
        }

        if (flechasDisponibles <= 0) {
            throw new RecursoInsuficienteException(
                    "flechas", flechasDisponibles);
        }

        flechasDisponibles--;
        System.out.println(nombre + " dispara con " + tipoArco + ".");
    }

    @Override
    public int calcularDanio() {
        return nivel * 8 + precision;
    }

    public int getFlechasDisponibles() {
        return flechasDisponibles;
    }
}
