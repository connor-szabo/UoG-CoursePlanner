
/**
 * This is a subclass of Degree for the Honours degree.
 * This class is formatted to go with requirements for 
 * the honours degree.
 *
 * @author Connor Szabo
 * @version October 20 2018
 */
import java.util.*;
public abstract class HonoursDegree extends Degree
{
	public HonoursDegree(CourseCatalog cc){
		super(cc);
		super.setDegreeTitle("BComp Honours");
		super.setRequiredCredits(20.0);
	}
	
	//Mutators
	
	//Sets the degree title
		public void setDegreeTitle(String title){
			super.setDegreeTitle(title);
		}
	
	//Sets the major
	public void setMajor(String major){
		super.setMajor(major);
		}
	
	public void setRequiredCourses(ArrayList<String> listOfRequiredCourseCodes){
		super.setRequiredCourses(listOfRequiredCourseCodes);
	}
	
	//Accessors
	
	//Gets the major
		public String getMajor(){
			return super.getMajor();
		}
		
		public ArrayList<Course> getRequiredCourses(){
			return super.getRequiredCourses();
		}
		
		public ArrayList<Course> remainingRequiredCourses(ArrayList<Course>allCoursesPlannedAndTaken){
			return super.remainingRequiredCourses(allCoursesPlannedAndTaken);
		}
		
		/**
		 * 
		 * @param thePlan gets all courses from the users plan of study
		 * @return a true or false saying i the user has met the requirements to graduate
		 */
		public boolean meetsRequirements(ArrayList<Course>allCoursesPlannedAndTaken){
			ArrayList<Course>requiredCourses;
			double aoa = 0;
			double aoa4 = 0;
			double aoa3 = 0;
			double elective = 0;
			double required = 0;
			boolean flag = false;
			
			//If the user has not reached the number of credits needed return false
			if(super.numberOfCreditsRemaining(allCoursesPlannedAndTaken) > 0){
				return false;
			}
			
			requiredCourses = super.getRequiredCourses();
			
			for(Course x : allCoursesPlannedAndTaken){
						
						//Check if the course is required
						for(Course y : requiredCourses){
							
							//If the course is found, and is completed and has been passed, add the credit
							if(x.getCourseCode().equalsIgnoreCase(y.getCourseCode())){
								flag = true;
								required = required + x.getCourseCredit();
								break;
							}	
						}
						
						//If the course was not a required one
						if(flag == false){
								String[] array = x.getCourseCode().split("*");
								//If it's a computer science course
								if(array[0].equalsIgnoreCase("CIS")){
									//if the course is level 4000
									if(Integer.parseInt(array[1]) >= 4000){
										//If you already have the 2 required level 4000 credits, add it to the 3000 and above credits
										if(aoa4 == 2){
										aoa3 = aoa3 + x.getCourseCredit();
									}
									else{
										aoa4 = aoa4 + x.getCourseCredit();
									}
								}
								//If the course is at the 3000 level
								if((Integer.parseInt(array[1]) < 4000)&&(Integer.parseInt(array[1]) >= 3000)){
									//If you have all required level 3000+ credits, add it to regular area of application
									if(aoa3 == 4){
										aoa = aoa + x.getCourseCredit();
									}
									else{
										aoa3 = aoa3 + x.getCourseCredit();
									}
								}
								//If the course is lower than the 3000 
								if(Integer.parseInt(array[1]) < 3000){
									aoa = aoa + x.getCourseCredit();
								}
							}
							//If the chosen course is not a CIS course
							else{
								elective = elective + x.getCourseCredit();
							}
					
					
						}//close if course is not required
			}//close Plan Of Study list
			
			//If the user has enough required credits
			if(required < 11.25){
				return false;
			}
			//if the user has enough area of application credits
			if(aoa < 4){
				return false;
			}
			//If the user doesnt have 2 area of application credits at the 4000 level
			if(aoa4 < 2){
				return false;
			}
			//If the user doesn't have 4 area of application credits at the 3000 level or higher
			if(aoa3 < 4){
				return false;
			}
			//if the user has enough elective credits
			if(elective < 4.75){
				return false;
			}
			
			
			
			//If user passes all tests: Pass
			return true;
			
		}
    
}
