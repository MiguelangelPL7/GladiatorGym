package mvc.model.vo;


public class Employee {

    public static enum gradeEmployee {receptionist, manager, instructor}

    private String dniEmployee;
    private String nameEmployee;
    private String surnamesEmployee;
    private String dateAdmissionEmployee;
    private byte ageEmployee;
    private String dateOfBirthdayEmployee;
    private String paymentMethodEmployee;
    private int phoneEmployee;
    private String mailEmployee;
    private String addressEmployee;
    private int salaryEmployee;
    private String userEmployee;
    private String passwordEmployee;
    private gradeEmployee grade;

    ///GETTERS AND SETTERS///

    ///DNI///
    public String getDniEmployee()
    {
        return dniEmployee;
    }

    public void setDniEmployee(String dniEmployee)
    {
        this.dniEmployee = dniEmployee;
    }

    ///NAME///
    public String getNameEmployee()
    {
        return nameEmployee;
    }

    public void setNameEmployee(String nameEmployee)
    {
        this.nameEmployee = nameEmployee;
    }

    ///SURNAME///
    public String getSurnamesEmployee()
    {
        return surnamesEmployee;
    }

    public void setSurnamesEmployee(String surnamesEmployee)
    {
        this.surnamesEmployee = surnamesEmployee;
    }

    ///DATE OF ADMISSION///
    public String getDateAdmissionEmployee()
    {
        return dateAdmissionEmployee;
    }

    public void setDateAdmissionEmployee(String dateAdmissionEmployee)
    {
        this.dateAdmissionEmployee = dateAdmissionEmployee;
    }

    ///AGE///
    public byte getAgeEmployee()
    {
        return ageEmployee;
    }

    public void setAgeEmployee(byte ageEmployee)
    {
        this. ageEmployee = ageEmployee;
    }


    ///DATE OF BIRTHDAY///
    public String getDateOfBirthdayEmployee()
    {
        return dateOfBirthdayEmployee;
    }

    public void setDateOfBirthdayEmployee(String dateOfBirthdayEmployee)
    {
        this.dateOfBirthdayEmployee = dateOfBirthdayEmployee;
    }

    ///PAYMENT METHOD///
    public String getPaymentMethodEmployee()
    {
        return paymentMethodEmployee;
    }

    public void setPaymentMethodEmployee(String paymentMethodEmployee)
    {
        this.paymentMethodEmployee = paymentMethodEmployee;
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
        this.mailEmployee = mailEmployee;
    }

    ///ADDRESS///
    public String getAddressEmployee()
    {
        return addressEmployee;
    }

    public void setAddressEmployee(String  addressEmployee)
    {
        this.addressEmployee = addressEmployee;
    }

    ///SALARY///
    public int getSalaryEmployee()
    {
        return salaryEmployee;
    }

    public void setSalaryEmployee(int salaryEmployee)
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
        this.userEmployee = userEmployee;
    }

    ///PASSWORD///
    public String getPasswordEmployee()
    {
        return passwordEmployee;
    }

    public void setPasswordEmployee(String passwordEmployee)
    {
        this.passwordEmployee = passwordEmployee;
    }

    ///GRADE///
    public gradeEmployee getGrade()
    {
        return grade;
    }

    public void setGrade(gradeEmployee grade)
    {
        this.grade = grade;
    }

}
