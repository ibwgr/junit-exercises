package assertions;

import com.sun.xml.internal.ws.policy.AssertionSet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.time.LocalDate;
import java.time.Period;

class PersonTest {


    @Test
    void getFullNameReturnsFirstnameSpaceLastname(){

        Person p = new Person("Hans", "Müller", null);
        String fullname = p.getFullName();
        Assertions.assertEquals(fullname, "Hans Müller");
    }

    @Test
    void getAgeReturned10Years() throws Exception{

        Person p1 = new Person ("", "", LocalDate.now().minusYears(10));
        Period age = p1.getAge();
        Assertions.assertEquals(10, age.getYears());
        Assertions.assertEquals(0, age.getMonths());
        Assertions.assertEquals(0, age.getDays());
    }

    @Test
    void getAgeReturns1DayIfYesterday() throws Exception {
        Person p = new Person("", "", LocalDate.now().minusDays(1));
        Period age = p.getAge();
        Assertions.assertEquals(0, age.getYears());
        Assertions.assertEquals(0, age.getMonths());
        Assertions.assertEquals(1, age.getDays());
    }

    @Test
    void getAgeReturs3Month(){
        Person p2 = new Person("", "", LocalDate.now().minusMonths(3));
        Period age = p2.getAge();
        Assertions.assertEquals(0, age.getYears());
        Assertions.assertEquals(3, age.getMonths());
        Assertions.assertEquals(0, age.getDays());
    }
}
