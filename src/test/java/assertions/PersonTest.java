package assertions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Period;

class PersonTest {

    // --- getFullName

    @Test
    void getFullNameReturnsFirstnameSpaceLastname(){
        Person p = new Person("Mitja", "Perko", null);
        String fullName = p.getFullName();

        Assertions.assertEquals(fullName, "Mitja Perko");
        Assertions.assertNotEquals(fullName, "Perko Mitja");

        //
        //throw new IllegalArgumentException("you should implement code here");
    }

    // Other Test in the function on Top


    // --- getAge

    @Test
    void getAgeReturns10YearsIfBornIn2009() throws Exception {

        Person p = new Person("", "", LocalDate.now().minusYears(10));

        Period age = p.getAge();

        Assertions.assertEquals(10, age.getYears());

        //throw new IllegalArgumentException("you should implement code here");
    }

    @Test
    void getAgeReturns1DayIfYesterday() throws Exception {
        Person p = new Person("", "", LocalDate.now().minusDays(1));
        Period age = p.getAge();

        Assertions.assertEquals(1, age.getDays());

        //throw new IllegalArgumentException("you should implement code here");
    }

    @Test
    void getAgeReturns1MonthIfBornLastMonth() throws Exception {
        Person p = new Person("", "", LocalDate.now().minusMonths(1));
        Period age = p.getAge();

        Assertions.assertEquals(1, age.getMonths());
    }
}
