package assertions;

import org.junit.Test;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.time.LocalDate;

/**
 * Created by ideadapt on 09.10.16.
 */
public class PersonTest {

    // getFullName

    @Test
    public void getFullNameReturnsFirstnameSpaceLastname(){
        // TODO implement
        throw new NotImplementedException();
    }

    // TODO some more useful tests

    // getAge


    // TODO verbessern. Hinweis: Repeatable (wiederholbar) zu jeder Zeit.
    @Test
    public void getAgeReturns10YearsIf2006() throws Exception {
        Person p = new Person("", "", LocalDate.of(2006, 1, 1));

        throw new NotImplementedException();
    }


    @Test
    public void getAgeReturns1DayIfYesterday() throws Exception {
        Person p = new Person("", "", LocalDate.now().minusDays(1));

        // TODO implement
        throw new NotImplementedException();
    }
    // TODO some more useful tests
}