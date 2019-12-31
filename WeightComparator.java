import java.util.Comparator;

public class WeightComparator implements Comparator<Person> {
    public int compare(Person a, Person b){
        //I compare the weight of two different people
        int aWeight = (int)a.getWeight();
        int bWeight = (int)b.getWeight();
        return aWeight - bWeight;
    }
}
