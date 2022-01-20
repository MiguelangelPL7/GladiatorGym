package mvc.view.materialWindow;

import mvc.controller.Coordinator;
import mvc.model.vo.Material;
import mvc.model.vo.Member;
import utils.PropertyNames;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MaterialWindow extends JPanel implements ActionListener {

    private Coordinator coordinator;

    private JPanel contentPane;

    private JButton btnCreateMaterial, btnModifyMaterial, btnListMaterials, btnDeleteMaterial;

    private JTextField textMid;

    public MaterialWindow() {
        initComponents();
    }

    private void initComponents() {
        contentPane = new JPanel();
        contentPane.setLayout(new GridLayout(5, 1));

        btnCreateMaterial = new JButton("Nuevo material");
        btnCreateMaterial.setBounds(20, 100, 30, 30);
        btnCreateMaterial.addActionListener(this);
        contentPane.add(btnCreateMaterial);

        btnModifyMaterial = new JButton("Modificar material");
        btnModifyMaterial.setBounds(20, 100, 30, 30);
        btnModifyMaterial.addActionListener(this);
        contentPane.add(btnModifyMaterial);

        btnListMaterials = new JButton("Ver materiales");
        btnListMaterials.setBounds(20, 100, 30, 30);
        btnListMaterials.addActionListener(this);
        contentPane.add(btnListMaterials);

        textMid = new JTextField(20);
        contentPane.add(textMid);

        btnDeleteMaterial = new JButton("Eliminar material");
        btnDeleteMaterial.setBounds(20, 100, 30, 30);
        btnDeleteMaterial.addActionListener(this);
        contentPane.add(btnDeleteMaterial);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCreateMaterial) {
            coordinator.loadPanel(22);
        }
        if (e.getSource() == btnModifyMaterial) {
            coordinator.loadPanel(23);
        }
        if (e.getSource() == btnListMaterials) {
            coordinator.loadPanel(24);
        }
        if (e.getSource() == btnDeleteMaterial) {
            onBtnDeleteMaterial();
        }
    }

    private void onBtnDeleteMaterial() {
        if (!textMid.getText().equals("")) {
            //-10 = rango inválido para realizar accion
            //-2 = mid de material no existente
            // -1 = material esta presente en un pedido
            // 1 = eliminacion correcta
            int result = coordinator.validarEliminacionMaterial(textMid.getText());
            if(result == 1) {

            } else {
                String message = "";
                switch (result) {
                    case -10:
                        message = "Rango invalido para realizar la accion";
                        break;
                    case -2:
                        message = "El mid del material no es correcto";
                        break;
                    case -1:
                        message = "El material esta presente en un pedido";
                        break;
                }
                JOptionPane.showMessageDialog(null, message, PropertyNames.WARNING_MESSAGE_TITLE, JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe poner un MID", PropertyNames.WARNING_MESSAGE_TITLE, JOptionPane.WARNING_MESSAGE);
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
