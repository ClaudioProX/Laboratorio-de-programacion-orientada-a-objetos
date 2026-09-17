public class Druida extends Personaje implements Hechicero, Sanador {

    private int mana;
    private int poderCuracion;
    private String formaNatural;

    public Druida(String nombre, int nivel, int puntosVida,
                  int mana, int poderCuracion, String formaNatural) {
        super(nombre, nivel, puntosVida);
        this.mana = mana;
        this.poderCuracion = poderCuracion;
        this.formaNatural = formaNatural;
    }

    @Override
    public void atacar() {
        System.out.println("[" + nombre
                + "] invoca raíces y espinas de la naturaleza.");
    }

    @Override
    public int calcularDanio() {
        return (nivel * 20) + (mana / 2);
    }

    @Override
    public void lanzarHechizo() {
        System.out.println(nombre
                + " lanza: ¡Tormenta de espinas! (maná: "
                + mana + ")");
    }

    @Override
    public int getMana() {
        return mana;
    }

    @Override
    public void curarAliado(Personaje aliado) {
        aliado.puntosVida += poderCuracion;

        if (aliado.puntosVida > 0) {
            aliado.estaVivo = true;
        }

        System.out.println(nombre
                + " toca la tierra y cura a "
                + aliado.getNombre() + " +" + poderCuracion
                + ". Vida: " + aliado.getPuntosVida());
    }

    @Override
    public int getPoderCuracion() {
        return poderCuracion;
    }

    public String getFormaNatural() {
        return formaNatural;
    }

    @Override
    public String toString() {
        return super.toString()
                + " | Maná: " + mana
                + " | Curación: " + poderCuracion
                + " | Forma natural: " + formaNatural;
    }
}
