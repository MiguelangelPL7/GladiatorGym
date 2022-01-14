package mvc.view;

import mvc.controller.Coordinator;
import utils.PropertyNames;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SingUpWindow extends JPanel implements ActionListener {

    private Coordinator coordinator;

    private JPanel contentPane;
    private JButton btnInit;
    private JTextField textUser;
    private JTextField textPass;
    private JLabel lblUser;
    private JLabel lblPass;



    public SingUpWindow() {
        initComponents();
    }

    private void initComponents() {

        contentPane = new JPanel();

        lblUser = new JLabel(PropertyNames.LBL_DNI);
        contentPane.add(lblUser);

        textUser = new JTextField(20);
        //textUser.setPreferredSize(new Dimension(50, 50));
        //textUser.setColumns(20);
        contentPane.add(textUser);

        lblPass = new JLabel(PropertyNames.LBL_CONTRASENA);
        contentPane.add(lblPass);

        textPass = new JTextField(20);
        contentPane.add(textPass);

        btnInit = new JButton(PropertyNames.BTN_INICIO);
        contentPane.add(btnInit);

        btnInit.addActionListener(this);

        // Cambiar el fondo: setBackground(new Color(98, 177, 166));
        // Cambiar la letra: .setFont(new Font("Serif", Font.BOLD, 30));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnInit) {
            onBtnInit();
        }
    }

    private void onBtnInit() {
        contentPane.removeAll();
        coordinator.viewMainWindow();
        contentPane.repaint();
    }

    private void createUIComponents() {

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
