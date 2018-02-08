import java.util.*;

/** This class is responsible for handling the board and its related actions such as creating it and moving the player */
public class Field2 {
    
    //initialize instance variables
    private char[][] game_space_obstacle;
    private int row = 0;
    private int column = 0;
    public char python = 'P';
    public char blank = '.';
    public int score = 0;
    private int press_out;
    public char[][] game_space = {
    {'.','.','.','.','.','.','.'},
    {'.','.','.','.','.','.','.'},
    {'.','.','.','.','.','.','.'},
    {'.','.','.','.','.','.','.'},
    {'.','.','.','.','.','.','.'},
    {'.','.','.','.','.','.','.'},
    {'.','.','.','.','.','.','.'}};
   
    //creates new obstacle and collectible
    public Obstacle2 obs = new Obstacle2();
    char obstacle = obs.getObsChar();
    public Collectible2 coll = new Collectible2();
    char collect = coll.getCollectibleChar();
    
    //Starts the process of playing the game
    public int Play(){
        System.out.println("Your score is " + score);
        System.out.println("Press 1 to move left, press 2 to move up, press 3 to move down, and press 4 to move right.");
        System.out.print("Play:");
        Scanner pressed = new Scanner(System.in);
        int press = pressed.nextInt();
        press_out = press;
        return press_out;
    }
    
    //gets the press and returns it
    public int getPress(){
        return press_out;
    }
    
    //Places the border obstacles
    public  char[][] placeObs(){
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
        
        game_space[4][3] = collect;
        return game_space;
    }
    
    /** Places our letter P on the board and replaces the previous with a "blank" tile. Also handles picking up a collectible */
    public  char[][] placePython(int py_row, int py_column){
        
        //incrementing score on collectible pick up
        if (game_space[py_row][py_column] == 'c'){
            score++;
            game_space[py_row][py_column] = python;
        }
        
        //replacing the last space the python occupied with a blank
        if (game_space[py_row][py_column] != 'x'){
            if (press_out == 1){
                game_space[py_row][py_column + 1] = blank;
            }
            if (press_out == 2){
                game_space[py_row + 1][py_column] = blank;
            }
            if (press_out == 3){
                game_space[py_row - 1][py_column] = blank;
            }
            if (press_out == 4){
                game_space[py_row][py_column - 1] = blank;
            }
            game_space[py_row][py_column] = python;
            printField2();
        }
        
        //end the game if the user tries to occupy an obstacle position.
        else if (game_space[py_row][py_column] == 'x') {
            System.out.println("You cannot move there, a wall is blocking your way! You have died! If you would like to play again, plesae run the program again.");
            System.exit(0);
        }
        
        return game_space;
    }
    
    /* Prints the entire board */
    public void printField2(){
        game_space_obstacle = game_space;
        for (row = 0; row < 7; row++){
            for (column = 0; column < 7; column++){
                System.out.print(game_space_obstacle[row][column]);
            }
            System.out.println();
        }
    }
    
}
