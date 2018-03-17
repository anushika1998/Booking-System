package roommanagement;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author verma
 */
public class RoomBook extends Application {
    Label label1;
    Label label2;
    Label label3;
    Label label4;
    Label label5;
    Label label6;
    Label label7;
    Label label8;

    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    
    TextField tf1 = new TextField();
    TextField tf2 = new TextField();
    TextField tf3 = new TextField();
    TextField tf4 = new TextField();
    TextField tf5 = new TextField();
    
    UserClass user;
    
    public RoomBook(UserClass user){
        super();
        this.user=user;
    }
    
    @Override
    public void start(Stage primaryStage) {
        button1 = new Button("Back"); // to go to the home page
        button2 = new Button("Check"); // to check if the room is available  
        button3 = new Button("Book"); // to book the room 
        
        
        label1 = new Label("Select the room number "); 
        label2 = new Label("Expected capacity"); 
        label3 = new Label("Purpose for booking");
        label4 = new Label("Time ");
        label5 = new Label("From ");
        label6 = new Label("Till ");
        label7 = new Label("Date ");
        
        ChoiceBox <String> roomChoice = new ChoiceBox(FXCollections.observableArrayList( "C01", "C02", "C03","C11","C12","C13","C21","C22","C23","C24","S01","S02","LR11","LR21","LR33"));// to get the room number to be checked or booked
        ChoiceBox Month = new ChoiceBox(FXCollections.observableArrayList( "January", "Febuary", "March","April","May","June","July","August","September","October","November","December"));
        ChoiceBox Year = new ChoiceBox(FXCollections.observableArrayList( "2017", "2018", "2019"));
        label8 = new Label("Result "); // to dislplay the result
        
        tf1.setPromptText("0");
        tf2.setPromptText("Purpose");
        tf3.setPromptText("HH:MM:SS");
        tf4.setPromptText("HH:MM:SS");
        tf5.setPromptText("YYYY/MM/DD");
        
        
        
        
        
        
        EventHandler<ActionEvent> backHandler = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("okay...");                
                UserHome log=new UserHome(user);
                Stage stage=new Stage();
                log.start(stage);
                primaryStage.close();
            }
        };
        button1.setOnAction(backHandler);
        
        
        button1.setOnMouseEntered(new EventHandler<javafx.scene.input.MouseEvent>() {
            
            @Override
            public void handle(javafx.scene.input.MouseEvent t) {
                button1.setScaleX(1.25);
                button1.setScaleY(1.25);
            }
        });

        button1.setOnMouseExited(new EventHandler<javafx.scene.input.MouseEvent>() {
        
            @Override
            public void handle(javafx.scene.input.MouseEvent t) {
                button1.setScaleX(1);
                button1.setScaleY(1);
            }
        });
        button2.setOnMouseEntered(new EventHandler<javafx.scene.input.MouseEvent>() {
            
            @Override
            public void handle(javafx.scene.input.MouseEvent t) {
                button2.setScaleX(1.75);
                button2.setScaleY(1.75);
            }
        });

        button2.setOnMouseExited(new EventHandler<javafx.scene.input.MouseEvent>() {
        
            @Override
            public void handle(javafx.scene.input.MouseEvent t) {
                button2.setScaleX(1.5);
                button2.setScaleY(1.5);
            }
        });
        
        
        
        button3.setOnMouseEntered(new EventHandler<javafx.scene.input.MouseEvent>() {
            
            @Override
            public void handle(javafx.scene.input.MouseEvent t) {
                button3.setScaleX(1.75);
                button3.setScaleY(1.75);
            }
        });

        button3.setOnMouseExited(new EventHandler<javafx.scene.input.MouseEvent>() {
        
            @Override
            public void handle(javafx.scene.input.MouseEvent t) {
                button3.setScaleX(1.5);
                button3.setScaleY(1.5);
            }
        });
        
        button3.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {
            
            @Override
            public void handle(javafx.scene.input.MouseEvent t) {
                String room=roomChoice.getValue();
                String day=tf5.getText().trim();
                String from=tf3.getText().trim();
                String till=tf4.getText().trim();
                String purpose=tf2.getText().trim();
                int capacity=Integer.parseInt(tf1.getText().trim());
                
                System.out.println("yes it is there");
                
                boolean answer=user.Booking(room, purpose, capacity, day, from, till);
                if(answer==true){
                    label8.setText("Booking done");
                }
                else{
                    label8.setText("Booking NOT done! Try again!");
                }
                
                
                System.out.println(room);
            }
        });
        
        
        EventHandler<ActionEvent> CheckHandler = new EventHandler<ActionEvent>() {   
            

            @Override
            public void handle(ActionEvent t) {
                String room=roomChoice.getValue();
                String day=tf5.getText().trim();
                String from=tf3.getText().trim();
                String till=tf4.getText().trim();
                Date on_day=null,st_at=null,ed_at=null;
                try {
                    on_day=(Date) new SimpleDateFormat("yyyy/mm/dd").parse(day);
                    DateFormat sdf = new SimpleDateFormat("hh:mm:ss");
                    st_at =  sdf.parse(from);
                    ed_at =  sdf.parse(till);
                } catch (ParseException ex) {
                    label8.setText("Enter date and time");
                }
                if((on_day!=null && st_at!=null)&& ed_at!=null){
                    if(user.isRoomAvailable(room,day,from,till)){
                        button3.setDisable(false);
                        label8.setText("Room is Available");
                    }
                    else{
                        label8.setText("Room is not Available");
                    }
                }
                
                System.out.println("got to play");
            }
        };
        button2.setOnAction(CheckHandler);
        
       
        
        button3.setDisable(true);
        
        button2.setLayoutX(95);
        button2.setLayoutY(120);
        button2.setScaleX(1.5);
        button2.setScaleY(1.5);
        
        button3.setLayoutX(255);
        button3.setLayoutY(120);
        button3.setScaleX(1.5);
        button3.setScaleY(1.5);
        
        
        HBox box2=new HBox();
        box2.setSpacing(50);
        box2.setPadding(new Insets(0, 20, 200, 20)); 
        box2.getChildren().addAll(label2,tf1);
        box2.setLayoutX(70);
        box2.setLayoutY(250);
        
        HBox box3=new HBox();
        box3.setSpacing(50);
        box3.setPadding(new Insets(0, 20, 200, 20)); 
        box3.getChildren().addAll(label3,tf2);
        box3.setLayoutX(70);
        box3.setLayoutY(300);
        
        HBox box4=new HBox();
        box4.setSpacing(50);
        box4.setPadding(new Insets(0, 20, 200, 20)); 
        box4.getChildren().addAll(label4,label5,tf3,label6,tf4);
        box4.setLayoutX(70);
        box4.setLayoutY(350);
        
        HBox box5=new HBox();
        box5.setSpacing(50);
        box5.setPadding(new Insets(0, 20, 200, 20)); 
        box5.getChildren().addAll(label7,tf5);
        box5.setLayoutX(70);
        box5.setLayoutY(400);
        
        
        
        roomChoice.setLayoutX(260);
        roomChoice.setLayoutY(200);
        
        label1.setLayoutX(70);
        label1.setLayoutY(200);
        
        button1.setLayoutX(650);
        button1.setLayoutY(20);
        
        label8.setLayoutX(70);
        label8.setLayoutY(50);
                
        
        Pane root = new Pane();
        root.getChildren().addAll(roomChoice,button1,label1,label8,button2,button3,box2,box3,box4,box5);
        Scene scene = new Scene(root, 750 ,500);
        
        primaryStage.setTitle("Room Management System");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
