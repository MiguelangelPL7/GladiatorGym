package mvc.model.vo;

import java.math.BigDecimal;

public class Material {

    private String midMaterial;
    private String nameMaterial;
    private double weightMaterial;
    private int unitsMaterial;
    private String activityMaterial;
    private String brandMaterial;
    private String othersMaterial;
    private double priceForOrder; //ESTE PRECIO SOLO SE USA AL AÑADIR UN MATERIAL A UN PEDIDO

    ///GETTERS AND SETTERS///
    ///MID///
    public String getMidMaterial()
    {
        return midMaterial;
    }

    public void setMidMaterial(String midMaterial)
    {
        this.midMaterial = midMaterial;
    }

    ///NAME///
    public String getNameMaterial()
    {
        return nameMaterial;
    }

    public void setNameMaterial(String nameMaterial)
    {
        this.nameMaterial = nameMaterial;
    }

    ///WEIGHT///
    public double getWeightMaterial()
    {
        return weightMaterial;
    }

    public void setWeightMaterial(double weightMaterial)
    {
        this.weightMaterial = weightMaterial;
    }

    ///UNITS///
    public int getUnitsMaterial()
    {
        return unitsMaterial;
    }

    public void setUnitsMaterial(int unitsMaterial)
    {
        this.unitsMaterial = unitsMaterial;
    }

    ///ACTIVITY ASSOCIATED///
    public String getBrandMaterial()
    {
        return  brandMaterial;
    }

    public void  setBrandMaterial(String brandMaterial)
    {
        this.brandMaterial = brandMaterial;
    }

    ///BRAND///
    public String getActivityMaterial()
    {
        return  activityMaterial;
    }

    public void  setActivityMaterial(String activityMaterial)
    {
        this.activityMaterial = activityMaterial;
    }

    ///OTHERS///
    public String getOthersMaterial()
    {
        return othersMaterial;
    }

    public void setOthersMaterial(String othersMaterial)
    {
        this.othersMaterial = othersMaterial;
    }

    ///PRICE FOR ORDER/// ESTE PRECIO SOLO SE USA AL AÑADIR UN MATERIAL A UN PEDIDO
    public double getPriceOrderMaterial()
    {
        return priceForOrder;
    }

    public void setPriceOrderMaterial(double priceForOrder)
    {
        this.priceForOrder = priceForOrder;
    }

}
