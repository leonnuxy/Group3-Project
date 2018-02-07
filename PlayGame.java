public class PlayGame {
    public static int py_row;
    public static int py_column;
    
    public static void main(String[] args){
        Field2 space = new Field2();
        Avatar_1 ava1 = new Avatar_1();
        int count = 0;
        while (count == 0){
            space.Play();
            ava1.rightLeft(space);
            ava1.upDown(space);
            py_row = ava1.getPRow();
            py_column = ava1.getPColumn();
            space.placePython(py_row, py_column);
        }
    }

}
