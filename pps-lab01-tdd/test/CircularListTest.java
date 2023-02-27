import lab01.tdd.CircularList;
import lab01.tdd.CircularListImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    private static final int INITIAL_SIZE = 3;
    CircularList circularList;
    CircularList emptyCircularList;

    @BeforeEach
    void beforeEach(){
        emptyCircularList = new CircularListImpl();
        circularList = new CircularListImpl();
        circularList.add(1);
        circularList.add(2);
        circularList.add(3);
    }

    @Test
    void testSize(){
        assertEquals(INITIAL_SIZE, circularList.size());
    }

    @Test
    void testCircularListIsEmpty(){
        assertTrue(emptyCircularList.isEmpty());
        assertFalse(circularList.isEmpty());
    }

    @Disabled
    @Test public void testTodo(){
        Assertions.fail();
    }

}
