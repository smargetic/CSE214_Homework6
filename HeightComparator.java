import java.util.Comparator;

public class HeightComparator implements Comparator<Person>{
    public int compare(Person a, Person b){
        //compares the height between two diffent people
        int aHeight = (int)a.getHeight();
        int bHeight = (int)b.getHeight();

        return aHeight-bHeight;
    }
}


