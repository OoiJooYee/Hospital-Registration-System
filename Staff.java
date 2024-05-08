abstract class Staff extends User {
    protected String staffID;
    protected double salary;

    public Staff(String n, String ic, String d, String g, Address add, String p, String e, String id, double s){
        super(n, ic, d, g, add, p, e);
        staffID = id;
        salary = s;
    }

    public void setStaffID(String id){
        staffID = id;
    }

    public void setSalary(double s){
        salary = s;
    }

    public String getStaffID(){
        return staffID;
    }

    public double getSalary(){
        return salary;
    }

    public abstract void displayInfo();
}