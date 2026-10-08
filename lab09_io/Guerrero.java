public class Guerrero extends Personaje {
    private String arma;
    private int fuerza;

    public Guerrero(String nombre, int nivel, int puntosVida,
                    String arma, int fuerza) {
        super(nombre, nivel, puntosVida);
        this.arma = arma;
        this.fuerza = fuerza;
    }

    @Override
    public void atacar() throws RpgException {
        if (!estaVivo) {
            throw new PersonajeDerrotadoException(nombre);
        }
        System.out.println(nombre + " ataca con " + arma + ".");
    }

    @Override
    public int calcularDanio() {
        return nivel * 10 + fuerza;
    }
}
