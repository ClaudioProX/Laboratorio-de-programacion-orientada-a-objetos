public class Main {

    public static void main(String[] args) {

        System.out.println("=== RPG — Expansión: Nuevas Clases ===");

        System.out.println("\n-- Error esperado (línea comentada) --");
        // Personaje generico = new Personaje("X", 1, 100);
        // ERROR: Personaje es abstracta y no puede instanciarse.
        System.out.println(
                "// new Personaje(...) -> no se puede instanciar una clase abstracta");

        Druida druida = new Druida(
                "Sylva", 7, 200,
                180, 120, "Lobo ancestral");

        Nigromante nigromante = new Nigromante(
                "Malachar", 6, 350,
                220, 15, 90);

        Bardo bardo = new Bardo(
                "Finnian", 5, 150,
                60, "Laúd", 12);

        Personaje[] equipo = {druida, nigromante, bardo};

        System.out.println("\n-- Ataques y daño --");
        for (Personaje p : equipo) {
            p.atacar();
            System.out.println("Daño: " + p.calcularDanio());
        }

        System.out.println("\n-- Capacidades por interfaz --");
        for (Personaje p : equipo) {

            if (p instanceof Hechicero h) {
                System.out.print("[Hechicero] ");
                h.lanzarHechizo();
            }

            if (p instanceof Sanador) {
                System.out.println("[Sanador] "
                        + p.getNombre() + " puede curar aliados.");
            }
        }

        System.out.println("\n-- Demostración de curación --");
        nigromante.recibirDanio(300);

        druida.curarAliado(nigromante);
        bardo.curarAliado(nigromante);

        System.out.println("\n-- Uso de instanceof para curar --");
        for (Personaje p : equipo) {
            if (p instanceof Sanador s) {
                System.out.println(p.getNombre()
                        + " implementa Sanador. Poder: "
                        + s.getPoderCuracion());
            }

            if (p instanceof Hechicero h) {
                System.out.println(p.getNombre()
                        + " implementa Hechicero. Maná: "
                        + h.getMana());
            }
        }

        System.out.println("\n-- Estado final --");
        for (Personaje p : equipo) {
            System.out.println(p);
        }
    }
}
