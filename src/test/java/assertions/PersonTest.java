package assertions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.time.LocalDate;

class PersonTest {

    // getFullName

    @Test
    void getFullNameReturnsFirstnameSpaceLastname(){
        // TODO implement
        Person p = new Person("Rade", "Ilic", -03-1992);

        String fullName = p.getFullName();

        Assertions.assertEquals(fullName, "Hannes Meier");
    }

    // TODO some more useful tests

    // getAge


    // TODO verbessern. Hinweis: Repeatable (wiederholbar) zu jeder Zeit.
    @Test
    void getAgeReturns10YearsIf2006() throws Exception {
        Person p = new Person("", "", LocalDate.of(2006, 1, 1));

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