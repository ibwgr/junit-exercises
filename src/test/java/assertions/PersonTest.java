package assertions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class PersonTest {

    // --- getFullName

    @Test
    void getFullNameReturnsFirstnameSpaceLastname(){
        String lastname = "Desax";
        String firstname = "Gion";
        Person p = new Person(firstname, lastname, null);
        String fullname = firstname + " " + lastname;
        Assertions.assertEquals(fullname, p.getFullName());
    }

    @Test
    void getFullNameNotReturnsFirstnameSpaceLastname(){
        String lastname = "Desax";
        String firstname = "Gion";
        Person p = new Person(firstname, lastname, null);

        String fullName = lastname + " " + firstname;
        Assertions.assertNotEquals(fullName,p.getFullName());
    }

   @Test
   void getFullNameReturnsFirstCharsInBigLetters(){
        String lastname = "Desax";
        String firstname = "Gion";
        Person p = new Person(firstname, lastname, null);
        String[] arrStr = p.getFullName().split(" ");
        for(String a : arrStr){
            if (!Character.isUpperCase(a.charAt(0))) {
                assert false;
            }
        }
   }

    // --- getAge

    @Test
    void getAgeReturns10YearsIfBorn10YearsAgo()  {
        Person p = new Person("", "", LocalDate.now().minusYears(10));
        Assertions.assertEquals(10,p.getAge().getYears());
        Assertions.assertEquals(0,p.getAge().getMonths());
        Assertions.assertEquals(0,p.getAge().getDays());
    }

    @Test
    void getAgeReturns1DayIfYesterday() {
        Person p = new Person("", "", LocalDate.now().minusDays(1));
        Assertions.assertEquals(0, p.getAge().getYears());
        Assertions.assertEquals(0,p.getAge().getMonths());
        Assertions.assertEquals(1,p.getAge().getDays());
    }

    @Test
    void getAgeReturnIsNotTooHigh(){
        LocalDate birthDay = LocalDate.now().plusDays(0);
        Person p = new Person("", "", birthDay);
        if(p.getAge().isNegative()){
            AssertionError error = new AssertionError("LocalDate birthday " + birthDay + " is set to future");
            System.out.println(error.getMessage());
            assert false;
        }
    }
}
