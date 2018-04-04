/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinicadminterminalclient;

import ejb.session.stateful.RegistrationControllerRemote;
import ejb.session.stateful.AppointmentControllerRemote;
import ejb.session.stateless.ConsultationEntityControllerRemote;
import ejb.session.stateless.PatientEntityControllerRemote;
import ejb.session.stateless.StaffEntityControllerRemote;
import ejb.session.stateless.DoctorEntityControllerRemote;
import java.text.ParseException;
import javax.annotation.Resource;
import javax.ejb.EJB;
import util.exception.DoctorNotFoundException;
import util.exception.EntityManagerException;
import util.exception.InvalidLoginException;
import util.exception.PatientNotFoundException;
import util.exception.StaffNotFoundException;

/**
 *
 * @author Shi Yun
 */
public class Main {
    @EJB
    private static StaffEntityControllerRemote staffEntityControllerRemote;
    @EJB
    private static PatientEntityControllerRemote patientEntityControllerRemote;
    @EJB
    private static DoctorEntityControllerRemote doctorEntityControllerRemote;
    @EJB
    private static RegistrationControllerRemote registrationControllerRemote;
    @EJB
    private static AppointmentControllerRemote appointmentControllerRemote;
    @EJB
    private static ConsultationEntityControllerRemote consultationEntityControllerRemote;
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InvalidLoginException, PatientNotFoundException, DoctorNotFoundException, EntityManagerException, ParseException, StaffNotFoundException {
        // TODO code application logic here
        MainApp mainApp = new MainApp(staffEntityControllerRemote, patientEntityControllerRemote, doctorEntityControllerRemote, registrationControllerRemote, appointmentControllerRemote, consultationEntityControllerRemote);
        mainApp.runApp();
    }
    
}
