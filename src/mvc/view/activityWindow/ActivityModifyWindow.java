package mvc.view.activityWindow;

import mvc.controller.Coordinator;
import mvc.model.vo.Activity;
import utils.PropertyNames;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActivityModifyWindow extends JPanel implements ActionListener {

    private Coordinator coordinator;

    private JPanel contentPane;

    private JLabel lblId, lblPid, lblSchedule, lblMonitorDNI, lblMaxCapacity;

    private JTextField textId, textPID, textSchedule, textMonitorDNI, textMaxCapacity;

    private JButton btnModifyActivity;

    private JCheckBox checkBoxAvailability;

    private Activity activity;

    public ActivityModifyWindow() {
        initComponents();
    }

    private void initComponents() {
        contentPane = new JPanel();

        lblId = new JLabel("Id pista");
        contentPane.add(lblId);

        textId = new JTextField(20);
        contentPane.add(textId);

        lblPid = new JLabel("PID");
        contentPane.add(lblPid);

        textPID = new JTextField(20);
        contentPane.add(textPID);

        lblSchedule = new JLabel("Horario");
        contentPane.add(lblSchedule);

        textSchedule = new JTextField(20);
        contentPane.add(textSchedule);

        lblMonitorDNI = new JLabel("Id monitor");
        contentPane.add(lblMonitorDNI);

        textMonitorDNI = new JTextField(20);
        contentPane.add(textMonitorDNI);

        checkBoxAvailability = new JCheckBox("Disponibilidad");
        contentPane.add(checkBoxAvailability);

        lblMaxCapacity = new JLabel("Capacidad maxima");
        contentPane.add(lblMaxCapacity);

        textMaxCapacity = new JTextField(20);
        contentPane.add(textMaxCapacity);

        btnModifyActivity = new JButton("Modificar");
        btnModifyActivity.addActionListener(this);
        contentPane.add(btnModifyActivity);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnModifyActivity) {
            onBtnModifyActivity();
        }
    }

    private void onBtnModifyActivity() {
            int result = coordinator.validarModificarAtributosA(getActivityData());
            // 1 = actualizacion correcta;
            // 0= actualizacion fallida
            // -1 = atributos inválidos
            //-2 = codigo de actividad inválido
            if(result == 1) {

            } else {
                String message = "";
                switch (result) {
                    case -2:
                        message = "Codigo de actividad invalido";
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
    }

    private Activity getActivityData() {
        Activity activity = new Activity();
        try {
            int id = Integer.parseInt(textId.getText());
            int pid = Integer.parseInt(textPID.getText());
            int maxCapacity = Integer.parseInt(textMaxCapacity.getText());

            activity.setCodigoActividad(id);
            activity.setActividadPID(pid);
            activity.setActividadHorario(textSchedule.getText());
            activity.setMonitorDNI(textMonitorDNI.getText());

            if(checkBoxAvailability.isSelected()) {
                activity.setActividadDisponibilidad(true);
            } else {
                activity.setActividadDisponibilidad(false);
            }
            activity.setCapacidadMaxima(maxCapacity);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,"Debe ingresar un dato numerico","Error",JOptionPane.ERROR_MESSAGE);
        }
        return activity;
    }

    private void fillFields() {
        String idActivity = String.valueOf(activity.getCodigoActividad());
        String pid = String.valueOf(activity.getActividadPID());
        String maxCapacity = String.valueOf(activity.getCapacidadMaxima());

        textId.setText(idActivity);
        textPID.setText(pid);
        textSchedule.setText(activity.getActividadHorario());
        textMonitorDNI.setText(activity.getMonitorDNI());

        if(activity.getActividadDisponibilidad()) {
            checkBoxAvailability.setSelected(true);
        } else {
            checkBoxAvailability.setSelected(false);
        }
        textMaxCapacity.setText(maxCapacity);
    }

    public Coordinator getCoordinator() {
        return coordinator;
    }

    public void setCoordinator(Coordinator coordinator) {
        this.coordinator = coordinator;
    }

    public JPanel getContentPane() {
        if(activity != null) {
            fillFields();
        }
        return contentPane;
    }

    public void setContentPane(JPanel contentPane) {
        this.contentPane = contentPane;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }
}

