/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.session.stateless;

import entity.AppointmentEntity;
import entity.DoctorEntity;
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
import util.exception.DoctorNotFoundException;

/**
 *
 * @author Shi Yun
 */
@Stateless
@Local(DoctorEntityControllerLocal.class)
@Remote(DoctorEntityControllerRemote.class)
public class DoctorEntityController implements DoctorEntityControllerRemote, DoctorEntityControllerLocal {

    @PersistenceContext(unitName = "ClinicAppointmentRegistrationLibraryPU")
    private EntityManager entityManager;

    public DoctorEntityController() {
    }

    @Override
    public List<DoctorEntity> retrieveAllDoctors() {
        Query query = entityManager.createQuery("SELECT d FROM DoctorEntity d");
        return query.getResultList();
    }

    @Override
    public DoctorEntity retrieveDoctorByDoctorId(Long doctorId) throws DoctorNotFoundException {
        DoctorEntity doctorEntity = entityManager.find(DoctorEntity.class, doctorId);

        if (doctorEntity != null) {
            return doctorEntity;
        } else {
            throw new DoctorNotFoundException("Doctor ID " + doctorId + " does not exist!");
        }
    }

    @Override
    public void addAppointmentToDoctor(Long doctorId, Long appointmentId) {
        DoctorEntity doctor = entityManager.find(DoctorEntity.class, doctorId);
        AppointmentEntity appointment = entityManager.find(AppointmentEntity.class, appointmentId);
        appointment.setDoctor(doctor);
        //doctor.addAppointment(appointment);
        entityManager.flush();
    }
    
    @Override
    public void deleteAppointment(Long doctorId, Long appointmentId) {
        DoctorEntity doctor = entityManager.find(DoctorEntity.class, doctorId);
        AppointmentEntity appointment = entityManager.find(AppointmentEntity.class, appointmentId);
        appointment.setDoctor(doctor);
        //doctor.deleteAppointment(appointment);
        //entityManager.flush();
    }
    
    @Override
    public void updateDoctor(DoctorEntity doctorEntity) {
        entityManager.merge(doctorEntity);
    }

    @Override
    public void deleteDoctor(Long doctorId) throws DoctorNotFoundException {
        DoctorEntity doctorEntityToRemove = retrieveDoctorByDoctorId(doctorId);
        entityManager.remove(doctorEntityToRemove);
    }
    
    @Override
    public DoctorEntity createNewDoctor(DoctorEntity doctorEntity) {
        entityManager.persist(doctorEntity);
        entityManager.flush();
        return doctorEntity;
    }
}
