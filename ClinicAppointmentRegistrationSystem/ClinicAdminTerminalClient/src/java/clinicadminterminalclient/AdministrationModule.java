/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinicadminterminalclient;

import ejb.session.stateful.AppointmentController;
import ejb.session.stateful.AppointmentControllerRemote;
import ejb.session.stateless.*;
import entity.AppointmentEntity;
import entity.DoctorEntity;
import entity.PatientEntity;
import entity.StaffEntity;
import java.util.List;
import java.util.Scanner;
import util.exception.DoctorNotFoundException;
import util.exception.EntityManagerException;
import util.exception.PatientNotFoundException;
import util.exception.StaffNotFoundException;

/**
 *
 * @author Shi Yun
 */
public class AdministrationModule {

    private StaffEntityControllerRemote staffEntityControllerRemote;
    private PatientEntityControllerRemote patientEntityControllerRemote;
    private DoctorEntityControllerRemote doctorEntityControllerRemote;
    private AppointmentControllerRemote appointmentControllerRemote;

    public AdministrationModule() {
    }
    
    
    AdministrationModule(StaffEntityControllerRemote staffEntityControllerRemote, PatientEntityControllerRemote patientEntityControllerRemote, DoctorEntityControllerRemote doctorEntityControllerRemote, AppointmentControllerRemote appointmentControllerRemote) {
        this.staffEntityControllerRemote = staffEntityControllerRemote;
        this.patientEntityControllerRemote = patientEntityControllerRemote;
        this.doctorEntityControllerRemote = doctorEntityControllerRemote;
        this.appointmentControllerRemote = appointmentControllerRemote;
    }

