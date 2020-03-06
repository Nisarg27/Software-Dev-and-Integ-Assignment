package sample;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.geometry.Pos;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.stage.Stage;

public class Main extends Application {
    private TextField Investing_amount = new TextField();
    private TextField No_of_years = new TextField();
    private TextField int_rate = new TextField();
    private TextField text_finalValue = new TextField();
    private Button calc_button = new Button("Calculate");

    @Override
    public void start(Stage primaryStage) {
        GridPane pane = new GridPane();
        pane.setVgap(5);
        pane.setHgap(5);
        pane.add(new Label("Investment Amount:"), 0, 0);
        pane.add(Investing_amount, 1, 0);
        pane.add(new Label("Number Of Years:"), 0, 1);
        pane.add(No_of_years, 1, 1);
        pane.add(new Label("Annual Interest Rate:"), 0, 2);
        pane.add(int_rate, 1, 2);
        pane.add(new Label("Future value:"), 0, 3);
        pane.add(text_finalValue, 1, 3);
        pane.add(calc_button, 1, 4);

        pane.setAlignment(Pos.CENTER);
        Investing_amount.setAlignment(Pos.BOTTOM_RIGHT);
        No_of_years.setAlignment(Pos.BOTTOM_RIGHT);
        int_rate.setAlignment(Pos.BOTTOM_RIGHT);
        text_finalValue.setAlignment(Pos.BOTTOM_RIGHT);
        text_finalValue.setEditable(false);
        GridPane.setHalignment(calc_button, HPos.RIGHT);
        pane.setPadding(new Insets(10, 10, 10, 10));


        calc_button.setOnAction( W-> final_val());
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Question_2"); // This line of coding will set the stage title
        primaryStage.setScene(scene); // This line of coding will place the scene in the stage
        primaryStage.show(); // This line of coding will display the stage
    }

    //This function calculates the final value that is needed in order to get the "Future value"
    private void final_val() {
        double invest_Amount = Double.parseDouble(Investing_amount.getText());
        int year_no = Integer.parseInt(No_of_years.getText());
        double month_interest =
                Double.parseDouble(int_rate.getText()) / 1200;
        text_finalValue.setText(String.format("$%.2f",
                (invest_Amount * Math.pow(1 + month_interest, year_no * 12))));
    }
}