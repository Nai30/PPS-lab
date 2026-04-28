package PSP;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
public class testingWeek15 {
    private int[] numbers;
    private String strOne;
    private String strTwo;
    @BeforeEach
    void setUp(){
        numbers = new int[]{28, 10, 18, 17};
        strOne ="Shelly";
        strTwo ="Shelly";

    }

    @Test
    void arrayLessThan(){
        for(int value:numbers){

        assertTrue(value>=20,"value is less than 20");
        }
    }
    @Test
    void strEqualTest(){
        assertEquals(strOne,strTwo,"Does not contain the same characters");
    }


    
}
