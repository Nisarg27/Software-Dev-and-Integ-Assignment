package sample;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
    Pane pane = new Pane();
    TextField file_text_field = new TextField();
    VBox box = new VBox();
    @Override
    public void start(Stage primaryStage) throws Exception {
        Label file_labelName = new Label("Filename:", file_text_field);
        file_labelName.setContentDisplay(ContentDisplay.RIGHT);
        file_text_field.setPrefColumnCount(20);
        Button btView = new Button("View");
        HBox hBox = new HBox(file_labelName, btView);
        box.getChildren().addAll(pane, hBox);
        Scene scene = new Scene(box);
        primaryStage.setScene(scene);
        btView.setOnAction(e-> {
            box.setTranslateY(10);
            primaryStage.sizeToScene();
        });
        primaryStage.show();
        primaryStage.setTitle("Question_4");
    }
    public static void main(String[] args) {
        launch(args);
    }
}