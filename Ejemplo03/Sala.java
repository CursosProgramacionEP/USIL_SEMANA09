import java.util.ArrayList;

public class Sala {
    private String nombre;
    private ArrayList<Mesa> mesas = new ArrayList<>();

    public Sala(String nombre) {
        this.nombre = nombre;
    }

    public void agregarMesa(Mesa m) {     // la mesa llega ya creada
        mesas.add(m);
    }

    public void mostrar() {
        System.out.println(nombre + " tiene " + mesas.size() + " mesa(s)");
    }
}
