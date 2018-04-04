package entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-04-04T10:54:22")
@StaticMetamodel(ConsultationEntity.class)
public class ConsultationEntity_ { 

    public static volatile SingularAttribute<ConsultationEntity, String> date;
    public static volatile SingularAttribute<ConsultationEntity, Long> patientId;
    public static volatile SingularAttribute<ConsultationEntity, Long> doctorId;
    public static volatile SingularAttribute<ConsultationEntity, Integer> queueNumber;
    public static volatile SingularAttribute<ConsultationEntity, Long> consultationId;

}