public class Nigromante extends Personaje implements Hechicero {

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
    public void atacar() {
        System.out.println("[" + nombre
                + "] drena la esencia vital de su enemigo.");
    }

    @Override
    public int calcularDanio() {
        return (nivel * 25)
                + (almasAbsorbidas * 10)
                + nivelOscuridad;
    }

    @Override
    public void lanzarHechizo() {
        System.out.println(nombre
                + " lanza: ¡Maldición de decadencia! (maná: "
                + mana + ")");
    }

    @Override
    public int getMana() {
        return mana;
    }

    public int getAlmasAbsorbidas() {
        return almasAbsorbidas;
    }

    public int getNivelOscuridad() {
        return nivelOscuridad;
    }

    @Override
    public String toString() {
        return super.toString()
                + " | Maná: " + mana
                + " | Almas: " + almasAbsorbidas
                + " | Oscuridad: " + nivelOscuridad;
    }
}
