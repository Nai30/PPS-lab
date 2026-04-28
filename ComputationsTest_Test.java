package PSP;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class ComputationsTest_Test {


    @BeforeEach
    void setUp(){
    

    }
    @Test
    void testFibonacci(){
        Assertions.assertEquals(0, Computations.fibonacci(0));
        Assertions.assertEquals(1, Computations.fibonacci(1));
        Assertions.assertEquals(1, Computations.fibonacci(2));
        Assertions.assertEquals(2, Computations.fibonacci(3));
    }
    @Test
    void testNegativeFibonacci(){
        Assertions.assertThrows(IllegalArgumentException.class,()->Computations.fibonacci(-1));
    }
    @Test
    void testIsPrime(){
        Assertions.assertTrue(Computations.isPrime(2));
        Assertions.assertTrue(Computations.isPrime(3));
        Assertions.assertFalse(Computations.isPrime(4));
    }
    @Test
    void testIsEven(){
        Assertions.assertTrue(Computations.isEven(2));
        Assertions.assertFalse(Computations.isEven(3));
    }
    @Test
    void testIsOdd(){
        Assertions.assertTrue(Computations.isOdd(3));
        Assertions.assertFalse(Computations.isOdd(2));
    }
    @Test
    void testToCelsius(){
        Assertions.assertEquals(0, Computations.toCelsius(32), 0.001);
        Assertions.assertEquals(100, Computations.toCelsius(212), 0.001);
    }
    @Test
    void testToFahrenheit(){
        Assertions.assertEquals(32, Computations.toFahrenheit(0), 0.001);
        Assertions.assertEquals(212, Computations.toFahrenheit(100), 0.001);
    }
    
}
