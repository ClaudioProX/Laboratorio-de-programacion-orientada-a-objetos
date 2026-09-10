public class Personaje implements Combatiente {
    private String nombre;
    private int nivel;
    private int puntosVida;
    private boolean estaVivo;

    public Personaje(String nombre, int nivel, int puntosVida) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.puntosVida = puntosVida;
        this.estaVivo = puntosVida > 0;
    }

    public String getNombre() { return nombre; }
    public int getNivel() { return nivel; }
    public int getPuntosVida() { return puntosVida; }
    public boolean isEstaVivo() { return estaVivo; }

    public void recibirDanio(int danio) {
        if (!estaVivo) {
            System.out.println(nombre + " ya está derrotado.");
            return;
        }
        if (danio < 0) danio = 0;

        puntosVida -= danio;
        if (puntosVida <= 0) {
            puntosVida = 0;
            estaVivo = false;
        }

        System.out.println(nombre + " recibe " + danio
                + " puntos de daño. Vida restante: " + puntosVida);
        if (!estaVivo) {
            System.out.println(nombre + " ha sido derrotado.");
        }
    }

    public int calcularDanio() {
        return getNivel() * 10;
    }

    @Override
    public void atacar() {
        System.out.println("[" + nombre + "] ataca con un golpe básico.");
    }

    @Override
    public void defender() {
        System.out.println(nombre + " se pone en guardia.");
    }

    // Sobrecarga adicional: tres firmas distintas.
    public void mostrarEstado() {
        System.out.println(nombre + " | Vida: " + puntosVida);
    }

    public void mostrarEstado(boolean detallado) {
        if (detallado) {
            System.out.println(toString());
        } else {
            mostrarEstado();
        }
    }

    public void mostrarEstado(String prefijo) {
        System.out.println(prefijo + " " + toString());
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre
                + " | Nivel: " + nivel
                + " | Vida: " + puntosVida
                + " | Vivo: " + (estaVivo ? "Sí" : "No");
    }
}
