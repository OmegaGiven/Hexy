import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
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





















        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
