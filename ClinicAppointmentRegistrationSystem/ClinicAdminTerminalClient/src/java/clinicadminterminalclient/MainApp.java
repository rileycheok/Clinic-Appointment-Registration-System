/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinicadminterminalclient;

import ejb.session.stateful.AppointmentControllerRemote;
import ejb.session.stateful.RegistrationControllerRemote;
import ejb.session.stateless.*;
import entity.StaffEntity;
import java.text.ParseException;
import java.util.Scanner;
import util.exception.DoctorNotFoundException;
import util.exception.EntityManagerException;
import util.exception.InvalidLoginException;
import util.exception.PatientNotFoundException;
import util.exception.StaffNotFoundException;

/**
 *
 * @author Shi Yun
 */
public class MainApp {
    
    private StaffEntityControllerRemote staffEntityControllerRemote;
    private PatientEntityControllerRemote patientEntityControllerRemote;
    private DoctorEntityControllerRemote doctorEntityControllerRemote;
    private RegistrationControllerRemote registrationControllerRemote;
    private AppointmentControllerRemote appointmentControllerRemote;
    private ConsultationEntityControllerRemote consultationEntityControllerRemote;
  
    private RegistrationModule registrationModule;
    private AdministrationModule administrationModule;
    private AppointmentModule appointmentModule;
    
    private StaffEntity currentStaffEntity;
    
    public MainApp() 
    {        
    }
    
    public MainApp(StaffEntityControllerRemote staffEntityControllerRemote, PatientEntityControllerRemote patientEntityControllerRemote, DoctorEntityControllerRemote doctorEntityControllerRemote, RegistrationControllerRemote registrationControllerRemote, AppointmentControllerRemote appointmentControllerRemote, ConsultationEntityControllerRemote consultationEntityControllerRemote) 
    {
        this.registrationControllerRemote = registrationControllerRemote;
        this.appointmentControllerRemote = appointmentControllerRemote;
        this.staffEntityControllerRemote = staffEntityControllerRemote;
        this.patientEntityControllerRemote = patientEntityControllerRemote;
        this.doctorEntityControllerRemote = doctorEntityControllerRemote;
        this.consultationEntityControllerRemote = consultationEntityControllerRemote;
    
    }
    
    public void runApp() throws InvalidLoginException, PatientNotFoundException, DoctorNotFoundException, EntityManagerException, ParseException, StaffNotFoundException
    {
        Scanner scanner = new Scanner(System.in);
        Integer response = 0;
        
        while(true)
        {
            System.out.println("*** Welcome to Clinic Appointment Registration System (CARS) ***\n");
            System.out.println("1: Login");
            System.out.println("2: Exit\n");
            response = 0;
            
            while(response < 1 || response > 2)
            {
                System.out.print("> ");

                response = scanner.nextInt();

                if(response == 1)
                {                                     
                        doLogin();
                        registrationModule = new RegistrationModule(registrationControllerRemote, doctorEntityControllerRemote, patientEntityControllerRemote, appointmentControllerRemote, consultationEntityControllerRemote);
                        appointmentModule = new AppointmentModule(appointmentControllerRemote, patientEntityControllerRemote, doctorEntityControllerRemote);
                        administrationModule = new AdministrationModule(staffEntityControllerRemote, patientEntityControllerRemote, doctorEntityControllerRemote, appointmentControllerRemote);
                        menuMain();                                  
                }
                else if (response == 2)
                {
                    break;
                }
                else
                {
                    System.out.println("Invalid option, please try again!\n");                
                }
            }
            
            if(response == 2)
            {
                break;
            }
            
        }
    }
    
    private void doLogin() throws InvalidLoginException
    {
        Scanner scanner = new Scanner(System.in);
        String username = "";
        String password = "";
        
        System.out.println("*** CARS :: Login ***\n");
        System.out.print("Enter username> ");
        username = scanner.nextLine().trim();
        System.out.print("Enter password> ");
        password = scanner.nextLine().trim();
        
        if(username.length() > 0 && password.length() > 0)
        {
            currentStaffEntity = staffEntityControllerRemote.staffLogin(username, password);
            System.out.println("Login successful!\n");
            System.out.println("*** Clinic Registration System (CRS) ***\n");
            System.out.println("You are login as "+ currentStaffEntity.getFirstName() + " " + currentStaffEntity.getLastName() + "\n");           
        }
        else
        {
            System.out.println(" login credential!");
        }
    }

    private void menuMain() throws PatientNotFoundException, DoctorNotFoundException, EntityManagerException, ParseException, StaffNotFoundException {
        Scanner scanner = new Scanner(System.in);
        Integer response = 0;
        
        while(true)
        {
            System.out.println("*** CARS :: Main ***\n");
            System.out.println("You are login as " + currentStaffEntity.getFirstName() + " " + currentStaffEntity.getLastName());
            System.out.println("1: Registration Operation");
            System.out.println("2: Appointment Operation");
            System.out.println("3: Administration Operation");
            System.out.println("4: Logout\n");
            response = 0;
            
            while(response < 1 || response > 4)
            {
                System.out.print("> ");

                response = scanner.nextInt();

                if(response == 1)
                {
                    registrationModule.registrationMenuMain();
                }
                else if(response == 2)
                {
                    appointmentModule.appointmentMenuMain();
                }
                else if (response == 3)
                {
                    administrationModule.administrationMenuMain();
                } 
                else if (response == 4)
                {
                    break;
                }
                else
                {
                    System.out.println("Invalid option, please try again!\n");                
                }
            }
            
            if(response == 4)
            {
                break;
            }
        }
    }
}
