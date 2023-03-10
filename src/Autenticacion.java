import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Autenticacion{
    public JPanel Autenticacion;
    private JTextField txtCorreo;
    private JPasswordField txtContrasena;
    private JLabel correoLabel;
    private JLabel contrasenaLabel;
    private JButton iniciarSesionButton;
    private JButton crearUsuarioButton;
    public String correo = "11";
    public String pass = "11";
    public Autenticacion() {
        iniciarSesionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtCorreo.getText().equals(correo) && txtContrasena.getText().equals(pass)){
                    System.out.println("Inicio con usuario Master");
                    //frame = new JFrame("Ingreso de Credenciales");
                    Main.frame.setContentPane(new registroUsuarios().registroUsuario);
                    Main.frame.pack();
                    Main.frame.setSize(500,600);

                } else {
                    System.out.println("Credenciales incorrectas");

                    txtContrasena.setText("");
                    JOptionPane.showMessageDialog(Main.frame,"Credenciales incorrectas");
                }
            }
        });
        crearUsuarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.setContentPane(new registroUsuarios().registroUsuario);
                Main.frame.pack();
                Main.frame.setSize(500,600);
            }
        });
    }

}
