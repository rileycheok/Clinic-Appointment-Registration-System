# Clinic Appointment Registration System

1. Introduction
The Clinic Appointment Registration System (“CARS”) allows a GP clinic to operate a frontline appointment and registration services. There will be three interfaces consisting of Clinic Admin Terminal, Self-Service Kiosk Terminal and AMSClient(Web Services) for external vendors. 
2. Entity Classes
2.1 AppointmentEntity
The Appointment Entity is used to represent the appointments created by the clinic staff for each appointment allocated to one patient and one doctor. It has the following relationships with the other entities as listed below:
1.	Many appointments can belong to 1 Patient  (Many To One Relationship(unidirectional))
2.	Many appointments can belong to 1 Doctor   (Many To One Relationship(unidirectional))

 
<<entity>>
AppointmentEntity
-               appointmentId : Long
-               patient: PatientEntity
-               doctor: DoctorEntity
-               date: String
-               time: String
-               datetime : Date 

+            AppointmentEntity()
+            getAppointmentId() : Long
+            setAppointmentId(Long appointmentId) : void
+            getDatetime() : Date
+            setDatetime(Date datetime) : void
+            getDoctor() : DoctorEntity
+            setDoctor(DoctorEntity doctor) : void
+            getPatient() : PatientEntity
+            setPatient(PatientEntity patient) : void
+            getDate() : String
+            setDate(String date) : void
+            getTime() : String
+            setTime(String time) : void

2.2 ConsultationEntity
The Consultation Entity is used to represent the consultations created each day by the clinic staff or self-registered patients. Similar to appointments, each Consultation is allocated to one patient and one doctor, however the ConsultationEntity contains only the patientId and doctorId instead of the entity. ConsultationEntities is refreshed every new day in the clinic, so as to reset the queueNumber.
 
<<entity>>
ConsultationEntity
-               consultationId : Long
-               queueNumber: Integer
-               patientId: Long
-               doctorId: Long
-               date: String

+            ConsultationEntity()
+            getConsultationId() : Long
+            setConsultationId(Long ConsultationId) : void
+            getQueueNumber() : Integer
+            setQueueNumber(Integer queueNumber) : void
+            getDoctorId() : Long
+            setDoctorId(Long doctorId) : void
+            getPatientId() : Long
+            setPatientId(Long patientId) : void
+            getDate() : String
+            setDate(String date) : void

2.3 PatientEntity
The patient entity has the following relationships with the other entities as listed below:
1.	A patient can make many Appointments (One To Many Relationship - owned by Appt unidirectional)
2.	A patient can have many Consultations (not explicitly coded in, but consultation entity references patientID)

 
<<entity>>
PatientEntity
-               patientId : Long
-               securityCode : String
-               firstName : String
-               lastName : String
-               gender : String
-               age : Integer
-               phone : String
-               identityNumber : String
-               address : String


+            PatientEntity()
+            getPatientId() : Long
+            setPatientId(Long PatientId) : void
+            getFirstName() : String
+            setFirstName(String firstName) : void
+            setLastName() : String
+            getLastName(String lastName) : void
+            getIdentityNumber() : String
+            setIdentityNumber(String identityNumber) : void
+            getGender() : String
+            setGender(String gender) : void
+            getAge() : String
+            setAge(Integer age) : void
+            getPhone() : String
+            setPhone(String phone) : void
+            getAddress() : String
+            setAddress(String address) : void



2.4 StaffEntity
This is a staff entity for staff members such as counter staff in the clinic.
 

<<entity>>
StaffEntity
-               staffId : Long
-               username : String
-               firstName : String
-               lastName : String
-               password : String



+            StaffEntity()
+            getStaffId() : Long
+            setStaffId(Long StaffId) : void
+            getFirstName() : String
+            setFirstName(String firstName) : void
+            getLastName() : String
+            setLastName(String lastName) : void
+            getPassword() : String
+            setPassword(String password) : void
+            getUsername() : String
+            setUsername(String username) : void

