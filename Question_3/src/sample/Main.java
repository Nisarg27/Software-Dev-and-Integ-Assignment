package sample;
import java.awt.Point;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {
    //Defining all the necessary variables that are needed in order to make the program run
    private Circle draw_circle; //big circle
    private Circle first_point, second_point, third_point;//points
    private Line first_line, second_line, third_line; //lines to connect points
    private Text angle_one, angle_two, angle_three; //to display angles between points
    @Override

    public void start(Stage primaryStage) {
        draw_circle = new Circle(200);
        draw_circle.setCenterX(250);
        draw_circle.setCenterY(250);
        draw_circle.setFill(Color.TRANSPARENT);
        draw_circle.setStroke(Color.BLACK);

        //initializing three small red circles to represent points
        first_point = new Circle(10);
        first_point.setFill(Color.RED);
        first_point.setStroke(Color.BLACK);
        //passing the point object and mouse event object after adding a mouse dragged listener which will allow
        //to call the movepoint() method later on
        first_point.setOnMouseDragged(D -> movePoint(first_point, D));
        second_point = new Circle(10);
        second_point.setFill(Color.RED);
        second_point.setStroke(Color.BLACK);
        second_point.setOnMouseDragged(D -> movePoint(second_point, D));
        third_point = new Circle(10);
        third_point.setFill(Color.RED);
        third_point.setStroke(Color.BLACK);
        third_point.setOnMouseDragged(D -> movePoint(third_point, D));
        initialize(); //initializes the default view and all three angles
        update(); //this method will update the view

        //the following line of coding creates pane and adds everything in the order
        Pane root = new Pane(draw_circle, first_line, second_line, third_line, angle_one, angle_two,
                angle_three, first_point, second_point, third_point);
        Scene scene = new Scene(root, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Question_3");
        primaryStage.show();
    }

    //this will initialize all the values regarding default_values
    void initialize() {
        //this will initialize the text to display angles
        angle_one = new Text();
        angle_two = new Text();
        angle_three = new Text();

        //The following piece of code finds the radius of the circle
        double X_center = draw_circle.getCenterX();
        double Y_center = draw_circle.getCenterY();
        double radius = draw_circle.getRadius();

        double angle = 0;

        double x = X_center + radius * Math.cos(Math.toRadians(angle));
        double y = Y_center + radius * Math.sin(Math.toRadians(angle));

        first_point.setCenterX(x);
        first_point.setCenterY(y);

        //The following piece of code will find the coordinates of the point to show the angle
        //same thing as above, difference is the distance from center
        x = X_center + (radius - 50) * Math.cos(Math.toRadians(angle));
        y = Y_center + (radius - 50) * Math.sin(Math.toRadians(angle));
        angle_one.setLayoutX(x);
        angle_one.setLayoutY(y);
        angle = 90;
        x = X_center + radius * Math.cos(Math.toRadians(angle));
        y = Y_center + radius * Math.sin(Math.toRadians(angle));
        second_point.setCenterX(x);
        second_point.setCenterY(y);
        x = X_center + (radius - 50) * Math.cos(Math.toRadians(angle));
        y = Y_center + (radius - 50) * Math.sin(Math.toRadians(angle));
        angle_two.setLayoutX(x);
        angle_two.setLayoutY(y);
        angle = 180;
        x = X_center + radius * Math.cos(Math.toRadians(angle));
        y = Y_center + radius * Math.sin(Math.toRadians(angle));
        third_point.setCenterX(x);
        third_point.setCenterY(y);
        x = X_center + (radius - 50) * Math.cos(Math.toRadians(angle));
        y = Y_center + (radius - 50) * Math.sin(Math.toRadians(angle));
        angle_three.setLayoutX(x);
        angle_three.setLayoutY(y);

        //The following small piece of code will just connect the lines
        first_line = new Line(first_point.getCenterX(), first_point.getCenterY(), second_point.getCenterX(), second_point.getCenterY());
        second_line = new Line(second_point.getCenterX(), second_point.getCenterY(), third_point.getCenterX(), third_point.getCenterY());
        third_line = new Line(third_point.getCenterX(), first_point.getCenterY(), first_point.getCenterX(), first_point.getCenterY());
    }
    //the following method will update the coordinates to the point where the mouse is dragged
    void movePoint(Circle point, MouseEvent event) {
        //finding current point and center point's location
        double x1 = event.getX();
        double x2 = draw_circle.getCenterX();
        double y1 = event.getY();
        double y2 = draw_circle.getCenterY();

        //finds angle between current point and the center
        double angle = Math.atan2(y1 - y2, x1 - x2);
        double newX = x2 + draw_circle.getRadius() * Math.cos(angle);
        double newY = y2 + draw_circle.getRadius() * Math.sin(angle);
        point.setCenterX(newX); //sets the location of the points
        point.setCenterY(newY); //sets the location of the points

        //similarly updating the coordinates of the angle display text
        newX = x2 + (draw_circle.getRadius() - 50) * Math.cos(angle);
        newY = y2 + (draw_circle.getRadius() - 50) * Math.sin(angle);
        if (point.equals(first_point)) {
            angle_one.setLayoutX(newX);
            angle_one.setLayoutY(newY);
        } else if (point.equals(second_point)) {
            angle_two.setLayoutX(newX);
            angle_two.setLayoutY(newY);
        } else {
            angle_three.setLayoutX(newX);
            angle_three.setLayoutY(newY);
        }
        update();//this will update the view
    }

//The following method just updates the view
    void update() {
        //the following piece of code just reconnects all the lines
        first_line.setStartX(first_point.getCenterX());
        first_line.setStartY(first_point.getCenterY());
        first_line.setEndX(second_point.getCenterX());
        first_line.setEndY(second_point.getCenterY());
        second_line.setStartX(second_point.getCenterX());
        second_line.setStartY(second_point.getCenterY());
        second_line.setEndX(third_point.getCenterX());
        second_line.setEndY(third_point.getCenterY());
        third_line.setStartX(third_point.getCenterX());
        third_line.setStartY(third_point.getCenterY());
        third_line.setEndX(first_point.getCenterX());
        third_line.setEndY(first_point.getCenterY());

        //The following line of code will find the distance between the second and the third point
        double a = Point.distance(second_point.getCenterX(), second_point.getCenterY(), third_point.getCenterX(), third_point.getCenterY());
        //The following line of code will find the distance between the first and the third point
        double b = Point.distance(first_point.getCenterX(), first_point.getCenterY(), third_point.getCenterX(), third_point.getCenterY());
        //The following line of code will find the distance between the second and the first point
        double c = Point.distance(second_point.getCenterX(), second_point.getCenterY(), first_point.getCenterX(), first_point.getCenterY());

        //the following piece of code was given in the given document to calculate the angles
        double angle1 = Math.acos((a * a - b * b - c * c) / (-2 * b * c));
        double angle2 = Math.acos((b * b - a * a - c * c) / (-2 * a * c));
        double angle3 = Math.acos((c * c - b * b - a * a) / (-2 * a * b));

        //The following piece of code will find the angles to one decimal precision as the user decides to drag it
        angle_one.setText(String.format("%.1f", Math.toDegrees(angle1)));
        angle_two.setText(String.format("%.1f", Math.toDegrees(angle2)));
        angle_three.setText(String.format("%.1f", Math.toDegrees(angle3)));
    }

    public static void main(String[] args) {
        launch(args);
    }

}