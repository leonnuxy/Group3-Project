/** This has the properties of the obstacle */
public class Obstacle2 {
    private static char obstacleChar = 'x';
    
    public static char getObsChar(){
        return obstacleChar;
    }
    
    public static void placeObstacles(){
        char[][] game_space_obstacles = GameSpace.getGameSpace();
        for (int column = 0; column < 7; column++){
            game_space_obstacles[0][column] = obstacleChar;
        }
        
        for (int column = 0; column < 7; column++){
            game_space_obstacles[6][column] = obstacleChar;
        }
        
        for (int row = 1; row < 7; row++){
            game_space_obstacles[row][0] = obstacleChar;
        }
        
        for (int row = 1; row < 7; row++){
            game_space_obstacles[row][6] = obstacleChar;
        }
        GameSpace.setGameSpace(game_space_obstacles);
    }
    
}

