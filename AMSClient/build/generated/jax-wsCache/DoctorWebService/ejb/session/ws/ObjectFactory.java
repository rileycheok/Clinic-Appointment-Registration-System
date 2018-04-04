
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

    private final static QName _DoctorNotFoundException_QNAME = new QName("http://ws.session.ejb/", "DoctorNotFoundException");
    private final static QName _AddAppointmentToDoctor_QNAME = new QName("http://ws.session.ejb/", "addAppointmentToDoctor");
    private final static QName _CreateNewDoctor_QNAME = new QName("http://ws.session.ejb/", "createNewDoctor");
    private final static QName _CreateNewDoctorResponse_QNAME = new QName("http://ws.session.ejb/", "createNewDoctorResponse");
    private final static QName _DeleteAppointment_QNAME = new QName("http://ws.session.ejb/", "deleteAppointment");
    private final static QName _DeleteDoctor_QNAME = new QName("http://ws.session.ejb/", "deleteDoctor");
    private final static QName _DeleteDoctorResponse_QNAME = new QName("http://ws.session.ejb/", "deleteDoctorResponse");
    private final static QName _RetrieveAllDoctors_QNAME = new QName("http://ws.session.ejb/", "retrieveAllDoctors");
    private final static QName _RetrieveAllDoctorsResponse_QNAME = new QName("http://ws.session.ejb/", "retrieveAllDoctorsResponse");
    private final static QName _RetrieveDoctorByDoctorId_QNAME = new QName("http://ws.session.ejb/", "retrieveDoctorByDoctorId");
    private final static QName _RetrieveDoctorByDoctorIdResponse_QNAME = new QName("http://ws.session.ejb/", "retrieveDoctorByDoctorIdResponse");
    private final static QName _UpdateDoctor_QNAME = new QName("http://ws.session.ejb/", "updateDoctor");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ejb.session.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DoctorNotFoundException }
     * 
     */
    public DoctorNotFoundException createDoctorNotFoundException() {
        return new DoctorNotFoundException();
    }

    /**
     * Create an instance of {@link AddAppointmentToDoctor }
     * 
     */
    public AddAppointmentToDoctor createAddAppointmentToDoctor() {
        return new AddAppointmentToDoctor();
    }

    /**
     * Create an instance of {@link CreateNewDoctor }
     * 
     */
    public CreateNewDoctor createCreateNewDoctor() {
        return new CreateNewDoctor();
    }

    /**
     * Create an instance of {@link CreateNewDoctorResponse }
     * 
     */
    public CreateNewDoctorResponse createCreateNewDoctorResponse() {
        return new CreateNewDoctorResponse();
    }

    /**
     * Create an instance of {@link DeleteAppointment }
     * 
     */
    public DeleteAppointment createDeleteAppointment() {
        return new DeleteAppointment();
    }

    /**
     * Create an instance of {@link DeleteDoctor }
     * 
     */
    public DeleteDoctor createDeleteDoctor() {
        return new DeleteDoctor();
    }

    /**
     * Create an instance of {@link DeleteDoctorResponse }
     * 
     */
    public DeleteDoctorResponse createDeleteDoctorResponse() {
        return new DeleteDoctorResponse();
    }

    /**
     * Create an instance of {@link RetrieveAllDoctors }
     * 
     */
    public RetrieveAllDoctors createRetrieveAllDoctors() {
        return new RetrieveAllDoctors();
    }

    /**
     * Create an instance of {@link RetrieveAllDoctorsResponse }
     * 
     */
    public RetrieveAllDoctorsResponse createRetrieveAllDoctorsResponse() {
        return new RetrieveAllDoctorsResponse();
    }

    /**
     * Create an instance of {@link RetrieveDoctorByDoctorId }
     * 
     */
    public RetrieveDoctorByDoctorId createRetrieveDoctorByDoctorId() {
        return new RetrieveDoctorByDoctorId();
    }

    /**
     * Create an instance of {@link RetrieveDoctorByDoctorIdResponse }
     * 
     */
    public RetrieveDoctorByDoctorIdResponse createRetrieveDoctorByDoctorIdResponse() {
        return new RetrieveDoctorByDoctorIdResponse();
    }

    /**
     * Create an instance of {@link UpdateDoctor }
     * 
     */
    public UpdateDoctor createUpdateDoctor() {
        return new UpdateDoctor();
    }

    /**
     * Create an instance of {@link DoctorEntity }
     * 
     */
    public DoctorEntity createDoctorEntity() {
        return new DoctorEntity();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DoctorNotFoundException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "DoctorNotFoundException")
    public JAXBElement<DoctorNotFoundException> createDoctorNotFoundException(DoctorNotFoundException value) {
        return new JAXBElement<DoctorNotFoundException>(_DoctorNotFoundException_QNAME, DoctorNotFoundException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddAppointmentToDoctor }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "addAppointmentToDoctor")
    public JAXBElement<AddAppointmentToDoctor> createAddAppointmentToDoctor(AddAppointmentToDoctor value) {
        return new JAXBElement<AddAppointmentToDoctor>(_AddAppointmentToDoctor_QNAME, AddAppointmentToDoctor.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateNewDoctor }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "createNewDoctor")
    public JAXBElement<CreateNewDoctor> createCreateNewDoctor(CreateNewDoctor value) {
        return new JAXBElement<CreateNewDoctor>(_CreateNewDoctor_QNAME, CreateNewDoctor.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateNewDoctorResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "createNewDoctorResponse")
    public JAXBElement<CreateNewDoctorResponse> createCreateNewDoctorResponse(CreateNewDoctorResponse value) {
        return new JAXBElement<CreateNewDoctorResponse>(_CreateNewDoctorResponse_QNAME, CreateNewDoctorResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteDoctor }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "deleteDoctor")
    public JAXBElement<DeleteDoctor> createDeleteDoctor(DeleteDoctor value) {
        return new JAXBElement<DeleteDoctor>(_DeleteDoctor_QNAME, DeleteDoctor.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteDoctorResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "deleteDoctorResponse")
    public JAXBElement<DeleteDoctorResponse> createDeleteDoctorResponse(DeleteDoctorResponse value) {
        return new JAXBElement<DeleteDoctorResponse>(_DeleteDoctorResponse_QNAME, DeleteDoctorResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RetrieveAllDoctors }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "retrieveAllDoctors")
    public JAXBElement<RetrieveAllDoctors> createRetrieveAllDoctors(RetrieveAllDoctors value) {
        return new JAXBElement<RetrieveAllDoctors>(_RetrieveAllDoctors_QNAME, RetrieveAllDoctors.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RetrieveAllDoctorsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "retrieveAllDoctorsResponse")
    public JAXBElement<RetrieveAllDoctorsResponse> createRetrieveAllDoctorsResponse(RetrieveAllDoctorsResponse value) {
        return new JAXBElement<RetrieveAllDoctorsResponse>(_RetrieveAllDoctorsResponse_QNAME, RetrieveAllDoctorsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RetrieveDoctorByDoctorId }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "retrieveDoctorByDoctorId")
    public JAXBElement<RetrieveDoctorByDoctorId> createRetrieveDoctorByDoctorId(RetrieveDoctorByDoctorId value) {
        return new JAXBElement<RetrieveDoctorByDoctorId>(_RetrieveDoctorByDoctorId_QNAME, RetrieveDoctorByDoctorId.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RetrieveDoctorByDoctorIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "retrieveDoctorByDoctorIdResponse")
    public JAXBElement<RetrieveDoctorByDoctorIdResponse> createRetrieveDoctorByDoctorIdResponse(RetrieveDoctorByDoctorIdResponse value) {
        return new JAXBElement<RetrieveDoctorByDoctorIdResponse>(_RetrieveDoctorByDoctorIdResponse_QNAME, RetrieveDoctorByDoctorIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateDoctor }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "updateDoctor")
    public JAXBElement<UpdateDoctor> createUpdateDoctor(UpdateDoctor value) {
        return new JAXBElement<UpdateDoctor>(_UpdateDoctor_QNAME, UpdateDoctor.class, null, value);
    }

}
