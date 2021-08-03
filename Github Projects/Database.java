import java.io.*;
import java.util.*;

public class Database{
	
	//Attributes
	private String fileName;
	private Student[] studentList;
	private int numOfTests;
	
	public Database() {
		
	}
	
	public Database(String fileName){
		this.fileName = "student-database.csv";
	}
	
	public int getNumberOfStudents(){
		//initialize variable to count number of students
		int numOfStudents = 0;
		//initialize String to hold csv file
		String studentData;
		//start try catch
		try{
			//access the file
			File fileObj = new File("student-database.csv");
			//start scanner to read file
			Scanner out = new Scanner(fileObj);
				//get rid of header
				out.nextLine();
				//loop to read file
				while(out.hasNextLine()) {
					//reading the file till nextLine is null
					studentData = out.nextLine();
					//incrememnting number of students variable
					numOfStudents++;
				}
			//our catch and Sop to user
			}catch(Exception e){
				System.out.println("An error occured while reading the file " + e);
			}
		//return number of students in database to be used in populateDatabase method
		return numOfStudents;
	}
	
	public void populateDatabase(){
		//variables to hold objects of csv file
		String[] tempLine;
		//variable to hold csv file
		String studentData;
		//variable array to store grades from file
		double[] tempGrades;
		//count to incrememnt students
		int count = 0;
		//will only interact with the database class
		this.studentList = new Student[getNumberOfStudents()];
		try {
			//acces our file
			File fileObj = new File("student-database.csv");
			//set scanner to read our file
			Scanner out = new Scanner(fileObj);
			//get rid of header
			out.nextLine();
			//loop to read next line
			while(out.hasNextLine()){
				//read the rows of our files and storing in studentData
				studentData = out.nextLine();
				//store comma delimiter elements in tempLine array
				tempLine = studentData.split(",");
				//store space delimiter elemtns in tempDouble array
				String[] tempDouble = tempLine[3].split(" ");
				//initialize size of double array tempGrades
				tempGrades = new double[tempDouble.length];
				//loop to iterate over every 
				for(int i = 0; i < tempDouble.length; i++){
					tempGrades[i] = Double.parseDouble(tempDouble[i]);
				}
				//initializing  each object
				studentList[count] = new Student((Integer.parseInt(tempLine[0])), tempLine[1], tempLine[2], tempGrades);
				count++;
				}
		}catch(Exception e){
			System.out.println("An error occured while reading the file " + e);
		}
	}
	
	public Student[] getStudentList() {
		//make student list public
		return this.studentList;
	}
	
	public void viewListOfStudents(){
		//iterate over studentList
		for(int i = 0; i < studentList.length; i++) {
			//Sop studentList at i toString to change to a string
		System.out.println("[" + studentList[i].getStudentId() + "]" + " " + studentList[i].toString());
		}
	}
	
	public void displayGrades(int studentId){
		//iterate through studentList
		for(int i = 0; i < studentList.length;i++){
			//check that userInput creates constraint
			if(studentList[i].getStudentId() == studentId){
				//view grades of that constrant
				studentList[i].viewGrades();
			}
		}
	}
	
	public double getNumAvg(int studentId){
		//average variable
		double average = 0.0;
		//iterate over our studentList
		for(int i = 0; i < studentList.length; i++){
			//check user constraints 
			if(studentList[i].getStudentId() == studentId){
				//call our calculateAverage method from Student class
				for(int j = 0; j < studentList[i].getGrades().length; j++){
					//sum grades at user constraints
					average += studentList[i].getGrades()[j];
				}
				//get the product of average 
				average = average / studentList[i].getGrades().length;
			}
		}
		return average;
	}
	 
	public char getStudentAvg(int studentId){
		//call in GradeCalculator method
		char average = 'E';
		//loop to iterate over 
		for(int i = 0; i < studentList.length; i++){
			//studentId matches with studentId then get their grades
			if(studentList[i].getStudentId() == studentId){
				//call our calculateAverage method from Student class
				average = studentList[i].calculateAverage();
			}
		}
		return average;
	}
	
	public char getTestAvg(int numTests){
		
		//call in GradeCalculator method
		GradeCalculator g = new GradeCalculator();
		//set variables
		double sum = 0.0;
		double testAvg = 0.0;
		//iterate over the studentList
		for(int i = 0; i < studentList.length; i++){
			//sum the grades at i and increase numTests by 1
			sum += studentList[i].getGrades()[numTests - 1];
			//get the test average of user constraint
			testAvg = sum / studentList.length;
		}
		//convert testAvg into a letter grade
		return g.convertToLetterGrade(testAvg);
	}
	
	public double allTestAvg(int numTests){
		
		//set variables
		double sum = 0.0;
		double testAvg = 0.0;
		//iterate over the studentList
		for(int i = 0; i < studentList.length; i++){
			//sum the grades at i and increase numTests by 1
			sum += studentList[i].getGrades()[numTests - 1];
			//get the test average of user constraint
			testAvg = sum / studentList.length;
		}
		//convert testAvg into a letter grade
		return testAvg;
	}
	
	public String nameOfStd(int studentId){
		String firstLast = "";
		for(int i = 0; i < studentList.length; i++){
			if(studentList[i].getStudentId() == studentId){
				firstLast = studentList[i].toString();
			}
		}
		return firstLast;
	}
	
	public void viewTopStudentPerExam(){
		
		Student s = new Student();
		//iterate studentList to get the length of the grades
		for(int i = 0; i < studentList[0].getGrades().length; i++){
		//initialize varibles within the loop so they reset at each iteration
		double max = 0;
		
		//iterate over the length of studentList
			for(int j = 0; j < studentList.length; j++){
				if(studentList[j].getGrades()[i] > max){
				max = studentList[j].getGrades()[i];
				//s is equal to studentList[j]
				s = studentList[j];
				}
			}
		//print out test incrementing by 1 and set it to the top students name
		System.out.print("Test " + (i + 1) + " Top Student: " + s.toString() + "\n");
		System.out.println();
		}
	}

}
