public class Main {
    public static void main(String[] args) {
        System.out.println("=== Sistema de Transporte Multimodal ===\n");

        Automovil auto = new Automovil(
            "Toyota", "Corolla", 2022, 180.0, 4, false
        );

        Avion avion = new Avion(
            "Boeing", "737", 2019, 850.0, 2, 12500, "Aeroméxico"
        );

        Barco barco = new Barco(
            "Ferretti", "550", 2020, 45.0, "Fibra de vidrio", 30.5, 8
        );

        System.out.println("-- Automovil --");
        System.out.println(auto);

        System.out.println("\nPruebas con valores incorrectos:");
        auto.setAnio(1800);
        auto.setNumPuertas(10);
        auto.setVelocidadMax(-25);

        System.out.println("\nEl automóvil conserva sus datos anteriores:");
        System.out.println(auto);

        System.out.println("\nCorrección con valores válidos:");
        auto.setAnio(2024);
        auto.setNumPuertas(5);
        auto.setVelocidadMax(190.0);
        System.out.println(auto);

        System.out.println("\n-- Avion --");
        System.out.println(avion);
        System.out.println("Prueba inválida de altitud:");
        avion.setAltitudMaxima(-1000);
        avion.setAltitudMaxima(13000);
        System.out.println("Después de corregir:");
        System.out.println(avion);

        System.out.println("\n-- Barco --");
        System.out.println(barco);
        System.out.println("Prueba inválida de tonelaje:");
        barco.setTonelajeMaximo(-5);
        barco.setTonelajeMaximo(35.0);
        System.out.println("Después de corregir:");
        System.out.println(barco);
    }
}
