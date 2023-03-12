import java.util.ArrayList;

public class cotizaciones {
    private int numeroFactura;
    private int idDepOrigen;
    private int idMunOrigen;
    private String  direccionOrigen;
    private int idDepDestino;
    private int idMunDestino;
    private String direccionDestino;
    private int numeroPaquetes;
    private String tamanoPaquete;
    private double total;
    public static ArrayList<cotizaciones> misCotizaciones = new ArrayList<>();

    public cotizaciones(int numeroFactura, int idDepOrigen, int idMunOrigen, String direccionOrigen,
                        int idDepDestino, int idMunDestino, String direccionDestino, int numeroPaquetes,
                        String tamanoPaquete, double total) {
        this.numeroFactura = numeroFactura;
        this.idDepOrigen = idDepOrigen;
        this.idMunOrigen = idMunOrigen;
        this.direccionOrigen = direccionOrigen;
        this.idDepDestino = idDepDestino;
        this.idMunDestino = idMunDestino;
        this.direccionDestino = direccionDestino;
        this.numeroPaquetes = numeroPaquetes;
        this.tamanoPaquete = tamanoPaquete;
        this.total = total;
    }

    @Override
    public String toString() {
        return "cotizaciones{" +
                "numeroFactura=" + numeroFactura +
                ", idDepOrigen='" + idDepOrigen + '\'' +
                ", idMunOrigen='" + idMunOrigen + '\'' +
                ", direccionOrigen='" + direccionOrigen + '\'' +
                ", idDepDestino='" + idDepDestino + '\'' +
                ", idMunDestino='" + idMunDestino + '\'' +
                ", direccionDestino='" + direccionDestino + '\'' +
                ", numeroPaquetes=" + numeroPaquetes +
                ", tamañoPaquete='" + tamanoPaquete + '\'' +
                ", total=" + total +
                '}';
    }

    public int getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(int numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public int getIdDepOrigen() {
        return idDepOrigen;
    }

    public void setIdDepOrigen(int idDepOrigen) {
        this.idDepOrigen = idDepOrigen;
    }

    public int getIdMunOrigen() {
        return idMunOrigen;
    }

    public void setIdMunOrigen(int idMunOrigen) {
        this.idMunOrigen = idMunOrigen;
    }

    public String getDireccionOrigen() {
        return direccionOrigen;
    }

    public void setDireccionOrigen(String direccionOrigen) {
        this.direccionOrigen = direccionOrigen;
    }

    public int getIdDepDestino() {
        return idDepDestino;
    }

    public void setIdDepDestino(int idDepDestino) {
        this.idDepDestino = idDepDestino;
    }

    public int getIdMunDestino() {
        return idMunDestino;
    }

    public void setIdMunDestino(int idMunDestino) {
        this.idMunDestino = idMunDestino;
    }

    public String getDireccionDestino() {
        return direccionDestino;
    }

    public void setDireccionDestino(String direccionDestino) {
        this.direccionDestino = direccionDestino;
    }

    public int getNumeroPaquetes() {
        return numeroPaquetes;
    }

    public void setNumeroPaquetes(int numeroPaquetes) {
        this.numeroPaquetes = numeroPaquetes;
    }

    public String getTamanoPaquete() {
        return tamanoPaquete;
    }

    public void setTamanoPaquete(String tamanoPaquete) {
        this.tamanoPaquete = tamanoPaquete;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
