package mvc.model.dao;

import conexion.ConexionBD;

import mvc.model.vo.Material;
import mvc.model.vo.Order;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
                order.setWeightOrder(rsc.getDouble("PesoTotal"));
                order.setPriceOrder(rsc.getDouble("PedidoPrecio"));
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

            sql = "DELETE FROM pedidos WHERE NID='"+NID+"';";
            this.ejecutarActualizacion(sql);
        }
        catch (Exception e) {
            System.out.println("Error conexión con el Servidor MySQL.\n" + e.getMessage());
        }

    }

    public boolean checkCancel(String nid)
    {
        try
        {
            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate now = LocalDate.now();

            String sql = "Select * from pedidos where NID='"+nid+"';";
            ResultSet rsc = this.ejecutarSQL(sql);

            rsc.next();
            String date=rsc.getString("FechaPedido");
            rsc.close();
            if(date.equals(dateFormat.format(now))){
                return true;
            }
        }
        catch (SQLException e) {
            System.out.println("Error conexión con el Servidor MySQL.\n" + e.getMessage());
            return false;
        }

        return false;

    }

    ///AGREGAR PEDIDO///
    public boolean registerOrder(Order order)
    {
        try{

            String sql = "";

            String nid = order.getNidOrder();
            String name = order.getNameProviderOrder();
            double weight = order.getWeightOrder();
            double price = order.getPriceOrder();
            String dateOrder = checkNullString(order.getOrderDateOrder());
            String dateDelivery = checkNullString(order.getDateDeliveryOrder());
            String empDni = checkNullString(order.getEmployeeDniOrder());


            sql = "INSERT INTO pedidos (NID, NombreProveedor, PesoTotal, PedidoPrecio,"+
                    " FechaPedido, FechaEstimadaEntrega, EmpleadoDNI) VALUES('"+nid+"','"+name+"',"+weight+","+
                    ""+price+","+dateOrder+","+dateDelivery+","+empDni+");";

            this.ejecutarActualizacion(sql);
        }
        catch (Exception e)
        {
            System.out.println("Error conexión con el Servidor MySQL.\n" + e.getMessage());
            return false;
        }

        return true;
    }

    public boolean addMaterial(String nid, Material mat)
    {
        if(validarMaterialEnPedido(nid,mat.getMidMaterial())) return false;

        try{
            String mid = mat.getMidMaterial();
            int units = mat.getUnitsMaterial();
            double price = mat.getPriceOrderMaterial();
            double tprice = price*units;


            String sql = "INSERT INTO materialespedido (NID, MID, UnidadesPedido, PrecioUnidad,"+
                    " PrecioTotalMaterial) VALUES('"+nid+"','"+mid+"',"+units+","+price+","+tprice+");";

            this.ejecutarActualizacion(sql);

            if(!subirPrecio(nid, tprice)) return false;
        }
        catch (Exception e)
        {
            System.out.println("Error conexión con el Servidor MySQL.\n" + e.getMessage());
            return false;
        }

        return true;
    }

    public ArrayList<Material> completarPedido(String nid)
    {
        ArrayList<Material> list = new <Material>ArrayList();
        try {

            String sql = "SELECT * FROM materialespedido WHERE NID='"+nid+"';";
            ResultSet rsc = this.ejecutarSQL(sql);

            while (rsc.next()) {
                Material m = new Material();
                m.setMidMaterial(rsc.getString("MID"));
                m.setUnitsMaterial(rsc.getInt("UnidadesPedido"));
                list.add(m);
            }

            rsc.close();
            cancelOrder(nid);

        } catch (Exception e) {
            System.out.println("Error conexión con el Servidor MySQL.\n" + e.getMessage());
        }

        return(list);
    }

    private boolean subirPrecio(String nid, double precio){
        try{
            String sql = "Select * from pedidos where NID='"+nid+"';";
            ResultSet rsc = this.ejecutarSQL(sql);

            rsc.next();
            double p=rsc.getDouble("PedidoPrecio")+precio;
            rsc.close();

            String sql2 = "UPDATE pedidos SET PedidoPrecio ="+p+" WHERE NID='"+nid+"';";
            this.ejecutarActualizacion(sql2);

        }catch (SQLException e) {
            System.out.println("Error al subir precio de pedido.\n" + e.getMessage());
            return false;
        }

        return true;
    }

    public String generarNID(){
        String nid=null;

        while(nid==null || validarNID(nid)){
            int num = (int)(Math.random()*900+100);
            char c1 = (char)(Math.random()*26+65);
            nid=String.valueOf(num)+c1;
        }
        return nid;
    }

    public boolean validarNID(String nid){
        try{
            String sql = "Select * from pedidos where NID='"+nid+"';";
            ResultSet rsc = this.ejecutarSQL(sql);

            if(rsc.next()){
                rsc.close();
                return true;
            }else{
                rsc.close();
                return false;
            }

        }catch (SQLException e) {
            System.out.println("Error al comprobar NID de pedido.\n" + e.getMessage());
            return false;
        }
    }

    public boolean validarMaterialEnPedido(String nid, String mid){
        try{
            String sql = "Select * from materialespedido where MID='"+mid+"' and NID='"+nid+"';";
            ResultSet rsc = this.ejecutarSQL(sql);

            if(rsc.next()){
                rsc.close();
                return true;
            }else{
                rsc.close();
                return false;
            }

        }catch (SQLException e) {
            System.out.println("Error al comprobar materialespedio.\n" + e.getMessage());
            return false;
        }
    }

    private String checkNullString(String s){
        if(s != null){ s="'"+s+"'"; }
        return s;
    }


}
