
package ejb.session.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for updatePatient complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="updatePatient"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="patientEntity" type="{http://ws.session.ejb/}patientEntity" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "updatePatient", propOrder = {
    "patientEntity"
})
public class UpdatePatient {

    protected PatientEntity patientEntity;

    /**
     * Gets the value of the patientEntity property.
     * 
     * @return
     *     possible object is
     *     {@link PatientEntity }
     *     
     */
    public PatientEntity getPatientEntity() {
        return patientEntity;
    }

    /**
     * Sets the value of the patientEntity property.
     * 
     * @param value
     *     allowed object is
     *     {@link PatientEntity }
     *     
     */
    public void setPatientEntity(PatientEntity value) {
        this.patientEntity = value;
    }

}
