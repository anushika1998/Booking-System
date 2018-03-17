/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roommanagement;

import java.util.ArrayList;
import javafx.application.Application;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author verma
 */
public class CourseSelection extends Application {
    Label label1;
    Label label2;
    Label label3;
    Label label4;
    Label label5;
    
    TextField tf1;

    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    
    UserClass user;
    
    public CourseSelection(UserClass user){
        
        this.user=user;
    }
    
    @Override
    public void start(Stage primaryStage) {
        button1 = new Button("Back"); // to go to the home page
        button2 = new Button("Search"); // to search the course 
        button3 = new Button("Add"); // to add the course
        button4 = new Button("Drop"); // to drop the course  
         
        
        tf1= new TextField(); // To put course name
        tf1.setPromptText("Enter course name");
        
        label1 = new Label("Enter the course "); 
        label2 = new Label("Details about the course "); // to dislplay the result
        label3 = new Label("Course Selection");
        
        
        
        
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
        
        
//        EventHandler<ActionEvent> backHandler = new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                System.out.println("okay...");                
//                UserHome log=new UserHome(user);
//                Stage stage=new Stage();
//                log.start(stage);
//                primaryStage.close();
//            }
//        };
//        button1.setOnAction(backHandler);
        
        
        
        button2.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {
            
            @Override
            public void handle(javafx.scene.input.MouseEvent t) {
                System.out.println("yoyoy");
//                CoursesClass temp=new CoursesClass();
//                String keyword=tf1.getText();
//                int search_ind=temp.searchCourse(keyword);
//                label2.setText(temp.getDetailsText(search_ind));
            }
        });
        
        EventHandler<ActionEvent> AddHandler = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("hahah");
//                CoursesClass temp=new CoursesClass();
//                String keyword=tf1.getText();
//                int search_ind=temp.searchCourse(keyword);
//                
//                user.addCourse(temp.getDetails(search_ind));
                                
            }
        };
        button3.setOnAction(AddHandler);
        
        EventHandler<ActionEvent> DropHandler = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("iaiia");
//                CoursesClass temp=new CoursesClass();
//                String keyword=tf1.getText();
//                int search_ind=temp.searchCourse(keyword);
//                
//                user.dropCourse(temp.getDetails(search_ind));
                                
            }
        };
        button4.setOnAction(DropHandler);
        
        
        HBox box1=new HBox();
        box1.setSpacing(50);
        box1.setPadding(new Insets(0, 20, 200, 20)); 
        box1.getChildren().addAll(label1,tf1);
        box1.setLayoutX(10);
        box1.setLayoutY(70);
        
        
        label3.setLayoutX(30);
        label3.setLayoutY(30);
        
        button1.setLayoutX(300);
        button1.setLayoutY(30);
        
        label2.setLayoutX(70);
        label2.setLayoutY(170);
        
        HBox box2=new HBox();
        box2.setSpacing(50);
        box2.setPadding(new Insets(0, 20, 200, 20)); 
        box2.getChildren().addAll(button3,button4);
        box2.setLayoutX(75);
        box2.setLayoutY(200);
        
        button2.setLayoutX(100);
        button2.setLayoutY(120);
                
        
        Pane root = new Pane();
        root.getChildren().addAll(box1,button1,label3,label2,button2,box2);
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
