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
        if(materials.size() > 0) {
            contentPane.setLayout(new GridLayout(materials.size()+1, 8));
            contentPane.add(new JLabel("Numero"));
            contentPane.add(new JLabel("MID"));
            contentPane.add(new JLabel("Nombre"));
            contentPane.add(new JLabel("Peso"));
            contentPane.add(new JLabel("Unidades"));
            contentPane.add(new JLabel("Actividad"));
            contentPane.add(new JLabel("Marca"));
            contentPane.add(new JLabel("Otros"));

            for(int i = 0; i < materials.size(); i++) {
                contentPane.add(new JLabel(i+1+""));
                contentPane.add(new JLabel(materials.get(i).getMidMaterial()));
                contentPane.add(new JLabel(materials.get(i).getNameMaterial()));
                contentPane.add(new JLabel(materials.get(i).getWeightMaterial()+""));
                contentPane.add(new JLabel(materials.get(i).getUnitsMaterial()+""));
                contentPane.add(new JLabel(materials.get(i).getActivityMaterial()));
                contentPane.add(new JLabel(materials.get(i).getBrandMaterial()));
                contentPane.add(new JLabel(materials.get(i).getOthersMaterial()));
            }
        } else {
            contentPane.add(new JLabel("No hay materiales"));
        }
    }

    public Coordinator getCoordinator() {
        return coordinator;
    }

    public void setCoordinator(Coordinator coordinator) {
        this.coordinator = coordinator;
    }

    public JPanel getContentPane() {
        contentPane.removeAll();
        completeMaterials();
        return contentPane;
    }

    public void setContentPane(JPanel contentPane) {
        this.contentPane = contentPane;
    }
}
