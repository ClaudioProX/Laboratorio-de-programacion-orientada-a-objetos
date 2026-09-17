public class Bardo extends Personaje implements Sanador {

    private int poderCuracion;
    private String instrumento;
    private int carisma;

    public Bardo(String nombre, int nivel, int puntosVida,
                 int poderCuracion, String instrumento, int carisma) {
        super(nombre, nivel, puntosVida);
        this.poderCuracion = poderCuracion;
        this.instrumento = instrumento;
        this.carisma = carisma;
    }

    @Override
    public void atacar() {
        System.out.println("[" + nombre
                + "] aturde al enemigo con un acorde de "
                + instrumento + ".");
    }

    @Override
    public int calcularDanio() {
        return (nivel * 10) + (carisma * 3);
    }

    @Override
    public void curarAliado(Personaje aliado) {
        aliado.puntosVida += poderCuracion;

        if (aliado.puntosVida > 0) {
            aliado.estaVivo = true;
        }

        System.out.println(nombre
                + " entona una melodía y cura a "
                + aliado.getNombre() + " +" + poderCuracion
                + ". Vida: " + aliado.getPuntosVida());
    }

    @Override
    public int getPoderCuracion() {
        return poderCuracion;
    }

    public String getInstrumento() {
        return instrumento;
    }

    public int getCarisma() {
        return carisma;
    }

    @Override
    public String toString() {
        return super.toString()
                + " | Curación: " + poderCuracion
                + " | Instrumento: " + instrumento
                + " | Carisma: " + carisma;
    }
}
