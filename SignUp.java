/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roommanagement;

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
public class SignUp extends Application {
    Label label1;
    Label label2;
    Label label3;
    Label label4;
    Label label5;

    Button button1;
    Button button2;

    TextField tf1;
    PasswordField pwdf1;
    PasswordField pwdf2;
    
    @Override
    public void start(Stage primaryStage) {
        label1= new Label("Sign Up"); // To say welcome
        label2= new Label("Email"); // To ask eid
        label3= new Label("Password"); // To ask password
        label4= new Label("Re-enter Password"); // To ask for creating a new account
        label5= new Label("Type of user"); // To ask for creating a new account
        
        final ToggleGroup group1 = new ToggleGroup();

        RadioButton rb1 = new RadioButton("Admin");
        rb1.setToggleGroup(group1);
        rb1.setSelected(true);

        RadioButton rb2 = new RadioButton("Faculty");
        rb2.setToggleGroup(group1);

        RadioButton rb3 = new RadioButton("Student");
        rb3.setToggleGroup(group1);
        
        button1 = new Button("Back"); // To go to prev frame
        button2 = new Button("Signup Here"); // To Signup
        
        tf1= new TextField(); // To put eid
        tf1.setPromptText("Enter Email Id");
        pwdf1 = new PasswordField(); // To put password
        pwdf1.setPromptText("Enter password");
        pwdf2 = new PasswordField(); // To put password
        pwdf2.setPromptText("Re-enter password");
        
        label2.setPadding(new Insets(0, 20, 10, 20));
        label3.setPadding(new Insets(0, 20, 10, 20));
        label4.setPadding(new Insets(0, 20, 10, 20));
        label5.setPadding(new Insets(0, 20, 10, 20));
        button1.setLayoutX(350);
        button1.setLayoutY(0);
        button2.setLayoutX(75);
        button2.setLayoutY(200);
        
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
        
        
        EventHandler<ActionEvent> backHandler = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("okay...");                
                LogIn log=new LogIn();
                Stage stage=new Stage();
                log.start(stage);
                primaryStage.close();
            }
        };
        button1.setOnAction(backHandler);
        
        EventHandler<ActionEvent> SigninHandler = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
                String type="";
                String email=tf1.getText();
                String pwd1=pwdf1.getText();
                String pwd2=pwdf2.getText();
                if(rb1.isSelected()){
                    type="Admin";
                }
                else if(rb2.isSelected()){
                    type="Faculty";
                }
                else if(rb3.isSelected()){
                    type="Student";
                }
                
                if(!pwd1.equals(pwd2)){
                    tf1.setText("");
                    pwdf1.setText("");
                    pwdf2.setText("");
                    System.out.println("tryagain");
                    group1.selectToggle(rb1);
                    return;
                }
                else if(email.trim().equalsIgnoreCase("")){
                    tf1.setText("");
                    pwdf1.setText("");
                    pwdf2.setText("");
                    System.out.println("tryagain1");
                    group1.selectToggle(rb1);
                    return;
                }
                else if((pwd1.trim().length()==0)||(pwd2.trim().length()==0)){
                    tf1.setText("");
                    pwdf1.setText("");
                    pwdf2.setText("");
                    System.out.println("tryagain2");
                    group1.selectToggle(rb1);
                    return;
                }
                try {
                    UserClass temp = new UserClass();
                    boolean answer=temp.addUser(email, pwd1, type, "Add textfield"); 
                    if(answer==true){
                        System.out.println("done");
                        LogIn log=new LogIn();
                        Stage stage=new Stage();
                        log.start(stage);
                        primaryStage.close();
                    }
                    else{
                        System.out.println("not right");
                        tf1.setText("");
                        pwdf1.setText("");
                        pwdf2.setText("");
                        group1.selectToggle(rb1);
                    }
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        };
        button2.setOnAction(SigninHandler);
        
        VBox box1=new VBox();
        box1.setSpacing(10);
        box1.setPadding(new Insets(0, 20, 200, 20)); 
        box1.getChildren().addAll(label2,label3, label4);
        box1.setLayoutX(10);
        box1.setLayoutY(50);
        
        VBox box2=new VBox();
        box2.setSpacing(10);
        box2.setPadding(new Insets(0, 20, 10, 20));
        box2.getChildren().addAll(tf1,pwdf1,pwdf2);
        box2.setLayoutX(150);
        box2.setLayoutY(50);
        
        VBox box3= new VBox();
        box3.setSpacing(10);
        box3.getChildren().add(label1);
        box3.setLayoutX(120);
        box3.setLayoutY(10);
        
        VBox box4= new VBox();
        box4.setSpacing(10);
        box4.getChildren().addAll(label5);
        box4.setLayoutX(10);
        box4.setLayoutY(160);
        
        HBox hbox = new HBox(rb1, rb2, rb3);
        hbox.setSpacing(10);
        hbox.setLayoutX(150);
        hbox.setLayoutY(160);
        
        Pane root = new Pane();
        root.getChildren().addAll(box3,box1,box2,button1,box4,hbox,button2);
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
