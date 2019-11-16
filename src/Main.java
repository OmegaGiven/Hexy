import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Main extends Application {
    //  white:  https://i.imgur.com/xe4LYx0.png
    //  red:   https://i.imgur.com/62DSuZj.png
    //  blue:  https://i.imgur.com/Su3rhhx.png

    private boolean redPlayer = true;
    private int count = 0;
    private Hex hex;

    /***
     * Prints the center part of the board and calls the logic of calculating the win based on the input of hexagons.
     * @param size of the board
     * @param game game pane so it can be altered.
     * @return the inside pane to be added to the main stage to display graphically.
     */
    public Pane PrintBoard(int size, BorderPane game){
        Pane pane = new Pane();

        //texts that will be used later for the top to display whose turn.
        Text player1turn = new Text("Player 1's turn (red)");
        player1turn.setFill(Color.RED);
        Text player2turn = new Text("Player 2's turn (blue)");
        player2turn.setFill(Color.BLUE);


        //creates out line of the board colors so players know their sides.
        Line topbottom = new Line(10, 15, size*35, 15);
        topbottom.setStrokeWidth(10);
        topbottom.setStroke(Color.RED);
        Line topbottom2 = new Line(10+ 15 * size, size * 30, 10+ 15 * size + size*35, size * 30 );
        topbottom2.setStrokeWidth(10);
        topbottom2.setStroke(Color.RED);
        Line leftright = new Line(10, 15, 10+ 15 * size , size * 30);
        leftright.setStrokeWidth(10);
        leftright.setStroke(Color.BLUE);
        Line leftright2 = new Line(size*35, 15, 10+ 15 * size + size*35, size * 30 );
        leftright2.setStrokeWidth(10);
        leftright2.setStroke(Color.BLUE);
        pane.getChildren().addAll(leftright,leftright2,topbottom,topbottom2);


        //creates the hexagon grid
        Image blank = new Image("https://i.imgur.com/xe4LYx0.png");
        int offset = 0;
        for (int y = 0; y < size; y++){
            for (int x = 0; x < size; x++){
                Hexagon hexagon = new Hexagon(blank);
                ImageView im = new ImageView(hexagon.image);
                im.setFitHeight(100);
                im.setFitWidth(100);
                pane.getChildren().add(im);
                im.setRotate(90);
                im.setY(y*25);
                im.setX(x*30+offset);


                hexagon.index = size * y + x;
                hex.addBlank(hexagon);

                game.setTop(player1turn);

                //event for click action and calls logic for win.
                im.setOnMouseClicked(event -> {
                    count++;
                    if(redPlayer) {
                        game.setTop(player2turn);
                        im.setImage(new Image("https://i.imgur.com/62DSuZj.png"));
                        redPlayer = false;
                        im.setDisable(true);
                        hexagon.setPlayer(1);
                        hex.change(hexagon);
                        if(count > (2 * size - 2) && hex.winner()) {
                            Text winner = new Text("Red is the Winner!!!");
                            winner.setFill(Color.RED);
                            game.setBottom(winner);
                            game.setDisable(true);
                        }
                    }
                    else {
                        im.setImage(new Image("https://i.imgur.com/Su3rhhx.png"));
                        game.setTop(player1turn);
                        redPlayer = true;
                        im.setDisable(true);
                        hexagon.setPlayer(2);
                        hex.change(hexagon);
                        if(count > (2 * size - 2) && hex.winner()) {
                            Text winner = new Text("Blue is the Winner!!!");
                            winner.setFill(Color.BLUE);
                            game.setBottom(winner);
                            game.setDisable(true);
                        }

                    }
                });
            }
            offset += 15;
        }

        return pane;
    }

    /***
     * The main method in displaying the graphics of the game.
     * @param stage
     */
    public void start(Stage stage){
        Pane backdrop = new Pane();
        BorderPane pane = new BorderPane();
        backdrop.getChildren().add(pane);
        Pane blank = new Pane();

        //buttons for determining size
        Text request = new Text("Please enter a integer size");
        Button defaultSize = new Button("Default board size 11");
        defaultSize.setOnMouseClicked(action -> {
            hex = new Hex(11);
            pane.setCenter(PrintBoard(11, pane));
            defaultSize.setDisable(true);
            pane.setLeft(blank);
        });
        TextField sizeInput = new TextField();
        Button enteredText = new Button("Enter");
        enteredText.setOnMouseClicked(action -> {
            hex = new Hex(Integer.parseInt(sizeInput.getText()));
            System.out.println(Integer.parseInt(sizeInput.getText()));
            pane.setCenter(PrintBoard(Integer.parseInt(sizeInput.getText()), pane));
            enteredText.setDisable(true);
            pane.setLeft(blank);
        });


        //creation of right instruction section.
        Text Instructions = new Text(
          "Instructions:" + "\n" +
          "Players will alternate clicking hexagons on unoccupied hexagons." + "\n" +
          "The Goal is to link their their colors sides in an unbroken chain. " + "\n" +
          "One player must win; there are no draws."
        );
        pane.setRight(Instructions);
        
        VBox leftPane = new VBox(request, sizeInput, enteredText, defaultSize);
        pane.setLeft(leftPane);
        Scene scene = new Scene(backdrop, 500, 500);
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.setTitle("Hexy");
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
