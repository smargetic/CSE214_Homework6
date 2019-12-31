import java.util.Comparator;

public class NameComparator implements Comparator<Person> {
    public int compare(Person a, Person b){
        //I compare the names of two different people
        return a.getName().compareTo(b.getName());
    }
}
