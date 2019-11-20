package assertions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Period;

class PersonTest {

    // getFullName

    @Test
    void getFullName_ReturnsFirstnameSpaceLastname(){
        // TODO implement
        Person p = new Person("Hannes", "Meier", LocalDate.of(1992, 3, 9));

        String fullName = p.getFullName();

        Assertions.assertEquals(fullName, "Hannes Meier");
    }

    // getAge
    @Test
    void getAge_Returns10YearsIf10YearsAgo(){
        Person p = new Person("Hannes", "Meier", LocalDate.now().minusYears(10));

        Period age = p.getAge();

        Assertions.assertEquals(10, age.getYears());
        Assertions.assertEquals(0, age.getMonths());
        Assertions.assertEquals(0, age.getDays());
    }

    @Test
    void getMonth_Returns1MonthIf1MonthAgo(){
        Person p = new Person("Hannes", "Meier", LocalDate.now().minusMonths(1));

        Period age = p.getAge();

        Assertions.assertEquals(0, age.getYears());
        Assertions.assertEquals(1, age.getMonths());
        Assertions.assertEquals(0, age.getDays());
    }


    @Test
    void getAge_Returns1DayIfYesterday(){
        Person p = new Person("Hannes", "Meier", LocalDate.now().minusDays(1));

        Period age = p.getAge();

        Assertions.assertEquals(0, age.getYears());
        Assertions.assertEquals(0, age.getMonths());
        Assertions.assertEquals(1, age.getDays());
    }


    // some more tests
    @Test
    void getName_ReturnsTrueWhenDifferentName(){
        Person p = new Person("1Hannes", "2Meier", LocalDate.of(1992, 3, 9));

        String fullName = p.getFullName();

        Assertions.assertFalse(Boolean.parseBoolean(fullName), "Hannes Meier");
    }

    @Test
    void getAge_ReturnsTrueWhenDifferentAge(){
        Person p = new Person("Hannes", "Meier", LocalDate.now().minusYears(11));

        Period age = p.getAge();

        Assertions.assertNotEquals(age, 10);
    }

    @Test
    void Person_TrueIfObjectIsNotNul(){
        Person p = new Person("Hannes", "Meier", LocalDate.now().minusYears(80));
        Assertions.assertNotNull(p);
    }

    @Test
    void Person_TrueIf2ObjectsAreNotSame(){
        Person p = new Person("Hannes", "Meier", LocalDate.of(1940, 6, 30));
        Person c = new Person("Petra", "Meier", LocalDate.of(1950, 3, 12));
        Assertions.assertNotSame(p, c);
    }

    @Test
    void Person_TrueIf2ObjectsAreSame(){
        Person p = new Person("Hannes", "Meier", LocalDate.of(1940, 6, 30));
        Person c = p;
        Assertions.assertSame(p, c);
    }
}
