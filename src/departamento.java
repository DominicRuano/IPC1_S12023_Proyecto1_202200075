import java.util.ArrayList;

public class departamento extends region{
    private String codigoRegion;
    private String region;
    private String nombreDep;
    public static ArrayList<departamento> misDepartamentos = new ArrayList<>();

    public departamento(String codigo, String nombre, double pEspecial, double pEstandar, String codigoRegion,
                        String region, String nombreDep) {
        super(codigo, nombre, pEspecial, pEstandar);
        this.codigoRegion = codigoRegion;
        this.region = region;
        this.nombreDep = nombreDep;
    }

    @Override
    public String toString() {
        return "departamento{" +
                "codigoRegion='" + codigoRegion + '\'' +
                ", region='" + region + '\'' +
                ", nombreDep='" + nombreDep + '\'' +
                '}';
    }

    public String getCodigoRegion() {
        return codigoRegion;
    }

    public void setCodigoRegion(String codigoRegion) {
        this.codigoRegion = codigoRegion;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getNombreDep() {
        return nombreDep;
    }

    public void setNombreDep(String nombreDep) {
        this.nombreDep = nombreDep;
    }
}
