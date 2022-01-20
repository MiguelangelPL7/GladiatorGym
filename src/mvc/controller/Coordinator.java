package mvc.controller;

import mvc.model.Logic;
import mvc.model.vo.*;
import mvc.view.MainWindow;
import mvc.view.SingUpWindow;
import mvc.view.activityWindow.ActivityModifyWindow;
import mvc.view.activityWindow.ActivityPointWindow;
import mvc.view.activityWindow.ActivityWindow;
import mvc.view.employeeWindow.EmployeeAddWindow;
import mvc.view.employeeWindow.EmployeeWindow;
import mvc.view.materialWindow.MaterialAddWindow;
import mvc.view.materialWindow.MaterialListWindow;
import mvc.view.materialWindow.MaterialModifyWindow;
import mvc.view.materialWindow.MaterialWindow;
import mvc.view.memberWindow.MemberAddWindow;
import mvc.view.memberWindow.MemberWindow;
import mvc.view.orderWindow.OrderAddWindow;
import mvc.view.orderWindow.OrderListWindow;
import mvc.view.orderWindow.OrderWindow;
import mvc.view.trackWindow.TrackModifyWindow;
import mvc.view.trackWindow.TrackPointWindow;
import mvc.view.trackWindow.TrackWindow;

import javax.swing.*;
import java.util.ArrayList;

public class Coordinator {

    private Logic logic;

    private ActivityWindow activityWindow;
    private ActivityModifyWindow activityModifyWindow;
    private ActivityPointWindow activityPointWindow;
    private EmployeeWindow employeeWindow;
    private EmployeeAddWindow employeeAddWindow;
    private MaterialWindow materialWindow;
    private MaterialAddWindow materialAddWindow;
    private MaterialModifyWindow materialModifyWindow;
    private MaterialListWindow materialListWindow;
    private MemberWindow memberWindow;
    private MemberAddWindow memberAddWindow;
    private OrderWindow orderWindow;
    private OrderAddWindow orderAddWindow;
    private OrderListWindow orderListWindow;
    private TrackWindow trackWindow;
    private TrackModifyWindow trackModifyWindow;
    private TrackPointWindow trackPointWindow;
    private MainWindow mainWindow;
    private SingUpWindow singUpWindow;

    private Activity activity;
    private Employee employee;
    private Member member;
    private Track track;
    private Material material;

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

    public ActivityModifyWindow getActivityModifyWindow() {
        return activityModifyWindow;
    }

    public void setActivityModifyWindow(ActivityModifyWindow activityModifyWindow) {
        this.activityModifyWindow = activityModifyWindow;
    }

    public ActivityPointWindow getActivityPointWindow() {
        return activityPointWindow;
    }

    public void setActivityPointWindow(ActivityPointWindow activityPointWindow) {
        this.activityPointWindow = activityPointWindow;
    }

    public EmployeeWindow getEmployeeWindow() {
        return employeeWindow;
    }

    public void setEmployeeWindow(EmployeeWindow employeeWindow) {
        this.employeeWindow = employeeWindow;
    }

    public EmployeeAddWindow getEmployeeAddWindow() {
        return employeeAddWindow;
    }

    public void setEmployeeAddWindow(EmployeeAddWindow employeeAddWindow) {
        this.employeeAddWindow = employeeAddWindow;
    }

    public MaterialWindow getMaterialWindow() {
        return materialWindow;
    }

    public void setMaterialWindow(MaterialWindow materialWindow) {
        this.materialWindow = materialWindow;
    }

    public MaterialAddWindow getMaterialAddWindow() {
        return materialAddWindow;
    }

    public void setMaterialAddWindow(MaterialAddWindow materialAddWindow) {
        this.materialAddWindow = materialAddWindow;
    }

    public MemberWindow getMemberWindow() {
        return memberWindow;
    }

    public void setMemberWindow(MemberWindow memberWindow) {
        this.memberWindow = memberWindow;
    }

    public MemberAddWindow getMemberAddWindow() {
        return memberAddWindow;
    }

    public void setMemberAddWindow(MemberAddWindow memberAddWindow) {
        this.memberAddWindow = memberAddWindow;
    }

    public OrderWindow getOrderWindow() {
        return orderWindow;
    }

    public void setOrderWindow(OrderWindow orderWindow) {
        this.orderWindow = orderWindow;
    }

    public OrderAddWindow getOrderAddWindow() {
        return orderAddWindow;
    }

    public void setOrderAddWindow(OrderAddWindow orderAddWindow) {
        this.orderAddWindow = orderAddWindow;
    }

    public TrackWindow getTrackWindow() {
        return trackWindow;
    }

    public void setTrackWindow(TrackWindow trackWindow) {
        this.trackWindow = trackWindow;
    }

    public TrackModifyWindow getTrackModifyWindow() {
        return trackModifyWindow;
    }

    public void setTrackModifyWindow(TrackModifyWindow trackModifyWindow) {
        this.trackModifyWindow = trackModifyWindow;
    }

    public TrackPointWindow getTrackPointWindow() {
        return trackPointWindow;
    }

    public void setTrackPointWindow(TrackPointWindow trackPointWindow) {
        this.trackPointWindow = trackPointWindow;
    }

    public MaterialModifyWindow getMaterialModifyWindow() {
        return materialModifyWindow;
    }

