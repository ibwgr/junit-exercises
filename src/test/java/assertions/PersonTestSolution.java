package assertions;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Period;

/**
 * Created by ideadapt on 09.10.16.
 */
public class PersonTestSolution {

    // getFullName

    @Test
    public void getFullNameReturnsFirstnameSpaceLastname(){
        Person p = new Person("Hannes", "Meier", LocalDate.of(1965,5,22));

        String fullName = p.getFullName();

        Assert.assertEquals(fullName, "Hannes Meier");
    }

    // getAge

    @Test
    public void getAgeReturns10YearsIf10YearsAgo() throws Exception {
        Person p = new Person("Hannes", "Meier", LocalDate.now().minusYears(10));

        Period age = p.getAge();

        Assert.assertEquals(10, age.getYears());
        Assert.assertEquals(0, age.getMonths());
        Assert.assertEquals(0, age.getDays());
    }

    @Test
    public void getAgeReturns1DayIfYesterday() throws Exception {
        Person p = new Person("Hannes", "Meier", LocalDate.now().minusDays(1));

        Period age = p.getAge();

        Assert.assertEquals(0, age.getYears());
        Assert.assertEquals(0, age.getMonths());
        Assert.assertEquals(1, age.getDays());
    }
}