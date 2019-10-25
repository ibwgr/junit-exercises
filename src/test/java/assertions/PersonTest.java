package assertions;

import org.junit.jupiter.api.Test;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.time.LocalDate;

class PersonTest {

    // getFullName

    @Test
    void getFullNameReturnsFirstnameSpaceLastname(){
        // TODO implement
        throw new NotImplementedException();
    }

    // TODO some more useful tests

    // getAge


    // TODO verbessern. Hinweis: Repeatable (wiederholbar) zu jeder Zeit.
    @Test
    void getAgeReturns10YearsIfBornIn2009() throws Exception {
        Person p = new Person("", "", LocalDate.of(2009, 1, 1));

        throw new NotImplementedException();
    }

    @Test
    void getAgeReturns1DayIfYesterday() throws Exception {
        Person p = new Person("", "", LocalDate.now().minusDays(1));

        // TODO implement
        throw new NotImplementedException();
    }
    // TODO some more useful tests
}