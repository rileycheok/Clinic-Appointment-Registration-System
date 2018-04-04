/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.session.ws;

import ejb.session.stateful.AppointmentControllerLocal;
import entity.AppointmentEntity;
import entity.DoctorEntity;
import entity.PatientEntity;
import java.text.ParseException;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.ejb.Stateless;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import util.exception.EntityManagerException;

/**
 *
 * @author Shi Yun
 */
@WebService(serviceName = "PatientAppointmentWebService")
@Stateless()
public class PatientAppointmentWebService {

    @EJB
    private AppointmentControllerLocal ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "createNewAppointment")
    public AppointmentEntity createNewAppointment(@WebParam(name = "newAppointmentEntity") AppointmentEntity newAppointmentEntity) {
        return ejbRef.createNewAppointment(newAppointmentEntity);
    }

    @WebMethod(operationName = "retrieveAllAppointments")
    public List<AppointmentEntity> retrieveAllAppointments() {
        return ejbRef.retrieveAllAppointments();
    }

    @WebMethod(operationName = "retrieveAppointmentsByDateAndTime")
    public List<AppointmentEntity> retrieveAppointmentsByDateAndTime(@WebParam(name = "date") String date, @WebParam(name = "time") String time) throws ParseException {
        return ejbRef.retrieveAppointmentsByDateAndTime(date, time);
    }

    @WebMethod(operationName = "retrieveAppointmentByAppointmentId")
    public AppointmentEntity retrieveAppointmentByAppointmentId(@WebParam(name = "appointmentId") Long appointmentId) throws EntityManagerException {
        return ejbRef.retrieveAppointmentByAppointmentId(appointmentId);
    }

    @WebMethod(operationName = "retrieveAppointmentsByAppointmentDate")
    public List<AppointmentEntity> retrieveAppointmentsByAppointmentDate(@WebParam(name = "appointmentDate") String appointmentDate) throws EntityManagerException {
        return ejbRef.retrieveAppointmentsByAppointmentDate(appointmentDate);
    }

    @WebMethod(operationName = "retrieveAppointmentsByDateAndDoctor")
    public List<AppointmentEntity> retrieveAppointmentsByDateAndDoctor(@WebParam(name = "date") String date, @WebParam(name = "doctorEntity") DoctorEntity doctorEntity) {
        return ejbRef.retrieveAppointmentsByDateAndDoctor(date, doctorEntity);
    }

    @WebMethod(operationName = "retrieveAppointmentsByPatient")
    public List<AppointmentEntity> retrieveAppointmentsByPatient(@WebParam(name = "patientEntity") PatientEntity patientEntity) {
        return ejbRef.retrieveAppointmentsByPatient(patientEntity);
    }

    @WebMethod(operationName = "retrieveAppointmentsByDoctor")
    public List<AppointmentEntity> retrieveAppointmentsByDoctor(@WebParam(name = "doctorEntity") DoctorEntity doctorEntity) {
        return ejbRef.retrieveAppointmentsByDoctor(doctorEntity);
    }

    @WebMethod(operationName = "updateAppointment")
    @Oneway
    public void updateAppointment(@WebParam(name = "appointmentEntity") AppointmentEntity appointmentEntity) {
        ejbRef.updateAppointment(appointmentEntity);
    }

    @WebMethod(operationName = "deleteAppointment")
    public void deleteAppointment(@WebParam(name = "appointmentId") Long appointmentId, @WebParam(name = "patientId") Long patientId, @WebParam(name = "doctorId") Long doctorId) throws EntityManagerException {
        ejbRef.deleteAppointment(appointmentId);
    }

    @WebMethod(operationName = "deleteAllAppointments")
    public void deleteAllAppointments() throws EntityManagerException {
        ejbRef.deleteAllAppointments();
    }
    
}
