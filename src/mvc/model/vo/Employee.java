package mvc.model.vo;


import java.math.BigDecimal;

public class Employee {



    private String dniEmployee;
    private String nameEmployee;
    private String firstSurnameEmployee;
    private String secondSurnameEmployee;
    private String dateAdmissionEmployee;
    private String dateOfBirthdayEmployee;
    private String paymentMethodEmployee;
    private String paymentNumberEmployee;
    private int phoneEmployee;
    private String mailEmployee;
    private String streetEmployee;
    private String cityEmployee;
    private int postalCodeEmployee;
    private double salaryEmployee;
    private String userEmployee;
    private String passwordEmployee;
    private String gradeEmployee;

    public Employee(){
        setPhoneEmployee(0);
        setPostalCodeEmployee(0);
        setSalaryEmployee(0);
    }

    ///GETTERS AND SETTERS///

    ///DNI///
    public String getDniEmployee()
    {
        return dniEmployee;
    }

    public void setDniEmployee(String dniEmployee)
    {
        this.dniEmployee = checkEmpty(dniEmployee);
    }

    ///NAME///
    public String getNameEmployee()
    {
        return nameEmployee;
    }

    public void setNameEmployee(String nameEmployee)
    {
        this.nameEmployee = checkEmpty(nameEmployee);
    }

    ///SURNAME///
    ///FIRST///
    public String getFirstSurnameEmployee()
    {
        return firstSurnameEmployee;
    }

    public void setFirstSurnameEmployee(String firstSurnameEmployee)
    {
        this.firstSurnameEmployee = checkEmpty(firstSurnameEmployee);
    }

    ///SECOND///
    public String getSecondSurnameEmployee()
    {
        return secondSurnameEmployee;
    }

    public void setSecondSurnameEmployee(String secondSurnameEmployee)
    {
        this.secondSurnameEmployee = checkEmpty(secondSurnameEmployee);
    }

    ///DATE OF ADMISSION///
    public String getDateAdmissionEmployee()
    {
        return dateAdmissionEmployee;
    }

    public void setDateAdmissionEmployee(String dateAdmissionEmployee)
    {
        this.dateAdmissionEmployee = checkEmpty(dateAdmissionEmployee);
    }

    ///DATE OF BIRTHDAY///
    public String getDateOfBirthdayEmployee()
    {
        return dateOfBirthdayEmployee;
    }

    public void setDateOfBirthdayEmployee(String dateOfBirthdayEmployee)
    {
        this.dateOfBirthdayEmployee = checkEmpty(dateOfBirthdayEmployee);
    }

    ///PAYMENT METHOD///
    public String getPaymentMethodEmployee()
    {
        return paymentMethodEmployee;
    }

    public void setPaymentMethodEmployee(String paymentMethodEmployee)
    {
        this.paymentMethodEmployee = checkEmpty(paymentMethodEmployee);
    }

    ///PAYMENT NUMBER///
    public String getPaymentNumberEmployee()
    {
        return paymentNumberEmployee;
    }

    public void setPaymentNumberEmployee(String paymentNumberEmployee)
    {
        this.paymentNumberEmployee = checkEmpty(paymentNumberEmployee);
    }

    ///PHONE NUMBER///
    public int getPhoneEmployee()
    {
        return phoneEmployee;
    }

    public void setPhoneEmployee(int phoneEmployee)
    {
        this.phoneEmployee = phoneEmployee;
    }

    ///MAIL///
    public String getMailEmployee()
    {
        return mailEmployee;
    }

    public void setMailEmployee(String mailEmployee)
    {
        this.mailEmployee = checkEmpty(mailEmployee);
    }

    ///ADDRESS///
    ///STREET///
    public String getStreetEmployee()
    {
        return streetEmployee;
    }

    public void setStreetEmployee(String  streetEmployee)
    {
        this.streetEmployee = checkEmpty(streetEmployee);
    }

    ///CITY
    public String getCityEmployee()
    {
        return cityEmployee;
    }

    public void setCityEmployee(String cityEmployee)
    {
        this.cityEmployee = checkEmpty(cityEmployee);
    }

    ///POSTAL CODE///
    public int getPostalCodeEmployee()
    {
        return postalCodeEmployee;
    }

    public void setPostalCodeEmployee(int  postalCodeEmployee)
    {
        this.postalCodeEmployee = postalCodeEmployee;
    }


    ///SALARY///
    public double getSalaryEmployee()
    {
        return salaryEmployee;
    }

    public void setSalaryEmployee(double salaryEmployee)
    {
        this.salaryEmployee = salaryEmployee;
    }

    ///USER///
    public String getUserEmployee()
    {
        return userEmployee;
    }

    public void setUserEmployee(String userEmployee)
    {
        this.userEmployee = checkEmpty(userEmployee);
    }

    ///PASSWORD///
    public String getPasswordEmployee()
    {
        return passwordEmployee;
    }

    public void setPasswordEmployee(String passwordEmployee)
    {
        this.passwordEmployee = checkEmpty(passwordEmployee);
    }

    ///GRADE///
    public String getGradeEmployee()
    {
        return gradeEmployee;
    }

    public void setGradeEmployee(String gradeEmployee)
    {
        this.gradeEmployee = checkEmpty(gradeEmployee);
    }

    private String checkEmpty(String s){
        if(s==null || s.equals("")) {
            s = null;
        }
        return s;

    }

}
