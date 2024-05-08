public class Appointment {
    public static int noOfAppointment = 0;
    private int appointmentID;
    private String date;
    private String time;
    private String service;
    private boolean appointmentStatus;
    private Patient patient;

    public Appointment(Patient p, String d, String t, String ser){
        patient = p;
        noOfAppointment += 1;
        appointmentID = noOfAppointment;
        date = d;
        time = t;
        service = ser;
        appointmentStatus = false;
        p.addAppointment(this);
    }

    public void setDate(String d){
        date = d;
    }

    public void setTime(String t){
        time = t;
    }

    public void setService(String ser){
        service = ser;
    }

    public void setAppointmentStatus(boolean status){
        appointmentStatus = status;
    }

    public void setPatient(Patient p){
        patient = p;
    }

    public int getAppointmentID(){
        return appointmentID;
    }

    public String getDate(){
        return date;
    }

    public String getTime(){
        return time;
    }

    public String getService(){
        return service;
    }

    public boolean getAppointmentStatus(){
        return appointmentStatus;
    }

    public String getStatus(){
        if (appointmentStatus == true){
            return "Appointment Attended";
        }
        else{
            return "Appointment Made";
        }
    }

    public String toString(){
        return String.format("%-25s%-15s%-15s%-15s%-15s%-15s%-30s%-10s", patient.getName(), patient.getIcNo(), patient.getPhone(), this.appointmentID, this.getDate(), this.getTime(), this.getService(), this.getStatus());
    }

    public void displayAppointmentInfo(){
        System.out.println("APPOINTMENT INFORMATION:");
        System.out.printf("%-15s : %s\n", "Patient Name", patient.getName());
        System.out.printf("%-15s : %s\n", "Patient IC", patient.getIcNo());
        System.out.printf("%-15s : %s\n", "Patient Phone", patient.getPhone());
        System.out.printf("%-15s : %d\n", "Appoinment ID", this.getAppointmentID());
        System.out.printf("%-15s : %s\n", "Date", this.getDate());
        System.out.printf("%-15s : %s\n", "Time", this.getTime());
        System.out.printf("%-15s : %s\n", "Diagnosis", this.getService());
        System.out.printf("%-15s : %s\n", "Status", this.getStatus());
    }
}