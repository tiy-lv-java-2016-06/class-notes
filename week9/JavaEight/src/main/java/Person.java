import java.time.LocalDate;
import java.time.Period;


/**
 * Created by jeff on 8/7/16.
 */
public class Person {

    public enum Sex {
        MALE, FEMALE
    }

    String name;
    Sex gender;
    String emailAddress;
    LocalDate birthdate;

    public Person(String name, Sex gender, String emailAddress, LocalDate birthdate) {
        this.name = name;
        this.gender = gender;
        this.emailAddress = emailAddress;
        this.birthdate = birthdate;
    }

    public int getAge(){
        return Period.between(birthdate, LocalDate.now()).getYears();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sex getGender() {
        return gender;
    }

    public void setGender(Sex gender) {
        this.gender = gender;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }
}
