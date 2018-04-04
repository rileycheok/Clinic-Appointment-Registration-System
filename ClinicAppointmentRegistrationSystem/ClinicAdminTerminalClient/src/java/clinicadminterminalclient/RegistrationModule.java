/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinicadminterminalclient;

import ejb.session.stateful.AppointmentControllerRemote;
import ejb.session.stateful.RegistrationControllerRemote;
import ejb.session.stateless.ConsultationEntityControllerRemote;
import ejb.session.stateless.DoctorEntityControllerRemote;
import ejb.session.stateless.PatientEntityControllerRemote;
import entity.AppointmentEntity;
import entity.DoctorEntity;
import entity.PatientEntity;
import entity.ConsultationEntity;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
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
public class RegistrationModule {

    private RegistrationControllerRemote registrationControllerRemote;
    private DoctorEntityControllerRemote doctorEntityControllerRemote;
    private PatientEntityControllerRemote patientEntityControllerRemote;
    private AppointmentControllerRemote appointmentControllerRemote;
    private ConsultationEntityControllerRemote consultationEntityControllerRemote;

    public RegistrationModule() {

    }

    public RegistrationModule(RegistrationControllerRemote registrationControllerRemote, DoctorEntityControllerRemote doctorEntityControllerRemote, PatientEntityControllerRemote patientEntityControllerRemote, AppointmentControllerRemote appointmentControllerRemote, ConsultationEntityControllerRemote consultationEntityControllerRemote) {
        this.registrationControllerRemote = registrationControllerRemote;
        this.doctorEntityControllerRemote = doctorEntityControllerRemote;
        this.patientEntityControllerRemote = patientEntityControllerRemote;
        this.appointmentControllerRemote = appointmentControllerRemote;
        this.consultationEntityControllerRemote = consultationEntityControllerRemote;
    }

