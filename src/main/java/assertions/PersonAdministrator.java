package assertions;

import java.time.LocalDate;
import java.util.Date;

/**
 * Created by Nett on 14.10.2016.
 */
public class PersonAdministrator {


    public static void main(String[] args) {
        try
        {
            Person p1 = new Person("Peter", "Meier", LocalDate.ofYearDay(2006,10));
            System.out.println(p1.getFullName());
            Person p2 = new Person("Peter", null, LocalDate.ofYearDay(2006,10));
            System.out.println(p1.getFullName());
        }
        catch(IllegalArgumentException ex)
        {
            System.out.println(ex.getMessage());
        }

    }

}
