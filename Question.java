public class Question {

	private final String question;
	
	private final String answer1 , answer2 , answer3 , answer4;
	
	private final int correctAnswer;
	private final int difficultyLevel;
	
	private boolean isAnswered;
	
	public Question(String question, String answer1, String answer2,String answer3, String answer4 , int correctAnswer , int difficultyLevel) {
		
		isAnswered = false;
		
		this.question = question;
		
		this.answer1 = answer1;
		this.answer2 = answer2;
		this.answer3 = answer3;
		this.answer4 = answer4;
		
		this.correctAnswer = correctAnswer;
		this.difficultyLevel = difficultyLevel;
		
	}
	
	public boolean isAnswered(){
		return isAnswered;
	}
	
	public boolean isSelectionCorrect(int selection){
		
		if(selection == correctAnswer) return true;
		
		return false;
	}

	public String getQuestion() {
		return question;
	}

	public String getAnswer1() {
		return answer1;
	}

	public String getAnswer2() {
		return answer2;
	}

	public String getAnswer3() {
		return answer3;
	}

	public String getAnswer4() {
		return answer4;
	}

	public int getCorrectAnswer() {
		return correctAnswer;
	}

	public int getDifficultyLevel() {
		return difficultyLevel;
	}
	
}
