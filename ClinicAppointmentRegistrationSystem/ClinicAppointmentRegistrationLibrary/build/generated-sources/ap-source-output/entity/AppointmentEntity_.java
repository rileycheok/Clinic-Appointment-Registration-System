package entity;

import entity.DoctorEntity;
import entity.PatientEntity;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-04-04T10:54:22")
@StaticMetamodel(AppointmentEntity.class)
public class AppointmentEntity_ { 

    public static volatile SingularAttribute<AppointmentEntity, DoctorEntity> doctor;
    public static volatile SingularAttribute<AppointmentEntity, String> date;
    public static volatile SingularAttribute<AppointmentEntity, Date> datetime;
    public static volatile SingularAttribute<AppointmentEntity, Long> appointmentId;
    public static volatile SingularAttribute<AppointmentEntity, PatientEntity> patient;
    public static volatile SingularAttribute<AppointmentEntity, String> time;

}