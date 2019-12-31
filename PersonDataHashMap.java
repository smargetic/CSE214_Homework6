import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.lang.String;

public class PersonDataHashMap extends Person{
    public static Scanner stdin = new Scanner(System.in);

    private ArrayList<Person> array = new ArrayList<Person>();

    private HashMap<String, Person> hashMap = new HashMap<String, Person>();

    public PersonDataHashMap(){

    }

    public PersonDataHashMap buildFromFile(String location) throws IllegalArgumentException{
        try {
            stdin = new Scanner(new File(location));
            //I get rid of the first line
            stdin.nextLine();

            while (stdin.hasNextLine()) {
                String temp = stdin.nextLine();

                //I read in the data and create a new instance of the person
                String[] data = temp.split(",");
                int length = data.length;

                for(int i=0; i<length;i++){
                    data[i] = data[i].trim();
                    if(i==0){
                        data[0] = data[0].substring(1,data[0].length()-1);
                    } else if (i==1){
                        data[1] = data[1].substring(1,2);
                    }

                }

                int age = Integer.parseInt(data[2]);
                double height = Double.parseDouble(data[3]);

                double weight = Double.parseDouble(data[4]);

                Person newPerson = new Person(data[0], age, data[1], height, weight );

                array.add(newPerson);
                hashMap.put(data[0], newPerson);



            }
        } catch (Exception FileNotFoundException) {
            throw new IllegalArgumentException();
        } finally {
            stdin = new Scanner(System.in);
        }

        return this;
    }

    public void add(String name, Person newPerson) throws PersonAlreadyExistsException{
        if(hashMap.containsKey(name)&&hashMap.containsValue(newPerson)){
            //the person already exists, I throw an error
            throw new PersonAlreadyExistsException();
        } else {
            //I add the person
            array.add(newPerson);
            hashMap.put(name, newPerson);
        }
    }

    public void get (String name) throws PersonDoesNotExistException{
        if (hashMap.isEmpty()){
            throw new PersonDoesNotExistException();
        }
        else if(hashMap.containsKey(name)==false){
            //the person is not present
            throw new PersonDoesNotExistException();
        } else {
            //I get the data on the person, and print out their values
            Person newPerson = hashMap.get(name);
            String temp;
            if(newPerson.getGender().equals("M")) {
                temp = "male";
            } else {
                temp = "female";
            }
            double height = newPerson.getHeight();
            int temp1 = (int)height;
            int feet = temp1/12;
            int inches = temp1%12;

            int weight = (int)newPerson.getWeight();


            System.out.print("\n" + newPerson.getName() + " is a " + newPerson.getAge() + " year old " + temp);
            System.out.print(" who is " + feet + " feet and " +  inches + " inches tall and weighs " + weight + " pounds.");
        }
    }

    public void remove(String name) throws PersonDoesNotExistException{
        if(hashMap.isEmpty()) {
            throw new PersonDoesNotExistException();
        }
        else if(!hashMap.containsKey(name)){
            throw new PersonDoesNotExistException();
        } else {
            //I remove the person
            Person tempPerson = hashMap.get(name);
            array.remove(tempPerson);
            hashMap.remove(name);
        }
    }

    public void printTable() throws EmptyTableException{
        if(array.size()==0){
            //there is nothing to print, I throw an error
            throw new EmptyTableException();
        }
        System.out.print("\n\tName\t|\tAge\t|\tGender\t|\t\t  Height  \t\t|\tWeight\t");
        System.out.print("\n====================================================================");

        //Since I use the array list to sort the data, I use it to print
        int arraySize = array.size();
        for(int i=0; i<arraySize;i++){
            Person tempPerson = array.get(i);
            double height = tempPerson.getHeight();
            int temp1 = (int)height;
            int feet = temp1/12;
            int inches = temp1%12;

            int weight = (int)tempPerson.getWeight();


            System.out.format("\n%9s%3s", tempPerson.getName(), " ");
            System.out.format("|%5s%2s", tempPerson.getAge(), " ");
            System.out.format("|%5s%s%5s"," ", tempPerson.getGender(), " ");
            System.out.format("|%4s feet %2s inches%4s", feet, inches, " ");
            System.out.format("|%6s%4s", weight, " ");

       }


    }

    public void sort (String i) throws IllegalArgumentException, EmptyTableException{
        int arraySize = array.size();
        if(arraySize ==0){
            //there is nothing to sort, I throw an error
            throw new EmptyTableException();
        }
        if(i.equals("n")){

            Collections.sort(array, new NameComparator());
        } else if (i.equals("w")){
            Collections.sort(array, new WeightComparator());
        } else if (i.equals("h")){
            Collections.sort(array, new HeightComparator());
        } else {
            throw new IllegalArgumentException();
        }
    }


}
