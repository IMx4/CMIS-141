/*
 * File: CrimeDataRecords.java
 * Author: Edward Benzenberg
 * Date: 5/3/17
 * Purpose: extract data from csv file, convert parsed information to correct data type, 
 *          instantiate CrimeDataObjects and pass parsed data to objects, store objects in a List.
 */

/*required imports*/
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/* 
 * CrimeDataRecords class - manages all CSV data extraction
 *                              and build records
 */
public class CrimeDataRecords {

	// declare Objects
	private static BufferedReader fileIn; //BufferedReader to read csv file	
	private static List<CrimeDataObjects> dataRecords; // List to store CrimeDataObjects
	
	/* default constructor*/
	public CrimeDataRecords() {
				
	}
	
	/*
	 * compileData method - extract data from csv and pass to buidCrimeDataRecords
	 */
	public static void readData(){
	
		//declare variables
		String lineIn = null; // temporarily holds string from csv file
		
		//initialize objects
		UserInterface userFile;	
	
		try {	
			// instantiate Objects
			userFile = new UserInterface();
			fileIn = new BufferedReader(new FileReader(userFile.getFileToRead()));// get file path
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("File Not Found");
		}// end try/catch
		
		// instantiate List object
	    dataRecords = new ArrayList<CrimeDataObjects>();

	    try{    	   
			fileIn.readLine();// skip first line
			lineIn = fileIn.readLine();//read line and store temporary String
		   
			/*while loop to read all lines from CSV file*/
			while(lineIn != null){ //while the next line is not empty	
				
				//System.out.println(lineIn); uncomment to see data transfer in console
				
				String[] parsedData = lineIn.split(",");//split strings and store to String array
				buildCrimeDataObjects(parsedData); // call method and pass string array 
				lineIn = fileIn.readLine();// read next line and store to temporary String	
				
			}//end while loop
			
		} catch (IOException e) {
	    	e.printStackTrace();
	    }//end try/catch
	    
	}// end compileData method
	
	/*
	 * buildCrimeDataRecords - builds CrimeDataObjects and stores them in List dataRecords
	 */
	public static void buildCrimeDataObjects(String[] parsedData){
		String[] data = parsedData;
		
		// initialize object
		CrimeDataObjects csvRecord;
		
		// parse strings to correct data type
		int year = Integer.parseInt(data[0]);
		long poplulation = Long.parseLong(data[1]);
		long violentCrime = Long.parseLong(data[2]);
		float violentCrimeRate = Float.parseFloat(data[3]); 
	    int murderNonNegManslaughter = Integer.parseInt(data[4]);
	    float murderNonNegManslaughterRate = Float.parseFloat(data[5]);
	    int rape = Integer.parseInt(data[6]);
	    float rapeRate = Float.parseFloat(data[7]);
	    int robbery = Integer.parseInt(data[8]);
	    float robberyRate = Float.parseFloat(data[9]);
	    int aggravatedAssault = Integer.parseInt(data[10]);
	    float aggravatedAssaultRate = Float.parseFloat(data[11]);
	    int propertyCrime = Integer.parseInt(data[12]);
	    float propertyCrimeRate = Float.parseFloat(data[13]);
	    int burglery = Integer.parseInt(data[14]); 
	    float burgleryRate = Float.parseFloat(data[15]);
	    int larceny = Integer.parseInt(data[16]);
	    float larcenyRate = Float.parseFloat(data[17]);
	    int motorVehicleTheft = Integer.parseInt(data[18]);
	    float motorVehicleTheftRate = Float.parseFloat(data[19]);    
	    
	    // instantiate CrimeDataRecords object and pass data parsed from csv
	    csvRecord = new CrimeDataObjects(year,poplulation,violentCrime,violentCrimeRate,murderNonNegManslaughter,
	    		                         murderNonNegManslaughterRate,rape,rapeRate,robbery,robberyRate,
	    		                         aggravatedAssault,aggravatedAssaultRate,propertyCrime,propertyCrimeRate,
	    		                         burglery,burgleryRate,larceny,larcenyRate,motorVehicleTheft,motorVehicleTheftRate);  
	    
		dataRecords.add(csvRecord);// add csvRecord object to List
		
	}// end buildCrimeDataRecords
	

	/*
	 * getdataRecord method - returns data records as a List
	 *                        it is static since all instances use the same data
	 */
	public static List<CrimeDataObjects> getDataRecords(){	
		return dataRecords;
	}// end getDataRecors method
		
}// end Class
		
	
	

	

	
	
	
	
	
	
	
	


