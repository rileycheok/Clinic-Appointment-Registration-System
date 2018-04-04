
package ejb.session.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ejb.session.ws package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _InvalidLoginException_QNAME = new QName("http://ws.session.ejb/", "InvalidLoginException");
    private final static QName _PatientNotFoundException_QNAME = new QName("http://ws.session.ejb/", "PatientNotFoundException");
    private final static QName _AddAppointmentToPatient_QNAME = new QName("http://ws.session.ejb/", "addAppointmentToPatient");
    private final static QName _CreateNewPatient_QNAME = new QName("http://ws.session.ejb/", "createNewPatient");
    private final static QName _CreateNewPatientResponse_QNAME = new QName("http://ws.session.ejb/", "createNewPatientResponse");
    private final static QName _DeleteAppointment_QNAME = new QName("http://ws.session.ejb/", "deleteAppointment");
    private final static QName _DeletePatient_QNAME = new QName("http://ws.session.ejb/", "deletePatient");
    private final static QName _DeletePatientResponse_QNAME = new QName("http://ws.session.ejb/", "deletePatientResponse");
    private final static QName _PatientExistsByIdentityNumber_QNAME = new QName("http://ws.session.ejb/", "patientExistsByIdentityNumber");
    private final static QName _PatientExistsByIdentityNumberResponse_QNAME = new QName("http://ws.session.ejb/", "patientExistsByIdentityNumberResponse");
    private final static QName _PatientLogin_QNAME = new QName("http://ws.session.ejb/", "patientLogin");
    private final static QName _PatientLoginResponse_QNAME = new QName("http://ws.session.ejb/", "patientLoginResponse");
    private final static QName _RetrieveAllPatients_QNAME = new QName("http://ws.session.ejb/", "retrieveAllPatients");
    private final static QName _RetrieveAllPatientsResponse_QNAME = new QName("http://ws.session.ejb/", "retrieveAllPatientsResponse");
    private final static QName _RetrievePatientByIdentityNumber_QNAME = new QName("http://ws.session.ejb/", "retrievePatientByIdentityNumber");
    private final static QName _RetrievePatientByIdentityNumberResponse_QNAME = new QName("http://ws.session.ejb/", "retrievePatientByIdentityNumberResponse");
    private final static QName _RetrievePatientByPatientId_QNAME = new QName("http://ws.session.ejb/", "retrievePatientByPatientId");
    private final static QName _RetrievePatientByPatientIdResponse_QNAME = new QName("http://ws.session.ejb/", "retrievePatientByPatientIdResponse");
    private final static QName _UpdatePatient_QNAME = new QName("http://ws.session.ejb/", "updatePatient");
    private final static QName _UpdatePatientResponse_QNAME = new QName("http://ws.session.ejb/", "updatePatientResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ejb.session.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link InvalidLoginException }
     * 
     */
    public InvalidLoginException createInvalidLoginException() {
        return new InvalidLoginException();
    }

    /**
     * Create an instance of {@link PatientNotFoundException }
     * 
     */
    public PatientNotFoundException createPatientNotFoundException() {
        return new PatientNotFoundException();
    }

    /**
     * Create an instance of {@link AddAppointmentToPatient }
     * 
     */
    public AddAppointmentToPatient createAddAppointmentToPatient() {
        return new AddAppointmentToPatient();
    }

    /**
     * Create an instance of {@link CreateNewPatient }
     * 
     */
    public CreateNewPatient createCreateNewPatient() {
        return new CreateNewPatient();
    }

    /**
     * Create an instance of {@link CreateNewPatientResponse }
     * 
     */
    public CreateNewPatientResponse createCreateNewPatientResponse() {
        return new CreateNewPatientResponse();
    }

    /**
     * Create an instance of {@link DeleteAppointment }
     * 
     */
    public DeleteAppointment createDeleteAppointment() {
        return new DeleteAppointment();
    }

    /**
     * Create an instance of {@link DeletePatient }
     * 
     */
    public DeletePatient createDeletePatient() {
        return new DeletePatient();
    }

    /**
     * Create an instance of {@link DeletePatientResponse }
     * 
     */
    public DeletePatientResponse createDeletePatientResponse() {
        return new DeletePatientResponse();
    }

    /**
     * Create an instance of {@link PatientExistsByIdentityNumber }
     * 
     */
    public PatientExistsByIdentityNumber createPatientExistsByIdentityNumber() {
        return new PatientExistsByIdentityNumber();
    }

    /**
     * Create an instance of {@link PatientExistsByIdentityNumberResponse }
     * 
     */
    public PatientExistsByIdentityNumberResponse createPatientExistsByIdentityNumberResponse() {
        return new PatientExistsByIdentityNumberResponse();
    }

    /**
     * Create an instance of {@link PatientLogin }
     * 
     */
    public PatientLogin createPatientLogin() {
        return new PatientLogin();
    }

    /**
     * Create an instance of {@link PatientLoginResponse }
     * 
     */
    public PatientLoginResponse createPatientLoginResponse() {
        return new PatientLoginResponse();
    }

    /**
     * Create an instance of {@link RetrieveAllPatients }
     * 
     */
    public RetrieveAllPatients createRetrieveAllPatients() {
        return new RetrieveAllPatients();
    }

    /**
     * Create an instance of {@link RetrieveAllPatientsResponse }
     * 
     */
    public RetrieveAllPatientsResponse createRetrieveAllPatientsResponse() {
        return new RetrieveAllPatientsResponse();
    }

    /**
     * Create an instance of {@link RetrievePatientByIdentityNumber }
     * 
     */
    public RetrievePatientByIdentityNumber createRetrievePatientByIdentityNumber() {
        return new RetrievePatientByIdentityNumber();
    }

    /**
     * Create an instance of {@link RetrievePatientByIdentityNumberResponse }
     * 
     */
    public RetrievePatientByIdentityNumberResponse createRetrievePatientByIdentityNumberResponse() {
        return new RetrievePatientByIdentityNumberResponse();
    }

    /**
     * Create an instance of {@link RetrievePatientByPatientId }
     * 
     */
    public RetrievePatientByPatientId createRetrievePatientByPatientId() {
        return new RetrievePatientByPatientId();
    }

    /**
     * Create an instance of {@link RetrievePatientByPatientIdResponse }
     * 
     */
    public RetrievePatientByPatientIdResponse createRetrievePatientByPatientIdResponse() {
        return new RetrievePatientByPatientIdResponse();
    }

    /**
     * Create an instance of {@link UpdatePatient }
     * 
     */
    public UpdatePatient createUpdatePatient() {
        return new UpdatePatient();
    }

    /**
     * Create an instance of {@link UpdatePatientResponse }
     * 
     */
    public UpdatePatientResponse createUpdatePatientResponse() {
        return new UpdatePatientResponse();
    }

    /**
     * Create an instance of {@link PatientEntity }
     * 
     */
    public PatientEntity createPatientEntity() {
        return new PatientEntity();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InvalidLoginException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "InvalidLoginException")
    public JAXBElement<InvalidLoginException> createInvalidLoginException(InvalidLoginException value) {
        return new JAXBElement<InvalidLoginException>(_InvalidLoginException_QNAME, InvalidLoginException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PatientNotFoundException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "PatientNotFoundException")
    public JAXBElement<PatientNotFoundException> createPatientNotFoundException(PatientNotFoundException value) {
        return new JAXBElement<PatientNotFoundException>(_PatientNotFoundException_QNAME, PatientNotFoundException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddAppointmentToPatient }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "addAppointmentToPatient")
    public JAXBElement<AddAppointmentToPatient> createAddAppointmentToPatient(AddAppointmentToPatient value) {
        return new JAXBElement<AddAppointmentToPatient>(_AddAppointmentToPatient_QNAME, AddAppointmentToPatient.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateNewPatient }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "createNewPatient")
    public JAXBElement<CreateNewPatient> createCreateNewPatient(CreateNewPatient value) {
        return new JAXBElement<CreateNewPatient>(_CreateNewPatient_QNAME, CreateNewPatient.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateNewPatientResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "createNewPatientResponse")
    public JAXBElement<CreateNewPatientResponse> createCreateNewPatientResponse(CreateNewPatientResponse value) {
        return new JAXBElement<CreateNewPatientResponse>(_CreateNewPatientResponse_QNAME, CreateNewPatientResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteAppointment }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "deleteAppointment")
    public JAXBElement<DeleteAppointment> createDeleteAppointment(DeleteAppointment value) {
        return new JAXBElement<DeleteAppointment>(_DeleteAppointment_QNAME, DeleteAppointment.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeletePatient }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "deletePatient")
    public JAXBElement<DeletePatient> createDeletePatient(DeletePatient value) {
        return new JAXBElement<DeletePatient>(_DeletePatient_QNAME, DeletePatient.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeletePatientResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "deletePatientResponse")
    public JAXBElement<DeletePatientResponse> createDeletePatientResponse(DeletePatientResponse value) {
        return new JAXBElement<DeletePatientResponse>(_DeletePatientResponse_QNAME, DeletePatientResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PatientExistsByIdentityNumber }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "patientExistsByIdentityNumber")
    public JAXBElement<PatientExistsByIdentityNumber> createPatientExistsByIdentityNumber(PatientExistsByIdentityNumber value) {
        return new JAXBElement<PatientExistsByIdentityNumber>(_PatientExistsByIdentityNumber_QNAME, PatientExistsByIdentityNumber.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PatientExistsByIdentityNumberResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "patientExistsByIdentityNumberResponse")
    public JAXBElement<PatientExistsByIdentityNumberResponse> createPatientExistsByIdentityNumberResponse(PatientExistsByIdentityNumberResponse value) {
        return new JAXBElement<PatientExistsByIdentityNumberResponse>(_PatientExistsByIdentityNumberResponse_QNAME, PatientExistsByIdentityNumberResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PatientLogin }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "patientLogin")
    public JAXBElement<PatientLogin> createPatientLogin(PatientLogin value) {
        return new JAXBElement<PatientLogin>(_PatientLogin_QNAME, PatientLogin.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PatientLoginResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "patientLoginResponse")
    public JAXBElement<PatientLoginResponse> createPatientLoginResponse(PatientLoginResponse value) {
        return new JAXBElement<PatientLoginResponse>(_PatientLoginResponse_QNAME, PatientLoginResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RetrieveAllPatients }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "retrieveAllPatients")
    public JAXBElement<RetrieveAllPatients> createRetrieveAllPatients(RetrieveAllPatients value) {
        return new JAXBElement<RetrieveAllPatients>(_RetrieveAllPatients_QNAME, RetrieveAllPatients.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RetrieveAllPatientsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "retrieveAllPatientsResponse")
    public JAXBElement<RetrieveAllPatientsResponse> createRetrieveAllPatientsResponse(RetrieveAllPatientsResponse value) {
        return new JAXBElement<RetrieveAllPatientsResponse>(_RetrieveAllPatientsResponse_QNAME, RetrieveAllPatientsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RetrievePatientByIdentityNumber }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "retrievePatientByIdentityNumber")
    public JAXBElement<RetrievePatientByIdentityNumber> createRetrievePatientByIdentityNumber(RetrievePatientByIdentityNumber value) {
        return new JAXBElement<RetrievePatientByIdentityNumber>(_RetrievePatientByIdentityNumber_QNAME, RetrievePatientByIdentityNumber.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RetrievePatientByIdentityNumberResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "retrievePatientByIdentityNumberResponse")
    public JAXBElement<RetrievePatientByIdentityNumberResponse> createRetrievePatientByIdentityNumberResponse(RetrievePatientByIdentityNumberResponse value) {
        return new JAXBElement<RetrievePatientByIdentityNumberResponse>(_RetrievePatientByIdentityNumberResponse_QNAME, RetrievePatientByIdentityNumberResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RetrievePatientByPatientId }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "retrievePatientByPatientId")
    public JAXBElement<RetrievePatientByPatientId> createRetrievePatientByPatientId(RetrievePatientByPatientId value) {
        return new JAXBElement<RetrievePatientByPatientId>(_RetrievePatientByPatientId_QNAME, RetrievePatientByPatientId.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RetrievePatientByPatientIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "retrievePatientByPatientIdResponse")
    public JAXBElement<RetrievePatientByPatientIdResponse> createRetrievePatientByPatientIdResponse(RetrievePatientByPatientIdResponse value) {
        return new JAXBElement<RetrievePatientByPatientIdResponse>(_RetrievePatientByPatientIdResponse_QNAME, RetrievePatientByPatientIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdatePatient }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "updatePatient")
    public JAXBElement<UpdatePatient> createUpdatePatient(UpdatePatient value) {
        return new JAXBElement<UpdatePatient>(_UpdatePatient_QNAME, UpdatePatient.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdatePatientResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "updatePatientResponse")
    public JAXBElement<UpdatePatientResponse> createUpdatePatientResponse(UpdatePatientResponse value) {
        return new JAXBElement<UpdatePatientResponse>(_UpdatePatientResponse_QNAME, UpdatePatientResponse.class, null, value);
    }

}
