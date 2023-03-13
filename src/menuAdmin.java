import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class menuAdmin {
    private JButton kioscosButton;
    private JButton regionesYPreciosButton;
    private JButton departamentosYMunicipiosButton;
    private JButton reportesButton;
    public JPanel MenuAdmin;
    private JButton regresarButton;
    public static void irMenuadmin(){
        Main.frame.setContentPane(new menuAdmin().MenuAdmin);
        Main.frame.pack();
        Main.frame.setSize(450,200);
    }
public menuAdmin() {
    regresarButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Autenticacion.irAutenticacion();
        }
    });
    kioscosButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            menukioscos.irMenuKiosco();
        }
    });
    regionesYPreciosButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            RegionesPrecios.irRegionesYp();
        }
    });
    departamentosYMunicipiosButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            menuDepMun.irDepMun();
        }
    });
    reportesButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            reportePaquetes.irReportes();
        }
    });
}
}
