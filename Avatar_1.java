import java.util.*;

/** This class is the player itself, it is responsible for the changing portion of moving the player */
public class Avatar_1{
    
    //setting instance variables
    String w;
    String a;
    public String s;
    String d;
    public int p_row = 1;
    public int p_column = 1;
    
    /* Handles if the user is trying to move left or right */
    public int rightLeft(int press_for_ava){
        int press_ava1 = press_for_ava;
        
        if (press_ava1 == 4){
            p_column = p_column + 1;
        }
        
        else if (press_ava1 == 1){
            p_column = p_column - 1;
        }
        
        else {
            p_column = p_column;
        }
        
        return p_column;
    }
    
    /* handles if the user is trying to move up or down */
    public int upDown(int press_for_ava){
        int press_ava2 = press_for_ava;
        
        if (press_ava2 == 2){
            p_row = p_row - 1;
        }
        
        else if (press_ava2 == 3) {
            p_row = p_row + 1;
        }
        
        return p_row;
        
    }
    
    public  int getPColumn(){
        return p_column;
    }
    
    public  int getPRow(){
        return p_row;
    }
    
}
