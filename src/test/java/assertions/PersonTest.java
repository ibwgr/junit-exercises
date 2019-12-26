<<<<<<< HEAD
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
=======
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
>>>>>>> 3e013e4be3a71470f8678448dfc73902047284b8
}