import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;

public class menuCotizar {
    public JPanel MenuCotizar;
    private JButton regresarButton;
    private JComboBox cboOrigenDep;
    private JComboBox cboOrigenMun;
    private JSpinner spinnerNumPaq;
    private JRadioButton pequeño110LibrasRadioButton;
    private JRadioButton mediano1150LibrasRadioButton;
    private JRadioButton grande50LibrasRadioButton;
    private JButton realizarCotizacionButton;
    private JRadioButton estandarRadioButton;
    private JRadioButton especialRadioButton;
    private JTextField txtPEstandar;
    private JTextField txtPEspecial;
    private JTextField txtTotal;
    private JComboBox cboDestDep;
    private JComboBox cboDestMun;
    private JComboBox cboOrigenDir;
    private JComboBox cboDestDir;
    private JButton guardarButton;
    private JButton irAComprarButton;
    private int cont= 1;
    private double tamanoPaquete = 0;
    private double total;

    public static void irMenuCoticar(){
        Main.frame.setContentPane(new menuCotizar().MenuCotizar);
        Main.frame.pack();
        Main.frame.setSize(650, 500);
    }

    public menuCotizar() {
        for (datosFactura i: datosFactura.misFacturas) {
            cboDestDir.addItem(i.getDireccion());
            cboOrigenDir.addItem(i.getDireccion());
        }

        SpinnerNumberModel sp = new SpinnerNumberModel();

        sp.setMinimum(0);
        sp.setMaximum(99);
        sp.setStepSize(1);
        spinnerNumPaq.setModel(sp);

        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuUser.irMenuUser();
            }
        });
        cboOrigenDep.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                try {

                    cboOrigenDep.removeAllItems();

                    for (departamento i : departamento.misDepartamentos) {
                        cboOrigenDep.addItem(i.getNombreDep());
                    }
                } catch (Exception E) {
                    System.out.println("here");
                }
            }
        });
        cboOrigenDep.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int num = cboOrigenDep.getSelectedIndex();

                try {
                    cboOrigenMun.removeAllItems();

                    for (municipio i: municipio.misMunicipios) {
                        if (departamento.misDepartamentos.get(num).getNombreDep().equals(i.getCodigoDeprtamento())){
                            cboOrigenMun.addItem(i.getNombreMun());
                        }
                    }
                }catch (Exception E){
                    System.out.println("here");
                }

            }
        });
        cboDestDep.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {

                    cboDestDep.removeAllItems();

                    for (departamento i : departamento.misDepartamentos) {
                        cboDestDep.addItem(i.getNombreDep());
                    }
                } catch (Exception E) {
                    System.out.println("here");
                }
            }
        });
        cboDestDep.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int num = cboDestDep.getSelectedIndex();

                try {
                    cboDestMun.removeAllItems();

                    for (municipio i: municipio.misMunicipios) {
                        if (departamento.misDepartamentos.get(num).getNombreDep().equals(i.getCodigoDeprtamento())){
                            cboDestMun.addItem(i.getNombreMun());
                        }
                    }
                }catch (Exception E){
                    System.out.println("here");
                }

                for (region i: region.misRegiones) {
                    if (i.getCodigo().equals(departamento.misDepartamentos.get(num).getCodigoRegionDep())){
                        txtPEstandar.setText(String.valueOf(i.getpEstandar()));
                        txtPEspecial.setText(String.valueOf(i.getpEspecial()));
                    }
                }
            }
        });
        realizarCotizacionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int num = cboDestDep.getSelectedIndex();

                double pRegion = 0;

                double numPaquetes = Integer.parseInt(spinnerNumPaq.getValue().toString());

                for (region i: region.misRegiones) {
                    if (estandarRadioButton.isSelected()){
                        if (i.getCodigo().equals(departamento.misDepartamentos.get(num).getCodigoRegionDep())){
                            pRegion = i.getpEstandar();
                        }
                    } else if (especialRadioButton.isSelected()) {
                        if (i.getCodigo().equals(departamento.misDepartamentos.get(num).getCodigoRegionDep())){
                            pRegion = i.getpEspecial();
                        }
                    }
                }

                if (pequeño110LibrasRadioButton.isSelected()){
                    tamanoPaquete = 1;
                } else if (mediano1150LibrasRadioButton.isSelected()) {
                    tamanoPaquete = 1.4;
                } else if (grande50LibrasRadioButton.isSelected()) {
                    tamanoPaquete = 1.7;
                }

                DecimalFormat DF = new DecimalFormat("#.00");

                total = pRegion * tamanoPaquete * numPaquetes;

                txtTotal.setText(String.valueOf(DF.format(total)));
            }
        });
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!txtTotal.getText().equals("") && !txtTotal.getText().equals(".00")){
                    cotizaciones.misCotizaciones.add(new cotizaciones(
                            cont,
                            cboOrigenDep.getSelectedIndex(),
                            cboOrigenMun.getSelectedIndex(),
                            cboOrigenDir.getSelectedItem().toString(),
                            cboDestDep.getSelectedIndex(),
                            cboDestMun.getSelectedIndex(),
                            cboDestDir.getSelectedItem().toString(),
                            Integer.parseInt(spinnerNumPaq.getValue().toString()),
                            String.valueOf(tamanoPaquete),
                            total));

                    System.out.println();
                    for (cotizaciones i: cotizaciones.misCotizaciones) {
                        System.out.println(i);
                    }
                }else {JOptionPane.showMessageDialog(null, "Por favor no guarde antes de Verificar el precio");}
            }
        });
        irAComprarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuComprar.irMenucompra();
            }
        });
    }
}
