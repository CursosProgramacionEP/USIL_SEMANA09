public class Main {
    public static void main(String[] args) {
        Empresa usil = new Empresa("USIL");

        usil.contratar(new Persona("Luis Rojas"));
        usil.contratar(new Persona("María Paz"));
        usil.contratar(new Persona("Jorge Díaz"));

        usil.mostrarEmpleados();
    }
}
