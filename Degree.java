
/**
 * This class contains information for the user such as:
 * -Student's degree and Major
 * -Required courses for said degree and major
 *
 * @author Connor Szabo
 * @version October 21 2018
 */
import java.util.*;

public abstract class Degree
{
	private String degreeTitle;
	private String major;
	private CourseCatalog cc;
	private ArrayList<Course> requiredCourses;
	private ArrayList<String> artsPrefix;
	private ArrayList<String> sciencePrefix;
	private double requiredCredits;
	
	public Degree(){
		requiredCourses = new ArrayList<>();
		artsPrefix = new ArrayList<>();
		sciencePrefix = new ArrayList<>();
		this.fillPrefixArrays();
	}
	
	public Degree(CourseCatalog cc){
		this();
		this.cc = cc;
		
	}
	
	//Mutators
	
	//Sets the degree title
	public void setDegreeTitle(String title){
		this.degreeTitle = title;
	}
	
	//Sets the required courses
	public void setRequiredCourses(ArrayList<String> listOfRequiredCourseCodes){
		ArrayList<Course> required = new ArrayList<>();
		Course course;
		
		for(String x : listOfRequiredCourseCodes){
			course = cc.findCourse(x);
			if(course != null){
				required.add(course);
			}
			
		}
		this.requiredCourses = required;
	}
	
	//Sets the major
	public void setMajor(String major){
		this.major = major;
	}
	
	//Sets the credits needed to graduate
	public void setRequiredCredits(double required){
		this.requiredCredits = required;
	}
	
	//Accessors
	
	public String getDegreeTitle(){
		return this.degreeTitle;
	}
	
	public ArrayList<Course> getRequiredCourses(){
		return this.requiredCourses;
	}
	
	//Gets the science prefix courses
	public ArrayList<String> getScienceCourses(){
		return this.sciencePrefix;
	}
	
	//gets the arts prefix courses
	public ArrayList<String> getArtsCourses(){
		return this.artsPrefix;
	}
	
	
	//Gets the major
	public String getMajor(){
		return this.major;
	}
	
	public CourseCatalog getCC(){
		return this.cc;
	}
	
	public ArrayList<Course> remainingRequiredCourses(ArrayList<Course>allCoursesPlannedAndTaken){
	ArrayList<Course> remaining = new ArrayList<>();
	ArrayList<Course> required = this.requiredCourses;
	boolean flag = false;
	
	for(Course x : required){
		flag = false;
		for(Course y : allCoursesPlannedAndTaken){
			if(x.getCourseCode().equalsIgnoreCase(y.getCourseCode())){
				flag = true;
			}
			
		}
		if(flag == false){
			remaining.add(x);
		}
	}
	
		return remaining;
	}
	
	public double numberOfCreditsRemaining(ArrayList<Course>allCoursesPlannedAndTaken){
		double earned = 0;
		double needed = 0;
		for(Course x : allCoursesPlannedAndTaken){
				earned = earned + x.getCourseCredit();
		}
		needed = this.requiredCredits - earned;
		if(needed < 0){
			return 0;
		}
		else{
			return needed;
		}
	}
	
	public double getRequiredCredits(){
		return this.requiredCredits;
	}
	
	public abstract boolean meetsRequirements(ArrayList<Course>listOfRequiredCourseCodes);
		
	
	public void fillPrefixArrays(){
		this.sciencePrefix.add("BIOL");
		this.sciencePrefix.add("CHEM");
		this.sciencePrefix.add("MATH");
		this.sciencePrefix.add("PHYS");
		this.sciencePrefix.add("IPS");
		this.sciencePrefix.add("ZOO");
		this.sciencePrefix.add("MBG");
		this.sciencePrefix.add("BIOC");
		this.sciencePrefix.add("STAT");
		this.sciencePrefix.add("NEUR");
		this.sciencePrefix.add("MCB");
		this.sciencePrefix.add("TOX");
		this.sciencePrefix.add("ANSC");
		this.sciencePrefix.add("BINF");
		this.sciencePrefix.add("BIOM");
		this.sciencePrefix.add("BIOP");
		this.sciencePrefix.add("BIOT");
		this.sciencePrefix.add("ENVS");
		this.sciencePrefix.add("FOOD");
		this.sciencePrefix.add("HK");
		this.sciencePrefix.add("KIN");
		this.sciencePrefix.add("NUTR");
		
		this.artsPrefix.add("SART");
		this.artsPrefix.add("SPAN");
		this.artsPrefix.add("PORT");
		this.artsPrefix.add("PHIL");
		this.artsPrefix.add("LING");
		this.artsPrefix.add("MUSC");
		this.artsPrefix.add("THST");
		this.artsPrefix.add("LAT");
		this.artsPrefix.add("LACS");
		this.artsPrefix.add("ENGL");
		this.artsPrefix.add("EURO");
		this.artsPrefix.add("CLAS");
		this.artsPrefix.add("CHIN");
		this.artsPrefix.add("ARTH");
		this.artsPrefix.add("FREN");
		this.artsPrefix.add("GERM");
		this.artsPrefix.add("HUMN");
		this.artsPrefix.add("ITAL");
		this.artsPrefix.add("HIST");
		this.artsPrefix.add("HISP");
		this.artsPrefix.add("GREK");
		this.artsPrefix.add("ARAB");
		this.artsPrefix.add("ANTH");
	}
	
}
