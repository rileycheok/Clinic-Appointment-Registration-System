/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.session.stateful;

import entity.AppointmentEntity;
import entity.DoctorEntity;
import entity.PatientEntity;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import oracle.jrockit.jfr.parser.ParseException;
import util.exception.EntityManagerException;

/**
 *
 * @author Shi Yun
 */
@Stateful
@Local (AppointmentControllerLocal.class)
@Remote (AppointmentControllerRemote.class)

public class AppointmentController implements AppointmentControllerRemote, AppointmentControllerLocal {

    @PersistenceContext(unitName = "ClinicAppointmentRegistrationLibraryPU")
    private EntityManager entityManager;

    public AppointmentController() {
    }
    
   
    
    @Override
    public AppointmentEntity createNewAppointment(AppointmentEntity newAppointmentEntity)
    {
        entityManager.persist(newAppointmentEntity);
        entityManager.flush();
        
        return newAppointmentEntity;
    }
    
    
    
    @Override
    public List<AppointmentEntity> retrieveAllAppointments() {
        // SELECT * FROM AppointmentEntity a ORDER BY a.date, a.time did not work
        Query query = entityManager.createQuery("SELECT a FROM AppointmentEntity a ORDER BY a.datetime");
        //changes here//

        return query.getResultList();
    }
    
    @Override
    public List<AppointmentEntity> retrieveAppointmentsByDateAndTime(String date, String time) throws java.text.ParseException {
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
        Date dateform = new Date();
        dateform = formatDate.parse(date);

        Query query = entityManager.createQuery("SELECT a FROM AppointmentEntity a WHERE a.datetime >= :datetime");
        query.setParameter("datetime", dateform, TemporalType.TIMESTAMP);
        List<AppointmentEntity> todayDoctorAppointments = query.getResultList();
        if (todayDoctorAppointments == null) {
            return null;
        } else {
            ArrayList<AppointmentEntity> bytimeDoctorAppointments = new ArrayList<AppointmentEntity>();
            for (AppointmentEntity appointment : todayDoctorAppointments) {
                if (appointment.getTime().equals(time)) {
                    bytimeDoctorAppointments.add(appointment);
                }

            }
            return bytimeDoctorAppointments;

        }

        //changes here//
        
    }

    
    @Override
    public AppointmentEntity retrieveAppointmentByAppointmentId(Long appointmentId) throws EntityManagerException
    {
        AppointmentEntity appointmentEntity = entityManager.find(AppointmentEntity.class, appointmentId);
        
        if(appointmentEntity != null)
        {
            return appointmentEntity;
        }
        else
        {
            throw new EntityManagerException("Appointment ID " + appointmentId + " does not exist!");
        }
    }
    
    @Override
    public List<AppointmentEntity> retrieveAppointmentsByAppointmentDate(String appointmentDate) throws EntityManagerException
    {
        ArrayList<AppointmentEntity> todayAppointments = new ArrayList<AppointmentEntity>();
        List<AppointmentEntity> allAppts = retrieveAllAppointments();
        for (AppointmentEntity appts : allAppts) {
            if (appts.getDate().equals(appointmentDate)){
                todayAppointments.add(appts);
            }
                
        }
        
        if(todayAppointments != null)
        {
            return todayAppointments;
        }
        else
        {
            throw new EntityManagerException("Appointment with date " + appointmentDate + " does not exist!");
        }
    }
    
    @Override
    public List<AppointmentEntity> retrieveAppointmentsByDateAndDoctor(String date, DoctorEntity doctorEntity)
    {
        ArrayList<AppointmentEntity> todayDoctorAppointments = new ArrayList<AppointmentEntity>();
        List<AppointmentEntity> allAppts = retrieveAllAppointments();
        for (AppointmentEntity appointment : allAppts) {
            if (appointment.getDate().equals(date) && appointment.getDoctor().equals(doctorEntity)){
                todayDoctorAppointments.add(appointment);
            }         
        }
        
        return todayDoctorAppointments;
    }
    
    @Override
    public List<AppointmentEntity> retrieveAppointmentsByPatient(PatientEntity patientEntity)
    {
        ArrayList<AppointmentEntity> patientAppointments = new ArrayList<AppointmentEntity>();
        List<AppointmentEntity> allAppts = retrieveAllAppointments();
        for (AppointmentEntity appointment : allAppts) {
            if (appointment.getPatient().equals(patientEntity)){
                patientAppointments.add(appointment);
            }         
        }
        
        return patientAppointments;
    }
    
    @Override
    public List<AppointmentEntity> retrieveAppointmentsByDoctor(DoctorEntity doctorEntity)
    {
        ArrayList<AppointmentEntity> doctorAppointments = new ArrayList<AppointmentEntity>();
        List<AppointmentEntity> allAppts = retrieveAllAppointments();
        for (AppointmentEntity appointment : allAppts) {
            if (appointment.getDoctor().equals(doctorEntity)){
                doctorAppointments.add(appointment);
            }         
        }
        
        return doctorAppointments;
    }
  
    
    @Override
    public void updateAppointment(AppointmentEntity appointmentEntity)
    {
        entityManager.merge(appointmentEntity);
    }
    
    
    
    @Override
    public void deleteAppointment(Long appointmentId) throws EntityManagerException
    {
        AppointmentEntity appointment = retrieveAppointmentByAppointmentId(appointmentId);
        appointment.setDoctor(null);
        appointment.setPatient(null);
        entityManager.remove(appointment);
    }
    
    @Override
    public void deleteAllAppointments() throws EntityManagerException 
    {
        List<AppointmentEntity> appointmentEntities = retrieveAllAppointments();
        for (AppointmentEntity a : appointmentEntities) {
            entityManager.remove(a);
            
        }
        
    }

}
