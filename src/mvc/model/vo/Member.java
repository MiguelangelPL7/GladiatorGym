package mvc.model.vo;

import java.math.BigDecimal;

public class Member {

    private String dniMember;
    private String nameMember;
    private String firstsurnameMember;
    private String secondsurnameMember;
    private String rateMember;
    private String dateSubscriptionMember;
    private BigDecimal priceSubscriptionMember;
    private String dateOfBirthdayMember;
    private String paymentMethodMember;
    private String paymentNumberMember;
    private int phoneMember;
    private String mailMember;
    private String streetMember;
    private String cityMember;
    private int postalCodeMember;
    private boolean activeMember;
    private int idMember;

    ///GETTERS AND SETTERS///

    ///DNI///
    public String getDniMember()
    {
        return dniMember;
    }

    public void setDniMember(String dniMember)
    {
        this.dniMember = dniMember;
    }

    ///NAME///
    public String getNameMember()
    {
        return nameMember;
    }

    public void setNameMember(String nameMember)
    {
        this.nameMember = nameMember;
    }

    ///FIRST SURNAME///
    public String getFirstsurnameMember()
    {
        return firstsurnameMember;
    }

    public void setFirstsurnameMember(String firstsurnameMember)
    {
        this.firstsurnameMember = firstsurnameMember;
    }

    ///SECOND SURNAME///
    public String getSecondsurnameMember()
    {
        return secondsurnameMember;
    }

    public void setSecondsurnameMember(String secondsurnameMember)
    {
        this.secondsurnameMember = secondsurnameMember;
    }

    ///RATE///
    public String getRateMember()
    {
        return rateMember;
    }

    public void setRateMember(String rateMember)
    {
        this.rateMember = rateMember;
    }

    ///DATE OF SUBSCRIPTION///
    public String getDateSubscriptionMember()
    {
        return dateSubscriptionMember;
    }

    public void setDateSubscriptionMember(String dateSubscriptionMember)
    {
        this.dateSubscriptionMember =  dateSubscriptionMember;
    }

    ///PRICE OF SUBSCRIPTION///
    public BigDecimal getPriceSubscriptionMember()
    {
        return priceSubscriptionMember;
    }

    public void setPriceSubscriptionMember(BigDecimal  priceSubscriptionMember)
    {
        this.priceSubscriptionMember = priceSubscriptionMember;
    }

    ///DATE OF BIRTHDAY///
    public String getDateOfBirthdayMember()
    {
        return dateOfBirthdayMember;
    }

    public void setDateOfBirthdayMember(String dateOfBirthdayMember)
    {
        this.dateOfBirthdayMember = dateOfBirthdayMember;
    }

    ///PAYMENT METHOD///
    public String getPaymentMethodMember()
    {
        return paymentMethodMember;
    }

    public void setPaymentMethodMember(String paymentMethodMember)
    {
        this.paymentMethodMember = paymentMethodMember;
    }

    ///NUMBER METHOD///
    public String getPaymentNumberMember()
    {
        return paymentNumberMember;
    }

    public void setPaymentNumberMember(String paymentNumberMember)
    {
        this.paymentNumberMember = paymentNumberMember;
    }


    ///PHONE NUMBER///
    public int getPhoneMember()
    {
        return phoneMember;
    }

    public void setPhoneMember(int phoneMember)
    {
        this.phoneMember = phoneMember;
    }

    ///MAIL///
    public String getMailMember()
    {
        return mailMember;
    }

    public void setMailMember(String mailMember)
    {
        this.mailMember = mailMember;
    }

    ///STREET///
    public String getStreetMember()
    {
        return streetMember;
    }

    public void setStreetMember(String  streetMember)
    {
        this.streetMember = streetMember;
    }

    ///CITY///
    public String getCityMember()
    {
        return cityMember;
    }

    public void setCityMember(String cityMember)
    {
        this.cityMember = cityMember;
    }

    ///POSTAL CODE///
    public int getPostalCodeMember()
    {
        return postalCodeMember;
    }

    public void setPostalCodeMember(int  postalCodeMember)
    {
        this.postalCodeMember = postalCodeMember;
    }

    ///ACTIVE: TRUE OR FALSE///
    public boolean getActiveMember()
   {
       return activeMember;
   }

    public void setActiveMember(boolean  activeMember)
    {
        this.activeMember = activeMember;
    }

    ///ID///
    public int getIdMember()
    {
        return idMember;
    }

    public void setIdMember(int  idMember)
    {
        this.idMember = idMember;
    }

}
