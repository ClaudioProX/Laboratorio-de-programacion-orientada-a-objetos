public class Druida extends Personaje {
    private int mana;

    public Druida(String nombre, int nivel, int puntosVida, int mana) {
        super(nombre, nivel, puntosVida);
        this.mana = mana;
    }

    @Override
    public void atacar() throws RpgException {
        if (!estaVivo) {
            throw new PersonajeDerrotadoException(nombre);
        }

        if (mana < 10) {
            throw new RecursoInsuficienteException("mana", mana);
        }

        mana -= 10;
        System.out.println(nombre + " invoca raices del bosque.");
    }

    @Override
    public int calcularDanio() {
        return nivel * 12 + mana / 2;
    }

    public int getMana() {
        return mana;
    }
}
