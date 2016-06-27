package tiy.week3;

import java.util.Comparator;

/**
 * Created by jeff on 6/27/16.
 */
public class Person implements Comparable<Person>{

    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public int compareTo(Person o) {
        int rval = this.getAge() - o.getAge();

        if(rval == 0){
            rval = this.firstName.compareTo(o.getFirstName());
        }

        return rval;
    }
}
