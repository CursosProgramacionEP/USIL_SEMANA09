public class Main {
    public static void main(String[] args) {
        Estudiante e = new Estudiante("Rosa Vega");
        for (int i = 1; i <= 9; i++) {
            Curso c = new Curso("Curso " + i);
            if (!e.inscribir(c)) {
                System.out.println("No se pudo inscribir: " + c.getNombre()
                        + " (máximo 8 cursos)");
            }
        }
        e.mostrarCursos();
    }
}
