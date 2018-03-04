import java.util.Random;

import javafx.scene.shape.Rectangle;

/** This class creates an Obstacle optimized for a 500 by 500 field*/
public class Obstacle_Jon {
  int obsXPos, xDefine;
  int obsYPos, yDefine;
  int obsWidth;
  int obsHeight;
  Rectangle obsWindow;

  Random rand = new Random();

  public Obstacle_Jon(){
    this.obsXPos = this.setXPos();
    this.obsYPos = this.setYPos();
    this.obsWidth = this.setWidth();
    this.obsHeight = this.setHeight();
    this.obsWindow = this.getObs();
  
  }

  //This constructor allows the creation of a obstacle with custom shape(for borders);
  public Obstacle_Jon(int borX, int borY, int borW, int borH){
    this.obsXPos = borX;
    this.obsYPos = borY;
    this.obsWidth = borW;
    this.obsHeight = borH;
  
  }







  //Define variables choose a random section(1-5) of the field to place object

  //10 pix of section are given to where potential collectibles will be place

  public int setXPos(){
    xDefine = rand.nextInt(5) + 1;
    if (xDefine == 1) {
      obsXPos = rand.nextInt(90-10) + 10;
    }

    if (xDefine == 2) {
      obsXPos = rand.nextInt(190-100) + 100;
    }

    if (xDefine == 3) {
      obsXPos = rand.nextInt(290-200) + 200;
    }

    if (xDefine == 4) {
      obsXPos = rand.nextInt(390-300) + 300;
    }

    if (xDefine == 5) {
      obsXPos = rand.nextInt(490-400) + 400;
    }

    return obsXPos;

  }



  public int setYPos(){

    yDefine = rand.nextInt(5) + 1;

    if (yDefine == 1) {
      obsYPos = rand.nextInt(90-10) + 10;
    }

    if (yDefine == 2) {
      obsYPos = rand.nextInt(190-100) + 100;
    }

    if (yDefine == 3) {
      obsYPos = rand.nextInt(290-200) + 200;
    }

    if (yDefine == 4) {
      obsYPos = rand.nextInt(390-300) + 300;
    }

    if (yDefine == 5) {
      obsYPos = rand.nextInt(490-400) + 400;
    }

    return obsYPos;

  }



  public int setWidth(){
    obsWidth = rand.nextInt(30) + 15;
    return obsWidth;

  }



  public int setHeight(){
    obsHeight = rand.nextInt(30) + 15;
    return obsHeight;

  }



  public Rectangle getObs(){
    obsWindow = new Rectangle(obsXPos, obsYPos, obsWidth, obsHeight);
    return obsWindow;

  }

}