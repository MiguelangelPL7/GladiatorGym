package mvc.view.employeeWindow;

import mvc.controller.Coordinator;
import mvc.model.vo.Employee;
import utils.PropertyNames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmployeeWindow extends JPanel implements ActionListener {

    private Coordinator coordinator;

    private JPanel contentPane;

    private JButton btnCreateEmployee, btnSearchEmployee, btnDeleteEmployee;

    private JTextField textDni;

    public EmployeeWindow() {
        initComponents();
    }

    private void initComponents() {
        contentPane = new JPanel();

        contentPane.setLayout(new GridLayout(4, 1));

        btnCreateEmployee = new JButton("Nuevo empleado");
        btnCreateEmployee.addActionListener(this);
        contentPane.add(btnCreateEmployee);

        textDni = new JTextField(20);
        contentPane.add(textDni);

        btnSearchEmployee = new JButton("Buscar empleado");
        btnSearchEmployee.addActionListener(this);
        contentPane.add(btnSearchEmployee);

        btnDeleteEmployee = new JButton("Eliminar empleado");
        btnDeleteEmployee.addActionListener(this);
        contentPane.add(btnDeleteEmployee);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCreateEmployee) {
            coordinator.loadPanel(12);
        }
        if (e.getSource() == btnSearchEmployee) {
            onBtnSearchEmployee();
        }
        if (e.getSource() == btnDeleteEmployee) {
            onBtnDeleteEmployee();
        }
    }

    private void onBtnSearchEmployee() {
        if (!textDni.getText().equals("")) {
            Employee employee = coordinator.solicitarInfoEmpleado(textDni.getText());
            if(employee.getDniEmployee().equals("0")){
                String message = "El DNI no es correcto";
                JOptionPane.showMessageDialog(null, message, PropertyNames.WARNING_MESSAGE_TITLE, JOptionPane.WARNING_MESSAGE);
            }else{
                textDni.setText("");
                coordinator.setEmployee(employee);
                coordinator.loadPanel(13);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe poner un ID", PropertyNames.WARNING_MESSAGE_TITLE, JOptionPane.WARNING_MESSAGE);
        }
    }

    private void onBtnDeleteEmployee() {
        if (!textDni.getText().equals("")) {
            //-10 = rango inválido para realizar accion
            //-20 = no te puedes eliminar a ti mismo
            //-2 = mid de material no existente
            int result = coordinator.validarEliminacionEmpleado(textDni.getText());
            if(result == 1) {

            } else {
                String message = "";
                switch (result) {
                    case -10:
                        message = "Rango invalido para realizar la accion";
                        break;
                    case -2:
                        message = "El DNI no es correcto";
                        break;
                    case -20:
                        message = "No te puedes eliminar a ti mismo";
                        break;
                }
                JOptionPane.showMessageDialog(null, message, PropertyNames.WARNING_MESSAGE_TITLE, JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe poner un DNI", PropertyNames.WARNING_MESSAGE_TITLE, JOptionPane.WARNING_MESSAGE);
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