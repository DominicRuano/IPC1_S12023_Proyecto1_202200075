import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Objects;

public class menuDepMun {
    private JButton regresarButton;
    private JTextField txtRegionDep;
    private JTextField txtNombreMun;
    private JTextField txtNombreDep;
    private JComboBox cboCodigoRegion;
    private JComboBox cboCodigoDep;
    private JComboBox cboAddMun;
    private JComboBox cboAddDep;
    private JButton guardarCambiosButton;
    private JButton guardarNuevoButton;
    private JButton eliminarButton;
    private JButton guardarCambiosButton1;
    private JButton guardarNuevoButton1;
    private JButton eliminarButton1;
    public JPanel DepMun;
    private void guardarDep(int num){
        if (!txtRegionDep.getText().equals("") && !txtNombreDep.getText().equals("")){

            departamento.misDepartamentos.add(new departamento("","",0,0,
                    region.misRegiones.get(num).getCodigo(),
                    txtRegionDep.getText(),
                    txtNombreDep.getText()));

            txtNombreDep.setText("");

            System.out.println();
            for (departamento i : departamento.misDepartamentos) {
                System.out.println(i);
            }
        }else {JOptionPane.showMessageDialog(Main.frame, "Por favor ingrese todos los campos.");}
    }
    private void guardarMun(){
        if (!txtNombreMun.getText().equals("")){

            municipio.misMunicipios.add(new municipio("","",0,0,"","",
                    "", cboCodigoDep.getSelectedItem().toString(),txtNombreMun.getText()));

            System.out.println();
            for (municipio i: municipio.misMunicipios) {
                System.out.println(i);
            }
        }
    }
    private void guardarCambiosDep(int num){

        departamento.misDepartamentos.get(num).setNombreDep(txtNombreDep.getText());
        departamento.misDepartamentos.get(num).setRegionDep(txtRegionDep.getText());
        departamento.misDepartamentos.get(num).setCodigoRegionDep(region.misRegiones.get(num).getCodigo());

        System.out.println();
        for (departamento i : departamento.misDepartamentos) {
            System.out.println(i);
        }
    }
    private void guardarCambiosMun(int num){

        municipio.misMunicipios.get(num).setNombreMun(txtNombreMun.getText());
        municipio.misMunicipios.get(num).setCodigoDeprtamento(departamento.misDepartamentos.get(cboCodigoDep.getSelectedIndex()).getNombreDep());

        System.out.println();
        for (municipio i : municipio.misMunicipios) {
            System.out.println(i);
        }
    }
    private void eliminarDep(){
        int num = cboAddDep.getSelectedIndex();

        departamento.misDepartamentos.remove(num);

        System.out.println();
        for (departamento i: departamento.misDepartamentos) {
            System.out.println(i);
        }

    }
    private void eliminiarMun(){
        int num = cboAddMun.getSelectedIndex();

        municipio.misMunicipios.remove(num);

        System.out.println();
        for (municipio i: municipio.misMunicipios) {
            System.out.println(i);
        }
    }
    public static void irDepMun(){
        Main.frame.setContentPane(new menuDepMun().DepMun);
        Main.frame.pack();
        Main.frame.setSize(700,350);
    }

    public menuDepMun() {
    regresarButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            menuAdmin.irMenuadmin();
        }
    });
        guardarNuevoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int num = cboCodigoRegion.getSelectedIndex();
                guardarDep(num);
            }
        });
        guardarCambiosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int num = cboAddDep.getSelectedIndex();
                guardarCambiosDep(num);
            }
        });
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarDep();
            }
        });
        cboAddDep.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                cboAddDep.removeAllItems();
                for (departamento i : departamento.misDepartamentos) {
                    cboAddDep.addItem(i.getNombreDep());
                }
            }
        });
        cboAddDep.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int num = cboAddDep.getSelectedIndex();

                try {
                    cboCodigoRegion.setSelectedItem(departamento.misDepartamentos.get(num).getCodigoRegionDep());
                    txtRegionDep.setText(departamento.misDepartamentos.get(num).getRegionDep());
                    txtNombreDep.setText(departamento.misDepartamentos.get(num).getNombreDep());


                }catch (Exception E ){
                    System.out.println("Here");
                }
            }
        });
        cboCodigoRegion.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    cboCodigoRegion.removeAllItems();

                    for (region i: region.misRegiones) {
                        cboCodigoRegion.addItem(i.getCodigo());
                    }
                }catch (Exception E){
                    System.out.println("Here");
                }

            }
        });
        cboCodigoRegion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int num = cboCodigoRegion.getSelectedIndex();

                txtRegionDep.setText(region.misRegiones.get(num).getNombre());
            }
        });
        guardarNuevoButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarMun();
            }
        });
        cboCodigoDep.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                try {
                    cboCodigoDep.removeAllItems();
                    for (departamento i: departamento.misDepartamentos) {
                        cboCodigoDep.addItem(i.getNombreDep());
                    }
                }catch (Exception E){
                    System.out.println("Here");
                }

            }
        });
        cboAddMun.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                cboAddMun.removeAllItems();
                for (municipio i : municipio.misMunicipios) {
                    cboAddMun.addItem(i.getNombreMun());
                }
            }
        });
        cboAddMun.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int num = cboAddMun.getSelectedIndex();

                try {
                    cboCodigoDep.setSelectedItem(municipio.misMunicipios.get(num).getCodigoDeprtamento());
                    txtNombreMun.setText(municipio.misMunicipios.get(num).getNombreMun());

                }catch (Exception E){
                    System.out.println("Here");
                }
            }
        });
        guardarCambiosButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int num = cboAddMun.getSelectedIndex();
                guardarCambiosMun(num);
            }
        });
        eliminarButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminiarMun();
            }
        });
    }
}
