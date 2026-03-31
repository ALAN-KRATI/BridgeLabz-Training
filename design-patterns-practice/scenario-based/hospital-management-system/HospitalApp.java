public class HospitalApp {
    public static void main(String[] args){
        HospitalManager instance = HospitalManager.getInstance();
        
        User patient = UserFactory.createUser("patient", "Alice");
        User doctor = UserFactory.createUser("doctor", "Dr. Bob");
        User admin = UserFactory.createUser("admin", "Alan");

        patient.showRole();
        doctor.showRole();
        admin.showRole();

        instance.addPatient(patient);
    
        MedicalReport mr = new MedicalReport.MedicalReportBuilder("Cancer")
                                        .testResults("Stage 4")
                                        .prescription("Chemotherapy")
                                        .doctorsRemark("Regular checkups")
                                        .build();

        instance.addAppointment(mr);
    }
}
