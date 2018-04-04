/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinicadminterminalclient;

import ejb.session.stateful.AppointmentControllerRemote;
import ejb.session.stateless.DoctorEntityControllerRemote;
import ejb.session.stateless.PatientEntityControllerRemote;
import entity.AppointmentEntity;
import entity.DoctorEntity;
import entity.PatientEntity;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import util.exception.DoctorNotFoundException;
import util.exception.EntityManagerException;
import util.exception.PatientNotFoundException;

/**
 *
 * @author Shi Yun
 */
public class AppointmentModule {

    private AppointmentControllerRemote appointmentControllerRemote;
    private PatientEntityControllerRemote patientEntityControllerRemote;
     private DoctorEntityControllerRemote doctorEntityControllerRemote;

    public AppointmentModule(AppointmentControllerRemote appointmentControllerRemote, PatientEntityControllerRemote patientEntityControllerRemote, DoctorEntityControllerRemote doctorEntityControllerRemote) {
        this.appointmentControllerRemote = appointmentControllerRemote;
        this.patientEntityControllerRemote = patientEntityControllerRemote;
        this.doctorEntityControllerRemote = doctorEntityControllerRemote;
    }

    void appointmentMenuMain() throws DoctorNotFoundException, PatientNotFoundException, EntityManagerException, ParseException {
        Scanner scanner = new Scanner(System.in);
        Integer response = 0;

        while (true) {
            System.out.println("*** CARS :: Appointment Operation ***\n");
            System.out.println("1: View Patient Appointments");
            System.out.println("2: Add Appointment");
            System.out.println("3: Cancel Appointment");
            System.out.println("4: Back\n");
            response = 0;

            while (response < 1 || response > 4) {
                System.out.print("> ");

                response = scanner.nextInt();

                if (response == 1) {
                    viewPatientAppointment();
                } else if (response == 2) {
                    addAppointment();
                } else if (response == 3) {
                    cancelAppointment();
                } else if (response == 4) {
                    break;
                } else {
                    System.out.println("Invalid option, please try again!\n");
                }
            }

            if (response == 4) {
                break;
            }
        }
    }

    private void viewPatientAppointment() throws PatientNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("*** CARS :: Appointment Operation :: View Patient Appointments ***\n");
        System.out.print("Enter Patient Identity Number> ");
        PatientEntity patient = new PatientEntity();
        patient = patientEntityControllerRemote.retrievePatientByIdentityNumber(scanner.next());
        System.out.println();
        System.out.println("Appointments: ");
        System.out.println("Id |Date        |Time |Doctor");
        
