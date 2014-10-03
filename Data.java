import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;


public class Data {

	private Data(){
		throw new AssertionError();
	}
	private static int maxDifficultyLevel = 0;
	private static List<Question> questions = new ArrayList<Question>();
	private static final Random r = new Random();
	
	public static void init() throws Exception{
		
		File directory = new File("questions");
		
		for(File questionFile : directory.listFiles()){
			if(questionFile.getName().endsWith(".properties")){
				Properties pr = new Properties();
				pr.load(new FileInputStream(questionFile));
				
				int difficulty = Integer.parseInt(pr.getProperty("difficulty"));
				
				if(difficulty > maxDifficultyLevel){
					maxDifficultyLevel = difficulty;
				}
				
				questions.add(new Question(pr.getProperty("question"),
						pr.getProperty("answer1") , pr.getProperty("answer2") , pr.getProperty("answer3") , pr.getProperty("answer4"),
						Integer.parseInt(pr.getProperty("correct")), difficulty));
				
			}
		}
		
	}
	
	public static void removeAllWithLowerDifficulty(int difficulty){
		for(Question q : questions){
			if(q.getDifficultyLevel() < difficulty){
				questions.remove(q);
			}
		}
	}
	
	public static Question getRandomQuestion(boolean isAnswered , int difficultyLevel){
		
		if(questions.size() == 0){
			return null;
		}
		
		int questionNumber = r.nextInt(questions.size());//IKR not good performance but come on...
		
		Question q = questions.get(questionNumber);
		
		if(q.isAnswered() == isAnswered && q.getDifficultyLevel() == difficultyLevel){
			return q;
		}
		
		return getRandomQuestion(isAnswered , difficultyLevel);
		
	}
	
}
