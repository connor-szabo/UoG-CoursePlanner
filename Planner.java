
/**
 * This program contains the interface for the user, allowing them
 * to set up their whole post-secondary academic career. By loading in
 * the file created by bootstrap, the user is able to pick courses
 * they have completed, want to take or are taking. The user doesn't
 * have to start from scratch either, because the program can load in
 * user transcripts of a specific format.
 *
 * @author Connor Szabo
 * @version October 20 2018
 */
import java.io.*;
import java.util.*;

public class Planner
{
    public static void main(String args[]) throws IOException{
        Planner p = new Planner();
        Degree deg = null;
        CourseCatalog cc = new CourseCatalog();
        
        Gui gui = new Gui(p, cc, deg);
        
    }//close main
    
    
    
}
