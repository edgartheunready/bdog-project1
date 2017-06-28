PASTEBINnew pastetrends API tools faq 
search...
 

Guest User
-
      
Public Pastes
Untitled
3 sec ago
Untitled
4 sec ago
Untitled
4 sec ago
Pereadin-Holy Shoc...
8 sec ago
Untitled
PHP | 8 sec ago
Untitled
10 sec ago
Untitled
13 sec ago
Untitled
Python | 14 sec ago

SHARE
TWEET

Employee
 A GUEST   JUN 27TH, 2017   14   NEVER

Not a member of Pastebin yet? Sign Up, it unlocks many cool features!
rawdownloadcloneembedreportprint Java 8.86 KB
/**
 * File name: TestEmployeeClass.java
 * @author Rebecca Johnson
 * Date: 6/27/2017
 * Purpose: This class tests the Employee, Executive, and Salesman classes. It
 *      creates instances of employee objects and calculates the employee's annual
 *      salary.
 *
 */
 
//Needed for File class, IOException and BufferReader
import java.io.*;
 
//Needed for ArrayList
import java.util.ArrayList;
 
public class TestEmployeeClass {
 
    public static void main(String[] args) throws IOException {
       
        //declares array lists of strings to hold each word of
        //  each file line
        ArrayList<String> word14List = new ArrayList<String>();
        ArrayList<String> word15List = new ArrayList<String>();
       
        //declares array lists to hold each employee object
        ArrayList<Employee> empData14 = new ArrayList<Employee>();
        ArrayList<Employee> empData15 = new ArrayList<Employee>();
       
        //declares and initializes a BufferedReader object.
        BufferedReader input = null;
       
        //declares the string that will hold each line of text from a file
         String fileLine;
         
         //creates a fileReader object needed to open text file
         FileReader fileName = new FileReader("EmployeeData.txt");
         
         //declares and initializes the total number of employee objects for both years
         int total14Employees = 0;
         int total15Employees = 0;
         
         //counters for each year
         int count14 = 0;
         int count15 = 0;
         
         //salary totals for each year
         int salaryTotal14 = 0;
         int salaryTotal15 = 0;
         
            //try-catch clause used to open file and catch any errors
            try {
                input = new BufferedReader(fileName);
 
                //read one line using BufferedReader
                while ((fileLine = input.readLine()) != null) {
                   
                    //this if-statement will execute if the line starts with 2014
                    if(fileLine.startsWith("2014")) {
                           
                        //splits each word/number of each line and adds it separately to array list
                        for(String word : fileLine.split(" "))
                            word14List.add(word);
                       
                        //checks if the second element in the array list is employee
                        if(word14List.get(count14 +1).equalsIgnoreCase("Employee")) {
                           
                            //adds an employee object to the main array list
                            empData14.add(new Employee(word14List.get(count14 + 2),
                            Integer.parseInt(word14List.get(count14 + 3))));
                           
                            //increments counter to start on next employee type
                            count14 = count14 + 4;
                        }
                       
                        //checks if the second element in the array list is salesman
                        else if(word14List.get(count14 + 1).equalsIgnoreCase("Salesman")) {
                           
                            //adds a salesman object to the main array list
                            empData14.add(new Salesman(word14List.get(count14 + 2),
                            Integer.parseInt(word14List.get(count14 + 3)),
                            Integer.parseInt(word14List.get(count14 + 4))));
                           
                            //increments counter to start on next employee type
                            count14 = count14 + 5;
                        }
                       
                        //checks if the second element in the array list is executive
                        else if(word14List.get(count14 + 1).equalsIgnoreCase("Executive")) {
                           
                            //adds an executive object to the main array list
                            empData14.add(new Executive(word14List.get(count14 + 2),
                            Integer.parseInt(word14List.get(count14 + 3)),
                            Integer.parseInt(word14List.get(count14 + 4))));
                               
                            //increments counter to start on next employee type
                            count14 = count14 + 5;
                        }
                    }
                   
                    //this else-if statement will execute if the line starts with 2015
                    else if(fileLine.startsWith("2015")) {
                       
                        //splits each word/number of each line and adds it separately to array list
                        for(String word : fileLine.split(" "))
                            word15List.add(word);
                       
                        //checks if the second element in the array list is employee
                        if(word15List.get(count15 +1).equalsIgnoreCase("Employee")) {
                           
                            //adds an employee object to the main array list
                            empData15.add(new Employee(word15List.get(count15 + 2),
                            Integer.parseInt(word15List.get(count15 + 3))));
                           
                            //increments counter to start on next employee type
                            count15 = count15 + 4;
                        }
                       
                        //checks if the second element in the array list is salesman
                        else if(word15List.get(count15 + 1).equalsIgnoreCase("Salesman")) {
                           
                            //adds a salesman object to the main array list
                            empData15.add(new Salesman(word15List.get(count15 + 2),
                            Integer.parseInt(word15List.get(count15 + 3)),
                            Integer.parseInt(word15List.get(count15 + 4))));
                           
                            //increments counter to start on next employee type
                            count15 = count15 + 5;
                        }
                       
                        //checks if the second element in the array list is executive
                        else if(word15List.get(count15 + 1).equalsIgnoreCase("Executive")) {
                           
                            //adds an executive object to the main array list
                            empData15.add(new Executive(word15List.get(count15 + 2),
                            Integer.parseInt(word15List.get(count15 + 3)),
                            Integer.parseInt(word15List.get(count15 + 4))));
                           
                            //increments counter to start on next employee type
                            count15 = count15 + 5;
                        }
                       
                        //will not process employee if year is neither 2014 nor 2015
                        else
                            System.out.print("INVALID YEAR");
                    }
                }
            }
           
            //catches error and outputs IO exception message
            catch (IOException io) {
                System.out.println("File IO exception" + io.getMessage());
            }
           
            finally {    
                 //closes bufferedReader stream when it is no longer needed
                    try {              
                        if (input != null) {
                            input.close();
                        }                
                    }
                //if bufferedReader stream will not close, error message will be displayed
                    catch (IOException io) {
                        System.out.println("Issue closing the Files" + io.getMessage());
                    }
            }
           
            //2014 employee report data
            System.out.print("2014 Employee Report: \n");
           
            //while loop will execute as long as the counter is less than the size of the array
            while(total14Employees < empData14.size()) {
               
                //uses printf to format output nicely
                System.out.printf("%nEmployee %d: %nType: %s%s %nAnnual Salary: $%,d %n",
                        total14Employees +1, empData14.get(total14Employees).getClass().getSimpleName(),
                        empData14.get(total14Employees).toString(),
                        empData14.get(total14Employees).annualSalary());
               
                //calculate the total salaries for 2014
                salaryTotal14 = salaryTotal14 + empData14.get(total14Employees).annualSalary();
                //increments counter
                total14Employees++;
            }
           
            //calculates and displays average of all salaries for the year of 2014
            System.out.printf("%nAverage of all salaries for 2014: $%,d %n" , (salaryTotal14 / total14Employees ));
           
            //2015 employee report data
            System.out.print("\n\n2015 Employee Report: \n");
           
            //while loop will execute as long as the counter is less than the size of the array
            while(total15Employees < empData15.size()) {
               
                //uses printf to format output nicely
                System.out.printf("%nEmployee %d: %nType: %s%s %nAnnual Salary: $%,d %n",
                        total15Employees +1, empData15.get(total15Employees).getClass().getSimpleName(),
                        empData15.get(total15Employees).toString(),
                        empData15.get(total15Employees).annualSalary());
               
                //calculate the total salaries for 2015
                salaryTotal15 = salaryTotal15 + empData15.get(total15Employees).annualSalary();
                //increments counter
                total15Employees++;
            }
           
          //calculates and displays average of all salaries for the year of 2015
            System.out.printf("%nAverage of all salaries for 2015: $%,d %n" , (salaryTotal15 / total15Employees ));
    }
 
}
RAW Paste Data

