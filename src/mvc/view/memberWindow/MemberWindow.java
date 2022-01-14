package mvc.view.memberWindow;

import mvc.controller.Coordinator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MemberWindow extends JPanel implements ActionListener {

    private Coordinator coordinator;

    private JPanel contentPane;

    private JLabel name;
    private JLabel surname;
    private JLabel dni;
    private JLabel rate;
    private JLabel age;
    private JLabel dateOfBirth;
    private JLabel price;
    private JLabel paymentMethod;
    private JLabel numberPhone;
    private JLabel mail;
    private JLabel direction;

    private JButton btnNewMember;

    public MemberWindow() {
        contentPane = new JPanel();
        //contentPane.setLayout(new BorderLayout(1, 1));

        name = new JLabel();
        surname = new JLabel();
        dni = new JLabel();
        rate = new JLabel();
        age = new JLabel();
        dateOfBirth = new JLabel();
        price = new JLabel();
        paymentMethod = new JLabel();
        numberPhone = new JLabel();
        mail = new JLabel();
        direction = new JLabel();

        btnNewMember = new JButton("Nuevo miembro");

        contentPane.add(name);
        contentPane.add(surname);
        contentPane.add(dni);
        contentPane.add(rate);
        contentPane.add(age);
        contentPane.add(dateOfBirth);
        contentPane.add(price);
        contentPane.add(paymentMethod);
        contentPane.add(numberPhone);
        contentPane.add(mail);
        contentPane.add(direction);
        contentPane.add(btnNewMember);

        btnNewMember.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnNewMember) {
            MemberAddWindow memberAddWindow = new MemberAddWindow();
            memberAddWindow.pack();
            memberAddWindow.setVisible(true);
        }
        // modificar
        if (e.getSource() == btnNewMember) {
            MemberAddWindow memberAddWindow = new MemberAddWindow();
            memberAddWindow.pack();
            memberAddWindow.setVisible(true);
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
