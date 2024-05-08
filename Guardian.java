public class Guardian {
    private String guardianName;
    private String guardianRelationship;

    public Guardian(String name, String relationship){
        guardianName = name;
        guardianRelationship = relationship;
    }

    public void setGuardianName(String name){
        guardianName = name;
    }

    public void setGuardianRelationship(String relationship){
        guardianRelationship = relationship;
    }

    public String getGuardianName(){
        return guardianName;
    }

    public String getGuardianRelationship(){
        return guardianRelationship; 
    }

    public String toString(){
        return this.getGuardianName() + " (" + this.getGuardianRelationship() + ")";
    }
}
