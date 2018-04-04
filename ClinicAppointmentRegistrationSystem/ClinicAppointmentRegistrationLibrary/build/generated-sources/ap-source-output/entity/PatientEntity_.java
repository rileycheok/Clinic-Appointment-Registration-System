package entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-04-04T10:54:22")
@StaticMetamodel(PatientEntity.class)
public class PatientEntity_ { 

    public static volatile SingularAttribute<PatientEntity, String> firstName;
    public static volatile SingularAttribute<PatientEntity, String> lastName;
    public static volatile SingularAttribute<PatientEntity, String> address;
    public static volatile SingularAttribute<PatientEntity, String> gender;
    public static volatile SingularAttribute<PatientEntity, Long> patientId;
    public static volatile SingularAttribute<PatientEntity, String> identityNumber;
    public static volatile SingularAttribute<PatientEntity, String> phone;
    public static volatile SingularAttribute<PatientEntity, String> securitycode;
    public static volatile SingularAttribute<PatientEntity, Integer> age;

}