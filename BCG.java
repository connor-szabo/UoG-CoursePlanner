
/**
 * BCG Is a subclass of degree for the major Computer Science General.
 * All method calls from here are formatted for the given major.
 *
 * @author Connor Szabo
 * @version October 20 2018
 */

import java.util.*;
public class BCG extends GeneralDegree
{
	public BCG(CourseCatalog cc){
		super(cc);
		super.setMajor("Computer Science General");
		this.setRequiredCourses(super.getCC().getReq());
	}
	
	//Mutators
	
	//Sets the required courses for the given major
	public void setRequiredCourses(ArrayList<String> listOfRequiredCourseCodes){
		ArrayList<String> requiredCourses = new ArrayList<>();
		
		requiredCourses.add("CIS*1500");
		requiredCourses.add("CIS*1910");
		requiredCourses.add("CIS*2500");
		requiredCourses.add("CIS*2430");
		requiredCourses.add("CIS*2520");
		requiredCourses.add("CIS*2910");
		requiredCourses.add("CIS*2750");
		requiredCourses.add("CIS*3530");

		super.setRequiredCourses(requiredCourses);
		
	}
	
	/**
	 * Retrieves an arraylist filled with mandatory courses for the given major
	 */
	public ArrayList<Course> getRequiredCourses(){
		return super.getRequiredCourses();
	}
	
}
