package assertions;

/**
 * @author - John Schmidt
 * 23.11.2021, 00:42
 */
public class CMain {

    public static void voidMethode(){
        System.out.println("ich bin VoidMethode von Main");
    }

    public static void voidMethodeMitInt(int f){
        System.out.println("ich bin VoidMethode von Main mit int f");
    }


    public static void main(String[] args) {


        Calculator c1 = new Calculator();
        System.out.println(c1.add1(2, 3));

      //  System.out.println( c1.addVoid(99,88) );//nicht systemprintln...
        //System.out.println();
       // voidMethode();
        CMain.voidMethode();
        CMain.voidMethodeMitInt(1);
        c1.addVoid(99,88);

    }
}
