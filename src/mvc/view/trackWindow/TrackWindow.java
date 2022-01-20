package mvc.view.trackWindow;

import mvc.controller.Coordinator;
import mvc.model.vo.Activity;
import mvc.model.vo.Member;
import mvc.model.vo.Track;
import utils.PropertyNames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TrackWindow extends JPanel implements ActionListener {

    private Coordinator coordinator;

    private JPanel contentPane;

    private JLabel lblId;

    private JTextField textIDTrack;

    private JButton btnPointTrack, btnModifyTrack, btnViewTrackInfo;


    public TrackWindow() {
        initComponents();
    }

    private void initComponents() {
        contentPane = new JPanel();
        contentPane.setLayout(new GridLayout(4, 1));

        btnPointTrack = new JButton("Apuntar pista");
        btnPointTrack.addActionListener(this);
        contentPane.add(btnPointTrack);

        textIDTrack = new JTextField(20);
        contentPane.add(textIDTrack);

        btnModifyTrack = new JButton("Modificar pista");
        btnModifyTrack.addActionListener(this);
        contentPane.add(btnModifyTrack);

        btnViewTrackInfo = new JButton("Ver informacion pista");
        btnViewTrackInfo.addActionListener(this);
        contentPane.add(btnViewTrackInfo);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnPointTrack) {
            coordinator.loadPanel(52);
        }
        if (e.getSource() == btnModifyTrack) {
            onBtnViewInfoTrack();
        }
        if (e.getSource() == btnViewTrackInfo) {
            onBtnViewInfoTrack();
        }
    }

    private void onBtnViewInfoTrack() {
        if (!textIDTrack.getText().equals("")) {
            try {
                int id = Integer.parseInt(textIDTrack.getText());
                Track track = coordinator.solicitarInfoP(id);
                coordinator.setTrack(track);
                coordinator.loadPanel(53);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Debe ingresar un dato numerico", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe poner un DNI", PropertyNames.WARNING_MESSAGE_TITLE, JOptionPane.WARNING_MESSAGE);
        }
    }

    public JPanel getContentPane() {
        return contentPane;
    }

    public void setContentPane(JPanel contentPane) {
        this.contentPane = contentPane;
    }

    public Coordinator getCoordinator() {
        return coordinator;
    }

    public void setCoordinator(Coordinator coordinator) {
        this.coordinator = coordinator;
    }
}