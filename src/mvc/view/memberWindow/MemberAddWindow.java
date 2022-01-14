package mvc.view.memberWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MemberAddWindow extends JDialog implements ActionListener {

    private JPanel contentPane;

    private JLabel title;
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

    private JTextField textName, textSurname, textDni, textRate, textAge, textDateOfBirth, textPrice, textPaymentMethod,
    textNumberPhone, textMail, textDirection;

    private JButton btnSave;
    private JButton btnCancel;
    private JButton btnDeleteAll;

    public MemberAddWindow() {
        initComponents();
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

        rate = new JLabel();
        rate.setText("Tarifa");
        rate.setBounds(20, 160, 80, 25);
        contentPane.add(rate);

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

        price = new JLabel();
        price.setText("Precio");
        price.setBounds(20, 240, 80, 25);
        contentPane.add(price);

        paymentMethod = new JLabel();
        paymentMethod.setText("Metodo de pago");
        paymentMethod.setBounds(290, 240, 120, 25);
        contentPane.add(paymentMethod);

        numberPhone = new JLabel();
        numberPhone.setText("Telefono");
        numberPhone.setBounds(20, 280, 80, 25);
        contentPane.add(numberPhone);

        mail = new JLabel();
        mail.setText("Correo");
        mail.setBounds(290, 280, 80, 25);
        contentPane.add(mail);

        direction = new JLabel();
        direction.setText("Direccion");
        direction.setBounds(20, 320, 80, 25);
        contentPane.add(direction);

        textName = new JTextField();
        textName.setBounds(80, 120, 190, 25);
        contentPane.add(textName);

        textSurname = new JTextField();
        textSurname.setBounds(340, 120, 190, 25);
        contentPane.add(textSurname);

        textRate = new JTextField();
        textRate.setBounds(80, 160, 80, 25);
        contentPane.add(textRate);

        textDni = new JTextField();
        textDni.setBounds(340, 160, 80, 25);
        contentPane.add(textDni);

        textAge = new JTextField();
        textAge.setBounds(80, 200, 190, 25);
        contentPane.add(textAge);

        textDateOfBirth = new JTextField();
        textDateOfBirth.setBounds(340, 200, 120, 25);
        contentPane.add(textDateOfBirth);

        textPrice = new JTextField();
        textPrice.setBounds(80, 240, 80, 25);
        contentPane.add(textPrice);

        textPaymentMethod = new JTextField();
        paymentMethod.setBounds(340, 240, 120, 25);
        contentPane.add(paymentMethod);

        textNumberPhone = new JTextField();
        textNumberPhone.setBounds(80, 280, 80, 25);
        contentPane.add(textNumberPhone);

        textMail = new JTextField();
        textMail.setBounds(340, 280, 80, 25);
        contentPane.add(textMail);

        textDirection = new JTextField();
        textDirection.setBounds(80, 320, 80, 25);
        contentPane.add(textDirection);

        // Botones

        btnSave = new JButton();
        btnSave.setBounds(110, 360, 120, 25);
        btnSave.setText("Guardar");
        contentPane.add(btnSave);
        btnSave.addActionListener(this);

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
        if (e.getSource() == btnSave) {

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
