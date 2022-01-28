package homework1;

import java.util.ArrayList;
import java.util.Scanner;

public class Student extends User implements StuInter,java.io.Serializable {
	
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private ArrayList<Course> stuCourses;
	//ArrayList to store All Student Objects
	public static ArrayList<Student> CSStudents = new ArrayList<Student>();
	
	// constructor
	public Student(String username, String password, String firstName, String lastName) {
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;	
		this.stuCourses = new ArrayList<Course>();
		CSStudents.add(this);
	}
	
	//default constructor
	public Student() {

		
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
	public ArrayList<Course> getStuCourses(){
		return this.stuCourses;
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
	public void addStuCourses(Course couName) {
		this.stuCourses.add(couName);
	}
	
	public void deleStuCoures(Course couName) {
		this.stuCourses.remove(couName);
	}
	
	//method to view all courses that are not full
	public void viewNotFullCourses() {
		 int count = 1;
		 System.out.println("The following courses are all the courses that are not Full");
		 for(int i = 0; i< Course.CSCourses.size(); i++) {
			 if(Course.CSCourses.get(i).getnameOfStu().size()<Course.CSCourses.get(i).getMaxNumStu()) {
				    
				    System.out.print(count+":");
					System.out.println(Course.CSCourses.get(i).disInfor());
					count++;
			 }
		 }
	 }
	
	
	//method for a student to register a Course
	public void registerCourse() {
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter a course ID you would like to register:");
		String CourseId = input.next();
		System.out.println("Please enter a course section number you would like to register: ");
		String SecNum = input.next();
		Course f = Course.searchCourse(CourseId, SecNum);
		if(Course.searchCourse(CourseId,SecNum).getCouName() != (null)) {
			if(Course.searchCourse(CourseId,SecNum).getMaxNumStu()>
			Course.searchCourse(CourseId,SecNum).getCurNumStu()) {
				System.out.println("Please enter your full name");
				String fullName = input.next();
				f.addStu(fullName);
				System.out.println("Your registration completed");
				f.increaseCurNumStu(1);
				this.addStuCourses(f);
			}
			else {
				System.out.println("this class is already full");
			}
		}
		else {
			System.out.println("Class could not be found");
		}
	}
	
	
	// method for a student to withdraw from a Course
	public void withdrawCourse() {
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter a course ID you would like to withdraw from:");
		String CourseId = input.next();
		System.out.println("Please enter a course section number you would like to withdraw from: ");
		String SecNum = input.next();
		Course f = Course.searchCourse(CourseId, SecNum);
		if(f.getCouName() != null) {
		System.out.println("Please enter your full name");
		String fullName = input.next();
		f.deleStu(fullName);
		System.out.println("Your withdraw completed");
		f.decreaseCurNumStu(1);
		this.deleStuCoures(f);
		}
		else {
			System.out.println("Course could not be found");
		}
		
	}
	
	
	//method to use Username and Password to find a Student object in all stored Student Objects
	public static Student searchStu(String f, String l) {
	     Student j = new Student();
	     for(int i = 0; i < CSStudents.size();i++) {
	    	 if(CSStudents.get(i).getUsername().equals(f) &&
	    			 CSStudents.get(i).getPassword().equals(l)) {
	    		j = CSStudents.get(i);
	    	 }
	     }
	     return j;
	}
	
	// View All registered Courses for current Student
	public void viewAllCouforCurStu() {
		System.out.println("The following courses are all the courses you are currently registered in");
		for(int i=0; i<this.stuCourses.size(); i++) {
			System.out.println(this.stuCourses.get(i).disInfor());
		}
		
	}
	
	// method to view All Courses
	public void viewAllCourse(){
	    System.out.println("Dear student, please see the following courses!");
		for(int i = 0; i< Course.CSCourses.size(); i++) {
			int j = i+1;
			System.out.print(j +":");
			System.out.println(Course.CSCourses.get(i).disInfor());
		}
		
	}
	//method to display information for the Student
	public void disInforOfUser() {
		System.out.println("This student's firstname is"+ this.firstName);
		System.out.println("THis student's lastname is" + this.lastName);
	}
	
	
	
	
	
	
	

}
