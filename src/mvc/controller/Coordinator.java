package mvc.controller;

import mvc.model.Logic;
import mvc.view.MainWindow;
import mvc.view.SingUpWindow;
import mvc.view.activityWindow.ActivityWindow;
import mvc.view.employeeWindow.EmployeeWindow;
import mvc.view.materialWindow.MaterialWindow;
import mvc.view.memberWindow.MemberWindow;
import mvc.view.orderWindow.OrderWindow;
import mvc.view.trackWindow.TrackWindow;

import javax.swing.*;

public class Coordinator {


    private Logic logic;

    private ActivityWindow activityWindow;
    private EmployeeWindow employeeWindow;
    private MaterialWindow materialWindow;
    private MemberWindow memberWindow;
    private OrderWindow orderWindow;
    private TrackWindow trackWindow;
    private MainWindow mainWindow;
    private SingUpWindow singUpWindow;

    public Logic getLogic() {
        return logic;
    }

    public void setLogic(Logic logic) {
        this.logic = logic;
    }

    public ActivityWindow getActivityWindow() {
        return activityWindow;
    }

    public void setActivityWindow(ActivityWindow activityWindow) {
        this.activityWindow = activityWindow;
    }

    public EmployeeWindow getEmployeeWindow() {
        return employeeWindow;
    }

    public void setEmployeeWindow(EmployeeWindow employeeWindow) {
        this.employeeWindow = employeeWindow;
    }

    public MaterialWindow getMaterialWindow() {
        return materialWindow;
    }

    public void setMaterialWindow(MaterialWindow materialWindow) {
        this.materialWindow = materialWindow;
    }

    public MemberWindow getMemberWindow() {
        return memberWindow;
    }

    public void setMemberWindow(MemberWindow memberWindow) {
        this.memberWindow = memberWindow;
    }

    public OrderWindow getOrderWindow() {
        return orderWindow;
    }

    public void setOrderWindow(OrderWindow orderWindow) {
        this.orderWindow = orderWindow;
    }

    public TrackWindow getTrackWindow() {
        return trackWindow;
    }

    public void setTrackWindow(TrackWindow trackWindow) {
        this.trackWindow = trackWindow;
    }

    public MainWindow getMainWindow() {
        return mainWindow;
    }

    public void setMainWindow(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
    }

    public SingUpWindow getSingUpWindow() {
        return singUpWindow;
    }

    public void setSingUpWindow(SingUpWindow singUpWindow) {
        this.singUpWindow = singUpWindow;
    }


    // MOSTRAR VENTANAS


    public void viewActivityWindow() {
        activityWindow.setVisible(true);
    }

    public void viewEmployeeWindow() {
        employeeWindow.setVisible(true);
    }

    public void viewMaterialWindow() {
        materialWindow.setVisible(true);
    }

    public void viewMemberWindow() {
        memberWindow.setVisible(true);
    }

    public void viewOrderWindow() {
        orderWindow.setVisible(true);
    }

    public void viewTrackWindow() {
        //trackWindow.setVisible(true);
    }

    public void viewMainWindow() {
        mainWindow.setVisible(true);
    }

    public void viewSingUpWindow() {
        singUpWindow.setVisible(true);
    }



    // PANELES

    public JPanel activityWindow() {
        return orderWindow.getContentPane();
    }

    public JPanel employeeWindow() {
        return employeeWindow.getContentPane();
    }

    public JPanel materialWindow() {
        return materialWindow.getContentPane();
    }

    public JPanel memberWindow() {
        return memberWindow.getContentPane();
    }

    public JPanel orderWindow() {
        return orderWindow.getContentPane();
    }

    /*public JPanel trackWindow() {
        //return trackWindow.getContentPane();
    }*/

    public JPanel singUpWindow() {
        return singUpWindow.getContentPane();
    }

    //////// CLASE LOGICA ///////

}
