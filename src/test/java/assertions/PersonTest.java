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
    void getAgeReturnsAgeInYears() {
        Person p1 = new Person("Gion", "Baptista", LocalDate.of(1987, 8,7));
        Period age = p1.getAge();

        Assertions.assertEquals(32, age.getYears());
        Assertions.assertEquals(2, age.getMonths());
        Assertions.assertEquals(22,age.getDays());
    }

    @Test
    void getAgeReturns10YearsIfBornIn2009() throws Exception {
        Person p = new Person("", "",LocalDate.now().minusYears(10));

        Period age = p.getAge();

        Assertions.assertEquals(10, age.getYears());
        Assertions.assertEquals(0, age.getMonths());
        Assertions.assertEquals(0,age.getDays());

    }

    @Test
    void getAgeReturns1DayIfYesterday() throws Exception {
        Person p = new Person("", "", LocalDate.now().minusDays(1));

        Period age = p.getAge();

        Assertions.assertEquals(0, age.getYears());
        Assertions.assertEquals(0, age.getMonths());
        Assertions.assertEquals(1,age.getDays());
    }

}