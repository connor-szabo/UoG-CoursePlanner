
/**
 * BCG Is a subclass of degree for the major Computer Science Honours.
 * All method calls from here are formatted for the given major.
 *
 * @author Connor Szabo
 * @version October 14 2018
 */
import java.util.ArrayList;

public class CS extends HonoursDegree
{
	public CS(CourseCatalog cc){
		super(cc);
		this.setMajor("Computer Science Honours");
		this.setRequiredCourses(super.getCC().getReq());
	}
	//Accessors
	
	//Returns the degree title
	public String getDegreeTitle(){
		return super.getDegreeTitle();
	}
	
	//sets the degree title
	public void setDegreeTitle(String title){
		super.setDegreeTitle(title);
	}
	
	//Sets the required courses for the given major
	public void setRequiredCourses(ArrayList<String> listOfRequiredCourseCodes){
		ArrayList<String> requiredCourses = new ArrayList<>();
		
		requiredCourses.add("CIS*1500");
		requiredCourses.add("MATH*1200");
		requiredCourses.add("CIS*1910");
		requiredCourses.add("CIS*2500");
		requiredCourses.add("CIS*2030");
		requiredCourses.add("CIS*2430");
		requiredCourses.add("CIS*2520");
		requiredCourses.add("CIS*2910");
		requiredCourses.add("CIS*2750");
		requiredCourses.add("CIS*3110");
		requiredCourses.add("CIS*3490");
		requiredCourses.add("CIS*3150");
		requiredCourses.add("CIS*3750");
		requiredCourses.add("CIS*2460");
		requiredCourses.add("CIS*3760");
		requiredCourses.add("CIS*4650");
		
		super.setRequiredCourses(requiredCourses);
		
	}
	
	public ArrayList<Course> getRequiredCourses(){
		return super.getRequiredCourses();
	}
	
	public boolean meetsRequirements(ArrayList<Course>allCoursesPlannedAndTaken){
		return false;
	}
	
	public ArrayList<Course> remainingRequiredCourses(ArrayList<Course>allCoursesPlannedAndTaken){
			return super.remainingRequiredCourses(allCoursesPlannedAndTaken);
	}
    
}