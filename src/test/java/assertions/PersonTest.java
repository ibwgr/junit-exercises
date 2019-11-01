package assertions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Period;

class PersonTest {

    // getFullName

    @Test
    void getFullNameReturnsFirstnameSpaceLastname(){
        Person p1 = new Person("Gion", "Baptista", LocalDate.of(1987, 1,1));
        String fullName = p1.getFullName();

        Assertions.assertEquals(fullName, "Gion Baptista");
    }

    @Test
    void getAgeReturns10YearsIfBorn10y5m12dAgo() {
        Person p = new Person("", "",LocalDate.now().minusYears(10).minusMonths(5).minusDays(12));

        Period age = p.getAge();
        System.out.println(age);

        Assertions.assertEquals(10, age.getYears());
        Assertions.assertEquals(5, age.getMonths());
        Assertions.assertEquals(12,age.getDays());

    }

    @Test
    void getAgeReturns1DayIfYesterday() {
        Person p = new Person("", "", LocalDate.now().minusDays(1));

        Period age = p.getAge();

        Assertions.assertEquals(0, age.getYears());
        Assertions.assertEquals(0, age.getMonths());
        Assertions.assertEquals(1,age.getDays());
    }

    @Test
    void getAgeToStringReturnsAgeAsString() {
        Person p = new Person("", "",LocalDate.now().minusYears(10).minusMonths(5).minusDays(12));
        System.out.println(p.getAgeToString());

        Assertions.assertEquals("Age: 10 Years, 5 Months, 12 Days.", p.getAgeToString());
    }

}