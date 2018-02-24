import java.lang.*;

/** This class runs the game */
public class PlayGame {
    
    //set instance variables
    public static String press_for_move;
    static GameSpace board = new GameSpace();
    static Avatar_1 python = new Avatar_1();
    static String direction;
    private static int carry_row;
    private static int carry_column;
    
    public static void main(String[] args){
        Obstacle2.placeObstacles();
        Collectible2.placeCollectible();
        boolean counter = false;
        while (counter == false){
            board.printGameSpace();
            direction = UserInput.takeInput();
            python.LeftRightMovement(direction);
            python.UpDownMovement(direction);
            python.newScore();
            python.PlacePython();
            
            
        }
    }
}
