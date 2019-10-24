package assertions;

import java.time.LocalDate;
import java.time.Period;

public class Person {

    private final String firstName;
    private final String lastName;
    private final LocalDate birthDate;

    public Person(String firstName, String lastName, LocalDate birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    public String getFullName(){
        return firstName + " " + lastName;
    }

    public Period getAge(){
        return Period.between(birthDate, LocalDate.now());
    }
}
