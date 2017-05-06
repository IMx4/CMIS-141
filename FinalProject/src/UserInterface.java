
/*
 * File: UserInterface.java
 * Author: Edward Benzenberg
 * Date: 5/3/17
 * Purpose: To display user prompts and collect user input for the file path and selection
 * they make. Also starts and stops the timer for elapsed time.
 */

/*Required imports*/
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/* 
 * UserInterface class- creates all user prompts, collects user input and 
 * 						calls methods to display statistics selected.
 */
public class UserInterface {
	
	// declare variables
	private static String fileToRead = ""; //file path 
	private double startTime = 0.0; //timer start time
	private double endTime = 0.0; //timer end time
	private final String CLEANSPACE = "\n\n\n"; //used to create space in data output 
	Scanner input; 
	
	//default constructor
	public UserInterface(){	
	}
	
	// constructor with file path argument	
	public UserInterface(String filePath) {	
		setFileToRead(filePath);// call method to set file path
	}

	/* 
	 * getter method for fileToRead
	 */
	public String getFileToRead() {	
		return fileToRead;
	}
	
	/* 
	 * setter method for fileToRead
	 * re formats file path for specific OS.
	 */
	public void setFileToRead(String filePath) {
		
		// declare local variable
		String file = filePath;
		
		//get OS file separator an rebuild file path string
		char separator = java.io.File.separatorChar;//get system default file separator 
		if(separator != '/'){ // if file separator is not / (if Windows)
			String windowsFilePath = file.replace('/', '\\');
			filePath = windowsFilePath;
		}//end if separator != '\'
		
		// set fileToRead variable with file path
		fileToRead  = file;
			
	}// end setFileToRead method
	
	
	/*
	 * setter method for startTime
	 */
	public void setStartTime() {
		this.startTime = System.nanoTime();
	}// end setStartTime method
	
	/*
	 * getter method for startTime
	 */
	public double getStartTime() { 
		return startTime;
	}// end getStartTime method
	
	/*
	 * setter method for endTime
	 */
	public void setEndTime() {
		this.endTime = System.nanoTime();
	}// end setEndTime method
	
	/*
	 * getter method for endTime
	 */
	public double getEndTime() { 
		return endTime;
	}// end getEndTime method
	
	/*
	 * initialize method - initializes the user interface
	 */
	public void intitialize() {
		
		welcomePrompt();
		
		//initialize Scanner object
		input = new Scanner(System.in);
		setFileToRead(input.nextLine());//set file to read from user input
		
		//check if file exist
		File file = new File(getFileToRead()); // instantiate File object and pass it file path
		if(file.exists()){ // if file exists
			setStartTime(); // set start time
			menu();	// call selection menu
		}else{ // if file does not exist
			System.out.println("\n**File does not exist**");
			System.out.println("1). Enter 'Q' to Quit");
			System.out.println("2). Enter any charachter to re enter file path");
			System.out.print("Enter your selection: ");
			
			if(input.next().toUpperCase().compareTo("Q") != 0){ // user does not quit
				intitialize(); // call initialize method to re enter file path	
			}else{
				System.exit(0);
			}//end if
			
		}//end if
		input.close(); // close scanner
		
	}//end initialize method
	
	/*
	 * welcomeScreen method - displays initial welcome screen and user prompts
	 */
	public void welcomePrompt(){
		//user prompts
		System.out.println("\n*** Welcome to The US Crime Statistical Application***\n");
		System.out.println(" - Please enter the file path to start.");
		System.out.println(" - Please use / as path seperator: Example C:/user/file");
		System.out.print("File: ");
		
	}// end welcomePrompt method
	
	/*
	 * menu method - displays menu of options
	 */
	public void menu() {
		System.out.println(CLEANSPACE);
		System.out.println("******************** Welcome to The US Crime Statistical Application ********************");
		System.out.println("\n\nEnter the number of the question you want answered. Enter 'Q' to quit the program:\n");
		System.out.println("1. What were growth percentages in population growth for each consecutive year from 1994 - 2013?");
		System.out.println("2. What year was the Murder rate the highest?");
		System.out.println("3. What year was the Murder rate the lowest?");
		System.out.println("4. What year was the Robbery rate the highest?");
		System.out.println("5. What year was the Robbery rate the lowest?");
		System.out.println("Q. Quit the program");	
		System.out.print("\nEnter your selection: ");
		userSelection();//call user selection
	}// end menu method
	
