import java.util.*;
public class Field2 {
    private  char[][] game_space_obstacle;
    private  int row = 0;
    private  int column = 0;
    public  char python = 'P';
    public  char[][] game_space = {
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
    public  Obstacle2 obs = new Obstacle2();
    char obstacle = obs.getObsChar();
    public Avatar_1 ava1 = new Avatar_1();
    
    public String press = "";
    
    //Starts the process of playing the game
    public String Play(){
        //String press = "";
        printField2();
        System.out.print("Play: ");
        Scanner pressed = new Scanner(System.in);
        press = pressed.nextLine();
        //System.out.println(press);
        return press;
    }
    
    //gets the press and returns it
    public String getPress(){
        //System.out.println(press);
        return press;
    }
    
    //Places the border obstacles
    public  char[][] placeObs(char obstacle){
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
        //game_space[p_row][p_column] = python;
        return game_space;
    }
    
    //Places our letter P on the board
    public  char[][] placePython(int py_row, int py_column){
        //py_row = ava1.getPRow();
        //py_column = ava1.getPColumn();
        game_space[py_row][py_column] = python;
        return game_space;
    }
    
    //Can print the board later if needed
    public void printField2(){
        placeObs(obstacle);
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
