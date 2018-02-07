import java.util.*;

public class Avatar_1{
    
    //setting instance variables
     String w;
     String a;
     public String s;
     String d;
     public int p_row = 1;
     public int p_column = 1;
     char python = 'P';
    
    public int rightLeft(Field2 space){
        String press = space.getPress();
        //System.out.println(press);
        if (press == "a" || press == "d") {
            if (press == "a"){
                p_column = p_column + 1;
            }
            if (press == "d"){
                p_column = p_column - 1;
            }
        }
        else {
            p_column = p_column;
        }
        return p_column;
    }
    public int upDown(Field2 space){
        String press = space.getPress();
        //System.out.println(pressl);
        //if (press == "w" || press == "s") {
            //System.out.println(press);
            if (press == "w"){
                p_row = p_row - 1;
            }
            if (press == "s"){
                p_row = p_row + 1 ;
                System.out.println("yeah" + press);
                System.out.println(p_row);
            }
        //}
        else {
            //p_row = p_row;
        }
        System.out.println(p_row);
        return p_row;
        
    }
    
    public  int getPColumn(){
        return p_column;
    }
    
    public  int getPRow(){
        return p_row;
    }
    
    
    public void Move(){}
    /**public static void main (String[] args){
        //boolean count = true;
        //while (count == true){
            //Play();
            rightLeft();
            upDown();
        //}

  }*/
}
