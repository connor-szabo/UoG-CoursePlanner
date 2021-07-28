/**
 * This is a subclass of Degree for the General degree.
 * This class is formatted to go with requirements for 
 * the general degree.
 *
 * @author Connor Szabo
 * @version October 20 2018
 */

import java.util.ArrayList;

public abstract class GeneralDegree extends Degree
{
	public GeneralDegree(CourseCatalog cc){
		super(cc);
		super.setDegreeTitle("BComp General");
		super.setRequiredCredits(15);
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
	
	//Sets credit requirements
	public void setRequiredCredits(double required){
		super.setRequiredCredits(required);
	}
	
	//Accessors
	
	//Gets the major
		public String getMajor(){
			return super.getMajor();
		}
		
		public ArrayList<Course> getRequiredCourses(){
			return super.getRequiredCourses();
		}
		
		public ArrayList<Course> remainingRequiredCourses(ArrayList<Course>allTheCoursesPlannedAndTaken){
			return super.remainingRequiredCourses(allTheCoursesPlannedAndTaken);
		}
		
		public boolean meetsRequirements(ArrayList<Course>allTheCoursesPlannedAndTaken){
			ArrayList<Course>requiredCourses;
			double cis2 = 0;
			double firstYear = 0;
			double cis3 = 0;
			double science = 0;
			double art = 0;
			double required = 0;
			boolean flag = false;
			
			//If the user has not reached the number of credits needed return false
			if(super.numberOfCreditsRemaining(allTheCoursesPlannedAndTaken) > 0){
				return false;
			}
			requiredCourses = super.getRequiredCourses();
			
			for(Course x : allTheCoursesPlannedAndTaken){	
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
								
					//Check to see if it is a CIS course
					if(array[0].equals("CIS")){
						//if the course is a 3000 or up course
						if(Integer.parseInt(array[1]) >= 3000){
							if(cis3 == 1){
								cis2 = cis2 + x.getCourseCredit();
							}
							else{
								cis3 = cis3 + x.getCourseCredit();
							}
						}
						//If the course is a 2000 course
						else if((Integer.parseInt(array[1]) < 3000)&&(Integer.parseInt(array[1]) > 2000)){
							cis2 = cis2 + x.getCourseCredit();
						}
					}
					//Checks if the course is an art credit
					for(String s : super.getArtsCourses()){
						if(s.equalsIgnoreCase(array[0])){
							//If it is a first year course, make sure user doesnt already have 6 first year credits
							if(Integer.parseInt(array[1]) < 2000){
								if(firstYear < 6){
									art = art + x.getCourseCredit();
									firstYear = firstYear + x.getCourseCredit();
								}
							}
							else{
								art = art + x.getCourseCredit();
										}
										
										
									}
								}
								
								//Checks if the course is a science credit
								for(String s : super.getScienceCourses()){
									if(s.equalsIgnoreCase(array[0])){
										//If it is a first year course, make sure user doesnt already have 6 first year credits
										if(Integer.parseInt(array[1]) < 2000){
											if(firstYear < 6){
												science = science + x.getCourseCredit();
												firstYear = firstYear + x.getCourseCredit();
											}
										}
										else{
											science = science + x.getCourseCredit();
										}
									}
								}	
						}//close if course is not required
			}//close Plan Of Study list
			
			//If the user has enough required credits
			if(required < 4.25){
				return false;
			}
			//if the user has enough area of application credits
			if(science < 2){
				return false;
			}
			//If the user doesnt have 2 area of application credits at the 4000 level
			if(art < 2){
				return false;
			}
			//If the user doesn't have 4 area of application credits at the 3000 level or higher
			if(cis2 < 0.5){
				return false;
			}
			//if the user has enough elective credits
			if(cis3 < 1){
				return false;
			}
			
			
			
			//If user passes all tests: Pass
			return true;
			
		}//close meetsRequirements
		
}
