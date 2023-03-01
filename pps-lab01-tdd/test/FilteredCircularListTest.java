import lab01.tdd3.FilteredCircularList;
import lab01.tdd3.FilteredCircularListImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class FilteredCircularListTest {

    FilteredCircularList circularList;
    FilteredCircularList emptyCircularList;

    @BeforeEach
    void beforeEach(){
        circularList = new FilteredCircularListImpl();
        emptyCircularList = new FilteredCircularListImpl();
        circularList.add(1);
        circularList.add(2);
        circularList.add(3);
    }

    @Test
    void testFilteredNext(){
        assertEquals(Optional.of(2), circularList.filteredNext(i -> (i == 2)));
        assertEquals(Optional.empty(), circularList.filteredNext(i -> (i > 3)));
        assertEquals(Optional.empty(), emptyCircularList.filteredNext(i -> (i == 0)));
    }

}
