public class Direccion {
    private String calle;
    private String distrito;

    public Direccion(String calle, String distrito) {
        this.calle = calle;
        this.distrito = distrito;
    }

    public String getCalle() { return calle; }
    public String getDistrito() { return distrito; }
}
