package mvc.view.materialWindow;

import mvc.controller.Coordinator;
import mvc.model.vo.Material;
import utils.PropertyNames;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MaterialModifyWindow extends JPanel implements ActionListener {

    private JLabel lblMid, lblType, lblUnits;

    private JTextField textMid, textType, textUnits;

    private JButton btnModifyMaterial, btnCancel, btnDeleteAll;

    private Coordinator coordinator;

    private JPanel contentPane;

    private JLabel title;

    public MaterialModifyWindow() {
        initComponents();
    }

    private void initComponents() {
        contentPane = new JPanel();

        title = new JLabel("MODIFICAR MATERIAL");
        title.setBounds(120, 20, 380, 30);
        title.setFont(new java.awt.Font("Verdana", 1, 18));
        contentPane.add(title);

        lblMid = new JLabel("MID");
        contentPane.add(lblMid);

        textMid = new JTextField(20);
        contentPane.add(textMid);

        lblType = new JLabel("Tipo");
        contentPane.add(lblType);

        textType = new JTextField(20);
        contentPane.add(textType);

        lblUnits = new JLabel("Unidades");
        contentPane.add(lblUnits);

        textUnits = new JTextField(20);
        contentPane.add(textUnits);


        btnModifyMaterial = new JButton("Modificar material");
        btnModifyMaterial.addActionListener(this);
        contentPane.add(btnModifyMaterial);

        btnCancel = new JButton("Cancelar");
        btnCancel.addActionListener(this);
        contentPane.add(btnCancel);

        btnDeleteAll = new JButton("Borrar todo");
        btnDeleteAll.addActionListener(this);
        contentPane.add(btnDeleteAll);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == btnModifyMaterial) {
            onBtnModifyMaterial();
        }
        if (e.getSource() == btnCancel) {

        }
        if (e.getSource() == btnDeleteAll) {

        }
    }

    private void onBtnModifyMaterial() {
        int units = 0;
        if(!textUnits.getText().equals("")) {
            try {
                units = Integer.parseInt(textUnits.getText());
            } catch (Exception e) {
                units = 0;
            }
        }
        int result = coordinator.validarModificacionMaterial(textMid.getText(), textType.getText(), units);

        // 1 = modificacion correcta
        // -1 = atributos de modificacion incorrectos
        //-2 = mid de material no existente
        //-10 = rango inválido para realizar accion
        if(result == 1) {

        } else {
            String message = "";
            switch (result) {
                case -10:
                    message = "Rango invalido para realizar accion";
                    break;
                case -2:
                    message = "Mid de material no existente";
                    break;
                case -1:
                    message = "Atributos invalidos";
                    break;
            }
            JOptionPane.showMessageDialog(null, message, PropertyNames.WARNING_MESSAGE_TITLE, JOptionPane.WARNING_MESSAGE);
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