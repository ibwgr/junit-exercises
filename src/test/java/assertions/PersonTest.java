package assertions;

import org.junit.Test;

import java.time.LocalDate;

/**
 * Created by ideadapt on 09.10.16.
 */
public class PersonTest {

    // getFullName

    @Test
    public void getFullNameReturnsFirstnameSpaceLastname(){
        // TODO implement
    }

    // TODO some more useful tests

    // getAge


    // TODO verbessern. Hinweis: Repeatable (wiederholbar) zu jeder Zeit.
    @Test
    public void getAgeReturns10YearsIf2006() throws Exception {
        Person p = new Person("", "", LocalDate.of(2006, 1, 1));
    }

    @Test
    public void getAgeReturns1DayIfYesterday() throws Exception {
        Person p = new Person("", "", LocalDate.now().minusDays(1));
        // TODO implement
    }
    // TODO some more useful tests
}