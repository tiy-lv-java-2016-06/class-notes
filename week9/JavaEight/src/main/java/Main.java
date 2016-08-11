import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by jeff on 8/11/16.
 */
public class Main {

    public static void main(String[] args) {
        List<Person> people = createPeople();
        printEachFemale(people);

    }

    public static List<Person> createPeople(){
        List<Person> people = new ArrayList<>();
        people.add(new Person("David", Person.Sex.MALE, "david@people.com", LocalDate.of(1995, 5, 10)));
        people.add(new Person("Sally", Person.Sex.FEMALE, "sally@people.com", LocalDate.of(1995, 7, 19)));
        people.add(new Person("Fred", Person.Sex.MALE, "fred@people.com", LocalDate.of(2001, 10, 31)));
        people.add(new Person("George", Person.Sex.MALE, "george@people.com", LocalDate.of(2015, 1, 11)));
        people.add(new Person("Annie", Person.Sex.FEMALE, "annie@people.com", LocalDate.of(1963, 6, 30)));

        return people;
    }

    public static void printEachName(List<Person> people){
        //For Loop
        System.out.println("For Loop");
        for(Person p : people){
            System.out.println(p.getName());
        }

        //Streams
        System.out.println("Streams");
        people.stream().forEach(p -> System.out.println(p.getName()));
    }

    public static void printEachFemale(List<Person> people){
        //For Loop
        System.out.println("For Loop");
        for(Person person : people){
            if(person.getGender() == Person.Sex.FEMALE){
                System.out.println(person.getName());
            }
        }

        //Streams
        System.out.println("Streams");
        people.stream()
                .filter(person -> person.getGender() == Person.Sex.FEMALE)
                .forEach(person -> System.out.println(person.getName()));
    }

    public static void allAdults(List<Person> people){
        //For loop
        System.out.println("For loop");
        boolean allAdult = true;
        for(Person person : people){
            if(person.getAge() < 18){
                allAdult = false;
            }
        }
        StringBuffer sb = new StringBuffer("Are they all adults: ").append(allAdult);
        System.out.println(sb.toString());

        boolean allAdults = people.stream()
                .allMatch(person -> person.getAge() >= 18);
        System.out.println("Are they all adults: " + allAdults);
    }

    public static void averageAges(List<Person> people){
        //For Loop
        System.out.println("For Loop");
        int totalAge = 0;
        int count = 0;

        for(Person person : people){
            totalAge += person.getAge();
            count++;
        }
        System.out.println("The average age is: " + totalAge / count);

        //Stream
        double avg = people.stream().mapToInt(p -> p.getAge()).average().getAsDouble();
        System.out.println("The average age is: " + avg);
    }

    public static void getNamesList(List<Person> people){
        //For loop
        List<String> names = new ArrayList<>();
        for(Person person : people){
            names.add(person.getName());
        }

        names = people.stream()
                .map(person -> person.getName())
                .collect(Collectors.toList());
    }

    public static void nameMap(List<Person> people){
        //For Loop
        Map<String, Person> nameMap = new HashMap<>();
        for(Person person : people){
            nameMap.put(person.getName(), person);
        }

        nameMap = people.stream()
                .collect(Collectors.toMap(p -> p.getName(), p -> p));
    }

    public static void groupByAges(List<Person> people){
        //For Loop
        Map<Integer, List<Person>> ageGroups = new HashMap<>();
        for(Person p : people){
            List<Person> personList;
            if(ageGroups.containsKey(p.getAge())){
                personList = ageGroups.get(p.getAge());
            }
            else{
                personList = new ArrayList<>();
            }

            personList.add(p);
            ageGroups.put(p.getAge(), personList);
        }

        ageGroups = people.stream().collect(Collectors.groupingBy(p -> p.getAge()));
    }
}
