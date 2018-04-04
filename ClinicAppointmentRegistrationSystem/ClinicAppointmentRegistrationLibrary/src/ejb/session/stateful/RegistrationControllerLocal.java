/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.session.stateful;

import entity.DoctorEntity;
import entity.PatientEntity;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Shi Yun
 */
@Local
public interface RegistrationControllerLocal {
      
    List<DoctorEntity> retrieveAllDoctors();
    PatientEntity registerNewPatient(PatientEntity newPatientEntity);

}
