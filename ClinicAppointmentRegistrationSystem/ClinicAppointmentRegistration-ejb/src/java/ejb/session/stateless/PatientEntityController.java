/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.session.stateless;

import entity.AppointmentEntity;
import entity.PatientEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import util.exception.InvalidLoginException;
import util.exception.PatientNotFoundException;

/**
 *
 * @author Shi Yun
 */
@Stateless
@Local(PatientEntityControllerLocal.class)
@Remote(PatientEntityControllerRemote.class)
public class PatientEntityController implements PatientEntityControllerRemote, PatientEntityControllerLocal {


    @PersistenceContext(unitName = "ClinicAppointmentRegistrationLibraryPU")
    private EntityManager entityManager;

    public PatientEntityController() {

    }

    @Override
    public PatientEntity createNewPatient(PatientEntity newPatientEntity) {
        /*if (patientExistsByIdentityNumber(newPatientEntity.getIdentityNumber()))
        {
            System.out.println("Patient with identity number " + newPatientEntity.getIdentityNumber() + "exists already!");
        } else {
            entityManager.persist(newPatientEntity);
            entityManager.flush();
            return newPatientEntity;
        } */
        entityManager.persist(newPatientEntity);
        entityManager.flush();
        return newPatientEntity;
    }
    
    @Override
    public PatientEntity retrievePatientByIdentityNumber(String identityNumber) throws PatientNotFoundException
    {
        Query query = entityManager.createQuery("SELECT p FROM PatientEntity p WHERE p.identityNumber = :inIdentityNumber");
        query.setParameter("inIdentityNumber", identityNumber);
        //PatientEntity patientEntity = (PatientEntity)query.getSingleResult();
        //patientEntity.setPatientAppointments(patientEntity.getPatientAppointments());
        
        try
        {
            return (PatientEntity)query.getSingleResult();
        }
        catch(NoResultException | NonUniqueResultException ex)
        {
            throw new PatientNotFoundException("Patient identity number " + identityNumber + " does not exist!");
        }
    }
    
    @Override
    public boolean patientExistsByIdentityNumber(String identityNumber)
    {
        Query query = entityManager.createQuery("SELECT p FROM PatientEntity p WHERE p.identityNumber = :inIdentityNumber");
        query.setParameter("inIdentityNumber", identityNumber);
        List<PatientEntity> list = (List<PatientEntity>) query.getResultList();
        if (list == null || list.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }
    
    @Override
    public List<PatientEntity> retrieveAllPatients()
    {
        Query query = entityManager.createQuery("SELECT p FROM PatientEntity p");
        return query.getResultList();
    }
    
    @Override
    public PatientEntity retrievePatientByPatientId(Long patientId) throws PatientNotFoundException
    {
        PatientEntity patientEntity = entityManager.find(PatientEntity.class, patientId);
        
        if(patientEntity != null)
        {
            return patientEntity;
        }
        else
        {
            throw new PatientNotFoundException("Patient ID " + patientId + " does not exist!");
        }
    }
    
    @Override
    public void updatePatient(PatientEntity patientEntity) throws PatientNotFoundException
    {
        entityManager.merge(patientEntity);
    }
    
    @Override
    public void deletePatient(Long patientId) throws PatientNotFoundException
    {
        PatientEntity patientEntityToRemove = retrievePatientByPatientId(patientId);
        entityManager.remove(patientEntityToRemove);
    }
    
    @Override
    public void addAppointmentToPatient(Long patientId, Long appointmentId) {
        PatientEntity patient = entityManager.find(PatientEntity.class, patientId);
        AppointmentEntity appointment = entityManager.find(AppointmentEntity.class, appointmentId);
        appointment.setPatient(patient);
    }
    
    @Override
    public void deleteAppointment(Long patientId, Long appointmentId) {
        PatientEntity patient = entityManager.find(PatientEntity.class, patientId);
        AppointmentEntity appointment = entityManager.find(AppointmentEntity.class, appointmentId);
        appointment.setPatient(null);
        entityManager.flush();
    }
    
    @Override
    public PatientEntity patientLogin(String identityNumber, String securityCode) throws InvalidLoginException {       
        try
        {
            PatientEntity patientEntity = retrievePatientByIdentityNumber(identityNumber);
            
            if(patientEntity.getSecuritycode().equals(securityCode))
            {
                return patientEntity;
            }
            else
            {
                throw new InvalidLoginException("Identity Number does not exist or invalid password!");
            }
        }
        catch(PatientNotFoundException ex)
        {
            throw new InvalidLoginException("Identity Number does not exist or invalid password!");
        }
    }

}
