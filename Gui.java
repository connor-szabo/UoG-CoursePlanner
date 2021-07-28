/**
 * @author Connor Szabo
 * @version November 19 2018
 * @description This class builds the User Interface for the planner program. 
 */
import java.awt.*;
import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.*;

public class Gui{
	Student user = new Student();
	DecimalFormat two = new DecimalFormat(".##");
	
	JMenuBar menuBar = new JMenuBar();
	JMenu newMenu = new JMenu("New");
	JMenu saveMenu = new JMenu("Save");
	JMenu loadMenu = new JMenu("Load");
	JMenuItem saveStudent = new JMenuItem("Save Student");
	JMenuItem saveCourses = new JMenuItem("Save Courses");
	JMenuItem loadCourses = new JMenuItem("Load Courses");
	JMenuItem loadStudent = new JMenuItem("Load Student");
	JMenuItem newStudent = new JMenuItem("New Student");
	
	JFrame frame;
	JFrame aFrame;
	
	JPanel userStats = new JPanel();
	JPanel startButtons = new JPanel();
	JPanel posOptions = new JPanel();
	JPanel courseOptions = new JPanel();
	JPanel gpaInfo = new JPanel();
	JPanel requirementsMain = new JPanel();
	JPanel plan = new JPanel();
	JPanel degreePanel = new JPanel();
	JPanel courseTypePanel = new JPanel();
	JPanel transcriptPanel = new JPanel();
	JPanel posPanel = new JPanel();
	JPanel preReqPanel = new JPanel();
	JPanel textAreaPanel = new JPanel();
	JPanel optionsPanel = new JPanel();
	

	JTextArea stats;
	JButton quit = new JButton("Quit");
	JButton posButton = new JButton("Plan Of Study");
	JButton courseButton = new JButton("Courses");
	JButton backStart = new JButton("Back");
	JButton backPOS = new JButton("Back");
	JButton backCourses = new JButton("Back");
	JButton backCourseType = new JButton("Back");
	
	//For the Save/Load Screen
	boolean flag1 = true;
	boolean flag2 = true;
	Integer studentInteger;
	String firstName;
	String lastName;
	String stringNum;
	String fileName;
	int studentNum;
	
	//For the POS Screen
	JButton coursePlanButton = new JButton("Course Plan");
	JButton gpaButton = new JButton("GPA");
	JButton requirementsButton = new JButton("Requirements");
	
	//For Courses screen
	JButton degreeButton = new JButton("Select Degree/Major");
	JButton maintainButton = new JButton("Maintain Courses");
	JButton requiredButton = new JButton("Required Courses");
	
	//For GPA screen
	JTextPane overallGPA = new JTextPane();
	JTextPane tenGPA = new JTextPane();
	JTextPane cisGPA = new JTextPane();
	JLabel overallLabel = new JLabel("Overall GPA:");
	JLabel tenLabel = new JLabel("GPA of 10 most recent credits:");
	JLabel cisLabel = new JLabel("GPA of all CIS courses:");
	
	//For Requirements screen
	JTextField metRequirements = new JTextField();
	JTextField creditsRemaining = new JTextField();
	JTextField creditsComplete = new JTextField();
	JTextField creditsNeeded = new JTextField();
	JTextArea rc = new JTextArea(10,15);
	JScrollPane requiredCourses = new JScrollPane(rc);
	JButton notInPOS = new JButton("Required Courses not in Plan of Study");
	JButton notInTranscript = new JButton("Required Courses not in Transcript");
	JLabel metRequirementsLabel = new JLabel("Are the requirements to graduate met?:");
	JLabel creditsRemainingLabel = new JLabel("Credits remaining:");
	JLabel creditsCompleteLabel = new JLabel("Credits completed:");
	JLabel creditsNeededLabel = new JLabel("Credits needed in Plan of Study:");
	
	//For Course Plan screen
	DefaultComboBoxModel<String> tempList = new DefaultComboBoxModel<String>();
	JComboBox<String> semList = new JComboBox<String>(tempList);
	JTextArea so = new JTextArea(15,15);
	JScrollPane semOutline = new JScrollPane(so);
	JButton loadSem = new JButton("Load");
	
	//For select degree screen
	String degreesArray[] = {"B.Comp","BCG"};
	JComboBox<String> degrees = new JComboBox<String>(degreesArray);
	DefaultComboBoxModel<String> majorList = new DefaultComboBoxModel<String>();
	JComboBox<String> majors = new JComboBox<String>(majorList);
	JTextPane selectDText = new JTextPane();
	JTextPane selectMText = new JTextPane();
	JButton degreeChoice = new JButton("Degree");
	JButton majorChoice = new JButton("Major");
	
	//Course Type Screen
	JButton transcript = new JButton("Transcript");
	JButton planofstudy = new JButton("Plan of Study");

	//Transcript screen
	JTextArea loc = new JTextArea(20,20);
	JScrollPane listOfCourses = new JScrollPane(loc);
	JButton change = new JButton("Change Grade");
	JButton tRemove = new JButton("Remove Course");
	JButton tAdd = new JButton("Add Course");
	JTextField tCourseCode = new JTextField();
	JTextField tSemTaken = new JTextField();
	JLabel tCode = new JLabel("Enter Course Code:");
	JLabel tSem = new JLabel("Enter Semester Taken:");
	
	//Plan of Study screen
	JButton pRemove = new JButton("Remove Course");
	JButton pAdd = new JButton("Add Course");
	JTextField pCourseCode = new JTextField();
	JTextField pSemTaken = new JTextField();
	JLabel pCodeLabel = new JLabel("Enter Course Code:");
	JLabel pSemLabel = new JLabel("Enter Semester Taken:");
	
	
	//Prereq screen
	DefaultComboBoxModel<String> requiredCourseList = new DefaultComboBoxModel<String>();
	JComboBox<String> requiredCourse = new JComboBox<String>(requiredCourseList);
	JTextArea reqPreReq = new JTextArea(10,10);
	JScrollPane rPR = new JScrollPane(reqPreReq);
	JTextArea preReq = new JTextArea(10,10);
	JScrollPane pR = new JScrollPane(preReq);
	JButton loadReqPreReq = new JButton("Load");
	JLabel posRequiredLabel = new JLabel("Plan of Study and Prerequisites");
	JLabel reqRequiredLabel = new JLabel("Required Course Prerequisites");
	
