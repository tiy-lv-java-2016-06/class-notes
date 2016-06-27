package tiy.week3;

import java.util.*;

/**
 * Created by jeff on 6/27/16.
 */
public class Main {

    public static void main(String[] args) {
//        List<Person> people = new ArrayList<Person>();
//
//        people.add(new Person("Mickey", "Mouse", 120));
//        people.add(new Person("Willey", "Mayes", 60));
//        people.add(new Person("Bob", "Hendrix", 50));
//        Collections.sort(people);
//
//        for(Person person : people){
//            System.out.format("%s %s\n", person.getFirstName(), person.getLastName());
//        }

        Map<String, Person> people = new HashMap<String, Person>();
        people.put("MMouse", new Person("Mickey", "Mouse", 120));
        people.put("WMayes", new Person("Willey", "Mayes", 60));
        people.put("BHendrix", new Person("Bob", "Hendrix", 50));

        for(String username : people.keySet()){
            System.out.println(username + ": " + people.get(username));
        }


    }

}
