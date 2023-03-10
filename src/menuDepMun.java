import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class menuDepMun {
    private JButton regresarButton;
    private JTextField txtRegionMun;
    private JTextField txtNombreDep;
    private JTextField txtNombreMun;
    private JComboBox cboCodigoRegion;
    private JComboBox cboCodigoDep;
    private JComboBox cboAddMun;
    private JComboBox cboAddDep;
    private JButton guardarCambiosButton;
    private JButton guardarNuevoButton;
    private JButton eliminarButton;
    private JButton guardarCambiosButton1;
    private JButton guardarNuevoButton1;
    private JButton eliminarButton1;
    public JPanel DepMun;

    public static void irDepMun(){
        Main.frame.setContentPane(new menuDepMun().DepMun);
        Main.frame.pack();
        Main.frame.setSize(700,350);
    }

    public menuDepMun() {
    regresarButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            menuAdmin.irMenuadmin();
        }
    });
        guardarNuevoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
