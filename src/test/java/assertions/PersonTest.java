package assertions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Period;

class PersonTest {

    // --- getFullName

    @Test
    void getFullNameReturnsFirstnameSpaceLastname() {
        Person p = new Person("Pinco", "Pallino", null);

        String fullname = p.getFullName();

        Assertions.assertEquals("Pinco Pallino", fullname);
    }

    // TODO some more useful tests


    // --- getAge

    @Test
    void getAgeReturns10YearsIfBorn10YearsAgo() {
        // TODO verbessern. Hinweis: Repeatable (wiederholbar) zu jeder Zeit.
        // Test sollte mit NOW funktionieren
        Person p = new Person("", "", LocalDate.now().minusYears(10));

        Period age = p.getAge();

        Assertions.assertEquals(10, age.getYears());
        Assertions.assertEquals(0, age.getMonths());
        Assertions.assertEquals(0, age.getDays());

    }

    @Test
    void getAgeReturns1DayIfYesterday() {
        Person p = new Person("", "", LocalDate.now().minusDays(1));

        Period age = p.getAge();

        Assertions.assertEquals(0, age.getYears());
        Assertions.assertEquals(0, age.getMonths());
        Assertions.assertEquals(1, age.getDays());
    }

    @Test
    void getAgeReturns5Years4Months3DaysIf5Years4Months3DaysAgo() {
        Person p = new Person("", "", LocalDate.now().minusYears(5).minusMonths(4).minusDays(3));

        Period age = p.getAge();

        Assertions.assertEquals(5, age.getYears());
        Assertions.assertEquals(4, age.getMonths());
        Assertions.assertEquals(3, age.getDays());
    }

    @Test
    void getAgeGreaterThan30(){
        Person p = new Person("", "", LocalDate.now().minusYears(31));

        Period age = p.getAge();

        Assertions.assertTrue(age.getYears() > 30);
    }
}
