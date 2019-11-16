import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Main extends Application {
    //  white:  https://i.imgur.com/xe4LYx0.png
    //  red:   https://i.imgur.com/62DSuZj.png
    // blue:  https://i.imgur.com/Su3rhhx.png

    boolean count = true;
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
                    if(count) {
                        hex.setImage(new Image("https://i.imgur.com/62DSuZj.png"));
                        count = false;
                        hex.setDisable(true);
                    }
                    else {
                        hex.setImage(new Image("https://i.imgur.com/Su3rhhx.png"));
                        count = true;
                        hex.setDisable(true);


                    }
                });
            }
            offset += 15;
        }
        return pane;
    }


    public void start(Stage stage){
        Pane backdrop = new Pane();
        BackgroundImage backgroundImage = new BackgroundImage(new Image("https://scx1.b-cdn.net/csz/news/800/2015/computermode.png"), BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        Background background = new Background(backgroundImage);
        BorderPane pane = new BorderPane();
        backdrop.setBackground(background);
        backdrop.getChildren().add(pane);
        Pane blank = new Pane();

        Text player1turn = new Text("Player 1's turn (red)");
        player1turn.setFill(Color.RED);
        Text player2turn = new Text("Player 2's turn (blue)");
        player2turn.setFill(Color.BLUE);

        Text request = new Text("Please Enter a Integer size");


        Button defaultSize = new Button("Default board size 11");
        defaultSize.setOnMouseClicked(action -> {
            Hex hex = new Hex();
            pane.setCenter(PrintBoard(11));
            defaultSize.setDisable(true);
            pane.setLeft(blank);
        });

        TextField sizeInput = new TextField();
        Button enteredText = new Button("Enter");
        enteredText.setOnMouseClicked(action -> {
            Hex hex = new Hex(Integer.parseInt(sizeInput.getText()));
            pane.setCenter(PrintBoard(Integer.parseInt(sizeInput.getText())));
            enteredText.setDisable(true);
            pane.setLeft(blank);
        });
        
        VBox leftPane = new VBox(request, sizeInput, enteredText, defaultSize);
        pane.setLeft(leftPane);

        stage.setTitle("Hexy");
        Scene scene = new Scene(backdrop);
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
