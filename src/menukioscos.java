import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class menukioscos {
    public JPanel MenuKioscos;
    private JTextField txtCodigo;
    private JTextField txtNombre;
    private JButton regresarButton;
    private JButton guardarCambiosButton;
    private JButton guardarNuevoButton;
    private JButton eliminarButton;
    private JComboBox cboAddKiosco;
    private JComboBox cboRegion;
    private void guardarKiosco(){
        if (!txtCodigo.getText().equals("") && !txtNombre.getText().equals("")){
            kiosco.misKioscos.add(new kiosco(txtNombre.getText(),txtCodigo.getText(), cboRegion.getSelectedItem().toString()));

            txtNombre.setText("");
            txtCodigo.setText("");

            System.out.println();
            for (kiosco i: kiosco.misKioscos) {
                System.out.println(i);
            }
        }else {JOptionPane.showMessageDialog(Main.frame, "Por favor ingrese todos los campos.");}
    }
    private void modificarKioco(int num){
        if (!txtCodigo.getText().equals("") && !txtNombre.getText().equals("")){
            kiosco.misKioscos.get(num).setCodigokiosco(txtCodigo.getText());
            kiosco.misKioscos.get(num).setNombre(txtNombre.getText());
            kiosco.misKioscos.get(num).setCodigoRegion(cboRegion.getSelectedItem().toString());

            System.out.println();
            for (kiosco i: kiosco.misKioscos) {
                System.out.println(i);
            }
        }else {JOptionPane.showMessageDialog(Main.frame, "Por favor ingrese todos los campos.");}
    }
    private void eliminiarKiosco(int num){
        kiosco.misKioscos.remove(num);

        txtNombre.setText("");
        txtCodigo.setText("");

        System.out.println();
        for (kiosco i: kiosco.misKioscos) {
            System.out.println(i);
        }
    }
    public static void irMenuKiosco(){
        Main.frame.setContentPane(new menukioscos().MenuKioscos);
        Main.frame.pack();
        Main.frame.setSize(450,350);
    }

    public menukioscos() {
    regresarButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            menuAdmin.irMenuadmin();
        }
    });
        guardarNuevoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarKiosco();
            }
        });
        cboAddKiosco.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                cboAddKiosco.removeAllItems();
                for (kiosco i : kiosco.misKioscos) {
                    cboAddKiosco.addItem(i.getNombre());
                }
            }
        });
        cboAddKiosco.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int num = cboAddKiosco.getSelectedIndex();
                try {
                    txtCodigo.setText(kiosco.misKioscos.get(num).getCodigokiosco());
                    txtNombre.setText(kiosco.misKioscos.get(num).getCodigokiosco());
                    cboRegion.setSelectedItem(kiosco.misKioscos.get(num).getCodigoRegion());
                }catch (Exception E){
                    System.out.println("Here.");
                }
            }
        });
        guardarCambiosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int num = cboAddKiosco.getSelectedIndex();
                try {
                    modificarKioco(num);
                }catch (Exception E){
                    System.out.println("Here");
                }
            }
        });
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int num = cboAddKiosco.getSelectedIndex();
                eliminiarKiosco(num);
            }
        });
        cboRegion.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                cboRegion.removeAllItems();

                for (region i: region.misRegiones) {
                    cboRegion.addItem(i.getCodigo());
                }
            }
        });
    }
}
