/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.session.ws;

import ejb.session.stateless.DoctorEntityControllerLocal;
import entity.DoctorEntity;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.ejb.Stateless;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import util.exception.DoctorNotFoundException;

/**
 *
 * @author Shi Yun
 */
@WebService(serviceName = "DoctorWebService")
@Stateless()
public class DoctorWebService {

    @EJB
    private DoctorEntityControllerLocal ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "retrieveAllDoctors")
    public List<DoctorEntity> retrieveAllDoctors() {
        return ejbRef.retrieveAllDoctors();
    }

    @WebMethod(operationName = "retrieveDoctorByDoctorId")
    public DoctorEntity retrieveDoctorByDoctorId(@WebParam(name = "doctorId") Long doctorId) throws DoctorNotFoundException {
        return ejbRef.retrieveDoctorByDoctorId(doctorId);
    }

    @WebMethod(operationName = "updateDoctor")
    @Oneway
    public void updateDoctor(@WebParam(name = "doctorEntity") DoctorEntity doctorEntity) {
        ejbRef.updateDoctor(doctorEntity);
    }

    @WebMethod(operationName = "deleteDoctor")
    public void deleteDoctor(@WebParam(name = "doctorId") Long doctorId) throws DoctorNotFoundException {
        ejbRef.deleteDoctor(doctorId);
    }

    @WebMethod(operationName = "addAppointmentToDoctor")
    @Oneway
    public void addAppointmentToDoctor(@WebParam(name = "doctorId") Long doctorId, @WebParam(name = "appointmentId") Long appointmentId) {
        ejbRef.addAppointmentToDoctor(doctorId, appointmentId);
    }

    @WebMethod(operationName = "deleteAppointment")
    @Oneway
    public void deleteAppointment(@WebParam(name = "doctorId") Long doctorId, @WebParam(name = "appointmentId") Long appointmentId, @WebParam(name = "patientId") Long patientId) {
        ejbRef.deleteAppointment(doctorId, appointmentId);
    }

    @WebMethod(operationName = "createNewDoctor")
    public DoctorEntity createNewDoctor(@WebParam(name = "doctorEntity") DoctorEntity doctorEntity) {
        return ejbRef.createNewDoctor(doctorEntity);
    }
    
}
