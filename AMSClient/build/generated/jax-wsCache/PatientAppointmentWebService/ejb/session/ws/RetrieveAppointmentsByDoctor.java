
package ejb.session.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for retrieveAppointmentsByDoctor complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="retrieveAppointmentsByDoctor"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="doctorEntity" type="{http://ws.session.ejb/}doctorEntity" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "retrieveAppointmentsByDoctor", propOrder = {
    "doctorEntity"
})
public class RetrieveAppointmentsByDoctor {

    protected DoctorEntity doctorEntity;

    /**
     * Gets the value of the doctorEntity property.
     * 
     * @return
     *     possible object is
     *     {@link DoctorEntity }
     *     
     */
    public DoctorEntity getDoctorEntity() {
        return doctorEntity;
    }

    /**
     * Sets the value of the doctorEntity property.
     * 
     * @param value
     *     allowed object is
     *     {@link DoctorEntity }
     *     
     */
    public void setDoctorEntity(DoctorEntity value) {
        this.doctorEntity = value;
    }

}
