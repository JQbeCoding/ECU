package assg6_franklinj23;

import java.util.*;
import java.io.*;
public class StudentMIS {

	public static void main(String[] args) {
	
		StudentList students = new StudentList();
		Scanner kbd = new Scanner(System.in);
		students.loadData("assg6_data.txt");
		
		System.out.println("Welcome to the Student Database");
		
		while(true) {
			displayMenu();
			int choice = kbd.nextInt();
			
			if(choice == 8) {
				System.out.println("Have a good day");
				System.exit(0);
				kbd.close();
			}
			switch(choice) {
			
			case 1:
				students.displayRoster();
				System.out.println("Click Enter to continue");
				kbd.nextLine();
				String cont = kbd.nextLine();
				if(cont.isEmpty()) {
					break;
				}
				break;
			case 2:
				kbd.nextLine();
				System.out.println("Enter the id you want to search for: ");
				String id = kbd.nextLine();
				students.searchForStudent(id);
				System.out.println("Click Enter to continue");
				cont = kbd.nextLine();
				if(cont.isEmpty()) {
					break;
				}
				
				break;
			case 3:
				kbd.nextLine();
				
			    System.out.println("Enter Student ID: ");
			    String stuId = kbd.nextLine();
			    
			    System.out.println("Enter Student Name: ");
			    String name = kbd.nextLine();
			    
			    System.out.println("Enter Student Standing: ");
			    String standing = kbd.nextLine();
			    
			    System.out.println("Enter Student Major: ");
			    String major = kbd.nextLine();
			    
			    students.addStudent(stuId, name, standing, major);
				System.out.println("Click Enter to continue");
				cont = kbd.nextLine();
				if(cont.isEmpty()) {
					break;
				}

				break;
			}

		}

		
    }
	
	public static void displayMenu() {
		System.out.println("Chose an option");
		System.out.println("[1] Display the roster");
		System.out.println("[2] Search for a student by id");
		System.out.println("[3] Add a new Student");
		System.out.println("[4] Remove a student");
		System.out.println("[5] Search for students by major");
		System.out.println("[6] Sort and save to file");
		System.out.println("[7] Save to file");
		System.out.println("[8] Exit");
	}
}
