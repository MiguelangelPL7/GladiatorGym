package mvc.view.orderWindow;

import mvc.controller.Coordinator;
import utils.PropertyNames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OrderWindow extends JPanel implements ActionListener {

    private Coordinator coordinator;

    private JPanel contentPane;

    private JLabel lblNid;

    private JTextField textNid;

    private JButton btnCreateOrder, btnViewOrders, btnCancelOrder, btnCompleteOrder;

    public OrderWindow() {
        contentPane = new JPanel();

        contentPane.setLayout(new GridLayout(6, 1));

        btnCreateOrder = new JButton(PropertyNames.BTN_CREATE_ORDER);
        btnCreateOrder.addActionListener(this);
        contentPane.add(btnCreateOrder);

        btnViewOrders = new JButton(PropertyNames.BTN_VIEW_ORDER);
        btnViewOrders.addActionListener(this);
        contentPane.add(btnViewOrders);


        lblNid = new JLabel("NID");
        contentPane.add(lblNid);

        textNid = new JTextField(20);
        contentPane.add(textNid);

        btnCompleteOrder = new JButton("Completar pedido");
        btnCompleteOrder.setBounds(20, 100, 30, 30);
        btnCompleteOrder.addActionListener(this);
        contentPane.add(btnCompleteOrder);

        btnCancelOrder = new JButton("Cancelar pedido");
        btnCancelOrder.setBounds(20, 100, 30, 30);
        btnCancelOrder.addActionListener(this);
        contentPane.add(btnCancelOrder);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCreateOrder) {
            coordinator.loadPanel(42);
        }
        if (e.getSource() == btnViewOrders) {
            coordinator.loadPanel(43);
        }
        if (e.getSource() == btnCancelOrder) {
            onBtnCancelOrder();
        }
        if (e.getSource() == btnCompleteOrder) {
            onBtnCompleteOrder();
        }
    }

    private void onBtnCancelOrder() {
        if (!textNid.getText().equals("")) {
            //-10 = rango inválido para realizar accion
            //-2 = nid de pedido no existente
            // -1 = eliminacion no posible ya, fecha muy tarde para cancelar
            // 1 = eliminacion correcta
            int result = coordinator.validarCancelacionPedido(textNid.getText());
            if(result == 1) {

            } else {
                String message = "";
                switch (result) {
                    case -10:
                        message = "Rango invalido para realizar la accion";
                        break;
                    case -2:
                        message = "El nid de pedido no existe";
                        break;
                    case -1:
                        message = "Eliminacion no posible, fecha muy tarde para cancelar";
                        break;
                }
                JOptionPane.showMessageDialog(null, message, PropertyNames.WARNING_MESSAGE_TITLE, JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe poner un NID", PropertyNames.WARNING_MESSAGE_TITLE, JOptionPane.WARNING_MESSAGE);
        }
    }

    private void onBtnCompleteOrder() {
        if (!textNid.getText().equals("")) {
            //-10 = rango inválido para realizar accion
            //-2 = nid de pedido no existente
            // 1 = pedido completado con exito
            int result = coordinator.validarCompletarPedido(textNid.getText());
            if(result == 1) {

            } else {
                String message = "";
                switch (result) {
                    case -10:
                        message = "Rango invalido para realizar la accion";
                        break;
                    case -2:
                        message = "El nid de pedido no existe";
                        break;
                }
                JOptionPane.showMessageDialog(null, message, PropertyNames.WARNING_MESSAGE_TITLE, JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe poner un NID", PropertyNames.WARNING_MESSAGE_TITLE, JOptionPane.WARNING_MESSAGE);
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