        // print the list of patient's appointments
        List<AppointmentEntity> patientAppointments = appointmentControllerRemote.retrieveAppointmentsByPatient(patient);
        for (AppointmentEntity appointment : patientAppointments) 
        {
            System.out.println(appointment.getAppointmentId() + " |" + appointment.getDate() + " |"
                                + appointment.getTime() + " |" + appointment.getDoctor().getFirstName() + " "
                                + appointment.getDoctor().getLastName());
        }  
    }

    private void addAppointment() throws DoctorNotFoundException, PatientNotFoundException, ParseException {
        System.out.println("*** CARS :: Appointment Operation :: Add Appointment ***\n");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Doctor:");
        System.out.println("Id |Name");
        
        List<DoctorEntity> allDoctors = doctorEntityControllerRemote.retrieveAllDoctors();
        for (DoctorEntity doctor : allDoctors) {
            System.out.println(doctor.getDoctorId()+"  |" + doctor.getFirstName() + " " + doctor.getLastName());
        }
        System.out.println();
        
        Long selectedDoctorId = null;
        boolean checkValidDoctorId = false;
        while (checkValidDoctorId == false) {
            System.out.print("Enter Doctor Id> ");
            selectedDoctorId = scanner.nextLong();
            if (selectedDoctorId > 0 && selectedDoctorId <= allDoctors.size()) {
                checkValidDoctorId = true;
                break;
            } else {
                System.out.println("Invalid Doctor Id entered!");
            }
        }
      
        System.out.print("Enter Date> ");
        String date = scanner.next();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        Date todayDate = c.getTime();
        Date enteredDate = null;

        try {
            enteredDate = dateFormat.parse(date);
        } catch (ParseException e) {
            System.out.println("Date entered in wrong format!");
            return;
        }

        if (!enteredDate.after(todayDate)) {
            System.out.println("Invalid!");
            return;
        }


        DoctorEntity selectedDoctor = new DoctorEntity();
        selectedDoctor = doctorEntityControllerRemote.retrieveDoctorByDoctorId(selectedDoctorId);
        
        System.out.println();
        System.out.println("Availability for " + selectedDoctor.getFirstName() + " " + selectedDoctor.getLastName() + " "
                + "on " + date + ":");
        
        List<AppointmentEntity> allDoctorAppointments = appointmentControllerRemote.retrieveAppointmentsByDateAndDoctor(date, selectedDoctor);
        
        List<String> allTimings = new ArrayList<String>();
        allTimings.add("9:00");
        allTimings.add("9:30");
        allTimings.add("10:00");
        allTimings.add("10:30");
        allTimings.add("11:00");
        allTimings.add("11:30");
        allTimings.add("12:00");
        allTimings.add("12:30");
        allTimings.add("13:00");
        allTimings.add("13:30");
        allTimings.add("14:00");
        allTimings.add("14:30");
        allTimings.add("15:00");
        allTimings.add("15:30");
        allTimings.add("16:00");
        allTimings.add("16:30");
        
        for(String thisTiming : allTimings)
        {
            boolean free = true;
            for (int i=0; i<allDoctorAppointments.size(); i++) {
                if (allDoctorAppointments.get(i).getTime().equals(thisTiming)) {
                    free = false;
                    break;
                }
            }
            if (free == true) {
                System.out.print(thisTiming + " ");
            }
        }
        
        System.out.println("\n");
        
        // adding a new appointment
        AppointmentEntity newAppointment = new AppointmentEntity();
        newAppointment.setDate(date);
        newAppointment.setDoctor(selectedDoctor);
        System.out.print("Enter Time> ");
        // check valid time input entered
        SimpleDateFormat checkTime = new SimpleDateFormat("HH:mm");
        String enteredTime = scanner.next();
        Date time = new Date();
        try {
            time = checkTime.parse(enteredTime);
        } catch (ParseException e) {
            System.out.println("Time entered in wrong format!");
            return;
        }
        newAppointment.setTime(enteredTime);
        
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String datetimeString = date + " " + newAppointment.getTime();
        Date datetime = format.parse(datetimeString);
        newAppointment.setDatetime(datetime);
        System.out.print("Enter Patient Identity Number> ");
        PatientEntity retrievedPatient = new PatientEntity();
        retrievedPatient = patientEntityControllerRemote.retrievePatientByIdentityNumber(scanner.next());
        newAppointment.setPatient(retrievedPatient);
        newAppointment = appointmentControllerRemote.createNewAppointment(newAppointment);
        
        // to update Doctor's list of appointments
        doctorEntityControllerRemote.addAppointmentToDoctor(selectedDoctorId, newAppointment.getAppointmentId());
        
        // to update Patient's list of appointments
        patientEntityControllerRemote.addAppointmentToPatient(retrievedPatient.getPatientId(), newAppointment.getAppointmentId());
        
        System.out.println("Appointment: " + selectedDoctor.getFirstName() + " " + selectedDoctor.getLastName() + " and "
                + retrievedPatient.getFirstName() + " " + retrievedPatient.getLastName() + " at " + newAppointment.getTime() 
                + " on " + date + " has been added.");
               
    }

    private void cancelAppointment() throws PatientNotFoundException, EntityManagerException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("*** CARS :: Appointment Operation :: Cancel Appointment ***\n");
        System.out.print("Enter Patient Identity Number> ");
        PatientEntity patient = new PatientEntity();
        patient = patientEntityControllerRemote.retrievePatientByIdentityNumber(scanner.next());
        System.out.println();
        System.out.println("Appointments: ");
        System.out.println("Id |Date        |Time |Doctor");
        
        // print the list of patient's appointments
        List<AppointmentEntity> patientAppointments = appointmentControllerRemote.retrieveAppointmentsByPatient(patient);
        if (patientAppointments.isEmpty()) {
            return;
        }
        for (AppointmentEntity appointment : patientAppointments) 
        {
            System.out.println(appointment.getAppointmentId() + " |" + appointment.getDate() + " |"
                                + appointment.getTime() + " |" + appointment.getDoctor().getFirstName() + " "
                                + appointment.getDoctor().getLastName());
        }
        System.out.println();
        
        System.out.print("Enter Appointment Id> ");
        AppointmentEntity appointment = new AppointmentEntity();
        try {
            appointment = appointmentControllerRemote.retrieveAppointmentByAppointmentId(scanner.nextLong());
        }
        catch(Exception e) {
            System.out.println("Invalid appointment Id entered!");
            return;
        }
        
        if (!patientAppointments.contains(appointment)) {
            System.out.println("Invalid appointment Id entered!");
            return;
        }
        System.out.println("Appointment: " + patient.getFirstName()+ " " + patient.getLastName() + " and "
                            + appointment.getDoctor().getFirstName() + " " + appointment.getDoctor().getLastName()
                            + " at " + appointment.getTime() + " on " + appointment.getDate() + " has been cancelled.");
        
        // delete the appointment from doctor
        doctorEntityControllerRemote.deleteAppointment(appointment.getDoctor().getDoctorId(), appointment.getAppointmentId());
        
        // delete the appointment from patient
        patientEntityControllerRemote.deleteAppointment(patient.getPatientId(), appointment.getAppointmentId());
        
        // delete the appointment
        appointmentControllerRemote.deleteAppointment(appointment.getAppointmentId());
    }
}