2.5 DoctorEntity
This is a doctor entity for doctors.








 
<<entity>>
DoctorEntity
-               doctorId : Long
-               registration : String
-               firstName : String
-               lastName : String
-               qualifications : String



+            DoctorEntity()
+            getDoctorId() : Long
+            setDoctorId(Long doctorId) : void
+            getFirstName() : String
+            setFirstName(String firstName) : void
+            setLastName() : String
+            getLastName(String lastName) : void
+            getRegistration() : String
+            setRegistration(String registration) : void
+            getQualifications() : String
+            setQualifications(String qualifications) : void

3.1 Controllers
Our system has the following controllers and listed the functions of each controller.
Stateful Sessions
1.	AppointmentController
This controller has a number of methods for retrievals. To delete an appointment, the system sets both the doctor and patient Id to null. Retrievals include retrieval through Date and Time, Date, Appointment Id, Doctor Id, Doctor and Date, PatientEntity, and DoctorEntity.

2.	RegistrationController
This controller allows for the retrieval of the list of doctors which are currently registered in the system. It also allows for the new registration of a patient. 
	

Stateless Sessions
1.	ConsultationEntityController
Handles any business methods that involves the consultation entity. Besides creating, updating, retrieving a list of consultations and deleting one consultation entity. More notable features include is retrieving consultation by Id. Also included in the ‘create new consultation’ method is the refreshing of consultation entities every new day.

2.	DoctorEntityController
Handles any business methods that involves the Doctor Entity. Besides creating, updating, retrieving a list of doctors and deleting one doctor. More notable features include is retrieving doctor by Id.

3.	PatientEntityController
Handles any business methods that involves the Patient Entity. Besides creating, updating, retrieving a list of patients and deleting one patient. More notable features include is checking if a patient exist through their identity number, enabling a clear business method involving patient login.

4.	StaffEntityController
Handles any business methods that involves the staff Entity. Besides creating, updating, retrieving a list of staff and deleting one doctor. More notable features include is retrieving staff by username and retrieving staff by staff Id.
3.2 Assumptions
The following are assumptions as listed:
1.	The list of consultations within the database is cleared on a new day. The system checks if the first date in the consultations database matches with the current date and time, if not, the database is cleared of consultations. This checking is done in the data initialisation bean and in the ‘create new consultation’ method in consultation entity controller.
2.	When patients are allowed to register for walk-in consultations, they must register 3 hours before the clinic closing time at 5pm. 
3.	Appointments can only be added from the next day 09:00 onwards, they cannot be added on the day itself. 
4.	In order to register a consultation through a booked appointment, the system will only display appointments on the day of registration.
5.	Each doctor in the clinic can only consult one patient in a fixed length of 30 minutes.
6.	In administration module, the identityNumber of PatientEntity, doctorId of DoctorEntity, staffId of StaffEntity will not be updated. 
7.	All staff have the ability to create and edit information within the database.
8.	During data initialisation, the database will be updated with the sample data provided by the clinic. Any changes will be manually coded into the data initialisation bean.
9.	Only Self-Service and Kiosk as well as the Main Terminal client can register a consultation as it is assumed that the AMS client is not near a clinic.

  General notes:
Exceptions for invalid inputs are coded in. For example, if the user enters the date in the wrong format, the program will throw an exception. The program handles all invalid inputs made by user, either exiting application or going back to the page before.


4. CARS Clinic Admin Terminal Client
4.1 Main Page of Admin Panel Client
The staff is required to login and use the client application, as implemented under the MainApp.
4.1.1 Staff Login
To login, the staff is required to provide their username and password as login credentials. Upon logging in successfully, the staff would be directed to the clinic admin application menu. Depending on the intentions of the staff at that point of time, they can access AdministrationModule, AppointmentModule and RegistrationModule respectively. 
 
In the scenario where the staff provided the wrong credentials, the relevant exceptions  (InvalidLoginCredentialsException) would be thrown to prompt the staff of the error. In the view of security, a generic message is displayed rather than specifying the exact reasons.

