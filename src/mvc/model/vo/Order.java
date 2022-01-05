package mvc.model.vo;

import java.lang.reflect.Array;
import java.util.HashSet;
import java.util.Set;

public class Order {

    private String nidOrder;
    private String nameProviderOrder;
    private float priceOrder;
    private String orderDateOrder;
    private String dateDeliveryOrder;
    private float weightOrder;
    //private Set<Material> materialsIncludedOrder = new HashSet<Material>();

    ///GETTERS AND SETTERS///

    ///NID///
    public String getNidOrder()
    {
        return nidOrder;
    }

    public void setNidOrder(String nidOrder)
    {
        this.nidOrder = nidOrder;
    }

    ///NAME PROVIDER///
    public String getNameProviderOrder()
    {
        return nameProviderOrder;
    }

    public void setNameProviderOrder(String nameProviderOrder)
    {
        this.nameProviderOrder = nameProviderOrder;
    }

    ///PRICE///
    public float getPriceOrder()
    {
        return priceOrder;
    }

    public void setPriceOrder(float priceOrder)
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
        this.orderDateOrder = orderDateOrder;
    }

    ///DATE OF THE DELIVERY///
    public String getDateDeliveryOrder()
    {
        return dateDeliveryOrder;
    }

    public void setDateDeliveryOrder(String dateDeliveryOrder)
    {
        this.dateDeliveryOrder = dateDeliveryOrder;
    }

    ///WEIGHT///
    public float getWeightOrder()
    {
        return weightOrder;
    }

    public void setWeightOrder(float weightOrder)
    {
        this.weightOrder = weightOrder;
    }

    ///MATERIALS INCLUDED///

}
