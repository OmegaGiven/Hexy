import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {


    public void PrintBoard(){
        //this will be used to create the initial board
    }
    public void updateBoard(){
        //this will be used to update an already existent board.
    }

    public void start(Stage stage){
        BorderPane pane = new BorderPane();
        
        Text player1turn = new Text("Player 1's turn (red)");
        Text player2turn = new Text("Player 2's turn (blue)");



















        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
