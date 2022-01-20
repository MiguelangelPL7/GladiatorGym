package mvc.view.trackWindow;

import mvc.controller.Coordinator;
import mvc.model.vo.Activity;
import mvc.model.vo.Track;
import utils.PropertyNames;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TrackModifyWindow extends JPanel implements ActionListener {

    private Coordinator coordinator;

    private JPanel contentPane;

    private JLabel lblId, lblPid, lblSchedule, lblMemberID, lblPrice;

    private JTextField textIDTrack, textPID, textSchedule, textMemberID, textPrice;

    private JButton btnModifyPista;

    private JCheckBox checkBoxAvailability;

    private Track track;

    public TrackModifyWindow() {
        initComponents();
    }

    private void initComponents() {
        contentPane = new JPanel();

        lblId = new JLabel("Id pista");
        contentPane.add(lblId);

        textIDTrack = new JTextField(20);
        contentPane.add(textIDTrack);

        lblPid = new JLabel("PID");
        contentPane.add(lblPid);

        textPID = new JTextField(20);
        contentPane.add(textPID);

        lblSchedule = new JLabel("Horario");
        contentPane.add(lblSchedule);

        textSchedule = new JTextField(20);
        contentPane.add(textSchedule);

        lblMemberID = new JLabel("Id miembro");
        contentPane.add(lblMemberID);

        textMemberID = new JTextField(20);
        contentPane.add(textMemberID);

        checkBoxAvailability = new JCheckBox("Disponibilidad");
        contentPane.add(checkBoxAvailability);

        lblPrice = new JLabel("Precio");
        contentPane.add(lblPrice);

        textPrice = new JTextField(20);
        contentPane.add(textPrice);

        btnModifyPista = new JButton("Modificar");
        btnModifyPista.addActionListener(this);
        contentPane.add(btnModifyPista);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnModifyPista) {
            onBtnModifyTrack();
        }
    }

    private void onBtnModifyTrack() {
        try {
            int result = coordinator.validarModificarAtributosP(getTrackData());
            // 1 = actualizacion correcta;
            // 0= actualizacion fallida
            // -1 = atributos inválidos
            //-2 = codigo de actividad inválido
            if(result == 1) {

            } else {
                String message = "";
                switch (result) {
                    case -2:
                        message = "Codigo de actividad incorrecto";
                        break;
                    case -1:
                        message = "Atributos invalidos";
                        break;
                    case 0:
                        message = "No se ha podido actualizar";
                        break;
                }
                JOptionPane.showMessageDialog(null, message, PropertyNames.WARNING_MESSAGE_TITLE, JOptionPane.WARNING_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,"Debe ingresar un dato numerico","Error",JOptionPane.ERROR_MESSAGE);
        }
    }

    private Track getTrackData() {
        Track track = new Track();
        try {
            int id = Integer.parseInt(textIDTrack.getText());
            int pid = Integer.parseInt(textPID.getText());
            int memberId = Integer.parseInt(textMemberID.getText());
            int price = Integer.parseInt(textPrice.getText());

            track.setCodigoPista(id);
            track.setPistaPID(pid);
            track.setPistaHorario(textSchedule.getText());
            track.setMiembroID(memberId);
            if(checkBoxAvailability.isSelected()) {
                track.setPistaDisponibilidad(true);
            } else {
                track.setPistaDisponibilidad(false);
            }
            track.setPrecioPorHora(price);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,"Debe ingresar un dato numerico","Error",JOptionPane.ERROR_MESSAGE);
        }
        return track;
    }

    private void fillFields() {
        String idTrack = String.valueOf(track.getCodigoPista());
        String idMember = String.valueOf(track.getMiembroID());
        String price = String.valueOf(track.getPrecioPorHora());
        String pid = String.valueOf(track.getPistaPID());

        textIDTrack.setText(idTrack);
        textPID.setText(pid);
        textSchedule.setText(track.getPistaHorario());
        textMemberID.setText(idMember);
        if(track.getPistaDisponibilidad()) {
            checkBoxAvailability.setSelected(true);
        } else {
            checkBoxAvailability.setSelected(false);
        }
        textPrice.setText(price);
    }

    public Coordinator getCoordinator() {
        return coordinator;
    }

    public void setCoordinator(Coordinator coordinator) {
        this.coordinator = coordinator;
    }

    public JPanel getContentPane() {
        if (track != null) {
            fillFields();
        }
        return contentPane;
    }

    public void setContentPane(JPanel contentPane) {
        this.contentPane = contentPane;
    }

    public Track getTrack() {
        return track;
    }

    public void setTrack(Track track) {
        this.track = track;
    }
}
