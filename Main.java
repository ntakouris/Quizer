import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application{

	private Question q;
	private final String green = "-fx-background-color: green;", red = "-fx-background-color: red;";//css
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
		
		question.setStyle("-fx-background-color: transparent;");//needs work
		
		stage.setWidth(1366);
		stage.setHeight(768);
		stage.setTitle("Quizer");
		stage.setResizable(false);
		
		ans1 = new Button(q.getAnswer1());
		
		ans1.setVisible(true);
		//ans1.setStyle(red);
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
		next.setPrefSize(300, 100);
		next.addEventHandler(MouseEvent.MOUSE_RELEASED, new EventHandler<MouseEvent>() {
	        @Override 
	        public void handle(MouseEvent e) {
	        	System.out.println("NEXT");
	            q = Data.getRandomQuestion();
	            reset();
	        }
		});
		
		BorderPane borderpane = new BorderPane();
		
		HBox topnode = new HBox();
		
		topnode.setPadding(new Insets(40 ,0 ,0 ,0));
		
		topnode.setAlignment(Pos.CENTER);
		topnode.getChildren().add(next);
		
		borderpane.setTop(topnode);
		
		VBox qbox = new VBox();
		qbox.setAlignment(Pos.CENTER);
		qbox.getChildren().add(question);
		qbox.setPadding(new Insets(50, 10, 50, 10));
		
		borderpane.setCenter(qbox);
		
		HBox answers = new HBox();
		
		answers.setPadding(new Insets(40,50 , 50 ,50));
		
		answers.setSpacing(1000);
		
		VBox ans1_3 = new VBox();
		
		ans1_3.setSpacing(100);
		
		VBox ans2_4 = new VBox();
		
		ans2_4.setSpacing(100);
		
		ans1_3.getChildren().addAll(ans1 , ans3);
		ans2_4.getChildren().addAll(ans2 , ans4);
		
		answers.getChildren().addAll(ans1_3 , ans2_4);
		
		borderpane.setBottom(answers);
		
		//fix formatting pls
		//root.getChildren().addAll(next , question , ans1 , ans2 , ans3 , ans4);
		root.getChildren().add(borderpane);
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
		
		next.setVisible(true);
	}
	
	private void redize(){
		
		next.setVisible(false);
		
		ans1.setStyle(red);
		ans2.setStyle(red);
		ans3.setStyle(red);
		ans4.setStyle(red);
	}
	
}
