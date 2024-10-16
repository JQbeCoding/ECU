package assg6_franklinj23;

import java.util.*;
import java.io.*;
public class StudentList implements StudentListInterface {

	private ArrayList<Student> students = new ArrayList<Student>();
	private boolean dataChanged = false;

	/**
	 * Loads the data given from the text file into the program 
	 * by storing each student in a Student object array list. If there
	 * are no students then the file returns an error message.
	 * @param fileName equals the name of the file given to the program
	 * @return the list of students.
	 */
	public List<Student> loadData(String fileName){
        String line;

		try(BufferedReader br = new BufferedReader(new FileReader(fileName))){
        while((line = br.readLine()) != null) {
			String [] parameters = line.split(",");
			
			//Since this is stored in an String array we must 
			//parse.
        	String id = (parameters[0]);
        	String name = parameters[1];
        	String standing = parameters[2];
        	String major = parameters[3];
        	
        	students.add(new Student(id,name,standing,major));
        	
		}
	}
        catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
		
		return students;
	}
	
	
	/**
	 * Displays the list of students to the program
	 */
	public void displayRoster() {
		for(Student student: students) {
			System.out.println(student);
		}
	}
	
	/**
	 * Searches for student id. If id matches it displays that student.
	 * Otherwise it returns a null character.
	 * @param id equals the id the user enters
	 * @return Either the student or null.
	 */
	public Student searchForStudent(String id){
		
		for(Student student: students) {
			if(id.equals(student.getId())) {
				System.out.println("Student Found:");
				System.out.println(student);
				return student;
			}
		}
		System.out.println("Student Not Found");
		return null;
	}
	
    public boolean addStudent(String id, String name, String standing, String major) {

    	for(Student student: students) {
    	if(id.equals(student.getId())) {
    		System.out.println("Id Already exist");
    		return false;
    	}
        Student newStudent = new Student(id, name, standing, major);
        students.add(newStudent);
        System.out.println("Student Added");
        dataChanged = true;
    	return true;
    	}
    	return false;
    }
    
    
    public boolean removeStudent(String id) {
    
    	for(Student student: students) {
    	if(id.equals(student.getId())) {
        	students.remove(student);
        	System.out.println("Student Removed");
        	dataChanged = true;
    		return true;
    	}
    }
    	System.out.println("Student Not found");
    	return false;
    }
    
    public ArrayList<Student> getStudentsByMajor(String major){
    	ArrayList<Student> sameMajor = new ArrayList<Student>();
    	for(Student student: students) {
    		if(major.equals(student.getMajor())) {
    			sameMajor.add(student);
    		}
    	}
    	
    	return sameMajor;
    }
    
    public void sort() {
    	ArrayList<Student> studentList = new ArrayList<Student>();
    	Collections.sort(studentList);
    	dataChanged = true;
    }
    
    public void save(){
        if (!dataChanged) {
            System.out.println("No changes to save.");
            return;
        }
    	
    	
    }
    
	    
}
	
	



