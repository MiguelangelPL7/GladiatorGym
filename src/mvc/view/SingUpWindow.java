package mvc.view;

import mvc.controller.Coordinator;
import utils.PropertyNames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SingUpWindow extends JFrame implements ActionListener {

    private Coordinator coordinator;

    private JPanel contentPane;
    private JButton btnInit;
    private JTextField textUser, textPass;
    private JLabel lblUser, lblPass, lblTitle;

    public SingUpWindow() {
        initComponents();
    }

    private void initComponents() {

        contentPane = new JPanel();
        contentPane.setLayout(new FlowLayout(FlowLayout.CENTER));

        setBounds(100, 100, 500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle(PropertyNames.LBL_TITLE);

        contentPane.setBackground(Color.lightGray);
        setBackground(Color.BLUE);

        setContentPane(contentPane);

        setLayout(null);

        lblTitle = new JLabel("BIENVENIDO A GLADIATOR GYM");
        lblTitle.setBounds(30, 60, 2000, 25);
        lblTitle.setFont(new Font("Serif", Font.BOLD, 25));
        contentPane.add(lblTitle);



        lblUser = new JLabel(PropertyNames.LBL_DNI);
        lblUser.setBounds(100, 140, 80, 25);
        contentPane.add(lblUser);

        textUser = new JTextField(20);
        textUser.setBounds(190, 140, 160, 25);
        contentPane.add(textUser);

        lblPass = new JLabel(PropertyNames.LBL_CONTRASENA);
        lblPass.setBounds(100, 180, 80, 25);
        contentPane.add(lblPass);

        textPass = new JTextField(20);
        textPass.setBounds(190, 180, 160, 25);
        contentPane.add(textPass);

        btnInit = new JButton(PropertyNames.BTN_INICIO);
        btnInit.setBounds(100, 240, 250, 25);
        btnInit.addActionListener(this);
        contentPane.add(btnInit);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnInit) {
            //onBtnInit();
            coordinator.viewMainWindow();
            this.dispose();
            this.setVisible(false);
        }
    }

    private void onBtnInit() {
        int result = coordinator.validarInicioSesion(textUser.getText(), textPass.getText());

        if(result == 1) {
            coordinator.viewMainWindow();
            this.dispose();
            this.setVisible(false);
        } else {
            String message = "";
            switch (result) {
                case -1:
                    message = "El DNI no existe";
                    break;
                case 0:
                    message = "La contraseña es incorrecta";
                    break;
            }
            JOptionPane.showMessageDialog(null, message, PropertyNames.WARNING_MESSAGE_TITLE, JOptionPane.WARNING_MESSAGE);
        }
    }

    public Coordinator getCoordinator() {
        return coordinator;
    }

    public void setCoordinator(Coordinator coordinator) {
        this.coordinator = coordinator;
    }
}
