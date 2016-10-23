package assertions;

import junit.framework.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Period;

/**
 * Created by ideadapt on 09.10.16.
 */
public class PersonTest {



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
    public void getAgeGibtImmer10JahreZurueck() {

        Person p = new Person("Harry", "Moser", LocalDate.now().minusYears(10));

        Period alter = p.getAge();

        Assert.assertEquals(10, alter.getYears());

    }

    @Test
    public void getAgeReturns1DayIfYesterday() throws Exception {

        Person p = new Person("Harry", "Moser", LocalDate.now().minusDays(1));

        Period age = p.getAge();

        Assert.assertEquals(1,age.getDays());
    }

}