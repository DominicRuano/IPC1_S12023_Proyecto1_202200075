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
    public String correo = "ipc1_202200075@gmail.com";
    public String pass = "202200075";
    public static int idUser = 0;
    public boolean validarCredenciales(){
        idUser = -1;
        for (usuario i : usuario.misUsuarios) {
            idUser = i.getIdUser();
            if (txtCorreo.getText().equals(i.getCorreo()) && txtContrasena.getText().equals(i.getPassword())){
                return true;
            }
        }
        return false;
    }
    public static void irAutenticacion(){
        Main.frame.setContentPane(new Autenticacion().Autenticacion);
        Main.frame.pack();
        Main.frame.setSize(400,300);
    }
    public Autenticacion() {
        iniciarSesionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtCorreo.getText().equals(correo) && txtContrasena.getText().equals(pass)){

                    System.out.println("Inicio con usuario Master");
                    menuAdmin.irMenuadmin();

                } else if (validarCredenciales()) {
                    menuUser.irMenuUser();
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
                registroUsuarios.irRegistrousuario();
            }
        });
    }

}
