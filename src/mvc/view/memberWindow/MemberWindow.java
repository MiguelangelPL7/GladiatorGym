package mvc.view.memberWindow;

import mvc.controller.Coordinator;
import mvc.model.vo.Member;
import utils.PropertyNames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MemberWindow extends JPanel implements ActionListener {

    private Coordinator coordinator;

    private JPanel contentPane;

    private JButton btnNewMember, btnSearchMember, btnDeleteMember;

    private JTextField textDni;

    public MemberWindow() {
        initComponents();
    }

    private void initComponents() {
        contentPane = new JPanel();

        contentPane.setLayout(new GridLayout(4, 1));


        btnNewMember = new JButton("Nuevo miembro");
        btnNewMember.setBounds(20, 100, 30, 30);
        btnNewMember.addActionListener(this);
        contentPane.add(btnNewMember);

        textDni = new JTextField(20);
        contentPane.add(textDni);

        btnSearchMember = new JButton("Buscar miembro");
        btnSearchMember.setBounds(20, 100, 30, 30);
        btnSearchMember.addActionListener(this);
        contentPane.add(btnSearchMember);

        btnDeleteMember = new JButton("Eliminar miembro");
        btnDeleteMember.setBounds(20, 100, 30, 30);
        btnDeleteMember.addActionListener(this);
        contentPane.add(btnDeleteMember);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnNewMember) {
            coordinator.loadPanel(32);
        }
        if (e.getSource() == btnSearchMember) {
            onBtnSearchEmployee();
        }
        if (e.getSource() == btnDeleteMember) {
            onBtnDeleteMember();
        }
    }

    private void onBtnSearchEmployee() {
        if (!textDni.getText().equals("")) {
            try {
                int id = Integer.parseInt(textDni.getText());
                Member member = coordinator.solicitarInfoMiembro(id);
                if(member.getIdMember()==0){
                    String message = "El ID no es correcto";
                    JOptionPane.showMessageDialog(null, message, PropertyNames.WARNING_MESSAGE_TITLE, JOptionPane.WARNING_MESSAGE);
                }else{
                    coordinator.setMember(member);
                    coordinator.loadPanel(32);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null,"Debe ingresar un dato numerico","Error",JOptionPane.ERROR_MESSAGE);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Debe poner un DNI", PropertyNames.WARNING_MESSAGE_TITLE, JOptionPane.WARNING_MESSAGE);
        }
    }

    private void onBtnDeleteMember() {
        if (!textDni.getText().equals("")) {
            try {
                int id = Integer.parseInt(textDni.getText());
                int result = coordinator.validarEliminacionMiembro(id);
                //-10 = rango inválido para realizar accion
                // 1 = eliminacion correcta
                //-2 = id de miembro no existente o ya activo

                if(result == 1) {

                } else {
                    String message = "";
                    switch (result) {
                        case -10:
                            message = "Rango invalido para realizar la accion";
                            break;
                        case -2:
                            message = "El DNI no es correcto";
                    }
                    JOptionPane.showMessageDialog(null, message, PropertyNames.WARNING_MESSAGE_TITLE, JOptionPane.WARNING_MESSAGE);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null,"Debe ingresar un dato numerico","Error",JOptionPane.ERROR_MESSAGE);
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
