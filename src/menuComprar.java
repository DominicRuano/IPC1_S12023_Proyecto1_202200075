import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.time.LocalDate;

public class menuComprar {
    public JPanel MenuComprar;
    private JButton regresarButton;
    private JComboBox<String> cboAddCotizacion;
    private JRadioButton pagoContraEntregaRadioButton;
    private JRadioButton tarjetaRadioButton;
    private JComboBox<String> cboTarjeta;
    private JTextField txtNumDeTarjeta;
    private JTextField txtNombreDeTarj;
    private JTextField txtFecha;
    private JTextField txtCVV;
    private JComboBox<String> cboAddFacturacion;
    private JTextField txtNombreCompleto;
    private JTextField txtDireccion;
    private JTextField txtNIT;
    private JButton pagarButton;
    private JButton generarFacturaButton;
    private JButton generarGuiaButton;
    private int valor = 1, val2 = 1, tem ;

    public static void irMenucompra(){
        Main.frame.setContentPane(new menuComprar().MenuComprar);
        Main.frame.pack();
        Main.frame.setSize(725, 300);
    }
    public void inicial(){
        for (cotizaciones i: cotizaciones.misCotizaciones) {
            cboAddCotizacion.addItem("Total: " +i.getTotal() + " Numero de Paquetes:" + i.getNumeroPaquetes());
        }
        for (datosFactura i: datosFactura.misFacturas) {
            cboAddFacturacion.addItem("Dato " + valor);
            valor += 1;
        }
        for (tarjeta i: tarjeta.misTarjetas) {
            if (Autenticacion.idUser == i.getIdUser()){
                cboTarjeta.addItem("XXXXXXXXXXXX" + i.getNumero().substring(12));
            }
        }
    }
    public String generarCodigo(){
        String codigo = "IPC1E";
        String banco = "abcdefghijklmnopqrstuvwxyz1234567890_-!@#$%^&*ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (int i = 0; i < 5; i++) {
            int numAleatorio = (int)(Math.random()*banco.length());
            codigo += banco.charAt(numAleatorio);
        }
        if (factura.misFacturas.size() > 0){
            for (factura i: factura.misFacturas) {
                if (!i.getNumGuia().equals(codigo)){
                    return codigo;
                }else {
                    System.out.println("Codigo repetido Generando uno nuevo... ");
                    return generarCodigo();
                }
            }
        }
        return codigo;
    }
