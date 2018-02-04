import java.util.*;
public class Field2 {
  private static char[][] game_space_obstacle;
  private static int row = 0;
  private static int column = 0;
  public static char python = 'P';
  private static char[][] game_space = {
  {'.','.','.','.','.','.','.'},
  {'.','.','.','.','.','.','.'},
  {'.','.','.','.','.','.','.'},
  {'.','.','.','.','.','.','.'},
  {'.','.','.','.','.','.','.'},
  {'.','.','.','.','.','.','.'},
  {'.','.','.','.','.','.','.'}};

//  public Field2(){}

  public static Obstacle2 obs = new Obstacle2();
  static char obstacle = obs.getObsChar();

  public static void printField2(char[][] aMatrix){
    game_space_obstacle = game_space;
    for (row = 0; row < 7; row++){
      for (column = 0; column < 7; column++){
        System.out.print(game_space_obstacle[row][column]);
        }
        System.out.println();
    }
    //return game_space;
  }

  public static char[][] placeObs(char obstacle){
    for (column = 0; column < 7; column++){
      game_space[0][column] = obstacle;
    }
    for (column = 0; column < 7; column++){
      game_space[6][column] = obstacle;
    }
    for (row = 1; row < 7; row++){
      game_space[row][0] = obstacle;
    }
    for (row = 1; row < 7; row++){
      game_space[row][6] = obstacle;
    }
    return game_space;
  }

  public static char[][] getGameSpace() {
    return game_space_obstacle;
  }

  public static void main(String[] args) {
    placeObs(obstacle);
    printField2(game_space_obstacle);
  }
}
