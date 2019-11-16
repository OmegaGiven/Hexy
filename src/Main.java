import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application {
    //  white:  https://i.imgur.com/xe4LYx0.png
    //  red:   https://i.imgur.com/62DSuZj.png
    // blue:  https://i.imgur.com/Su3rhhx.png
    ArrayList hexGrid;

    public Pane PrintBoard(int size){
        Pane pane = new Pane();
        //this will be used to create the initial board
        int offset = 0;
        Image image = new Image("https://i.imgur.com/xe4LYx0.png");
        for (int y = 0; y <= size; y++){
            for (int x = 0; x <= size; x++){
                ImageView hex = new ImageView(image);
                hex.setFitHeight(100);
                hex.setFitWidth(100);
                pane.getChildren().add(hex);
                hex.setRotate(90);
                hex.setY(y*25);
                hex.setX(x*30+offset);

                hex.setOnMouseClicked(event -> {
//                    hex.setIma;
                });
            }
            offset += 15;
        }
        return pane;
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

        Hex hex = new Hex();

        Button defaultSize = new Button("Default board size 11");
        defaultSize.setOnMouseClicked(action -> {
           hex.size = 11;

        });

        TextField sizeInput = new TextField();
        Button enteredText = new Button("Enter");
        enteredText.setOnMouseClicked(action -> {
            hex.size = Integer.parseInt(sizeInput.getText());
        });
        
        VBox leftPane = new VBox(sizeInput, enteredText, defaultSize);
        pane.setLeft(leftPane);

        pane.setCenter(PrintBoard(hex.size));



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
