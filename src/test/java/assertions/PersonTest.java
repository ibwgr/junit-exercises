package assertions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.time.Period;

import java.time.LocalDate;

class PersonTest {

    // --- getFullName

    @Test
    void getFullNameReturnsFirstnameSpaceLastname(){
        Person p = new Person("Urs", "Heusser", LocalDate.of(2000,1,15));
        String s = "Urs Heusser";
        Assertions.assertEquals(s, p.getFullName());
    }

    @Test
    void getFullNameHasASpace() {
        Person p = new Person("Urs", "Heusser", LocalDate.of(2000,1,15));
        String fn = p.getFullName();
        Assertions.assertTrue(fn.contains(" "));
    }


    // --- getAge

    @Test
    void getAgeReturns10YearsIfBornThenYearsAgo()  {
        Person p = new Person("", "", LocalDate.now().minusYears(10));
        Period age = p.getAge();
        Assertions.assertEquals(10, age.getYears());
    }

    @Test
    void getAgeReturns1DayIfBornYesterday()  {
        Person p = new Person("", "", LocalDate.now().minusDays(1));
        Period age = p.getAge();
        Assertions.assertEquals(1, age.getDays());
    }

    @Test
    void getAgeHasToBePositive() {
        Person p = new Person("", "", LocalDate.now().minusYears(22).minusDays(543).minusMonths(2938));
        Period age = p.getAge();
        Assertions.assertFalse(age.isNegative(), "Alter darf nicht negativ sein!");
    }
}
