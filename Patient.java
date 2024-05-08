import java.util.ArrayList;

public class Patient extends User {
    private Guardian guardian;
    private EmergencyContact emergencyContact;
    private String occupation;
    private ArrayList<MedicalRecord> records = new ArrayList<MedicalRecord>();
    private ArrayList<Appointment> appointments = new ArrayList<Appointment>();

    public Patient(String n, String ic, String d, String g, Address add, String p, String e, Guardian guard, EmergencyContact emergC, String occ){
        super(n, ic, d, g, add, p, e);
        guardian = guard;
        emergencyContact = emergC;
        occupation = occ;
    }

    public void setGuardian(Guardian guard){
        guardian = guard;
    }

    public void setEmergencyContact(EmergencyContact emergC){
        emergencyContact = emergC;
    }

    public void setOccupation(String occ){
        occupation = occ;
    }

    public Guardian getGuardian(){
        return guardian;
    }

    public EmergencyContact getEmergencyContact(){
        return emergencyContact;
    }

    public String getOccupation(){
        return occupation;
    }

    public ArrayList<Appointment> getAppointment(){
        return appointments;
    }

    public void addMedicalRecord(MedicalRecord med){
        records.add(med);
    }

    public void addAppointment(Appointment a){
        appointments.add(a);
    }

    public void displayAppointmentInfo(){
        if (appointments.size() == 0){
            System.out.println("\nNo appointments made.");
        }
        else{
            System.out.printf("%-25s%-15s%-15s%-15s%-15s%-15s%-30s%-10s\n", "Patient Name", "Patient IC", "Patient Phone", "Appointment ID", "Date", "Time", "Service", "Status");
            System.out.printf("%-25s%-15s%-15s%-15s%-15s%-15s%-30s%-10s\n", "------------", "----------", "-------------", "--------------", "----", "----", "-------", "------");
            for(Appointment a:appointments){
                System.out.println(a);
            }
        }
    }
    
    public void displayInfo(){
        System.out.println("PATIENT INFORMATION:");
        System.out.printf("%-12s : %s\n", "Name", name);
        System.out.printf("%-12s : %s\n", "IC No.", icNo);
        System.out.printf("%-12s : %s\n", "DOB", DOB);
        System.out.printf("%-12s : %s\n", "Gender", gender);
        System.out.printf("%-12s : %s\n", "Address", address.toString());
        System.out.printf("%-12s : %s\n", "Phone No.", phone);
        System.out.printf("%-12s : %s\n", "Email", email);
        System.out.printf("%-12s : %s\n", "Occupation", this.getOccupation());
        if(guardian!=null)
        System.out.printf("%-19s : %s\n", "Guardian", guardian.toString());
        if(emergencyContact!=null)
        System.out.printf("%-19s : %s\n", "Emergency Contact", emergencyContact.toString());
    }
}