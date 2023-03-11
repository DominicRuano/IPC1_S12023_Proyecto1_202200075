import java.util.ArrayList;

public class tarjeta {
    private String Nombre;
    private String numero;
    private String fecha;
    private  int idUser;
    public static ArrayList<tarjeta> misTarjetas = new ArrayList<>();

    public tarjeta(String nombre, String numero, String fecha, int idUser) {
        Nombre = nombre;
        this.numero = numero;
        this.fecha = fecha;
        this.idUser = idUser;
    }

    @Override
    public String toString() {
        return "tarjeta{" +
                "Nombre='" + Nombre + '\'' +
                ", numero='" + numero + '\'' +
                ", fecha='" + fecha + '\'' +
                ", idUser=" + idUser +
                '}';
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
}
