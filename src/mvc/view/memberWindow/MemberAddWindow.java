package mvc.view.memberWindow;

import mvc.controller.Coordinator;
import mvc.model.vo.Employee;
import mvc.model.vo.Member;
import utils.PropertyNames;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MemberAddWindow extends JPanel implements ActionListener {

    private Coordinator coordinator;

    private JPanel contentPane;

    private JLabel lblTitle, lblDni, lblName, lblFirstSurname, lblSecondSurname, lblRate, lblDateSubscription,
            lblPriceSubscription, lblDateOfBirth, lblPaymentMethod, lblPaymentNumber, lblPhone, lblMail, lblStreet,
            lblCity, lblPostalCode, lblId;

    private JTextField textDni, textName, textFirstSurname, textSecondSurname, textRate, textDateSubscription,
            textPriceSubscription, textDateOfBirth, textPaymentMethod, textPaymentNumber, textPhone, textMail,
            textStreet, textCity, textPostalCode, textId;

    private JButton btnMemberAdd, btnDeleteAll;

    private JCheckBox checkBoxActive;

    public MemberAddWindow() {
        initComponents();
    }

    private void initComponents() {
        contentPane = new JPanel();

        lblTitle = new JLabel("CREAR UN MIEMBRO");
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

        lblRate = new JLabel("Tarifa");
        contentPane.add(lblRate);

        textRate = new JTextField(20);
        contentPane.add(textRate);

        lblDateSubscription = new JLabel("Fecha de suscripcion");
        contentPane.add(lblDateSubscription);

        textDateSubscription = new JTextField(20);
        contentPane.add(textDateSubscription);

        lblPriceSubscription = new JLabel("Precio de subscripcion");
        contentPane.add(lblPriceSubscription);

        textPriceSubscription = new JTextField(20);
        contentPane.add(textPriceSubscription);

        lblDateOfBirth = new JLabel("Fecha de nacimiento");
        contentPane.add(lblDateOfBirth);

        textDateOfBirth = new JTextField(20);
        contentPane.add(textDateOfBirth);

        lblPaymentMethod = new JLabel("Metodo de pago");
        contentPane.add(lblPaymentMethod);

        textPaymentMethod = new JTextField(20);
        contentPane.add(textPaymentMethod);

        lblPaymentNumber = new JLabel("Numero de pago");
        contentPane.add(lblPaymentNumber);

        textPaymentNumber = new JTextField(20);
        contentPane.add(textPaymentNumber);

        lblPhone = new JLabel("Telefono");
        contentPane.add(lblPhone);

        textPhone = new JTextField(20);
        contentPane.add(textPhone);

        lblMail = new JLabel("Correo electronico");
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

        checkBoxActive = new JCheckBox("Activo");
        contentPane.add(checkBoxActive);

        lblId = new JLabel("ID");
        contentPane.add(lblId);
        lblId.setVisible(false);

        textId = new JTextField(20);
        contentPane.add(textId);
        textId.setVisible(false);

        // Botones

        btnMemberAdd = new JButton();
        btnMemberAdd.setBounds(110, 360, 120, 25);
        btnMemberAdd.setText("Añadir miembro");
        contentPane.add(btnMemberAdd);
        btnMemberAdd.addActionListener(this);

        btnDeleteAll = new JButton();
        btnDeleteAll.setBounds(390, 360, 120, 25);
        btnDeleteAll.setText("Borrar todo");
        contentPane.add(btnDeleteAll);
        btnDeleteAll.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnMemberAdd) {
            onBtnAddMember();
        }
        if (e.getSource() == btnDeleteAll) {
            deleteAllFields();
        }
    }

    private void deleteAllFields() {
        textDni.setText("");
        textName.setText("");
        textFirstSurname.setText("");
        textSecondSurname.setText("");
        textRate.setText("");
        textDateSubscription.setText("");
        textPriceSubscription.setText("");
        textDateOfBirth.setText("");
        textPaymentMethod.setText("");
        textPaymentNumber.setText("");
        textPhone.setText("");
        textMail.setText("");
        textStreet.setText("");
        textCity.setText("");
        textPostalCode.setText("");
    }

    private void onBtnAddMember() {
        int result = coordinator.validarNuevoMiembro(getMemberData());
        ////-10 = rango inválido para realizar accion
        // 1 = adicion correcta;
        // 0= adicion fallida
        // -1 = atributos inválidos
        //-2 = DNI ya existente
        if (result == 1) {

        } else {
            String message = "";
            switch (result) {
                case -10:
                    message = "Rango invalido para realizar la accion";
                    break;
                case -2:
                    message = "El DNI ya existe";
                    break;
                case -1:
                    message = "Atributos invalidos";
                    break;
                case 0:
                    message = "No se ha podido añadir";
                    break;
            }
            JOptionPane.showMessageDialog(null, message, PropertyNames.WARNING_MESSAGE_TITLE, JOptionPane.WARNING_MESSAGE);
        }
    }

    private Member getMemberData() {
        double price = 0;
        int phone = 0;
        int postalCode = 0;
        int id = 0;
        if (!textId.getText().equals("")) {
            try {
                id = Integer.parseInt(textId.getText());
            } catch (Exception e) {
                id = 0;
            }
        }
        if (!textPostalCode.getText().equals("")) {
            try {
                postalCode = Integer.parseInt(textPostalCode.getText());
            } catch (Exception e) {
                postalCode = 0;
            }
        }
        if (!textPhone.getText().equals("")) {
            try {
                phone = Integer.parseInt(textPhone.getText());
            } catch (Exception e) {
                phone = 0;
            }
        }
        if (!textPriceSubscription.getText().equals("")) {
            try {
                price = Double.parseDouble(textPriceSubscription.getText());
            } catch (Exception e) {
                price = 0;
            }
        }
        Member member = new Member();
        member.setDniMember(textDni.getText());
        member.setNameMember(textName.getText());
        member.setFirstsurnameMember(textFirstSurname.getText());
        member.setSecondsurnameMember(textSecondSurname.getText());
        member.setRateMember(textRate.getText());
        member.setDateSubscriptionMember(textDateSubscription.getText());
        member.setPriceSubscriptionMember(price);
        member.setDateOfBirthdayMember(textDateOfBirth.getText());
        member.setPaymentMethodMember(textPaymentMethod.getText());
        member.setPaymentNumberMember(textPaymentNumber.getText());
        member.setPhoneMember(phone);
        member.setMailMember(textMail.getText());
        member.setStreetMember(textStreet.getText());
        member.setCityMember(textCity.getText());
        member.setPostalCodeMember(postalCode);
        if (checkBoxActive.isSelected()) {
            member.setActiveMember(true);
        } else {
            member.setActiveMember(false);
        }
        member.setIdMember(id);

        return member;
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