    public void administrationMenuMain() throws PatientNotFoundException, EntityManagerException, DoctorNotFoundException, StaffNotFoundException {
        Scanner scanner = new Scanner(System.in);
        Integer response = 0;
        
        while(true)
        {
            System.out.println("*** CARS :: Administration Operation ***\n");
            System.out.println("1: Patient Management");
            System.out.println("2: Doctor Management");
            System.out.println("3: Staff Management");
            System.out.println("4: Back\n");
            response = 0;
            
            while(response < 1 || response > 4)
            {
                System.out.print("> ");

                response = scanner.nextInt();

                if(response == 1)
                {
                    doPatientManagement();
                }
                else if(response == 2)
                {
                    doDoctorManagement();
                }
                else if (response == 3)
                {
                    doStaffManagement();
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

    private void doPatientManagement() throws PatientNotFoundException, EntityManagerException {
        Scanner scanner = new Scanner(System.in);
        Integer response = 0;
        
        System.out.println("*** CARS :: Administration Operation :: Patient Management ***\n");
        System.out.println("1: Add Patient");
        System.out.println("2: View Patient Details");
        System.out.println("3: Update Patient");
        System.out.println("4: Delete Patient");
        System.out.println("5: View All Patients");
        System.out.println("6: Back\n");
        response = 0;
        
        while(response < 1 || response > 6)
            {
                System.out.print("> ");

                response = scanner.nextInt();

                if(response == 1)
                {
                    doAddPatient();
                }
                else if(response == 2)
                {
                    doViewPatientDetails();
                }
                else if (response == 3)
                {
                    doUpdatePatient();
                } 
                else if (response == 4)
                {
                    doDeletePatient();
                }
                else if (response == 5)
                {
                    doViewAllPatients();
                }
                else if (response == 6)
                {
                    break;
                }
                else
                {
                    System.out.println("Invalid option, please try again!\n");                
                }         
            if(response == 6)
            {
                break;
            }
        }
    }
    private void doAddPatient()
    {
        Scanner scanner = new Scanner(System.in);
        PatientEntity newPatientEntity = new PatientEntity();

        System.out.println("*** CARS :: Administration Operation :: Patient Management :: Add Patient ***\n");
        System.out.print("Enter Identity Number> ");
        newPatientEntity.setIdentityNumber(scanner.nextLine().trim());
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
        System.out.println("Patient has been added successfully!");

    }
    
    
    
    private void doViewPatientDetails()
    {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("*** CARS :: Administration Operation :: Patient Management :: View Patient Details ***\n");
        System.out.print("Enter Patient Identity Number> ");
        String identityNumber = scanner.next();
        
        PatientEntity patientEntity = new PatientEntity();
        try
        {
            patientEntity = patientEntityControllerRemote.retrievePatientByIdentityNumber(identityNumber);
            System.out.printf("%8s%20s%20s%15s%20s%20s\n", "Patient ID", "Identity Number", "First Name", "Last Name", "Gender", "Age", "Phone", "Address");
            System.out.printf("%8s%20s%20s%15s%20s%20s\n", patientEntity.getPatientId().toString(), patientEntity.getIdentityNumber(), patientEntity.getFirstName(), patientEntity.getLastName(), patientEntity.getGender(), patientEntity.getAge().toString(), patientEntity.getPhone(), patientEntity.getAddress());         
        }
        catch(PatientNotFoundException ex)
        {
            System.out.println("An error has occurred while retrieving patient: " + ex.getMessage() + "\n");
        }
        
    }
    
    
    private void doUpdatePatient() throws PatientNotFoundException 
    {
        Scanner scanner = new Scanner(System.in);        
        String input;
        PatientEntity patientEntity = new PatientEntity();
        
        System.out.println("*** CARS :: Administration Operation :: Patient Management :: Update Patient ***\n");
        
        // note that identity number cannot be changed
        System.out.print("Enter Identity Number> ");
        input = scanner.nextLine().trim();
        patientEntity = patientEntityControllerRemote.retrievePatientByIdentityNumber(input);
                
        System.out.print("Enter Security Code (blank if no change)> ");
        input = scanner.nextLine().trim();
        if(input.length() > 0)
        {
            patientEntity.setSecuritycode(input);
        }
        
        System.out.print("Enter First Name (blank if no change)> ");
        input = scanner.nextLine().trim();
        if(input.length() > 0)
        {
            patientEntity.setFirstName(input);
        }
                
        System.out.print("Enter Last Name (blank if no change)> ");
        input = scanner.nextLine().trim();
        if(input.length() > 0)
        {
            patientEntity.setLastName(input);
        }
        
        System.out.print("Enter Gender (blank if no change)> ");
        input = scanner.nextLine().trim();
        if(input.length() > 0)
        {
            patientEntity.setGender(input);
        }
                
        System.out.print("Enter Age (blank if no change)> ");
        input = scanner.nextLine().trim();
        if(input.length() > 0)
        {
           int result = Integer.parseInt(input);
            patientEntity.setAge(result);
        }
        
        System.out.print("Enter Phone (blank if no change)> ");
        input = scanner.nextLine().trim();
        if(input.length() > 0)
        {
            patientEntity.setPhone(input);
        }
        
        System.out.print("Enter Address (blank if no change)> ");
        input = scanner.nextLine().trim();
        if(input.length() > 0)
        {
            patientEntity.setAddress(input);
        }
        
        patientEntityControllerRemote.updatePatient(patientEntity);
        System.out.println("Patient updated successfully!\n");
        
    }
    
    
    
    private void doDeletePatient() throws PatientNotFoundException, EntityManagerException
    {
        Scanner scanner = new Scanner(System.in);        
        System.out.println("*** CARS :: Administration Operation :: Patient Management :: Delete Patient ***\n");
        System.out.print("Enter patient identity number> ");
        String identityNumber = scanner.next();
        scanner.nextLine();
        PatientEntity patientEntity = new PatientEntity();
        patientEntity = patientEntityControllerRemote.retrievePatientByIdentityNumber(identityNumber);
        System.out.printf("Confirm Delete Patient %s %s (Patient ID: %d) (Enter 'Y' to Delete)> ", patientEntity.getFirstName(), patientEntity.getLastName(), patientEntity.getPatientId());
        
        String input;
        input = scanner.nextLine().trim();
        
        if(input.equals("Y"))
        {
            try 
            {
                // retrieve all apointments attached to this patient
                List<AppointmentEntity> patientAppointments = appointmentControllerRemote.retrieveAppointmentsByPatient(patientEntity);
                for (AppointmentEntity appointment: patientAppointments) {
                    // delete appointment from patient
                    patientEntityControllerRemote.deleteAppointment(patientEntity.getPatientId(), appointment.getAppointmentId());
                    // delete appointment from doctor
                    doctorEntityControllerRemote.deleteAppointment(appointment.getDoctor().getDoctorId(), appointment.getAppointmentId());
                    // delete the appointment
                    appointmentControllerRemote.deleteAppointment(appointment.getAppointmentId());
                }
                
                patientEntityControllerRemote.deletePatient(patientEntity.getPatientId());
                System.out.println("Patient deleted successfully!\n");
            } 
            catch (PatientNotFoundException ex) 
            {
                System.out.println("An error has occurred while deleting patient: " + ex.getMessage() + "\n");
            }            
        }
        else
        {
            System.out.println("Patient NOT deleted!\n");
        }
    }
    
    
    
    private void doViewAllPatients()
    {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("*** CARS :: Administration Operation :: Patient Management :: View All Patients ***\n");
        List<PatientEntity> patientEntities = patientEntityControllerRemote.retrieveAllPatients();  
        System.out.printf("%8s%15s%15s%15s%15s%15s%15s%15s\n", "Patient ID", "Identity Number", "First Name", "Last Name", "Gender", "Age", "Phone", "Address");

        for(PatientEntity patientEntity:patientEntities)
        {
            System.out.printf("%8s%15s%15s%15s%15s%15s%15s%15s\n", patientEntity.getPatientId().toString(), patientEntity.getIdentityNumber(), patientEntity.getFirstName(), patientEntity.getLastName(), patientEntity.getGender(), patientEntity.getAge().toString(), patientEntity.getPhone(), patientEntity.getAddress());         
                  
        }

        System.out.print("Press any key to continue...> ");
        scanner.nextLine();
    }
    

    private void doDoctorManagement() throws DoctorNotFoundException, EntityManagerException {
        Scanner scanner = new Scanner(System.in);
        Integer response = 0;
        
        System.out.println("*** CARS :: Administration Operation :: Doctor Management ***\n");
        System.out.println("1: Add Doctor");
        System.out.println("2: View Doctor Details");
        System.out.println("3: Update Doctor");
        System.out.println("4: Delete Doctor");
        System.out.println("5: View All Doctors");
        System.out.println("6: Back\n");
        response = 0;
        
        while(response < 1 || response > 6)
            {
                System.out.print("> ");

                response = scanner.nextInt();

                if(response == 1)
                {
                    doAddDoctor();
                }
                else if(response == 2)
                {
                    doViewDoctorDetails();
                }
                else if (response == 3)
                {
                    doUpdateDoctor();
                } 
                else if (response == 4)
                {
                    doDeleteDoctor();
                }
                else if (response == 5)
                {
                    doViewAllDoctors();
                }
                else if (response == 6)
                {
                    break;
                }
                else
                {
                    System.out.println("Invalid option, please try again!\n");                
                }         
            if(response == 6)
            {
                break;
            }
        }
    }
    
    private void doAddDoctor()
    {
        Scanner scanner = new Scanner(System.in);
        DoctorEntity newDoctorEntity = new DoctorEntity();

        System.out.println("*** CARS :: Administration Operation :: Doctor Management :: Add Doctor ***\n");
        System.out.print("Enter First Name> ");
        newDoctorEntity.setFirstName(scanner.nextLine().trim());
        System.out.print("Enter Last Name> ");
        newDoctorEntity.setLastName(scanner.nextLine().trim());
        System.out.print("Enter Registration> ");
        newDoctorEntity.setRegistration(scanner.nextLine().trim());
        System.out.print("Enter Qualifications> ");
        newDoctorEntity.setQualifications(scanner.nextLine().trim());

        newDoctorEntity = doctorEntityControllerRemote.createNewDoctor(newDoctorEntity);
        System.out.println("Doctor has been added successfully!");

    }
    
    private void doViewDoctorDetails() throws DoctorNotFoundException
    {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("*** CARS :: Administration Operation :: Doctor Management :: View Doctor Details ***\n");
        System.out.print("Enter DoctorId> ");
        Long doctorId = scanner.nextLong();
        
        DoctorEntity doctorEntity = new DoctorEntity();
 
        try
        {
            doctorEntity = doctorEntityControllerRemote.retrieveDoctorByDoctorId(doctorId);
            System.out.printf("%8s%20s%20s%20s%20s\n", "Doctor ID", "First Name", "Last Name", "Registration", "Qualifications");
            System.out.printf("%8s%20s%20s%20s%20s\n", doctorEntity.getDoctorId().toString(), doctorEntity.getFirstName(), doctorEntity.getLastName(), doctorEntity.getRegistration(), doctorEntity.getQualifications());         
        }
        catch(DoctorNotFoundException ex)
        {
            System.out.println("An error has occurred while retrieving patient: " + ex.getMessage() + "\n");
        }      
    }
    
    private void doUpdateDoctor() throws DoctorNotFoundException
    {
        Scanner scanner = new Scanner(System.in);        
        String input;
        DoctorEntity doctorEntity = new DoctorEntity();
        
        System.out.println("*** CARS :: Administration Operation :: Doctor Management :: Update Doctor ***\n");
        
        // note that doctorId cannot be changed
        System.out.print("Enter DoctorId> ");
        Long doctorId = scanner.nextLong();
        scanner.nextLine();
        doctorEntity = doctorEntityControllerRemote.retrieveDoctorByDoctorId(doctorId);
                
        System.out.print("Enter First Name (blank if no change)> ");
        input = scanner.nextLine().trim();
        if(input.length() > 0)
        {
            doctorEntity.setFirstName(input);
        }
                
        System.out.print("Enter Last Name (blank if no change)> ");
        input = scanner.nextLine().trim();
        if(input.length() > 0)
        {
            doctorEntity.setLastName(input);
        }
        
        System.out.print("Enter Registration (blank if no change)> ");
        input = scanner.nextLine().trim();
        if(input.length() > 0)
        {
            doctorEntity.setRegistration(input);
        }
                
        System.out.print("Enter Qualifications (blank if no change)> ");
        input = scanner.nextLine().trim();
        if(input.length() > 0)
        {
            doctorEntity.setQualifications(input);
        }
        
        doctorEntityControllerRemote.updateDoctor(doctorEntity);
        System.out.println("Doctor updated successfully!\n");
        
    }
    
    private void doDeleteDoctor() throws DoctorNotFoundException, EntityManagerException
    {
        Scanner scanner = new Scanner(System.in);        
        System.out.println("*** CARS :: Administration Operation :: Doctor Management :: Delete Doctor ***\n");
        System.out.print("Enter DoctorId> ");
        Long doctorId = scanner.nextLong();
        scanner.nextLine();
        DoctorEntity doctorEntity = new DoctorEntity();
        doctorEntity = doctorEntityControllerRemote.retrieveDoctorByDoctorId(doctorId);

        System.out.printf("Confirm Delete Doctor %s %s (Doctor ID: %d) (Enter 'Y' to Delete)> ", doctorEntity.getFirstName(), doctorEntity.getLastName(), doctorEntity.getDoctorId());
        
        String input;
        input = scanner.nextLine().trim();
        
        if(input.equals("Y"))
        {
            try 
            {
                // retrieve all apointments attached to this doctor
                List<AppointmentEntity> doctorAppointments = appointmentControllerRemote.retrieveAppointmentsByDoctor(doctorEntity);
                for (AppointmentEntity appointment: doctorAppointments) {
                    // delete appointment from doctor
                    doctorEntityControllerRemote.deleteAppointment(doctorEntity.getDoctorId(), appointment.getAppointmentId());
                    // delete appointment from patient
                    doctorEntityControllerRemote.deleteAppointment(appointment.getPatient().getPatientId(), appointment.getAppointmentId());
                    // delete the appointment
                    appointmentControllerRemote.deleteAppointment(appointment.getAppointmentId());
                }
                
                doctorEntityControllerRemote.deleteDoctor(doctorEntity.getDoctorId());
                System.out.println("Doctor deleted successfully!\n");
            } 
            catch (DoctorNotFoundException ex) 
            {
                System.out.println("An error has occurred while deleting doctor: " + ex.getMessage() + "\n");
            }            
        }
        else
        {
            System.out.println("Doctor NOT deleted!\n");
        }
    }
    
    
    
    private void doViewAllDoctors()
    {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("*** CARS :: Administration Operation :: Doctor Management :: View All Doctors ***\n");
        List<DoctorEntity> doctorEntities = doctorEntityControllerRemote.retrieveAllDoctors();  
        System.out.printf("%8s%20s%20s%20s%20s\n", "Doctor ID", "First Name", "Last Name", "Registration", "Qualifications");
                    

        for(DoctorEntity doctorEntity : doctorEntities)
        {
            System.out.printf("%8s%20s%20s%20s%20s\n", doctorEntity.getDoctorId().toString(), doctorEntity.getFirstName(), doctorEntity.getLastName(), doctorEntity.getRegistration(), doctorEntity.getQualifications());        
                  
        }

        System.out.print("Press any key to continue...> ");
        scanner.nextLine();
    }
  

    private void doStaffManagement() throws StaffNotFoundException, EntityManagerException {
        Scanner scanner = new Scanner(System.in);
        Integer response = 0;
        
        System.out.println("*** CARS :: Administration Operation :: Staff Management ***\n");
        System.out.println("1: Add Staff");
        System.out.println("2: View Staff Details");
        System.out.println("3: Update Staff");
        System.out.println("4: Delete Staff");
        System.out.println("5: View All Staff");
        System.out.println("6: Back\n");
        response = 0;
        
        while(response < 1 || response > 6)
            {
                System.out.print("> ");

                response = scanner.nextInt();

                if(response == 1)
                {
                    doAddStaff();
                }
                else if(response == 2)
                {
                    doViewStaffDetails();
                }
                else if (response == 3)
                {
                    doUpdateStaff();
                } 
                else if (response == 4)
                {
                    doDeleteStaff();
                }
                else if (response == 5)
                {
                    doViewAllStaff();
                }
                else if (response == 6)
                {
                    break;
                }
                else
                {
                    System.out.println("Invalid option, please try again!\n");                
                }         
            if(response == 6)
            {
                break;
            }
        }
    }
    
    private void doAddStaff()
    {
        Scanner scanner = new Scanner(System.in);
        StaffEntity newStaffEntity = new StaffEntity();

        System.out.println("*** CARS :: Administration Operation :: Staff Management :: Add Staff ***\n");
        System.out.print("Enter First Name> ");
        newStaffEntity.setFirstName(scanner.nextLine().trim());
        System.out.print("Enter Last Name> ");
        newStaffEntity.setLastName(scanner.nextLine().trim());
        System.out.print("Enter Username> ");
        newStaffEntity.setUsername(scanner.nextLine().trim());
        System.out.print("Enter Password> ");
        newStaffEntity.setPassword(scanner.nextLine().trim());

        newStaffEntity = staffEntityControllerRemote.createNewStaff(newStaffEntity);
        System.out.println("Staff has been added successfully!");

    }
    
    private void doViewStaffDetails() throws StaffNotFoundException
    {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("*** CARS :: Administration Operation :: Staff Management :: View Staff Details ***\n");
        System.out.print("Enter Staff Id> ");
        Long staffId = scanner.nextLong();
        
        StaffEntity staffEntity = new StaffEntity();
 
        try
        {
            staffEntity = staffEntityControllerRemote.retrieveStaffByStaffId(staffId);
            System.out.printf("%8s%20s%20s%20s%20s\n", "Staff ID", "First Name", "Last Name", "Username", "Password");
            System.out.printf("%8s%20s%20s%20s%20s\n", staffEntity.getStaffId().toString(), staffEntity.getFirstName(), staffEntity.getLastName(), staffEntity.getUsername(), staffEntity.getPassword());         
        }
        catch(StaffNotFoundException ex)
        {
            System.out.println("An error has occurred while retrieving staff: " + ex.getMessage() + "\n");
        }      
    }
    
    private void doUpdateStaff() throws StaffNotFoundException
    {
        Scanner scanner = new Scanner(System.in);        
        String input;
        StaffEntity staffEntity = new StaffEntity();
        
        System.out.println("*** CARS :: Administration Operation :: Staff Management :: Update Staff ***\n");
        
        // note that staffId cannot be changed
        System.out.print("Enter Staff Id> ");
        Long staffId = scanner.nextLong();
        scanner.nextLine();
        staffEntity =staffEntityControllerRemote.retrieveStaffByStaffId(staffId);
        
        System.out.print("Enter First Name (blank if no change)> ");
        input = scanner.nextLine().trim();
        if(input.length() > 0)
        {
            staffEntity.setFirstName(input);
        }
                
        System.out.print("Enter Last Name (blank if no change)> ");
        input = scanner.nextLine().trim();
        if(input.length() > 0)
        {
            staffEntity.setLastName(input);
        }
        
        System.out.print("Enter Username> ");
        input = scanner.nextLine().trim();
        if(input.length() > 0)
        {
            staffEntity.setUsername(input);
        }
        
        System.out.print("Enter Password (blank if no change)> ");
        input = scanner.nextLine().trim();
        if(input.length() > 0)
        {
            staffEntity.setPassword(input);
        }
        
        staffEntityControllerRemote.updateStaff(staffEntity);
        System.out.println("Staff updated successfully!\n");
        
    }
    
    private void doDeleteStaff() throws StaffNotFoundException, EntityManagerException
    {
        Scanner scanner = new Scanner(System.in);        
        System.out.println("*** CARS :: Administration Operation :: Staff Management :: Delete Staff ***\n");
        System.out.print("Enter StaffId> ");
        Long staffId = scanner.nextLong();
        scanner.nextLine();
        StaffEntity staffEntity = new StaffEntity();
        staffEntity = staffEntityControllerRemote.retrieveStaffByStaffId(staffId);

        System.out.printf("Confirm Delete Staff %s %s (Staff ID: %d) (Enter 'Y' to Delete)> ", staffEntity.getFirstName(), staffEntity.getLastName(), staffEntity.getStaffId());
        
        String input;
        input = scanner.nextLine().trim();
        
        if(input.equals("Y"))
        {
            staffEntityControllerRemote.deleteStaff(staffId);
        }
        else
        {
            System.out.println("Staff NOT deleted!\n");
        }
    }
    
    
    
    private void doViewAllStaff()
    {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("*** CARS :: Administration Operation :: Staff Management :: View All Staff ***\n");
        List<StaffEntity> staffEntities = staffEntityControllerRemote.retrieveAllStaffs();  
        System.out.printf("%8s%20s%20s%20s%20s\n", "Staff ID", "First Name", "Last Name", "Username", "Password");

        for(StaffEntity staffEntity : staffEntities)
        {
            System.out.printf("%8s%20s%20s%20s%20s\n", staffEntity.getStaffId().toString(), staffEntity.getFirstName(), staffEntity.getLastName(), staffEntity.getUsername(), staffEntity.getPassword());                
                  
        }

        System.out.print("Press any key to continue...> ");
        scanner.nextLine();
    }
    
}
