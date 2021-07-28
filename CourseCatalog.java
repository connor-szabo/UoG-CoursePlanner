
/**
 * This class contains all available courses that a student can take,
 * along with the required courses for all majors
 *
 * @author Connor Szabo
 * @version October 19 2018
 */
import java.io.*;
import java.util.*;

public class CourseCatalog
{
	private ArrayList<Course> courseCatalog;
	private ArrayList<String> requiredCourseCodes;
	private ArrayList<Attempt> plannedOrAttempt;
	
	//Constructor
	public CourseCatalog(){
		courseCatalog = new ArrayList<>();
		requiredCourseCodes = new ArrayList<>();
		plannedOrAttempt = new ArrayList<>();
	}
	
	//Accessor
	public ArrayList<Course> getCatalog(){
		return this.courseCatalog;
	}
	
	public ArrayList<Attempt> getAttempts(){
		return this.plannedOrAttempt;
	}
	
	public ArrayList<String> getReq(){
		return this.requiredCourseCodes;
	}
	
	public void addAttempt(Course course, String sem){
		plannedOrAttempt.add(new Attempt(course, sem));
	}
	
	public void addAttempt(Course course, String sem, String grade){
		plannedOrAttempt.add(new Attempt(course, sem, grade));

	}

	
	/**
	 * Saves the current CourseCatalog
	 */
	public void saveCatalog() throws IOException{
		File file = new File("Catalog");
		FileWriter fw = new FileWriter(file);
		Writer bw = new BufferedWriter(fw);
		
		for(Course x : this.courseCatalog){
			bw.write(x.getCourseCode() + "," + x.getCourseCredit() + "," + x.getCourseTitle() + ",");
			for(Course y : x.getPrerequisites()){
				if(x.getPrerequisites().indexOf(y) == x.getPrerequisites().size()-1){
					bw.write(y.getCourseCode());
				}
				else{
					bw.write(y.getCourseCode() + ":");
				}
			}
			
		}
		bw.close();
	}
	
	/**
	 * 	Loads all courses from a given file and stores them in an arraylist
	 * @param fileName Name of file that contains all courses
	 * @throws IOException 
	 */
	public void initializeCatalog(String fileName) throws IOException{
		Course course;
    	String line = "";
        ArrayList<Course> preReq = new ArrayList<>();
        
        try(BufferedReader kb = new BufferedReader(new FileReader(fileName))){
            while((line = kb.readLine()) != null){
            	String[] array = line.split(",");
            	array[0].replaceAll(" ", "");
            	array[1].replaceAll(" ", "");
            	if(array[2].substring(0, 1).equals(" ")){
            		array[2] = array[2].substring(1);
            	}

            	
            	//Giving the new course the loaded parameters
            	course = new Course();
            	course.setCourseCode(array[0]);
            	course.setCourseTitle(array[2]);
            	course.setCourseCredit(Double.parseDouble(array[1]));
            	if(array.length >3){
            		course.setSemesterOffered(array[3]);
            	}
            	
            	//If the course has prerequisites
            	if(array.length == 5){
            		array[4].replaceAll(" ", "");
            		String[] preReqArray = array[4].split(":");
            		
            		//Get rid of any spaces if necessary
            		if(preReqArray[0].contains(" ")){
            			preReqArray[0] = preReqArray[0].substring(1);
            		}
            		preReq = findPreReq(this.courseCatalog, preReqArray);
            		
            		course.setPrerequisites(preReq);
            	}
            	//Add the created courses to the array list
                addCourse(course);
            }
            kb.close();
        }
        catch(FileNotFoundException e){
         System.out.println("File not found");
         
        }
        
        
	}
    
	
    /**
     * 
     * @param courses The courses created so far stored in a arraylist
     * @param array The prerequisites for the current course
     * @return an arraylist of all the prerequisite courses for the current course
     */
    public ArrayList<Course> findPreReq(ArrayList<Course> courses, String[] array){
    	ArrayList<Course> preReq = new ArrayList<>();
    	Course holder;
    	
    	
    	for(int i = 0; i < array.length; i++){
    		Course course = this.findCourse(array[i]);
    		
    		//If the course can not be found
    		if(course == null){
    			holder = new Course(array[i]);
				preReq.add(holder);
    		}
    		//if the course is found
    		else{
    			preReq.add(course);
    		}
			
		}
    	
    	return preReq;
    	
    }//close findPreReq
    
    
    /**
     * 
     * @param courseCode The course code of the class you are looking for
     * @return the desired course if found, otherwise null
     */
    public Course findCourse(String courseCode){
    	
    	for(Course x : this.courseCatalog){
    		if(x.getCourseCode().equals(courseCode)){
    			return x;
    		}
    	}
    	return null;   	
    }//close findCourse
    
    
    /**
     * Removes a desired course from the course catalog
     * @param toRemove desired course
     */
    public void removeCourse(Course toRemove){
    	this.courseCatalog.remove(toRemove);
    }//close removeCourse
    
    public void removeAttempt(Attempt toRemove){
    	this.plannedOrAttempt.remove(toRemove);
    }
    
    public void removeAllAttempts(){
    	this.plannedOrAttempt = null;
    	this.plannedOrAttempt = new ArrayList<>();
    }
    
    /**
     * Adds a desired course to course catalog
     * @param toAdd desired course
     */
    public void addCourse(Course toAdd){
    	this.courseCatalog.add(toAdd);
    }
    
    /**
     * Displays all available courses
     */
    public void displayAll(){
    	for(Course x: this.courseCatalog){
    		System.out.println(x);
    	}
    }
    
    
}
