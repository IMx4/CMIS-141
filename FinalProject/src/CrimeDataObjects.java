/*
 * File: CrimeDataRecords.java
 * Author: Edward Benzenberg
 * Date: 5/3/17
 * Purpose: This class is used to build CrimeDataObjects that contain all the data parsed from one year of the csv file.
 *           - Objects contain data for all fields of the csv file, it is available for future expansion.
 *           - All getters are available for future expansion of more statistic options.
 */

/* 
 * CrimeDataObjects class - responsible for creation of CrimeData objects
 */
public class CrimeDataObjects {
	
	//declare variables
	private int year = 0; //year
	private double poplulation = 0; //population
	private long violentCrime = 0; //violent crime
	private float violentCrimeRate = 0; //violent crime rate
    private int murderNonNegManslaughter = 0; //Murder and non-negligent manslaughter
    private float murderNonNegManslaughterRate = 0;//Murder and non-negligent manslaughter rate
    private int rape = 0;//rape
    private float rapeRate = 0;//rape rate
    private int robbery = 0; //robbery
    private float robberyRate = 0;//robbery rate
    private int aggravatedAssault = 0;//Aggravated assault
    private float aggravatedAssaultRate = 0;//Aggravated assault rate
    private int propertyCrime = 0;//Property crime
    private float propertyCrimeRate = 0;//Property crime rate
    private int burglary = 0; //Burglary
    private float burglaryRate = 0;//Burglary rate
    private int larceny = 0;//larceny
    private float larcenyRate = 0;//larceny rate
    private int motorVehicleTheft = 0;//motor vehicle theft
    private float motorVehicleTheftRate = 0;//motor vehicle theft rate
	
	//default constructor
	public CrimeDataObjects(){	
	}
	
	//constructor 
	public CrimeDataObjects(int year, double poplulation, long vCrime, float vCrimeRate, 
			              int murderNonNegMan, float murderNonNegManRate, int rape, 
			              float rapeRate, int robbery,float robberyRate, int aggAssault, 
			              float aggAssaultRate, int propCrime, float propCrimeRate, int burglery, 
			              float burgleryRate,int larceny, float larcenyRate, int mvTheft, float mvTheftRate ) {
		
		this.year = year;
		this.poplulation = poplulation;
		this.violentCrime = vCrime;
		this.violentCrimeRate = vCrimeRate;
		this.murderNonNegManslaughter = murderNonNegMan;
		this.murderNonNegManslaughterRate = murderNonNegManRate;
		this.rape = rape;
		this.rapeRate = rapeRate;
		this.robbery = robbery;
		this.robberyRate = robberyRate;
		this.aggravatedAssault = aggAssault;
		this.aggravatedAssaultRate = aggAssaultRate;
		this.propertyCrime = propCrime;
		this.propertyCrimeRate = propCrimeRate;
		this.burglary = burglery;
		this.burglaryRate = burgleryRate;
		this.larceny = larceny;
		this.larcenyRate = larcenyRate;
		this.motorVehicleTheft =mvTheft;
		this.motorVehicleTheftRate = mvTheftRate;	
	}

	/*
	 * getter method for year
	 */
	public int getYear() {
		return year;
	}


	/*
	 * getter method for population
	 */
	public double getPoplulation() {
		return poplulation;
	}


	/*
	 * getter method for violentCrime
	 */
	public long getViolentCrime() {
		return violentCrime;
	}

	/*
	 * getter method for violentCrimeRate
	 */
	public float getViolentCrimeRate() {
		return violentCrimeRate;
	}

	/*
	 * getter method for murderNonNegManslaughter
	 */
	public int getMurderNonNegManslaughter() {
		return murderNonNegManslaughter;
	}

	/*
	 * getter method for murderNonNegManslaughterRate
	 */
	public float getMurderNonNegManslaughterRate() {
		return murderNonNegManslaughterRate;
	}

	/*
	 * getter method for rape
	 */
	public int getRape() {
		return rape;
	}


	/*
	 * getter method for rapeRate
	 */
	public float getRapeRate() {
		return rapeRate;
	}

	/*
	 * getter method for robbery
	 */
	public int getRobbery() {
		return robbery;
	}

	/*
	 * getter method for robberyRate
	 */
	public float getRobberyRate() {
		return robberyRate;
	}

	/*
	 * getter method for aggravatedAssault
	 */
	public int getAggravatedAssault() {
		return aggravatedAssault;
	}

	/*
	 * getter method for aggravatedAssaultRate
	 */
	public float getAggravatedAssaultRate() {
		return aggravatedAssaultRate;
	}


	/*
	 * getter method for propertyCrime
	 */
	public int getPropertyCrime() {
		return propertyCrime;
	}

	/*
	 * getter method for propertyCrimeRate
	 */
	public float getPropertyCrimeRate() {
		return propertyCrimeRate;
	}

	/*
	 * getter method for burglary
	 */
	public int getBurglery() {
		return burglary;
	}

	/*
	 * getter method for burgleryRate
	 */
	public float getBurgleryRate() {
		return burglaryRate;
	}

	/*
	 * getter method for larceny
	 */
	public int getLarceny() {
		return larceny;
	}

	/*
	 * getter method for larcenyRate
	 */
	public float getLarcenyRate() {
		return larcenyRate;
	}

	/*
	 * getter method for motorVehicleTheft
	 */
	public int getMotorVehicleTheft() {
		return motorVehicleTheft;
	}

	/*
	 * getter method for motorVehicleTheftRate
	 */
	public float getMotorVehicleTheftRate() {
		return motorVehicleTheftRate;
	}
	
}// end CrimeDataObjects class
