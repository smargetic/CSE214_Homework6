public class PersonAlreadyExistsException extends Exception {
    public PersonAlreadyExistsException(){
        super("This person already exists.");
    }
}
