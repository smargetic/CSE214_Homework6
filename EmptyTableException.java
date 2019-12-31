public class EmptyTableException extends Exception {
    public EmptyTableException(){
        super("\nThe table is empty.");
    }
}
