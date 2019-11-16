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

    boolean redPlayer = true;
    public Pane PrintBoard(int size){
        Pane pane = new Pane();
        //this will be used to create the initial board
        int offset = 0;


//        Image image = new Image("https://i.imgur.com/xe4LYx0.png");


        Hex hexy = new Hex();
        Image blank = new Image("https://i.imgur.com/xe4LYx0.png");
        for (int y = 0; y <= size; y++){
            for (int x = 0; x <= size; x++){
                Hexagon hexagon = new Hexagon(blank);
                ImageView im = new ImageView(hexagon.image);
                im.setFitHeight(100);
                im.setFitWidth(100);
                pane.getChildren().add(im);
                im.setRotate(90);
                im.setY(y*25);
                im.setX(x*30+offset);

                hexagon.index = x * y + x;
                hexy.addBlank(hexagon);

                im.setOnMouseClicked(event -> {
                    if(redPlayer) {
                        im.setImage(new Image("https://i.imgur.com/62DSuZj.png"));
                        redPlayer = false;
                        im.setDisable(true);
                        hexagon.setPlayer(1);
                        hexy.change(hexagon);
                        if(hexy.winner()) {
                            System.out.println("Hello");
                        }
                    }
                    else {
                        im.setImage(new Image("https://i.imgur.com/Su3rhhx.png"));
                        redPlayer = true;
                        im.setDisable(true);
                        hexagon.setPlayer(2);
                        hexy.change(hexagon);
                        if(hexy.winner()) {
                            System.out.println("Hello");
                        }

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
