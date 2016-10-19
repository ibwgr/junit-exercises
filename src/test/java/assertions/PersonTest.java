package assertions;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.time.LocalDate;
import java.time.Period;

/**
 * Created by ideadapt on 09.10.16.
 */
public class PersonTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    // getFullName

    @Test
    public void getFullNameReturnsFirstnameSpaceLastname(){

        Person p = new Person("Hans", "Meier",LocalDate.now());

        String fullname = p.getFullName();

        Assert.assertEquals("Hans Meier", fullname);
    }

    @Test
    public void getFullNameReturnsFirstnameSpaceLastnameInFirstnameMoreSpacesLastname(){
        Person p = new Person(" Hans ", " Meier ", LocalDate.now());

        String fullname = p.getFullName();

        Assert.assertEquals("Hans Meier", fullname);
    }

    @Test
    public void newPersonThrowIllegalArgumentExceptionFirstnameEmptyString(){

        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("not allowed empty String");

        new Person("", "Meier", LocalDate.now());
    }

    @Test
    public void newPersonThrowIllegalArgumentExceptionLastnameEmptyString(){

        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("not allowed empty String");

        new Person("Hans", "", LocalDate.now());
    }

    @Test
    public void newPersonThrowIllegalArgumentExceptionLastnameNull(){

        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("not allowed null for String argument");

        new Person("Hans", null, LocalDate.now());
    }

    @Test
    public void newPersonThrowIllegalArgumentExceptionFirstnameNull(){

        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("not allowed null for String argument");

        new Person(null, "Meier", LocalDate.now());
    }

    @Test
    public void newPersonThrowIllegalArgumentExceptionFirstnameOrLastnameWithNumber(){

        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("numbers not allowed in name");

        new Person("Hans", "Meier12", LocalDate.now());
    }

    @Test
    public void newPersonThrowIllegalArgumentExceptionFirstnameWhiteSpaces(){

        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("not allowed only white spaces");

        new Person("  ", "Meier", LocalDate.now());
    }

    @Test
    public void newPersonThrowIllegalArgumentExceptionLastnameWhiteSpaces(){

        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("not allowed only white spaces");

        new Person("Hans", "  ", LocalDate.now());
    }

    // getAge

    @Test
    public void getAgeReturns10YearsIf2006(){
        Person p = new Person("Hans", "Meier", LocalDate.of(2006, 1, 1));
        
        int differenceTo2016 = LocalDate.now().getYear() - 2016;
        Period alter = p.getAge();

        Assert.assertEquals(10,alter.getYears()- differenceTo2016);
    }


    @Test
    public void getAgeReturns1DayIfYesterday(){
        Person p = new Person("Hans", "Meier", LocalDate.now().minusDays(1));

        Period alter = p.getAge();

        Assert.assertEquals(1,alter.getDays());

    }

    @Test
    public void newPersonThrowIllegalArgumentBirthdayNull(){

        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("not allowed null or date after actual time for birthDate");

        new Person("Hans", "Meier", null);
    }

    @Test
    public void newPersonThrowIllegalArgumentBirthdayAfterActualDay(){

        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("not allowed null or date after actual time for birthDate");

        new Person("Hans", "Meier", LocalDate.now().plusDays(1));
    }

}