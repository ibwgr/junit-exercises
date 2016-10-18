package assertions;

import java.time.LocalDate;
import java.time.Period;

/**
 * Created by ideadapt on 09.10.16.
 */
public class Person {

    protected static final String NO_NAME = "no name";

    private final String firstName;
    private final String lastName;
    private final LocalDate birthDate;

    public Person(String firstName, String lastName, LocalDate birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    public String getFullName(){
        if (lastName != null && firstName != null) {
            return firstName + " " + lastName;
        } else if (lastName != null && firstName == null) {
            return lastName;
        } else if (lastName == null && firstName != null) {
            return firstName;
        } else {
            return "no name";
        }
    }

    public Period getAge(){
        return Period.between(birthDate, LocalDate.now());
    }
}
