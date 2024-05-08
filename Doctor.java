import java.util.ArrayList;

public class Doctor extends Staff {
    private String role;
    private Department department;
    private ArrayList<MedicalRecord> records = new ArrayList<MedicalRecord>();

    public Doctor(String n, String ic, String d, String g, Address add, String p, String e, String id, double s, String r, Department dep){
        super(n, ic, d, g, add, p, e, id, s);
        role = r;
        department = dep;
    }

    public void setRole(String r){
        role = r;
    }

    public void setDepartment(Department dep){
        department = dep;
    }

    public String getRole(){
        return role;
    }

    public Department getDepartment(){
        return department;
    }

    public void addMedicalRecord(MedicalRecord med){
        records.add(med);
    }

    public void displayInfo(){
        System.out.println("DOCTOR INFORMATION:");
        System.out.printf("%-12s : %s\n", "Name", name);
        System.out.printf("%-12s : %s\n", "IC No.", icNo);
        System.out.printf("%-12s : %s\n", "DOB", DOB);
        System.out.printf("%-12s : %s\n", "Gender", gender);
        System.out.printf("%-12s : %s\n", "Address", address.toString());
        System.out.printf("%-12s : %s\n", "Phone No.", phone);
        System.out.printf("%-12s : %s\n", "Email", email);
        System.out.printf("%-12s : %s\n", "Staff ID", staffID);
        System.out.printf("%-12s : RM %.2f\n", "Salary", salary);
        System.out.printf("%-12s : %s\n", "Role", role);
        System.out.printf("%-12s : %s\n", "Department", department.getDepartment());
    }
}