	//****************************Administrator Widgets****************************
	
	JPanel adminCourse = new JPanel();
	JPanel adminHome = new JPanel();
	JPanel adminDegree = new JPanel();
	
	JButton adminBackHome = new JButton("Back");
	
	//For Admin Main Menu
	JButton adminCourseMenu = new JButton("Edit Courses");
	JButton adminDegreeMenu = new JButton("Edit Degrees");
	
	//For Admin Course Menu
	JLabel adminCodeLabel = new JLabel("Course Code");
	JTextField adminCode = new JTextField();
	JLabel adminTitleLabel = new JLabel("Course Title");
	JTextField adminTitle = new JTextField();
	JLabel adminSemLabel = new JLabel("Semester Offered");
	JTextField adminSem = new JTextField();
	JLabel adminPreReqLabel = new JLabel("Prerequisite Courses");
	JTextField adminPreReq = new JTextField();
	JLabel adminWeightLabel = new JLabel("Course Weight");
	JTextField adminWeight = new JTextField();
	JButton editCourse = new JButton("Create/Change Course");
	JButton removeCourse = new JButton("Remove Course");
	
	//For Admin Degree Menu
	JLabel adminDegreeTitleLabel = new JLabel("Degree Title");
	JTextField adminDegreeTitle = new JTextField();
	JLabel adminReqCredLabel = new JLabel("Required Credits");
	JTextField adminReqCred = new JTextField();
	JLabel adminMajorLabel = new JLabel("Majors");
	JTextField adminMajor = new JTextField();
	JButton adminEditDegree = new JButton("Add/Edit");
	JButton adminRemoveDegree = new JButton("Remove");
	
	
	
	ArrayList<Course> planOfStudyCourses;
    CourseCatalog cc;
	Degree deg;
	
	
	public Gui(Planner p, CourseCatalog c, Degree d){
		cc = c;
		deg = d;
		
		//Creating the menu
		menuBar.add(newMenu);
		menuBar.add(saveMenu);
		menuBar.add(loadMenu);
		saveMenu.add(saveCourses);
		saveMenu.add(saveStudent);
		loadMenu.add(loadCourses);
		loadMenu.add(loadStudent);
		newMenu.add(newStudent);
		
		
		
		//Creates the JFrame and it's features
		frame = new JFrame("Academic Planner");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 800);
		frame.setLayout(new BorderLayout());
		frame.setResizable(false);
		frame.setJMenuBar(menuBar);
		
		aFrame = new JFrame("Administrator Window");
		aFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		aFrame.setSize(300, 300);
		aFrame.setLayout(new BorderLayout());
		aFrame.setResizable(false);
		

		
		//Set layouts
		plan.setLayout(new BoxLayout(plan, BoxLayout.Y_AXIS));
		gpaInfo.setLayout(new GridLayout(3,2,10,10));
		requirementsMain.setLayout(new GridLayout(5,2));
		startButtons.setLayout(new FlowLayout());
		degreePanel.setLayout(new BoxLayout(degreePanel, BoxLayout.Y_AXIS));
		transcriptPanel.setLayout(new BoxLayout(transcriptPanel, BoxLayout.Y_AXIS));
		posPanel.setLayout(new BoxLayout(posPanel, BoxLayout.Y_AXIS));
		preReqPanel.setLayout(new BoxLayout(preReqPanel, BoxLayout.Y_AXIS));
		textAreaPanel.setLayout(new BoxLayout(textAreaPanel, BoxLayout.Y_AXIS));
		optionsPanel.setLayout(new BoxLayout(optionsPanel, BoxLayout.Y_AXIS));
		adminCourse.setLayout(new GridLayout(6,2));
		adminHome.setLayout(new FlowLayout());
		adminDegree.setLayout(new GridLayout(4,2));

		
		
		
		//Gets the user's first name
		while(flag1 == true){
			flag1 = false;
			firstName = JOptionPane.showInputDialog("Please enter your first name");
			if(firstName.length() < 2){
				flag1 = true;
			}
		}
		
		user.setFirstName(firstName);
		
		
		//Gets the user's last name
		while(flag2 == true){
			flag2 = false;
			lastName = JOptionPane.showInputDialog("Please enter your last name");
			if(lastName.length() < 2){
				flag2 = true;
			}
		}
		
		user.setLastName(lastName);
	
		//Gets the user's student number
		while(studentNum <= 0){	
		stringNum = JOptionPane.showInputDialog("Please enter your student number");
		
			try{
				studentNum = Integer.parseInt(stringNum);  
			}
			catch(NumberFormatException e){
				studentNum = -1;
			}
		}
		
		studentInteger = new Integer(studentNum);
		user.setStudentNumber(studentInteger);
		
		stats = new JTextArea(user.getFirstName() + "\t" + stringNum + "\t" + user.getLastName());
		
		//*******************Add action Listeners*******************
		newStudent.addActionListener(ev->{
			flag1 = true;
			flag2 = true;
			studentNum = -1;
			//Gets the user's first name
			while(flag1 == true){
				flag1 = false;
				firstName = JOptionPane.showInputDialog("Please enter your first name");
				if(firstName.length() < 2){
					flag1 = true;
				}
			}
			
			user.setFirstName(firstName);
			
			
			//Gets the user's last name
			while(flag2 == true){
				flag2 = false;
				lastName = JOptionPane.showInputDialog("Please enter your last name");
				if(lastName.length() < 2){
					flag2 = true;
				}
			}
			
			user.setLastName(lastName);
		
			//Gets the user's student number
			while(studentNum <= 0){	
			stringNum = JOptionPane.showInputDialog("Please enter your student number");
			
				try{
					studentNum = Integer.parseInt(stringNum);  
				}
				catch(NumberFormatException e){
					studentNum = -1;
				}
			}
			
			studentInteger = new Integer(studentNum);
			user.setStudentNumber(studentInteger);
			
			stats.setText(user.getFirstName() + "\t" + stringNum + "\t" + user.getLastName());
			frame.pack();
			cc.removeAllAttempts();
			deg = null;
		});
		//Opens course screen
		courseButton.addActionListener(ev->
		{
			courses();
		});
		
