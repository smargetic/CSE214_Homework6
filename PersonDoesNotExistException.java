public class PersonDoesNotExistException extends Exception {
    public PersonDoesNotExistException(){
        super("This person does not exist.");
    }
}