/**
 * File name: TestEmployeeClass.java
 * @author Rebecca Johnson
 * Date: 6/27/2017
 * Purpose: This class tests the Employee, Executive, and Salesman classes. It 
 * 		creates instances of employee objects and calculates the employee's annual
 * 		salary. 
 *
 */

//Needed for File class, IOException and BufferReader
import java.io.*;

//Needed for ArrayList
import java.util.ArrayList;

public class TestEmployeeClass {

	public static void main(String[] args) throws IOException {
		
		//declares array lists of strings to hold each word of
		//	each file line
		ArrayList<String> word14List = new ArrayList<String>();
		ArrayList<String> word15List = new ArrayList<String>();
		
		//declares array lists to hold each employee object
		ArrayList<Employee> empData14 = new ArrayList<Employee>();
		ArrayList<Employee> empData15 = new ArrayList<Employee>();
		
		//declares and initializes a BufferedReader object.
		BufferedReader input = null;
		
		//declares the string that will hold each line of text from a file
		 String fileLine;
		 
		 //creates a fileReader object needed to open text file
		 FileReader fileName = new FileReader("EmployeeData.txt");
		 
		 //declares and initializes the total number of employee objects for both years
		 int total14Employees = 0;
		 int total15Employees = 0;
		 
		 //counters for each year
		 int count14 = 0;
		 int count15 = 0;
		 
		 //salary totals for each year
		 int salaryTotal14 = 0;
		 int salaryTotal15 = 0;
		 
		 	//try-catch clause used to open file and catch any errors
	        try {
	            input = new BufferedReader(fileName);

	            //read one line using BufferedReader
	            while ((fileLine = input.readLine()) != null) {
	                
	            	//this if-statement will execute if the line starts with 2014
	            	if(fileLine.startsWith("2014")) {
	            			
	            		//splits each word/number of each line and adds it separately to array list
	            		for(String word : fileLine.split(" "))
	            			word14List.add(word);
	            		
	            		//checks if the second element in the array list is employee
	            		if(word14List.get(count14 +1).equalsIgnoreCase("Employee")) {
	            			
	            			//adds an employee object to the main array list
	            			empData14.add(new Employee(word14List.get(count14 + 2), 
	            			Integer.parseInt(word14List.get(count14 + 3))));
	            			
	            			//increments counter to start on next employee type
	            			count14 = count14 + 4;
	            		}
	            		
	            		//checks if the second element in the array list is salesman
	            		else if(word14List.get(count14 + 1).equalsIgnoreCase("Salesman")) {
	            			
	            			//adds a salesman object to the main array list
	            			empData14.add(new Salesman(word14List.get(count14 + 2), 
	            			Integer.parseInt(word14List.get(count14 + 3)),
	          				Integer.parseInt(word14List.get(count14 + 4))));
	            			
	            			//increments counter to start on next employee type
	            			count14 = count14 + 5;
	            		}
	            		
	            		//checks if the second element in the array list is executive
	            		else if(word14List.get(count14 + 1).equalsIgnoreCase("Executive")) {
	            			
	            			//adds an executive object to the main array list 
	            			empData14.add(new Executive(word14List.get(count14 + 2), 
	            			Integer.parseInt(word14List.get(count14 + 3)),
	            			Integer.parseInt(word14List.get(count14 + 4))));
	            				
	            			//increments counter to start on next employee type
	            			count14 = count14 + 5;
	            		}
	            	}
	            	
	            	//this else-if statement will execute if the line starts with 2015
	                else if(fileLine.startsWith("2015")) {
	                	
	                	//splits each word/number of each line and adds it separately to array list
	                	for(String word : fileLine.split(" "))
            				word15List.add(word);
            			
	                	//checks if the second element in the array list is employee
            			if(word15List.get(count15 +1).equalsIgnoreCase("Employee")) {
            				
            				//adds an employee object to the main array list
            				empData15.add(new Employee(word15List.get(count15 + 2), 
            				Integer.parseInt(word15List.get(count15 + 3))));
            				
            				//increments counter to start on next employee type
            				count15 = count15 + 4;
            			}
            			
            			//checks if the second element in the array list is salesman
            			else if(word15List.get(count15 + 1).equalsIgnoreCase("Salesman")) {
            				
            				//adds a salesman object to the main array list
            				empData15.add(new Salesman(word15List.get(count15 + 2), 
            				Integer.parseInt(word15List.get(count15 + 3)),
            				Integer.parseInt(word15List.get(count15 + 4))));
            				
            				//increments counter to start on next employee type
            				count15 = count15 + 5;
            			}
            			
            			//checks if the second element in the array list is executive
            			else if(word15List.get(count15 + 1).equalsIgnoreCase("Executive")) {
            				
            				//adds an executive object to the main array list
            				empData15.add(new Executive(word15List.get(count15 + 2), 
            				Integer.parseInt(word15List.get(count15 + 3)),
            				Integer.parseInt(word15List.get(count15 + 4))));
            				
            				//increments counter to start on next employee type
            				count15 = count15 + 5;
            			}
            			
            			//will not process employee if year is neither 2014 nor 2015
            			else
            				System.out.print("INVALID YEAR");
	                }
	            }
	        } 
	        
	        //catches error and outputs IO exception message
	        catch (IOException io) {
	            System.out.println("File IO exception" + io.getMessage());
	        }
	       
	        finally {    
	        	 //closes bufferedReader stream when it is no longer needed
	            	try {               
	            		if (input != null) {
	            			input.close();
	            		}                
	            	} 
	            //if bufferedReader stream will not close, error message will be displayed
	            	catch (IOException io) {
	            		System.out.println("Issue closing the Files" + io.getMessage());
	            	}
	        }
	        
	        //2014 employee report data
	        System.out.print("2014 Employee Report: \n");
	        
	        //while loop will execute as long as the counter is less than the size of the array
	        while(total14Employees < empData14.size()) {
	        	
	        	//uses printf to format output nicely
	        	System.out.printf("%nEmployee %d: %nType: %s%s %nAnnual Salary: $%,d %n",
	        			total14Employees +1, empData14.get(total14Employees).getClass().getSimpleName(),
	        			empData14.get(total14Employees).toString(),
	        			empData14.get(total14Employees).annualSalary());
	        	
	        	//calculate the total salaries for 2014
	        	salaryTotal14 = salaryTotal14 + empData14.get(total14Employees).annualSalary();
	        	//increments counter
	        	total14Employees++;
	        }
	        
	        //calculates and displays average of all salaries for the year of 2014
	        System.out.printf("%nAverage of all salaries for 2014: $%,d %n" , (salaryTotal14 / total14Employees ));
	        
	        //2015 employee report data
	        System.out.print("\n\n2015 Employee Report: \n");
	        
	        //while loop will execute as long as the counter is less than the size of the array
	        while(total15Employees < empData15.size()) {
	        	
	        	//uses printf to format output nicely
	        	System.out.printf("%nEmployee %d: %nType: %s%s %nAnnual Salary: $%,d %n",
	        			total15Employees +1, empData15.get(total15Employees).getClass().getSimpleName(),
	        			empData15.get(total15Employees).toString(), 
	        			empData15.get(total15Employees).annualSalary());
	        	
	        	//calculate the total salaries for 2015
	        	salaryTotal15 = salaryTotal15 + empData15.get(total15Employees).annualSalary();
	        	//increments counter
	        	total15Employees++;
	        }
	        
	      //calculates and displays average of all salaries for the year of 2015
	        System.out.printf("%nAverage of all salaries for 2015: $%,d %n" , (salaryTotal15 / total15Employees ));
	}

}
