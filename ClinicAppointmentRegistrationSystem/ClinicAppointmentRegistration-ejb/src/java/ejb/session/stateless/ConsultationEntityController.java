/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.session.stateless;

import entity.ConsultationEntity;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import util.exception.EntityManagerException;

/**
 *
 * @author joycefoo
 */
@Stateless
public class ConsultationEntityController implements ConsultationEntityControllerRemote, ConsultationEntityControllerLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PersistenceContext(unitName = "ClinicAppointmentRegistrationLibraryPU")
    private EntityManager entityManager;
    
    
    
    
    public ConsultationEntityController()
    {
    }
    
    
    
    @Override
    public ConsultationEntity createNewConsultation(ConsultationEntity newConsultationEntity)
    {
        Calendar c = null;
        c = c.getInstance();
        Date date = c.getTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String today = format.format(date);
        List<ConsultationEntity> allConsultations = retrieveAllConsultations();
        if (allConsultations.size() > 0 && !allConsultations.get(0).getDate().equals(today)) {
            try {
                deleteAllConsultations();
            } catch (EntityManagerException ex) {
                Logger.getLogger(ConsultationEntityController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        entityManager.flush();
        entityManager.persist(newConsultationEntity);
        entityManager.flush();
        
        return newConsultationEntity;
    }
    
    
    
    @Override
    public List<ConsultationEntity> retrieveAllConsultations()
    {
        Query query = entityManager.createQuery("SELECT c FROM ConsultationEntity c");
        
        return query.getResultList();
    }
    
    
    
    @Override
    public ConsultationEntity retrieveConsultationByConsultationId(Long consultationId) throws EntityManagerException
    {
        ConsultationEntity consultationEntity = entityManager.find(ConsultationEntity.class, consultationId);
        
        if(consultationEntity != null)
        {
            return consultationEntity;
        }
        else
        {
            throw new EntityManagerException("Consultation ID " + consultationId + " does not exist!");
        }
    }
    
  
    
    @Override
    public void updateConsultation(ConsultationEntity consultationEntity)
    {
        entityManager.merge(consultationEntity);
    }
    
    
    
    @Override
    public void deleteConsultation(Long consultationId) throws EntityManagerException
    {
        ConsultationEntity consultationEntityToRemove = entityManager.find(ConsultationEntity.class, consultationId);
        entityManager.remove(consultationEntityToRemove);
        entityManager.flush();
    }
    
    @Override
    public void deleteAllConsultations() throws EntityManagerException 
    {
        List<ConsultationEntity> consultationEntities = retrieveAllConsultations();
        for (ConsultationEntity ce : consultationEntities) {
            deleteConsultation(ce.getConsultationId());
            
        }
        entityManager.flush();
    }
}