    public void setMaterialModifyWindow(MaterialModifyWindow materialModifyWindow) {
        this.materialModifyWindow = materialModifyWindow;
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

    public MaterialListWindow getMaterialListWindow() {
        return materialListWindow;
    }

    public void setMaterialListWindow(MaterialListWindow materialListWindow) {
        this.materialListWindow = materialListWindow;
    }

    public OrderListWindow getOrderListWindow() {
        return orderListWindow;
    }

    public void setOrderListWindow(OrderListWindow orderListWindow) {
        this.orderListWindow = orderListWindow;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public Track getTrack() {
        return track;
    }

    public void setTrack(Track track) {
        this.track = track;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public void loadPanel(int panel) {
        switch (panel) {

            // Activity
            case 1:
                mainWindow.changePanelLeft(activityWindow.getContentPane());
                break;
            case 2:
                mainWindow.changePanelCenter(activityPointWindow.getContentPane());
                break;
            case 3:
                activityModifyWindow.setActivity(getActivity());
                mainWindow.changePanelCenter(activityModifyWindow.getContentPane());
                break;

            // Employee
            case 11:
                mainWindow.changePanelLeft(employeeWindow.getContentPane());
                break;
            case 12:
                employeeAddWindow.setEmployee(getEmployee());
                mainWindow.changePanelCenter(employeeAddWindow.getContentPane());
                break;

            // Material
            case 21:
                mainWindow.changePanelLeft(materialWindow.getContentPane());
                break;
            case 22:
                mainWindow.changePanelCenter(materialAddWindow.getContentPane());
                break;
            case 23:
                mainWindow.changePanelCenter(materialModifyWindow.getContentPane());
                break;
            case 24:
                mainWindow.changePanelCenter(materialListWindow.getContentPane());
                break;

            // Member
            case 31:
                mainWindow.changePanelLeft(memberWindow.getContentPane());
                break;
            case 32:
                memberAddWindow.setMember(getMember());
                mainWindow.changePanelCenter(memberAddWindow.getContentPane());
                break;

            // Order
            case 41:
                mainWindow.changePanelLeft(orderWindow.getContentPane());
                break;
            case 42:
                mainWindow.changePanelCenter(orderAddWindow.getContentPane());
                break;
            case 43:
                mainWindow.changePanelCenter(orderListWindow.getContentPane());
                break;

            // Track
            case 51:
                mainWindow.changePanelLeft(trackWindow.getContentPane());
                break;
            case 52:
                mainWindow.changePanelCenter(trackPointWindow.getContentPane());
                break;
            case 53:
                trackModifyWindow.setTrack(getTrack());
                mainWindow.changePanelCenter(trackModifyWindow.getContentPane());
                break;
        }
    }

    // FRAMES

    public void viewMainWindow() {
        mainWindow.setVisible(true);
    }

    public void viewSingUpWindow() {
        singUpWindow.setVisible(true);
    }

    // PANELES

    public JPanel activityWindow() {
        return activityWindow.getContentPane();
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

    public JPanel activityPanelIzq() {
        return activityWindow.getContentPane();
    }


    //////// CLASE LOGICA ///////

    public int validarInicioSesion(String dni, String pass) {
        return logic.validarInicioSesion(dni, pass);
    }

    public int validarApuntarMiembroA(int id, int pid, String horario) {
        return logic.validarApuntarMiembroA(id, pid, horario);
    }

    public int validarApuntarMiembroP(int id, int pid, String horario, int horasDuracion) {
        return logic.validarApuntarMiembroP(id, pid, horario, horasDuracion);
    }

    public int validarModificarAtributosA(Activity activity) {
        return logic.validarModificarAtributosA(activity);
    }

    public int validarModificarAtributosP(Track track) {
        return logic.validarModificarAtributosP(track);
    }

    public int validarAdicionMaterial(Material material) {
        return logic.validarAdicionMaterial(material);
    }

    public int validarModificacionMaterial(String mid, String tipo, int uds) {
        return logic.validarModificacionMaterial(mid, tipo, uds);
    }

    public int validarEliminacionMaterial(String mid) {
        return logic.validarEliminacionMaterial(mid);
    }

    public Track solicitarInfoP(int codigoPista) {
        return logic.solicitarInfoP(codigoPista);
    }

    public Activity solicitarInfoA(int codigoActividad) {
        return logic.solicitarInfoA(codigoActividad);
    }

    public ArrayList<Material> solicitarListaMateriales() {
        return logic.solicitarListaMateriales();
    }

    public ArrayList<Order> solicitarListaPedidos() {
        return logic.solicitarListaPedidos();
    }

    public int validarAdicionPedido(Order order, ArrayList<Material> materials) {
        return logic.validarAdicionPedido(order, materials);
    }

    public int validarCancelacionPedido(String nid) {
        return logic.validarCancelacionPedido(nid);
    }

    public int validarCompletarPedido(String nid) {
        return logic.validarCompletarPedido(nid);
    }

    public int validarNuevoEmpleado(Employee em) {
        return logic.validarNuevoEmpleado(em);
    }

    public int validarEliminacionEmpleado(String DNI) {
        return logic.validarEliminacionEmpleado(DNI);
    }

    public Employee solicitarInfoEmpleado(String DNI) {
        return logic.solicitarInfoEmpleado(DNI);
    }

    public int validarModificacionEmpleado(Employee em) {
        return logic.validarModificacionEmpleado(em);
    }

    public int validarNuevoMiembro(Member me) {
        return logic.validarNuevoMiembro(me);
    }

    public int validarEliminacionMiembro(int id) {
        return logic.validarEliminacionMiembro(id);
    }

    public Member solicitarInfoMiembro(int DNI) {
        return logic.solicitarInfoMiembro(DNI);
    }

    public int validarModificacionMiembro(Member me) {
        return logic.validarModificacionMiembro(me);
    }


}