/*

*Created By: Walt-20
*Small grade book program to find individual averages, highest score, and test averages
*Date Last Updated : 03AUG2021

*/

import java.io.*;
import java.util.*;

public class Runner{
	
	public static void main(String[] args){
		
		//set up login UI
		//call in scanner
		Scanner in = new Scanner(System.in);
		//ask user for username
		System.out.println("==================================================\n");
		System.out.println("\t Sign in to Walt's GradeBook \n\n" + 
		"==================================================\n" +
		"\nPlease print your username: ");
		String username = in.next();
		//print message dependent on user input
		if(checkUser(username)){
		}else{
			if(!checkUser(username)){
				System.out.println("Your username is not correct");
			}
			return;
		}
		//ask user for password
		System.out.println("\nPlease enter your password: ");
		String password = in.next();
		//if statements to display password is strong
		if(isPassLong(password) && isPassUpper(password) && isPassLower(password) && containsDigit(password) && containsSpecialCharacter(password)){
			System.out.println("\nThanks for signing up to Walt's Gradebook\n");
		}
		else {
			System.out.println("You have entered the wrong credentials");
			return; 
		}
		//if statments if user is missing a constraint or not entering the same password
		if(!isPassLong(password)){
			System.out.println("Your password is not long enough! 8 characters or more");
		}
		if(!isPassUpper(password)){
			System.out.println("Your password does not contain a uppercase character");
		}
		if(!isPassLower(password)){
			System.out.println("Your password does not contain a lowercase character");
		}
		if(!containsDigit(password)){
			System.out.println("Your password does not contain a number");
		}
		if(!containsSpecialCharacter(password)){
			System.out.println("Your password does not contain a special character");
		}
		
		//create database class
		Database students = new Database();
		students.populateDatabase();
		//variables
		int menu = 0;
		int userInput;
		boolean flag = false;
		//create menu on while loop 
		//create menu on while loop 
		while(!flag){
			System.out.println("==================================================\n" +
					"\n\t Walt's Grade Book Menu \n\n" +
					"==================================================\n" +
					"1. View Student Test Grade and Average \n" +
					"2. Get Test Average \n" +
					"3. Get Top Studetnt per Exam \n" +
					"4. Exit");
			//take user input for menu selection
			menu = Integer.parseInt(in.next());
			//if user inputs 4 turn flag to true and display log off message
			if(menu == 4) {
				flag = true;
				System.out.println("===========================================================================\n" +
					"\n\t You Have Successfully Logged Off \n\n" +
					"===========================================================================");
				return;
			}
			//if user inputs 4 have them view students and make selections
			if(menu == 1){
				//view list of students
				System.out.println("===========================================================================\n" +
					"\n\t Student List \n\n" +
					"===========================================================================");
				//prints out list of studnets
				students.viewListOfStudents();
				System.out.println();
				System.out.println("===========================================================================\n");
				//ask the user for the student whos average they want
				System.out.println("Select the students grades you want to view using their Student Id\n");
				//take user input
				userInput = in.nextInt();
				//get students name
				System.out.println("==================================================\n" +
					"\n\t Student's Average \n\n" +
					"==================================================\n");
				//print out students name
				System.out.println("You are viewing grades for: " + students.nameOfStd(userInput));
				//get students average letter and numerical grade
				char studentLetter = students.getStudentAvg(userInput);
				double studentAvg = students.getNumAvg(userInput);
				//display average and format
				System.out.println("Average: " + String.format("%.01f", studentAvg) + "\n" +
				"Letter: " + studentLetter + "\n");
				//shows students individual test scores
				students.displayGrades(userInput);
				System.out.println();
			}
			//if user enters 2 ask which test to average and average display to user
			if(menu == 2) {
				System.out.println("===========================================================================\n" +
					"\n\t Average Test Menu \n\n" +
					"===========================================================================\n");
				//ask user which test they would like to view
				System.out.println("Which test would you like the average of? [1-4]");
				//take user input
				userInput = in.nextInt();
				System.out.println("===========================================================================\n" +
				"\n\t Average Letter Grade for Test Number \n\n" +
				"===========================================================================\n");
				//show overall class test grade
				char overallAvg = students.getTestAvg(userInput);
				double numericalAvg = students.allTestAvg(userInput);
				System.out.println("Test " + userInput + ": " + overallAvg + "\n" + 
				"Average: " + String.format("%.02f", numericalAvg));
				System.out.println();
			}
			if(menu == 3){
				System.out.println("===========================================================================\n" +
					"\n\t Top Students Per Exam \n\n" +
					"===========================================================================\n");
				students.viewTopStudentPerExam();
			}
		}
	}
	
	//methods to check username and password compatibility
	
	//chekc if username is more than 6 characters
	public static boolean isUser(String username){
		if(username.length() > 6){
			return true;
		}
		return false;
	}
	//check if username is true or false
	public static boolean checkUser(String username){
		if(isUser(username)){
			return true;
		}
		return false;
	}
	//check password length
	public static boolean isPassLong(String password){
		if(password.length() > 8){
			return true;
		}
		return false; 
	}
	//check if password has upperCase
	public static boolean isPassUpper(String password){
		String upperCase = password.toUpperCase();
		for(int i = 0; i < password.length(); i++){
			if(upperCase.charAt(i) == password.charAt(i)){
				return true;
			}
		}
		return false;
	}
	//check if password has lowerCase
	public static boolean isPassLower(String password){
		String lowerCase = password.toLowerCase();
		for(int i = 0; i < password.length(); i++){
			if(lowerCase.charAt(i) == password.charAt(i)){
				return true;
			}
		}
		return false;
	}
	//check if password containts a digit
	public static boolean containsDigit(String password){
		for(int i = 0; i < password.length(); i++){
			if(password.charAt(i) == '0' || password.charAt(i) == '1' || password.charAt(i) == '2' ||
				password.charAt(i) == '3' || password.charAt(i) == '4' || password.charAt(i) == '5' ||
				password.charAt(i) == '6' || password.charAt(i) == '7' || password.charAt(i) == '8' ||
				password.charAt(i) == '9') {
					return true;
			}
		}
		return false;
	}
	//check if password containts special character
	public static boolean containsSpecialCharacter(String password){
		for(int i = 0; i < password.length(); i++){
			if(password.charAt(i) == '#' || password.charAt(i) == '@' || password.charAt(i) == '&' ||
				password.charAt(i) == '$') {
					return true;
			}
		}
		return false;
	}
	
}
