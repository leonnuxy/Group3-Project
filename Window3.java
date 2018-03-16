import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.*;
import javafx.animation.AnimationTimer;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.Random;
import java.util.Scanner;


/**
 This class initializes the window for a snake game to be played in including the movement and timers
 */
public class Window3 extends Application{
	
	//Initialize all variables
    public int score;
    boolean R = false;
    boolean L = false;
    boolean U = false;
    boolean D = false;
    boolean P = false;
    double rectX=0;
    double rectY=0;
    Random rand = new Random();
    boolean check = true;
    Group space = new Group();
	private ImageView theCollectible;
	private ImageView theObstacle;
	public ImageView thePortal;
	public ImageView thePortal2;
	boolean animate_boo = true;
	
	/* Starts the window */
    public void start(Stage primaryStage){
    		Menu men = new Menu();
    		//Scene scen = new Scene(men.start(), 800, 800);
        Scene scene = new Scene(play(), 800, 800);
        //primaryStage.setScene(scen);
        //primaryStage.show();
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }
    
    /* Produces the shape from avatar class to move and the controls to be used to move it */
    public Group play(){
    	System.out.println("Start");
    	
    		//Create the objects for the screen.
        Collectible col = new Collectible();
        theCollectible = col.getCol();
        Border bor = new Border();
        Obstacle obs = new Obstacle();
        theObstacle = obs.getObs();
        Button controls = new Button();
        Label label_score = new Label("Your score is: " + score);
        Avatar new_player = new Avatar();
        ImageView player = new_player.avatar_Snake(10, 10);
        thePortal por = new thePortal();
        thePortal por2 = new thePortal();
        thePortal = por.makePortal();
        thePortal2 = por2.makePortal();
        Rectangle rect = new Rectangle (250,250,15,15);
        Rectangle rect2 = new Rectangle (600,600,15,15);
        rect.setFill(Color.RED);
        
        //checks to make sure that the portals are not in the smae quadrant.
        while(por.getSelection() == por2.getSelection()) {
        		por2.createSelection();
        }
        
        //relocate all of the positions to an initial starting point
        player.relocate(30, 30);
        theCollectible.relocate(col.setXPos2(), col.setYPos2());
        theObstacle.relocate(obs.setXPos(), obs.setYPos());
        thePortal.relocate(por.createPortalX(), por.createPortalY());
        thePortal2.relocate(por2.createPortalX(), por2.createPortalY());
        label_score.relocate(20, 240);
        controls.relocate(-50, 100);
        
        //add all of the objects to the screen
        space.getChildren().add(label_score);
        space.getChildren().add(bor.leftBorder());
        space.getChildren().add(bor.rightBorder());
        space.getChildren().add(bor.downBorder());
        space.getChildren().add(bor.upBorder());
        space.getChildren().add(player);
        space.getChildren().add(theCollectible);
        space.getChildren().add(theObstacle);
        space.getChildren().add(thePortal);
        space.getChildren().add(thePortal2);
        space.getChildren().add(rect);
        space.getChildren().add(rect2);
        space.getChildren().add(controls);
        
        //controls event handler
        controls.setOnKeyPressed(e->{
        		if(e.getCode()==KeyCode.P) {
        			P = true;
        			R=false;
                L=false;
                U=false;
                D=false;
        			
        		}
            if(e.getCode()==KeyCode.RIGHT){
                R=true;
                L=false;
                U=false;
                D=false;
                P=false;
            }
            
            if(e.getCode()==KeyCode.LEFT){
                L=true;
                R=false;
                D=false;
                U=false;
                P=false;
            }
            
            if(e.getCode()==KeyCode.UP){
                L=false;
                R=false;
                U=true;
                D=false;
                P=false;
            }
            
            if(e.getCode()==KeyCode.DOWN){
                R=false;
                L=false;
                D=true;
                U=false;
                P=false;
            }
        });
        
        //Animates the movement
        AnimationTimer animate=new AnimationTimer(){
            //handler for the animation of the movement
            public void handle(long arg0) {
            		
                if(R){
                    rectX+=3.0;
                    player.setTranslateX(rectX);
                    //System.out.println("" + (player.getTranslateX()+30) + " " + (player.getTranslateY()+30));
                }
                
                if(L){
                    rectX-=3.0;
                    player.setTranslateX(rectX);
                    //System.out.println("" + (player.getTranslateX()+30) + " " + (player.getTranslateY()+30));
                }
                
                if(U){
                    rectY-=3.0;
                    player.setTranslateY(rectY);
                    //System.out.println("" + (player.getTranslateX()+30) + " " + (player.getTranslateY()+30));
                }
                
                if(D){
                    
                    rectY+=3.0;
                    player.setTranslateY(rectY);
                    //System.out.println("" + (player.getTranslateX()+30) + " " + (player.getTranslateY()+30));
                    
                }
                
                if(P){
                		//moves the player to 0,0 and ends the game
                		rectY = player.getTranslateY();
                		rectX = player.getTranslateX();
                		//System.out.println("" + (player.getTranslateX()+30) + " " + (player.getTranslateY()+30));
                		player.setTranslateY(0);
                		player.setTranslateX(0);
                		player.relocate(rectX, rectY);
                		
                }
                
                //collision between player controlled object and borders
                if ((player.getBoundsInParent().intersects(theObstacle.getBoundsInParent()))||
                    (player.getBoundsInParent().intersects(bor.borLXPos, bor.borLYPos, bor.borLWidth, bor.borLHeight))||
                    (player.getBoundsInParent().intersects(bor.borRXPos, bor.borRYPos, bor.borRWidth, bor.borRHeight)) ||
                    (player.getBoundsInParent().intersects(bor.borUXPos, bor.borUYPos, bor.borUWidth, bor.borUHeight)) ||
                    (player.getBoundsInParent().intersects(bor.borDXPos, bor.borDYPos, bor.borDWidth, bor.borDHeight))){
                    
                    label_score.setText("You Died");
                    //System.out.println("" + player.getBoundsInParent());
                    this.stop();
                }
                
                //collision between player controlled objects and collectible
                if (player.getBoundsInParent().intersects(theCollectible.getBoundsInParent())) {
                    theCollectible.relocate(col.setXPos2(), col.setYPos2());
                    theCollectible.getBoundsInParent();
                    space.getChildren().remove(theCollectible);
                    space.getChildren().add(theCollectible);
                    score++;
                    label_score.setText("Your score is: " + score);
                    
                }
                
                //makes sure that the Collectible and the Obstacle do not appear in the same spot
                if (theCollectible.getBoundsInParent().intersects(obs.getXPos(), obs.getYPos(), obs.getWidth(), obs.getHeight())) {
                		theCollectible.relocate(col.setXPos2(), col.setYPos2());
                }
                
                //moves the player to to the black rectangle after they collide with a portal.
                if (player.getBoundsInParent().intersects(thePortal.getBoundsInParent())) {
                	
                		int xcood = por2.getXCood();
                		int ycood = por2.getYCood();
                		player.setTranslateX(0);
                		player.setTranslateY(0);
                		space.getChildren().remove(player);
                		player.relocate(rect.getX(), rect.getY() );
                		space.getChildren().add(player);
                		thePortal.getBoundsInParent();
                		space.getChildren().remove(thePortal);
                		space.getChildren().add(thePortal);
                		//System.out.println("Going to Portal 2 at " + por2.getXCood() + ", "+ por2.getYCood());
                		//
                		
                }
                
                //moves the player to the red rectangele after they collide with portal.
                if (player.getBoundsInParent().intersects(thePortal2.getBoundsInParent())) {
                		
                		int xcood = por.getXCood();
                		int ycood = por.getYCood();
                		player.setTranslateX(0);
                		player.setTranslateY(0);
                		space.getChildren().remove(player);
	            		player.relocate(rect2.getX(), rect2.getY());
	            		thePortal2.getBoundsInParent();
	            		space.getChildren().add(player);
	            		//System.out.println("Going to Portal 1 at: " + por.getXCood() + ", "+ por.getYCood());
	            		thePortal.getBoundsInParent();
	            		space.getChildren().remove(thePortal2);
	            		space.getChildren().add(thePortal2);
                }
            }
        };
        animate.start();
        
        //System.out.println("Portal 1 " + por.getXCood() + " , "+ por.getYCood());
        //System.out.println("Portal 2 " + por2.getXCood() + " , "+ por2.getYCood());
        return space;
    }
    
    /* Launch all arguments */
    public static void main(String[] args){
        
        launch(args);
    }
}