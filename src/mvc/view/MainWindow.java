package mvc.view;

import mvc.controller.Coordinator;
import utils.PropertyNames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame implements ActionListener {

    private Coordinator coordinator;

    private JPanel mainPanel;
    private JPanel panelMenu;
    private JPanel contentPane;

    private JButton btnInit, btnMaterial, btnOrder, btnMembers, btnEmployee, btnTrack, btnActivity;

    private JLabel lblUser;



    public MainWindow() {
        initComponents();
    }

    private void initComponents() {
        // Configuracion del frame
        //setBounds(100, 100, 500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Gladiator Gym");
        //setLocationRelativeTo(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        //setIconImage(new ImageIcon(getClass().getResource("/../../images/Imagen1.png")).getImage());

        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        setContentPane(mainPanel);
        // Cambiar el fondo: setBackground(new Color(98, 177, 166));
        // Cambiar la letra: .setFont(new Font("Serif", Font.BOLD, 30));



        panelMenu = new JPanel();
        mainPanel.add(panelMenu);

        contentPane = new JPanel();
        mainPanel.add(contentPane);

        lblUser = new JLabel("Funciona");
        contentPane.add(lblUser);

        lblUser = new JLabel("OLa");
        contentPane.add(lblUser);

        lblUser = new JLabel("sdsds");
        contentPane.add(lblUser);

        lblUser = new JLabel("sdds");
        contentPane.add(lblUser);

        btnInit = new JButton("Pulsame");
        btnInit.addActionListener(this);
        panelMenu.add(btnInit);

        btnEmployee = new JButton("Empleados");
        btnEmployee.addActionListener(this);
        panelMenu.add(btnEmployee);

        btnMembers = new JButton("Miembros");
        btnMembers.addActionListener(this);
        panelMenu.add(btnMembers);

        btnTrack = new JButton("Pistas");
        btnTrack.addActionListener(this);
        panelMenu.add(btnTrack);

        btnActivity = new JButton("Actividades");
        btnActivity.addActionListener(this);
        panelMenu.add(btnActivity);

        btnMaterial = new JButton(PropertyNames.BTN_MATERIAL);
        btnMaterial.addActionListener(this);
        panelMenu.add(btnMaterial);

        btnOrder = new JButton(PropertyNames.BTN_ORDER);
        btnOrder.addActionListener(this);
        panelMenu.add(btnOrder);








        //Prueba
        panelMenu.setBackground(Color.cyan);
        contentPane.setBackground(Color.BLUE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnInit) {
            onBtnInit();
        }
        if (e.getSource() == btnMaterial) {
            onBtnMaterial();
        }
        if (e.getSource() == btnOrder) {
            onBtnOrder();
        }
        if (e.getSource() == btnMembers) {
            onBtnMember();
        }
        if (e.getSource() == btnActivity) {

        }
        if (e.getSource() == btnTrack) {

        }
        if (e.getSource() == btnEmployee) {

        }
    }

    private void onBtnInit() {
        cambiarPanel(coordinator.singUpWindow());
    }

    private void onBtnMaterial() {
        cambiarPanel(coordinator.materialWindow());
    }

    private void onBtnOrder() {
        cambiarPanel(coordinator.orderWindow());
    }

    private void onBtnMember() {
        cambiarPanel(coordinator.memberWindow());
    }

    private void cambiarPanel(JPanel panel) {
        contentPane.removeAll();
        contentPane.add(panel);
        contentPane.repaint();
        contentPane.revalidate();
    }

    public Coordinator getCoordinator() {
        return coordinator;
    }

    public void setCoordinator(Coordinator coordinator) {
        this.coordinator = coordinator;
    }
}
