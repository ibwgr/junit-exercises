package assertions;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class CalculatorTest {

    @Test
    void onePlusOneIsTwo(){
        Assertions.assertEquals(Calculator.addition(1,1),2);
    }
}
