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

    private JLabel lblId, lblPid, lblSchedule, lblPrice;

    private JTextField textIDTrack, textPID, textSchedule, textPrice;

    private JButton btnModifyPista;

    private JCheckBox checkBoxAvailability;

    private Track track;

    public TrackModifyWindow() {
        initComponents();
    }

    private void initComponents() {
        contentPane = new JPanel();

        lblId = new JLabel("Codigo de Pista");
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
        int id = 0;
        int pid = 0;
        int memberId = 0;
        double price = 0;
        if(!textIDTrack.getText().equals("")) {
            try {
                id = Integer.parseInt(textIDTrack.getText());
            } catch (Exception e) {
                id = 0;
            }
        }
        if(!textPID.getText().equals("")) {
            try {
                pid = Integer.parseInt(textPID.getText());
            } catch (Exception e) {
                pid = 0;
            }
        }
        if(!textPrice.getText().equals("")) {
            try {
                price = Double.parseDouble(textPrice.getText());
            } catch (Exception e) {
                price = 0;
            }
        }
        Track track = new Track();
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

        return track;
    }

    private void fillFields() {
        String idTrack = String.valueOf(track.getCodigoPista());
        if(idTrack.equals("0")){idTrack="";}
        String idMember = String.valueOf(track.getMiembroID());
        if(idMember.equals("0")){idMember="";}
        String price = String.valueOf(track.getPrecioPorHora());
        if(price.equals("0.0")){price="";}
        String pid = String.valueOf(track.getPistaPID());
        if(pid.equals("0")){pid="";}

        textIDTrack.setText(idTrack);
        textPID.setText(pid);
        textSchedule.setText(track.getPistaHorario());
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
