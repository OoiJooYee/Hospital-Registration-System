public class Department {
    private String departmentName;
    private String departmentDescription;

    public Department(String name, String description){
        departmentName = name;
        departmentDescription = description;
    }

    public void setDepartmentName(String name){
        departmentName = name;
    }

    public void setDepartmentDescription(String description){
        departmentDescription = description;
    }

    public String getDepartmentName(){
        return departmentName;
    }

    public String getDepartmentDescription(){
        return departmentDescription;
    }

    public String getDepartment(){
        return departmentName + " (" + departmentDescription + ")";
    }

    public void printInfo(){
        System.out.println("DEPARTMENT:");
        System.out.printf("%-13s : %s\n", "Name", this.getDepartmentName());
        System.out.printf("%-13s : %s\n", "Description", this.getDepartmentDescription());
    }
}
