public class GameSpace {
    
    private static int score = 0;
	private static char[][] game_space = {
    {'.','.','.','.','.','.','.'},
    {'.','.','.','.','.','.','.'},
    {'.','.','.','.','.','.','.'},
    {'.','.','.','.','.','.','.'},
    {'.','.','.','.','.','.','.'},
    {'.','.','.','.','.','.','.'},
    {'.','.','.','.','.','.','.'}};
    
    public static char[][] getGameSpace(){
        return game_space;
    }
    
    public static void setGameSpace(char[][] new_game_space){
        game_space = new_game_space;
    }
    
    public static void printGameSpace(){
        for (int row = 0; row < 7; row++){
            for (int column = 0; column < 7; column++){
                System.out.print(game_space[row][column]);
            }
            System.out.println();
        }
    }
    
    public static int getScore() {
        return score;
    }
    
    public static void setScore(int new_score) {
        if (new_score == score) {
            score = score;
        }
        else {
            score = new_score;
            System.out.println("Your score is: " + score);
        }
    }
}
