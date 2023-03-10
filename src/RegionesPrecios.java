import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RegionesPrecios {
    private JPanel RegYPre;
    private JButton regresarButton;
    private JTextField txtCodigo;
    private JTextField txtNombre;
    private JTextField txtPEspecial;
    private JButton guardarCambiosButton;
    private JButton guardarNuevoButton;
    private JButton eliminarButton;
    private JTextField txtPEstandar;
    private JComboBox cboAddRegion;

    private void GuardarRegion(){
        if (!txtCodigo.getText().equals("") && !txtNombre.getText().equals("") &&
                txtPEspecial.getText().equals("") && !txtPEstandar.getText().equals("")){
            try {
                region.misRegiones.add(new region(txtCodigo.getText(), txtNombre.getText(),
                        Integer.parseInt(txtPEspecial.getText()), Integer.parseInt(txtPEstandar.getText())));

                System.out.println();
                for (region i: region.misRegiones) {
                    System.out.println(i);
                }

            }catch (Exception E){
                JOptionPane.showMessageDialog(Main.frame, "Los campos de precio deben se numeros.");
            }
        }else {JOptionPane.showMessageDialog(Main.frame, "Por favor llene todos los campos.");}
    }
    private void modificarRegion(int num){
        if (!txtCodigo.getText().equals("") && !txtNombre.getText().equals("") &&
                txtPEspecial.getText().equals("") && !txtPEstandar.getText().equals("")){

            try {
                region.misRegiones.get(num).setCodigo(txtCodigo.getText());
                region.misRegiones.get(num).setNombre(txtNombre.getText());
                region.misRegiones.get(num).setpEspecial(Integer.parseInt(txtPEspecial.getText()));
                region.misRegiones.get(num).setpEstandar(Integer.parseInt(txtPEstandar.getText()));
            }catch (Exception E){JOptionPane.showMessageDialog(Main.frame, "Los campos de precio deben se numeros.");}

        System.out.println();
        for (region i : region.misRegiones) {
            System.out.println(i);
        }

        }else {JOptionPane.showMessageDialog(Main.frame, "Por favor llene todos los campos.");}
    }
    private void eliminarRegion(int num){
        region.misRegiones.remove(num);
    }

    public RegionesPrecios() {
    regresarButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            menuAdmin.irMenuadmin();
        }
    });
        guardarNuevoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuardarRegion();
            }
        });
        guardarCambiosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int num = cboAddRegion.getSelectedIndex();

                modificarRegion(num);
            }
        });
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int num = cboAddRegion.getSelectedIndex();

                eliminarRegion(num);
            }
        });
        cboAddRegion.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                cboAddRegion.removeAllItems();

                for (region i: region.misRegiones) {
                    cboAddRegion.addItem(i.getNombre());
                }

            }
        });
        cboAddRegion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int num = cboAddRegion.getSelectedIndex();

                txtCodigo.setText(region.misRegiones.get(num).getCodigo());
                txtNombre.setText(region.misRegiones.get(num).getNombre());
                txtPEspecial.setText(String.valueOf(region.misRegiones.get(num).getpEspecial()));
                txtPEstandar.setText(String.valueOf(region.misRegiones.get(num).getpEstandar()));
            }
        });
    }
}
