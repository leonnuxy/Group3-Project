public class PlayGame {
    public static int py_row =1 ;
    public static int py_column = 1;
    public static int press_for_move;
    
    public static void main(String[] args){
        Field2 space = new Field2();
        Avatar_1 ava1 = new Avatar_1();
        space.placeObs();
        space.placePython(py_row, py_column);
        int count = 0;
        while (count == 0){
            space.Play();
            press_for_move = space.getPress();
            ava1.rightLeft(press_for_move);
            ava1.upDown(press_for_move);
            py_row = ava1.getPRow();
            py_column = ava1.getPColumn();
            System.out.println("row = " + py_row + " column = " + py_column);
            space.placePython(py_row, py_column);
        }
    }

}
