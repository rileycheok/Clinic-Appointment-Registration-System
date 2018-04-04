/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import org.eclipse.persistence.oxm.annotations.XmlInverseReference;

/**
 *
 * @author Shi Yun
 */
@Entity
public class PatientEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patientId;
    @Column (nullable = false)
    private String securitycode;
    @Column (nullable = false)
    private String firstName;
    @Column (nullable = false)
    private String lastName;
    @Column (nullable = false)
    private String gender;
    @Column (nullable = false)
    private Integer age;
    @Column (length = 10, nullable = false, unique = true)
    private String identityNumber;
    @Column (length = 8, nullable = false)
    private String phone;
    @Column (nullable = false)
    private String address;
    
    /*
    @OneToMany(mappedBy = "patient")
    private List<AppointmentEntity> patientAppointments;
    */

    public PatientEntity() {
    }
    
    public String getSecuritycode() {
        return securitycode;
    }

    public void setSecuritycode(String securitycode) {
        this.securitycode = securitycode;
    }
    

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    /*
    public List<AppointmentEntity> getPatientAppointments() {
        return patientAppointments;
    }

    public void setPatientAppointments(List<AppointmentEntity> patientAppointments) {
        this.patientAppointments = patientAppointments;
    }
    
    */
    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    
    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (patientId != null ? patientId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the patientId fields are not set
        if (!(object instanceof PatientEntity)) {
            return false;
        }
        PatientEntity other = (PatientEntity) object;
        if ((this.patientId == null && other.patientId != null) || (this.patientId != null && !this.patientId.equals(other.patientId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.PatientEntity[ patientId=" + patientId + " ]";
    }
    /*
    public void addAppointment(AppointmentEntity appointment) {
        if(appointment != null && !this.getPatientAppointments().contains(appointment))
        {
            this.getPatientAppointments().add(appointment);
        }
    }
    
    public void deleteAppointment(AppointmentEntity appointment) {
        if(appointment != null && this.getPatientAppointments().contains(appointment))
        {
            for (AppointmentEntity appt : this.getPatientAppointments()) 
            {
                if (appt.getAppointmentId().equals(appointment.getAppointmentId()))
                {
                    this.getPatientAppointments().remove(appt);
                    return;    
                }
            }
        }
    }
*/
}
