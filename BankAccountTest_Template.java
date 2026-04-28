package PSP;



import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;



class BankAccountTest {

    private BankAccount account;

    @BeforeEach
    void setUp() {
        // Starts each test with a fresh account of 100.0
        account = new BankAccount(100.0);
    }

    /** 1. Add an @AfterEach annotation and method to delete the current bank account to make it available for garbage collection */
    @AfterEach
    void setDown(){
        account=null;
    }

    @Test
    void testDeposit() {
    /** 2. Adeposit $50 and check that the balance is 150 */
    account.deposit(50);
    assertTrue(account.getBalance()==150);
    }

    @Test
    void testWithdraw() {
    /** 3. withdraw $40 and check that the balance is $60; remember that each test is done on a fresh instance of bank account */
    account.withdraw(40.0);
    assertEquals(60,account.getBalance());
    }

    @Test
    void testInvalidDeposit() {
    /** 4. Deposit a negative amount and check if an exception is thrown */
    assertThrows(IllegalArgumentException.class,()->account.deposit(-10));
    }

    @Test
    void testOverdraft() {
    /** 5. Verify that Withdrawing more than the current balance
    throws an exception */
    assertThrows(IllegalArgumentException.class,()->account.withdraw(150));
    }

    @Test
    /** 6. Add a test to check that an Exception is thrown when
    trying to create a new bankaccout with a negaive initial balance */
    void testInvalidBalance(){
        assertThrows(IllegalArgumentException.class,()-> new BankAccount(-10));
    }

     
}
