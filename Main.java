import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextBuilder;
import javafx.stage.Stage;

public class Main extends Application{

	private Question q;
	private final String green = "-fx-background-color: lawngreen;", red = "-fx-background-color: red;";//css
	private Button ans1 , ans2 , ans3 , ans4 , next;
	private Text question;
	
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
		
		//question.setWrapText(true);
		question = TextBuilder.create().text(q.getQuestion()).wrappingWidth(1266).build();
		question.setStyle("-fx-background-color: transparent;");//needs work
		
		stage.setWidth(1366);
		stage.setHeight(768);
		stage.setTitle("Quizer");
		stage.setResizable(false);
		
		ans1 = new Button();
		
		ans1.setVisible(true);
		//ans1.setStyle(green);
		ans1.addEventHandler(MouseEvent.MOUSE_RELEASED, new EventHandler<MouseEvent>() {
	        @Override 
	        public void handle(MouseEvent e) {
	            
	        	if(q.getCorrectAnswer() == 1){
	        		greenize();
	        	}else{
	        		redize();
	        	}
	            
	        }
		});
		
		ans2 = new Button();
		
		ans2.setVisible(true);
		
		ans2.addEventHandler(MouseEvent.MOUSE_RELEASED, new EventHandler<MouseEvent>() {
	        @Override 
	        public void handle(MouseEvent e) {

	        	if(q.getCorrectAnswer() == 2){
	        		greenize();
	        	}else{
	        		redize();
	        	}
	          
	        }
		});
		
		ans3 = new Button();
		
		ans3.setVisible(true);
		
		ans3.addEventHandler(MouseEvent.MOUSE_RELEASED, new EventHandler<MouseEvent>() {
	        @Override 
	        public void handle(MouseEvent e) {

	        	if(q.getCorrectAnswer() == 3){
	        		greenize();
	        	}else{
	        		redize();
	        	}
	          
	        }
		});
		
		ans4 = new Button();
		
		ans4.setVisible(true);
		
		ans4.addEventHandler(MouseEvent.MOUSE_RELEASED, new EventHandler<MouseEvent>() {
	        @Override 
	        public void handle(MouseEvent e) {

	        	if(q.getCorrectAnswer() == 4){
	        		greenize();
	        	}else{
	        		redize();
	        	}
	          
	        }
		});
		
		next = new Button("Next");
		
		next.setVisible(false);
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
		qbox.setPadding(new Insets(50, 10, 50, 50));
		
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
		reset();
	}
	
	private void reset(){
		
		question = TextBuilder.create().text(q.getQuestion()).wrappingWidth(1266).build();
		ans1.setText(TextBuilder.create().text(q.getAnswer1()).wrappingWidth(200).build().getText());
		ans2.setText(TextBuilder.create().text(q.getAnswer2()).wrappingWidth(200).build().getText());
		ans3.setText(TextBuilder.create().text(q.getAnswer3()).wrappingWidth(200).build().getText());
		ans4.setText(TextBuilder.create().text(q.getAnswer4()).wrappingWidth(200).build().getText());

		
		next.setVisible(false);
		next.setStyle("");
	}
	
	private void greenize(){
		
		next.setStyle(green);
		next.setVisible(true);

	}
	
	private void redize(){
		
		next.setStyle(red);
		next.setVisible(true);

	}
	
}
