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
    public String correo = "";
    public String pass = "";
    public boolean validarCredenciales(){
        for (usuario i : usuario.misUsuarios) {
            if (txtCorreo.getText().equals(i.getCorreo()) && txtContrasena.getText().equals(i.getPassword())){
                return true;
            }
        }
        return false;
    }
    public static void irAutenticacion(){
        Main.frame.setContentPane(new Autenticacion().Autenticacion);
        Main.frame.pack();
        Main.frame.setSize(400,500);
    }
    public Autenticacion() {
        iniciarSesionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtCorreo.getText().equals(correo) && txtContrasena.getText().equals(pass)){

                    System.out.println("Inicio con usuario Master");

                    Main.frame.setContentPane(new menuAdmin().MenuAdmin);
                    Main.frame.pack();
                    Main.frame.setSize(500,300);

                } else if (validarCredenciales()) {
                    //funcion para ir al menu de usuarios
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
