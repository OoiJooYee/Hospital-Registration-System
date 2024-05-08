import java.util.Date;

public class RegisterQueue {
    public static int noOfQueue = 0;
    public static int diagnosedQueue = 0;
    private int queueNo;
    private String service;
    private Date queueDateTime;
    private Patient patient;

    public RegisterQueue(Patient p, String ser){
        patient = p;
        noOfQueue += 1;
        queueNo = noOfQueue;
        service = ser;
        queueDateTime = new Date();
    }

    public void setService(String ser){
        service = ser;
    }

    public void setPatient(Patient p){
        patient = p;
    }

    public int getQueueNo(){
        return queueNo;
    }

    public int getCurrentWaitingInQueue(){
        int num = queueNo - diagnosedQueue - 1;
        if(num<0)
            num = 0;
        return num;
    }

    public String getService(){
        return service;
    }

    public String getDateTime(){
        return queueDateTime.toString();
    }

    public Patient getPatient(){
        return patient;
    }

    public void displayRegisterQueueInfo(){
        System.out.println("REGISTER QUEUE INFORMATION:");
        System.out.printf("%-15s : %s\n", "Patient Name", patient.getName());
        System.out.printf("%-15s : %s\n", "Patient IC", patient.getIcNo());
        System.out.printf("%-15s : %s\n", "Patient Phone", patient.getPhone());
        System.out.printf("%-18s : %d\n", "Queue No.", this.getQueueNo());
        System.out.printf("%-18s : %d\n", "Waiting In Queue", this.getCurrentWaitingInQueue());
        System.out.printf("%-18s : %s\n", "Register Time", this.getDateTime());
        System.out.printf("%-18s : %s\n", "Diagnosis", this.getService());
    }
}