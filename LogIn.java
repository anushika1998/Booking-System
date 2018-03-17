package roommanagement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.stage.Stage;

/**
 *
 * @author verma
 */
public class LogIn extends Application {
    Label label1;
    Label label2;
    Label label3;
    Label label4;
    
    

    Button button1;
    Button button2;

    TextField tf1;
    PasswordField passwordField;
        
    @Override
    public void start(Stage primaryStage) {
        label1= new Label("Welcome"); // To say welcome
        label2= new Label("Email"); // To ask eid
        label3= new Label("Password"); // To ask password
        label4= new Label("Dont't have an Account"); // To ask for creating a new account
        
        button1 = new Button("Login"); // To login
        button2 = new Button("Signup Here"); // To Signup
        
        tf1= new TextField(); // To put eid
        tf1.setPromptText("Enter Email Id");
        passwordField = new PasswordField(); // To put password
        passwordField.setPromptText("Enter password");
        
        label2.setPadding(new Insets(0, 20, 10, 20));
        label3.setPadding(new Insets(0, 20, 10, 20));
        button1.setLayoutX(120);
        button1.setLayoutY(120);
        
        button1.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {
            
            @Override
            public void handle(javafx.scene.input.MouseEvent t) {
                
                try {
                    UserClass temp=new UserClass();
                    String email=tf1.getText().trim();
                    boolean answer=temp.isUserThere(email, passwordField.getText());
                    if(answer==true){
                        temp.setEmail(email);
                        temp.setName();
                        temp.setType();
                        UserHome uh=new UserHome(temp);
                        Stage stage=new Stage();
                        uh.start(primaryStage);
                        //primaryStage.close();
                    }
                    else{
                        tf1.setText("");
                        passwordField.setText("");
                        System.out.println("Wrong");
                    }
                    
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                    
                
            }
        });
        
        EventHandler<ActionEvent> SignUpHandler = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            System.out.println("okay...");                
            SignUp sU=new SignUp();
            Stage stage=new Stage();
            sU.start(stage);
            primaryStage.close();
        }
    };
        
        button2.setOnAction(SignUpHandler);
        
        
        
        
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
        
        VBox box1=new VBox();
        box1.setSpacing(10);
        box1.setPadding(new Insets(0, 20, 200, 20)); 
        box1.getChildren().addAll(label2,label3);
        box1.setLayoutX(10);
        box1.setLayoutY(50);
        
        VBox box2=new VBox();
        box2.setSpacing(10);
        box2.setPadding(new Insets(0, 20, 10, 20));
        box2.getChildren().addAll(tf1,passwordField);
        box2.setLayoutX(150);
        box2.setLayoutY(50);
        
        VBox box3= new VBox();
        box3.setSpacing(10);
        box3.getChildren().add(label1);
        box3.setLayoutX(120);
        box3.setLayoutY(10);
        
        VBox box4= new VBox();
        box4.setSpacing(10);
        box4.getChildren().addAll(label4,button2);
        box4.setLayoutX(75);
        box4.setLayoutY(160);
        box4.setAlignment(Pos.CENTER);
        
        AnchorPane root = new AnchorPane();
        root.getChildren().addAll(box3,box1,box2,button1,box4);
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
