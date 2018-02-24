import java.util.*;
import java.lang.*;

/** This class is the player itself, it is responsible for the changing portion of moving the player */
public class Avatar_1{
    
    final static char avatar_character = 'P';
    private static int column = 1;
    private static int row = 2;
    //private static String direction;
    private static char [][] direction_game_space = GameSpace.getGameSpace();
    private static char blank = '.';
    private final static String UP = "w";
    private final static String DOWN = "s";
    private final static String LEFT = "a";
    private final static String RIGHT = "d";
    
    public static int LeftRightMovement(String direction){
        
        if (direction.equals(LEFT)){
            column = column - 1;
        }
        else if (direction.equals(RIGHT)){
            column = column + 1;
        }
        else {
            column = column;
        }
        
        return column;
    }
    
    public static int UpDownMovement(String direction){
        
        if (direction.equals(UP)){
            row = row - 1;
        }
        else if (direction.equals(DOWN)){
            row = row + 1;
        }
        else {
            row = row;
        }
        
        return row;
    }
    
    public static void PlacePython() {
        String which_press = UserInput.getPress();
        if (direction_game_space[row][column] != 'x'){
            if (which_press.equals(RIGHT)){
                direction_game_space[row][column - 1] = blank;
                //System.out.println("made it to replacing after right");
            }
            else if (which_press.equals(DOWN)){
                direction_game_space[row - 1][column] = blank;
                //System.out.println("made it to replacing after down");
            }
            else if (which_press.equals(UP)){
                direction_game_space[row + 1][column] = blank;
                //System.out.println("made it to replacing after up");
            }
            else if (which_press.equals(LEFT)){
                direction_game_space[row][column + 1] = blank;
                //System.out.println("made it to replacing after left");
            }
            direction_game_space[row][column] = avatar_character;
        }
        
        //end the game if the user tries to occupy an obstacle position.
        else if (direction_game_space[row][column] == 'x') {
            System.out.println("You cannot move there, a wall is blocking your way! You have died! If you would like to play again, please run the program again.");
            System.exit(0);
        }
        GameSpace.setGameSpace(direction_game_space);
    }
    
    public static void newScore() {
        if (direction_game_space[row][column] == 'c') {
            int new_score = GameSpace.getScore();
            new_score++;
            GameSpace.setScore(new_score);
            
        }
    }

}
