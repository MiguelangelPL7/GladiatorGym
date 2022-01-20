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

    public Material(){
        setWeightMaterial(0);
        setUnitsMaterial(0);
        setPriceOrderMaterial(0);
    }

    ///GETTERS AND SETTERS///
    ///MID///
    public String getMidMaterial()
    {
        return midMaterial;
    }

    public void setMidMaterial(String midMaterial)
    {
        this.midMaterial = checkEmpty(midMaterial);
    }

    ///NAME///
    public String getNameMaterial()
    {
        return nameMaterial;
    }

    public void setNameMaterial(String nameMaterial)
    {
        this.nameMaterial = checkEmpty(nameMaterial);
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
        this.brandMaterial = checkEmpty(brandMaterial);
    }

    ///BRAND///
    public String getActivityMaterial()
    {
        return  activityMaterial;
    }

    public void  setActivityMaterial(String activityMaterial)
    {
        this.activityMaterial = checkEmpty(activityMaterial);
    }

    ///OTHERS///
    public String getOthersMaterial()
    {
        return othersMaterial;
    }

    public void setOthersMaterial(String othersMaterial)
    {
        this.othersMaterial = checkEmpty(othersMaterial);
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

    private String checkEmpty(String s){
        if(s==null || s.equals("")) {
            s = null;
        }
        return s;

    }

}
