package utils;

import pages.AppointmentFlowPage;
import pages.LoginPage;

public class PageInitializer {

    public static LoginPage loginPage;
    public static AppointmentFlowPage appointmentFlowPage;

    public static void initializePageObjects(){
        loginPage=new LoginPage();
        appointmentFlowPage=new AppointmentFlowPage();
    }
}
