import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {


    public void PrintBoard(){
        //this will be used to create the initial board
    }
    public void updateBoard(){
        //this will be used to update an already existing board.
    }

    public void start(Stage stage){
        BorderPane pane = new BorderPane();

        Text player1turn = new Text("Player 1's turn (red)");
        player1turn.setFill(Color.RED);
        Text player2turn = new Text("Player 2's turn (blue)");
        player2turn.setFill(Color.BLUE);

        Text request = new Text("Please Enter a Integer size");

        Button defaultSize = new Button("Default board size 11");
        defaultSize.setOnMouseClicked(action -> {
            int size = 11;
        });

        TextField sizeInput = new TextField();
        Button enteredText = new Button("Enter");
        enteredText.setOnMouseClicked(action -> {
            int size = Integer.parseInt(sizeInput.getText());
            System.out.println(size);
        });


        VBox leftPane = new VBox(sizeInput, enteredText, defaultSize);
        pane.setLeft(leftPane);







        stage.setTitle("Hexy");
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
