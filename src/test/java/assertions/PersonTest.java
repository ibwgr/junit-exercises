package assertions;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class PersonTest {

    // getFullName

    @Test
    void getFullNameReturnsFirstnameSpaceLastname(){
        // TODO implement
        throw new IllegalArgumentException("you should implement code here");
    }

    // TODO some more useful tests

    // getAge


    // TODO verbessern. Hinweis: Repeatable (wiederholbar) zu jeder Zeit.
    @Test
    void getAgeReturns10YearsIfBornIn2009() throws Exception {
        Person p = new Person("", "", LocalDate.of(2009, 1, 1));

        throw new IllegalArgumentException("you should implement code here");
    }

    @Test
    void getAgeReturns1DayIfYesterday() throws Exception {
        Person p = new Person("", "", LocalDate.now().minusDays(1));

        // TODO implement
        throw new IllegalArgumentException("you should implement code here");
    }
    // TODO some more useful tests
}