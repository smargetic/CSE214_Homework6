import java.io.Serializable;


public class PersonDataManager extends PersonDataHashMap implements Serializable {
    public static void main(String[] args){


        PersonDataHashMap pdhm = new PersonDataHashMap();
        boolean truth = true;
        while(truth){
            System.out.print("\n\nMenu:");
            System.out.print("\n\t(I)-Import from File");
            System.out.print("\n\t(A)-Add Person");
            System.out.print("\n\t(R)-Remove Person");
            System.out.print("\n\t(G)-Get Info on Person");
            System.out.print("\n\t(P)-Print Table");
            System.out.print("\n\t(S)-Sort");
            System.out.print("\n\t\t(N)-Name");
            System.out.print("\n\t\t(W)-Weight");
            System.out.print("\n\t\t(H)-Height");
            System.out.print("\n\t(Q)-Quit");

            System.out.print("\n\nPlease select an option: ");

            String answer = pdhm.stdin.nextLine().trim().toLowerCase();
            //
            switch(answer){
                case "i":
                    System.out.print("\nPlease select a location: ");
                    String location = pdhm.stdin.nextLine();
                    try{
                        System.out.print("\n\nLoading...");
                        //I read in the file
                        pdhm.buildFromFile(location);
                        System.out.print("\n\nPerson data loaded successfully!");
                    } catch (Exception IllegalArgumentException){
                        System.out.print("\n\nSorry, this file does not exist. Please try again.");
                    }



                    break;
                case "a":
                    //I create a new instance of a person, and add them to the hashmap and arraylist

                    System.out.print("\nPlease enter the name of the person: ");
                    String name = pdhm.stdin.nextLine().trim();

                    name.toLowerCase();
                    name = name.substring(0,1).toUpperCase() + name.substring(1).toLowerCase();

                    System.out.print("\nPlease enter the age: ");
                    String tempAge = pdhm.stdin.nextLine().trim();
                    int age = Integer.parseInt(tempAge);

                    System.out.print("\nPlease enter the gender (F/M): ");
                    String gender = pdhm.stdin.nextLine().trim().toUpperCase();
                    //In case the user gives unconventional answers
                    if(gender.equals("FEMALE")){
                        gender = "F";
                    } else if (gender.equals("MALE")){
                        gender = "M";
                    }

                    System.out.print("\nPlease enter the height (in inches): ");
                    String tempHeight = pdhm.stdin.nextLine().trim();
                    double height = Double.parseDouble(tempHeight);

                    System.out.print("\nPlease enter the weight (in lbs): ");
                    String tempWeight = pdhm.stdin.nextLine().trim();
                    int weight = Integer.parseInt(tempWeight);

                    Person newPerson = new Person(name, age, gender, height, weight);
                    //I add the person I've created to the hashmap
                    try{
                        pdhm.add(name, newPerson);
                        System.out.print(name + " has been added to the list!");
                    } catch (Exception PersonAlreadyExistsException) {
                        System.out.print("\nSorry, this person already exists!");
                    }

                    break;
                case "r":
                    System.out.print("\nPlease enter the name of the person: ");
                    String name2 = pdhm.stdin.nextLine().trim();
                    //I make sure the name provided is in the correct format
                    name2.toLowerCase();
                    name2 = name2.substring(0,1).toUpperCase() + name2.substring(1).toLowerCase();

                    try{
                        //I remove the person
                        pdhm.remove(name2);
                        System.out.print(name2 + " has been removed!");
                    } catch (Exception PersonDoesNotExistException) {
                        System.out.print("\nThis person does not exist!");
                    }
                    break;
                case "g":
                    System.out.print("\nPlease enter the name of the person: ");
                    String name3 = pdhm.stdin.nextLine().trim();
                    //I make sure the name provided is in the correct format
                    name3.toLowerCase();
                    name3 = name3.substring(0,1).toUpperCase() + name3.substring(1).toLowerCase();

                    try {
                        //I get the data of the person, and print it
                        pdhm.get(name3);
                    } catch (Exception PersonDoesNotExistException){
                        System.out.print("\nThis person does not exist!");
                    }
                    break;
                case "p":
                    try {
                        pdhm.printTable();
                    } catch (Exception EmptyTableException){
                        System.out.print("\nThere is nothing present to print!");
                    }
                    break;
                case "s":
                    //I sort the data based on the users decision
                    System.out.print("\nPlease select by what: ");
                    System.out.print("\n\t(N)-Name");
                    System.out.print("\n\t(W)-Weight");
                    System.out.print("\n\t(H)-Height");
                    System.out.print("\nChoose an option: ");

                    String tempAnswer = pdhm.stdin.nextLine().trim().toLowerCase();

                    try {
                        pdhm.sort(tempAnswer);
                    } catch (Exception IllegalArgumentException){
                        System.out.print("\nSorry, that is not an option");
                    }


                    break;
                case "q":
                    System.out.print("\nSorry to see you go!");
                    truth = false;
                    System.exit(0);
                    break;
                default:
                    System.out.print("\nThat is not an option, please try again");
                    break;

            }
        }
    }

}
