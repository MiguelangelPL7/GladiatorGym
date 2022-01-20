package mvc.view.orderWindow;

import mvc.controller.Coordinator;
import mvc.model.vo.Order;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class OrderListWindow extends JPanel {

    private Coordinator coordinator;

    private JPanel contentPane;

    public OrderListWindow() {
        initComponents();
    }

    private void initComponents() {
        contentPane = new JPanel();
    }

    private void viewOrders() {
        ArrayList<Order> orders = coordinator.solicitarListaPedidos();

        contentPane.setLayout(new GridLayout(1, 8));
        contentPane.add(new JLabel("Numero"));
        contentPane.add(new JLabel("NID"));
        contentPane.add(new JLabel("Nombre"));
        contentPane.add(new JLabel("Precio"));
        contentPane.add(new JLabel("Fecha de pedido"));
        contentPane.add(new JLabel("Fecha de llegada"));
        contentPane.add(new JLabel("Peso"));
        contentPane.add(new JLabel("Dni empleado"));

        if(orders != null) {
            contentPane.setLayout(new GridLayout(orders.size(), 8));
            for(int i = 1; i <= 8; i++) {
                contentPane.add(new JLabel(i+""));
                contentPane.add(new JLabel(orders.get(i).getNidOrder()));
                contentPane.add(new JLabel(orders.get(i).getNidOrder()));
                contentPane.add(new JLabel(orders.get(i).getPriceOrder()+""));
                contentPane.add(new JLabel(orders.get(i).getOrderDateOrder()));
                contentPane.add(new JLabel(orders.get(i).getDateDeliveryOrder()));
                contentPane.add(new JLabel(orders.get(i).getWeightOrder()+""));
                contentPane.add(new JLabel(orders.get(i).getEmployeeDniOrder()));
            }
        }
    }

    public Coordinator getCoordinator() {
        return coordinator;
    }

    public void setCoordinator(Coordinator coordinator) {
        this.coordinator = coordinator;
    }

    public JPanel getContentPane() {
        viewOrders();
        return contentPane;
    }

    public void setContentPane(JPanel contentPane) {
        this.contentPane = contentPane;
    }
}
