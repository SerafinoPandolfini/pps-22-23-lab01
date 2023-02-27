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
    private AccountHolder accountHolder;
    private BankAccount bankAccount;

    @BeforeEach
    void beforeEach(){
        accountHolder = new AccountHolder("Luigi", "Bianchi", 2);
        bankAccount = new SimpleBankAccountWithAtm(accountHolder, INITIAL_BALANCE);
    }

    @Test
    void testAccountHolder() {
        AccountHolder holder = bankAccount.getHolder();
        assertEquals(holder.getName(), accountHolder.getName());
        assertEquals(holder.getSurname(), accountHolder.getSurname());
        assertEquals(holder.getId(), accountHolder.getId());
    }

    @Test
    void testInitialBalance() {
        assertEquals(INITIAL_BALANCE, bankAccount.getBalance());
    }

    @Test
    void testDepositWithAtm() {
        final int depositBalance = 300;
        bankAccount.deposit(2,depositBalance);
        assertEquals(INITIAL_BALANCE + depositBalance - 1, bankAccount.getBalance());
    }
}
