import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application{

	private Question q;
	private final String green = "", red = "";//css
	private Button ans1 , ans2 , ans3 , ans4 , next;
	private TextArea question;
	
	public static void main(String[] args) {
		
		try {
			Data.init();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		launch(args);
	}

	@Override
    public void start(Stage stage) {
		
		StackPane root = new StackPane();
		
		q = Data.getRandomQuestion();
		
		question = new TextArea(q.getQuestion());
		question.setEditable(false);
		question.setWrapText(true);
		
		stage.setWidth(1366);
		stage.setHeight(768);
		stage.setTitle("Quizer");
		stage.setResizable(false);
		
		ans1 = new Button(q.getAnswer1());
		
		ans1.setVisible(true);
		
		ans1.addEventHandler(MouseEvent.MOUSE_RELEASED, new EventHandler<MouseEvent>() {
	        @Override 
	        public void handle(MouseEvent e) {
	            
	        	if(q.getCorrectAnswer() == 1){
	        		ans1.setStyle(green);
	        	}else{
	        		redize();
	        	}
	            
	        }
		});
		
		ans2 = new Button(q.getAnswer2());
		
		ans2.setVisible(true);
		
		ans2.addEventHandler(MouseEvent.MOUSE_RELEASED, new EventHandler<MouseEvent>() {
	        @Override 
	        public void handle(MouseEvent e) {

	        	if(q.getCorrectAnswer() == 2){
	        		ans2.setStyle(green);
	        	}else{
	        		redize();
	        	}
	          
	        }
		});
		
		ans3 = new Button(q.getAnswer3());
		
		ans3.setVisible(true);
		
		ans3.addEventHandler(MouseEvent.MOUSE_RELEASED, new EventHandler<MouseEvent>() {
	        @Override 
	        public void handle(MouseEvent e) {

	        	if(q.getCorrectAnswer() == 3){
	        		//greenize button
	        		ans3.setStyle(green);
	        	}else{
	        		redize();
	        	}
	          
	        }
		});
		
		ans4 = new Button(q.getAnswer4());
		
		ans4.setVisible(true);
		
		ans4.addEventHandler(MouseEvent.MOUSE_RELEASED, new EventHandler<MouseEvent>() {
	        @Override 
	        public void handle(MouseEvent e) {

	        	if(q.getCorrectAnswer() == 4){
	        		ans4.setStyle(green);
	        	}else{
	        		redize();
	        	}
	          
	        }
		});
		
		next = new Button("Next");
		
		next.setVisible(true);
		
		next.addEventHandler(MouseEvent.MOUSE_RELEASED, new EventHandler<MouseEvent>() {
	        @Override 
	        public void handle(MouseEvent e) {
	            q = Data.getRandomQuestion();
	            reset();
	        }
		});
		
		//fix formatting pls
		root.getChildren().addAll(next , question , ans1 , ans2 , ans3 , ans4);
		
		stage.setScene(new Scene(root));
		stage.show();
	}
	
	private void reset(){
		
		ans1.setStyle("");
		ans2.setStyle("");
		ans3.setStyle("");
		ans4.setStyle("");
		
		question.setText(q.getQuestion());
		ans1.setText(q.getAnswer1());
		ans2.setText(q.getAnswer2());
		ans3.setText(q.getAnswer3());
		ans4.setText(q.getAnswer4());
	}
	
	private void redize(){
		ans1.setStyle(red);
		ans2.setStyle(red);
		ans3.setStyle(red);
		ans4.setStyle(red);
	}
	
}
