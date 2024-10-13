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
    This method is used to add a new Student. It should have four
    parameters that represent the id, name, standing, and major. If the id is already in
    the student roster, then a message should be printed informing the user that the
    student already exists. This method returns a boolean value. If the student is
    added, it returns true; otherwise it returns false.
    */
    public void addStudent();
    /*
    This method should have an id (of String type) as the parameter.
    It should remove the Student from the roster if the id is found. Otherwise it should
    print a message. This method returns a boolean value. If the student is removed, it
    returns true; otherwise it returns false.
    */
    public void removeStudent();
    /*
    This method should have a major as the parameter. It
    should return an ArrayList object with all the students with the given major. If
    there is no student with the given major, the size of the ArrayList will be zero.
    */
    public void getStudentsByMajor();
    /*
    This method has no parameter and returns nothing. It should sort all the
    students by their id.
    */
    public void sort();
    /*
    This method has no parameter. It should write the student roster back to the
    file if the data has been changed (the same file is used for both reading and
    writing).
    */
    public void save();
}
