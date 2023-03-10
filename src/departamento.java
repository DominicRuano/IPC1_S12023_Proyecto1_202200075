import java.util.ArrayList;

public class departamento extends region{
    private String codigoRegionDep;
    private String regionDep;
    private String nombreDep;
    public static ArrayList<departamento> misDepartamentos = new ArrayList<>();


    public departamento(String codigo, String nombre, double pEspecial, double pEstandar, String codigoRegionDep, String regionDep, String nombreDep) {
        super(codigo, nombre, pEspecial, pEstandar);
        this.codigoRegionDep = codigoRegionDep;
        this.regionDep = regionDep;
        this.nombreDep = nombreDep;
    }

    @Override
    public String toString() {
        return "departamento{" +
                "codigoRegionDep='" + codigoRegionDep + '\'' +
                ", regionDep='" + regionDep + '\'' +
                ", nombreDep='" + nombreDep + '\'' +
                '}';
    }

    public String getCodigoRegionDep() {
        return codigoRegionDep;
    }

    public void setCodigoRegionDep(String codigoRegionDep) {
        this.codigoRegionDep = codigoRegionDep;
    }

    public String getRegionDep() {
        return regionDep;
    }

    public void setRegionDep(String regionDep) {
        this.regionDep = regionDep;
    }

    public String getNombreDep() {
        return nombreDep;
    }

    public void setNombreDep(String nombreDep) {
        this.nombreDep = nombreDep;
    }
}