4.2 Registration Module
There are 3 operations in this module, as implemented under RegistrationModule.

4.2.1 Register New Patient
Patient details are entered accordingly to the prompts. However, if the identityNumber entered already exists in the database, the operation will be stopped, returning to the main page of RegistrationModule. Otherwise, the createNewPatient(PatientEntity patientEntity) in PatientEntityController class will be called to perform this operation, persisting the new PatientEntity into the database.

4.2.2 Register Walk-In Consultation
The list of doctors scheduled to work is displayed, along with their availabilities for the next 3 hours. So for example, if a patient walks in to the clinic at 12:45, the availabilities of the doctors for the next 6 half-hour slots will be displayed. A new ConsultationEntity is created, but before it is persisted into the database, entityManager will check if the consultation entities are created for today. If they were from the previous days, entityManager wipes out all the consultation entities in the database and queueNumber is hence restarted. After this is done, new ConsultationEntity is persisted into database, along with the queueNumber which is the number of ConsultationEntities in the database. A new appointmentEntity is created too, so as to make checking of availabilities of doctors faster.

4.2.3 Register Consultation by Appointment
Patient identityNumber is entered, PatientEntityController retrieves the PatientEntity, then the AppointmentEntityController will retrieve the appointments by the PatientEntity. Appointments will then be displayed, and patient is prompted to enter the appointmentId, which will be checked to ensure that the appointment is for that day. A new ConsultationEntity is created.

4.3 Appointment Module
4.3.1 View Patient Appointments
Patient identityNumber is entered, PatientEntityController retrieves the PatientEntity, then the AppointmentEntityController will retrieve the appointments by the PatientEntity to display.

4.3.2 Add Appointment
The list of doctors scheduled to work is displayed. DoctorId and Date is entered accordingly, and AppointmentEntityController retrieves and displays the availability of the selected doctor for the day. Time and patient identityNumber is entered to create the new AppointmentEntity which is then persisted into the database.

4.3.3 Cancel Appointment
Patient identityNumber is entered, PatientEntityController retrieves the PatientEntity, then the AppointmentEntityController will retrieve the appointments by the PatientEntity to display. AppointmentId is entered, and it will check that the appointmentId belongs to the PatientEntity retrieved before deleting from the database.
4.4 Administration Module
4.4.1 Patient Management
User can add new patient, view patient details, update patient particulars, delete patient and view all patients.  A PatientNotFoundException may be thrown if patient is not found.

4.4.2 Doctor Management
User can add new doctor, view doctor details, update doctor particulars, delete doctor and view all doctors. A DoctorNotFoundException may be thrown if doctor is not found.
.
4.4.3 Staff Management
User can add new staff, view staff details, update staff particulars, delete staff and view all staff. A StaffNotFoundException may be thrown if staff is not found.

5. Self-Service Kiosk
The users are the visitor and patient of the clinic. Visitor should register an account first in order to login. Patient can login with their identityNumber and securityCode directly. This is implemented under the MainApp. 

In the main page, there are 5 operations which can be done by the DoRegisterModule and DoAppointmentsModule.
5.1 DoRegisterModule
5.1.1 Register Walk-In Consultation
The list of doctors scheduled to work is displayed, along with their availabilities for the next 3 hours. So for example, if a patient walks in to the clinic at 12:45, the availabilities of the doctors for the next 6 half-hour slots will be displayed. A new ConsultationEntity is created, but before it is persisted into the database, entityManager will check if the consultation entities are created for today. If they were from the previous days, entityManager wipes out all the consultation entities in the database and queueNumber is hence restarted. After this is done, new ConsultationEntity is persisted into database, along with the queueNumber which is the number of ConsultationEntities in the database. A new appointmentEntity is created too, so as to make checking of availabilities of doctors faster.

