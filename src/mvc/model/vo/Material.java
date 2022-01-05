package mvc.model.vo;

public class Material {

    private String nameMaterial;
    private float weightMaterial;
    private int unitsMaterial;
    //activity associated
    private String othersMaterial;

    ///GETTERS AND SETTERS///

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
    public float getWeightMaterial()
    {
        return weightMaterial;
    }

    public void setWeightMaterial(float weightMaterial)
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
    //get

    //set

    ///OTHERS///
    public String getOthersMaterial()
    {
        return othersMaterial;
    }

    public void setOthersMaterial(String othersMaterial)
    {
        this.othersMaterial = othersMaterial;
    }

}