		//Opens plan of study screen
		posButton.addActionListener(ev->
		{
			planOfStudy();	
		});
		
		//to go back to start
		backStart.addActionListener(ev->
		{
			start();
		});
		
		//Back to POS screen
		backPOS.addActionListener(ev->{
			planOfStudy();
		});
		
		//Load courses into the system
		loadCourses.addActionListener(ev->{
			 try {
				cc.initializeCatalog("CourseListA2.txt");
			} catch (IOException e) {
				JOptionPane.showMessageDialog(new JFrame(), "File Not Found", "Error", JOptionPane.ERROR_MESSAGE);

			}
		});
		
		//Quit button
		quit.addActionListener(ev->{
			String options[] = {"Yes","Cancel"};
			int option = JOptionPane.showOptionDialog(null, "Are you sure you want to exit?", "Quit?", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[1]);			
			if(option == JOptionPane.YES_OPTION){
				System.exit(0);
			}
		});
		
		//Loads a plan of study into the system
		loadStudent.addActionListener(ev->{
			fileName = JOptionPane.showInputDialog("Please enter the file name");
			String line = "";
			String lineHolder[];
			int readLine = 0;
			boolean exists = false;
			Course tempCourse = null;
			
			try {
				BufferedReader br = new BufferedReader(new FileReader(fileName));
				cc.removeAllAttempts();
				deg = null;
				line = br.readLine();
				while(line != null){
					readLine++;
					if(readLine == 1){
						lineHolder = line.split(",");
						user.setFirstName(lineHolder[0]);
						user.setLastName(lineHolder[1]);
						stringNum = lineHolder[2];
						user.setStudentNumber(new Integer(stringNum));
						stats.setText(user.getFirstName() + "\t" + stringNum + "\t" + user.getLastName());

					}
					if(readLine == 2){
						if(!(line.equals("none"))){
							if(line.equals("Computer Science Honours")){
								deg = new CS(cc);
							}
							if(line.equals("Software Engineering")){
								deg = new SEng(cc);
							}
							if(line.equals("Bachelor of Computing General")){
								deg = new BCG(cc);
							}
						}
					}
					if(readLine > 2){
						lineHolder = line.split(",");
						for(Course x : cc.getCatalog()){
							if(x.getCourseCode().equals(lineHolder[0])){
								exists = true;
								tempCourse = x;
							}
						}
						if(exists == false){
							tempCourse = new Course(lineHolder[0]);
						}
						
						if(lineHolder.length == 2){
							cc.addAttempt(tempCourse,lineHolder[1]);
						}
						else{
							cc.addAttempt(tempCourse,lineHolder[1], lineHolder[2]);

						}
						
					}
					line = br.readLine();

				}
				br.close();
			} catch (FileNotFoundException e) {
				JOptionPane.showMessageDialog(new JFrame(), "File could not be found", "Error", JOptionPane.ERROR_MESSAGE);
			}
			catch(IOException e){
				
			}

		});
		
		//Saves current courses
		saveCourses.addActionListener(ev->{
			File fp = new File("CourseListA2.txt");
			ArrayList<Course>required = null;
			Course tempCourse = null;
			try{
				FileWriter fw = new FileWriter(fp);
				for(Course x : cc.getCatalog()){
					fw.write(x.getCourseCode() + "," + x.getCourseCredit() + "," + x.getCourseTitle() + "," + x.getSemesterOffered() + ",");
					required = x.getPrerequisites();
					if((required != null)&&(!required.isEmpty())){
						tempCourse = required.get(required.size()-1);
						for(Course y : required){
							if(tempCourse == y){
								fw.write(y.getCourseCode());
							}
							else{
								fw.write(y.getCourseCode() + ":");
							}
						}	
					}
					fw.write("\n");
				}
				
				fw.close();
			}
			catch(IOException e){
				
			}
		});
		
		//Saves current student
		saveStudent.addActionListener(ev->{
			String fileName;
			Course tempCourse = null;
			fileName = user.getFirstName() + user.getLastName() + stringNum + ".txt";
			File fp = new File(fileName);
			try {
				FileWriter fw = new FileWriter(fp);
				
				fw.write(user.getFirstName() + "," + user.getLastName() + "," + stringNum + "\n");
				if(deg != null){
				fw.write(deg.getMajor() + "\n");
				}
				else{
					fw.write("none\n");
				}
				
				for(Attempt x : cc.getAttempts()){
					tempCourse = x.getCourseAttempted();
					fw.write(tempCourse.getCourseCode() + "," + x.getSemesterTaken() + ",");
					if(x.getAttemptGrade() != null){
						fw.write(x.getAttemptGrade() + "\n");
					}
					else{
						fw.write("\n");
					}
				}
				
			fw.close();
			
			} catch (IOException e) {
			}
			
		});
		
		//Opens GPA screen
		gpaButton.addActionListener(ev->{
			gpa();
		});
		
		//Opens requirements screen
		requirementsButton.addActionListener(ev->{
			requirements();
		});
		
		//Opens course plan screen
		coursePlanButton.addActionListener(ev->{
			coursePlan();
		});
		
		//Display all of the required courses not found in student's POS
		notInPOS.addActionListener(ev->{
			boolean check = false;
			Course temp = null;
			rc.setText("");
			if(deg != null){				
				//Compares all attempted courses with o grade with
				//the required ones to check if it's in POS
				for(Course x : deg.getRequiredCourses()){
					check = false;
					for(Attempt y: cc.getAttempts()){
						temp = y.getCourseAttempted();
						if(temp.getCourseCode().equalsIgnoreCase(x.getCourseCode())){
							if(y.getAttemptGrade() == null){
								check = true;
							}
						}
					}
					if(check == false){
						rc.append(x.getCourseCode() + "\n");
					}
				}
			}
			else{
				rc.append("No Degree Selected\n");
			}
			
		});
		
