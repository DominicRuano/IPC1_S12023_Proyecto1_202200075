import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class editarUser {
    public JPanel EditarUser;
    private JTextField txtCorreo;
    private JTextField txtNombre;
    private JTextField txtApellido;
    private JPasswordField txtContra;
    private JTextField txtDpi;
    private JComboBox cboNacionalidad;
    private JTextField txtAlias;
    private JTextField txtTelefono;
    private JComboBox cboRol;
    private JLabel lblImagen;
    private JButton subirFotografiaButton;
    private JButton guardarCambiosButton;
    private JTextField txtFecha;
    private JComboBox cboGenero;
    private JButton regresarButton;
    private JButton cargarButton;
    private JButton eliminarUsuarioButton;
    private String direcccion;
    private void modificarUSer(int num){
        usuario.misUsuarios.get(num).setNombre(txtNombre.getText());
        usuario.misUsuarios.get(num).setCorreo(txtCorreo.getText());
        usuario.misUsuarios.get(num).setApellido(txtApellido.getText());
        usuario.misUsuarios.get(num).setPassword(txtContra.getText());
        usuario.misUsuarios.get(num).setDpi(txtDpi.getText());
        usuario.misUsuarios.get(num).setAlias(txtAlias.getText());
        usuario.misUsuarios.get(num).setFechaNacimiento(txtFecha.getText());
        usuario.misUsuarios.get(num).setGenero(cboGenero.getSelectedItem().toString());
        usuario.misUsuarios.get(num).setNacionalidad(cboNacionalidad.getSelectedItem().toString());
        usuario.misUsuarios.get(num).setRol(cboRol.getSelectedItem().toString());
        usuario.misUsuarios.get(num).setTelefono(txtTelefono.getText());
        usuario.misUsuarios.get(num).setFotografia(direcccion);
    }

    public static void irEditarUser(){
        Main.frame.setContentPane(new editarUser().EditarUser);
        Main.frame.pack();
        Main.frame.setSize(400, 600);
    }

public editarUser() {
    regresarButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            menuUser.irMenuUser();
        }
    });
    cargarButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            txtNombre.setText(usuario.misUsuarios.get(Autenticacion.idUser).getNombre());
            txtCorreo.setText(usuario.misUsuarios.get(Autenticacion.idUser).getCorreo());
            txtApellido.setText(usuario.misUsuarios.get(Autenticacion.idUser).getApellido());
            txtContra.setText(usuario.misUsuarios.get(Autenticacion.idUser).getPassword());
            txtDpi.setText(usuario.misUsuarios.get(Autenticacion.idUser).getDpi());
            txtAlias.setText(usuario.misUsuarios.get(Autenticacion.idUser).getAlias());
            txtFecha.setText(usuario.misUsuarios.get(Autenticacion.idUser).getFechaNacimiento());
            cboGenero.setSelectedItem(usuario.misUsuarios.get(Autenticacion.idUser).getGenero());
            cboNacionalidad.setSelectedItem(usuario.misUsuarios.get(Autenticacion.idUser).getNacionalidad());
            cboRol.setSelectedItem(usuario.misUsuarios.get(Autenticacion.idUser).getRol());
            txtTelefono.setText(usuario.misUsuarios.get(Autenticacion.idUser).getTelefono());
            Image pImagen = new ImageIcon(usuario.misUsuarios.get(Autenticacion.idUser).getFotografia()).getImage();
            ImageIcon pIcono = new ImageIcon(pImagen.getScaledInstance(lblImagen.getWidth(),lblImagen.getHeight(),Image.SCALE_SMOOTH));
            lblImagen.setIcon(pIcono);

            direcccion = usuario.misUsuarios.get(Autenticacion.idUser).getFotografia();
        }
    });
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
    guardarCambiosButton.addActionListener(new ActionListener() {
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

                            modificarUSer(Autenticacion.idUser);

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
    eliminarUsuarioButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            int num = JOptionPane.showConfirmDialog(null, "Seguro que desea eliminar su usuario?",
                    "ATENCION", JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.INFORMATION_MESSAGE);

            if (0 == num){
                usuario.misUsuarios.remove(Autenticacion.idUser);

                System.out.println();
                for (usuario i : usuario.misUsuarios) {
                    System.out.println(i);
                }

                Autenticacion.irAutenticacion();
            }else {}


        }
    });
}
}
