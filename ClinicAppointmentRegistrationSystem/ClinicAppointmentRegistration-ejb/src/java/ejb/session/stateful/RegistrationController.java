package ejb.session.stateful;

import ejb.session.stateless.PatientEntityControllerLocal;
import entity.PatientEntity;
import entity.DoctorEntity;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Shi Yun
 */
@Stateful
@Local (RegistrationControllerLocal.class)
@Remote (RegistrationControllerRemote.class)

public class RegistrationController implements RegistrationControllerRemote, RegistrationControllerLocal {
   
    
    @PersistenceContext(unitName = "ClinicAppointmentRegistrationLibraryPU")
    private EntityManager entityManager;

    public RegistrationController() {
       
    }
    
    
    @Override
    public List<DoctorEntity> retrieveAllDoctors()
    {
        Query query = entityManager.createQuery("SELECT d FROM DoctorEntity d");
        return query.getResultList();
    }
    
    @Override
    public PatientEntity registerNewPatient(PatientEntity newPatientEntity) {
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
   
    
}
