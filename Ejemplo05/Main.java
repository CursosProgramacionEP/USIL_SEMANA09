public class Main {
    public static void main(String[] args) {
        Futbolista f = new Futbolista("Paolo Guerrero", 9);
        LigaFutbol liga = new LigaFutbol("Liga 1");

        EquipoFutbol e = new EquipoFutbol(f, liga, "Alianza Lima", "Lima");
        e.mostrar();
    }
}
