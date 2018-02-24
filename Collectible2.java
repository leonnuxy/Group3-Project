/** This has the properties of the collectible */
public class Collectible2 {
    private static char collectibleChar = 'c';
    
    public static void placeCollectible(){
        char[][] game_space_collectible = GameSpace.getGameSpace();
        game_space_collectible[3][4] = collectibleChar;
        
        GameSpace.setGameSpace(game_space_collectible);
    }
}

