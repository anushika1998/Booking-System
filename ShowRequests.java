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
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author verma
 */
public class ShowRequests extends Application {
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
    ArrayList<String> req=new ArrayList();
    public ShowRequests(UserClass user, ArrayList<String> l){
        super();
        this.user=user;
        req=l;
    }
    
    @Override
    public void start(Stage primaryStage) {
        button1 = new Button("Back"); // to go to the home page
        button2 = new Button("Accept"); // to accept the room booking  
        button3 = new Button("Reject"); // to reject the room booking
        
        
        label1 = new Label("Select the request "); 
        ChoiceBox cb = new ChoiceBox(FXCollections.observableArrayList( req));// to get the room numbers that are booked by you
        label2 = new Label("Result "); // to dislplay the result
        label3 = new Label("Details "); // to dislplay the details about the request
        
        
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
        
        EventHandler<ActionEvent> AcceptHandler = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("okay...");                
                String s=(String)cb.getValue();
                System.out.println("dvfdfv");
                System.out.println(user.getName());
                boolean answer=user.acceptingRequests(s);
                if(answer==true){
                    label2.setText("Request Has been Rejected");
                    this.deleteFromList(s);
                    
                }
                else{
                    label2.setText("Request Could not be Rejected");
                }
            }

            private void deleteFromList(String room) {
                int len=req.size();
                for(int i=0;i<len;i++){
                    if(room.equals(req.get(i))){
                        req.remove(i);
                    }
                }
            }
        };
        button2.setOnAction(AcceptHandler);
        
        
        EventHandler<ActionEvent> RejectHandler = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("okay...");                
                String s=(String)cb.getValue();
                System.out.println("dvfdfv");
                System.out.println(user.getName());
                boolean answer=user.rejectingRequests(s);
                if(answer==true){
                    label2.setText("Request Has been Rejected");
                    
                }
                else{
                    label2.setText("Request Could not be Rejected");
                }
            }
        };
        button3.setOnAction(RejectHandler);
        
        
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
        
        
        HBox box1=new HBox();
        box1.setSpacing(50);
        box1.setPadding(new Insets(0, 20, 200, 20)); 
        box1.getChildren().addAll(label1, cb);
        box1.setLayoutX(70);
        box1.setLayoutY(100);
        
        label3.setLayoutX(100);
        label3.setLayoutY(140);
        
        // show all requests 
        
        button1.setLayoutX(300);
        button1.setLayoutY(30);
        
        label2.setLayoutX(70);
        label2.setLayoutY(220);
        
        HBox box2=new HBox();
        box2.setSpacing(50);
        box2.setPadding(new Insets(0, 20, 200, 20)); 
        box2.getChildren().addAll(button2, button3);
        box2.setLayoutX(70);
        box2.setLayoutY(160);
                
        
        Pane root = new Pane();
        root.getChildren().addAll(box1,button1,label2,box2);
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
