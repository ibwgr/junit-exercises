package assertions;

import org.junit.Assert;
import org.junit.Test;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.time.LocalDate;

/**
 * Created by ideadapt on 09.10.16.
 *
 */
public class PersonTest {

    //---------------------------
    // getFullName Tests
    //---------------------------

    @Test
    public void getFullNameReturnsFirstnameSpaceLastname(){
        //System under test (SUT)
        Person p = new Person("Hans", "Muster", LocalDate.now());
        String fullName = p.getFullName();
        Assert.assertEquals("Hans Muster", fullName);
    }

    //  some more useful tests, z.B. Test ohne Nachnamen, allenfalls auch die Personenklasse anpassen
    @Test
    public void getFullNameOnlyWithNachnameReturnOnlyNachname(){
        //System under test (SUT)
        Person p = new Person("Hans", null, LocalDate.now());
        String fullName = p.getFullName();
        Assert.assertEquals("Hans", fullName);
    }

    @Test
    public void getFullNameOnlyWithVornameReturnOnlyVorname(){
        //System under test (SUT)
        Person p = new Person(null, "Muster", LocalDate.now());
        String fullName = p.getFullName();
        Assert.assertEquals("Muster", fullName);
    }

    @Test
    public void getFullNameWithoutNamesReturnNoName(){
        //System under test (SUT)
        Person p = new Person(null, null, LocalDate.now());
        String fullName = p.getFullName();
        Assert.assertEquals(Person.NO_NAME, fullName);
    }

    //---------------------------
    // getAge
    //---------------------------

    // Hinweis: Wiederholbar zu jeder Zeit (auch naechstes Jahr noch!)
    @Test
    public void getAgeReturns10YearsIf2006() throws Exception {
        LocalDate testdate = LocalDate.of(2010, 1, 1);
        int theoreticalCalculatedAge = LocalDate.now().getYear() - testdate.getYear();
        System.out.println("Testdate Year: " +testdate.getYear());
        System.out.println("Current  Year: " +LocalDate.now().getYear());
        System.out.println("Years/age which the method should return: " +theoreticalCalculatedAge);
        //
        Person p = new Person("", "", testdate);
        Assert.assertEquals(theoreticalCalculatedAge , p.getAge().getYears());
    }

    @Test
    public void getAgeReturns1DayIfYesterday() throws Exception {
        Person p = new Person("", "", LocalDate.now().minusDays(1));
        System.out.println(p.getAge().getDays());
    }

    //---------------------------
    //
    //---------------------------
    // no more tests...


}