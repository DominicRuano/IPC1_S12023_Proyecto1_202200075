import javax.swing.*;
import java.util.ArrayList;

public class Main {
    public static JFrame frame;

    public static void main(String[] args) {
        region.misRegiones.add(new region("m", "Metropolitana", 25.00, 35.00));
        region.misRegiones.add(new region("nt", "Norte", 45.55, 68.50));
        region.misRegiones.add(new region("no", "Nororiente", 35.48, 58.68));
        region.misRegiones.add(new region("so", "Suroriente", 32.48, 38.68));
        region.misRegiones.add(new region("soc", "Suroccidente", 29.00, 34.00));
        region.misRegiones.add(new region("noc", "Norocidente", 40.00, 44.50));

        usuario.misUsuarios.add(new usuario("", "", "", "", "", "",
                "", "", "", "", "", ""));
        usuario.misUsuarios.add(new usuario("22", "", "", "", "", "",
                "", "", "", "", "", ""));

        departamento.misDepartamentos.add(new departamento("","",0,0,
                "NOC","Metropolitana","Guatemala"));

        departamento.misDepartamentos.add(new departamento("","",0,0,
                "NO","Norte","Mixco"));

        municipio.misMunicipios.add(new municipio("","",0,0,"","",
                "","Mixco","1ro De Julio"));
        municipio.misMunicipios.add(new municipio("","",0,0,"","",
                "","Guatemala","Guatemala"));

        datosFactura.misFacturas.add(new datosFactura("Dominic","m 23 l 30 villas del quetzal","26795431",0));
        datosFactura.misFacturas.add(new datosFactura("Juan Pablo","avenida siempre viva 742","34256780",0));

        frame = new JFrame("USAC-Delivery");
        frame.setContentPane(new Autenticacion().Autenticacion);
        //frame.setContentPane(new registroUsuarios().registroUsuario);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setSize(400,300);

    }
}