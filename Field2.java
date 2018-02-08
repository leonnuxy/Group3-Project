import java.util.*;
public class Field2 {
    private char[][] game_space_obstacle;
    private int row = 0;
    private int column = 0;
    public char python = 'P';
    public char blank = '.';
    public int score = 0;
    public char[][] game_space = {
    {'.','.','.','.','.','.','.'},
    {'.','.','.','.','.','.','.'},
    {'.','.','.','.','.','.','.'},
    {'.','.','.','.','.','.','.'},
    {'.','.','.','.','.','.','.'},
    {'.','.','.','.','.','.','.'},
    {'.','.','.','.','.','.','.'}};
    //public  int py_row;
    //public  int py_column;
    
    //  public Field2(){}
    
    //creates new obstacle and avatar
    public Obstacle2 obs = new Obstacle2();
    char obstacle = obs.getObsChar();
    public Collectible2 coll = new Collectible2();
    char collect = coll.getCollectibleChar();
    
    //public Avatar_1 ava1 = new Avatar_1();
    private int press_out;
    
    //Starts the process of playing the game
    public int Play(){
        System.out.println("Your score is " + score);
        System.out.print("Play:");
        Scanner pressed = new Scanner(System.in);
        int press = pressed.nextInt();
        press_out = press;
        return press_out;
    }
    
    //gets the press and returns it
    public int getPress(){
        //press_out = press;
        System.out.println("getPress " + press_out);
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
    
    //Places our letter P on the board
    public  char[][] placePython(int py_row, int py_column){
        if (game_space[py_row][py_column] == 'c'){
            score++;
            game_space[py_row][py_column] = python;
        }
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
        else if (game_space[py_row][py_column] == 'x') {
            System.out.println("You cannot move there, a wall is blocking your way! You have now died!");
            System.exit(0);
            printField2();
        }
        
        return game_space;
    }
    
    //Can print the board later if needed
    public void printField2(){
        game_space_obstacle = game_space;
        for (row = 0; row < 7; row++){
            for (column = 0; column < 7; column++){
                System.out.print(game_space_obstacle[row][column]);
            }
            System.out.println();
        }
        //return game_space;
    }
    
    //gets the board itself can returns it
    public  char[][] getGameSpace() {
        return game_space_obstacle;
    }
    
    /**public  void main(String[] args) {
        int count = 0;
        while (count == 0){
            Play();
            ava1.rightLeft();
            ava1.upDown();
            py_row = ava1.getPRow();
            py_column = ava1.getPColumn();
            placePython(py_row, py_column);
        }
    }*/
}
