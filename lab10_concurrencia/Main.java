public class Main {
    public static void main(String[] args) {
        System.out.println("=== Gran Torneo del Gremio ===");

        System.out.println("\n=== BLOQUE 1 - COMBATES CONCURRENTES ===");
        TablaResultados tabla = new TablaResultados();

        Personaje s1 = new Druida("Sylva", 10, 300, 100);
        Personaje m1 = new Nigromante("Malachar", 8, 150, 120);
        Personaje l1 = new Arquero("Legolas", 6, 200, "Arco", 10, 95);
        Personaje t1 = new Guerrero("Thorin", 9, 400, "Hacha", 80);
        Personaje b1 = new Druida("Brego", 7, 250, 80);
        Personaje k1 = new Nigromante("Kael", 5, 180, 90);

        Thread h1 = new Thread(new CombateConcurrente("Campo-1", s1, m1, tabla));
        Thread h2 = new Thread(new CombateConcurrente("Campo-2", l1, t1, tabla));
        Thread h3 = new Thread(new CombateConcurrente("Campo-3", b1, k1, tabla));

        h1.start();
        h2.start();
        h3.start();

        System.out.println("\n=== BLOQUE 2 - MONITOR DEL TORNEO ===");
        MonitorTorneo monitor = new MonitorTorneo("Torneo Principal", 3);
        monitor.start();

        System.out.println("\n=== BLOQUE 3 - JOIN ===");
        try {
            h1.join();
            h2.join();
            h3.join();
            monitor.join();
        } catch (InterruptedException e) {
            System.out.println("Espera interrumpida.");
            Thread.currentThread().interrupt();
        }

        System.out.println("\nTodos los combates han terminado.");
        tabla.mostrarResultados();

        System.out.println("\n=== BLOQUE 4 - RACE CONDITION ===");
        ContadorCompartido contador = new ContadorCompartido();
        Thread[] hilos = new Thread[5];

        for (int i = 0; i < hilos.length; i++) {
            hilos[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++) contador.incrementar();
            });
            hilos[i].start();
        }

        try {
            for (Thread t : hilos) t.join();
        } catch (InterruptedException e) {
            System.out.println("Espera interrumpida.");
            Thread.currentThread().interrupt();
        }

        System.out.println("Sin sync - esperado: 5000 | real: " + contador.getContador());

        contador.resetear();

        for (int i = 0; i < hilos.length; i++) {
            hilos[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++) contador.incrementarSeguro();
            });
            hilos[i].start();
        }

        try {
            for (Thread t : hilos) t.join();
        } catch (InterruptedException e) {
            System.out.println("Espera interrumpida.");
            Thread.currentThread().interrupt();
        }

        System.out.println("Con sync - esperado: 5000 | real: " + contador.getContador());
    }
}
