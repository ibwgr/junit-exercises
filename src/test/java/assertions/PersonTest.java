package assertions;

import junit.framework.Assert;
import org.junit.Test;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.time.LocalDate;
import java.time.Period;

/**
 * Created by ideadapt on 09.10.16.
 */
public class PersonTest {

    // getFullName

    @Test
    public void getFullNameReturnsFirstnameSpaceLastname(){
        Person p = new Person("Harry", "Moser", LocalDate.now());

        String fullname = p.getFullName();

        Assert.assertEquals("Harry Moser", fullname);
    }

    // TODO some more useful tests
    @Test
    public void getAgeReturnTestObObjektPeriodeZurckKommt(){
        Person t = new Person("Harry", "Moser", LocalDate.now());
        Period  period = t.getAge();
        Assert.assertNotNull(period);

    }
    @Test
    public void getAgeRetunObAlterRichtigRechnet() {
        Person p = new Person("Harry", "Moser", LocalDate.of(1973, 04, 10));
        Period  period = p.getAge();
        Assert.assertEquals(43,period.getYears());



    }

    // TODO verbessern. Hinweis: Repeatable (wiederholbar) zu jeder Zeit.
    @Test
    public void getAgeReturns10YearsIf2006() throws Exception {
        Person p = new Person("", "", LocalDate.of(2006, 1, 1));


    }

    @Test
    public void getAgeReturns1DayIfYesterday() throws Exception {
        Person p = new Person("", "", LocalDate.now().minusDays(1));

        // TODO implement
        throw new NotImplementedException();
    }
    // TODO some more useful tests
}