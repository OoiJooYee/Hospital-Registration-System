import java.util.Date;

public class MedicalRecord {
    private static int noOfMedicalRecord = 0;
    private int medicalRecordID;
    private Date recordDateTime;
    private String problem;
    private Patient patient;
    private Doctor doctor;

    public MedicalRecord(String prob, Patient p, Doctor d){
        noOfMedicalRecord += 1;
        medicalRecordID = noOfMedicalRecord;
        recordDateTime = new Date();
        problem = prob;
        patient = p;
        doctor = d;
        p.addMedicalRecord(this);
        d.addMedicalRecord(this);
    }

    public void setRecordDateTime(Date datetime){
        recordDateTime = datetime;
    }

    public void setProblem(String prob){
        problem = prob;
    }

    public void setPatient(Patient p){
        patient = p;
    }

    public void setDoctor(Doctor d){
        doctor = d;
    }

    public int getMedicalRecordID(){
        return medicalRecordID;
    }

    public String getRecordDateTime(){
        return recordDateTime.toString();
    }

    public String getProblem(){
        return problem;
    }

    public Patient getPatient(){
        return patient;
    }

    public void displayMedicalRecord(){
        System.out.println("MEDICAL RECORD:");
        System.out.printf("%-15s : %s\n", "Patient Name", patient.getName());
        System.out.printf("%-15s : %s\n", "Patient IC", patient.getIcNo());
        System.out.printf("%-15s : %s\n", "Doctor Name", doctor.getName());
        System.out.printf("%-19s : %s\n", "Medical Record ID", this.getMedicalRecordID());
        System.out.printf("%-19s : %s\n", "Record Date Time", this.getRecordDateTime());
        System.out.printf("%-19s : %s\n", "Problem", this.getProblem());
    }
}
