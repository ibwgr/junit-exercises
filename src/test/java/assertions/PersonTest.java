package assertions;

import org.junit.Assert;
import org.junit.Test;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.time.LocalDate;

/**
 * Created by ideadapt on 09.10.16.
 */
public class PersonTest {

    // getFullName

    @Test
    public void getFullNameReturnsFirstnameSpaceLastname(){
        Person p = new Person("Firstname", "Lastname", LocalDate.of(2006, 1, 1));

        Assert.assertEquals("Firstname Lastname", p.getFullName());
    }

    @Test
    public void getFullNameReturnsSpaceIfEmpty(){
        Person p = new Person("", "", LocalDate.of(2006, 1, 1));

        Assert.assertEquals(" ", p.getFullName());
    }

    // getAge

    @Test
    public void getAgeReturns10YearsIf10YearsAgo() throws Exception {
        Person p = new Person("", "", LocalDate.now().minusYears(10));

        Assert.assertEquals(10, p.getAge().getYears());
        Assert.assertEquals( 0, p.getAge().getMonths());
        Assert.assertEquals( 0, p.getAge().getDays());
    }

    @Test
    public void getAgeReturns1DayIfYesterday() throws Exception {
        Person p = new Person("", "", LocalDate.now().minusDays(1));

        Assert.assertEquals(0, p.getAge().getYears());
        Assert.assertEquals(0, p.getAge().getMonths());
        Assert.assertEquals(1, p.getAge().getDays());
    }

    @Test
    public void getAgeReturns3MonthIf3MonthAgo() throws Exception {
        Person p = new Person("", "", LocalDate.now().minusMonths(3));

        Assert.assertEquals(0, p.getAge().getYears());
        Assert.assertEquals(3, p.getAge().getMonths());
        Assert.assertEquals(0, p.getAge().getDays());
    }

}