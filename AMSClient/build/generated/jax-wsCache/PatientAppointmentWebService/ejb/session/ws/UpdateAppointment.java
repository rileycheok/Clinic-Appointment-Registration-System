
package ejb.session.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for updateAppointment complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="updateAppointment"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="appointmentEntity" type="{http://ws.session.ejb/}appointmentEntity" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "updateAppointment", propOrder = {
    "appointmentEntity"
})
public class UpdateAppointment {

    protected AppointmentEntity appointmentEntity;

    /**
     * Gets the value of the appointmentEntity property.
     * 
     * @return
     *     possible object is
     *     {@link AppointmentEntity }
     *     
     */
    public AppointmentEntity getAppointmentEntity() {
        return appointmentEntity;
    }

    /**
     * Sets the value of the appointmentEntity property.
     * 
     * @param value
     *     allowed object is
     *     {@link AppointmentEntity }
     *     
     */
    public void setAppointmentEntity(AppointmentEntity value) {
        this.appointmentEntity = value;
    }

}
