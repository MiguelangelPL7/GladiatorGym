package mvc.view.activityWindow;

import mvc.controller.Coordinator;
import mvc.model.vo.Activity;
import utils.PropertyNames;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActivityPointWindow extends JPanel implements ActionListener {

    private Coordinator coordinator;

    private JPanel contentPane;

    private JLabel lblId, lblPid, lblHorario;

    private JTextField textId, textPID, textSchedule;

    private JButton btnPointActivity;

    public ActivityPointWindow() {
        initComponents();
    }

    private void initComponents() {
        contentPane = new JPanel();

        lblId = new JLabel("ID");
        contentPane.add(lblId);

        textId = new JTextField(20);
        contentPane.add(textId);

        lblPid = new JLabel("PID");
        contentPane.add(lblPid);

        textPID = new JTextField(20);
        contentPane.add(textPID);

        lblHorario = new JLabel("Horario");
        contentPane.add(lblHorario);

        textSchedule = new JTextField(20);
        contentPane.add(textSchedule);

        btnPointActivity = new JButton("Apuntar actividad");
        btnPointActivity.addActionListener(this);
        contentPane.add(btnPointActivity);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnPointActivity) {
            onBtnPointWindow();
        }
    }

    private void onBtnPointWindow() {

        try {
            int id = Integer.parseInt(textId.getText());
            int pid = Integer.parseInt(textPID.getText());

            int result = coordinator.validarApuntarMiembroA(id, pid, textSchedule.getText());

            //100 = miembro ya apuntado
            //2 = apuntado correctamente,
            // 1 = apuntar fallido
            //0 = actividad no encontrada o no disponible
            // -1 = id de miembro no existe
            if(result == 2) {

            } else {
                String message = "";
                switch (result) {
                    case 100:
                        message = "El miembro ya esta apuntado";
                        break;
                    case 1:
                        message = "No se ha podido apuntar";
                        break;
                    case 0:
                        message = "Actividad no encontrada o no disponible";
                        break;
                    case -1:
                        message = "El id del miembro no existe";
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