package mvc.view.trackWindow;

import mvc.controller.Coordinator;
import utils.PropertyNames;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TrackPointWindow extends JPanel implements ActionListener {

    private Coordinator coordinator;

    private JPanel contentPane;

    private JLabel lblIdMember, lblPID, lblSchedule, lblDuration;

    private JTextField textIDMember, textPID, textSchedule, textDuration;

    private JButton btnPointTrack;

    public TrackPointWindow() {
        initComponents();
    }

    private void initComponents() {
        contentPane = new JPanel();

        lblIdMember = new JLabel("ID miembro");
        contentPane.add(lblIdMember);

        textIDMember = new JTextField(20);
        contentPane.add(textIDMember);

        lblPID = new JLabel("PID");
        contentPane.add(lblPID);

        textPID = new JTextField(20);
        contentPane.add(textPID);

        lblSchedule = new JLabel("Horario");
        contentPane.add(lblSchedule);

        textSchedule = new JTextField(20);
        contentPane.add(textSchedule);

        lblDuration = new JLabel("Horas duracion");
        contentPane.add(lblDuration);

        textDuration = new JTextField(20);
        contentPane.add(textDuration);

        btnPointTrack = new JButton("Apuntar");
        btnPointTrack.addActionListener(this);
        contentPane.add(btnPointTrack);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnPointTrack) {
            onBtnPointTrack();
        }
    }

    private void onBtnPointTrack() {
        try {
            int id = Integer.parseInt(textIDMember.getText());
            int pid = Integer.parseInt(textPID.getText());
            int duration = Integer.parseInt(textDuration.getText());

            int result = coordinator.validarApuntarMiembroP(id, pid, textSchedule.getText(), duration);

            //1 = apuntar fallido
            //0 = pista no encontrada o no disponible
            //-1 = id de miembro no existe
            //2 = apuntar correcto
            if(result == 2) {

            } else {
                String message = "";
                switch (result) {
                    case 1:
                        message = "No se ha podido apuntar";
                        break;
                    case 0:
                        message = "Pista no encontrada o no disponible";
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
