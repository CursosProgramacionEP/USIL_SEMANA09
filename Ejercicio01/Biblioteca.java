import java.util.ArrayList;

public class Biblioteca {
    private String nombre;
    // TODO 1: declara el atributo libros (ArrayList de Libro)

    public Biblioteca(String nombre) {
        this.nombre = nombre;
        // TODO 2: crea la lista vacía con new ArrayList<>()
    }

    public void agregarLibro(Libro l) {
        // TODO 3: agrega el libro a la lista
    }

    public void listarLibros() {
        System.out.println(nombre);
        // TODO 4: recorre la lista con un for y muestra "1. título - autor"
    }
}
