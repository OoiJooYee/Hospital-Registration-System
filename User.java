abstract class User {
    protected String name;
    protected String icNo;
    protected String DOB;
    protected String gender;
    protected Address address;
    protected String phone;
    protected String email;

    public User(String n, String ic, String d, String g, Address add, String p, String e){
        name = n;
        icNo = ic;
        DOB = d;
        gender = g;
        address = add;
        phone = p;
        email = e;
    }

    public void setName(String n){
        name = n;
    }

    public void setIcNo(String ic){
        icNo = ic;
    }

    public void setDOB(String d){
        DOB = d;
    }

    public void setGender(String g){
        gender = g;
    }

    public void setAddress(Address add){
        address = add;
    }

    public void setPhone(String p){
        phone = p;
    }

    public void setEmail(String e){
        email = e;
    }

    public String getName(){
        return name;
    }

    public String getIcNo(){
        return icNo;
    }

    public String getDOB(){
        return DOB;
    }

    public String getGender(){
        return gender;
    }

    public Address getAddress(){
        return address;
    }

    public String getPhone(){
        return phone;
    }

    public String getEmail(){
        return email;
    }

    public abstract void displayInfo();
}