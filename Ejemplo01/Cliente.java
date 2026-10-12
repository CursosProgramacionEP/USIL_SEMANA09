public class Cliente {
    private String nombre;
    private Direccion direccion;      // la asociación es un atributo

    public Cliente(String nombre, Direccion direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public void mostrar() {
        System.out.println(nombre + " vive en " + direccion.getCalle()
                + ", " + direccion.getDistrito());
    }
}
