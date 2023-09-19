import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class App extends Application {

    private Stage primaryStage;
    private Scene scene1;
    private Scene scene2;
    private Scene scene3;
    private Scene scene4;
    private Scene scene5;
    
    private ArrayList<String> workoutHistory = new ArrayList<>();
    private TextArea workoutHistoryTextArea;        


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        primaryStage = stage;
       
       
   
        

        //create the workout input scene
        Group workoutInputLayout1 = new Group();
        TextField workoutInputField1 = new TextField();
        TextField workoutInputField2 = new TextField();
        TextField workoutInputField3 = new TextField();
        Button saveButton1 = new Button("Save");
        saveButton1.setLayoutX(5);
        saveButton1.setLayoutY(150);
        saveButton1.setOnAction(e -> saveWorkout(workoutInputField1.getText(), workoutInputField2.getText(), workoutInputField3.getText()));

        

        //create the workout input scene
        Group workoutInputLayout2 = new Group();
        TextField workoutInputField4 = new TextField();
        TextField workoutInputField5 = new TextField();
        TextField workoutInputField6 = new TextField();
        Button saveButton2 = new Button("Save");
        saveButton2.setLayoutX(5);
        saveButton2.setLayoutY(150);
        saveButton2.setOnAction(e -> saveWorkout(workoutInputField4.getText(), workoutInputField5.getText(), workoutInputField6.getText()));

        HBox hbox1 = new HBox(workoutInputField1);
        hbox1.setLayoutX(5);
        hbox1.setLayoutY(50);
        HBox hbox2 = new HBox(workoutInputField2);
        hbox2.setLayoutX(5);
        hbox2.setLayoutY(80);
        HBox hbox3 = new HBox(workoutInputField3);
        hbox3.setLayoutX(5);
        hbox3.setLayoutY(110);

        HBox hbox4 = new HBox(workoutInputField4);
        hbox4.setLayoutX(5);
        hbox4.setLayoutY(50);
        HBox hbox5 = new HBox(workoutInputField5);
        hbox5.setLayoutX(5);
        hbox5.setLayoutY(80);
        HBox hbox6 = new HBox(workoutInputField6); 
        hbox6.setLayoutX(5);
        hbox6.setLayoutY(110);

        // Create the workout history scene
        VBox workoutHistoryLayout = new VBox(10);
        workoutHistoryTextArea = new TextArea();
        workoutHistoryTextArea.setEditable(false);

        workoutHistoryLayout.getChildren().addAll(new Label("Workout History:"), workoutHistoryTextArea);


        // Create scene1
        Group root1 = new Group();
        scene1 = new Scene(root1, 600, 400, Color.WHITE);

        // Create scene2
        Group root2 = new Group();
        scene2 = new Scene(root2, 600, 400, Color.BLUEVIOLET); // Change the background color as needed

        // Create scene3;
        scene3 = new Scene(workoutInputLayout1, 270, 225, Color.WHITE); // Change the background color as needed

         // Create scene4
        scene4 = new Scene(workoutInputLayout2, 330, 225, Color.WHITE); // Change the background color as needed

        // Create scene5
        scene5 = new Scene(workoutHistoryLayout, 400, 300, Color.WHITE); // Change the background color as needed


        // Set an image at the top of the stage
        Image image = new Image("dumbbell.jpg");
        stage.getIcons().add(image);

        // Set background image for scene1
        Image back = new Image("Gym.jpg");
        ImageView imageView1 = new ImageView(back);
        imageView1.setFitWidth(600);
        imageView1.setFitHeight(400);
        root1.getChildren().add(imageView1);

        // Add text to scene1
        Text text1 = new Text("Welcome to Fitness Tracker!");
        text1.setFont(Font.font("Verdana", 25));
        text1.setFill(Color.BLACK);
        text1.setX(132);
        text1.setY(50);
        
        // Create a Font object with bold style
        Font boldFont = Font.font("Arial", FontWeight.BOLD, 25); // You can customize the font family and size
        text1.setFont(boldFont);

        // Add a line under the text in scene1
        Line line1 = new Line(123, 55, 484, 55);
        line1.setStrokeWidth(3);
        line1.setStroke(Color.BLACK);

        // Create a button on scene1 to switch to scene2
        Button button = new Button("Press to log new workout!");
        button.setOnAction(e -> switchToScene2());
        button.setLayoutX(230);
        button.setLayoutY(300);

        // root for scene1
        root1.getChildren().addAll(text1, line1, button);
        
        // create butttons on scene2 for workout
        Button cardioButton = new Button("Cardio Workout");
        Button strengthButton = new Button("Strength Workout");
        cardioButton.setLayoutX(150);
        cardioButton.setLayoutY(200);
        strengthButton.setLayoutX(330);
        strengthButton.setLayoutY(200);
        cardioButton.setOnAction(e -> switchToScene3());
        strengthButton.setOnAction(e -> switchToScene4());
        root2.getChildren().addAll(cardioButton, strengthButton);

        // add rectangle to scene2
        Rectangle rec = new Rectangle();
        rec.setWidth(300);
        rec.setHeight(75);
        rec.setFill(null);
        rec.setTranslateX(146);
        rec.setTranslateY(177);
        rec.setStroke(Color.BLACK);
        root2.getChildren().add(rec);

        //add label to scene2
        Label label1 = new Label("Cardio or Strength Training?"); 
        label1.setStyle("-fx-font-size: 20px; -fx-text-fill: black;");
        label1.setLayoutX(180);
        label1.setLayoutY(40);
        root2.getChildren().add(label1);

        //add another label to scene2
        Label label2 = new Label("What did you do Today?"); 
        label2.setStyle("-fx-font-size: 20px; -fx-text-fill: black;");
        label2.setLayoutX(194);
        label2.setLayoutY(20);
        root2.getChildren().add(label2);

        Label label3 = new Label("Duration (mins)");
        label3.setLayoutX(175);
        label3.setLayoutY(50);
        Label label4 = new Label("Pace (mph)");
        label4.setLayoutX(175);
        label4.setLayoutY(80);
        Label label5 = new Label("Distance (miles)");
        label5.setLayoutX(175);
        label5.setLayoutY(110);

        Label label6 = new Label("Duration (mins)");
        label6.setLayoutX(175);
        label6.setLayoutY(50);
        Label label7 = new Label("Muscles trained");
        label7.setLayoutX(175);
        label7.setLayoutY(80);
        Label label8 = new Label("Date trained");
        label8.setLayoutX(175);
        label8.setLayoutY(110);

        workoutInputLayout1.getChildren().addAll(label3, label4, label5);
        workoutInputLayout2.getChildren().addAll(label6, label7, label8);
        

        

        // Add UI elements to layout3 for scene3
        Text scene3Text = new Text("Log Cardio Workout!");
        scene3Text.setLayoutX(10);
        scene3Text.setLayoutY(20);
        scene3Text.setFont(Font.font("Verdana", 20));
        Button backButton3 = new Button("Back to home page");
        backButton3.setLayoutX(5); 
        backButton3.setLayoutY(195);
        backButton3.setOnAction(e -> switchToScene1());
        

        

        // Add UI elements to layout4 for scene4
        Text scene4Text = new Text("Log Strength Training Workout!");
        scene4Text.setLayoutX(10);
        scene4Text.setLayoutY(20);
        scene4Text.setFont(Font.font("Verdana", 20));
        Button backButton4 = new Button("Back to home page");
        backButton4.setLayoutX(5); 
        backButton4.setLayoutY(195);
        backButton4.setOnAction(e -> switchToScene1());
       
        

        //add button to scene3 to see workout history in scene5
        Button scene5button1 = new Button("See workout history");
        scene5button1.setLayoutX(5);
        scene5button1.setLayoutY(170);
        scene5button1.setOnAction(e -> switchToScene5());

        Label enter1 = new Label("Enter Your Workout");
        enter1.setLayoutX(10);
        enter1.setLayoutY(25);

        Button backButton5 = new Button("Back to home page");
        backButton5.setOnAction(e -> switchToScene1());
        

        //add button to scene4 to see workout history in scene5
        Button scene5button2 = new Button("See workout history");
        scene5button2.setLayoutX(5);
        scene5button2.setLayoutY(170);
        scene5button2.setOnAction(e -> switchToScene5());

        Label enter2 = new Label("Enter Your Workout");
        enter2.setLayoutX(10);
        enter2.setLayoutY(25);
        

        //add button on scene5 to go back to scene1
        workoutHistoryLayout.getChildren().addAll(backButton5);
        
        workoutInputLayout1.getChildren().addAll(scene3Text, enter1, hbox1, hbox2, hbox3, saveButton1, scene5button1, backButton3);
        workoutInputLayout2.getChildren().addAll(scene4Text, enter2, hbox4, hbox5, hbox6, saveButton2, scene5button2, backButton4);
        
        // Set the initial scene
        primaryStage.setScene(scene1);
       

        // Set the title of the stage
        primaryStage.setTitle("Fitness Tracker");


        // Show the stage
        primaryStage.show();
        }

        //switch scene methods
        private void switchToScene1() {
        primaryStage.setScene(scene1);
        primaryStage.setTitle("Fitness Tracker");
        }

        private void switchToScene2() {
        primaryStage.setScene(scene2);
        primaryStage.setTitle("Fitness Tracker");
        }
        private void switchToScene3() {
        primaryStage.setScene(scene3);
        primaryStage.setTitle("Cardio");
        }
        private void switchToScene4() {
        primaryStage.setScene(scene4);
        primaryStage.setTitle("Strength Training");
        }
        private void switchToScene5() {
        primaryStage.setScene(scene5);
        primaryStage.setTitle("Workout History");
        }    
    
        private void saveWorkout(String workout1, String workout2, String workout3) {
            workoutHistory.add(workout1);
            workoutHistory.add(workout2);
            workoutHistory.add(workout3);
            updateWorkoutHistoryTextArea();
        }
    
        private void updateWorkoutHistoryTextArea() {
            StringBuilder historyText = new StringBuilder();
            for (String workout : workoutHistory) {
                historyText.append(workout).append("\n");
                
            }
            workoutHistoryTextArea.setText(historyText.toString());
        }
        }
