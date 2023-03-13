import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.time.LocalDate;

public class menuEnvios {
    private JTable table1;
    private JPanel MenuEnvios;
    private JButton descargarGuiaButton;
    private JComboBox cboAdd;
    private JButton descargarFacturaButton;
    private JButton regresarButton;
    public static void irMenuEnvios(){
        Main.frame.setContentPane(new menuEnvios().MenuEnvios);
        Main.frame.pack();
        Main.frame.setSize(400, 400);
    }
public menuEnvios() {

    DefaultTableModel modelo = new DefaultTableModel();

    String[] nombres = new String[]{"Codigo","Origen","Destino","Tamaño"};
    modelo.setColumnIdentifiers(nombres);

    Object[] ob = new Object[4];


    for (factura i: factura.misFacturas) {
        if (i.getIdUser() == Autenticacion.idUser){
            ob[0] = i.getNumGuia();
            ob[1] = i.getTota();
            ob[2] = i.getDestino();
            ob[3] = i.getTamanoPaquete();
            modelo.addRow(ob);
        }
    }
    table1.setModel(modelo);

    cboAdd.removeAllItems();
    for (factura i: factura.misFacturas) {
        cboAdd.addItem(i.getNumGuia());
    }


    regresarButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            menuUser.irMenuUser();
        }
    });
    descargarGuiaButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            int tem = cboAdd.getSelectedIndex();

            FileWriter archivo2 = null;
            try {
                archivo2 = new FileWriter("Guia.html");

                archivo2.write("hola");
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
            }catch (Exception E){
                System.out.println(E);
            }




        }
    });
    descargarFacturaButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            int tem = cboAdd.getSelectedIndex();
            FileWriter archivo = null;

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
            }catch (Exception E){
                System.out.println(E);
            }

        }
    });
}
}
