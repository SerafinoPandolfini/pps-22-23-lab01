import lab01.example.model.AccountHolder;
import lab01.example.model.BankAccount;

import lab01.example.model.SimpleBankAccountWithAtm;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The test suite for testing the SimpleBankAccountWithAtm implementation
 */

public class SimpleBankAccountWithAtmTest {

    private static final int INITIAL_BALANCE = 100;
    private static final int ATM_FEE = 1;
    private AccountHolder accountHolder;
    private BankAccount bankAccount;

    @BeforeEach
    void beforeEach(){
        accountHolder = new AccountHolder("Luigi", "Bianchi", 2);
        bankAccount = new SimpleBankAccountWithAtm(accountHolder, INITIAL_BALANCE);
    }

    @Test
    void testBankAccountHolder() {
        AccountHolder holder = bankAccount.getHolder();
        assertEquals(accountHolder, holder);
    }

    @Test
    void testInitialBalance() {
        assertEquals(INITIAL_BALANCE, bankAccount.getBalance());
    }

    @Test
    void testDepositWithAtm() {
        final int depositAmount = 300;
        bankAccount.deposit(2,depositAmount);
        assertEquals(INITIAL_BALANCE + depositAmount - ATM_FEE, bankAccount.getBalance());
    }

    @Test
    void testWithdrawWithAtm() {
        final int withdrawAmount = 40;
        bankAccount.withdraw(2, withdrawAmount);
        assertEquals(INITIAL_BALANCE - withdrawAmount - ATM_FEE, bankAccount.getBalance());
    }

    @Test
    void testWrongWithdraw() {
        final int withdrawAmount = 200;
        bankAccount.withdraw(2, withdrawAmount);
        assertEquals(INITIAL_BALANCE, bankAccount.getBalance());
    }

}
