
package ejb.session.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for createNewAppointment complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="createNewAppointment"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="newAppointmentEntity" type="{http://ws.session.ejb/}appointmentEntity" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "createNewAppointment", propOrder = {
    "newAppointmentEntity"
})
public class CreateNewAppointment {

    protected AppointmentEntity newAppointmentEntity;

    /**
     * Gets the value of the newAppointmentEntity property.
     * 
     * @return
     *     possible object is
     *     {@link AppointmentEntity }
     *     
     */
    public AppointmentEntity getNewAppointmentEntity() {
        return newAppointmentEntity;
    }

    /**
     * Sets the value of the newAppointmentEntity property.
     * 
     * @param value
     *     allowed object is
     *     {@link AppointmentEntity }
     *     
     */
    public void setNewAppointmentEntity(AppointmentEntity value) {
        this.newAppointmentEntity = value;
    }

}
