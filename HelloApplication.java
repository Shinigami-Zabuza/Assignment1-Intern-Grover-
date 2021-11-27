package com.example.javafx_project1;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.StackPane;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.event.ActionEvent;

import java.io.IOException;

public class HelloApplication extends Application
{
    @Override
    public void start(Stage stage) throws IOException
    {
        //creating 2 input textfields and 1 submit button (required task)
        TextField t1 = new TextField("Enter");     //create first input textfield
        t1.setAlignment(Pos.CENTER);                  //textfield1's text is aligned to center
        TextField t2 = new TextField("Enter");     //create second input textfield
        t2.setAlignment(Pos.CENTER);                  //textfield1's text is aligned to center

        Button b = new Button();                      //create a button
        b.setText("Submit Button");
        b.setTranslateX(-190);                        //fix the position of button
        b.setTranslateY(20);                          //these x,y works best for our code




        //-----------------------------------------------------CREATIVE COMPONENT 1
        // Add labels to mention/indicate the textfields to user
        Label l1 = new Label("Text Field 1->");    //create label1
        l1.setPrefWidth(150);                         //set width of label component
        Label l2 = new Label("Text Field 2->");    //create label2
        l2.setPrefWidth(150);                         //set width of label component
        //------------------------------------------------------------------------






        //---------------------------------------------------------CREATIVE COMPONENT 2
        // on pressing submit, the 2 input strings (in textfields) will get added/concatenated
        // and computed result will be shown as a text on label named result
        Label result = new Label("(Creative component) Result of adding 2 input strings will be");  //create a label
        result.setTranslateX(125);                                    //fix label's position
        result.setTranslateY(200);
        //to change text of label when input(/event) is given, we create an event handler for button
        EventHandler<ActionEvent> buttonEvent = new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent e)
            {
                result.setText(t1.getText()+t2.getText());    //add texts in textfield 1&2
            }
        };
        b.setOnAction(buttonEvent);                 //call event handler when submit button is clicked
        //------------------------------------------------------------------------------------



        HBox h1 = new HBox(l1,t1);                    //to put textfield1 and label1 in same row
        h1.setAlignment(Pos.CENTER);                  //align components of this hbox in center

        HBox h2 = new HBox(l2,t2);                    //to put textfield1 and label1 in same row
        h2.setAlignment(Pos.CENTER);                  //align components of this hbox in center

        VBox v = new VBox();                         //create vbox
        v.getChildren().addAll(h1,h2,b,result);               //add both hbox and button and result components to it

        /*Now, since we want only the textfields at centre and not the whole hbox(ie labels + textfield)
          we can't use inbuilt methods, So, we use setMargin() method of vbox and using Insets()
          we fixed the offsets (for example 150 from left- best for our 600x600 scene) to bring
          the textfields at the centre of screen (as it was the questions requirement.
          -Also, we put a 10 offset from top FOR h2 because we want the 2 textfields to have some
          verticle distance between them, and not get congested (one just below other).
          -we put a 10 offset for h1, just to bring everything at centre of screen
         */
        v.setMargin(h1, new Insets(10,150,0,0));
        v.setMargin(h2, new Insets(10,150,0,0));
        v.setAlignment(Pos.CENTER);                     //set the alignment of vbox's components to centre

        Scene sc = new Scene(v, 600,600);        //add vbox (ie all components to the scene

        stage.setTitle("Assignment");
        stage.setScene(sc);                            //add scene to the stage
        stage.show();                                  //and make stage visible



    }

    public static void main(String[] args) {
        launch();
    }
}