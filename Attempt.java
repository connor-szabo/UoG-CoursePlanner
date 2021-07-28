
public class Attempt {

	private String semTaken;
	private String grade;
	private Course courseAttempted;
	
	public Attempt(){
		this.semTaken = null;
		this.grade = null;
		this.courseAttempted = null;
	}
	
	public Attempt(Course course, String sem){
		this.courseAttempted = course;
		this.semTaken = sem;
		this.grade = null;
	}
	
	public Attempt(Course course, String sem, String grade){
		this.courseAttempted = course;
		this.semTaken = sem;
		this.grade = grade;
	}

	
	public void setAttemptGrade(String grade){
		this.grade = grade;
	}
	
	public void setSemesterTken(String semester){
		this.semTaken = semester;
	}
	
	public void setCourseAttempted(Course theCourse){
		this.courseAttempted = theCourse;
	}
	
	public String getAttemptGrade(){
		return this.grade;
	}
	
	public String getSemesterTaken(){
		return this.semTaken;
	}
	
	public Course getCourseAttempted(){
		return this.courseAttempted;
	}
	
	
}
