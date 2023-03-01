import lab01.tdd.CircularList;
import lab01.tdd.CircularListImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Optional;

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

    @Test
    void testCircularListNextElement(){
        assertEquals(Optional.empty(), emptyCircularList.next());
        assertEquals(Optional.of(1), circularList.next());
        assertEquals(Optional.of(2), circularList.next());
        assertEquals(Optional.of(3), circularList.next());
        assertEquals(Optional.of(1), circularList.next());
    }

    @Test
    void testCircularListPreviousElement(){
        assertEquals(Optional.empty(), emptyCircularList.previous());
        assertEquals(Optional.of(1), circularList.previous());
        assertEquals(Optional.of(3), circularList.previous());
        assertEquals(Optional.of(2), circularList.previous());
    }

    @Test
    void testReset(){
        circularList.next();
        circularList.reset();
        assertEquals(Optional.of(1), circularList.next());
    }

    @Disabled
    @Test public void testTodo(){
        Assertions.fail();
    }

}
