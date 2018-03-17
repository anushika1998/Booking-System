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
public class RoomCancel extends Application {
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
    ArrayList<String> bookedrooms=new ArrayList();
    public RoomCancel(UserClass user,ArrayList<String> l){
        
        this.user=user;
        this.bookedrooms=l;
        
    }
    
    @Override
    public void start(Stage primaryStage) {
        button1 = new Button("Back"); // to go to the home page
        button2 = new Button("Cancel"); // to cancel if the room is booked by you  
         
        
        
        label1 = new Label("Select the room to cancel "); 
        ChoiceBox cb = new ChoiceBox(FXCollections.observableArrayList( bookedrooms));// to get the room numbers that are booked by you
        label2 = new Label("Result "); // to dislplay the result
        
        
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
        
//        EventHandler<ActionEvent> cancelHandler = new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                System.out.println("okay...");                
//                //Object room=cb.getValue();
//                System.out.println("dvfdfv");
//                System.out.println(user.getName());
////                boolean answer=user.cancelRoom(room);
////                if(answer==true){
////                    label2.setText("Room Has been Cancelled");
////                    //this.deleteFromList(room);
////                }
////                else{
////                    label2.setText("Room Could not be Cancelled");
////                }
//            }
//
//            };
//        button2.setOnAction(cancelHandler);
             
        button2.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {
            
            @Override
            public void handle(javafx.scene.input.MouseEvent t) {
                System.out.println("okay...");                
                String room=(String)cb.getValue();
                System.out.println("dvfdfv");
                System.out.println(user.getName());
                boolean answer=user.cancelRoom(room);
                if(answer==true){
                    label2.setText("Room Has been Cancelled");
                    this.deleteFromList(room);
                }
                else{
                    label2.setText("Room Could not be Cancelled");
                }
            }

            private void deleteFromList(String room) {
                int len=bookedrooms.size();
                for(int i=0;i<len;i++){
                    if(room.equals(bookedrooms.get(i))){
                        bookedrooms.remove(i);
                    }
                }
            }
      
        });
        
       
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
        
        
        
        
        
        
        HBox box1=new HBox();
        box1.setSpacing(50);
        box1.setPadding(new Insets(0, 20, 200, 20)); 
        box1.getChildren().addAll(button2);
        box1.setLayoutX(75);
        box1.setLayoutY(150);
        
        cb.setLayoutX(260);
        cb.setLayoutY(100);
        
        label1.setLayoutX(70);
        label1.setLayoutY(100);
        
        button1.setLayoutX(300);
        button1.setLayoutY(30);
        
        label2.setLayoutX(70);
        label2.setLayoutY(200);
                
        
        Pane root = new Pane();
        root.getChildren().addAll(box1,cb,button1,label1,label2);
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
