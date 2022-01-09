package mvc.model.dao;

import conexion.ConexionBD;

import mvc.model.vo.Order;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.ArrayList;

public class OrderDAO extends ConexionBD {

    ///LISTA DE PEDIDOS///
    public ArrayList<Order> listOrder()
    {
        ArrayList<Order> listOfOrder = new <Order>ArrayList();
        try {

            String sql = "SELECT * FROM pedidos";
            ResultSet rsc = this.ejecutarSQL(sql);


            while (rsc.next()) {
                Order order = new Order();
                order.setNidOrder(rsc.getString("NID"));
                order.setNameProviderOrder(rsc.getString("NombreProveedor"));
                order.setWeightOrder(rsc.getBigDecimal("PesoTotal"));
                order.setPriceOrder(rsc.getBigDecimal("PedidoPrecio"));
                order.setOrderDateOrder(rsc.getString("FechaPedido"));
                order.setDateDeliveryOrder(rsc.getString("FechaEstimadaEntrega"));
                order.setEmployeeDniOrder(rsc.getString("EmpleadoDNI"));

                listOfOrder.add(order);

            }

            rsc.close();
        } catch (Exception e) {
            System.out.println("Error conexión con el Servidor MySQL.\n" + e.getMessage());
        }

        return(listOfOrder);
    }

    ///CANCELAR PEDIDO///
    public void cancelOrder(String nid)
    {
        try
        {
            String sql = "";
            String NID = nid;

            sql = "DELETE FROM order WHERE NID="+NID+";";
            this.ejecutarActualizacion(sql);
        }
        catch (Exception e) {
            System.out.println("Error conexión con el Servidor MySQL.\n" + e.getMessage());
        }

    }

    ///AGREGAR PEDIDO///
    public void registerOrder(Order order)
    {
        try{

            String sql = "";

            String nid = order.getNidOrder();
            String name = order.getNameProviderOrder();
            BigDecimal weight = order.getWeightOrder();
            BigDecimal price = order.getPriceOrder();
            String dateOrder = order.getOrderDateOrder();
            String dateDelivery = order.getDateDeliveryOrder();
            String empDni = order.getEmployeeDniOrder();


            sql = "INSERT INTO pedidos (NID, NombreProveedor, PesoTotal, PedidoPrecio,"+
                    " FechaPedido, FechaEstimadaEntrega, EmpleadoDNI) VALUES('"+nid+"','"+name+"','"+weight+"',"+
                    ""+price+",'"+dateOrder+"','"+dateDelivery+"','"+empDni+"');";

            this.ejecutarActualizacion(sql);
        }
        catch (Exception e)
        {
            System.out.println("Error conexión con el Servidor MySQL.\n" + e.getMessage());
        }
    }


}
