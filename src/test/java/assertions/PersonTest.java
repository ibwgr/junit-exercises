package assertions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Period;

class PersonTest {

    // getFullName

    @Test
    void getFullNameReturnsFirstnameSpaceLastname(){
        // TODO implement
        Person p = new Person("Rade", "Ilic", LocalDate.of(1992, 3, 9));

        String fullName = p.getFullName();

        Assertions.assertEquals(fullName, "Hannes Meier");
    }

    // TODO some more useful tests

    // getAge


    // TODO verbessern. Hinweis: Repeatable (wiederholbar) zu jeder Zeit.
    @Test
    void getAgeReturns10YearsIfBornIn2009() throws Exception {
        Person p = new Person("", "", LocalDate.now().minusYears(10));

        Period age = p.getAge();

        Assertions.assertEquals(10, age.getYears());
        Assertions.assertEquals(0, age.getMonths());
        Assertions.assertEquals(0, age.getDays());
    }

    @Test
    void getAgeReturns1DayIfYesterday() throws Exception {
         Person p = new Person("", "", LocalDate.now().minusDays(1));

        Period age = p.getAge();

        Assertions.assertEquals(0, age.getYears());
        Assertions.assertEquals(0, age.getMonths());
        Assertions.assertEquals(1, age.getDays());
    }
    // TODO some more useful tests
}