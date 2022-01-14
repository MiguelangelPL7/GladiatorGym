package mvc.view.employeeWindow;

import mvc.controller.Coordinator;

import javax.swing.*;

public class EmployeeWindow extends JPanel {

    private Coordinator coordinator;

    private JPanel contentPane;

    private JLabel name;
    private JLabel surname;
    private JLabel dateInit;
    private JLabel dni;
    private JLabel age;
    private JLabel dateOfBirth;
    private JLabel paymentMethod;
    private JLabel numberPhone;
    private JLabel email;
    private JLabel direction;
    private JLabel salary;
    private JLabel user;
    private JLabel pass;
    private JLabel range;

    public EmployeeWindow() {
        contentPane = new JPanel();

        name = new JLabel();
        surname = new JLabel();
        dateInit = new JLabel();
        dni = new JLabel();
        age = new JLabel();
        dateOfBirth = new JLabel();
        paymentMethod = new JLabel();
        numberPhone = new JLabel();
        email = new JLabel();
        direction = new JLabel();
        salary = new JLabel();
        user = new JLabel();
        pass = new JLabel();
        range = new JLabel();

        contentPane.add(name);
        contentPane.add(surname);
        contentPane.add(dateInit);
        contentPane.add(dni);
        contentPane.add(age);
        contentPane.add(dateOfBirth);
        contentPane.add(paymentMethod);
        contentPane.add(numberPhone);
        contentPane.add(email);
        contentPane.add(direction);
        contentPane.add(salary);
        contentPane.add(user);
        contentPane.add(pass);
        contentPane.add(range);
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