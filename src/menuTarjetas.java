import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class menuTarjetas {
    public JPanel MenuTarjetas;
    private JTextField txtNombre;
    private JTextField txtNumero;
    private JTextField txtFecha;
    private JButton regresarButton;
    private JComboBox cboAddTarjeta;
    private JButton guardarCambiosButton;
    private JButton guardarNuevoButton;
    private JButton eliminarButton;
    private void guardarTarjeta(){
        if (!txtNombre.getText().equals("") && !txtNumero.getText().equals("") && !txtFecha.getText().equals("")) {
            if (txtNumero.getText().length() == 16){
                tarjeta.misTarjetas.add(new tarjeta(txtNombre.getText(),txtNumero.getText(),txtFecha.getText(),Autenticacion.idUser));

                txtNumero.setText("");
                txtNombre.setText("");
                txtFecha.setText("");

                System.out.println();
                for (tarjeta i: tarjeta.misTarjetas) {
                    System.out.println(i);
                }
            }else{JOptionPane.showMessageDialog(Main.frame, "El numero de Tarjeta deber ser igual a 16 digitos");}
        }else {JOptionPane.showMessageDialog(Main.frame, "Por favor ingrese todos los campos");}
    }
    private void modificarTarjeta(){
        int num = cboAddTarjeta.getSelectedIndex();

        if (!txtNombre.getText().equals("") && !txtNumero.getText().equals("") && !txtFecha.getText().equals("")) {
            if (txtNumero.getText().length() == 16){
                tarjeta.misTarjetas.get(num).setNombre(txtNombre.getText());
                tarjeta.misTarjetas.get(num).setNumero(txtNumero.getText());
                tarjeta.misTarjetas.get(num).setFecha(txtFecha.getText());

                System.out.println();
                for (tarjeta i : tarjeta.misTarjetas) {
                    System.out.println(i);
                }
            }else{JOptionPane.showMessageDialog(Main.frame, "El numero de Tarjeta deber ser igual a 16 digitos");}
        }else {JOptionPane.showMessageDialog(Main.frame, "Por favor ingrese todos los campos");}
    }
    private void eliminiarTarjeta(){
        int num = cboAddTarjeta.getSelectedIndex();

        tarjeta.misTarjetas.remove(num);

        System.out.println();
        for (tarjeta i: tarjeta.misTarjetas) {
            System.out.println(i);
        }
    }
    public static void irMenuTarjetas(){
        Main.frame.setContentPane(new menuTarjetas().MenuTarjetas);
        Main.frame.pack();
        Main.frame.setSize(450, 325);
    }

    public menuTarjetas() {
        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuUser.irMenuUser();
            }
        });
        guardarNuevoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarTarjeta();
            }
        });
        guardarCambiosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    modificarTarjeta();
                }catch (Exception E){
                    System.out.println("here");
                }
            }
        });
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminiarTarjeta();
            }
        });
        cboAddTarjeta.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    cboAddTarjeta.removeAllItems();

                    for (tarjeta i: tarjeta.misTarjetas) {

                        if (Autenticacion.idUser == i.getIdUser()){
                            String num = "XXXXXXXXXXXX" + i.getNumero().substring(i.getNumero().length()-4);

                            cboAddTarjeta.addItem(num);
                        }
                    }
                }catch (Exception E){
                    System.out.println("here");
                }

            }
        });
        cboAddTarjeta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int num = cboAddTarjeta.getSelectedIndex();

                txtNombre.setText(tarjeta.misTarjetas.get(num).getNombre());
                txtNumero.setText(tarjeta.misTarjetas.get(num).getNumero());
                txtFecha.setText(tarjeta.misTarjetas.get(num).getFecha());
            }
        });
    }
}