5.1.2 Register Consultation by Appointment
Patient identityNumber is entered, PatientEntityController retrieves the PatientEntity, then the AppointmentEntityController will retrieve the appointments by the PatientEntity. Appointments will then be displayed, and patient is prompted to enter the appointmentId, which will be checked to ensure that the appointment is for that day. A new ConsultationEntity is created.
5.2 DoAppointmentsModule
5.2.1 View Appointments
Patient identityNumber is entered, PatientEntityController retrieves the PatientEntity, then the AppointmentEntityController will retrieve the appointments by the PatientEntity to display.

5.2.2 Add Appointment
The list of doctors scheduled to work is displayed. DoctorId and Date is entered accordingly, and AppointmentEntityController retrieves and displays the availability of the selected doctor for the day. Time and patient identityNumber is entered to create the new AppointmentEntity which is then persisted into the database.



5.2.3 Cancel Appointment
Patient identityNumber is entered, PatientEntityController retrieves the PatientEntity, then the AppointmentEntityController will retrieve the appointments by the PatientEntity to display. AppointmentId is entered, and it will check that the appointmentId belongs to the PatientEntity retrieved before deleting from the database.

6. AMS Client
Similar to the Self-Service Kiosk, this is primarily used for patients and new patients. New patients have the option to register themselves with the system before being able to utilise the service provided within the AMS Client. Patients are required to register in order to login and use the client application. Using the AMS client, they are able to add, view and cancel appointments. 
6.1 Main Page of AMS Client
Users would be able to see the following options:
1.	Register
2.	Login
3.	Exit
6.1.1 Register
A new patient is required to register in order to login to utilize the AMS Client. The patient is required to enter their personal details and login credentials, i.e. the attributes in the Patient entity. Regarding their login credentials, their identity number is used to uniquely identified by the patient and is treated as the username to login. Additionally, the security code acts as a password.
 
Input validations are done for the patient’s first and last name, contact number, address, gender, age and address. This is to ensure that the contact information is meaningful in identifying the patient and should any of the details is needed by the staff at the clinic for their day-to-day operations, they are able to easily access it from the system. As the identity number is also used for the purpose as the username of the patient’s entity, it is crucial to ensure that the identity number is unique.
 
In the scenario where the email already exist, a generic exception will be thrown to notify the patient.



6.2.1 Login
To login, the patient is required to provide their identity number and security code as login credentials. Upon logging in successfully, the patient would be directed to the client application menu, that is informally called as AMS Client Main.
 
In the scenario where the patient provided the wrong credentials or has yet to register, the relevant exceptions  (InvalidLoginCredentialsException or PatientNotFoundException) would be thrown to prompt the patient of the error. In the view of security, a generic message is displayed rather than specifying the exact reasons.
6.2  AMS Client Main (PatientMenu)
With the use cases for the AMS Client, the client it has been further categorized into 3 sections with consideration of the associated business rules:
1.	View Appointments
2.	Add Appointment
3.	Cancel Appointment
4.	Logout
 
It is assumed that the patient logs out after use, as the AMS Client is utilised in a public area and it is generally not advisable for patients to reveal personal details to unwanted eyes.
6.2.1 View Appointments
This section allows the patient to view all the appointments created. Patient identityNumber is entered so to verify the patient’s credentials. The PatientEntityController retrieves the PatientEntity, then the AppointmentEntityController will retrieve the appointments by the PatientEntity to display.

6.2.2 Add Appointment
The list of doctors scheduled to work is displayed. DoctorId and Date is entered accordingly, and AppointmentEntityController retrieves and displays the availability of the selected doctor for the day. Time and patient identityNumber is entered to create the new AppointmentEntity which is then persisted into the database.

6.2.2 Cancel Appointment 
Patient identityNumber is entered, PatientEntityController retrieves the PatientEntity, then the AppointmentEntityController will retrieve the appointments by the PatientEntity to display. AppointmentId is entered, and it will check that the appointmentId belongs to the PatientEntity retrieved before deleting from the database.
 

 
