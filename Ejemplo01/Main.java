public class Main {
    public static void main(String[] args) {
        Direccion d = new Direccion("Av. Javier Prado 123", "San Isidro");
        Cliente c = new Cliente("Ana Torres", d);
        c.mostrar();
    }
}
