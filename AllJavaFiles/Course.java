package homework1;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
 
public class Course implements java.io.Serializable {
		private String courseName;
		private String courseId;
		private int maxNumStu;
		private int curNumStu;
		private ArrayList<String> namesOfStu;
		private String couInstru;
		private String secNum;
		private String couLoc;
		//Arraylist to store all Courses Object read from MyUniversityCourses.csv
		public static ArrayList<Course> CSCourses = new ArrayList<Course>();
		
		//method to read MyUniversityCourses.csv
		public static void readCSV() {
			 ArrayList<String[]> CS = new ArrayList<String[]>();
			 Scanner scanner = null;
			  try{
				  scanner = new Scanner(new File("src/MyUniversityCourses.csv"));
			  }  catch(FileNotFoundException e) {
				  throw new RuntimeException("not Found the FIle");
			  }
			 
	         
		        //Set the delimiter used in file
		        scanner.useDelimiter(",");
		         
		        //Get all tokens and store them in some data structure
		        //I am just printing them
		        while (scanner.hasNext()) 
		        {  
		        	String [] arrs = scanner.nextLine().split(",");
		        	CS.add(arrs);
		        }
		         
		       
		        //Do not forget to close the scanner  
		        scanner.close();
		       for(int i = 1; i< CS.size(); i++) {
		    	   
		    	  Course cou = new Course(CS.get(i)[0], CS.get(i)[1], Integer.parseInt(CS.get(i)[2]),
		    			  Integer.parseInt(CS.get(i)[3]), CS.get(i)[5],
		    			  CS.get(i)[6],CS.get(i)[7]);
		    	   CSCourses.add(cou);
		       }
			
		}
		//constructor
		public Course(String courseName, String courseId,int maxNumStu,
				int curNumStu, String couInstru,
				String secNum, String couLoc){
			this.courseName = courseName;
			this.courseId = courseId;
			this.maxNumStu = maxNumStu;
			this.curNumStu = curNumStu;
			this.namesOfStu = new ArrayList<String>();
			this.couInstru = couInstru;
			this.secNum = secNum;
			this.couLoc = couLoc;	
		}
		//default constructor
		public Course() {
			
			
		}
		//encapsulation
		public void setmaxNumStu(int num){
			this.maxNumStu = num;
		}
		public void increaseCurNumStu(int num) {
			this.curNumStu += num;
		}
		public void decreaseCurNumStu(int num) {
			this.curNumStu -= num;
		}
		public void addStu(String name) {
			this.namesOfStu.add(name);

		}
		public void deleStu(String name) {
			for(int i = 0; i<this.namesOfStu.size();i++) {
				if(this.namesOfStu.get(i).equals(name)) {
					this.namesOfStu.remove(i);
				}
			}
		}
		public void setcouInstru(String instr) {
			this.couInstru = instr;
		}
		
		public void setSecNum (String sec) {
			this.secNum = sec;
		}
		public void setcouLoc(String location) {
			this.couLoc = location;
		}
		
		public String getCouName() {
			return this.courseName;
		}
		public String getCouId() {
			return this.courseId;
		}
		public int getMaxNumStu() {
			return this.maxNumStu;
		}
		public int getCurNumStu() {
			return this.curNumStu;
		}
		public ArrayList<String> getnameOfStu(){
			return this.namesOfStu;
		}
		public String getCouInstru() {
			return this.couInstru;
		}
		public String getSecNum() {
			return this.secNum;
		}
		public String getCouLoc() {
			return this.couLoc;
		}
		
		//method to display information for a Course object
		public String disInfor(){
			String k ="";
			k += "This Course's Name is "+ this.courseName;
			k +="; This Course's Id is "+ this.courseId;
			k +="; Maximum student Number is "+ this.maxNumStu;
			k +="; Current student number is  " + this.curNumStu;
			k +="; Current enrolled student list is ";
			  for(String elem : this.namesOfStu){
			        k+= elem+", ";
			    }
			k +="; Course Instructor is "+ this.couInstru;
			k +="; Section Number is "+ this.secNum;
			k +="; Course Location is "+ this.couLoc;
			
			return k;
			
			
		}
		//method to find a certain Course Object from all Stored Course Objects
		public static Course searchCourse(String courseId, String secNum) {
			Course file = new Course();
			for(int i = 0; i < CSCourses.size(); i++) {
				if(CSCourses.get(i).getCouId().equals(courseId) && CSCourses.get(i).getSecNum().equals(secNum)){
					file = CSCourses.get(i);
				
					
				}

			}
			return file;
		}
		
		
		
		
		
		
		
		
}

