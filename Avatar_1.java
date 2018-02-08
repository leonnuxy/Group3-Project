import java.util.*;

public class Avatar_1{
    
    //setting instance variables
    String w;
    String a;
    public String s;
    String d;
    public int p_row = 1;
    public int p_column = 1;
    //char python = 'P';
    //int press_ava1 = 1;
    //int press_ava2 = 1;
    
    public int rightLeft(int press_for_ava){
        int press_ava1 = press_for_ava;
        System.out.println("Start of rightLeft column = " + p_column + " and the press is currently " +press_ava1);
        if (press_ava1 == 4){
            System.out.println("no");
            p_column = p_column + 1;
        }
        else if (press_ava1 == 1){
            System.out.println("no");
            p_column = p_column - 1;
        }
        else {
            p_column = p_column;
        }
        System.out.println("End of rightLeft column = " + p_column);
        return p_column;
    }
    public int upDown(int press_for_ava){
        int press_ava2 = press_for_ava;
        System.out.println("Start of upDown row  = " + p_row);
        
        if (press_ava2 == 2){
            System.out.println("Made it to if");
            p_row = p_row - 1;
        }
        
        else if (press_ava2 == 3) {
            System.out.println("made it to else");
            p_row = p_row + 1;
        }
        System.out.println("End of upDown row = " + p_row);
        System.out.println(press_ava2);
        return p_row;
        
    }
    
    public  int getPColumn(){
        return p_column;
    }
    
    public  int getPRow(){
        return p_row;
    }
    
    
    //public void Move(){}
    /**public static void main (String[] args){
        //boolean count = true;
        //while (count == true){
            //Play();
            rightLeft();
            upDown();
        //}

  }*/
}
