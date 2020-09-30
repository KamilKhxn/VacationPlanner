package Projects;

import java.util.Calendar;
import java.util.Scanner;

public class VacationPPlannerKhanKamil {

	    //Attributes/Properties

	    public static Scanner input;

	    //Strings for storing incoming message from user

	    // and storing prepared String to be displayed to user

	    public static String incoming;

	    public static String outgoing;

	    //Variables for storing user’s information

	    public static String country;

	    public static double days;

	    public static double amountOrigin;

	    public static double conversionFactor;

	    public static String currencySymbol;
		public static String travelType;
		public static double funds; 
		public static double travelCost;
		public static double hotelCost;

	    //Personal information

	    public static String firstName, lastName, title;



	    //Longitude and latitude information

	    public static double originLat, originLong;

	    public static double destLat, destLong;



	    //constants

	    public static double airSpeed, landSpeed;

	    public static double carCostpKm, airCostPKm, hotelCostPDay;



	    //Calculated quantities

	    public static double amountTravel, amountDest, dailyAllowance;

	    public static double distance;

	    public static double travelTime, vacationTime;

	    //Actions/Methods

	    public static void initialize() {

	        //TODO
	    	airSpeed = 700;
			landSpeed = 80;
			carCostpKm = 0.1;
			airCostPKm = 0.3;
			hotelCostPDay = 100;
			
			input = new Scanner(System.in);

	    }

	    public static void greet() {

	        //TODO
			System.out.println("Welcome to your Vacation Planner!"); 
	    }

	    public static void getPersonalInfo() {

	        //First Name. Last Name, Title
	    	System.out.println("What is your first name?");
			firstName = input.nextLine();
			System.out.println("What is your last name?");
			lastName= input.nextLine();
			System.out.println("Hi " + firstName + ", what title do you prefer? (press enter if you prefer none)");
			title = input.nextLine();
			
			if (title.equals("")) { 	
				System.out.println("Hi " + firstName + " pleasure to meet you!");
				
			}else { 	
					System.out.println("Hi " + title +" "+ lastName + " nice to meet you!");
			}
	        

	    }

	    public static void printSeparator() {

	        // print a line of some symbols to separate parts of the code while executed

			System.out.println("\n\n\n\n ********* \n\n\n\n");

	    }

	    public static void getVacationDays() {

	    	System.out.println("How many days are you planning to go on vacation for");
			input.reset();
			days = input.nextDouble();
	    }

	    public static void getCountry() {

	    	System.out.println("What country are you planning to visit?");
			input.reset();
			country = input.nextLine();
			Calendar cal = Calendar.getInstance();
			int monthnum = cal.get(Calendar.MONTH);
			String strMonth = "";
			if (monthnum == 0) {
				strMonth = "January";
			}
			else if (monthnum == 1) {
				strMonth = "February";
			}
			else if (monthnum == 2) {
				strMonth = "March";
			}
			else if (monthnum == 3) {
				strMonth = "April";
			}
			else if (monthnum == 4) {
				strMonth = "May";
			}
			else if (monthnum == 5) {
				strMonth = "June";
			}
			else if (monthnum == 6) {
				strMonth = "July";
			}
			else if (monthnum == 7) {
				strMonth = ""
						+ "August";
			}
			else if (monthnum == 8) {
				strMonth = "September";
			}
			else if (monthnum == 9) {
				strMonth = "October";
			}
			else if (monthnum == 10) {
				strMonth = "November";
			}
			else if (monthnum == 11) {
				strMonth = "December";
			}
			System.out.println(strMonth + " is a great time to travel to " + country);
	    }

	    public static void getTravelType() {

	    	input.reset();
			System.out.println("How do you plan to get to " + country); 
			travelType = input.next();
			
			if (travelType.toUpperCase().startsWith("A")) {//if user wrote airplane
				travelType = "AirPlane";
			
 
			}if (travelType.toUpperCase().startsWith("P")) {// if user wrote plane
				travelType = "AirPlane";
			
			}
			if (travelType.toUpperCase().startsWith("F")) {// if user wrote fly
				travelType = "AirPlane";
			}
			
			else if (travelType.toUpperCase().startsWith("C")) {//if user wrote car
				travelType = "Car";

				}	
			else if (travelType.toUpperCase().startsWith("D")) {// if user wrote drive
				travelType = "Car";
			}
			System.out.println("Wow travelling by " + travelType + " should be fun!");
	    }

	    public static void getFunds() {

	    	System.out.println("What is your budget for this trip"); 
			input.reset();
			funds = input.nextDouble(); 
	    }

	    public static void getCurrencySymbol() {

	    	System.out.println("Enter the currency symbol used in " + country);
			input.reset();
			currencySymbol = input.next();
	    }

	    public static void getConversionFactor() {

	    	System.out.println("What is the conversion rate between 1 CAD and " + currencySymbol);
			input.reset();
			conversionFactor = input.nextDouble(); 
	    }

