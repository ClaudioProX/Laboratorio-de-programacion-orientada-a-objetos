public class Nigromante extends Personaje
        implements Hechicero {

    private int mana;
    private int almasAbsorbidas;
    private int nivelOscuridad;

    public Nigromante(String nombre, int nivel, int puntosVida,
                      int mana, int almasAbsorbidas, int nivelOscuridad) {
        super(nombre, nivel, puntosVida);
        this.mana = mana;
        this.almasAbsorbidas = almasAbsorbidas;
        this.nivelOscuridad = nivelOscuridad;
    }

    @Override
    public void atacar() throws RpgException {

        if (!isEstaVivo()) {
            throw new PersonajeDerrotadoException(getNombre());
        }

        if (mana < 15) {
            throw new RecursoInsuficienteException("mana", mana);
        }

        mana -= 15;

        System.out.println("[" + getNombre()
                + "] lanza una maldicion oscura."
                + " Mana restante: " + mana);
    }

    @Override
    public int calcularDanio() {
        return nivel * 20
                + almasAbsorbidas * 5
                + nivelOscuridad;
    }

    @Override
    public void lanzarHechizo() {
        System.out.println(getNombre()
                + " lanza Maldicion de Decadencia.");
    }

    @Override
    public int getMana() {
        return mana;
    }

    @Override
    public String toString() {
        return super.toString()
                + " | Mana: " + mana
                + " | Almas: " + almasAbsorbidas
                + " | Oscuridad: " + nivelOscuridad;
    }
}
