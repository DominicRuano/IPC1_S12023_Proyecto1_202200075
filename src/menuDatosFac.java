import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
            guardarDireccion(){

            }
        }
    });
}
}
