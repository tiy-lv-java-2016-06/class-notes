import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jeff on 8/7/16.
 */
public class Main {

    public static void main(String[] args) {
        List<Person> people = createPeople();
        allAdult(people);
    }

    public static List<Person> createPeople(){
        List<Person> people = new ArrayList<>();
        people.add(new Person("David", Person.Sex.MALE, "david@people.com", LocalDate.of(1975, 5, 10)));
        people.add(new Person("Sally", Person.Sex.FEMALE, "sally@people.com", LocalDate.of(1995, 7, 19)));
        people.add(new Person("Fred", Person.Sex.MALE, "fred@people.com", LocalDate.of(2001, 10, 31)));
        people.add(new Person("George", Person.Sex.MALE, "george@people.com", LocalDate.of(2015, 1, 11)));
        people.add(new Person("Annie", Person.Sex.FEMALE, "annie@people.com", LocalDate.of(1963, 6, 30)));

        return people;
    }

    public static void printEachName(List<Person> people){
        //For loop
        System.out.println("For loop");
        for(Person p : people){
            System.out.println(p.getName());
        }

        //Stream equivalent
        System.out.println("Stream");
        people.stream().forEach(p -> System.out.println(p.getName()));
    }

    public static void printEachFemale(List<Person> people){
        //For loop
        System.out.println("For loop");
        for(Person p : people){
            if(p.getGender() == Person.Sex.FEMALE) {
                System.out.println(p.getName());
            }
        }

        //Stream equivalent
        System.out.println("Stream");
        people.stream()
                .filter(person -> person.getGender() == Person.Sex.FEMALE)
                .forEach(p -> System.out.println(p.getName()));
    }

    public static void allAdult(List<Person> people){
        //For loop
        System.out.println("For loop");
        boolean allAdult = true;
        for(Person p : people){
            if(p.getAge() < 18){
                allAdult = false;
            }
        }
        System.out.println("Are they all adults: " + allAdult);

        boolean allAdults = people.stream().allMatch(person -> person.getAge() > 18);
        System.out.println("Are they all adults: " + allAdults);
    }

    public static void aggregateAges(List<Person> people){
        //For loop
        System.out.println("For loop");
        int totalAge = 0;
        int count = 0;

        for(Person p : people){
            totalAge += p.getAge();
            count ++;
        }
        System.out.println("The average age is: " + totalAge / count);

        //Stream
        people.stream().mapToInt(p -> p.getAge()).average().getAsDouble();
        System.out.println("The average age is: " + totalAge / count);
    }


}
