package assertions;

/**
 * @author - John Schmidt
 * 23.11.2021, 00:39
 */
public class Calculator {
    CalculatorService service;      //egal... muss man nicht verstehen


    public Calculator(CalculatorService service){
        this.service=service;
    }
//weil ez, darum leerer Construktor...
    public Calculator(){}


    public int perform(int i, int j){
        return service.add(i,j);
    }


    public int add1(int i, int j){
        return i+j+1;//+1
    }

    public void addVoid(int i, int j){
        System.out.println("irgendwas void zeugs");
    }

}
