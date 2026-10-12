public class Main {
    public static void main(String[] args) {
        Biblioteca b = new Biblioteca("Biblioteca USIL");
        b.agregarLibro(new Libro("Java en 24 horas", "Ana Soto"));
        b.agregarLibro(new Libro("Algoritmos y estructuras", "Luis Joyanes"));
        b.agregarLibro(new Libro("POO paso a paso", "Carla Mena"));
        b.listarLibros();
    }
}
