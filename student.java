interface StudentListInterFace{
    /**
    * This method should have a file name as the parameter. The method
    *  loads the data containing all the students from a given file.
    */
    public void loadData();
    /**
     * This method displays the complete information of all the students
     * on the roster. It does not have any parameter and returns nothing.
     */ 
    public void displayRoster();
    /*
    This method should have an id (of String type) as the
    parameter. It should return the Student object if found, or null if not found.
    */
    public void searchForStudent();
    /*
    */
    public void addStudent();
    public void removeStudent();
    public void getStudentsByMajor();
    public void sort();
    public void save();
}