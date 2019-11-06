package assertions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Period;

class PersonTest {

    // getFullName

    @Test
    void getFullNameReturnsFirstnameSpaceLastname(){
        Person p = new Person("James", "Bond", LocalDate.of(2019,11,05));
        String fullname = p.getFullName();
        Assertions.assertEquals("James Bond", fullname);

    }

    // TODO some more useful tests

    // getAge (Problem: Dieser Test funktioniert datumsabhängig, Morgen geht er nicht mehr. Leider noch keine funktionierende Lösung gefunden..)
    @Test
    void getAgeReturnsAmountOfDaysSinceBirthUntilToday(){
         Person p = new Person("", "", LocalDate.of(2019, 11, 05));
         Period age = p.getAge();

         Assertions.assertEquals(0, age.getYears());
         Assertions.assertEquals(0, age.getMonths());
         Assertions.assertEquals(1, age.getDays());
    }


    // TODO verbessern. Hinweis: Repeatable (wiederholbar) zu jeder Zeit.
    @Test
    void getAgeReturns20YearsIfBornIn1999() throws Exception {
        Person p = new Person("", "", LocalDate.now().minusYears(20));

        Period age = p.getAge();

        Assertions.assertEquals(20, age.getYears());
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


