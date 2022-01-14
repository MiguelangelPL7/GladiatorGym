package mvc.view.employeeWindow;

import mvc.controller.Coordinator;
import mvc.view.memberWindow.MemberAddWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmployeeAddWindow  extends JDialog implements ActionListener {

    private Coordinator coordinator;

    private JPanel contentPane;

    private JLabel title;
    private JLabel name;
    private JLabel surname;
    private JLabel dateInit;
    private JLabel dni;
    private JLabel age;
    private JLabel dateOfBirth;
    private JLabel paymentMethod;
    private JLabel numberPhone;
    private JLabel mail;
    private JLabel direction;
    private JLabel salary;
    private JLabel user;
    private JLabel pass;
    private JLabel range;

    private JTextField textName, textSurname, textDateInit, textDni, textAge, textDateOfBirth, textPaymentMethod,
        textNumberPhone, textMail, textDirection, textSalary, textUser, textPass, textRange;

    private JButton btnCreateEmployee;
    private JButton btnCancel;
    private JButton btnDeleteAll;

    public EmployeeAddWindow() {
        contentPane = new JPanel();
    }

    private void initComponents() {
        contentPane = new JPanel();

        setContentPane(contentPane);
        setModal(true);
        setBounds(100, 100,800,600);
        setTitle("Crear nuevo miembro");
        setLocationRelativeTo(null);
        setLayout(null);

        title = new JLabel();
        title.setText("CREAR UN MIEMBRO");
        title.setBounds(120, 20, 380, 30);
        title.setFont(new java.awt.Font("Verdana", 1, 18));
        contentPane.add(title);

        name = new JLabel();
        name.setText("Nombre");
        name.setBounds(20, 120, 80, 25);
        contentPane.add(name);

        surname = new JLabel();
        surname.setText("Apellidos");
        surname.setBounds(290, 120, 80, 25);
        contentPane.add(surname);

        dateInit = new JLabel();
        dateInit.setText("Fecha de inicio");
        dateInit.setBounds(20, 160, 80, 25);
        contentPane.add(dateInit);

        dni = new JLabel();
        dni.setText("DNI");
        dni.setBounds(290, 160, 80, 25);
        contentPane.add(dni);

        age = new JLabel();
        age.setText("Edad");
        age.setBounds(20, 200, 80, 25);
        contentPane.add(age);

        dateOfBirth = new JLabel();
        dateOfBirth.setText("Fecha de nacimiento");
        dateOfBirth.setBounds(290, 200, 120, 25);
        contentPane.add(dateOfBirth);

        paymentMethod = new JLabel();
        paymentMethod.setText("Metodo de pago");
        paymentMethod.setBounds(20, 240, 80, 25);
        contentPane.add(paymentMethod);

        numberPhone = new JLabel();
        numberPhone.setText("Telefono");
        numberPhone.setBounds(290, 240, 120, 25);
        numberPhone.add(numberPhone);

        mail = new JLabel();
        mail.setText("Correo electronico");
        mail.setBounds(20, 280, 80, 25);
        contentPane.add(mail);

        direction = new JLabel();
        direction.setText("Direccion");
        direction.setBounds(290, 280, 80, 25);
        contentPane.add(direction);

        salary = new JLabel();
        salary.setText("Salario");
        salary.setBounds(20, 320, 80, 25);
        contentPane.add(salary);

        range = new JLabel();
        range.setText("Rango");
        range.setBounds(290, 320, 80, 25);
        contentPane.add(range);

        user = new JLabel();
        user.setText("Usuario");
        user.setBounds(20, 360, 80, 25);
        contentPane.add(user);

        pass = new JLabel();
        pass.setText("Contraseña");
        user.setBounds(290, 360, 80, 25);
        contentPane.add(pass);




        textName = new JTextField();
        textName.setBounds(80, 120, 190, 25);
        contentPane.add(textName);

        textSurname = new JTextField();
        textSurname.setBounds(340, 120, 190, 25);
        contentPane.add(textSurname);

        textDateInit = new JTextField();
        textDateInit.setBounds(80, 160, 80, 25);
        contentPane.add(textDateInit);

        textDni = new JTextField();
        textDni.setBounds(340, 160, 80, 25);
        contentPane.add(textDni);

        textAge = new JTextField();
        textAge.setBounds(80, 200, 190, 25);
        contentPane.add(textAge);

        textDateOfBirth = new JTextField();
        textDateOfBirth.setBounds(340, 200, 120, 25);
        contentPane.add(textDateOfBirth);

        textPaymentMethod = new JTextField();
        textPaymentMethod.setBounds(80, 240, 80, 25);
        contentPane.add(textPaymentMethod);

        textNumberPhone = new JTextField();
        textNumberPhone.setBounds(340, 240, 120, 25);
        contentPane.add(textNumberPhone);

        textMail = new JTextField();
        textMail.setBounds(80, 280, 80, 25);
        contentPane.add(textMail);

        textDirection = new JTextField();
        textDirection.setBounds(340, 280, 80, 25);
        contentPane.add(textDirection);

        textDirection = new JTextField();
        textDirection.setBounds(80, 320, 80, 25);
        contentPane.add(textDirection);


        textSalary = new JTextField();
        textSalary.setBounds(340, 320, 80, 25);
        contentPane.add(textSalary);

        textUser = new JTextField();
        textUser.setBounds(80, 360, 80, 25);
        contentPane.add(textUser);


        textPass = new JTextField();
        textPass.setBounds(340, 360, 80, 25);
        contentPane.add(textPass);

        textRange = new JTextField();
        textRange.setBounds(80, 400, 80, 25);
        contentPane.add(textRange);


        // Botones

        btnCreateEmployee = new JButton();
        btnCreateEmployee.setBounds(110, 360, 120, 25);
        btnCreateEmployee.setText("Crear empleado");
        contentPane.add(btnCreateEmployee);
        btnCreateEmployee.addActionListener(this);

        btnCancel = new JButton();
        btnCancel.setBounds(250, 360, 120, 25);
        btnCancel.setText("Cancelar");
        contentPane.add(btnCancel);
        btnCancel.addActionListener(this);

        btnDeleteAll = new JButton();
        btnDeleteAll.setBounds(390, 360, 120, 25);
        btnDeleteAll.setText("Borrar todo");
        contentPane.add(btnDeleteAll);
        btnDeleteAll.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCreateEmployee) {

        }
        if (e.getSource() == btnCancel) {

        }
        if (e.getSource() == btnDeleteAll) {

        }
    }

    public void getDatos() {
        //REcoge todos los datos
    }
}