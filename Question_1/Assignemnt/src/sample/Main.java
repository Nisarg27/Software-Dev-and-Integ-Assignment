package sample;

import java.util.ArrayList;
import java.util.Random;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application {

    static String path = "file:D:\\Uoit\\Uoit Second year\\Second Sem\\Software Dev and Integ\\Assignemnt\\src\\sample\\Cards", fileExt = ".png";

    //declaring an array of cards
    Image cards[];
    @Override
    public void start(Stage primaryStage) {
        //This will initialize the array of cards
        cards = new Image[54];

        //the following piece of coding is to load the cards
        for (int i = 0; i < cards.length; i++) {
            cards[i] = new Image(path
                    + (i + 1) + fileExt, true);
        }
        Random random = new Random();  //The following line of code will define a random number generator
        HBox row = new HBox(); //defining an hbox to arrange all of the elements in the array for cards
        row.setAlignment(Pos.CENTER);

         // defining a list containing 3 unique random index between 0 and 52,
        ArrayList<Integer> Rand_index = new ArrayList<>();
        while (Rand_index.size() != 3) {
            int randomCard_Ind = random.nextInt(cards.length - 2);
            if (!Rand_index.contains(randomCard_Ind)) {
                Rand_index.add(randomCard_Ind);
            }
        }

        for (Integer randomCard_Ind : Rand_index) {
            ImageView im = new ImageView(cards[randomCard_Ind]);
            row.getChildren().add(im);
        }

        Scene scene = new Scene(row, 300, 120);
        primaryStage.setTitle("Question_1");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}