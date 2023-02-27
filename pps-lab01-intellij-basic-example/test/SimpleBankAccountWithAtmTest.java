import lab01.example.model.AccountHolder;
import lab01.example.model.BankAccount;

import lab01.example.model.SimpleBankAccountWithAtm;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The test suite for testing the SimpleBankAccountWithAtm implementation
 */

public class SimpleBankAccountWithAtmTest {

    private AccountHolder accountHolder;
    private BankAccount bankAccount;

    @BeforeEach
    void beforeEach(){
        accountHolder = new AccountHolder("Luigi", "Bianchi", 2);
        bankAccount = new SimpleBankAccountWithAtm(accountHolder, 0);
    }

    @Test
    void testAccountHolder() {
        AccountHolder holder = bankAccount.getHolder();
        assertEquals(holder.getName(), accountHolder.getName());
        assertEquals(holder.getSurname(), accountHolder.getSurname());
        assertEquals(holder.getId(), accountHolder.getId());
    }
}
