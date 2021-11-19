package assertions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Period;

class PersonTest {

    // --- getFullName

    @Test
    void getFullNameReturnsFirstnameSpaceLastname() {
      Person p = new Person("Hannes", "Meier", null);

      String fullName = p.getFullName();

      Assertions.assertEquals(fullName, "Hannes Meier");
    }

  // TODO some more useful tests

  // --- getAge

  @Test
  void getAgeReturns10YearsIf10YearsAgo() { // besserer Testname als getAgeReturns10YearsIf10YearsAgo
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

  // TODO some more useful tests
}
