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
        if(orders.size() > 0) {
            contentPane.setLayout(new GridLayout(orders.size()+1, 8));
            contentPane.add(new JLabel("Numero"));
            contentPane.add(new JLabel("NID"));
            contentPane.add(new JLabel("Nombre"));
            contentPane.add(new JLabel("Precio"));
            contentPane.add(new JLabel("Fecha de pedido"));
            contentPane.add(new JLabel("Fecha de llegada"));
            contentPane.add(new JLabel("Peso"));
            contentPane.add(new JLabel("Dni empleado"));
            for(int i = 0; i < orders.size(); i++) {
                contentPane.add(new JLabel(i+1+""));
                contentPane.add(new JLabel(orders.get(i).getNidOrder()));
                contentPane.add(new JLabel(orders.get(i).getNameProviderOrder()));
                contentPane.add(new JLabel(orders.get(i).getPriceOrder()+""));
                contentPane.add(new JLabel(orders.get(i).getOrderDateOrder()));
                contentPane.add(new JLabel(orders.get(i).getDateDeliveryOrder()));
                contentPane.add(new JLabel(orders.get(i).getWeightOrder()+""));
                contentPane.add(new JLabel(orders.get(i).getEmployeeDniOrder()));
            }
        } else {
            contentPane.add(new JLabel("No hay pedidos"));
        }
    }

    public Coordinator getCoordinator() {
        return coordinator;
    }

    public void setCoordinator(Coordinator coordinator) {
        this.coordinator = coordinator;
    }

    public JPanel getContentPane() {
        contentPane.removeAll();
        viewOrders();
        return contentPane;
    }

    public void setContentPane(JPanel contentPane) {
        this.contentPane = contentPane;
    }
}
