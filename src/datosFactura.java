import java.util.ArrayList;

public class datosFactura {
    private String nombre;
    private String direccion;
    private String Nit;
    private int idUser;
    public static ArrayList<datosFactura> misFacturas = new ArrayList<>();

    public datosFactura(String nombre, String direccion, String nit, int idUser) {
        this.nombre = nombre;
        this.direccion = direccion;
        Nit = nit;
        this.idUser = idUser;
    }

    @Override
    public String toString() {
        return "datoFact{" +
                "nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", Nit='" + Nit + '\'' +
                ", idUser=" + idUser +
                '}';
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNit() {
        return Nit;
    }

    public void setNit(String nit) {
        Nit = nit;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
}
