/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.session.stateful;

import entity.AppointmentEntity;
import entity.DoctorEntity;
import entity.PatientEntity;
import java.util.List;
import javax.ejb.Remote;
import util.exception.EntityManagerException;

/**
 *
 * @author Shi Yun
 */
@Remote
public interface AppointmentControllerRemote {
    
    public AppointmentEntity createNewAppointment(AppointmentEntity newAppointmentEntity);
    
    public List<AppointmentEntity> retrieveAllAppointments();
    
    public List<AppointmentEntity> retrieveAppointmentsByDateAndTime(String date, String time) throws java.text.ParseException;
    
    public AppointmentEntity retrieveAppointmentByAppointmentId(Long appointmentId) throws EntityManagerException;
    
    public List<AppointmentEntity> retrieveAppointmentsByAppointmentDate(String appointmentDate) throws EntityManagerException;
    
    public List<AppointmentEntity> retrieveAppointmentsByDateAndDoctor(String date, DoctorEntity doctorEntity);
    
    public List<AppointmentEntity> retrieveAppointmentsByPatient(PatientEntity patientEntity);
    
    public List<AppointmentEntity> retrieveAppointmentsByDoctor(DoctorEntity doctorEntity);
            
    public void updateAppointment(AppointmentEntity appointmentEntity);
    
    public void deleteAppointment(Long appointmentId) throws EntityManagerException;
    
    public void deleteAllAppointments() throws EntityManagerException;
}
