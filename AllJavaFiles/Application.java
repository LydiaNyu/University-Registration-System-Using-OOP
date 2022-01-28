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
import java.io.*;

public class Application implements java.io.Serializable {
	
	public static void main(String[] args) throws IOException  {
		
		//de-serialization
		 try{
			  
		      FileInputStream fis = new FileInputStream("myCourse.ser");
		      ObjectInputStream ois = new ObjectInputStream(fis);
		      Course.CSCourses = (ArrayList<Course>)ois.readObject();
		      ois.close();
		      fis.close();
		      
		    
		      FileInputStream fis2 = new FileInputStream("myStudent.ser");
		      ObjectInputStream ois2 = new ObjectInputStream(fis2);
		      Student.CSStudents = (ArrayList<Student>)ois2.readObject();
		      ois2.close();
		      fis2.close();
		      

		      FileInputStream fis3 = new FileInputStream("myAdmin.ser");
		      ObjectInputStream ois3 = new ObjectInputStream(fis3);
		      Admin.AdminList = (ArrayList<Admin>)ois3.readObject();
		      ois3.close();
		      fis3.close();
		      
		      
		    }
		    catch(IOException ioe) {
		       Course.readCSV();
		       Admin myAdmin = new Admin("Admin","Admin001","first","last");
			 
		       
		    }
		 catch(ClassNotFoundException cnfe) {
		       cnfe.printStackTrace();
		       return;
		       
		     }
        
        
        
        
		
	    
		Scanner useFor = new Scanner(System.in);
		
		//Ask for if that's a Student or ADmin
		System.out.println("Are you a Student or an Admin?");
		System.out.println("Enter 1 if you are a student:");
		System.out.println("Enter 2 if you are an Admin?");
		int identity = useFor.nextInt();
		if(identity ==1){
			System.out.println("Please enter your username here");
			String userNameStu1 = useFor.next();
			System.out.println("Please enter your password here");
			String passwordStu1 = useFor.next();
			if(Student.searchStu(userNameStu1, passwordStu1).getUsername() !=(null)) {
				Student stu1 = Student.searchStu(userNameStu1, passwordStu1);
				int serviced = 0;
				do{
					System.out.println("Which service you are asking for?");
				System.out.println("Enter 1 to View all courses");
				System.out.println("Enter 2 to View all courses that are not Full");
				System.out.println("Enter 3 to Register on a course");
				System.out.println("Enter 4 to Withdraw from a course");
				System.out.println("Enter 5 to View all courses that you are being registered in now");
				System.out.println("Enter 6 to Exit");
				int serviceforStu = useFor.nextInt();
				serviced = serviceforStu;
				if(serviceforStu ==1) {
					stu1.viewAllCourse();
				}
				if(serviceforStu ==2) {
					stu1.viewNotFullCourses();
				}
				if(serviceforStu == 3) {
					stu1.registerCourse();
				}
				if(serviceforStu == 4) {
					stu1.withdrawCourse();
				}
				if(serviceforStu == 5) {
					stu1.viewAllCouforCurStu();
				}
			    }while(serviced != 6);
				
			}
			else {
				System.out.println("Student could not be found based on your username or password");
			}
			
		}
		
		if(identity ==2) {
			System.out.println("Please enter your username here");
			String userNameAdmin1 = useFor.next();
			System.out.println("Please enter your password here");
			String passwordAdmin1 = useFor.next();
			if(Admin.searchadmin(userNameAdmin1, passwordAdmin1).getUsername() !=(null)) {
				Admin admin1 = Admin.searchadmin(userNameAdmin1, passwordAdmin1);
				System.out.println("Which kind of service you are asking for?");
				System.out.println("Enter 1 to Courses Management Services");
				System.out.println("Enter 2 to Reports Services");
				int option1 = useFor.nextInt();
				if(option1 == 1) {
					int serAdmin = 0;
					do{System.out.println("Which service you are asking for?");
					System.out.println("Enter 1 to Create a new course");
					System.out.println("Enter 2 to Delete a course");
					System.out.println("Enter 3 to Edit a course");
					System.out.println("Enter 4 to Display information for a given course");
					System.out.println("Enter 5 to Register a student");
					System.out.println("Enter 6 to Exit");
					int option2 = useFor.nextInt();
					serAdmin = option2;
					if(option2 ==1) {
						admin1.createCourse();
					}
					if(option2 ==2) {
						admin1.deleCourse();
					}
					if(option2 ==3) {
						admin1.editCourse();
					}
					if(option2 ==4) {
						admin1.displaySpecCou();
					}
					if(option2 ==5) {
						admin1.registerStu();
					}
					}
					while(serAdmin != 6);
				}
				if(option1 == 2) {
					int serAdmin = 0;
					do{System.out.println("Which service you are asking for?");
					System.out.println("Enter 1 to View all courses");
					System.out.println("Enter 2 to View all courses that are Full");
					System.out.println("Enter 3 to Write to a file that are Full");
					System.out.println("Enter 4 to View the names of the students being registered in a"
							+ "specific course");
					System.out.println("Enter 5 to View the list of courses that a given student is"
							+ "being registered on");
					System.out.println("Enter 6 to Sort courses based on the current number of student "
							+ "registers");
					System.out.println("Enter 7 to Exit");
					int option3 = useFor.nextInt();
					serAdmin = option3;
					if(option3 ==1) {
						admin1.viewAllCourse();
					}
					if(option3 ==2) {
						admin1.viewFullCourses();
					}
					if(option3 ==3) {
					    admin1.writeToFile();
					}
					if(option3 ==4) {
						admin1.viewStuInSpecCou();
					}
					if(option3 ==5) {
						admin1.viewCouOfSpecStu();
					}
					if(option3 ==6) {
						admin1.sortCourses();
					}
					
					}
					while(serAdmin !=7);
				}
				
				
			}
			else {
				System.out.println("Admin could not be found based on your username or password");
			}
		}
		
		
		
       //serialization
		try {
			//FileOutput Stream writes data to a file
			FileOutputStream fos = new FileOutputStream("myCourse.ser");
			
			//ObjectOutputStream writes objects to a stream (A sequence of data)
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			//Writes the specific object to the OOS
			oos.writeObject(Course.CSCourses);
			
			//Close both streams
			oos.close();
			fos.close();
			
			
            FileOutputStream fos2 = new FileOutputStream("myStudent.ser");
			
			//ObjectOutputStream writes objects to a stream (A sequence of data)
			ObjectOutputStream oos2 = new ObjectOutputStream(fos2);
			
			//Writes the specific object to the OOS
			oos2.writeObject(Student.CSStudents);
			
			//Close both streams
			oos2.close();
			fos2.close();
			
			
			
			FileOutputStream fos3 = new FileOutputStream("myAdmin.ser");
			
			//ObjectOutputStream writes objects to a stream (A sequence of data)
			ObjectOutputStream oos3 = new ObjectOutputStream(fos3);
			
			//Writes the specific object to the OOS
			oos3.writeObject(Admin.AdminList);
			
			//Close both streams
			oos3.close();
			fos3.close();
			
			
		} 
		catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
	}
}
