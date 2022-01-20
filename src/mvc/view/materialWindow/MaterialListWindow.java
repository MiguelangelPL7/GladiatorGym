package mvc.view.materialWindow;

import mvc.controller.Coordinator;
import mvc.model.vo.Material;

import javax.swing.*;

import java.awt.*;
import java.util.ArrayList;

public class MaterialListWindow extends JPanel {

    private Coordinator coordinator;

    private JPanel contentPane;

    public MaterialListWindow() {
        initComponents();
    }

    private void initComponents() {
        contentPane = new JPanel();
    }

    private void completeMaterials() {
        ArrayList<Material> materials = coordinator.solicitarListaMateriales();

        contentPane.setLayout(new GridLayout(1, 8));
        contentPane.add(new JLabel("Numero"));
        contentPane.add(new JLabel("MID"));
        contentPane.add(new JLabel("Nombre"));
        contentPane.add(new JLabel("Peso"));
        contentPane.add(new JLabel("Unidades"));
        contentPane.add(new JLabel("Actividad"));
        contentPane.add(new JLabel("Marca"));
        contentPane.add(new JLabel("Otros"));

        if(materials != null) {
            contentPane.setLayout(new GridLayout(materials.size(), 8));
            for(int i = 1; i <= 8; i++) {
                contentPane.add(new JLabel(i+""));
                contentPane.add(new JLabel(materials.get(i).getMidMaterial()));
                contentPane.add(new JLabel(materials.get(i).getNameMaterial()));
                contentPane.add(new JLabel(materials.get(i).getWeightMaterial()+""));
                contentPane.add(new JLabel(materials.get(i).getUnitsMaterial()+""));
                contentPane.add(new JLabel(materials.get(i).getActivityMaterial()));
                contentPane.add(new JLabel(materials.get(i).getBrandMaterial()));
                contentPane.add(new JLabel(materials.get(i).getOthersMaterial()));
            }
        }
    }

    public Coordinator getCoordinator() {
        return coordinator;
    }

    public void setCoordinator(Coordinator coordinator) {
        this.coordinator = coordinator;
    }

    public JPanel getContentPane() {
        completeMaterials();
        return contentPane;
    }

    public void setContentPane(JPanel contentPane) {
        this.contentPane = contentPane;
    }
}