public menuComprar() {

    inicial();

    regresarButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            menuUser.irMenuUser();
        }
    });
    tarjetaRadioButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            cboTarjeta.setEnabled(true);
            txtNombreDeTarj.setEnabled(true);
            txtFecha.setEnabled(true);
            txtCVV.setEnabled(true);
        }
    });
    pagoContraEntregaRadioButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            cboTarjeta.setEnabled(false);
            txtNombreDeTarj.setEnabled(false);
            txtFecha.setEnabled(false);
            txtCVV.setEnabled(false);
        }
    });
    cboTarjeta.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            int num = cboTarjeta.getSelectedIndex();

            txtNombreDeTarj.setText(tarjeta.misTarjetas.get(num).getNombre());
            txtFecha.setText(tarjeta.misTarjetas.get(num).getFecha());
        }
    });
    cboAddFacturacion.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            int num = cboAddFacturacion.getSelectedIndex();

            txtNombreCompleto.setText(datosFactura.misFacturas.get(num).getNombre());
            txtDireccion.setText(datosFactura.misFacturas.get(num).getDireccion());
            txtNIT.setText(datosFactura.misFacturas.get(num).getNit());
        }
    });
    pagarButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            generarCodigo();
            String gua = generarCodigo();
            if (!pagoContraEntregaRadioButton.isSelected()){
                if (txtCVV.getText().length() == 3){

                    factura.misFacturas.add(new factura(
                            String.valueOf(val2),
                            gua,
                            "Departamento: " +
                                    departamento.misDepartamentos.get(cotizaciones.misCotizaciones.get(cboAddCotizacion.getSelectedIndex()).getIdDepOrigen()).getNombreDep() +
                                    "   Municipio: " +
                                    municipio.misMunicipios.get(cotizaciones.misCotizaciones.get(cboAddCotizacion.getSelectedIndex()).getIdMunOrigen()).getNombreMun() +
                                    "   Direccion: " +
                                    cotizaciones.misCotizaciones.get(cboAddCotizacion.getSelectedIndex()).getDireccionOrigen(),
                            "Departamento: " +
                                    departamento.misDepartamentos.get(cotizaciones.misCotizaciones.get(cboAddCotizacion.getSelectedIndex()).getIdDepDestino()).getNombreDep() +
                                    "   Municipio: " +
                                    municipio.misMunicipios.get(cotizaciones.misCotizaciones.get(cboAddCotizacion.getSelectedIndex()).getIdMunDestino()).getNombreMun() +
                                    "   Direccion: " +
                                    cotizaciones.misCotizaciones.get(cboAddCotizacion.getSelectedIndex()).getDireccionDestino(),
                            txtNIT.getText(),
                            "Pago contra entrega",
                            cotizaciones.misCotizaciones.get(cboAddCotizacion.getSelectedIndex()).getTamanoPaquete(),
                            String.valueOf(cotizaciones.misCotizaciones.get(cboAddCotizacion.getSelectedIndex()).getNumeroPaquetes()),
                            String.valueOf(cotizaciones.misCotizaciones.get(cboAddCotizacion.getSelectedIndex()).getTotal() + 5),
                            Autenticacion.idUser));


                    System.out.println();
                    for (factura i: factura.misFacturas) {
                        System.out.println(i);
                    }

                    tem = factura.misFacturas.size();
                    val2 += 1;

                    generarFacturaButton.setEnabled(true);


                    JOptionPane.showMessageDialog(null, "Se Completo la compra por favor descarga la Factura y la guia o ingresa a ver envios para descargarlas.");
                }else {JOptionPane.showMessageDialog(null, "Por favor ingrese un CVV Valido");}

            }else {

                factura.misFacturas.add(new factura(
                        String.valueOf(val2),
                        gua,"Departamento: " +
                        departamento.misDepartamentos.get(cotizaciones.misCotizaciones.get(cboAddCotizacion.getSelectedIndex()).getIdDepOrigen()).getNombreDep() +
                        "   Municipio: " +
                        municipio.misMunicipios.get(cotizaciones.misCotizaciones.get(cboAddCotizacion.getSelectedIndex()).getIdMunOrigen()).getNombreMun() +
                        "   Direccion: " +
                        cotizaciones.misCotizaciones.get(cboAddCotizacion.getSelectedIndex()).getDireccionOrigen(),
                        "Departamento: " +
                                departamento.misDepartamentos.get(cotizaciones.misCotizaciones.get(cboAddCotizacion.getSelectedIndex()).getIdDepDestino()).getNombreDep() +
                                "   Municipio: " +
                                municipio.misMunicipios.get(cotizaciones.misCotizaciones.get(cboAddCotizacion.getSelectedIndex()).getIdMunDestino()).getNombreMun() +
                                "   Direccion: " +
                                cotizaciones.misCotizaciones.get(cboAddCotizacion.getSelectedIndex()).getDireccionDestino(),
                        txtNIT.getText(),
                        "Tarjeta",
                        cotizaciones.misCotizaciones.get(cboAddCotizacion.getSelectedIndex()).getTamanoPaquete(),
                        String.valueOf(cotizaciones.misCotizaciones.get(cboAddCotizacion.getSelectedIndex()).getNumeroPaquetes()),
                        String.valueOf(cotizaciones.misCotizaciones.get(cboAddCotizacion.getSelectedIndex()).getTotal()),
                        Autenticacion.idUser));


                System.out.println();
                for (factura i: factura.misFacturas) {
                    System.out.println(i);
                }

                tem = factura.misFacturas.size() -1;
                val2 += 1;

                generarFacturaButton.setEnabled(true);

                JOptionPane.showMessageDialog(null, "Se Completo la compra por favor descarga la Factura y la guia.");

            }

        }
    });
    generarFacturaButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            FileWriter archivo = null;
            FileWriter archivo2 = null;

            try {
                archivo = new FileWriter("Factura.html");

                archivo.write("<html><head><title>Ejemplo de archivo .html</title></head><body> \n");
                archivo.write("<h1>  FACTURA EMITIDA POR USAC-Delivery"+ "<h1>");
                archivo.write("<h1> Numero de factura: "+ factura.misFacturas.get(tem).getNumFactura() + "<h1>");
                archivo.write("<h1> Codigo de paquete: "+ factura.misFacturas.get(tem).getNumGuia() + "<h1>");
                archivo.write("<h1> Orige:  "+ factura.misFacturas.get(tem).getOrigen() + "<h1>");
                archivo.write("<h1> Destino:  "+ factura.misFacturas.get(tem).getDestino() + "<h1>");
                archivo.write("<h1> Nit: "+ factura.misFacturas.get(tem).getNit() + "<h1>");
                archivo.write("<h1> Tipo de pago: "+ factura.misFacturas.get(tem).getTipoDePago() + "<h1>");

                if (factura.misFacturas.get(tem).getTamanoPaquete().equals("1.0")){
                    archivo.write("<h1> Tamaño de Paquete: Pequeño"+"<h1>");
                } else if (factura.misFacturas.get(tem).getTamanoPaquete().equals("1.4")) {
                    archivo.write("<h1> Tamaño de Paquete: Mediano"+"<h1>");
                } else if (factura.misFacturas.get(tem).getTamanoPaquete().equals("1.7")) {
                    archivo.write("<h1> Tamaño de Paquete: Grande"+"<h1>");
                }else {
                    archivo.write("<h1> Tamaño de Paquete: Personalizado"+"<h1>");
                }

                archivo.write("<h1> Numero de paquetes: "+ factura.misFacturas.get(tem).getNumeroPaquetes() + "<h1>");
                archivo.write("<h1> Total: "+ factura.misFacturas.get(tem).getTota() + "<h1>");

                archivo.write(    "</body></html>");
                archivo.close();

                System.out.println("factura creada");


                archivo2 = new FileWriter("Guia.html");

                archivo2.write("<html><head><title>Ejemplo de archivo .html</title></head><body> \n");
                archivo2.write("<h1>  GUIA EMITIDA POR USAC-Delivery"+ "<h1>");
                archivo2.write("<h1> Codigo de paquete: "+ factura.misFacturas.get(tem).getNumGuia() + "<h1>");
                archivo2.write("<h1> Orige:  "+ factura.misFacturas.get(tem).getOrigen() + "<h1>");
                archivo2.write("<h1> Destino:  "+ factura.misFacturas.get(tem).getDestino() + "<h1>");
                archivo2.write("<h1> Tipo de pago: "+ factura.misFacturas.get(tem).getTipoDePago() + "<h1>");

                if (factura.misFacturas.get(tem).getTamanoPaquete().equals("1.0")){
                    archivo2.write("<h1> Tamaño de Paquete: Pequeño"+"<h1>");
                } else if (factura.misFacturas.get(tem).getTamanoPaquete().equals("1.4")) {
                    archivo2.write("<h1> Tamaño de Paquete: Mediano"+"<h1>");
                } else if (factura.misFacturas.get(tem).getTamanoPaquete().equals("1.7")) {
                    archivo2.write("<h1> Tamaño de Paquete: Grande"+"<h1>");
                }else {
                    archivo2.write("<h1> Tamaño de Paquete: Personalizado"+"<h1>");
                }

                archivo2.write("<h1> Numero de paquetes: "+ factura.misFacturas.get(tem).getNumeroPaquetes() + "<h1>");
                archivo2.write("<h1> Fecha: "+ LocalDate.now() + "<H1>");
                archivo2.write("<h1> Total: Q"+ factura.misFacturas.get(tem).getTota() + "<h1>");
                archivo2.write("<img src=\"Codigo de barras.jpg\">");

                archivo2.write(    "</body></html>");
                archivo2.close();

                System.out.println("Guia creada");

            }catch (Exception E){
                System.out.println(E);
            }
        }
    });
}
}
