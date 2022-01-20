package mvc.controller;

import mvc.model.Logic;
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

public class GladiatorGym {

    private Coordinator coordinator;
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

    public static void main(String[] args) {
        GladiatorGym gladiatorGym = new GladiatorGym();
        gladiatorGym.init();
    }

    private void init() {
        // Instancias
        coordinator = new Coordinator();
        logic = new Logic();

        //Instancias de ventanas
        activityWindow = new ActivityWindow();
        activityModifyWindow = new ActivityModifyWindow();
        activityPointWindow = new ActivityPointWindow();
        employeeWindow = new EmployeeWindow();
        employeeAddWindow = new EmployeeAddWindow();
        materialWindow = new MaterialWindow();
        materialAddWindow = new MaterialAddWindow();
        materialModifyWindow = new MaterialModifyWindow();
        materialListWindow = new MaterialListWindow();
        memberWindow = new MemberWindow();
        memberAddWindow = new MemberAddWindow();
        orderWindow = new OrderWindow();
        orderAddWindow = new OrderAddWindow();
        orderListWindow = new OrderListWindow();
        trackWindow = new TrackWindow();
        trackPointWindow = new TrackPointWindow();
        trackModifyWindow = new TrackModifyWindow();
        mainWindow = new MainWindow();
        singUpWindow = new SingUpWindow();

        // Establecer ventanas
        logic.setCoordinator(coordinator);
        activityWindow.setCoordinator(coordinator);
        activityModifyWindow.setCoordinator(coordinator);
        activityPointWindow.setCoordinator(coordinator);
        employeeWindow.setCoordinator(coordinator);
        employeeAddWindow.setCoordinator(coordinator);
        materialWindow.setCoordinator(coordinator);
        materialAddWindow.setCoordinator(coordinator);
        materialModifyWindow.setCoordinator(coordinator);
        materialListWindow.setCoordinator(coordinator);
        memberWindow.setCoordinator(coordinator);
        memberAddWindow.setCoordinator(coordinator);
        orderWindow.setCoordinator(coordinator);
        orderAddWindow.setCoordinator(coordinator);
        orderListWindow.setCoordinator(coordinator);
        trackWindow.setCoordinator(coordinator);
        trackPointWindow.setCoordinator(coordinator);
        trackModifyWindow.setCoordinator(coordinator);
        mainWindow.setCoordinator(coordinator);
        singUpWindow.setCoordinator(coordinator);

        // Establecer coordinator
        coordinator.setLogic(logic);
        coordinator.setActivityWindow(activityWindow);
        coordinator.setActivityModifyWindow(activityModifyWindow);
        coordinator.setActivityPointWindow(activityPointWindow);
        coordinator.setEmployeeWindow(employeeWindow);
        coordinator.setEmployeeAddWindow(employeeAddWindow);
        coordinator.setMaterialWindow(materialWindow);
        coordinator.setMaterialAddWindow(materialAddWindow);
        coordinator.setMaterialModifyWindow(materialModifyWindow);
        coordinator.setMaterialListWindow(materialListWindow);
        coordinator.setMemberWindow(memberWindow);
        coordinator.setMemberAddWindow(memberAddWindow);
        coordinator.setOrderWindow(orderWindow);
        coordinator.setOrderAddWindow(orderAddWindow);
        coordinator.setOrderListWindow(orderListWindow);
        coordinator.setTrackWindow(trackWindow);
        coordinator.setTrackPointWindow(trackPointWindow);
        coordinator.setTrackModifyWindow(trackModifyWindow);
        coordinator.setMainWindow(mainWindow);
        coordinator.setSingUpWindow(singUpWindow);

        singUpWindow.setVisible(true);
    }
}