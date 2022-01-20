package mvc.view.activityWindow;

import mvc.controller.Coordinator;
import mvc.model.vo.Activity;
import mvc.model.vo.Employee;
import mvc.model.vo.Track;
import utils.PropertyNames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActivityWindow extends JPanel implements ActionListener {

    private Coordinator coordinator;

    private JPanel contentPane;

    private JLabel lblId;

    private JTextField textId;

    private JButton btnViewInfoActivity, btnPointActivity, btnModifyActivity;

    public ActivityWindow() {
        initsComponents();
    }

    private void initsComponents() {
        contentPane = new JPanel();
        //contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
        contentPane.setLayout(new GridLayout(5, 1));

        btnViewInfoActivity = new JButton("Ver info actividad");
        btnViewInfoActivity.addActionListener(this);
        contentPane.add(btnViewInfoActivity);

        lblId = new JLabel("Codigo de actividad");
        contentPane.add(lblId);

        textId = new JTextField(20);
        contentPane.add(textId);

        btnModifyActivity = new JButton("Modificar actividad");
        btnModifyActivity.addActionListener(this);
        contentPane.add(btnModifyActivity);

        btnPointActivity = new JButton("Apuntar actividad");
        btnPointActivity.addActionListener(this);
        contentPane.add(btnPointActivity);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnPointActivity) {
            coordinator.loadPanel(2);
        }
        if (e.getSource() == btnViewInfoActivity) {
            onBtnViewInfoActivity();
        }
        if (e.getSource() == btnModifyActivity) {
            onBtnViewInfoActivity();
        }
    }

    private void onBtnViewInfoActivity() {
        if (!textId.getText().equals("")) {
            try {
                int id = Integer.parseInt(textId.getText());
                Activity activity = coordinator.solicitarInfoA(id);
                if(activity.getCodigoActividad()==0){
                    String message = "El Codigo de Actividad no es correcto";
                    JOptionPane.showMessageDialog(null, message, PropertyNames.WARNING_MESSAGE_TITLE, JOptionPane.WARNING_MESSAGE);
                }else{
                    coordinator.setActivity(activity);
                    coordinator.loadPanel(3);
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Debe ingresar un dato numerico", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe poner un Codigo de Actividad", PropertyNames.WARNING_MESSAGE_TITLE, JOptionPane.WARNING_MESSAGE);
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
