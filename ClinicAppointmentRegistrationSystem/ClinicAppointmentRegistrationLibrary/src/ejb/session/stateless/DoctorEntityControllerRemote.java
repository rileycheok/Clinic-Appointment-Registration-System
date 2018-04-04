/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.session.stateless;

import entity.DoctorEntity;
import javax.ejb.Remote;
import java.util.List;
import util.exception.DoctorNotFoundException;

/**
 *
 * @author Shi Yun
 */
@Remote
public interface DoctorEntityControllerRemote {
    
    public List<DoctorEntity> retrieveAllDoctors();

    public DoctorEntity retrieveDoctorByDoctorId(Long doctorId) throws DoctorNotFoundException;

    public void updateDoctor(DoctorEntity doctorEntity);

    public void deleteDoctor(Long doctorId) throws DoctorNotFoundException;
    
    public void addAppointmentToDoctor(Long doctorId, Long appointmentId);
    
    public void deleteAppointment(Long doctorId, Long appointmentId);
    
    public DoctorEntity createNewDoctor(DoctorEntity doctorEntity);
}
