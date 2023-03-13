import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class reportePaquetes {
    private JTable table1;
    private JPanel panel1;
    private JButton regresarButton;
    private JTextField textField1;
    private JTextField textField2;
    public static void irReportes(){
        Main.frame.setContentPane(new reportePaquetes().panel1);
        Main.frame.pack();
        Main.frame.setSize(600, 300);
    }

    public reportePaquetes() {

    DefaultTableModel modelo = new DefaultTableModel();

    String[] nombres = new String[]{"Codigo","Origen","Destino","Tamaño"};
    modelo.setColumnIdentifiers(nombres);

    Object[] ob = new Object[4];


    for (factura i: factura.misFacturas) {
        ob[0] = i.getNumGuia();
        ob[1] = i.getTota();
        ob[2] = i.getDestino();
        ob[3] = i.getTamanoPaquete();
        modelo.addRow(ob);
    }
        int num = 0, num1 = 0;

        for (factura i: factura.misFacturas) {
            num = num + Integer.parseInt(i.getTota());
            num1 = num1 + Integer.parseInt(i.getNumeroPaquetes());
        }
    
    textField1.setText(String.valueOf(num));
    textField2.setText(String.valueOf(num1));


    regresarButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            menuAdmin.irMenuadmin();
        }
    });
}
}
