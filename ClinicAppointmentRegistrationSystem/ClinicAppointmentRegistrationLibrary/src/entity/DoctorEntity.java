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
public class DoctorEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long doctorId;
    @Column (nullable = false)
    private String firstName;
    @Column (nullable = false)
    private String lastName;
    @Column (nullable = false)
    private String registration;
    @Column (nullable = false)
    private String qualifications;
    
    //@OneToMany(mappedBy = "doctor")
    //private List<AppointmentEntity> doctorAppointments;

    public DoctorEntity() {
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

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getQualifications() {
        return qualifications;
    }

    public void setQualifications(String qualifications) {
        this.qualifications = qualifications;
    }

    
    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    /*
    public List<AppointmentEntity> getDoctorAppointments() {
        return doctorAppointments;
    }

    public void setDoctorAppointments(List<AppointmentEntity> doctorAppointments) {
        this.doctorAppointments = doctorAppointments;
    }
    */

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (doctorId != null ? doctorId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the doctorId fields are not set
        if (!(object instanceof DoctorEntity)) {
            return false;
        }
        DoctorEntity other = (DoctorEntity) object;
        if ((this.doctorId == null && other.doctorId != null) || (this.doctorId != null && !this.doctorId.equals(other.doctorId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.DoctorEntity[ doctorId=" + doctorId + " ]";
    }
    
    /*
    public void addAppointment(AppointmentEntity appointment) {
        if(appointment != null && !this.getDoctorAppointments().contains(appointment))
        {
            this.getDoctorAppointments().add(appointment);
        }
    }
    
    public void deleteAppointment(AppointmentEntity appointment) {
        if(appointment != null && this.getDoctorAppointments().contains(appointment))
        {
            for (AppointmentEntity appt : this.getDoctorAppointments()) 
            {
                if (appt.getAppointmentId().equals(appointment.getAppointmentId()))
                {
                    this.getDoctorAppointments().remove(appt);
                    return;    
                }
            }
        }
    }
    */
}
