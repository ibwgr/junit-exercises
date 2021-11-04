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
    @Test
    void getFullNameCheckSpaceBetween(){
        Person pers1 = new Person("Tobias", "Meier", null);
        String fullName = pers1.getFullName();
        Assertions.assertTrue(fullName.contains(" "), "True if space between firstname and lastname");
    }

    @Test
    void isTeenAge18_12ReturnTrue(){
        Person pers1 = new Person("", "", LocalDate.of(2003, 3,11));
        Person pers2 = new Person("", "", LocalDate.of(2009, 3, 11));
        Period age1 = pers1.getAge();
        Period age2 = pers2.getAge();
        int years1 = age1.getYears();
        int years2 = age2.getYears();

        Assertions.assertEquals(18, age1.getYears());
        Assertions.assertEquals(12, age2.getYears());
        Assertions.assertTrue(pers1.isTeen(years1),"Is teen = true");
        Assertions.assertTrue(pers2.isTeen(years2),"Is teen = true");

    }
    @Test
    void isNotTeenAge11_19ReturnFalse(){
        Person pers1 = new Person("", "", LocalDate.of(2010, 3,11));
        Person pers2 = new Person("", "", LocalDate.of(2002, 3, 11));
        Period age1 = pers1.getAge();
        Period age2 = pers2.getAge();
        int years1 = age1.getYears();
        int years2 = age2.getYears();

        Assertions.assertEquals(11, age1.getYears());
        Assertions.assertEquals(19, age2.getYears());
        Assertions.assertFalse(pers1.isTeen(years1), "Not teen = false");
        Assertions.assertFalse(pers2.isTeen(years2), "Not teen = false");
    }


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
