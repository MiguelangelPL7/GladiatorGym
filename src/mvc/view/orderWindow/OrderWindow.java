package mvc.view.orderWindow;

import mvc.controller.Coordinator;
import mvc.view.memberWindow.MemberAddWindow;
import utils.PropertyNames;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OrderWindow extends JPanel implements ActionListener {

    private Coordinator coordinator;

    private JPanel contentPane;

    private JButton btnCreateOrder;
    private JButton btnViewOrders;

    private JLabel name;
    private JLabel price;
    private JLabel dateOrder;
    private JLabel dateDelivery;
    private JLabel weight;
    private JLabel listOrder;

    public OrderWindow() {
        contentPane = new JPanel();

        name = new JLabel();
        price = new JLabel();
        dateOrder = new JLabel();
        dateDelivery = new JLabel();
        weight = new JLabel();
        listOrder = new JLabel();

        btnCreateOrder = new JButton(PropertyNames.BTN_CREATE_ORDER);
        btnViewOrders = new JButton(PropertyNames.BTN_VIEW_ORDER);

        contentPane.add(name);
        contentPane.add(price);
        contentPane.add(dateOrder);
        contentPane.add(dateDelivery);
        contentPane.add(weight);
        contentPane.add(listOrder);

        contentPane.add(btnCreateOrder);
        contentPane.add(btnViewOrders);

        btnCreateOrder.addActionListener(this);
        btnViewOrders.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCreateOrder) {
            OrderAddWindow orderAddWindow = new OrderAddWindow();
            orderAddWindow.pack();
            orderAddWindow.setVisible(true);
        }
        if (e.getSource() == btnViewOrders) {

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