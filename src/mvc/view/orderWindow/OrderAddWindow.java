package mvc.view.orderWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OrderAddWindow extends JDialog implements ActionListener {

    private JPanel contentPane;

    private JLabel title;
    private JLabel name;
    private JLabel price;
    private JLabel dateOrder;
    private JLabel dateDelivery;
    private JLabel weight;
    private JLabel listOrder;

    private JTextField textName, textPrice, textDateOrder, textDateDelivery, textWeight, textListOrder;

    private JButton btnMakeOrder;
    private JButton btnCancel;
    private JButton btnDeleteAll;

    public OrderAddWindow() {
        initComponents();
    }

    private void initComponents() {
        contentPane = new JPanel();

        setContentPane(contentPane);
        setModal(true);

        setBounds(100, 100,800,600);

        setTitle("Crear nuevo pedido");
        setLocationRelativeTo(null);
        setLayout(null);

        title = new JLabel();
        title.setText("CREAR PEDIDO");
        title.setBounds(120, 20, 380, 30);
        title.setFont(new java.awt.Font("Verdana", 1, 18));
        contentPane.add(title);

        name = new JLabel();
        name.setText("Nombre");
        name.setBounds(20, 120, 80, 25);
        contentPane.add(name);

        price = new JLabel();
        price.setText("Precio");
        price.setBounds(290, 120, 80, 25);
        contentPane.add(price);

        dateOrder = new JLabel();
        dateOrder.setText("Fecha de pedido");
        dateOrder.setBounds(20, 160, 80, 25);
        contentPane.add(dateOrder);

        dateDelivery = new JLabel();
        dateDelivery.setText("Fecha prevista");
        dateDelivery.setBounds(290, 160, 80, 25);
        contentPane.add(dateDelivery);

        weight = new JLabel();
        weight.setText("Peso");
        weight.setBounds(20, 200, 80, 25);
        contentPane.add(weight);

        listOrder = new JLabel();
        listOrder.setText("Lista de materiales");
        listOrder.setBounds(290, 200, 120, 25);
        contentPane.add(listOrder);


        textName = new JTextField();
        textName.setBounds(80, 120, 190, 25);
        contentPane.add(textName);

        textPrice = new JTextField();
        textPrice.setBounds(340, 120, 190, 25);
        contentPane.add(textPrice);

        textDateOrder = new JTextField();
        textDateOrder.setBounds(80, 160, 80, 25);
        contentPane.add(textDateOrder);

        textDateDelivery = new JTextField();
        textDateDelivery.setBounds(340, 160, 80, 25);
        contentPane.add(textDateDelivery);

        textWeight = new JTextField();
        textWeight.setBounds(80, 200, 190, 25);
        contentPane.add(textWeight);

        textListOrder = new JTextField();
        textListOrder.setBounds(340, 200, 120, 25);
        contentPane.add(textListOrder);


        // Botones

        btnMakeOrder = new JButton();
        btnMakeOrder.setBounds(110, 360, 120, 25);
        btnMakeOrder.setText("Realizar pedido");
        contentPane.add(btnMakeOrder);
        btnMakeOrder.addActionListener(this);

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
        if (e.getSource() == btnMakeOrder) {

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
