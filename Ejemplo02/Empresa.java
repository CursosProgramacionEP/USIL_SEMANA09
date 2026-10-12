import java.util.ArrayList;

public class Empresa {
    private String nombre;
    private ArrayList<Persona> empleados;     // multiplicidad *

    public Empresa(String nombre) {
        this.nombre = nombre;
        this.empleados = new ArrayList<>();   // la lista empieza vacía
    }

    public void contratar(Persona p) {
        empleados.add(p);
    }

    public void mostrarEmpleados() {
        System.out.println("Empleados de " + nombre + ": " + empleados.size());
        for (Persona p : empleados) {
            System.out.println("- " + p.getNombre());
        }
    }
}
