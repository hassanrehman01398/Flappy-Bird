/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flappybird;

import java.util.Random;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author hp
 */
public class Flappybird extends Application {
    int gravity=5;
    int up=0;
    int pipe1=-5;
    Label l1=new Label();
    Label l2=new Label();
    Timeline tm;
    @Override
    public void start(Stage primaryStage) {
    
       Pane root = new Pane();
      
        Image i=new Image("images/flappy1.gif");
            
        ImageView im=new ImageView(i);
        im.setFitHeight(70);
        im.setFitWidth(60);
        im.setX(100);
        im.setY(200);
        Image i1=new Image("images/pipeUp.png");
        Image i2=new Image("images/pipeDown.png");
        
        //Image[] img=new Image[]{i1,i2};
        //Random rd=new Random();
        //int k=rd.nextInt(2);
        
        ImageView im1=new ImageView(i1);
          im1.setFitHeight(250);
        im1.setFitWidth(300);
        im1.setX(550);
        im1.setY(0);
        im1.setRotate(180);
        ImageView im2=new ImageView(i2);
          im2.setFitHeight(300);
        im2.setFitWidth(100);
        im2.setX(570);
        im2.setY(330);
        
//        Image ii1=new Image("images/pipeUp.png");
//        ImageView imm1=new ImageView(ii1);
//          im1.setFitHeight(250);
//        imm1.setFitWidth(300);
//        imm1.setX(550);
//        imm1.setY(0);
//        imm1.setRotate(180);
//        Image ii2=new Image("images/pipeDown.png");
//        ImageView imm2=new ImageView(ii2);
//          imm2.setFitHeight(300);
//        imm2.setFitWidth(100);
//        imm2.setX(570);
//        imm2.setY(330);
//        
        
        Image i3=new Image("images/ground.png");
        ImageView im3=new ImageView(i3);
      
          im3.setFitHeight(140);
        im3.setFitWidth(300);
        im3.setX(0);
        im3.setY(630);
        tm=new Timeline(new KeyFrame(Duration.millis(30), new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent event) {
//         im.setY(im.getY()+gravity);
//       
im1.setX(im1.getX()+pipe1);
//String h1=im1.toString();
l1.setText(im1.getX()+"");
l1.setLayoutX(400);
l1.setLayoutY(300);
im2.setX(im2.getX()+pipe1);
//String h2=im2.toString();
l2.setText(im2.getX()+"");
//im.intersects(im1.getX()+143, im1.getY()-13,im1.getFitWidth()-290, im1.getFitHeight()-13)||im.intersects(im2.getX()+25, im2.getY()+25,im2.getFitWidth()-25, im2.getFitHeight()-15
if(im.intersects(im3.getX(),im3.getY()+15, im3.getFitWidth(), im3.getFitHeight())||im.intersects(im1.getX()+143, im1.getY()-13,im1.getFitWidth()-290, im1.getFitHeight()-13)||im.intersects(im2.getX()+25, im2.getY()+25,im2.getFitWidth()-25, im2.getFitHeight()-15))
//Bounds bim=im.getBoundsInParent();
//Bounds bim1=im1.getBoundsInParent();
//Bounds bim2=im2.getBoundsInParent();
//Bounds bim3=im3.getBoundsInParent();
//if(bim.intersects(bim3)||bim.intersects(bim1)||bim.intersects(bim2))

{

tm.pause();

  }
Random rd1=new Random();
int k=rd1.nextInt(300);
int y=rd1.nextInt(300);
if(im1.getX()<-700)
{

im1.setX(1350);
im1.setFitWidth(k);
im1.setFitHeight(y);
}
if(im2.getX()<-700)
{
im2.setFitWidth(k);
im2.setFitHeight(y);
im2.setX(1400);
}

    
l2.setLayoutX(400);
l2.setLayoutY(400);
up+=gravity;
           im.setY(up);
           }
       }));
        tm.setCycleCount(Timeline.INDEFINITE);
        tm.play();
   im3.fitWidthProperty().bind(root.widthProperty());
      im.setOnKeyPressed(new EventHandler<KeyEvent>() {
           @Override
           public void handle(KeyEvent event) {
           if(event.getCode()==KeyCode.SPACE)
           {
           gravity=-5;
       //    im.setLayoutY(im.getLayoutY()-gravity);
            }
///           else
   //        {
     //        }
           }
       });
      im.setOnKeyReleased(new EventHandler<KeyEvent>() {
           @Override
           public void handle(KeyEvent event) {
          
          // if(event.getCode()!=KeyCode.SPACE)
           {
               gravity=5;
     //      im.setLayoutY(im.getLayoutY()+gravity);
           
           }
           }
       });
        root.getChildren().addAll(im,im1,im2,im3,l1,l2);
        root.setStyle("-fx-background-color: LIGHTBLUE");
        Scene scene = new Scene(root, 300, 250);
        primaryStage.setMaximized(true);
        primaryStage.setResizable(false);
        primaryStage.setTitle("FlappyBird");
        primaryStage.setScene(scene);
        im.requestFocus();
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
