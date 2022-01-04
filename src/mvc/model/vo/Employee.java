package mvc.model.vo;

public class Employee {

    public static enum gradeEmployee {receptionist, manager, instructor}

    private String dniEmployee;
    private String nameEmployee;
    private String surnamesEmployee;
    private String dateAdmissionEmployee;
    private byte ageEmployee;
    private String dateOfBirthfayEmployee;
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

}
