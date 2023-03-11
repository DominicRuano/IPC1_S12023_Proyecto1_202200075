import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class menuDatosFac {
    public JPanel MenuDatosfact;
    private JComboBox cboAddUbic;
    private JTextField txtNombre;
    private JTextField txtDireccion;
    private JTextField txtNIT;
    private JButton regresarButton;
    private JButton guardarCambiosButton;
    private JButton guardarNuevoButton;
    private JButton eliminarButton;
    private void guardarDireccion(){
        if (!txtNombre.getText().equals("") && !txtDireccion.getText().equals("") && !txtNIT.getText().equals("")){

            datosFactura.misFacturas.add(new datosFactura(txtNombre.getText(),
                    txtDireccion.getText(),
                    txtNIT.getText(),
                    Autenticacion.idUser));

            txtNombre.setText("");
            txtDireccion.setText("");
            txtNIT.setText("");

            System.out.println();
            for (datosFactura i: datosFactura.misFacturas) {
                System.out.println(i);
            }

        }else {JOptionPane.showMessageDialog(Main.frame, "Por favor ingrese todos los campos.");}
    }
    private void guardarCambios(){
        if (!txtNombre.getText().equals("") && !txtDireccion.getText().equals("") && !txtNIT.getText().equals("")){

            int num = cboAddUbic.getSelectedIndex();

            datosFactura.misFacturas.get(num).setNit(txtNIT.getText());
            datosFactura.misFacturas.get(num).setDireccion(txtDireccion.getText());
            datosFactura.misFacturas.get(num).setNombre(txtNombre.getText());

            System.out.println();
            for (datosFactura i: datosFactura.misFacturas) {
                System.out.println(i);
            }

        }else {JOptionPane.showMessageDialog(Main.frame, "Por favor ingrese todos los campos.");}
    }
    private void eliminarDireccion(){
        int num = cboAddUbic.getSelectedIndex();

        datosFactura.misFacturas.remove(num);

        System.out.println();
        for (datosFactura i: datosFactura.misFacturas) {
            System.out.println(i);
        }
    }
    public static void irMenuDatosFact(){
        Main.frame.setContentPane(new menuDatosFac().MenuDatosfact);
        Main.frame.pack();
        Main.frame.setSize(500, 400);
    }
public menuDatosFac() {
    regresarButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            menuUser.irMenuUser();
        }
    });
    guardarNuevoButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            guardarDireccion();
        }
    });
    cboAddUbic.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);
            try {
                cboAddUbic.removeAllItems();

                for (datosFactura i: datosFactura.misFacturas) {
                    if (Autenticacion.idUser == i.getIdUser()){
                        cboAddUbic.addItem(i.getDireccion());
                    }

                }
            }catch (Exception E){
                System.out.println("here");
            }
        }
    });
    cboAddUbic.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            int num = cboAddUbic.getSelectedIndex();
            try {

                txtNombre.setText(datosFactura.misFacturas.get(num).getNombre());
                txtDireccion.setText(datosFactura.misFacturas.get(num).getDireccion());
                txtNIT.setText(datosFactura.misFacturas.get(num).getNit());

            }catch (Exception E){
                System.out.println("here");
            }
        }
    });
    guardarCambiosButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            guardarCambios();
        }
    });
    eliminarButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            eliminarDireccion();
        }
    });
}
}
