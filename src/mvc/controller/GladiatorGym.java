package mvc.controller;

import mvc.model.dao.EmployeeDAO;

public class GladiatorGym {


    public static void main(String[] args) {
        EmployeeDAO employeeDAO = new EmployeeDAO();
        employeeDAO.consultarAlumnos();
    }
}