		//Display all of the required courses not found in student's transcript
		notInTranscript.addActionListener(ev->{
			boolean check = false;
			Course temp = null;
			rc.setText("");
			if(deg != null){				
				//Compares all attempted courses with no grade with
				//the required ones to check if it's in POS
				for(Course x : deg.getRequiredCourses()){
					check = false;
					for(Attempt y: cc.getAttempts()){
						temp = y.getCourseAttempted();
						if(temp.getCourseCode().equalsIgnoreCase(x.getCourseCode())){
							if(y.getAttemptGrade() != null){
								check = true;
							}
						}
					}
					if(check == false){
						rc.append(x.getCourseCode() + "\n");
					}
				}
			}
			else{
				rc.append("No Degree Selected\n");
			}
		});
		
		degreeButton.addActionListener(ev->{
			selectDegree();
		});
		
		//Button clicked to select Degree
		degreeChoice.addActionListener(ev->{
			String choice = degrees.getSelectedItem().toString();
			if(choice.equals("B.Comp")){
				majors.removeAllItems();
				majors.addItem("Computer Science Honours");
				majors.addItem("Software Engineering");
				selectMText.setVisible(true);
				majors.setVisible(true);
				majorChoice.setEnabled(true);
				frame.pack();
			}
			else if(choice.equals("BCG")){
				majors.removeAllItems();
				majors.setVisible(true);
				majors.addItem("Bachelor of Computing General");
				selectMText.setVisible(true);
				majorChoice.setEnabled(true);
				frame.pack();
			}
			else{
				majors.removeAllItems();
				majors.setVisible(false);
				majorChoice.setEnabled(false);
				selectMText.setVisible(false);
				frame.pack();
			}
		});
		
		//Button to select the major
		majorChoice.addActionListener(ev->{
			String choice = majors.getSelectedItem().toString();
			if(choice.equals("Bachelor of Computing General")){
				deg = new BCG(cc);
				courses();
			}
			else if(choice.equals("Computer Science Honours")){
				deg = new CS(cc);
				courses();
			}
			else if(choice.equals("Software Engineering")){
				deg = new SEng(cc);
				courses();
			}
			
		});
		
		maintainButton.addActionListener(ev->{
			selectCourses();
		});
		
		//Button to send you to page containing all courses in transcript
		transcript.addActionListener(ev->{
			transcriptCourses();
		});
		
		//Button to send you to page containing all courses in plan of study
		planofstudy.addActionListener(ev->{
			posCourses();
		});
		
		backCourses.addActionListener(ev->{
			courses();
		});
		
		backCourseType.addActionListener(ev->{
			selectCourses();
		});
		
		//Button to load the chosen semester's courses
		loadSem.addActionListener(ev->{
			so.setText("");
			String sem = semList.getSelectedItem().toString();
			for(Attempt x : cc.getAttempts()){
				Course tempCourse = x.getCourseAttempted();
				if(x.getSemesterTaken().equalsIgnoreCase(sem)){
					so.append(tempCourse.getCourseCode() + "\n");
				}
			}
			
		});
		
