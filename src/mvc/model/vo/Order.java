package mvc.model.vo;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class Order {

    private String nidOrder;
    private String nameProviderOrder;
    private double priceOrder;
    private String orderDateOrder;
    private String dateDeliveryOrder;
    private double weightOrder;
    private String employeeDniOrder;

    public Order(){
        setPriceOrder(0);
        setWeightOrder(0);
    }

    ///GETTERS AND SETTERS///

    ///NID///
    public String getNidOrder()
    {
        return nidOrder;
    }

    public void setNidOrder(String nidOrder)
    {
        this.nidOrder = checkEmpty(nidOrder);
    }

    ///NAME PROVIDER///
    public String getNameProviderOrder()
    {
        return nameProviderOrder;
    }

    public void setNameProviderOrder(String nameProviderOrder)
    {
        this.nameProviderOrder = checkEmpty(nameProviderOrder);
    }

    ///PRICE///
    public double getPriceOrder()
    {
        return priceOrder;
    }

    public void setPriceOrder(double priceOrder)
    {
        this.priceOrder = priceOrder;
    }

    ///DATE OF THE ORDER///
    public String getOrderDateOrder()
    {
        return orderDateOrder;
    }

    public void setOrderDateOrder(String orderDateOrder)
    {
        this.orderDateOrder = checkEmpty(orderDateOrder);
    }

    ///DATE OF THE DELIVERY///
    public String getDateDeliveryOrder()
    {
        return dateDeliveryOrder;
    }

    public void setDateDeliveryOrder(String dateDeliveryOrder)
    {
        this.dateDeliveryOrder = checkEmpty(dateDeliveryOrder);
    }

    ///WEIGHT///
    public double getWeightOrder()
    {
        return weightOrder;
    }

    public void setWeightOrder(double weightOrder)
    {
        this.weightOrder = weightOrder;
    }

    ///EMPLOYEE DNI///
    public String getEmployeeDniOrder()
    {
        return employeeDniOrder;
    }

    public void setEmployeeDniOrder(String employeeDniOrder)
    {
        this.employeeDniOrder = checkEmpty(employeeDniOrder);
    }

    private String checkEmpty(String s){
        if(s==null || s.equals("")) {
            s = null;
        }
        return s;

    }

}
