import java.util.ArrayList;

public class factura {
    private String numFactura;
    private String numGuia;
    private String origen;
    private String destino;
    private String nit;
    private String tipoDePago;
    private String tamanoPaquete;
    private final String numeroPaquetes;
    private String tota;
    private int idUser;
    public static ArrayList<factura> misFacturas = new ArrayList<>();

    public factura(String numFactura, String numGuia, String origen, String destino, String nit, String tipoDePago,
                   String tamanoPaquete, String numeroPaquetes, String tota, int iduser) {
        this.numFactura = numFactura;
        this.numGuia = numGuia;
        this.origen = origen;
        this.destino = destino;
        this.nit = nit;
        this.tipoDePago = tipoDePago;
        this.tamanoPaquete = tamanoPaquete;
        this.numeroPaquetes = numeroPaquetes;
        this.tota = tota;
        this.idUser = iduser;
    }

    @Override
    public String toString() {
        return "factura{" +
                "numFactura='" + numFactura + '\'' +
                ", numGuia='" + numGuia + '\'' +
                ", origen='" + origen + '\'' +
                ", destino='" + destino + '\'' +
                ", nit='" + nit + '\'' +
                ", tipoDePago='" + tipoDePago + '\'' +
                ", tamanoPaquete='" + tamanoPaquete + '\'' +
                ", numeroPaquetes='" + numeroPaquetes + '\'' +
                ", tota='" + tota + '\'' +
                ", idUser=" + idUser +
                '}';
    }

    public String getNumGuia() {
        return numGuia;
    }

    public String getNumFactura() {
        return numFactura;
    }

    public String getOrigen() {
        return origen;
    }

    public String getDestino() {
        return destino;
    }

    public String getNit() {
        return nit;
    }

    public String getTipoDePago() {
        return tipoDePago;
    }

    public String getTamanoPaquete() {
        return tamanoPaquete;
    }

    public String getNumeroPaquetes() {
        return numeroPaquetes;
    }

    public String getTota() {
        return tota;
    }

    public int getIdUser() {
        return idUser;
    }
}
