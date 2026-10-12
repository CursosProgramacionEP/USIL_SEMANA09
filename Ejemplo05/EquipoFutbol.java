// Clase de asociación: guarda información de la relación Futbolista - LigaFutbol
public class EquipoFutbol {
    private Futbolista futbolista;
    private LigaFutbol liga;
    private String nombre;
    private String ciudad;

    public EquipoFutbol(Futbolista futbolista, LigaFutbol liga,
                        String nombre, String ciudad) {
        this.futbolista = futbolista;
        this.liga = liga;
        this.nombre = nombre;
        this.ciudad = ciudad;
    }

    public void mostrar() {
        System.out.println(futbolista.getNombre() + " juega en " + nombre
                + " (" + ciudad + ") de la " + liga.getNombre());
    }
}
