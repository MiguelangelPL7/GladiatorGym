package mvc.view.materialWindow;

import mvc.controller.Coordinator;
import mvc.model.vo.Material;
import utils.PropertyNames;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MaterialAddWindow extends JPanel implements ActionListener {

    private JLabel lblMid, lblName, lblWeight, lblUnits, lblActivity, lblBrand, lblOthers;

    private JTextField textMid, textName, textWeight, textUnits, textActivity, textBrand, textOthers;

    private JButton btnCreateMaterial, btnCancel, btnDeleteAll;

    private Coordinator coordinator;

    private JPanel contentPane;

    private JLabel title;

    public MaterialAddWindow() {
        initComponents();
    }

    private void initComponents() {
        contentPane = new JPanel();

        title = new JLabel("CREAR UN MATERIAL");
        title.setFont(new java.awt.Font("Verdana", 1, 18));
        contentPane.add(title);

        lblMid = new JLabel("MID");
        contentPane.add(lblMid);

        textMid = new JTextField(20);
        contentPane.add(textMid);

        lblName = new JLabel("Nombre");
        contentPane.add(lblName);

        textName = new JTextField(20);
        contentPane.add(textName);

        lblWeight = new JLabel("Peso");
        contentPane.add(lblWeight);

        textWeight = new JTextField(20);
        contentPane.add(textWeight);

        lblUnits = new JLabel("Unidades");
        contentPane.add(lblUnits);

        textUnits = new JTextField(20);
        contentPane.add(textUnits);

        lblActivity = new JLabel("Actividad");
        contentPane.add(lblActivity);

        textActivity = new JTextField(20);
        contentPane.add(textActivity);

        lblBrand = new JLabel("Marca");
        contentPane.add(lblBrand);

        textBrand = new JTextField(20);
        contentPane.add(textBrand);

        lblOthers = new JLabel("Otros");
        contentPane.add(lblOthers);

        textOthers = new JTextField(20);
        contentPane.add(textOthers);

        btnCreateMaterial = new JButton("Crear material");
        btnCreateMaterial.addActionListener(this);
        contentPane.add(btnCreateMaterial);

        btnCancel = new JButton("Cancelar");
        btnCancel.addActionListener(this);
        contentPane.add(btnCancel);

        btnDeleteAll = new JButton("Borrar todo");
        btnDeleteAll.addActionListener(this);
        contentPane.add(btnDeleteAll);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == btnCreateMaterial) {
            onBtnCreateMaterial();
        }
        if (e.getSource() == btnCancel) {

        }
        if (e.getSource() == btnDeleteAll) {

        }
    }

    private void onBtnCreateMaterial() {
        try {
            double weight = Double.parseDouble(textWeight.getText());
            int units = Integer.parseInt(textUnits.getText());

            Material material = new Material();
            material.setMidMaterial(textMid.getText());
            material.setNameMaterial(textName.getText());
            material.setWeightMaterial(weight);
            material.setUnitsMaterial(units);
            material.setActivityMaterial(textActivity.getText());
            material.setBrandMaterial(textBrand.getText());
            material.setOthersMaterial(textOthers.getText());


            int result = coordinator.validarAdicionMaterial(material);

            // 1 = adicion correcta;
            // 0= adicion fallida
            // -1 = atributos inválidos
            //-2 = nombre de material ya existente
            if(result == 1) {

            } else {
                String message = "";
                switch (result) {
                    case -2:
                        message = "Material ya existente";
                        break;
                    case -1:
                        message = "Atributos invalidos";
                        break;
                    case 0:
                        message = "No se ha podido añadir";
                        break;
                }
                JOptionPane.showMessageDialog(null, message, PropertyNames.WARNING_MESSAGE_TITLE, JOptionPane.WARNING_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,"Debe ingresar un dato numerico","Error",JOptionPane.ERROR_MESSAGE);
        }
    }

    public Coordinator getCoordinator() {
        return coordinator;
    }

    public void setCoordinator(Coordinator coordinator) {
        this.coordinator = coordinator;
    }

    public JPanel getContentPane() {
        return contentPane;
    }

    public void setContentPane(JPanel contentPane) {
        this.contentPane = contentPane;
    }
}
