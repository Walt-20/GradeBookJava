
public class Student{
	
	//class will represent a student from the file
	
	//Attributes
	private int studentId;
	private String firstName;
	private String lastName;
	private double[] grades;

	//Methods, default constructor
	public Student() {
		
	}
	
	Student(int studentId, String firstName, String lastName, double[] grades){
		
		//recieves all attributes for student
		this.studentId = studentId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.grades = grades; 
		
	}
	
	//Setters
	public void setStudentId(int studentId){
		this.studentId = studentId;
	}
	
	public void setFirstName(String firstName){
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName){
		this.lastName = lastName;
	}
	
	public void setGrades(double[] grades){
		this.grades = grades;
	}
	
	//Getters
	public int getStudentId(){
		return this.studentId;
	}
	
	public String getFirstName(){
		return this.firstName;
	}
	
	public String getLastName(){
		return this.lastName;
	}
	
	public double[] getGrades(){
		return this.grades;
	}
	
	public char calculateAverage(){
		
		GradeCalculator g = new GradeCalculator();
		//call calcaverage parameters this.grades
		double testAvg = g.calculateAverage(this.grades);
		//convert to char using converToLetterGrade method
		char letter = g.convertToLetterGrade(testAvg);
		return letter;
	}
	
	public void viewGrades(){
		//loop through grades 
		for(int i = 0; i < this.grades.length; i++){
			//print out grades at i while increment i for test scores
			System.out.println("Test: " + (i + 1) + " " + this.grades[i]);
		}
	}
	
	public String toString(){
		
		//method to return a String containing students firstName and lastName
		return firstName + " " + lastName;
	}
	
}
