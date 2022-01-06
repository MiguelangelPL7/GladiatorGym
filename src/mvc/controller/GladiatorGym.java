package mvc.controller;

import mvc.model.dao.ActivityDAO;
import mvc.model.dao.EmployeeDAO;
import mvc.model.vo.Activity;

import java.sql.Timestamp;
import java.util.ArrayList;

public class GladiatorGym {

    public static void main(String[] args) {
        ActivityDAO a = new ActivityDAO();
        Activity petanca = new Activity();
        petanca.setCapacidadMaxima(120);
        petanca.setCodigoActividad(6970);
        petanca.setActividadPID(324);
        petanca.setMonitorDNI(null);
        petanca.setActividadDisponibilidad(true);
        petanca.setActividadHorario("2022-02-10 10:00:00");

        a.registrar(petanca);

    }
}