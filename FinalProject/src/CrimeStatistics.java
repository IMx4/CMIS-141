/*
 * File: CrimeStatistics.java
 * Author: Edward Benzenberg
 * Date: 5/3/17
 * Purpose: to compile data into statistical information and 
 * display the data to the user
 */

/*required imports*/
import java.util.ArrayList;
import java.util.List;


/*
 * CrimeStatistics class - responsible for creating and
 *                         displaying statistical information
 */
public class CrimeStatistics {
	
	// instantiate List object - it is static since all instances will use the same data
	private static List<CrimeDataObjects> recordList = new ArrayList<CrimeDataObjects>(); 
	
	// constructor
	public CrimeStatistics() {
			
	}
	
	//static block to call compile data and fill List - used in all methods
	static{	
	CrimeDataRecords.readData();
	recordList = CrimeDataRecords.getDataRecords();
	}
	
	/*
	 * popGrowthRate method - compiles and displays population growth year to year
	 */
	public ArrayList<String> popGrowthRate () {
		
		//declare variables
		String tempYears; // temporarily holds year value
		double tempGrowth; //stores the growth percent
		String yearToYearGrowth;
		
		ArrayList<String> growthRateChart = new ArrayList<String>();//array to hold data from CrimeDataRecords
	
		// add header to array
		growthRateChart.add("**** Year to Year ****");
		growthRateChart.add("**** Growth Rates ****");
		growthRateChart.add("----------------------");

		for (int i = 0; i < recordList.size()-1; i++){ // Loop through List of CrimeDataObjects
			tempYears = Integer.toString(recordList.get(i).getYear()); // get year and store in variable
			tempYears += " - "; // add String to variable
			tempYears += Integer.toString(recordList.get(i+1).getYear());	// get next year and add to variable
			tempGrowth = (((recordList.get(i+1).getPoplulation() -        
					        recordList.get(i).getPoplulation()) /
					       (recordList).get(i).getPoplulation()))*100; // calculate growth and add to variable
				
			yearToYearGrowth = String.format("%s = %.4f%%" ,tempYears, tempGrowth);// form string for year to year growth
		    growthRateChart.add(yearToYearGrowth); // add string to arrayList	
		}// end for loop
		
		return growthRateChart;
	}// end popGrowthRate method
	
	/*
	* murderRateHigh method - outputs highest year and rate
	*/
	public String murderRateHigh () {
		
		// declare variables
		int year = 0;
		float highestRate = 0;
		String murderRateHigh = "\n**** Highest Murder Rate ****" +
				                "\n-----------------------------\n" +
				                "Year: ";
				
		year = recordList.get(0).getYear();// store year of first record
		highestRate = recordList.get(0).getMurderNonNegManslaughterRate();//store rate of first record
		
		// loop through records and compare rates
		for( int i = 1; i < recordList.size(); i++ ){			
			if(highestRate < recordList.get(i).getMurderNonNegManslaughterRate() ){ //if rate is higher
				year = recordList.get(i).getYear();// store year
				highestRate = recordList.get(i).getMurderNonNegManslaughterRate();//store rate
			}// end if	
		}// end for loop
		
		murderRateHigh += Integer.toString(year); //add year to string
		murderRateHigh += "  Murder Rate:";// add title to string
		murderRateHigh += Float.toString(highestRate);// add murder rate to string
		
		return murderRateHigh;
	}// end murderRateHigh method
	
	/* 
	 * murderRateLow method - outputs lowest year and rate
	 */
	public String murderRateLow () {
		
		// declare variables
				int year = 0;
				float highestRate = 0;
				String murderRateLow = "\n**** Lowest Murder Rate ****" +
						               "\n-----------------------------\n" +
						               "Year: ";
						
				year = recordList.get(0).getYear();// store year of first record
				highestRate = recordList.get(0).getMurderNonNegManslaughterRate();//store rate of first record
				// loop through records and compare rates
				for( int i = 1; i < recordList.size(); i++ ){	
					if(highestRate > recordList.get(i).getMurderNonNegManslaughterRate() ){ //if rate is lower
						year = recordList.get(i).getYear();// store year
						highestRate = recordList.get(i).getMurderNonNegManslaughterRate();//store rate
					}// end if	
				}// end for loop
				
				murderRateLow += Integer.toString(year); //add year to string
				murderRateLow += "  Murder Rate:";// add title to string
				murderRateLow += Float.toString(highestRate);// add murder rate to string
				//murderRateLow += yearLow;
				
				return murderRateLow;
		
	}// end murderRateLow method
	
	/*
	* robberyRateHigh method - outputs highest year and rate
	*/
	public String robberyRateHigh () {
		
		// declare variables
		int year = 0;
		float highestRate = 0;
		String robberyRateHigh = "\n**** Highest Robbery Rate ****" +
		                         "\n-----------------------------\n";
		
		year = recordList.get(0).getYear();// store year of first record
		highestRate = recordList.get(0).getRobberyRate();//store rate of first record
		
		// loop through records and compare rates
		for( int i = 1; i < recordList.size(); i++ ){	
			if(highestRate < recordList.get(i).getRobberyRate() ){ //if rate is higher
				year = recordList.get(i).getYear();// store year
				highestRate = recordList.get(i).getRobberyRate();//store rate
			}// end if	
		}// end for loop
		
		robberyRateHigh += Integer.toString(year); //add year to string
		robberyRateHigh += "  Robbery Rate:";// add title to string
		robberyRateHigh += Float.toString(highestRate);// add murder rate to string
		
		return robberyRateHigh;
	}// end robberyRateHigh method
	
	/*
	* robberyRateLow method - outputs lowest year and rate
	*/
	public String robberyRateLow () {
		
		// declare variables
		int year = 0;
		float highestRate = 0;
		String robberyRateLow = "\n**** Lowest Robbery Rate ****" +
				                "\n-----------------------------\n";
		
		year = recordList.get(0).getYear();// store year of first record
		highestRate = recordList.get(0).getRobberyRate();// store rate of first record

		// loop through records and compare rates
		for( int i = 1; i < recordList.size(); i++ ){			
			if(highestRate > recordList.get(i).getRobberyRate() ){ //if rate is lower
				year = recordList.get(i).getYear();// store year
				highestRate = recordList.get(i).getRobberyRate();//store rate
			}// end if	
		}// end for loop
		
		robberyRateLow += Integer.toString(year); //add year to string
		robberyRateLow += "  Robbery Rate:";// add title to string
		robberyRateLow += Float.toString(highestRate);// add murder rate to string
		
		return robberyRateLow;
	}// end robberyRateLow method

}// end CrimeStatistics class
