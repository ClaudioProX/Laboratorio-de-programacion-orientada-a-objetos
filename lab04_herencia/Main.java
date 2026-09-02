public class Main {
    public static void main(String[] args) {
        Guerrero guerrero = new Guerrero(
                "Thorin", 5, 200, 85, "Cota de Malla");

        Mago mago = new Mago(
                "Gandalf", 8, 150, 120, "Fuego");

        Arquero arquero = new Arquero(
                "Legolas", 6, 120, "Arco élfico", 95);

        Personaje[] personajes = {guerrero, mago, arquero};

        System.out.println("=== Batalla RPG ===");

        System.out.println("\n-- Ronda 1: Ataques --");
        for (Personaje personaje : personajes) {
            personaje.atacar();
            System.out.println();
        }

        System.out.println("-- Ronda 2: Defensas --");
        for (Personaje personaje : personajes) {
            personaje.defender();
        }

        System.out.println("\n-- Daño recibido --");
        guerrero.recibirDanio(60);
        mago.recibirDanio(200);

        System.out.println("\n-- Estado final --");
        for (Personaje personaje : personajes) {
            System.out.println(personaje);
        }
    }
}
