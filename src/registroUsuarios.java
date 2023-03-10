import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class registroUsuarios {
    private JTextField txtCorreo;
    private JTextField txtNombre;
    private JTextField txtApellido;
    private JPasswordField txtContra;
    private JTextField txtDpi;
    private JComboBox cboGenero;
    private JComboBox cboNacionalidad;
    private JTextField txtAlias;
    private JTextField txtTelefono;
    private JComboBox cboRol;
    private JButton subirFotografiaButton;
    public  JPanel registroUsuario;
    private JLabel lblImagen;
    private JButton guardarButton;
    private JTextField txtFecha;
    private JButton regresarButton;
    private String direcccion = "";

    private void crearUsuario(){
        usuario.misUsuarios.add(new usuario(txtCorreo.getText(),
                txtNombre.getText(),
                txtApellido.getText(),
                txtContra.getSelectedText(),
                txtDpi.getText(),
                txtFecha.getText(),
                cboGenero.getSelectedItem().toString(),
                cboNacionalidad.getSelectedItem().toString(),
                txtAlias.getText(),
                txtTelefono.getText(),
                cboRol.getSelectedItem().toString(),
                direcccion));
    }


    public registroUsuarios() {
    subirFotografiaButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser jFileChooser = new JFileChooser();
            FileNameExtensionFilter filtro = new FileNameExtensionFilter("JPG, PNG","JPG","PNG");
            jFileChooser.setFileFilter(filtro);

            int respuesta = jFileChooser.showOpenDialog(null);
            if (respuesta == JFileChooser.APPROVE_OPTION){
                direcccion = jFileChooser.getSelectedFile().getPath();
                Image pImagen = new ImageIcon(direcccion).getImage();
                ImageIcon pIcono = new ImageIcon(pImagen.getScaledInstance(lblImagen.getWidth(),lblImagen.getHeight(),Image.SCALE_SMOOTH));
                lblImagen.setIcon(pIcono);
            }
        }

    });

        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!txtNombre.getText().equals("") && !txtCorreo.getText().equals("") && !txtApellido.getText().equals("") &&
                        !txtContra.getText().equals("") && !txtDpi.getText().equals("") && !txtFecha.getText().equals("") &&
                        !cboGenero.getSelectedItem().equals("") && !cboNacionalidad.getSelectedItem().equals("") && !txtAlias.getText().equals("") &&
                        !cboRol.getSelectedItem().equals("") && !txtTelefono.getText().equals("") && !cboRol.getSelectedItem().equals("")){

                    if (!txtContra.getText().equals(txtContra.getText().toLowerCase()) && !txtContra.getText().equals(txtContra.getText().toUpperCase()))  {

                        if (!txtContra.getText().contains("1") || !txtContra.getText().contains("2") || !txtContra.getText().contains("3") ||
                                !txtContra.getText().contains("4") || !txtContra.getText().contains("5") || !txtContra.getText().contains("6") ||
                                !txtContra.getText().contains("7") || !txtContra.getText().contains("8") || !txtContra.getText().contains("9") ||
                                !txtContra.getText().contains("0")){

                            if (!txtContra.getText().contains("_") || !txtContra.getText().contains("-") || !txtContra.getText().contains("?") ||
                                    !txtContra.getText().contains("@") || !txtContra.getText().contains("#") || !txtContra.getText().contains("$") ||
                                    !txtContra.getText().contains("+") || !txtContra.getText().contains("&") || !txtContra.getText().contains("*") ||
                                    !txtContra.getText().contains("~")){

                                txtNombre.setText("");
                                txtCorreo.setText("");
                                txtApellido.setText("");
                                txtContra.setText("");
                                txtDpi.setText("");
                                txtAlias.setText("");
                                txtFecha.setText("");
                                cboGenero.setSelectedItem("");
                                cboNacionalidad.setSelectedItem("");
                                cboRol.setSelectedItem("");
                                txtTelefono.setText("");
                                cboRol.setSelectedItem("");


                                crearUsuario();

                                System.out.println();
                                for (usuario i : usuario.misUsuarios) {
                                    System.out.println(i);
                                }

                            }else {JOptionPane.showMessageDialog(Main.frame, "La contraseña debe contener Caracteres especiales como: @#$/?...");}
                        }else {JOptionPane.showMessageDialog(Main.frame, "La contraseña debe contenes numeros y Letras.");}
                    }else {JOptionPane.showMessageDialog(Main.frame, "La contraseña debe tener Mayusculas y Minusculas.");}
                }else {JOptionPane.showMessageDialog(Main.frame, "Ingrese todos los campos marcador con (*).");}
            }
        });
        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Autenticacion.irAutenticacion();
            }
        });
    }

}
