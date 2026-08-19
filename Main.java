public class Main {
    public static void main(String[] args) {
        Perro perro = new Perro("Max", 3, 12.5, "Labrador", true);
        Gato gato = new Gato("Misi", 2, 3.8, "Gris", true);
        Canario canario = new Canario("Pico", 1, 0.03, "Amarillo", true);

        System.out.println("=== Clínica Veterinaria ===");

        System.out.println("\n-- Perro --");
        System.out.println(perro);
        perro.comer();
        perro.ladrar();
        perro.buscarPelota();

        System.out.println("\n-- Gato --");
        System.out.println(gato);
        gato.dormir();
        gato.maullar();
        gato.ronronear();

        System.out.println("\n-- Canario --");
        System.out.println(canario);
        canario.comer();
        canario.cantar();
        canario.volar();
    }
}

/*
PREGUNTAS DE REFLEXIÓN

1. ¿Por qué declaramos los atributos como private y no como public?
Porque private aplica encapsulamiento: evita que otras clases modifiquen directamente
el estado del objeto. El acceso puede controlarse mediante getters y setters.

2. ¿Qué pasaría si quitaras el super() del constructor de Perro?
En este programa se produciría un error de compilación, porque Animal no tiene un
constructor vacío. Perro debe llamar a super(nombre, edad, peso) para inicializar
los atributos heredados.

3. ¿Qué ventaja tiene sobreescribir toString() en lugar de crear un método con otro nombre?
toString() es un método estándar heredado de Object. Al sobrescribirlo,
System.out.println(objeto) puede mostrar automáticamente una representación útil
del objeto y se aprovecha el polimorfismo.
*/