	/*
	 * userSelection method - gets user input selection from menu items
	 */
	public void userSelection() {
		
		// declare variables
		String userInput; // holds user selection
		
		// initialize Scanner object
		input = new Scanner(System.in);
		
		userInput = input.next().toUpperCase(); // assign user input to variable
		statisticSelection(userInput); // pass user input to statisticSelection method 
		input.close(); // close scanner
		
	}//end userSelection method
	
	/*
	 * secondOptionSelection method - gets user input continue or quit prompt
	 * 								  that shows after first statistic is displayed
	 */
	public void optionToQuit() {
		
		//declare variables
		String userInput;
		
		//initialize scanner
		input = new Scanner(System.in);
		
		System.out.println("\nEnter 'C' for menu or 'Q' to quit");
		userInput = input.next().toUpperCase(); // get user selection
		
		//validate second option menu
		if(userInput.compareTo("C") == 0){ // if continue is selected
			menu(); // call menu to be displayed
		}else if (userInput.compareTo("Q") == 0){ // if quit is selected
			statisticSelection(userInput);// pass user selection to switch statement in statistic selection
		}else{ // if invalid entry
			System.out.println("**Invalid selection - Returning to menu**.\n\n\n\n");
			menu(); // call menu to be displayed
		}//end if
		input.close(); // close scanner
		
	}//end userSelection method
	
	/*
	 * statisticSelection method - takes the user input and calls the method to 
	 *                             display statistics	
	 */
	public void statisticSelection(String seclection){
		
		// declare variables
		boolean askContinue = false; //used to validate if continue or quit menu should be displayed
		
		// instantiate CrimeStatistic object 
		CrimeStatistics statistic = new CrimeStatistics();
		
		System.out.println(CLEANSPACE); //create space in output
		
		// switch statement to select correct statistic to be displayed
		switch(seclection){
			case "1":  ArrayList<String> growthRateChart = statistic.popGrowthRate(); // population growth rate chart
						for(String year : growthRateChart)
							System.out.println(year);
						askContinue = true;
						break;
			case "2": System.out.println(statistic.murderRateHigh()); // year of highest murder rate
						askContinue = true;
						break;
			case "3": System.out.println(statistic.murderRateLow()); // year of lowest murder rate
						askContinue = true;
						break;
			case "4": System.out.println(statistic.robberyRateHigh()); // year of highest robbery rate
						askContinue = true;
						break;
			case "5": System.out.println(statistic.robberyRateLow()); // year of lowest robbery rate
						askContinue = true;
						break;
			case "Q": 	setEndTime(); // user quits - set end time
						System.out.println(elsapsedTime()); //output elapsed time
						System.exit(0); // exit 
						break;
			case "C": menu(); // continue to menu of selections
						break;
			default: System.out.println("\n\n**Invalid Entry. Please re enter your selection**\n");	// if user makes invalid selection	
						menu(); // call selection menu
						break;
		}//end switch statement
		
		// if a statistic has been called then display continue or quit
		if(askContinue){ // if boolean has been triggered from statistic being selected
			optionToQuit(); // call continue or quit
			askContinue = false; //re set boolean
		}//end if
	}//end userInput method
	
	/*
	 * elapsedTime method - calculates and returns elapsed time
	 */
	public String elsapsedTime(){
		double time = (getEndTime() - getStartTime())/1000000000.0; // calculate elapsed time
		String elapsedTime = ("\n***Elapsed Time: " + Math.round(time) + " seconds***\n");
		elapsedTime += "***Thank you for using the US Crime Statistics Program***\n\n";
		
		return elapsedTime;
	}// end elapsedTime method
	
}// end userInterface Class
