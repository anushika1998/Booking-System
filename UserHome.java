/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roommanagement;
//show all courses
// time and date
import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author verma
 */
public class UserHome extends Application {
    Label label1;
    Label label2;
    Label label3;
    Label label4;
    Label label5;

    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    
    UserClass user;

    public UserHome(UserClass user){
//        super();
        this.user=user;
    }

    
        
    @Override
    public void start(Stage primaryStage) {
        label1= new Label("Name"); // To say welcome
        
        
        
        button1 = new Button("Book a room"); // to check if room is available and book it if required
        button2 = new Button("Rooms booked"); // to check the rooms you booked and cancel them if wnated 
        button3 = new Button("Show requests"); // to show the requests for room booking and accept or reject them accordingly
        button4 = new Button("Log Out"); // to log out
        button5 = new Button("Time Table"); // To show the time table for this semester
        button6 = new Button("Personalized Time Table"); // To show the personalized time table for this semeste
        button7 = new Button("Course Selection"); // To select the course of user's choice
        
        label1.setText(user.getName());
        
        EventHandler<ActionEvent> BookRoomHandler = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("okay...");                
                RoomBook log=new RoomBook(user);
                Stage stage=new Stage();
                log.start(primaryStage);
                //primaryStage.close();
            }
        };
        button1.setOnAction(BookRoomHandler);
        
        EventHandler<ActionEvent> RoomsBookedHandler = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("okay..."); 
                ArrayList<String> bookedrooms= new ArrayList();
                bookedrooms=user.UserRoomsBooked();
                System.out.println(bookedrooms.toString());
                RoomCancel log=new RoomCancel(user,bookedrooms);
                Stage stage=new Stage();
                log.start(primaryStage);
                //primaryStage.close();
            }
        };
        button2.setOnAction(RoomsBookedHandler);
        
        EventHandler<ActionEvent> RequestsHandler = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("okay...");                
                
                ArrayList<String> req= new ArrayList();
                req=user.ShowRequests();
                System.out.println(req.toString());
                ShowRequests log=new ShowRequests(user,req);
                Stage stage=new Stage();
                log.start(stage);
                primaryStage.close();
            }
        };
        button3.setOnAction(RequestsHandler);
        
        EventHandler<ActionEvent> CourseSelHandler = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("okay...");                
                CourseSelection co=new CourseSelection(user);
                Stage stage=new Stage();
                co.start(stage);
                primaryStage.close();
            }
        };
        button7.setOnAction(CourseSelHandler);
        
        
        
        EventHandler<ActionEvent> logoutHandler = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("okay...");                
                LogIn log=new LogIn();
                Stage stage=new Stage();
                log.start(stage);
                primaryStage.close();
            }
        };
        button4.setOnAction(logoutHandler);
        
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
                button2.setScaleX(1.25);
                button2.setScaleY(1.25);
            }
        });

        button2.setOnMouseExited(new EventHandler<javafx.scene.input.MouseEvent>() {
        
            @Override
            public void handle(javafx.scene.input.MouseEvent t) {
                button2.setScaleX(1);
                button2.setScaleY(1);
            }
        });
        
        button2.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>(){
            @Override
            public void handle(javafx.scene.input.MouseEvent t) {
                
            }
        });
        
        button3.setOnMouseEntered(new EventHandler<javafx.scene.input.MouseEvent>() {
            
            @Override
            public void handle(javafx.scene.input.MouseEvent t) {
                button3.setScaleX(1.25);
                button3.setScaleY(1.25);
            }
        });

        button3.setOnMouseExited(new EventHandler<javafx.scene.input.MouseEvent>() {
        
            @Override
            public void handle(javafx.scene.input.MouseEvent t) {
                button3.setScaleX(1);
                button3.setScaleY(1);
            }
        });
        
        button4.setOnMouseEntered(new EventHandler<javafx.scene.input.MouseEvent>() {
            
            @Override
            public void handle(javafx.scene.input.MouseEvent t) {
                button4.setScaleX(1.25);
                button4.setScaleY(1.25);
            }
        });

        button4.setOnMouseExited(new EventHandler<javafx.scene.input.MouseEvent>() {
        
            @Override
            public void handle(javafx.scene.input.MouseEvent t) {
                button4.setScaleX(1);
                button4.setScaleY(1);
            }
        });
        
        button5.setOnMouseEntered(new EventHandler<javafx.scene.input.MouseEvent>() {
            
            @Override
            public void handle(javafx.scene.input.MouseEvent t) {
                button5.setScaleX(1.25);
                button5.setScaleY(1.25);
            }
        });

        button5.setOnMouseExited(new EventHandler<javafx.scene.input.MouseEvent>() {
        
            @Override
            public void handle(javafx.scene.input.MouseEvent t) {
                button5.setScaleX(1);
                button5.setScaleY(1);
            }
        });
        
        button6.setOnMouseEntered(new EventHandler<javafx.scene.input.MouseEvent>() {
            
            @Override
            public void handle(javafx.scene.input.MouseEvent t) {
                button6.setScaleX(1.25);
                button6.setScaleY(1.25);
            }
        });

        button6.setOnMouseExited(new EventHandler<javafx.scene.input.MouseEvent>() {
        
            @Override
            public void handle(javafx.scene.input.MouseEvent t) {
                button6.setScaleX(1);
                button6.setScaleY(1);
            }
        });
        
        button7.setOnMouseEntered(new EventHandler<javafx.scene.input.MouseEvent>() {
            
            @Override
            public void handle(javafx.scene.input.MouseEvent t) {
                button7.setScaleX(1.25);
                button7.setScaleY(1.25);
            }
        });

        button7.setOnMouseExited(new EventHandler<javafx.scene.input.MouseEvent>() {
        
            @Override
            public void handle(javafx.scene.input.MouseEvent t) {
                button7.setScaleX(1);
                button7.setScaleY(1);
            }
        });
        
        
        VBox box1=new VBox();
        box1.setSpacing(10);
        box1.setPadding(new Insets(0, 20, 200, 20)); 
        box1.getChildren().addAll(button1,button2,button3,button7);
        box1.setLayoutX(75);
        box1.setLayoutY(50);
        
        VBox box2=new VBox();
        box2.setSpacing(10);
        box2.setPadding(new Insets(0, 20, 10, 20));
        box2.getChildren().addAll(button4,button5,button6);
        box2.setLayoutX(250);
        box2.setLayoutY(10);
        box2.setAlignment(Pos.TOP_LEFT);
        
        VBox box3= new VBox();
        box3.setSpacing(10);
        box3.getChildren().add(label1);
        box3.setLayoutX(50);
        box3.setLayoutY(10);
        
                
        
        Pane root = new Pane();
        root.getChildren().addAll(box3,box1,box2);
        Scene scene = new Scene(root, 400 ,250);
        
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
