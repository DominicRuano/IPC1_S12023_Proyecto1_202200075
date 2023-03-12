import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class menuUser {
    private JButton cerrarSesionButton;
    private JButton cambiarDatosButton;
    private JButton tarjetasCreditoDebitoButton;
    private JButton datosDeFacturacionButton;
    private JButton cotizarButton;
    private JButton comprarButton;
    private JButton descargarFacturaGuiaButton;
    private JButton enviosSolicitadosButton;
    private JPanel MenuUser;
    public static void irMenuUser(){
        Main.frame.setContentPane(new menuUser().MenuUser);
        Main.frame.pack();
        Main.frame.setSize(600, 200);
    }

    public menuUser() {
        cerrarSesionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Autenticacion.irAutenticacion();
            }
        });
        cambiarDatosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editarUser.irEditarUser();
            }
        });
        tarjetasCreditoDebitoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuTarjetas.irMenuTarjetas();
            }
        });
        datosDeFacturacionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuDatosFac.irMenuDatosFact();
            }
        });
        cotizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuCotizar.irMenuCoticar();
            }
        });
    }
}
