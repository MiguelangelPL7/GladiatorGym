package mvc.view.orderWindow;

import mvc.controller.Coordinator;
import mvc.model.vo.Material;
import mvc.model.vo.Order;
import utils.PropertyNames;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class OrderAddWindow extends JPanel implements ActionListener {

    private Coordinator coordinator;

    private JPanel contentPane;

    private JLabel lblTitle, lblNid, lblName,  lblPrice, lblDateDelivery, lblWeight;

    private JTextField textNid, textName, textPrice, textDateDelivery, textWeight;

    private JButton btnMakeOrder, btnCancel, btnDeleteAll;

    public OrderAddWindow() {
        initComponents();
    }

    private void initComponents() {
        contentPane = new JPanel();

        contentPane.setLayout(null);

        lblTitle = new JLabel("CREAR PEDIDO");
        lblTitle.setBounds(250, 20, 1000, 100);
        lblTitle.setFont(new java.awt.Font("Verdana", 1, 18));
        contentPane.add(lblTitle);

        lblNid = new JLabel("NID");
        lblNid.setBounds(150, 100, 80, 25);
        contentPane.add(lblNid);

        textNid = new JTextField(20);
        textNid.setBounds(200, 100, 80, 25);
        contentPane.add(textNid);

        lblName = new JLabel("Nombre proveedor");
        lblName.setBounds(50, 150, 120, 25);
        contentPane.add(lblName);

        textName = new JTextField(20);
        textName.setBounds(200, 150, 80, 25);
        contentPane.add(textName);

        lblPrice = new JLabel("Precio");
        contentPane.add(lblPrice);

        textPrice = new JTextField(20);
        contentPane.add(textPrice);

        lblDateDelivery = new JLabel("Fecha de entrega");
        contentPane.add(lblDateDelivery);

        textDateDelivery = new JTextField(20);
        contentPane.add(textDateDelivery);

        lblWeight = new JLabel("Peso");
        contentPane.add(lblWeight);

        textWeight = new JTextField(20);
        contentPane.add(textWeight);

        /*d = new JLabel("MID Material");
        contentPane.add(s);

        s = new JTextField(20);
        contentPane.add(s);

        d = new JLabel("Unidades");
        contentPane.add(s);

        s = new JTextField(20);
        contentPane.add(s);

        d = new JLabel("Precio");
        contentPane.add(s);

        s = new JTextField(20);
        contentPane.add(s);*/

        // Botones

        btnMakeOrder = new JButton("Realizar pedido");
        contentPane.add(btnMakeOrder);
        btnMakeOrder.addActionListener(this);

        btnCancel = new JButton("Cancelar");
        contentPane.add(btnCancel);
        btnCancel.addActionListener(this);

        btnDeleteAll = new JButton("Borrar todo");
        contentPane.add(btnDeleteAll);
        btnDeleteAll.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnMakeOrder) {
            onBtnMakeOrder();
        }
        if (e.getSource() == btnCancel) {

        }
        if (e.getSource() == btnDeleteAll) {

        }
    }

    private void onBtnMakeOrder() {
        try{
            double price = Double.parseDouble(textPrice.getText());
            double weight = Double.parseDouble(textWeight.getText());

            Order order = new Order();
            order.setNidOrder(textNid.getText());
            order.setNameProviderOrder(textName.getText());
            order.setPriceOrder(price);
            order.setDateDeliveryOrder(textDateDelivery.getText());
            order.setWeightOrder(weight);

            ArrayList<Material> materials = new ArrayList<>();

            int result = coordinator.validarAdicionPedido(order, materials);

            //-10 = rango inválido para realizar accion
            // 1 = adicion correcta;
            // 0= adicion fallida
            // -1 = atributos inválidos
            // -2 = materiales inválidos
            if(result == 1) {

            } else {
                String message = "";
                switch (result) {
                    case -10:
                        message = "Rango invalido para realizar la accion";
                        break;
                    case -2:
                        message = "Materiales invalido";
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
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,"Debe ingresar un dato numerico","Error",JOptionPane.ERROR_MESSAGE);
        }
    }

    public void getDatos() {
        //REcoge todos los datos
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
