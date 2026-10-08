public class Nigromante extends Personaje {
    private int mana;

    public Nigromante(String nombre, int nivel, int puntosVida, int mana) {
        super(nombre, nivel, puntosVida);
        this.mana = mana;
    }

    @Override
    public void atacar() throws RpgException {
        if (!estaVivo) {
            throw new PersonajeDerrotadoException(nombre);
        }

        if (mana < 15) {
            throw new RecursoInsuficienteException("mana", mana);
        }

        mana -= 15;
        System.out.println(nombre + " lanza magia oscura.");
    }

    @Override
    public int calcularDanio() {
        return nivel * 14 + mana / 2;
    }

    public int getMana() {
        return mana;
    }
}
