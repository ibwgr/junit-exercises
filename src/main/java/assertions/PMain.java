package assertions;

import java.time.LocalDate;

/**
 * @author - John Schmidt
 * 08.11.2021, 00:40
 */
public class PMain {
    public static void main(String[] args) {

        Person p1 = new Person("Hans","Muster",null);
        Person p2 = new Person("Frau","Musterfrau", LocalDate.of(2005,11,28));
        Person p3 = new Person("Hans","Muster",LocalDate.now());
        //Person p4 = new Person("Hans","Muster",(LocalDate.now()-(LocalDate.of(2021,10,14))));
        Person p5 = new Person("Frau","Musterfrau", LocalDate.of(2021,10,14));
        //getAgeReturns10YearsIfBornIn2009() //2021-10=2011


        //System.out.println("p1: "+p1.getAge());
        System.out.println("p2: "+p2.getAge());
        System.out.println("p3: "+p3.getAge());



    }
}
