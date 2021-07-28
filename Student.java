/**
 * This program contains the user's first and last name, 
 * along with their student number
 * @author connorszabo
 * @version Oct 14 2018
 *
 */
public class Student {
	private String fName;
	private String lName;
	private Integer studentNum;
	
	public Student(){
		this.fName = null;
		this.lName = null;
		this.studentNum = 0;	
	}
	public Student(String f, String l, Integer num){
		this.fName = f;
		this.lName = l;
		this.studentNum = num;
	}
	
	//************Accessor************\\
	
	//Returns the full name of the student
	public String getFullName(){
		return this.fName + " " + this.lName;
	}
	
	//Returns the First name
	public String getFirstName(){
		return this.fName;
	}
	
	//Returns the last name
	public String getLastName(){
		return this.lName;
	}
	
	public Integer getStudentNumber(){
		return this.studentNum;
	}
	
	//************Mutator************\\
	
	//Sets the users first name
	public void setFirstName(String first){
		this.fName = first;
	}
	
	//Sets the users last name
	public void setLastName(String last){
		this.lName = last;
	}
	
	//Sets the student number
	public void setStudentNumber(Integer studentNum){
		this.studentNum = studentNum;
	}
}
