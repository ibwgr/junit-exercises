package assertions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.time.LocalDate;
import java.time.Period;

class PersonTest {

    // getFullName

    @Test
    void getFullNameReturnsFirstnameSpaceLastname(){
        // TODO implement
        Person hans = new Person("Hans","Muster", LocalDate.of(2001,1,10));
        String fullName = hans.getFullName();
        Assertions.assertEquals("Hans Muster", fullName);
    }

    // TODO some more useful tests

    // getAge


    // TODO verbessern. Hinweis: Repeatable (wiederholbar) zu jeder Zeit.
    @Test
    void getAgeReturns10YearsIfBorn10YearsAgo() throws Exception {
        Person person = new Person("", "", LocalDate.now().minusYears(10));
        Period age = person.getAge();

        Assertions.assertEquals(10,age.getYears());
    }

    @Test
    void getAgeReturns1DayIfYesterday() throws Exception {
        Person p = new Person("", "", LocalDate.now().minusDays(1));
        Period age = p.getAge();

        Assertions.assertEquals(1, age.getDays());
    }
    // TODO some more useful tests
}