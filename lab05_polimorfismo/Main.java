public class Main {
    public static void main(String[] args) {
        System.out.println("=== RPG - Demostración de Polimorfismo ===");

        // 3a. Referencias padre apuntando a objetos hijo.
        Personaje p1 = new Guerrero("Thorin", 5, 200, 85, "Cota de Malla");
        Personaje p2 = new Mago("Gandalf", 8, 120, 150, "Fuego");
        Personaje p3 = new Arquero("Legolas", 6, 150, "Arco Largo", 30, 95);

        System.out.println("\n-- calcularDanio() por tipo --");
        System.out.println(p1.getNombre() + " (Guerrero) daño: " + p1.calcularDanio());
        System.out.println(p2.getNombre() + " (Mago) daño: " + p2.calcularDanio());
        System.out.println(p3.getNombre() + " (Arquero) daño: " + p3.calcularDanio());

        // 3b. Arreglo polimórfico.
        Personaje[] equipo = {p1, p2, p3};
        System.out.println("\n-- Arreglo polimórfico --");
        for (Personaje p : equipo) {
            System.out.println(p.getNombre() + " daño: " + p.calcularDanio());
        }

        // 3c. Las tres sobrecargas del gestor.
        GestorBatalla gestor = new GestorBatalla();

        System.out.println("\n-- GestorBatalla: sobrecarga 1 --");
        gestor.ejecutarAtaque(p1);

        System.out.println("\n-- GestorBatalla: sobrecarga 2 --");
        gestor.ejecutarAtaque(p2, p3);

        System.out.println("\n-- GestorBatalla: sobrecarga 3 --");
        gestor.ejecutarAtaque(equipo);

        gestor.mostrarHistorial();

        // 3d. Identificación del tipo real con instanceof.
        System.out.println("\n-- instanceof --");
        for (Personaje p : equipo) {
            if (p instanceof Guerrero) {
                System.out.println(p.getNombre() + " es un Guerrero.");
            } else if (p instanceof Mago) {
                System.out.println(p.getNombre() + " es un Mago.");
            } else if (p instanceof Arquero) {
                System.out.println(p.getNombre() + " es un Arquero.");
            }
        }

        // Parte 4. Sobrecarga adicional propia.
        System.out.println("\n-- Sobrecarga adicional: mostrarEstado() --");
        p1.mostrarEstado();
        p1.mostrarEstado(true);
        p1.mostrarEstado("[ESTADO DETALLADO]");

        System.out.println("\n-- Limpieza del historial --");
        gestor.limpiarHistorial();
        gestor.mostrarHistorial();
    }
}
