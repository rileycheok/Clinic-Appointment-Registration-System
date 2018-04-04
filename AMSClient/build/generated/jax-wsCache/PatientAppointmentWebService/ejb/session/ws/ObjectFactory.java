
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

    private final static QName _EntityManagerException_QNAME = new QName("http://ws.session.ejb/", "EntityManagerException");
    private final static QName _ParseException_QNAME = new QName("http://ws.session.ejb/", "ParseException");
    private final static QName _CreateNewAppointment_QNAME = new QName("http://ws.session.ejb/", "createNewAppointment");
    private final static QName _CreateNewAppointmentResponse_QNAME = new QName("http://ws.session.ejb/", "createNewAppointmentResponse");
    private final static QName _DeleteAllAppointments_QNAME = new QName("http://ws.session.ejb/", "deleteAllAppointments");
    private final static QName _DeleteAllAppointmentsResponse_QNAME = new QName("http://ws.session.ejb/", "deleteAllAppointmentsResponse");
    private final static QName _DeleteAppointment_QNAME = new QName("http://ws.session.ejb/", "deleteAppointment");
    private final static QName _DeleteAppointmentResponse_QNAME = new QName("http://ws.session.ejb/", "deleteAppointmentResponse");
    private final static QName _RetrieveAllAppointments_QNAME = new QName("http://ws.session.ejb/", "retrieveAllAppointments");
    private final static QName _RetrieveAllAppointmentsResponse_QNAME = new QName("http://ws.session.ejb/", "retrieveAllAppointmentsResponse");
    private final static QName _RetrieveAppointmentByAppointmentId_QNAME = new QName("http://ws.session.ejb/", "retrieveAppointmentByAppointmentId");
    private final static QName _RetrieveAppointmentByAppointmentIdResponse_QNAME = new QName("http://ws.session.ejb/", "retrieveAppointmentByAppointmentIdResponse");
    private final static QName _RetrieveAppointmentsByAppointmentDate_QNAME = new QName("http://ws.session.ejb/", "retrieveAppointmentsByAppointmentDate");
    private final static QName _RetrieveAppointmentsByAppointmentDateResponse_QNAME = new QName("http://ws.session.ejb/", "retrieveAppointmentsByAppointmentDateResponse");
    private final static QName _RetrieveAppointmentsByDateAndDoctor_QNAME = new QName("http://ws.session.ejb/", "retrieveAppointmentsByDateAndDoctor");
    private final static QName _RetrieveAppointmentsByDateAndDoctorResponse_QNAME = new QName("http://ws.session.ejb/", "retrieveAppointmentsByDateAndDoctorResponse");
    private final static QName _RetrieveAppointmentsByDateAndTime_QNAME = new QName("http://ws.session.ejb/", "retrieveAppointmentsByDateAndTime");
    private final static QName _RetrieveAppointmentsByDateAndTimeResponse_QNAME = new QName("http://ws.session.ejb/", "retrieveAppointmentsByDateAndTimeResponse");
    private final static QName _RetrieveAppointmentsByDoctor_QNAME = new QName("http://ws.session.ejb/", "retrieveAppointmentsByDoctor");
    private final static QName _RetrieveAppointmentsByDoctorResponse_QNAME = new QName("http://ws.session.ejb/", "retrieveAppointmentsByDoctorResponse");
    private final static QName _RetrieveAppointmentsByPatient_QNAME = new QName("http://ws.session.ejb/", "retrieveAppointmentsByPatient");
    private final static QName _RetrieveAppointmentsByPatientResponse_QNAME = new QName("http://ws.session.ejb/", "retrieveAppointmentsByPatientResponse");
    private final static QName _UpdateAppointment_QNAME = new QName("http://ws.session.ejb/", "updateAppointment");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ejb.session.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link EntityManagerException }
     * 
     */
    public EntityManagerException createEntityManagerException() {
        return new EntityManagerException();
    }

    /**
     * Create an instance of {@link ParseException }
     * 
     */
    public ParseException createParseException() {
        return new ParseException();
    }

    /**
     * Create an instance of {@link CreateNewAppointment }
     * 
     */
    public CreateNewAppointment createCreateNewAppointment() {
        return new CreateNewAppointment();
    }

    /**
     * Create an instance of {@link CreateNewAppointmentResponse }
     * 
     */
    public CreateNewAppointmentResponse createCreateNewAppointmentResponse() {
        return new CreateNewAppointmentResponse();
    }

    /**
     * Create an instance of {@link DeleteAllAppointments }
     * 
     */
    public DeleteAllAppointments createDeleteAllAppointments() {
        return new DeleteAllAppointments();
    }

    /**
     * Create an instance of {@link DeleteAllAppointmentsResponse }
     * 
     */
    public DeleteAllAppointmentsResponse createDeleteAllAppointmentsResponse() {
        return new DeleteAllAppointmentsResponse();
    }

    /**
     * Create an instance of {@link DeleteAppointment }
     * 
     */
    public DeleteAppointment createDeleteAppointment() {
        return new DeleteAppointment();
    }

    /**
     * Create an instance of {@link DeleteAppointmentResponse }
     * 
     */
    public DeleteAppointmentResponse createDeleteAppointmentResponse() {
        return new DeleteAppointmentResponse();
    }

    /**
     * Create an instance of {@link RetrieveAllAppointments }
     * 
     */
    public RetrieveAllAppointments createRetrieveAllAppointments() {
        return new RetrieveAllAppointments();
    }

    /**
     * Create an instance of {@link RetrieveAllAppointmentsResponse }
     * 
     */
    public RetrieveAllAppointmentsResponse createRetrieveAllAppointmentsResponse() {
        return new RetrieveAllAppointmentsResponse();
    }

    /**
     * Create an instance of {@link RetrieveAppointmentByAppointmentId }
     * 
     */
    public RetrieveAppointmentByAppointmentId createRetrieveAppointmentByAppointmentId() {
        return new RetrieveAppointmentByAppointmentId();
    }

    /**
     * Create an instance of {@link RetrieveAppointmentByAppointmentIdResponse }
     * 
     */
    public RetrieveAppointmentByAppointmentIdResponse createRetrieveAppointmentByAppointmentIdResponse() {
        return new RetrieveAppointmentByAppointmentIdResponse();
    }

    /**
     * Create an instance of {@link RetrieveAppointmentsByAppointmentDate }
     * 
     */
    public RetrieveAppointmentsByAppointmentDate createRetrieveAppointmentsByAppointmentDate() {
        return new RetrieveAppointmentsByAppointmentDate();
    }

    /**
     * Create an instance of {@link RetrieveAppointmentsByAppointmentDateResponse }
     * 
     */
    public RetrieveAppointmentsByAppointmentDateResponse createRetrieveAppointmentsByAppointmentDateResponse() {
        return new RetrieveAppointmentsByAppointmentDateResponse();
    }

    /**
     * Create an instance of {@link RetrieveAppointmentsByDateAndDoctor }
     * 
     */
    public RetrieveAppointmentsByDateAndDoctor createRetrieveAppointmentsByDateAndDoctor() {
        return new RetrieveAppointmentsByDateAndDoctor();
    }

    /**
     * Create an instance of {@link RetrieveAppointmentsByDateAndDoctorResponse }
     * 
     */
    public RetrieveAppointmentsByDateAndDoctorResponse createRetrieveAppointmentsByDateAndDoctorResponse() {
        return new RetrieveAppointmentsByDateAndDoctorResponse();
    }

    /**
     * Create an instance of {@link RetrieveAppointmentsByDateAndTime }
     * 
     */
    public RetrieveAppointmentsByDateAndTime createRetrieveAppointmentsByDateAndTime() {
        return new RetrieveAppointmentsByDateAndTime();
    }

    /**
     * Create an instance of {@link RetrieveAppointmentsByDateAndTimeResponse }
     * 
     */
    public RetrieveAppointmentsByDateAndTimeResponse createRetrieveAppointmentsByDateAndTimeResponse() {
        return new RetrieveAppointmentsByDateAndTimeResponse();
    }

    /**
     * Create an instance of {@link RetrieveAppointmentsByDoctor }
     * 
     */
    public RetrieveAppointmentsByDoctor createRetrieveAppointmentsByDoctor() {
        return new RetrieveAppointmentsByDoctor();
    }

    /**
     * Create an instance of {@link RetrieveAppointmentsByDoctorResponse }
     * 
     */
    public RetrieveAppointmentsByDoctorResponse createRetrieveAppointmentsByDoctorResponse() {
        return new RetrieveAppointmentsByDoctorResponse();
    }

    /**
     * Create an instance of {@link RetrieveAppointmentsByPatient }
     * 
     */
    public RetrieveAppointmentsByPatient createRetrieveAppointmentsByPatient() {
        return new RetrieveAppointmentsByPatient();
    }

    /**
     * Create an instance of {@link RetrieveAppointmentsByPatientResponse }
     * 
     */
    public RetrieveAppointmentsByPatientResponse createRetrieveAppointmentsByPatientResponse() {
        return new RetrieveAppointmentsByPatientResponse();
    }

    /**
     * Create an instance of {@link UpdateAppointment }
     * 
     */
    public UpdateAppointment createUpdateAppointment() {
        return new UpdateAppointment();
    }

    /**
     * Create an instance of {@link AppointmentEntity }
     * 
     */
    public AppointmentEntity createAppointmentEntity() {
        return new AppointmentEntity();
    }

    /**
     * Create an instance of {@link DoctorEntity }
     * 
     */
    public DoctorEntity createDoctorEntity() {
        return new DoctorEntity();
    }

    /**
     * Create an instance of {@link PatientEntity }
     * 
     */
    public PatientEntity createPatientEntity() {
        return new PatientEntity();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EntityManagerException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "EntityManagerException")
    public JAXBElement<EntityManagerException> createEntityManagerException(EntityManagerException value) {
        return new JAXBElement<EntityManagerException>(_EntityManagerException_QNAME, EntityManagerException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ParseException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "ParseException")
    public JAXBElement<ParseException> createParseException(ParseException value) {
        return new JAXBElement<ParseException>(_ParseException_QNAME, ParseException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateNewAppointment }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "createNewAppointment")
    public JAXBElement<CreateNewAppointment> createCreateNewAppointment(CreateNewAppointment value) {
        return new JAXBElement<CreateNewAppointment>(_CreateNewAppointment_QNAME, CreateNewAppointment.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateNewAppointmentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "createNewAppointmentResponse")
    public JAXBElement<CreateNewAppointmentResponse> createCreateNewAppointmentResponse(CreateNewAppointmentResponse value) {
        return new JAXBElement<CreateNewAppointmentResponse>(_CreateNewAppointmentResponse_QNAME, CreateNewAppointmentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteAllAppointments }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "deleteAllAppointments")
    public JAXBElement<DeleteAllAppointments> createDeleteAllAppointments(DeleteAllAppointments value) {
        return new JAXBElement<DeleteAllAppointments>(_DeleteAllAppointments_QNAME, DeleteAllAppointments.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteAllAppointmentsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "deleteAllAppointmentsResponse")
    public JAXBElement<DeleteAllAppointmentsResponse> createDeleteAllAppointmentsResponse(DeleteAllAppointmentsResponse value) {
        return new JAXBElement<DeleteAllAppointmentsResponse>(_DeleteAllAppointmentsResponse_QNAME, DeleteAllAppointmentsResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteAppointmentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "deleteAppointmentResponse")
    public JAXBElement<DeleteAppointmentResponse> createDeleteAppointmentResponse(DeleteAppointmentResponse value) {
        return new JAXBElement<DeleteAppointmentResponse>(_DeleteAppointmentResponse_QNAME, DeleteAppointmentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RetrieveAllAppointments }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "retrieveAllAppointments")
    public JAXBElement<RetrieveAllAppointments> createRetrieveAllAppointments(RetrieveAllAppointments value) {
        return new JAXBElement<RetrieveAllAppointments>(_RetrieveAllAppointments_QNAME, RetrieveAllAppointments.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RetrieveAllAppointmentsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "retrieveAllAppointmentsResponse")
    public JAXBElement<RetrieveAllAppointmentsResponse> createRetrieveAllAppointmentsResponse(RetrieveAllAppointmentsResponse value) {
        return new JAXBElement<RetrieveAllAppointmentsResponse>(_RetrieveAllAppointmentsResponse_QNAME, RetrieveAllAppointmentsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RetrieveAppointmentByAppointmentId }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "retrieveAppointmentByAppointmentId")
    public JAXBElement<RetrieveAppointmentByAppointmentId> createRetrieveAppointmentByAppointmentId(RetrieveAppointmentByAppointmentId value) {
        return new JAXBElement<RetrieveAppointmentByAppointmentId>(_RetrieveAppointmentByAppointmentId_QNAME, RetrieveAppointmentByAppointmentId.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RetrieveAppointmentByAppointmentIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "retrieveAppointmentByAppointmentIdResponse")
    public JAXBElement<RetrieveAppointmentByAppointmentIdResponse> createRetrieveAppointmentByAppointmentIdResponse(RetrieveAppointmentByAppointmentIdResponse value) {
        return new JAXBElement<RetrieveAppointmentByAppointmentIdResponse>(_RetrieveAppointmentByAppointmentIdResponse_QNAME, RetrieveAppointmentByAppointmentIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RetrieveAppointmentsByAppointmentDate }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "retrieveAppointmentsByAppointmentDate")
    public JAXBElement<RetrieveAppointmentsByAppointmentDate> createRetrieveAppointmentsByAppointmentDate(RetrieveAppointmentsByAppointmentDate value) {
        return new JAXBElement<RetrieveAppointmentsByAppointmentDate>(_RetrieveAppointmentsByAppointmentDate_QNAME, RetrieveAppointmentsByAppointmentDate.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RetrieveAppointmentsByAppointmentDateResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "retrieveAppointmentsByAppointmentDateResponse")
    public JAXBElement<RetrieveAppointmentsByAppointmentDateResponse> createRetrieveAppointmentsByAppointmentDateResponse(RetrieveAppointmentsByAppointmentDateResponse value) {
        return new JAXBElement<RetrieveAppointmentsByAppointmentDateResponse>(_RetrieveAppointmentsByAppointmentDateResponse_QNAME, RetrieveAppointmentsByAppointmentDateResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RetrieveAppointmentsByDateAndDoctor }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "retrieveAppointmentsByDateAndDoctor")
    public JAXBElement<RetrieveAppointmentsByDateAndDoctor> createRetrieveAppointmentsByDateAndDoctor(RetrieveAppointmentsByDateAndDoctor value) {
        return new JAXBElement<RetrieveAppointmentsByDateAndDoctor>(_RetrieveAppointmentsByDateAndDoctor_QNAME, RetrieveAppointmentsByDateAndDoctor.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RetrieveAppointmentsByDateAndDoctorResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "retrieveAppointmentsByDateAndDoctorResponse")
    public JAXBElement<RetrieveAppointmentsByDateAndDoctorResponse> createRetrieveAppointmentsByDateAndDoctorResponse(RetrieveAppointmentsByDateAndDoctorResponse value) {
        return new JAXBElement<RetrieveAppointmentsByDateAndDoctorResponse>(_RetrieveAppointmentsByDateAndDoctorResponse_QNAME, RetrieveAppointmentsByDateAndDoctorResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RetrieveAppointmentsByDateAndTime }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "retrieveAppointmentsByDateAndTime")
    public JAXBElement<RetrieveAppointmentsByDateAndTime> createRetrieveAppointmentsByDateAndTime(RetrieveAppointmentsByDateAndTime value) {
        return new JAXBElement<RetrieveAppointmentsByDateAndTime>(_RetrieveAppointmentsByDateAndTime_QNAME, RetrieveAppointmentsByDateAndTime.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RetrieveAppointmentsByDateAndTimeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "retrieveAppointmentsByDateAndTimeResponse")
    public JAXBElement<RetrieveAppointmentsByDateAndTimeResponse> createRetrieveAppointmentsByDateAndTimeResponse(RetrieveAppointmentsByDateAndTimeResponse value) {
        return new JAXBElement<RetrieveAppointmentsByDateAndTimeResponse>(_RetrieveAppointmentsByDateAndTimeResponse_QNAME, RetrieveAppointmentsByDateAndTimeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RetrieveAppointmentsByDoctor }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "retrieveAppointmentsByDoctor")
    public JAXBElement<RetrieveAppointmentsByDoctor> createRetrieveAppointmentsByDoctor(RetrieveAppointmentsByDoctor value) {
        return new JAXBElement<RetrieveAppointmentsByDoctor>(_RetrieveAppointmentsByDoctor_QNAME, RetrieveAppointmentsByDoctor.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RetrieveAppointmentsByDoctorResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "retrieveAppointmentsByDoctorResponse")
    public JAXBElement<RetrieveAppointmentsByDoctorResponse> createRetrieveAppointmentsByDoctorResponse(RetrieveAppointmentsByDoctorResponse value) {
        return new JAXBElement<RetrieveAppointmentsByDoctorResponse>(_RetrieveAppointmentsByDoctorResponse_QNAME, RetrieveAppointmentsByDoctorResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RetrieveAppointmentsByPatient }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "retrieveAppointmentsByPatient")
    public JAXBElement<RetrieveAppointmentsByPatient> createRetrieveAppointmentsByPatient(RetrieveAppointmentsByPatient value) {
        return new JAXBElement<RetrieveAppointmentsByPatient>(_RetrieveAppointmentsByPatient_QNAME, RetrieveAppointmentsByPatient.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RetrieveAppointmentsByPatientResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "retrieveAppointmentsByPatientResponse")
    public JAXBElement<RetrieveAppointmentsByPatientResponse> createRetrieveAppointmentsByPatientResponse(RetrieveAppointmentsByPatientResponse value) {
        return new JAXBElement<RetrieveAppointmentsByPatientResponse>(_RetrieveAppointmentsByPatientResponse_QNAME, RetrieveAppointmentsByPatientResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateAppointment }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "updateAppointment")
    public JAXBElement<UpdateAppointment> createUpdateAppointment(UpdateAppointment value) {
        return new JAXBElement<UpdateAppointment>(_UpdateAppointment_QNAME, UpdateAppointment.class, null, value);
    }

}