    public void registrationMenuMain() throws PatientNotFoundException, DoctorNotFoundException, ParseException {
        Scanner scanner = new Scanner(System.in);
        Integer response = 0;

        while (true) {
            System.out.println("*** CARS :: Registration Operation ***\n");
            System.out.println("1: Register New Patient");
            System.out.println("2: Register Walk-In Consultation");
            System.out.println("3: Register Consultation By Appointment");
            System.out.println("4: Back\n");
            response = 0;

            while (response < 1 || response > 4) {
                System.out.print("> ");

                response = scanner.nextInt();

                if (response == 1) {
                    registerNewPatient();
                } else if (response == 2) {
                    registerWalkInConsultation();
                } else if (response == 3) {
                    registerConsultationByAppointment();
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

    private void registerNewPatient() {

        Scanner scanner = new Scanner(System.in);
        PatientEntity newPatientEntity = new PatientEntity();

        System.out.println("*** CRS :: Registration Operation :: Register New Patient ***\n");
        System.out.print("Enter Identity Number> ");
        String idd = scanner.nextLine().trim();
        if (patientEntityControllerRemote.patientExistsByIdentityNumber(idd)) {
            System.out.println("Patient Identity Number Exists!");
            return;
        }

        newPatientEntity.setIdentityNumber(idd);

        System.out.print("Enter Security Code> ");
        newPatientEntity.setSecuritycode(scanner.nextLine().trim());
        System.out.print("Enter First Name> ");
        newPatientEntity.setFirstName(scanner.nextLine().trim());
        System.out.print("Enter Last Name> ");
        newPatientEntity.setLastName(scanner.nextLine().trim());
        System.out.print("Enter Gender> ");
        newPatientEntity.setGender(scanner.nextLine().trim());
        System.out.print("Enter Age> ");
        newPatientEntity.setAge(scanner.nextInt());
        scanner.nextLine();
        System.out.print("Enter Phone> ");
        newPatientEntity.setPhone(scanner.nextLine().trim());
        System.out.print("Enter Address> ");
        newPatientEntity.setAddress(scanner.nextLine().trim());

        newPatientEntity = patientEntityControllerRemote.createNewPatient(newPatientEntity);

        System.out.println("Patient has been registered successfully!\n");

    }

    private void registerWalkInConsultation() throws PatientNotFoundException, DoctorNotFoundException, ParseException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("*** CRS :: Registration Operation :: Register Walk-In Consultation ***\n");
        System.out.println("Doctor:");
        System.out.println("Id |Name");

        List<DoctorEntity> allDoctors = doctorEntityControllerRemote.retrieveAllDoctors();
        for (DoctorEntity doctor : allDoctors) {
            System.out.println(doctor.getDoctorId() + "  |" + doctor.getFirstName() + " " + doctor.getLastName());
        }

        System.out.println("Availability:");
        System.out.println("Time  |1 |2 |3 |");
        Calendar c = Calendar.getInstance();
        Date date = c.getTime();//starting time    
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = dateformat.format(date); // today's date in yyyy-MM-dd form
        SimpleDateFormat timeformat = new SimpleDateFormat("HH:mm");
        SimpleDateFormat minuteformat = new SimpleDateFormat("mm");
        String currentminute = minuteformat.format(date);
        int minute = Integer.parseInt(currentminute);
        if (minute >= 30) {
            c.add(Calendar.HOUR_OF_DAY, 1);
            c.set(Calendar.MINUTE, 0);
            c.set(Calendar.SECOND, 0);
        } else {
            c.set(Calendar.MINUTE, 30);
            c.set(Calendar.SECOND, 0);
        }

        // check if time is before 16:31 so that a consultation can still be assigned
        if (((String) timeformat.format(date)).compareTo("16:31") >= 0) {
            System.out.println("Clinic is closed for the day!");
            return;
        }

        for (int i = 0; i < 6; i++) {
            date = c.getTime();
            String nexttime = timeformat.format(date);
            if (nexttime.equals("17:00")) {
                break;
            } else {
                System.out.print(nexttime + " |");
                List<AppointmentEntity> targetappt = appointmentControllerRemote.retrieveAppointmentsByDateAndTime(currentDate, nexttime);
                if (targetappt == null) {
                    System.out.println("o |o |o |");
                } else {
                    AppointmentEntity temp = null;
                    for (long j = 1; j <= 3; j++) {
                        for (AppointmentEntity appt : targetappt) {
                            if (appt.getDoctor().getDoctorId() == j) {
                                temp = appt;
                                break;
                            } else {
                                temp = null;
                            }
                        }
                        if (temp == null) {
                            System.out.print("o |");

                        } else {
                            System.out.print("x |");
                        }

                    }
                    System.out.println();
                }
            }

            c.add(Calendar.MINUTE, 30);

        }

        //availability logic
        System.out.print("Enter Doctor Id> ");
        Long selectedDoctorId = scanner.nextLong();
        scanner.nextLine();
        System.out.print("Enter Patient Identity Number> ");
        String selectedIdentityNumber = scanner.nextLine().trim();
        DoctorEntity selectedDoctor = doctorEntityControllerRemote.retrieveDoctorByDoctorId(selectedDoctorId);
        PatientEntity patient = patientEntityControllerRemote.retrievePatientByIdentityNumber(selectedIdentityNumber);
        System.out.print("Enter Chosen Time> ");
        
        // check valid time input entered
        SimpleDateFormat checkTime = new SimpleDateFormat("HH:mm");
        String chosentime = scanner.next();
        Date time = new Date();
        try {
            time = checkTime.parse(chosentime);
        } catch (ParseException e) {
            System.out.println("Time entered in wrong format!");
            return;
        }

        if (isDuplicateAppointment(currentDate, chosentime, selectedDoctor)) {
            System.out.println("Doctor is unavailable!");
        } else {
            ConsultationEntity newConsultationEntity = new ConsultationEntity();
            newConsultationEntity.setDoctorId(selectedDoctor.getDoctorId());
            newConsultationEntity.setPatientId(patient.getPatientId());
            //need check if its a new day
            int size = consultationEntityControllerRemote.retrieveAllConsultations().size();
            int queueNumber = size + 1;
            newConsultationEntity.setQueueNumber(queueNumber);
            newConsultationEntity.setDate(currentDate);
            consultationEntityControllerRemote.createNewConsultation(newConsultationEntity);

            System.out.println(selectedDoctor.getFirstName() + " " + selectedDoctor.getLastName() + " is going to see "
                    + patient.getFirstName() + " " + patient.getLastName() + " at " + chosentime + ". Queue Number is: " + queueNumber + "."); // add in time, and queue number
            //block slot out
            AppointmentEntity blockSlot = new AppointmentEntity();
            blockSlot.setDate(currentDate);
            blockSlot.setTime(chosentime);
            blockSlot.setDoctor(selectedDoctor);
            blockSlot.setPatient(patient);
            String datetime = currentDate + " " + chosentime;
            SimpleDateFormat lastformat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            Date datetime2 = lastformat.parse(datetime);
            blockSlot.setDatetime(datetime2);
            appointmentControllerRemote.createNewAppointment(blockSlot);

        }
    }

    private boolean isDuplicateAppointment(String date, String chosentime, DoctorEntity chosenDoctor) {
        List<AppointmentEntity> entities = appointmentControllerRemote.retrieveAppointmentsByDateAndDoctor(date, chosenDoctor);
        boolean isDuplicate = false;
        for (AppointmentEntity a : entities) {
            if (a.getTime().equals(chosentime)) {
                isDuplicate = true;
            }
        }
        return isDuplicate;
    }

    private void registerConsultationByAppointment() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("*** CRS :: Registration Operation :: Register Consultation By Appointment ***\n");
        System.out.print("Enter Patient Identity Number> ");
        String patientIdentityNumber = scanner.nextLine().trim();
        System.out.println();
        System.out.println("Appointments:");
        System.out.println("Id |Date       |Time   |Doctor");

        // retrieve appointments acc to patient identity number
        try {
            PatientEntity patientEntity = new PatientEntity();
            patientEntity = patientEntityControllerRemote.retrievePatientByIdentityNumber(patientIdentityNumber);
            List<AppointmentEntity> patientAppointments = appointmentControllerRemote.retrieveAppointmentsByPatient(patientEntity);

            if (patientAppointments.size() >= 1) //has appointments
            {
                List<AppointmentEntity> appointments = patientAppointments;
                for (AppointmentEntity rowAppointment : appointments) { //print each appointment into one row
                    System.out.println(rowAppointment.getAppointmentId() + " |" + rowAppointment.getDate() + " |"
                            + rowAppointment.getTime() + " |" + rowAppointment.getDoctor().getFirstName() + " " + rowAppointment.getDoctor().getLastName());
                }

                System.out.println();
                System.out.print("Enter Appointment Id> ");
                Long appointmentId = scanner.nextLong();

                //r
                //int thisDayDate = t
                // retrieve appointment by Id, get patient and get doctor
                try {
                    AppointmentEntity selectedAppointmentEntity = appointmentControllerRemote.retrieveAppointmentByAppointmentId(appointmentId);
                    String selectedDate = selectedAppointmentEntity.getDate();
                    Calendar c1 = Calendar.getInstance();

                    Date todayDate = c1.getTime();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    String todayString = sdf.format(todayDate);

                    if (todayString.equals(selectedDate)) {
                        //create consultation, add queue number
                        DoctorEntity selectedDoctor = selectedAppointmentEntity.getDoctor();
                        PatientEntity patient = selectedAppointmentEntity.getPatient();
                        ConsultationEntity newConsultationEntity = new ConsultationEntity();
                        newConsultationEntity.setDoctorId(selectedDoctor.getDoctorId());
                        newConsultationEntity.setPatientId(patient.getPatientId());
                        int size = consultationEntityControllerRemote.retrieveAllConsultations().size();
                        int queueNumber = size+1;

                        newConsultationEntity.setQueueNumber(queueNumber);
                        newConsultationEntity.setDate(todayString);

                        consultationEntityControllerRemote.createNewConsultation(newConsultationEntity);

                        System.out.println(selectedDoctor.getFirstName() + " " + selectedDoctor.getLastName() + " is going to see "
                                + patient.getFirstName() + " " + patient.getLastName() + " at " + selectedAppointmentEntity.getTime() + ". Queue Number is: " + queueNumber + ".");
                    } else {
                        System.out.println("Appointment is not set for today. Please come again next time.");
                    }

                } catch (EntityManagerException e) {
                    System.out.println("Wrong Appointment Id Keyed!");
                }
            } else { //no appointments under found patient
                System.out.println("Patient has no appointments :/");
            }
        } catch (PatientNotFoundException e) {
            System.out.println("No such patient in the system!");
        }
    }

}
