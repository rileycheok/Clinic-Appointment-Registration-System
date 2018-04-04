/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.session.stateless;

import entity.PatientEntity;
import java.util.List;
import javax.ejb.Remote;
import util.exception.InvalidLoginException;
import util.exception.PatientNotFoundException;

/**
 *
 * @author Shi Yun
 */
@Remote
public interface PatientEntityControllerRemote {
    
    public PatientEntity createNewPatient(PatientEntity newPatientEntity);
    
    public PatientEntity retrievePatientByIdentityNumber(String identityNumber) throws PatientNotFoundException;
    
    public boolean patientExistsByIdentityNumber(String identityNumber);
    
    public List<PatientEntity> retrieveAllPatients();
    
    public PatientEntity retrievePatientByPatientId(Long patientId) throws PatientNotFoundException;
    
    public void updatePatient(PatientEntity patientEntity) throws PatientNotFoundException;
    
    public void deletePatient(Long patientId) throws PatientNotFoundException;
    
    public void addAppointmentToPatient(Long patientId, Long appointmentId);
    
    public void deleteAppointment(Long patientId, Long appointmentId);
    
    public PatientEntity patientLogin(String identityNumber, String securityCode) throws InvalidLoginException;
}
