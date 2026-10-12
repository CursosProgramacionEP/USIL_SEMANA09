public class Main {
    public static void main(String[] args) {
        Mesa mesa = new Mesa("madera");     // la mesa existe por sí sola

        Sala sala1 = new Sala("Sala A");
        Sala sala2 = new Sala("Sala B");
        sala1.agregarMesa(mesa);
        sala2.agregarMesa(mesa);            // la misma parte en dos "todo"

        sala1.mostrar();
        sala1 = null;                       // desaparece la Sala A...
        System.out.println("La mesa sigue existiendo: " + mesa.getMaterial());
    }
}
