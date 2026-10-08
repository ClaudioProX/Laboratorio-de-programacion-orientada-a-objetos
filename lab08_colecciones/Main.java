public class Main {

    public static void main(String[] args) {

        GestionGremio gremio = new GestionGremio();

        System.out.println("=== BLOQUE 1 - ARRAYLIST ===");

        gremio.agregarMiembro(
                new Druida("Sylva", 10, 300, 100));

        gremio.agregarMiembro(
                new Nigromante("Malachar", 8, 250, 120));

        gremio.agregarMiembro(
                new Arquero("Legolas", 6, 150,
                        "Arco", 20, 95));

        gremio.agregarMiembro(
                new Guerrero("Thorin", 9, 400,
                        "Hacha", 80));

        gremio.mostrarRoster();

        gremio.eliminarMiembro("Malachar");
        gremio.mostrarRoster();

        Personaje encontrado =
                gremio.buscarPorNombre("Legolas");

        if (encontrado != null) {
            System.out.println(
                    "Encontrado: " + encontrado.getNombre());
        }

        System.out.println("\n=== BLOQUE 2 - LINKEDLIST ===");

        gremio.encolarSolicitante("Gandalf");
        gremio.encolarSolicitante("Aragorn");
        gremio.encolarSolicitante("Gimli");

        gremio.mostrarCola();

        gremio.atenderSiguiente();
        gremio.mostrarCola();

        System.out.println("\n=== BLOQUE 3 - HASHMAP ===");

        gremio.agregarItem("Pocion de vida", 5);
        gremio.agregarItem("Flecha elfica", 30);
        gremio.agregarItem("Pocion de vida", 3);

        gremio.mostrarInventario();

        gremio.usarItem("Pocion de vida");
        gremio.usarItem("Pergamino de fuego");

        gremio.mostrarInventario();

        System.out.println("\n=== BLOQUE 4 - HASHSET ===");

        gremio.registrarHabilidad("Curacion");
        gremio.registrarHabilidad("Magia oscura");
        gremio.registrarHabilidad("Curacion");

        gremio.mostrarHabilidades();

        System.out.println("Tiene tiro con arco? "
                + gremio.tieneHabilidad("Tiro con arco"));

        System.out.println("Tiene curacion? "
                + gremio.tieneHabilidad("Curacion"));

        System.out.println("\n=== BLOQUE 5 - RESUMEN ===");

        gremio.mostrarRoster();
        gremio.mostrarCola();
        gremio.mostrarInventario();
        gremio.mostrarHabilidades();
    }
}
