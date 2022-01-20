package mvc.view;

import mvc.controller.Coordinator;
import mvc.view.activityWindow.ActivityModifyWindow;
import mvc.view.activityWindow.ActivityWindow;
import utils.PropertyNames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame implements ActionListener {

    private Coordinator coordinator;

    private JPanel mainPanel;
    private JPanel contentPane;
    private JPanel panelIzq;

    private JButton btnInit, btnMaterial, btnOrder, btnMembers, btnEmployee, btnTrack, btnActivity, btnCloseSession;

    private JLabel lblUser;

    private JToolBar barra;



    public MainWindow() {
        initComponents();
    }

    private void initComponents() {
        // Configuracion del frame
        //setBounds(100, 100, 500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle(PropertyNames.LBL_TITLE);
        //setLocationRelativeTo(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        //setIconImage(new ImageIcon(getClass().getResource("/../../images/Imagen1.png")).getImage());

        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        setContentPane(mainPanel);
        // Cambiar el fondo: setBackground(new Color(98, 177, 166));
        // Cambiar la letra: .setFont(new Font("Serif", Font.BOLD, 30));

        barra = new JToolBar();
        barra.setBackground(Color.darkGray);
        mainPanel.add(barra, BorderLayout.NORTH);


        panelIzq = new JPanel();
        mainPanel.add(panelIzq, BorderLayout.WEST);

        contentPane = new JPanel(new BorderLayout());
        mainPanel.add(contentPane, BorderLayout.CENTER);

        btnInit = new JButton("Inicio");
        btnInit.addActionListener(this);
        barra.add(btnInit);

        btnEmployee = new JButton("Empleados");
        btnEmployee.setPreferredSize(new Dimension(100,100));
        btnEmployee.addActionListener(this);
        barra.add(btnEmployee);

        btnMembers = new JButton("Miembros");
        btnMembers.addActionListener(this);
        barra.add(btnMembers);

        btnTrack = new JButton("Pistas");
        btnTrack.addActionListener(this);
        barra.add(btnTrack);

        btnActivity = new JButton("Actividades");
        btnActivity.addActionListener(this);
        barra.add(btnActivity);

        btnMaterial = new JButton(PropertyNames.BTN_MATERIAL);
        btnMaterial.addActionListener(this);
        barra.add(btnMaterial);

        btnOrder = new JButton(PropertyNames.BTN_ORDER);
        btnOrder.addActionListener(this);
        barra.add(btnOrder);

        btnCloseSession = new JButton("Cerrar sesion");
        btnCloseSession.addActionListener(this);
        barra.add(btnCloseSession);

        panelInit();

        //Prueba
        panelIzq.setBackground(Color.cyan);
        contentPane.setBackground(Color.BLUE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnInit) {
            panelInit();
        }
        if (e.getSource() == btnActivity) {
            panelInit();
            coordinator.loadPanel(1);
        }
        if (e.getSource() == btnEmployee) {
            panelInit();
            coordinator.loadPanel(11);
        }
        if (e.getSource() == btnMaterial) {
            panelInit();
            coordinator.loadPanel(21);
        }
        if (e.getSource() == btnMembers) {
            panelInit();
            coordinator.loadPanel(31);
        }
        if (e.getSource() == btnOrder) {
            panelInit();
            coordinator.loadPanel(41);
        }
        if (e.getSource() == btnTrack) {
            panelInit();
            coordinator.loadPanel(51);
        }
        if (e.getSource() == btnCloseSession) {
            onBtnCloseSession();
        }
    }

    private void panelInit() {
        panelIzq.removeAll();
        contentPane.removeAll();
        JLabel lblInfoInit = new JLabel();
        lblInfoInit.setText("GLADIATOR GYM");
        lblInfoInit.setBounds(120, 100, 380, 30);
        lblInfoInit.setFont(new java.awt.Font("Verdana", 1, 80));
        lblInfoInit.setAlignmentX(CENTER_ALIGNMENT);
        contentPane.add(lblInfoInit);
        contentPane.repaint();
        panelIzq.repaint();
    }

    private void onBtnCloseSession() {
        int r = JOptionPane.showConfirmDialog(this,"Esta seguro que desea salir?",
                PropertyNames.CONFIRM_MESSAGE_TITLE, JOptionPane.YES_NO_OPTION);
        if (r == JOptionPane.YES_NO_OPTION) {
            coordinator.viewSingUpWindow();
            this.dispose();
            this.setVisible(false);
        }
    }

    public void changePanelLeft(JPanel panel) {
        panelIzq.removeAll();
        panelIzq.setLayout(new BorderLayout());
        panelIzq.add(panel, BorderLayout.NORTH);
        panelIzq.repaint();
        panelIzq.revalidate();
    }

    public void changePanelCenter(JPanel panel) {
        contentPane.removeAll();
        //contentPane.add(panel, BorderLayout.CENTER);
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
