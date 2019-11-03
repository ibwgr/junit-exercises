package assertions;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.time.LocalDate;
import java.time.Period;

class PersonTest {

    /***********************
    * getFullName
    */
    @Test
    void getFullNameShouldReturnFirstnameSpaceLastname(){
        Person a = new Person("Philipp","Tuor", LocalDate.of(1989, 06, 21));

        String fullName = a.getFullName();

        Assert.assertEquals("Philipp Tuor", fullName);
    }

    @Test
    void getFullNameShouldReturnFirstnameSpaceDoubleLastname() {
        Person a = new Person(" Gülän", "DoubleLastName 123", LocalDate.of(1989, 06, 21));

        String fullName = a.getFullName();

        Assert.assertEquals(" Gülän DoubleLastName 123", fullName);
    }

    @Test
    void getFullNameShouldNotReturnFirstnameLastname(){
        Person a = new Person("Philipp","Tuor", LocalDate.of(1989, 06, 21));

        String fullName = a.getFullName();

        Assert.assertNotEquals("PhilippTuor", fullName);
    }

    @Test
    void getFullNameShouldNotReturnLastnameSpaceFirstname(){
        Person a = new Person("Philipp","Tuor", LocalDate.of(1989, 06, 21));

        String fullName = a.getFullName();

        Assert.assertNotEquals("Tuor Philipp", fullName);
    }



    /***********************
     * getAge
     */

    @Test
    void getAgeShouldReturn10Years() throws Exception {
        Person p = new Person("", "", LocalDate.now().minusYears(10));

        Period actualAge = p.getAge();

        Assert.assertEquals(10, actualAge.getYears());
    }

    @Test
    void getAgeReturns1DayIfYesterday() throws Exception {
        Person p = new Person("", "", LocalDate.now().minusDays(1));

        Period actualAge = p.getAge();

        Assert.assertEquals(1, actualAge.getDays());
    }

    @Test
    void getAgeReturns5MontschIfFiveMonthsAgo() throws Exception {
        Person p = new Person("", "", LocalDate.now().minusMonths(5));

        Period actualAge = p.getAge();

        Assert.assertEquals(5, actualAge.getMonths());
    }

}