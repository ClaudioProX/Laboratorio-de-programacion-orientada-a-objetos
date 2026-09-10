import java.util.ArrayList;

public class GestorBatalla {
    private ArrayList<String> historial;

    public GestorBatalla() {
        historial = new ArrayList<>();
    }

    // Sobrecarga 1: un atacante.
    public void ejecutarAtaque(Personaje atacante) {
        int danio = atacante.calcularDanio();
        System.out.println("[BATALLA] " + atacante.getNombre()
                + " ataca solo -> daño: " + danio);
        atacante.atacar();
        historial.add(atacante.getNombre() + " atacó solo (daño: " + danio + ")");
    }

    // Sobrecarga 2: atacante contra defensor.
    public void ejecutarAtaque(Personaje atacante, Personaje defensor) {
        int danio = atacante.calcularDanio();
        System.out.println("[BATALLA] " + atacante.getNombre()
                + " ataca a " + defensor.getNombre() + " -> daño: " + danio);
        atacante.atacar();
        defensor.recibirDanio(danio);
        defensor.defender();

        String evento = atacante.getNombre() + " atacó a " + defensor.getNombre()
                + " (daño: " + danio + ")";
        if (!defensor.isEstaVivo()) {
            evento += " - " + defensor.getNombre() + " derrotado";
        }
        historial.add(evento);
    }

    // Sobrecarga 3: un equipo completo.
    public void ejecutarAtaque(Personaje[] equipo) {
        System.out.println("[BATALLA] Equipo completo ataca -> "
                + equipo.length + " personajes");

        StringBuilder resumen = new StringBuilder("Ataque en equipo: ");
        for (int i = 0; i < equipo.length; i++) {
            Personaje atacante = equipo[i];
            int danio = atacante.calcularDanio();
            System.out.println("  " + atacante.getNombre() + " -> daño: " + danio);
            atacante.atacar();

            if (i > 0) resumen.append(", ");
            resumen.append(atacante.getNombre());
        }
        historial.add(resumen.toString());
    }

    public void mostrarHistorial() {
        System.out.println("\n-- Historial --");
        if (historial.isEmpty()) {
            System.out.println("No hay eventos registrados.");
            return;
        }
        for (int i = 0; i < historial.size(); i++) {
            System.out.println((i + 1) + ". " + historial.get(i));
        }
    }

    public void limpiarHistorial() {
        historial.clear();
        System.out.println("Historial limpiado.");
    }
}
