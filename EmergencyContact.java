public class EmergencyContact {
    private String emergencyContactName;
    private String emergencyContactRelationship;
    private String emergencyContactPhoneNo;

    public EmergencyContact(String name, String relationship, String phone){
        emergencyContactName = name;
        emergencyContactRelationship = relationship;
        emergencyContactPhoneNo = phone;
    }

    public void setEmergencyContactName(String name){
        emergencyContactName = name;
    }

    public void setEmergencyContactRelationship(String relationship){
        emergencyContactRelationship = relationship;
    }

    public void setEmergencyContactPhoneNo(String phone){
        emergencyContactPhoneNo = phone;
    }

    public String getEmergencyContactName(){
        return emergencyContactName;
    }

    public String getEmergencyContactRelationship(){
        return emergencyContactRelationship;
    }

    public String getEmergencyContactPhoneNo(){
        return emergencyContactPhoneNo;
    }

    public String toString(){
        return this.getEmergencyContactName() + " (" + this.getEmergencyContactRelationship() + ") [" + this.getEmergencyContactPhoneNo() + "]";
    }
}
