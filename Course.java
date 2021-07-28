 
import java.util.*;

public class Course {
    private String courseTitle;
    private String courseCode;
    private String semOffered;
    private double courseCredit;
    private ArrayList<Course> preReq;
    
    //Constructor
    public Course(){
        this.semOffered = "B";
        preReq = new ArrayList<>();
    }
    
    public Course(String courseCode){
    	this();
    	this.courseCode = courseCode;
    }
    
    public Course(String title, String code, String sem, double credit, ArrayList<Course> req){
    	this.courseTitle = title;
        this.courseCode = code;
        this.semOffered = sem;
        this.courseCredit = credit;
        this.preReq = req;
    }
    
    public Course(Course course){
    	this(course.courseTitle, course.courseCode, course.semOffered, course.courseCredit, course.preReq);
    }
    
    //Accessors
    
    /**
     * 
     * @return The course code
     */
    public String getCourseCode(){
    	return this.courseCode;
    }
    
    /**
     * 
     * @return Name of course
     */
    public String getCourseTitle(){
    	return this.courseTitle;
    }
    
    /**
     * 
     * @return the number of credits the course is worth
     */
    public double getCourseCredit(){
    	return this.courseCredit;
    }
    
    /**
     * 
     * @return A list of the prerequisites for the given course
     */
    public ArrayList<Course> getPrerequisites(){
    	return this.preReq;
    }
    
    public String getSemesterOffered(){
    	return this.semOffered;
    }
    
    //Mutators
    
    //Sets course code
    protected void setCourseCode(String code){
    	this.courseCode = code;
    }
    
    //Sets course Title
    protected void setCourseTitle(String title){
    	this.courseTitle = title;
    }
    
    //Sets course Credit
    protected void setCourseCredit(double num){
    	this.courseCredit = num;
    }
    
    //Sets prerequisites for the course
    protected void setPrerequisites(ArrayList<Course> preReqList){
    	this.preReq = preReqList;
    }
    
    //Sets the semester taken
    protected void setSemesterOffered(String sem){
    	this.semOffered = sem;
    }
    
}
