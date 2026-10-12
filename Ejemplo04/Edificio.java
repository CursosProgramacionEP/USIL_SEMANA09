import java.util.ArrayList;

public class Edificio {
    private String nombre;
    private ArrayList<Piso> pisos = new ArrayList<>();

    public Edificio(String nombre, int cantidadPisos) {
        this.nombre = nombre;
        for (int i = 1; i <= cantidadPisos; i++) {
            pisos.add(new Piso(i));          // el Edificio crea sus Pisos
        }
    }

    public void mostrar() {
        System.out.println(nombre + " tiene " + pisos.size() + " pisos:");
        for (Piso p : pisos) {
            System.out.println("- Piso " + p.getNumero());
        }
    }
}
