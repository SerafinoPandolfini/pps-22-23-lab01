import lab01.tdd2.CircularListWithIterators;
import lab01.tdd2.CircularListWithIteratorsImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.ListIterator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CircularListWithIteratorsTest {

    private CircularListWithIterators circularList;

    @BeforeEach
    void beforeEach(){
        circularList = new CircularListWithIteratorsImpl();
        circularList.add(1);
        circularList.add(2);
        circularList.add(3);

    }

    @Test
    void testForwardIterator(){
        Iterator<Integer> forwardInterator = circularList.forwardIterator();
        assertEquals(1, forwardInterator.next());
        assertEquals(2, forwardInterator.next());
        assertEquals(3, forwardInterator.next());
        assertEquals(1, forwardInterator.next());

    }
}
