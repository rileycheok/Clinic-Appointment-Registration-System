/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.session.ws;

import ejb.session.stateless.PatientEntityControllerLocal;
import entity.PatientEntity;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.ejb.Stateless;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import util.exception.InvalidLoginException;
import util.exception.PatientNotFoundException;

/**
 *
 * @author Shi Yun
 */
@WebService(serviceName = "PatientRegistrationWebService")
@Stateless()
public class PatientRegistrationWebService {

    @EJB
    private PatientEntityControllerLocal ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "createNewPatient")
    public PatientEntity createNewPatient(@WebParam(name = "newPatientEntity") PatientEntity newPatientEntity) {
        return ejbRef.createNewPatient(newPatientEntity);
    }

    @WebMethod(operationName = "retrievePatientByIdentityNumber")
    public PatientEntity retrievePatientByIdentityNumber(@WebParam(name = "identityNumber") String identityNumber) throws PatientNotFoundException {
        return ejbRef.retrievePatientByIdentityNumber(identityNumber);
    }

    @WebMethod(operationName = "patientExistsByIdentityNumber")
    public boolean patientExistsByIdentityNumber(@WebParam(name = "identityNumber") String identityNumber) {
        return ejbRef.patientExistsByIdentityNumber(identityNumber);
    }

    @WebMethod(operationName = "retrieveAllPatients")
    public List<PatientEntity> retrieveAllPatients() {
        return ejbRef.retrieveAllPatients();
    }

    @WebMethod(operationName = "retrievePatientByPatientId")
    public PatientEntity retrievePatientByPatientId(@WebParam(name = "patientId") Long patientId) throws PatientNotFoundException {
        return ejbRef.retrievePatientByPatientId(patientId);
    }

    @WebMethod(operationName = "updatePatient")
    public void updatePatient(@WebParam(name = "patientEntity") PatientEntity patientEntity) throws PatientNotFoundException {
        ejbRef.updatePatient(patientEntity);
    }

    @WebMethod(operationName = "deletePatient")
    public void deletePatient(@WebParam(name = "patientId") Long patientId) throws PatientNotFoundException {
        ejbRef.deletePatient(patientId);
    }

    @WebMethod(operationName = "addAppointmentToPatient")
    @Oneway
    public void addAppointmentToPatient(@WebParam(name = "patientId") Long patientId, @WebParam(name = "appointmentId") Long appointmentId) {
        ejbRef.addAppointmentToPatient(patientId, appointmentId);
    }

    @WebMethod(operationName = "deleteAppointment")
    @Oneway
    public void deleteAppointment(@WebParam(name = "patientId") Long patientId, @WebParam(name = "appointmentId") Long appointmentId, @WebParam(name = "doctorId") Long doctorId) {
        ejbRef.deleteAppointment(patientId, appointmentId);
    }

    @WebMethod(operationName = "patientLogin")
    public PatientEntity patientLogin(@WebParam(name = "identityNumber") String identityNumber, @WebParam(name = "securityCode") String securityCode) throws InvalidLoginException {
        return ejbRef.patientLogin(identityNumber, securityCode);
    }
    
}
