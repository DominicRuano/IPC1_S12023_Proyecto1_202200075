import java.util.ArrayList;

public class kiosco {
    String Nombre;
    String Codigokiosco;
    String CodigoRegion;
    public static ArrayList<kiosco> misKioscos = new ArrayList<>();

    public kiosco(String nombre, String codigokiosco, String codigoRegion) {
        Nombre = nombre;
        Codigokiosco = codigokiosco;
        CodigoRegion = codigoRegion;
    }

    @Override
    public String toString() {
        return "kiosco{" +
                "Nombre='" + Nombre + '\'' +
                ", Codigokiosco='" + Codigokiosco + '\'' +
                ", CodigoRegion='" + CodigoRegion + '\'' +
                '}';
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getCodigokiosco() {
        return Codigokiosco;
    }

    public void setCodigokiosco(String codigokiosco) {
        Codigokiosco = codigokiosco;
    }

    public String getCodigoRegion() {
        return CodigoRegion;
    }

    public void setCodigoRegion(String codigoRegion) {
        CodigoRegion = codigoRegion;
    }
}
