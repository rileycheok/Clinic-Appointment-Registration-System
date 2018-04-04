
package ejb.session.ws;

import java.util.List;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.FaultAction;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.11-b150120.1832
 * Generated source version: 2.2
 * 
 */
@WebService(name = "PatientAppointmentWebService", targetNamespace = "http://ws.session.ejb/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface PatientAppointmentWebService {


    /**
     * 
     * @param newAppointmentEntity
     * @return
     *     returns ejb.session.ws.AppointmentEntity
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "createNewAppointment", targetNamespace = "http://ws.session.ejb/", className = "ejb.session.ws.CreateNewAppointment")
    @ResponseWrapper(localName = "createNewAppointmentResponse", targetNamespace = "http://ws.session.ejb/", className = "ejb.session.ws.CreateNewAppointmentResponse")
    @Action(input = "http://ws.session.ejb/PatientAppointmentWebService/createNewAppointmentRequest", output = "http://ws.session.ejb/PatientAppointmentWebService/createNewAppointmentResponse")
    public AppointmentEntity createNewAppointment(
        @WebParam(name = "newAppointmentEntity", targetNamespace = "")
        AppointmentEntity newAppointmentEntity);

    /**
     * 
     * @return
     *     returns java.util.List<ejb.session.ws.AppointmentEntity>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "retrieveAllAppointments", targetNamespace = "http://ws.session.ejb/", className = "ejb.session.ws.RetrieveAllAppointments")
    @ResponseWrapper(localName = "retrieveAllAppointmentsResponse", targetNamespace = "http://ws.session.ejb/", className = "ejb.session.ws.RetrieveAllAppointmentsResponse")
    @Action(input = "http://ws.session.ejb/PatientAppointmentWebService/retrieveAllAppointmentsRequest", output = "http://ws.session.ejb/PatientAppointmentWebService/retrieveAllAppointmentsResponse")
    public List<AppointmentEntity> retrieveAllAppointments();

    /**
     * 
     * @throws EntityManagerException_Exception
     */
    @WebMethod
    @RequestWrapper(localName = "deleteAllAppointments", targetNamespace = "http://ws.session.ejb/", className = "ejb.session.ws.DeleteAllAppointments")
    @ResponseWrapper(localName = "deleteAllAppointmentsResponse", targetNamespace = "http://ws.session.ejb/", className = "ejb.session.ws.DeleteAllAppointmentsResponse")
    @Action(input = "http://ws.session.ejb/PatientAppointmentWebService/deleteAllAppointmentsRequest", output = "http://ws.session.ejb/PatientAppointmentWebService/deleteAllAppointmentsResponse", fault = {
        @FaultAction(className = EntityManagerException_Exception.class, value = "http://ws.session.ejb/PatientAppointmentWebService/deleteAllAppointments/Fault/EntityManagerException")
    })
    public void deleteAllAppointments()
        throws EntityManagerException_Exception
    ;

    /**
     * 
     * @param doctorEntity
     * @return
     *     returns java.util.List<ejb.session.ws.AppointmentEntity>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "retrieveAppointmentsByDoctor", targetNamespace = "http://ws.session.ejb/", className = "ejb.session.ws.RetrieveAppointmentsByDoctor")
    @ResponseWrapper(localName = "retrieveAppointmentsByDoctorResponse", targetNamespace = "http://ws.session.ejb/", className = "ejb.session.ws.RetrieveAppointmentsByDoctorResponse")
    @Action(input = "http://ws.session.ejb/PatientAppointmentWebService/retrieveAppointmentsByDoctorRequest", output = "http://ws.session.ejb/PatientAppointmentWebService/retrieveAppointmentsByDoctorResponse")
    public List<AppointmentEntity> retrieveAppointmentsByDoctor(
        @WebParam(name = "doctorEntity", targetNamespace = "")
        DoctorEntity doctorEntity);

    /**
     * 
     * @param appointmentEntity
     */
    @WebMethod
    @Oneway
    @RequestWrapper(localName = "updateAppointment", targetNamespace = "http://ws.session.ejb/", className = "ejb.session.ws.UpdateAppointment")
    @Action(input = "http://ws.session.ejb/PatientAppointmentWebService/updateAppointment")
    public void updateAppointment(
        @WebParam(name = "appointmentEntity", targetNamespace = "")
        AppointmentEntity appointmentEntity);

    /**
     * 
     * @param patientEntity
     * @return
     *     returns java.util.List<ejb.session.ws.AppointmentEntity>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "retrieveAppointmentsByPatient", targetNamespace = "http://ws.session.ejb/", className = "ejb.session.ws.RetrieveAppointmentsByPatient")
    @ResponseWrapper(localName = "retrieveAppointmentsByPatientResponse", targetNamespace = "http://ws.session.ejb/", className = "ejb.session.ws.RetrieveAppointmentsByPatientResponse")
    @Action(input = "http://ws.session.ejb/PatientAppointmentWebService/retrieveAppointmentsByPatientRequest", output = "http://ws.session.ejb/PatientAppointmentWebService/retrieveAppointmentsByPatientResponse")
    public List<AppointmentEntity> retrieveAppointmentsByPatient(
        @WebParam(name = "patientEntity", targetNamespace = "")
        PatientEntity patientEntity);

    /**
     * 
     * @param appointmentId
     * @return
     *     returns ejb.session.ws.AppointmentEntity
     * @throws EntityManagerException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "retrieveAppointmentByAppointmentId", targetNamespace = "http://ws.session.ejb/", className = "ejb.session.ws.RetrieveAppointmentByAppointmentId")
    @ResponseWrapper(localName = "retrieveAppointmentByAppointmentIdResponse", targetNamespace = "http://ws.session.ejb/", className = "ejb.session.ws.RetrieveAppointmentByAppointmentIdResponse")
    @Action(input = "http://ws.session.ejb/PatientAppointmentWebService/retrieveAppointmentByAppointmentIdRequest", output = "http://ws.session.ejb/PatientAppointmentWebService/retrieveAppointmentByAppointmentIdResponse", fault = {
        @FaultAction(className = EntityManagerException_Exception.class, value = "http://ws.session.ejb/PatientAppointmentWebService/retrieveAppointmentByAppointmentId/Fault/EntityManagerException")
    })
    public AppointmentEntity retrieveAppointmentByAppointmentId(
        @WebParam(name = "appointmentId", targetNamespace = "")
        Long appointmentId)
        throws EntityManagerException_Exception
    ;

    /**
     * 
     * @param date
     * @param time
     * @return
     *     returns java.util.List<ejb.session.ws.AppointmentEntity>
     * @throws ParseException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "retrieveAppointmentsByDateAndTime", targetNamespace = "http://ws.session.ejb/", className = "ejb.session.ws.RetrieveAppointmentsByDateAndTime")
    @ResponseWrapper(localName = "retrieveAppointmentsByDateAndTimeResponse", targetNamespace = "http://ws.session.ejb/", className = "ejb.session.ws.RetrieveAppointmentsByDateAndTimeResponse")
    @Action(input = "http://ws.session.ejb/PatientAppointmentWebService/retrieveAppointmentsByDateAndTimeRequest", output = "http://ws.session.ejb/PatientAppointmentWebService/retrieveAppointmentsByDateAndTimeResponse", fault = {
        @FaultAction(className = ParseException_Exception.class, value = "http://ws.session.ejb/PatientAppointmentWebService/retrieveAppointmentsByDateAndTime/Fault/ParseException")
    })
    public List<AppointmentEntity> retrieveAppointmentsByDateAndTime(
        @WebParam(name = "date", targetNamespace = "")
        String date,
        @WebParam(name = "time", targetNamespace = "")
        String time)
        throws ParseException_Exception
    ;

    /**
     * 
     * @param appointmentDate
     * @return
     *     returns java.util.List<ejb.session.ws.AppointmentEntity>
     * @throws EntityManagerException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "retrieveAppointmentsByAppointmentDate", targetNamespace = "http://ws.session.ejb/", className = "ejb.session.ws.RetrieveAppointmentsByAppointmentDate")
    @ResponseWrapper(localName = "retrieveAppointmentsByAppointmentDateResponse", targetNamespace = "http://ws.session.ejb/", className = "ejb.session.ws.RetrieveAppointmentsByAppointmentDateResponse")
    @Action(input = "http://ws.session.ejb/PatientAppointmentWebService/retrieveAppointmentsByAppointmentDateRequest", output = "http://ws.session.ejb/PatientAppointmentWebService/retrieveAppointmentsByAppointmentDateResponse", fault = {
        @FaultAction(className = EntityManagerException_Exception.class, value = "http://ws.session.ejb/PatientAppointmentWebService/retrieveAppointmentsByAppointmentDate/Fault/EntityManagerException")
    })
    public List<AppointmentEntity> retrieveAppointmentsByAppointmentDate(
        @WebParam(name = "appointmentDate", targetNamespace = "")
        String appointmentDate)
        throws EntityManagerException_Exception
    ;

    /**
     * 
     * @param date
     * @param doctorEntity
     * @return
     *     returns java.util.List<ejb.session.ws.AppointmentEntity>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "retrieveAppointmentsByDateAndDoctor", targetNamespace = "http://ws.session.ejb/", className = "ejb.session.ws.RetrieveAppointmentsByDateAndDoctor")
    @ResponseWrapper(localName = "retrieveAppointmentsByDateAndDoctorResponse", targetNamespace = "http://ws.session.ejb/", className = "ejb.session.ws.RetrieveAppointmentsByDateAndDoctorResponse")
    @Action(input = "http://ws.session.ejb/PatientAppointmentWebService/retrieveAppointmentsByDateAndDoctorRequest", output = "http://ws.session.ejb/PatientAppointmentWebService/retrieveAppointmentsByDateAndDoctorResponse")
    public List<AppointmentEntity> retrieveAppointmentsByDateAndDoctor(
        @WebParam(name = "date", targetNamespace = "")
        String date,
        @WebParam(name = "doctorEntity", targetNamespace = "")
        DoctorEntity doctorEntity);

    /**
     * 
     * @param patientId
     * @param doctorId
     * @param appointmentId
     * @throws EntityManagerException_Exception
     */
    @WebMethod
    @RequestWrapper(localName = "deleteAppointment", targetNamespace = "http://ws.session.ejb/", className = "ejb.session.ws.DeleteAppointment")
    @ResponseWrapper(localName = "deleteAppointmentResponse", targetNamespace = "http://ws.session.ejb/", className = "ejb.session.ws.DeleteAppointmentResponse")
    @Action(input = "http://ws.session.ejb/PatientAppointmentWebService/deleteAppointmentRequest", output = "http://ws.session.ejb/PatientAppointmentWebService/deleteAppointmentResponse", fault = {
        @FaultAction(className = EntityManagerException_Exception.class, value = "http://ws.session.ejb/PatientAppointmentWebService/deleteAppointment/Fault/EntityManagerException")
    })
    public void deleteAppointment(
        @WebParam(name = "appointmentId", targetNamespace = "")
        Long appointmentId,
        @WebParam(name = "patientId", targetNamespace = "")
        Long patientId,
        @WebParam(name = "doctorId", targetNamespace = "")
        Long doctorId)
        throws EntityManagerException_Exception
    ;

}