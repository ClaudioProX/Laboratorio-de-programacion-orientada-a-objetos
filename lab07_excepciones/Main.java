public class Main {

    public static void main(String[] args) {

        System.out.println(
                "=== RPG - Sistema con Manejo de Excepciones ===");

        MotorCombate motor = new MotorCombate();

        Druida druida = new Druida(
                "Sylva", 8, 200,
                50, 80, "Lobo ancestral");

        Nigromante nigromante = new Nigromante(
                "Malachar", 6, 240,
                80, 10, 70);


        System.out.println(
                "\n=== Escenario 1: Turno normal ===");

        motor.ejecutarTurno(druida, nigromante);

        System.out.println(
                "\n=== Escenario 2: Personaje derrotado ===");

        try {
            druida.recibirDanio(9999);
        } catch (AccionInvalidaException e) {
            System.out.println(
                    "Error inesperado: " + e.getMessage());
        }

        motor.ejecutarTurno(druida, nigromante);

        System.out.println(
                "\n=== Escenario 3: Arquero sin flechas ===");

        Arquero sinFlechas = new Arquero(
                "Legolas", 6, 150,
                "Arco Largo", 0, 95);

        Druida defensor = new Druida(
                "Elandra", 5, 180,
                40, 50, "Oso");

        motor.ejecutarTurno(sinFlechas, defensor);

        System.out.println(
                "\n=== Escenario 4: Curar aliado derrotado ===");

        Druida druida2 = new Druida(
                "Lunara", 5, 180,
                40, 70, "Ciervo");

        Nigromante personajeDerrotado = new Nigromante(
                "Noctis", 4, 100,
                50, 3, 30);

        try {
            personajeDerrotado.recibirDanio(9999);
            druida2.curarAliado(personajeDerrotado);
        } catch (RpgException e) {
            System.out.println(
                    "No se pudo curar: " + e.getMessage());
        }

        System.out.println(
                "\n=== Escenario 5: Danio negativo ===");

        try {
            druida2.recibirDanio(-50);
        } catch (AccionInvalidaException e) {
            System.out.println(
                    "Capturado: " + e.getMessage());
        } finally {
            System.out.println(
                    "El bloque finally siempre se ejecuta.");
        }

        System.out.println(
                "\n=== Escenario 6: Bitacora completa ===");

        motor.mostrarBitacora();
    }
}
