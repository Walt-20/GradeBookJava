

public class GradeCalculator{
	
	//class that contains useful methods to calculate averages 
	//and convert grades to letter grades
	
	//Methods
	public char convertToLetterGrade(double grade){
		
		char letterGrade;
		//return a letter grade for a given test score or average grade
		if((grade >= 90.0) && (grade <= 100.0)){
			letterGrade = 'A';
		}else if((grade >= 80.0) && (grade < 90.0)){
			letterGrade = 'B';
		}else if((grade >= 70.0) && (grade < 80.0)){
			letterGrade = 'C';
		}else if((grade >= 60.0) && (grade < 70.0)){
			letterGrade = 'D';
		}else if((grade >= 0.0) && (grade < 60.0)){
			letterGrade = 'F';
		}else{
			letterGrade = 'E';
		}
		return letterGrade;
	}
	
	public double calculateAverage(double[] grades){
		
		//given list of grades, return average grades
		int sum = 0;
		//iterate through grades
		for(int i = 0; i < grades.length; i++){
			//add grades to sum
			sum += grades[i];
		}
		//get product of sum and grades.length
		return sum / grades.length;
	}
	
}