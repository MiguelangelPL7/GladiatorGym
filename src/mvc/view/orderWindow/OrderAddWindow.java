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

    private JButton btnMakeOrder, btnDeleteAll;

    private JPanel panel1, panel2, panel3;

    private JLabel l1, l2, l3, l11, l12, l13, l21, l22, l23, l31, l32, l33;

    private JTextField t11, t12, t13, t21, t22, t23, t31, t32, t33;

    public OrderAddWindow() {
        initComponents();
    }

    private void initComponents() {
        contentPane = new JPanel();

        lblTitle = new JLabel("CREAR PEDIDO");
        lblTitle.setFont(new java.awt.Font("Verdana", 1, 18));
        contentPane.add(lblTitle);

        lblNid = new JLabel("NID");
        contentPane.add(lblNid);

        textNid = new JTextField(20);
        contentPane.add(textNid);

        lblName = new JLabel("Nombre proveedor");
        contentPane.add(lblName);

        textName = new JTextField(20);
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

        panel1 = new JPanel();

        l1 = new JLabel("Material 1:");
        panel1.add(l1);

        l11 = new JLabel("MID");
        panel1.add(l11);

        t11 = new JTextField(20);
        panel1.add(t11);

        l12 = new JLabel("Unidades");
        panel1.add(l12);

        t12 = new JTextField(20);
        panel1.add(t12);

        l13 = new JLabel("Precio");
        panel1.add(l13);

        t13 = new JTextField(20);
        panel1.add(t13);

        //
        panel2 = new JPanel();

        l2 = new JLabel("Material 2:");
        panel2.add(l2);

        l21 = new JLabel("MID");
        panel2.add(l21);

        t21 = new JTextField(20);
        panel2.add(t21);

        l22 = new JLabel("Unidades");
        panel2.add(l22);

        t22 = new JTextField(20);
        panel2.add(t22);

        l23 = new JLabel("Precio");
        panel2.add(l23);

        t23 = new JTextField(20);
        panel2.add(t23);

        //
        panel3 = new JPanel();

        l3 = new JLabel("Material 3:");
        panel3.add(l3);

        l31 = new JLabel("MID");
        panel3.add(l31);

        t31 = new JTextField(20);
        panel3.add(t31);

        l32 = new JLabel("Unidades");
        panel3.add(l32);

        t32 = new JTextField(20);
        panel3.add(t32);

        l33 = new JLabel("Precio");
        panel3.add(l33);

        t33 = new JTextField(20);
        panel3.add(t33);

        contentPane.add(panel1);
        contentPane.add(panel2);
        contentPane.add(panel3);

        // Botones

        btnMakeOrder = new JButton("Realizar pedido");
        contentPane.add(btnMakeOrder);
        btnMakeOrder.addActionListener(this);


        btnDeleteAll = new JButton("Borrar todo");
        contentPane.add(btnDeleteAll);
        btnDeleteAll.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnMakeOrder) {
            onBtnMakeOrder();
        }
        if (e.getSource() == btnDeleteAll) {

        }
    }

    private void onBtnMakeOrder() {
        double price = 0;
        double weight = 0;
        if(!textPrice.getText().equals("")) {
            try {
                price = Double.parseDouble(textPrice.getText());
            } catch (Exception e) {
                price = 0;
            }
        }
        if(!textWeight.getText().equals("")) {
            try {
                weight = Double.parseDouble(textWeight.getText());
            } catch (Exception e) {
                weight = 0;
            }
        }
        Order order = new Order();
        order.setNidOrder(textNid.getText());
        order.setNameProviderOrder(textName.getText());
        order.setPriceOrder(price);
        order.setDateDeliveryOrder(textDateDelivery.getText());
        order.setWeightOrder(weight);

        ArrayList<Material> materials = createMaterials();

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
    }

    private ArrayList<Material> createMaterials() {
        ArrayList<Material> materials = new ArrayList<>();
        Material m1 = new Material();
        if(!l11.equals("") && !l12.equals("") && !l13.equals("")) {
            m1.setMidMaterial(l11.getText());
            m1.setUnitsMaterial(Integer.parseInt(l12.getText()));
            m1.setPriceOrderMaterial(Double.parseDouble(l13.getText()));
            materials.add(m1);
        }
        Material m2 = new Material();
        if(!l21.equals("") && !l22.equals("") && !l23.equals("")) {
            m2.setMidMaterial(l21.getText());
            m2.setUnitsMaterial(Integer.parseInt(l22.getText()));
            m2.setPriceOrderMaterial(Double.parseDouble(l23.getText()));
            materials.add(m2);
        }
        Material m3 = new Material();
        if(!l31.equals("") && !l32.equals("") && !l33.equals("")) {
            m3.setMidMaterial(l31.getText());
            m3.setUnitsMaterial(Integer.parseInt(l32.getText()));
            m3.setPriceOrderMaterial(Double.parseDouble(l33.getText()));
            materials.add(m3);
        }
        return materials;
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