	    public static double twoDecimals(double number) {

	        //TODO
	    	double formattedNumber = ((int)(number*100))/100.0;
			return formattedNumber;

	    }

	    public static void getLatitudeLongitudeCoordinatesOrigin() {

			System.out.println("Search online for the latitude of your starting location in the following format: \n +40.46 for for North and -40.46 for South \n What is the latitude of your starting location?");
			input.reset();
			originLat = input.nextDouble(); 
			
			System.out.println("Search online for the longitude of your starting location in the following format: \n +40.46 for for East and -40.46 for West \n What is the longitude of your starting location?");
			input.reset();
			originLong = input.nextDouble(); 
		
	    }

	    public static void getLatitudeLongitudeCoordinatesDestination() {

	    	System.out.println("Search online for the latitude of " + country + " in the following format: \n +40.46 for for North and -40.46 for South \n What is the latitude of " + country + "?");
			input.reset();
			destLat = input.nextDouble(); 
			
			System.out.println("Search online for the longitude of " + country + " in the following format: \n +40.46 for for East and -40.46 for West \n What is the longitude of " + country + "?");
			input.reset();
			destLong = input.nextDouble(); 
	    }

	    public static void calculateDistance() {

	    	 final int R = 6371;
			 Double latDistance = toRad(destLat - originLat);
			 Double lonDistance = toRad(destLong - originLong);
			 Double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2) +
			 Math.cos(toRad(originLat)) * Math.cos(toRad(destLat)) *
			 Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
			 Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
			 distance = R * c;
 
			 System.out.println("The distance to " + country + "is " + distance + "km");//TODO
	    }
	    
	    private static Double toRad(double number) {
			 return number * Math.PI / 180;
	    }

	    public static void calculateTravelTime() {

	    	if (travelType == "Car") {
				travelTime = distance / landSpeed; 

			} else if (travelType == "AirPlane"){
				travelTime = distance / airSpeed; 
	    }
			System.out.println("the traveling time is " + travelTime + " hours"); 

	    }
	    public static void calculateDailyAllowance() {

	    	if (travelType == "Car") {
				dailyAllowance = (funds - 2*(carCostpKm * distance) - (days * hotelCostPDay)) / days;

			} else if (travelType == "AirPlane"){
				dailyAllowance = (funds - 2*(airCostPKm * distance) - (days * hotelCostPDay)) / days;
				}
			 
			System.out.println("your daily spending limit is CAD $" + dailyAllowance); 

	    }

	    public static void calculateLocalCurrencyAmount() {

	    	amountDest = (dailyAllowance * days) * conversionFactor;

			amountTravel = dailyAllowance * conversionFactor;

			System.out.println("you have " + currencySymbol + " " + amountDest + " in total and " + currencySymbol + " " + amountTravel + " per day" ); 

	    }

	    public static void prepareMessage() {

	    	if (travelType == "Car") {
				travelCost = 2*(carCostpKm * distance);

			} else if (travelType == "AirPlane"){
				travelCost =  2*(airCostPKm * distance);

				}

	if (travelType == "Car") {
		hotelCost = (days * hotelCostPDay);

	} else if (travelType == "AirPlane"){
		hotelCost = (days * hotelCostPDay);

		}
		//rounding values
		hotelCost = twoDecimals(hotelCost);
		travelCost = twoDecimals(travelCost);
		amountTravel = twoDecimals(amountTravel);
		amountDest = twoDecimals(amountDest);
		dailyAllowance = twoDecimals(dailyAllowance);
		travelTime = twoDecimals(travelTime);
		distance = twoDecimals(distance);
	    }

	    public static void printMessage() {

			System.out.println("Dear " + firstName + " you will be travelling a total of " + distance + "km in " + travelTime + " hours to " + country + " (return trip).\n You will spend CAD $" + travelCost + " in travel costs and CAD $" + hotelCost + " in hotel costs.\n This means you will have " + currencySymbol + " " + amountDest + " in total and " + currencySymbol + " " + amountTravel + " to spend per day.\n Have a wonderful trip to " + country + " " + firstName +"!");

	    }



	    public static void main(String[] args) {

	        initialize();

	        greet();

	        printSeparator();

	        getPersonalInfo();

	        printSeparator();

	        getCountry();

	        printSeparator();
	        
	        getVacationDays();
	      
	        printSeparator();

	        getTravelType();

	        printSeparator();

	        getFunds();

	        printSeparator();

	        getCurrencySymbol();

	        printSeparator();

	        getConversionFactor();

	        printSeparator();

	        getLatitudeLongitudeCoordinatesOrigin();

	        printSeparator();

	        getLatitudeLongitudeCoordinatesDestination();

	        calculateDistance();

	        calculateTravelTime();

	        calculateDailyAllowance();

	        calculateLocalCurrencyAmount();

	        prepareMessage();

	        printSeparator();

	        printMessage();

	    }

}
