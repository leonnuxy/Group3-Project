import java.util.*;

public class Avatar_1{
  static String w;
  static String a;
  static String s;
  static String d;

  //public static Field2 space = new Field2();



    //gets the row and colum for the constructor.


  /*public static char getMove(){
    //Field2.print();
    System.out.print("Play: ");
    Scanner pressed = new Scanner(System.in);
    String press = pressed.nextLine();
    int row = 1;
    int column = 1;
    boolean count = true;

      if (press == w || press == a || press == d || press == s){
        while (count = true){
          if (press == w){
            row = row -1;
            column = column;
          }
          if (press == a){
            row = row;
            column = column - 1;
          }
          if (press == d){
            row = row;
            column = column +1;
          }
          if (press == s){
            row = row +1;
            column = column;
          }
          System.out.print("Play: ");
          pressed = new Scanner(System.in);
          press = pressed.nextLine();
          //new col = gotten col (col postion of current player)
          //new row = gotten row (row postion of current player)
        }
      }
      else {
        count = false;
      }
      System.out.println("You fucked up");

    String c = Integer.toString(row);
    String v = Integer.toString(column);
    String b = c + v;
    System.out.println(b);
    return 'n';
  }*/
  public void Move(){}
  public static void main (String[] args){
    //Field2 space = new Field2();
    char[][] game_space_ob = Field2.getGameSpace();
    Field2.printField2(game_space_ob);
    //char[][] game_f = Field2.getGameSpace();
    //for (int row = 0; row < 7; row++){
      //for (int column = 0; column < 7; column++){
        //System.out.print(game_f[row][column]);
        //}
        //System.out.println();
    //}
    //getMove();

  }

}
