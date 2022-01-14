package mvc.view.materialWindow;

import mvc.controller.Coordinator;

import javax.swing.*;

public class MaterialWindow extends JPanel {

    private Coordinator coordinator;

    private JPanel contentPane;

    private JLabel name;
    private JLabel weight;
    private JLabel unit;
    private JLabel activityAssociate;
    private JTextArea other;


    public MaterialWindow() {
        contentPane = new JPanel();

        name = new JLabel();
        weight = new JLabel();
        unit = new JLabel();
        activityAssociate = new JLabel();
        other = new JTextArea();

        contentPane.add(name);
        contentPane.add(weight);
        contentPane.add(unit);
        contentPane.add(activityAssociate);
        contentPane.add(other);
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
