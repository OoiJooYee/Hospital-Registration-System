public class Administrator extends Staff {
    private String dataAccessPassword = "HRS2023";

    public Administrator(String n, String ic, String d, String g, Address add, String p, String e, String id, double s){
        super(n, ic, d, g, add, p, e, id, s);
    }

    public boolean checkPassword(String password){
        if(dataAccessPassword.equals(password))
            return true;
        else
            return false;
    }

    public void displayInfo(){
        System.out.println("ADMINISTRATOR INFORMATION:");
        System.out.printf("%-12s : %s\n", "Name", name);
        System.out.printf("%-12s : %s\n", "IC No.", icNo);
        System.out.printf("%-12s : %s\n", "DOB", DOB);
        System.out.printf("%-12s : %s\n", "Gender", gender);
        System.out.printf("%-12s : %s\n", "Address", address.toString());
        System.out.printf("%-12s : %s\n", "Phone No.", phone);
        System.out.printf("%-12s : %s\n", "Email", email);
        System.out.printf("%-12s : %s\n", "Staff ID", staffID);
        System.out.printf("%-12s : RM %.2f\n", "Salary", salary);
    }
}