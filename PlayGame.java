/** This class runs the game */
public class PlayGame {
    
    //set instance variables
    public static int py_row =1 ;
    public static int py_column = 1;
    public static int press_for_move;
    
    /* Main method to constantly prompt for user input */
    public static void main(String[] args){
        Field2 space = new Field2();
        Avatar_1 ava1 = new Avatar_1();
        space.placeItems();
        space.placePython(py_row, py_column);
        System.out.println("Press 1 to move left, press 2 to move up, press 3 to move down, and press 4 to move right.");
        int count = 0;
        while (count == 0){
            space.Play();
            press_for_move = space.getPress();
            ava1.rightLeft(press_for_move);
            ava1.upDown(press_for_move);
            py_row = ava1.getPRow();
            py_column = ava1.getPColumn();
            space.placePython(py_row, py_column);
        }
    }

}
