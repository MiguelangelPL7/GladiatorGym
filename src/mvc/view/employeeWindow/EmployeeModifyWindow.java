package mvc.view.employeeWindow;

import mvc.controller.Coordinator;
import mvc.model.vo.Employee;
import utils.PropertyNames;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmployeeModifyWindow extends JPanel implements ActionListener {

    private Coordinator coordinator;

    private JPanel contentPane;

    private JLabel lblTitle, lblDni, lblName, lblFirstSurname, lblSecondSurname, lblDateInit, lblDateOfBirtht,
            lblPaymentMethod, lblPaymentNumber, lblNumberPhone, lblMail, lblStreet, lblCity, lblPostalCode,
            lblSalary, lblUser, lblPass, lblRange;

    private JTextField textDni, textName, textFirstSurname, textSecondSurname, textDateInit, textDateOfBirtht,
            textPaymentNumber, textNumberPhone, textMail, textStreet, textCity, textPostalCode,
            textSalary, textUser, textPass;

    private JComboBox textRange, textPaymentMethod;

    private JButton btnDeleteAll, btnModifyEmployee;

    private Employee employee;

    public EmployeeModifyWindow() {
        initComponents();
    }

    private void initComponents() {
        contentPane = new JPanel();

        lblTitle = new JLabel("CREAR UN EMPLEADO");
        lblTitle.setFont(new java.awt.Font("Verdana", 1, 18));
        contentPane.add(lblTitle);

        lblDni = new JLabel("DNI");
        contentPane.add(lblDni);

        textDni = new JTextField(20);
        contentPane.add(textDni);

        lblName = new JLabel("Nombre");
        contentPane.add(lblName);

        textName = new JTextField(20);
        contentPane.add(textName);

        lblFirstSurname = new JLabel("Primer apellido");
        contentPane.add(lblFirstSurname);

        textFirstSurname = new JTextField(20);
        contentPane.add(textFirstSurname);

        lblSecondSurname = new JLabel("Segundo apellido");
        contentPane.add(lblSecondSurname);

        textSecondSurname = new JTextField(20);
        contentPane.add(textSecondSurname);

        lblDateInit = new JLabel("Fecha de incio");
        contentPane.add(lblDateInit);

        textDateInit = new JTextField(20);
        contentPane.add(textDateInit);

        lblDateOfBirtht = new JLabel("Fecha de nacimiento");
        contentPane.add(lblDateOfBirtht);

        textDateOfBirtht = new JTextField(20);
        contentPane.add(textDateOfBirtht);

        lblPaymentMethod = new JLabel("Metodo de pago");
        contentPane.add(lblPaymentMethod);

        String optionsToChoose1[] = {"Tarjeta", "PayPal", "Cuenta"};
        textPaymentMethod= new JComboBox(optionsToChoose1);
        contentPane.add(textPaymentMethod);

        lblPaymentNumber = new JLabel("Numero de pago");
        contentPane.add(lblPaymentNumber);

        textPaymentNumber = new JTextField(20);
        contentPane.add(textPaymentNumber);

        lblNumberPhone = new JLabel("Telefono");
        contentPane.add(lblNumberPhone);

        textNumberPhone = new JTextField(20);
        contentPane.add(textNumberPhone);

        lblMail = new JLabel("Correo electrónico");
        contentPane.add(lblMail);

        textMail = new JTextField(20);
        contentPane.add(textMail);

        lblStreet = new JLabel("Calle");
        contentPane.add(lblStreet);

        textStreet = new JTextField(20);
        contentPane.add(textStreet);

        lblCity = new JLabel("Ciudad");
        contentPane.add(lblCity);

        textCity = new JTextField(20);
        contentPane.add(textCity);

        lblPostalCode = new JLabel("Codigo postal");
        contentPane.add(lblPostalCode);

        textPostalCode = new JTextField(20);
        contentPane.add(textPostalCode);

        lblSalary = new JLabel("Salario");
        contentPane.add(lblSalary);

        textSalary = new JTextField(20);
        contentPane.add(textSalary);

        lblUser = new JLabel("Usuario");
        contentPane.add(lblUser);

        textUser = new JTextField(20);
        contentPane.add(textUser);

        lblPass = new JLabel("Contraseña");
        contentPane.add(lblPass);

        textPass = new JTextField(20);
        contentPane.add(textPass);

        lblRange = new JLabel("Rol");
        contentPane.add(lblRange);

        String optionsToChoose2[] = {"Recepcionista", "Manager", "Monitor"};
        textRange = new JComboBox(optionsToChoose2);
        contentPane.add(textRange);

        // Botones

        btnModifyEmployee = new JButton();
        btnModifyEmployee.setBounds(110, 360, 120, 25);
        btnModifyEmployee.setText("Modificar empleado");
        btnModifyEmployee.addActionListener(this);
        contentPane.add(btnModifyEmployee);

        btnDeleteAll = new JButton();
        btnDeleteAll.setBounds(390, 360, 120, 25);
        btnDeleteAll.setText("Borrar todo");
        btnDeleteAll.addActionListener(this);
        contentPane.add(btnDeleteAll);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnModifyEmployee) {
            onBtnModifyEmployee();
        }
        if (e.getSource() == btnDeleteAll) {
            deleteAllFields();
        }
    }

    private void onBtnModifyEmployee() {
        int result = coordinator.validarModificacionEmpleado(getEmployeeData());
        //-10 = rango inválido para realizar accion
        // 1 = adicion correcta;
        //0= adicion fallida
        // -1 = atributos inválidos
        //-2 = id de empleado no existente
        if (result == 1) {

        } else {
            String message = "";
            switch (result) {
                case -10:
                    message = "Rango invalido para realizar la accion";
                    break;
                case -2:
                    message = "El DNI no es correcto";
                    break;
                case -1:
                    message = "Atributos invalidos";
                    break;
                case 0:
                    message = "No se ha podido modificar";
                    break;
            }
            JOptionPane.showMessageDialog(null, message, PropertyNames.WARNING_MESSAGE_TITLE, JOptionPane.WARNING_MESSAGE);
        }
    }

    private void deleteAllFields() {
        textDni.setText("");
        textName.setText("");
        textFirstSurname.setText("");
        textSecondSurname.setText("");
        textDateInit.setText("");
        textDateOfBirtht.setText("");
        textPaymentNumber.setText("");
        textNumberPhone.setText("");
        textMail.setText("");
        textStreet.setText("");
        textCity.setText("");
        textPostalCode.setText("");
        textSalary.setText("");
        textUser.setText("");
        textPass.setText("");
    }

    private void fillFields() {
        String phone = String.valueOf(employee.getPhoneEmployee());
        if (phone.equals("0")) {
            phone = "";
        }
        String postalCode = String.valueOf(employee.getPostalCodeEmployee());
        if (postalCode.equals("0")) {
            postalCode = "";
        }
        String salary = String.valueOf(employee.getSalaryEmployee());
        if (salary.equals("0.0")) {
            salary = "";
        }

        textDni.setText(employee.getDniEmployee());
        textName.setText(employee.getNameEmployee());
        textFirstSurname.setText(employee.getFirstSurnameEmployee());
        textSecondSurname.setText(employee.getSecondSurnameEmployee());
        textDateInit.setText(employee.getDateAdmissionEmployee());
        textDateOfBirtht.setText(employee.getDateOfBirthdayEmployee());
        int pos=0;
        switch (employee.getPaymentMethodEmployee()){
            case "Tarjeta":
                pos=0;
                break;
            case "PayPal":
                pos=1;
                break;
            case "Cuenta":
                pos=2;
                break;
        }
        textPaymentMethod.setSelectedIndex(pos);
        textPaymentNumber.setText(employee.getPaymentNumberEmployee());
        textNumberPhone.setText(phone);
        textMail.setText(employee.getMailEmployee());
        textStreet.setText(employee.getStreetEmployee());
        textCity.setText(employee.getCityEmployee());
        textPostalCode.setText(postalCode);
        textSalary.setText(salary);
        textUser.setText(employee.getUserEmployee());
        textPass.setText(employee.getPasswordEmployee());
        int pos2=0;
        switch (employee.getGradeEmployee()){
            case "Recepcionista":
                pos2=0;
                break;
            case "Manager":
                pos2=1;
                break;
            case "Monitor":
                pos2=2;
                break;
        }
        textRange.setSelectedIndex(pos2);
    }

    private Employee getEmployeeData() {
        int phone = 0;
        int postalCode = 0;
        double salaryEmployee = 0;
        if (!textNumberPhone.getText().equals("")) {
            try {
                phone = Integer.parseInt(textNumberPhone.getText());
            } catch (Exception e) {
                phone = 0;
            }
        }
        if (!textPostalCode.getText().equals("")) {
            try {
                postalCode = Integer.parseInt(textPostalCode.getText());
            } catch (Exception e) {
                postalCode = 0;
            }
        }
        if (!textSalary.getText().equals("")) {
            try {
                salaryEmployee = Double.parseDouble(textSalary.getText());
            } catch (Exception e) {
                salaryEmployee = 0;
            }
        }
        Employee employee = new Employee();
        employee.setDniEmployee(textDni.getText());
        employee.setNameEmployee(textName.getText());
        employee.setFirstSurnameEmployee(textFirstSurname.getText());
        employee.setSecondSurnameEmployee(textSecondSurname.getText());
        employee.setDateAdmissionEmployee(textDateInit.getText());
        employee.setDateOfBirthdayEmployee(textDateOfBirtht.getText());
        employee.setPaymentMethodEmployee(textPaymentMethod.getSelectedItem().toString());
        employee.setPaymentNumberEmployee(textPaymentNumber.getText());
        employee.setPhoneEmployee(phone);
        employee.setMailEmployee(textMail.getText());
        employee.setStreetEmployee(textStreet.getText());
        employee.setCityEmployee(textCity.getText());
        employee.setPostalCodeEmployee(postalCode);
        employee.setSalaryEmployee(salaryEmployee);
        employee.setUserEmployee(textUser.getText());
        employee.setPasswordEmployee(textPass.getText());
        employee.setGradeEmployee(textRange.getSelectedItem().toString());
        return employee;
    }

    public Coordinator getCoordinator() {
        return coordinator;
    }

    public void setCoordinator(Coordinator coordinator) {
        this.coordinator = coordinator;
    }

    public JPanel getContentPane() {
        if (employee != null) {
            fillFields();
        }
        return contentPane;
    }

    public void setContentPane(JPanel contentPane) {
        this.contentPane = contentPane;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}