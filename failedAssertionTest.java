package PSP;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class failedAssertionTest {
    @Test
    void testOne(){
        assertEquals(1,2);
    }
    @Test 
    void testTwo(){
        assertTrue(true);
    }
    @Test
    void testThree(){
        assertNull("running");
    }
}
