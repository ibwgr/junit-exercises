package assertions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class PersonTest {

    // --- getFullName

    @Test
    void getFullNameReturnsFirstnameSpaceLastname(){
        // TODO implement
        Person persontest1 = new Person("Peter", "Mustermannomann",null);

        Assertions.assertEquals(persontest1.getFullName(), "Peter Mustermannomann");
        //String gesamtname = persontest1.getFullName();
        //Assertions.assertEquals(gesamtname, "Peter Mustermannomann");


//        if(persontest1.getFullName().contains(" ")){
//            System.out.println("hat ein Leerzeichen");
//        }
//        else{
//            System.out.println("hat kein Leerzeichen, ist fehlgeschlagen");
//        }
        //throw new IllegalArgumentException("you should implement code here");
    }

    // TODO some more useful tests


    // --- getAge

    @Test
    void getAgeReturns10YearsIfBornIn2009() throws Exception {
        // TODO verbessern. Hinweis: Repeatable (wiederholbar) zu jeder Zeit.
        //Person p = new Person("", "", LocalDate.of(2009, 1, 1));
        Person p = new Person("", "", LocalDate.now());//.of(2011, 1, 1));

        //int year = LocalDate.of(2011,5,30).getYear();
        int yearNow = LocalDate.now().getYear();
        System.out.println("yearNow: "+yearNow);
        int yearMinusTen = LocalDate.now().getYear()-10;
        System.out.println("yearMinusTen: "+yearMinusTen);
        int ten =  yearNow-yearMinusTen;
        System.out.println("ten: "+ten);
        Assertions.assertEquals(ten,10);
        //throw new IllegalArgumentException("you should implement code here");
    }

    @Test
    void getAgeReturns1DayIfYesterday() throws Exception {
        //Person p = new Person("", "", LocalDate.now().minusDays(1));
        // TODO implement
        Person p = new Person("", "", LocalDate.now().minusDays(1));

        System.out.println("MinusDay(1)...: "+LocalDate.now().minusDays(1));
        int dayNow = LocalDate.now().getDayOfMonth();   //-LocalDate.now().minusDays(1);
        System.out.println("dayNow: "+dayNow);
        int dayMinusOne = LocalDate.now().getDayOfMonth()-1;
        System.out.println("dayMinusOne "+dayMinusOne);
        int one = dayNow-dayMinusOne;
        System.out.println("one: "+one);

        Assertions.assertEquals(one,1);

        //throw new IllegalArgumentException("you should implement code here");
    }

    // TODO some more useful tests
    @Test                       //ü
    public void getFullNameNoHaveUE(){
        Person p1 = new Person("Peterli", "Musti",null);
        String str = p1.getFullName();

        if (str.contains("ü")) {
            System.out.println("hat ü, also die Methode hat ein ü");
            Assertions.assertTrue(false);
        } else {
            System.out.println("hat kein ü");
            Assertions.assertTrue(true);
        }


    }
}
