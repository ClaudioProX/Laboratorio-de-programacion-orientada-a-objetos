public class Mago extends Personaje {
    private int mana;
    private String escuelaMagia;

    public Mago(String nombre, int nivel, int puntosVida,
                int mana, String escuelaMagia) {
        super(nombre, nivel, puntosVida);
        this.mana = mana;
        this.escuelaMagia = escuelaMagia;
    }

    public int getMana() { return mana; }
    public String getEscuelaMagia() { return escuelaMagia; }

    @Override
    public int calcularDanio() {
        return mana * getNivel();
    }

    @Override
    public void atacar() {
        super.atacar();
        System.out.println("¡" + getNombre() + " lanza un hechizo de "
                + escuelaMagia + " causando " + mana + " de daño mágico!");
    }

    @Override
    public void defender() {
        System.out.println(getNombre() + " invoca un escudo mágico de " + escuelaMagia + ".");
    }

    @Override
    public String toString() {
        return super.toString()
                + " | Maná: " + mana
                + " | Escuela: " + escuelaMagia;
    }
}
