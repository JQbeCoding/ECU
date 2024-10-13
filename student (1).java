public class Student implements Comparable<Student> {
    private String id;
    private String name;
    private String standing;
    private String major;
    
    public Student(){
        this.id = null;
        this.name = null;
        this.standing = null;
        this.major = null;
    }
    
    public Student(String id, String name, String standing, String major){
        this.id = id;
        this.name = name;
        this.standing = standing;
        this.major = major;
    }
    
    public String getId(){
        return id;
    }
    
    public void setId(String newId){
        this.id = newId;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String newName){
        this.name = newName;
    }
    
    public String getStanding(){
        return standing;
    }
    
    public void setStanding(String newStanding){
        this.standing = newStanding;
    }
    
        public String getMajor(){
        return major;
    }
    
    public void setMajor(String newMajor){
        this.major = newMajor;
    }
    
    public String toString(){
        return id + " " + name + " " + standing + " " + major + " ";
    }
    
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        
        if (obj instanceof Student) {
            Student other = (Student) obj;
            return (id != null ? id.equals(other.id) : other.id == null);
        }
        
        return false;
    }
    
    public int hashCode() {
            return id != null ? id.hashCode() : 0; 
        }
    
    public int compareTo(Student other) {
        if (this.id == null && other.id == null) {
            return 0; 
        }
        if (this.id == null) {
            return -1; 
        }
        if (other.id == null) {
            return 1; 
        }
        return this.id.compareTo(other.id); 
    }
}
