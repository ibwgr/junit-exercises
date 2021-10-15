package assertions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Period;

class PersonTest {

    // --- getFullName

    @Test
    void getFullNameReturnsFirstnameSpaceLastname(){
        Person p = new Person("Hans", "Müller", LocalDate.of(1986, 7, 18));
        String fullname = "Hans Müller";
        Assertions.assertEquals(fullname, p.getFullName());
    }


    // --- getAge

    @Test
    void getAgeReturns10YearsIf10ago() {
        Person p = new Person("", "", LocalDate.now().minusYears(10));
        Period age = p.getAge();
        Assertions.assertEquals(10, age.getYears());
    }

    @Test
    void getAgeHasToBePositive() {
        LocalDate birthday = LocalDate.now().minusYears(10).minusMonths(7).minusDays(9);
        Person p = new Person("Foo", "Bar", birthday);
        Period age = p.getAge();
        Assertions.assertTrue(age.getYears() > 0 || age.getMonths() > 0 || age.getDays() > 0);
    }

    @Test
    void getAgeReturns1DayIfYesterday() {
        Person p = new Person("", "", LocalDate.now().minusDays(1));
        Period age = p.getAge();
        Assertions.assertEquals(1, age.getDays());
    }

    @Test
    void getAgeReturns5MonthsIf5MonthsAgo() {
        Person p = new Person("", "", LocalDate.now().minusMonths(5));
        Period age = p.getAge();
        Assertions.assertEquals(5, age.getMonths());
    }

    @Test
    void checkIfAgeIsLargerThen11(){
        Person p = new Person("", "", LocalDate.of(2009, 10, 10));
        Period age = p.getAge();
        System.out.println(age.getYears());
        Assertions.assertTrue(age.getYears() > 11);
    }
}
