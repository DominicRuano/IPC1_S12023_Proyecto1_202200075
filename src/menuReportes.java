import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class menuReportes {
    private JButton regionesConMásEnvíosButton;
    private JButton paquetesEnviadosButton;
    private JButton ingresosTotalesButton;
    private JButton usuariosPaquetesButton;
    private JButton regresarButton;
    public JPanel MenuReportes;

    public static void irReportes(){
        Main.frame.setContentPane(new menuReportes().MenuReportes);
        Main.frame.pack();
        Main.frame.setSize(400,200);
    }

    public menuReportes() {
        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuAdmin.irMenuadmin();
            }
        });
    }
}
