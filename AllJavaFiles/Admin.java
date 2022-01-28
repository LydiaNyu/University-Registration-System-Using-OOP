package homework1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Admin extends User implements AdminInter , java.io.Serializable {
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	//ArrayList to store All Admin objects
	public static ArrayList<Admin> AdminList = new ArrayList<Admin>();
	
	
	//constructor
	public Admin(String username, String password, String firstName, String lastName) {
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;	
		AdminList.add(this);
	}
	//Default constructor
	public Admin() {
	
	}
	//encapsulation
	public String getUsername() {
		return this.username;
	}
	public String getPassword() {
		return this.password;
	}
	public String getFirstName() {
		return this.firstName;
	}
	public String getLastName() {
		return this.lastName;
	}

	public void setUsername(String nameuser) {
		this.username = nameuser;
	}
	public void setPassword(String wordpass) {
		this.password = wordpass;
	}
	public void setFirstName(String namefirst) {
		this.firstName = namefirst;
	}
	public void setLastName(String namelast) {
		this.lastName = namelast;
	}
	
	
	
	// method to delete a course
	public void deleCourse(){
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter a course ID you would like to delete:");
		String CourseId = input.next();
		System.out.println("Please enter a course section number you would like to delete: ");
		String SecNum = input.next();
		Course f = Course.searchCourse(CourseId, SecNum);
		if(f.getCouName() != (null)) {
		for(int i = 0; i < Course.CSCourses.size(); i++) {
			if(Course.CSCourses.get(i)== f){
				Course.CSCourses.remove(i);
				System.out.println("Course sucessfully deleted");
			}
		}
		}
		else {
			System.out.println("Course could not be found");
		}
		
	}
	
	//method to edit a Course
	public void editCourse() {
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter a course ID you would like to edit:");
		String CourseId = input.next();
		System.out.println("Please enter a course section number you would like to edit:");
		String SecNum = input.next();
		Course f = Course.searchCourse(CourseId, SecNum);
		if(f.getCouName() != (null)) {
	    System.out.println("Please enter which part of the course would you like to edit:");
	    System.out.println("enter 1 if you want to edit the maximum number of students");
	    System.out.println("enter 2 if you want to edit the course instructor");
	    System.out.println("enter 3 if you want to edit the course section number");
	    System.out.println("enter 4 if you want to edit the course location");
	    int choice = input.nextInt();
	    if(choice == 1) {
	    	System.out.println("Please enter the new maximum number of students");
	    	int maxNum = input.nextInt();
	    	f.setmaxNumStu(maxNum);
	    	System.out.println("edit completed");
	    }
	    if(choice == 2) {
	    	System.out.println("Please enter the new course instructor");
	    	String couIns = input.next();
	    	f.setcouInstru(couIns);
	    	System.out.println("edit completed");
	    }
	    if(choice == 3) {
	    	System.out.println("Please enter the new course section number");
	    	String secNum = input.next();
	    	f.setSecNum(secNum);
	    	System.out.println("edit completed");
	    }
	    if(choice == 4) {
	    	System.out.println("Please enter the new course location");
	    	String newLoc = input.next();
	    	f.setcouLoc(newLoc);
	    	System.out.println("edit completed");
	    }
		}
		else {
			System.out.println("Course could not be found");
		}
	}
	
	//method to create a Course
	public void createCourse() {
		Scanner input = new Scanner(System.in);
		System.out.println("please write down the new Course name");
		String newName = input.next();
		System.out.println("please write down the new Course id");
		String newId = input.next();
		System.out.println("please write down the maximum number of student of this new Course ");
		int maxStu = input.nextInt();
		System.out.println("please write down the name of the course Instructor");
		String couInsName = input.next();
		System.out.println("please write down the new Course Section Number");
		String newSecNum = input.next();
		System.out.println("please write down the new Course Location");
		String newLoc = input.next();
		
		Course newCourse = new Course(newName,newId,maxStu,0,couInsName,newSecNum,newLoc);
		Course.CSCourses.add(newCourse);
		System.out.println("new Course successfully created");
		
	}
	
	//method to view all Courses that are full
	 public void viewFullCourses() {
		 int count = 1;
		 for(int i = 0; i< Course.CSCourses.size(); i++) {
			 if(Course.CSCourses.get(i).getnameOfStu().size()==Course.CSCourses.get(i).getMaxNumStu()) {
				    System.out.println(count+":");
					System.out.println(Course.CSCourses.get(i).disInfor());
					count++;
			 }
		 }
	 }
	 
	 //method to display information for a specific course
	 public void displaySpecCou() {
		 Scanner input = new Scanner(System.in);
		 System.out.println("Please enter the course ID of the course you would like to display:");
			String CourseId = input.next();
			System.out.println("Please enter a course section number of the course you would like to display: ");
			String SecNum = input.next();
			Course f = Course.searchCourse(CourseId, SecNum);
			if(f.getCouName() != (null))
			{System.out.println(f.disInfor());}
			else
			{System.out.println("Course could not be found");}
			
	 }
	 
	 //method to register a Student
	 public void registerStu() {
		 Scanner input = new Scanner(System.in);
		 System.out.println("Please enter the username for this new Student");
		 String userName = input.next();
		 System.out.println("Please enter the password for this new Student");
		 String passWord = input.next();
		 System.out.println("Please enter the firstname of this new student");
		 String firstName = input.next();
		 System.out.println("Please enter the lastname of this new student");
		 String lastName = input.next();
		 Student newStu = new Student(userName,passWord,firstName,lastName);
	 }
	 
	 //method to view Students in a specific course
	 public void viewStuInSpecCou() {
		 Scanner input = new Scanner(System.in);
		 System.out.println("Please enter the course ID of the specific course whose registered students you would like"
		 		+ "to see:");
		 String CourseId = input.next();
		 System.out.println("Please enter a course section number of the course whose registered students you would like"
		 		+ "to see: ");
		 String SecNum = input.next();
		 Course f = Course.searchCourse(CourseId, SecNum);
		 if(f.getCouName() != (null)) {
		 System.out.print("The List of Students is : ");
		 for(int i = 0; i< f.getnameOfStu().size(); i++) {
			 System.out.print(f.getnameOfStu().get(i));
		 }
		 }
		 else {
			 System.out.println("Course could not be found");
		 }
	 }
	 
	 //method to view CourseList of a specific student 
	 public void viewCouOfSpecStu() {
		 Scanner input = new Scanner(System.in);
		 System.out.println("Please enter the first name of the Student whose course lists you would like to see");
		 String first = input.next();
		 System.out.println("Please enter the last name of t");
		 String last = input.next();
		 Student f = new Student();
		 Student z = f.searchStu(first, last);
		 if(z.getFirstName() != (null)) {
		 System.out.print("The Course List is:");
		 for(int i = 0; i< z.getStuCourses().size(); i++) {
			 System.out.print(" "+ z.getStuCourses().get(i));
		 }
		 }
		 else {
			 System.out.println("Student could not be found");
		 }
		 
		 
	 }
	 
	 //method to use Username and Password to find a Admin object stored in the ArrayList AdminList
	 public static Admin searchadmin(String f, String l) {
	     Admin j = new Admin();
	     for(int i = 0; i < AdminList.size();i++) {
	    	 if(AdminList.get(i).getUsername().equals(f) &&
	    			 AdminList.get(i).getPassword().equals(l)) {
	    		j = AdminList.get(i);
	    	 }
	     }
	     return j;
	}

	
	 //method to write All Full Courses to a file
	 public void writeToFile() 
			  throws IOException {
		 	  int count = 1;
		 	  String k = "";
		 	  for(int i = 0; i< Course.CSCourses.size(); i++) {
		 	  if(Course.CSCourses.get(i).getnameOfStu().size()==Course.CSCourses.get(i).getMaxNumStu()) {
		 		   String s=String.valueOf(count);
		 		   k += s +":";
				   k += Course.CSCourses.get(i).disInfor();
				   k += System.lineSeparator();
				   count++;
			  }
		      }
			    BufferedWriter writer = new BufferedWriter(new FileWriter("src/TheFullCourse.txt"));
			    writer.write(k);
			    
			    writer.close();
			}

	 //method to sort all Courses according to the current Number of Student registered in that Course
	 public void sortCourses(){
		 for(int i=0;i<Course.CSCourses.size();i++){

		       for(int j=i+1;j<Course.CSCourses.size();j++){

		           Integer tempI=Course.CSCourses.get(i).getCurNumStu();
		           Integer tempJ=Course.CSCourses.get(j).getCurNumStu();
		         

		           if(tempI>tempJ)
		        	  Collections.swap(Course.CSCourses, i, j);
		           }

		           }
	 }
	 
	 //method to view All Courses
	 public void viewAllCourse(){
		    System.out.println("Dear Admin, please see the following courses!");
			for(int i = 0; i< Course.CSCourses.size(); i++) {
				int j = i+1;
				System.out.print(j +":");
				System.out.println(Course.CSCourses.get(i).disInfor());
				
			}
			
		}
	 
	 //method to displayInformation of the Admin
	 public void disInforOfUser() {
		 System.out.println("This admin's first name is"+ this.firstName);
		 System.out.println("This admin's last name is "+ this.lastName);
	 }

	
	
	
	 
	 
	 
	 
	 

}
	
