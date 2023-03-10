public class municipio extends departamento{
    private String codigoDeprtamento;
    private String NombreMun;

    public municipio(String codigo, String nombre, double pEspecial, double pEstandar, String codigoRegion,
                     String region, String nombreDep, String codigoDeprtamento, String nombreMun) {
        super(codigo, nombre, pEspecial, pEstandar, codigoRegion, region, nombreDep);
        this.codigoDeprtamento = codigoDeprtamento;
        NombreMun = nombreMun;
    }

    @Override
    public String toString() {
        return "municipio{" +
                "codigoDeprtamento='" + codigoDeprtamento + '\'' +
                ", NombreMun='" + NombreMun + '\'' +
                '}';
    }

    public String getCodigoDeprtamento() {
        return codigoDeprtamento;
    }

    public void setCodigoDeprtamento(String codigoDeprtamento) {
        this.codigoDeprtamento = codigoDeprtamento;
    }

    public String getNombreMun() {
        return NombreMun;
    }

    public void setNombreMun(String nombreMun) {
        NombreMun = nombreMun;
    }
}