		//Adds course to plan of study
		pAdd.addActionListener(ev->{
			boolean courseFlag = true;
			boolean semFlag = false;
			boolean exists = false;
			String sem = "";
			String course = "";
			Course tempCourse = null;
			sem = pSemTaken.getText();
			course = pCourseCode.getText();
			
			if(sem.length() != 3){
				semFlag = true;
			}
			if(sem.length() == 3){
				if(!((sem.substring(0, 1).equalsIgnoreCase("W"))||(sem.substring(0, 1).equalsIgnoreCase("F")))){
					semFlag = true;
				}
			
				try{
					Integer.parseInt(sem.substring(1));
				}
				catch(NumberFormatException e){
					semFlag = true;
				}
			}
			if(cc.getCatalog() != null){
				for(Course x : cc.getCatalog()){
					if(x.getCourseCode().equalsIgnoreCase(course)){
						tempCourse = x;
						courseFlag = false;
					}
				}		
			}
			if((semFlag == false)&&(courseFlag == false)){
				for(Attempt y : cc.getAttempts()){
					Course temp = y.getCourseAttempted();
					if(y.getAttemptGrade() == null){
						if(temp.getCourseCode().equals(tempCourse.getCourseCode())){
							if(y.getSemesterTaken().equals(sem)){
								exists = true;
							}
						}
					}
				}
				if(exists == false){
					if((tempCourse.getSemesterOffered().equalsIgnoreCase("B"))||(tempCourse.getSemesterOffered().equalsIgnoreCase(sem.substring(0,1)))){
						cc.addAttempt(tempCourse, sem);
					}
					else{
						JOptionPane.showMessageDialog(new JFrame(), "Course not offered this semester", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
				else{
					JOptionPane.showMessageDialog(new JFrame(), "Course with these parameters already exists", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
			else{
				JOptionPane.showMessageDialog(new JFrame(), "Input Error", "Error", JOptionPane.ERROR_MESSAGE);
			}
			posCourses();
		});
		
		//Removing course from plan of study
		pRemove.addActionListener(ev->{	
			boolean courseFlag = true;
			boolean semFlag = false;
			String sem = "";
			String course = "";
			Course tempCourse = null;
			Attempt toRemove = null;
			sem = pSemTaken.getText();
			course = pCourseCode.getText();
			if(sem.length() != 3){
				semFlag = true;
			}
			if(sem.length() == 3){
				if(!((sem.substring(0, 1).equalsIgnoreCase("W"))||(sem.substring(0, 1).equalsIgnoreCase("F")))){
					semFlag = true;
				}
			
				try{
					Integer.parseInt(sem.substring(1));
				}
				catch(NumberFormatException e){
					semFlag = true;
				}
			}
			if(cc.getAttempts() != null){
				for(Attempt x : cc.getAttempts()){
					tempCourse = x.getCourseAttempted();
					if(tempCourse.getCourseCode().equalsIgnoreCase(course)){
						if(x.getSemesterTaken().equals(sem)){
							if(x.getAttemptGrade() == null){
								toRemove = x;
								courseFlag = false;
							}
						}
					}
				}		
			}
			if((semFlag == false)&&(courseFlag == false)){
				
				cc.removeAttempt(toRemove);
			}
			else{
				JOptionPane.showMessageDialog(new JFrame(), "Something went wrong", "Error", JOptionPane.ERROR_MESSAGE);
			}
			posCourses();
			
			
		});
		
		//Adds course to Transcript
		tAdd.addActionListener(ev->{
			boolean courseFlag = true;
			boolean semFlag = false;
			boolean exists = false;
			String sem = "";
			String course = "";
			Course tempCourse = null;
			sem = tSemTaken.getText();
			course = tCourseCode.getText();
			
			if(sem.length() != 3){
				semFlag = true;
			}
			if(sem.length() == 3){
				if(!((sem.substring(0, 1).equalsIgnoreCase("W"))||(sem.substring(0, 1).equalsIgnoreCase("F")))){
					semFlag = true;
				}
			
				try{
					Integer.parseInt(sem.substring(1));
				}
				catch(NumberFormatException e){
					semFlag = true;
				}
			}
			if(cc.getCatalog() != null){
				for(Course x : cc.getCatalog()){
					if(x.getCourseCode().equalsIgnoreCase(course)){
						tempCourse = x;
						courseFlag = false;
					}
				}		
			}
			if((semFlag == false)&&(courseFlag == false)){
				String grade;
				do{
					grade = JOptionPane.showInputDialog("Enter the course grade");
					try{
						Double.parseDouble(grade);
					}
					catch(NumberFormatException e){
						grade = "-1";
					}
				}while(Double.parseDouble(grade) < 0);
				
				for(Attempt y : cc.getAttempts()){
					Course temp = y.getCourseAttempted();
					if(y.getAttemptGrade() != null){
						if(y.getSemesterTaken().equals(sem)){
							if(temp.getCourseCode().equals(tempCourse.getCourseCode())){
								exists = true;
							}
						}
						
					}
				}
				
				if(exists == false){
					if((tempCourse.getSemesterOffered().equalsIgnoreCase("B"))||(tempCourse.getSemesterOffered().equalsIgnoreCase(sem.substring(0,1)))){
						cc.addAttempt(tempCourse, sem, grade);

					}
					else{
						JOptionPane.showMessageDialog(new JFrame(), "Course not offered this semester", "Error", JOptionPane.ERROR_MESSAGE);

					}

				}
				else{
					JOptionPane.showMessageDialog(new JFrame(), "Course with these parameters already exists", "Error", JOptionPane.ERROR_MESSAGE);

				}
			}
			else{
				JOptionPane.showMessageDialog(new JFrame(), "Input Error", "Error", JOptionPane.ERROR_MESSAGE);
			}
			transcriptCourses();
		});
		
		//Changes grade when clicked
		change.addActionListener(ev->{
			boolean courseFlag = true;
			boolean semFlag = false;
			String sem = "";
			String course = "";
			Attempt attemptTemp = null;
			sem = tSemTaken.getText();
			course = tCourseCode.getText();
			
			if(sem.length() != 3){
				semFlag = true;
			}
			if(sem.length() == 3){
				if(!((sem.substring(0, 1).equalsIgnoreCase("W"))||(sem.substring(0, 1).equalsIgnoreCase("F")))){
					semFlag = true;
				}
			
				try{
					Integer.parseInt(sem.substring(1));
				}
				catch(NumberFormatException e){
					semFlag = true;
				}
			}
			if(cc.getCatalog() != null){
				for(Attempt x : cc.getAttempts()){
					Course checkCourse = x.getCourseAttempted();
					if(checkCourse.getCourseCode().equalsIgnoreCase(course)){
						if(x.getSemesterTaken().equalsIgnoreCase(sem)){
							attemptTemp = x;
							courseFlag = false;
						}
					}
				}		
			}
			if((semFlag == false)&&(courseFlag == false)){
				String grade;
				do{
					grade = JOptionPane.showInputDialog("Enter the course grade");
					try{
						Double.parseDouble(grade);
					}
					catch(NumberFormatException e){
						grade = "-1";
					}
				}while(Double.parseDouble(grade) < 0);
				attemptTemp.setAttemptGrade(grade);
			}
			else{
				JOptionPane.showMessageDialog(new JFrame(), "Input Error", "Error", JOptionPane.ERROR_MESSAGE);
			}
			transcriptCourses();
		});
		
		//Sends to page containing prerequisite courses
		requiredButton.addActionListener(ev->{
			preReqScreen();
		});
		
		//Loads the selected required course's prerequisites
		loadReqPreReq.addActionListener(ev->{
			reqPreReq.setText("");
			if(deg != null){
			String chosen = requiredCourse.getSelectedItem().toString();
				for(Course x: deg.getRequiredCourses()){
					if(x.getCourseCode().equalsIgnoreCase(chosen)){
						for(Course y : x.getPrerequisites()){
							reqPreReq.append(y.getCourseCode() + "\n");
						}
					}
				}
			}
			else{
				reqPreReq.setText("No Degree has been chosen yet");
			}
			
		});
		
		adminDegreeMenu.addActionListener(ev->{
			degreeEditor();
		});
		
		adminCourseMenu.addActionListener(ev->{
			courseEditor();
		});
		
		adminBackHome.addActionListener(ev->{
			adminHomeScreen();
		});
		
		editCourse.addActionListener(ev->{
			boolean flag = false;
			boolean found = false;
			boolean foundReq = false;
			ArrayList<Course>prereqList = new ArrayList<>();
			String code = adminCode.getText();
			String title = adminTitle.getText();
			String sem = adminSem.getText();
			String credits = adminWeight.getText();
			String prereq = adminPreReq.getText();
			prereq.replaceAll(" ", "");
			
			if(code.equals("")){
				flag = true;
			}
			if(title.equals("")){
				flag = true;
			}
			if(sem.length() != 1){
				flag = true;
			}
			if(!((sem.equalsIgnoreCase("F"))||(sem.equalsIgnoreCase("W"))||(sem.equalsIgnoreCase("B")))){
				flag = true;
			}
			
			if(flag = false){
				String array[] = prereq.split(",");
				for(int i = 0; i < array.length; i++){
					foundReq = false;
					for(Course y : cc.getCatalog()){
						if(y.getCourseCode().equals(array[i])){
							foundReq = true;
							prereqList.add(y);
						}
					}
					if(foundReq == false){
						prereqList.add(new Course(array[i]));
					}
				}
				
				
				for(Course x : cc.getCatalog()){
					if(code.equalsIgnoreCase(x.getCourseCode())){
						found = true;
						x.setCourseCode(code);
						x.setCourseCredit(Double.parseDouble(credits));
						x.setCourseTitle(title);
						x.setSemesterOffered(sem);
						x.setPrerequisites(prereqList);
						
					}
				}
				if(found == false){
					cc.addCourse(new Course(title, code, sem, Double.parseDouble(credits), prereqList));
				}
				
				
			}
			else{
				JOptionPane.showMessageDialog(new JFrame(), "Something Went Wrong!", "Error", JOptionPane.ERROR_MESSAGE);;
			}
			
			
		});
		
		removeCourse.addActionListener(ev->{
			boolean found = false;
			String code = adminCode.getText();
			if(code.equals("")){
				for(Course x : cc.getCatalog()){
					if(code.equalsIgnoreCase(x.getCourseCode())){
						found = true;
						x = null;
					}
				}
			
				if(found == false){
					JOptionPane.showMessageDialog(new JFrame(), "Could not find course", "Error", JOptionPane.ERROR_MESSAGE);;
				}
			}
			else{
				JOptionPane.showMessageDialog(new JFrame(), "Need Course Code Input", "Error", JOptionPane.ERROR_MESSAGE);;
			}
		});
		
		//********************End Action Listeners*******************
		so.setEditable(false);
		selectMText.setEditable(false);
		selectDText.setEditable(false);
		reqPreReq.setEditable(false);
		preReq.setEditable(false);
		loc.setEditable(false);
		stats.setEditable(false);		
		
		selectDText.setText("Select your desired degree:");
		selectMText.setText("Select your desired Major:");
		
		overallGPA.setEditable(false);
		tenGPA.setEditable(false);
		cisGPA.setEditable(false);
		rc.setEditable(false);
		metRequirements.setEditable(false);
		creditsNeeded.setEditable(false);
		creditsComplete.setEditable(false);
		creditsRemaining.setEditable(false);
		
		//Add widgets to panels and frame
		gpaInfo.add(overallLabel);
		gpaInfo.add(overallGPA);
		gpaInfo.add(tenLabel);
		gpaInfo.add(tenGPA);
		gpaInfo.add(cisLabel);
		gpaInfo.add(cisGPA);

		requirementsMain.add(metRequirementsLabel);
		requirementsMain.add(metRequirements);
		requirementsMain.add(creditsRemainingLabel);
		requirementsMain.add(creditsRemaining);
		requirementsMain.add(creditsCompleteLabel);
		requirementsMain.add(creditsComplete);
		requirementsMain.add(creditsNeededLabel);
		requirementsMain.add(creditsNeeded);
		requirementsMain.add(notInPOS);
		requirementsMain.add(notInTranscript);
		
		optionsPanel.add(requiredCourse);
		optionsPanel.add(loadReqPreReq);
		
		textAreaPanel.add(reqRequiredLabel);
		textAreaPanel.add(rPR);
		textAreaPanel.add(posRequiredLabel);
		textAreaPanel.add(pR);

		preReqPanel.add(optionsPanel);
		preReqPanel.add(textAreaPanel);
		
		adminHome.add(adminDegreeMenu);
		adminHome.add(adminCourseMenu);

		adminCourse.add(adminCode);
		adminCourse.add(adminCodeLabel);
		adminCourse.add(adminTitle);
		adminCourse.add(adminTitleLabel);
		adminCourse.add(adminSem);
		adminCourse.add(adminSemLabel);
		adminCourse.add(adminWeight);
		adminCourse.add(adminWeightLabel);
		adminCourse.add(adminPreReq);
		adminCourse.add(adminPreReqLabel);
		adminCourse.add(editCourse);
		adminCourse.add(removeCourse);

		adminDegree.add(adminDegreeTitle);
		adminDegree.add(adminDegreeTitleLabel);
		adminDegree.add(adminReqCred);
		adminDegree.add(adminReqCredLabel);
		adminDegree.add(adminMajor);
		adminDegree.add(adminMajorLabel);
		adminDegree.add(adminEditDegree);
		adminDegree.add(adminRemoveDegree);

		
		degreePanel.add(selectDText);
		degreePanel.add(degrees);
		degreePanel.add(degreeChoice);
		degreePanel.add(selectMText);
		degreePanel.add(majors);
		degreePanel.add(majorChoice);
		selectMText.setVisible(false);
		majors.setVisible(false);
		majorChoice.setEnabled(false);
		
		courseTypePanel.add(transcript);
		courseTypePanel.add(planofstudy);
		
		plan.add(semList);
		plan.add(semOutline);
		plan.add(loadSem);
		
		posOptions.add(coursePlanButton);
		posOptions.add(requirementsButton);
		posOptions.add(gpaButton);

		transcriptPanel.add(change);
		transcriptPanel.add(tRemove);
		transcriptPanel.add(tCode);
		transcriptPanel.add(tCourseCode);
		transcriptPanel.add(tSem);
		transcriptPanel.add(tSemTaken);
		transcriptPanel.add(tAdd);
		
		posPanel.add(pCodeLabel);
		posPanel.add(pCourseCode);
		posPanel.add(pSemLabel);
		posPanel.add(pSemTaken);
		posPanel.add(pAdd);
		posPanel.add(pRemove);
		
		courseOptions.add(maintainButton);
		courseOptions.add(degreeButton);
		courseOptions.add(requiredButton);
		
		userStats.add(stats);
		
		startButtons.add(courseButton);
		startButtons.add(posButton);
		
		frame.add(userStats, BorderLayout.NORTH);
		start();
		adminHomeScreen();
		
		frame.pack();
		frame.setVisible(true);
		aFrame.setVisible(true);
		
	}//close Gui method
	
	
	public void start(){
		//set things you don't need invisible
		backStart.setVisible(false);
		courseOptions.setVisible(false);
		posOptions.setVisible(false);

		//set things you do need visible
		startButtons.setVisible(true);
		quit.setVisible(true);

		frame.add(startButtons, BorderLayout.CENTER);
		frame.add(quit, BorderLayout.SOUTH);
		frame.pack();

	}
	
	
	public void planOfStudy(){
		//set things you don't need invisible
		startButtons.setVisible(false);
		quit.setVisible(false);
		courseOptions.setVisible(false);
		backPOS.setVisible(false);
		gpaInfo.setVisible(false);
		requirementsMain.setVisible(false);
		requiredCourses.setVisible(false);
		plan.setVisible(false);


				
		//set things you do need visible
		backStart.setVisible(true);
		posOptions.setVisible(true);
		
		frame.add(posOptions, BorderLayout.CENTER);
		frame.add(backStart, BorderLayout.SOUTH);
		frame.pack();

	}
	
	public void courses(){
		//set things you don't need invisible
		startButtons.setVisible(false);
		quit.setVisible(false);
		posOptions.setVisible(false);
		degreePanel.setVisible(false);
		courseTypePanel.setVisible(false);
		backCourses.setVisible(false);
		preReqPanel.setVisible(false);
				
		//set things you do need visible
		backStart.setVisible(true);
		courseOptions.setVisible(true);
		
		frame.add(courseOptions, BorderLayout.CENTER);
		frame.add(backStart, BorderLayout.SOUTH);
		frame.pack();

	}
	
	public void gpa(){
		ArrayList<Attempt> courseArray = new ArrayList<>();
		int totalCourses = 0;
		int cisCourses = 0;
		int tenCount = 0;
		double overall = 0;
		double ten = 0;
		double cis = 0;
		
		for(Attempt x : cc.getAttempts()){
			Course tempCourse = x.getCourseAttempted();
			if(x.getAttemptGrade()!= null){
				totalCourses++;
				overall = overall + Double.parseDouble(x.getAttemptGrade());
				if(tempCourse.getCourseCode().substring(0,3).equalsIgnoreCase("CIS")){
					cisCourses++;
					cis = cis + Double.parseDouble(x.getAttemptGrade());
				}
				if(tenCount < 10){
					courseArray.add(x);
					tenCount++;
				}
				else{
					Attempt lowest = null;
					for(Attempt y : courseArray){
						if(lowest == null){
							lowest = y;
						}
						else{
							if(Integer.parseInt(y.getSemesterTaken().substring(1,3)) < Integer.parseInt(lowest.getSemesterTaken().substring(1, 3))){
								lowest = y;
							}
							else if(Integer.parseInt(y.getSemesterTaken().substring(1,3)) == Integer.parseInt(lowest.getSemesterTaken().substring(1, 3))){
								if(y.getSemesterTaken().substring(0,1).equals("F")&&lowest.getSemesterTaken().substring(0,1).equals("W")){
									lowest = y;
								}
							}

						}
					}
					
					if(Integer.parseInt(x.getSemesterTaken().substring(1,3)) > Integer.parseInt(lowest.getSemesterTaken().substring(1, 3))){
						courseArray.remove(lowest);
						courseArray.add(x);
					}

				}
				
				
			}
		}
		
		if(totalCourses > 0){
			overall = overall/totalCourses;
		}
		if(cisCourses > 0){
			cis = cis/cisCourses;
		}
		if(courseArray != null){
			for(Attempt y : courseArray){
				ten = ten + Double.parseDouble(y.getAttemptGrade());

			}
		}
		if(tenCount > 0){
			ten = ten/tenCount;
		}
		
		//set things you don't need invisible
		backStart.setVisible(false);
		posOptions.setVisible(false);
		
		//set things you do need visible
		backPOS.setVisible(true);
		gpaInfo.setVisible(true);
		
		frame.add(gpaInfo, BorderLayout.CENTER);
		frame.add(backPOS, BorderLayout.SOUTH);

		overallGPA.setText(two.format(overall) + "%");
		tenGPA.setText(two.format(ten) + "%");
		cisGPA.setText(two.format(cis) + "%");
		
		if(overall == 0){
			overallGPA.setText("0%");
		}
		if(ten == 0){
			tenGPA.setText("0%");
		}
		if(cis == 0){
			cisGPA.setText("0%");
		}
		
		frame.pack();

		
		
	}
	
	public void coursePlan(){
		
		tempList.removeAllElements();
		for(Attempt x : cc.getAttempts()){
			String sem = x.getSemesterTaken();
			if(tempList.getIndexOf(sem) == -1){
				tempList.addElement(sem);
			}

		}
		
		//set things you don't need invisible
		backStart.setVisible(false);
		posOptions.setVisible(false);
		requirementsMain.setVisible(false);
		
		//set things you do need visible
		backPOS.setVisible(true);
		plan.setVisible(true);
		
		frame.add(plan, BorderLayout.CENTER);
		frame.add(backPOS, BorderLayout.SOUTH);
		frame.pack();

	}
	
	public void requirements(){
		double totalCredits = 0;
		double remainingCredits = 0;
		double posCredits = 0;
		if(!cc.getAttempts().isEmpty()){
			for(Attempt x: cc.getAttempts()){
				Course tempCourse = x.getCourseAttempted();
				if(x.getAttemptGrade()!= null){
					if(Double.parseDouble(x.getAttemptGrade()) > 50){
					totalCredits = totalCredits + tempCourse.getCourseCredit();
					}
				}
				else{
				posCredits = posCredits + tempCourse.getCourseCredit();
				}
			}
		}
		creditsComplete.setText(Double.toString(totalCredits));
		if(deg != null){
			remainingCredits = deg.getRequiredCredits() - totalCredits;
			if(remainingCredits < 0){
				remainingCredits = 0;
			}
			posCredits = remainingCredits - posCredits;
			if(posCredits < 0){
				posCredits = 0;
			}
			creditsRemaining.setText(Double.toString(remainingCredits));
			creditsNeeded.setText(Double.toString(posCredits));
			metRequirements.setText(String.valueOf(deg.meetsRequirements(cc.getCatalog())));
			
		}
		else{
			creditsRemaining.setText("N/A");
			creditsNeeded.setText("N/A");
			metRequirements.setText("N/A");
		}
		
		//set things you don't need invisible
		backStart.setVisible(false);
		posOptions.setVisible(false);
		
		//set things you do need visible
		backPOS.setVisible(true);
		requirementsMain.setVisible(true);
		requiredCourses.setVisible(true);
		
		frame.add(requirementsMain,BorderLayout.WEST);
		frame.add(requiredCourses,BorderLayout.CENTER);
		frame.add(backPOS, BorderLayout.SOUTH);
		frame.pack();
	}
	
	public void selectDegree(){
		//set things you don't need invisible
		backStart.setVisible(false);
		courseOptions.setVisible(false);
		selectMText.setVisible(false);
		majors.setVisible(false);
		majorChoice.setEnabled(false);
		
		
		//set things you do need visible
		degreePanel.setVisible(true);
		
		frame.add(degreePanel, BorderLayout.CENTER);
		frame.pack();
	}
	
	public void selectCourses(){
		//set things you don't need invisible
		backStart.setVisible(false);
		courseOptions.setVisible(false);
		transcriptPanel.setVisible(false);
		posPanel.setVisible(false);
		backCourseType.setVisible(false);
		listOfCourses.setVisible(false);

				
		//set things you do need visible
		courseTypePanel.setVisible(true);
		backCourses.setVisible(true);
		
		frame.add(courseTypePanel, BorderLayout.CENTER);	
		frame.add(backCourses, BorderLayout.SOUTH);
		frame.pack();

	}
	
	public void posCourses(){
		loc.setText("");
		if(cc.getAttempts() != null){
			for(Attempt x : cc.getAttempts()){
				Course tempCourse = x.getCourseAttempted();
				if(x.getAttemptGrade() == null){	
					loc.append(tempCourse.getCourseCode() + "\t" + x.getSemesterTaken() + "\n");
				}
			}
		}
		//set things you don't need invisible
		courseTypePanel.setVisible(false);
		backCourses.setVisible(false);

		//set things you do need visible
		posPanel.setVisible(true);
		backCourseType.setVisible(true);
		listOfCourses.setVisible(true);
		
		frame.add(listOfCourses, BorderLayout.CENTER);
		frame.add(posPanel, BorderLayout.EAST);
		frame.add(backCourseType, BorderLayout.SOUTH);
		frame.pack();
	}
	
	public void transcriptCourses(){
		loc.setText("");
		if(cc.getAttempts() != null){
			for(Attempt x : cc.getAttempts()){
				Course tempCourse = x.getCourseAttempted();
				if(x.getAttemptGrade()!= null){
					if(Double.parseDouble(x.getAttemptGrade()) > 0){
						loc.append(tempCourse.getCourseCode() + "\t" +x.getAttemptGrade() + "\t" + x.getSemesterTaken() + "\n");
					}
				}
			}
		}
		
		//set things you don't need invisible
		courseTypePanel.setVisible(false);
		backCourses.setVisible(false);

		//set things you do need visible
		transcriptPanel.setVisible(true);
		backCourseType.setVisible(true);
		listOfCourses.setVisible(true);

		frame.add(listOfCourses, BorderLayout.CENTER);
		frame.add(transcriptPanel, BorderLayout.EAST);
		frame.add(backCourseType, BorderLayout.SOUTH);
		frame.pack();
		
	}
	
	public void preReqScreen(){
		reqPreReq.setText("");
		requiredCourse.removeAll();
		if(deg !=null){
			for(Course x : deg.getRequiredCourses()){
				requiredCourse.addItem(x.getCourseCode());
			}
		}
		preReq.setText("");
		for(Attempt x : cc.getAttempts()){
			Course tempCourse = x.getCourseAttempted();
			if(x.getAttemptGrade() == null){
				preReq.append(tempCourse.getCourseCode() + ": ");
				if(tempCourse.getPrerequisites() != null){
					for(Course y: tempCourse.getPrerequisites()){
						preReq.append(y.getCourseCode() + " ");
					
					}
				}
				preReq.append("\n");
				
			}
		}
		
		//set things you don't need invisible
		backStart.setVisible(false);
		courseOptions.setVisible(false);
		
		//set things you do need visible
		preReqPanel.setVisible(true);
		backCourses.setVisible(true);

		frame.add(preReqPanel, BorderLayout.CENTER);
		frame.add(backCourses, BorderLayout.SOUTH);
		requiredCourse.setVisible(true);

		frame.pack();
		
	}
	
	//**************************Admin Methods**************************
	/**
	 * @param none
	 * @return void
	 * When invoked, this method will open up the start menu for the 
	 * administrator's screen. The menu will have two buttons, each
	 * one with an action listener attached so that other methods can
	 * be invoked and other screens may be accessed. When this method
	 * is called, all other administrator screens become invisible and
	 * the main menu is the only visible screen/panel remaining.
	 */
	public void adminHomeScreen(){
		adminBackHome.setVisible(false);
		adminCourse.setVisible(false);
		adminDegree.setVisible(false);
		
		adminHome.setVisible(true);
		
		aFrame.add(adminHome,BorderLayout.CENTER);
		aFrame.pack();
		
	}
	
	public void courseEditor(){
		adminHome.setVisible(false);
		
		adminBackHome.setVisible(true);
		adminCourse.setVisible(true);
		
		
		aFrame.add(adminCourse,BorderLayout.CENTER);
		aFrame.add(adminBackHome,BorderLayout.SOUTH);
		aFrame.pack();
	}
	
	public void degreeEditor(){
		adminHome.setVisible(false);
		
		adminDegree.setVisible(true);
		adminBackHome.setVisible(true);
		
		aFrame.add(adminDegree,BorderLayout.CENTER);
		aFrame.add(adminBackHome,BorderLayout.SOUTH);
		aFrame.pack();
	}
	
}//close Gui class
