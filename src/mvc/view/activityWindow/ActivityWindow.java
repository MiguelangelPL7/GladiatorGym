package mvc.view.activityWindow;

import mvc.controller.Coordinator;

import javax.swing.*;

public class ActivityWindow extends JPanel {

    private Coordinator coordinator;

    private JPanel contentPane;

    private JLabel availability;
    private JLabel schedule;
    private JLabel monitorAssigned;
    private JLabel maxCapacity;
    private JLabel members;

    public ActivityWindow() {
        contentPane = new JPanel();

        availability = new JLabel();
        schedule = new JLabel();
        monitorAssigned = new JLabel();
        maxCapacity = new JLabel();
        members = new JLabel();

        contentPane.add(availability);
        contentPane.add(schedule);
        contentPane.add(monitorAssigned);
        contentPane.add(maxCapacity);
        contentPane.add(members);
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
