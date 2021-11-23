package assertions;

import fakes.User;
import org.junit.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author - John Schmidt
 * 23.11.2021, 00:40
 */
public class CalculatorTest {

    @Test
    public void add1Test(){
        Calculator c1 = new Calculator();
        Assertions.assertEquals(5,c1.add1(2,3));//+1...
    }


//    CalculatorService service1 = new CalculatorService() {        mach es automatisch, warum auch immer
//        @Override
//        public int add(int i, int j) {
//            return 0;
//        }
//    }

    CalculatorService service1 = Mockito.mock(CalculatorService.class);     //egal... muss man nicht verstehen

    @Test
    public void performTest(){
        Calculator c1 = new Calculator(service1);//mit service1, programm sagt create a constructor, klar weil ruft ja konstruktor auf
        //Assertions.assertEquals(5,service.add1(2,3));
//        Assertions.assertEquals(5,c1.perform(2,3));//ohne service1, sagt irgend ein Objekt ist null

        //jetzt alles rot, weil möchte 5, aber gebe 0,0, da isch eher verständlich das da passiert
        // damit jetzt 2 + 3 reinkommen:
        //Mockito.doNothing()
        //Mockito.when(service1.add(2,3))
        Mockito.when(service1.add(1,4)).thenReturn(5);
        Assertions.assertEquals(5,c1.perform(1,4));
    }

    @Test
    public void performTestzumspielen(){
        Calculator c1 = new Calculator(service1);//mit service1, programm sagt create a constructor, klar weil ruft ja konstruktor auf
        //Assertions.assertEquals(5,service.add1(2,3));
//        Assertions.assertEquals(5,c1.perform(2,3));//ohne service1, sagt irgend ein Objekt ist null

        //jetzt alles rot, weil möchte 5, aber gebe 0,0, da isch eher verständlich das da passiert
        // damit jetzt 2 + 3 reinkommen:
        //Mockito.doNothing()
        //Mockito.when(service1.add(2,3))
        Mockito.when(service1.add(1,4)).thenReturn(5);
        //     System.out.println(Mockito.doReturn(Arrays.asList(new User("peter"))).when(mokitoDb).getUsers());//github
        //    System.out.println("uu "+ Mockito.doReturn(Collections.emptyList()).when(mokitoDb).getUsers()  );//github
        System.out.println("?? "+Mockito.when(service1.add(1,4)).thenReturn(5));

        //System.out.println("?? "+Mockito.when(service1.add(1,4)).thenReturn(5));

        //Assertions.assertEquals(5,c1.perform(1,4));
    }

    @Test
    public void addVoidTest(){
        Calculator c1 = new Calculator(service1);//mit service1, programm sagt create a constructor, klar weil ruft ja konstruktor auf
        //Assertions.assertEquals(5,service.add1(2,3));
//        Assertions.assertEquals(5,c1.perform(2,3));//ohne service1, sagt irgend ein Objekt ist null

        //jetzt alles rot, weil möchte 5, aber gebe 0,0, da isch eher verständlich das da passiert
        // damit jetzt 2 + 3 reinkommen:
        //Mockito.doNothing()
        //Mockito.when(service1.add(2,3))
//        Mockito.when(service1.add(1,4)).thenReturn(5);
//        Assertions.assertEquals(5,c1.perform(1,4));
   //    Mockito.when(service1.addVoid(2,3);)//au da git strichpuktund klammer
    //    Mockito.when(service1.add(2,3))//gibt kein strichpunkt Klammer
     //   Mockito.when(service1.addVoid(2,3));geht nicht

      //  System.out.println(Mockito.doAnswer(service1.addVoid(2,4));


   //     System.out.println(Mockito.doReturn(Arrays.asList(new User("peter"))).when(mokitoDb).getUsers());//github
    //    System.out.println("uu "+ Mockito.doReturn(Collections.emptyList()).when(mokitoDb).getUsers()  );//github

//        int x = 5;
//        System.out.println("?? "+Mockito.when(Arrays.asList(service1.add(1,4))).thenReturn(x));

    }


}
