import java.util.ArrayList;

public class region {
    private String Codigo;
    private String nombre;
    private double pEspecial;
    private double pEstandar;
    public static ArrayList<region> misRegiones = new ArrayList<>();

    public region(String codigo, String nombre, double pEspecial, double pEstandar) {
        Codigo = codigo.toUpperCase();
        this.nombre = nombre;
        this.pEspecial = pEspecial;
        this.pEstandar = pEstandar;
    }

    @Override
    public String toString() {
        return "region{" +
                "Codigo='" + Codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", pEspecial=" + pEspecial +
                ", pEstandar=" + pEstandar +
                '}';
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String codigo) {
        Codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getpEspecial() {
        return pEspecial;
    }

    public void setpEspecial(double pEspecial) {
        this.pEspecial = pEspecial;
    }

    public double getpEstandar() {
        return pEstandar;
    }

    public void setpEstandar(double pEstandar) {
        this.pEstandar = pEstandar;
    }
}
