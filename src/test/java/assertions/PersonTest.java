package assertions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Period;

class PersonTest {

    // --- getFullName

    @Test
    void getFullNameReturnsFirstnameSpaceLastname(){
        // TODO implement
       // throw new IllegalArgumentException("you should implement code here");
        Person pers1 = new Person("Tobias", "Meier", null);
        Assertions.assertEquals("Tobias Meier",pers1.getFullName());

    }

    // TODO some more useful tests


    // --- getAge

    @Test
    void getAgeReturns10YearsIfBorn10YearsFromToday() throws Exception {
        // TODO verbessern. Hinweis: Repeatable (wiederholbar) zu jeder Zeit.
        Person p = new Person("", "", LocalDate.now().minusYears(10));

        //throw new IllegalArgumentException("you should implement code here");
        Period age = p.getAge();
        Assertions.assertEquals(10,age.getYears());
        Assertions.assertEquals(0, age.getMonths());
        Assertions.assertEquals(0, age.getDays());
    }

    @Test
    void getAgeReturns1DayIfYesterday() throws Exception {
        Person p = new Person("", "", LocalDate.now().minusDays(1));

        // TODO implement
        //throw new IllegalArgumentException("you should implement code here");
        Period age = p.getAge();
        Assertions.assertEquals(1,age.getDays());
        Assertions.assertEquals(0, age.getMonths());
        Assertions.assertEquals(0, age.getYears());
    }

    // TODO some more useful tests
}
