/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Shi Yun
 */
@Entity
public class ConsultationEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long consultationId;
    @Column (nullable = false)
    private Integer queueNumber;
    private Long patientId;
    private Long doctorId;
    @Column (nullable = false)
    private String date;

    public ConsultationEntity() {
    }

    
    public Long getId() {
        return consultationId;
    }

    public void setId(Long consultationId) {
        this.consultationId = consultationId;
    }

    public Long getConsultationId() {
        return consultationId;
    }

    public void setConsultationId(Long consultationId) {
        this.consultationId = consultationId;
    }

    public Integer getQueueNumber() {
        return queueNumber;
    }

    public void setQueueNumber(Integer queueNumber) {
        this.queueNumber = queueNumber;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (consultationId != null ? consultationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the consultationId fields are not set
        if (!(object instanceof ConsultationEntity)) {
            return false;
        }
        ConsultationEntity other = (ConsultationEntity) object;
        if ((this.consultationId == null && other.consultationId != null) || (this.consultationId != null && !this.consultationId.equals(other.consultationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ConsultationEntity[ consultationId=" + consultationId + " ]";
    }
    
}
