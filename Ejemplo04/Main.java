public class Main {
    public static void main(String[] args) {
        // Aquí no se crea ningún Piso: lo hace el Edificio
        Edificio e = new Edificio("Torre USIL", 3);
        e.mostrar();

        e = null;   // si el Edificio desaparece, sus Pisos también
    }
}
