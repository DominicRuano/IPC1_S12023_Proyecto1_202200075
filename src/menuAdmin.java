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
public menuAdmin() {
    regresarButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Autenticacion.irAutenticacion();
        }
    });
}
}
