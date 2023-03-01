package lab01.tdd2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CircularListWithIteratorsImpl implements CircularListWithIterators {
    private final List<Integer> list = new ArrayList<>();

    @Override
    public void add(int element) {
        list.add(element);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.size() == 0;
    }

    @Override
    public Iterator<Integer> forwardIterator() {
        return new Iterator<>() {

            private int position = 0;

            @Override
            public boolean hasNext() {
                return true;
            }

            @Override
            public Integer next() {
                int currentElement = list.get(position);
                position = position + 1;
                if (position >= size()) {
                    position = 0;
                }
                return currentElement;
            }
        };
    }

    @Override
    public Iterator<Integer> backwardIterator() {
        return new Iterator<>() {

            private int position = 0;

            @Override
            public boolean hasNext() {
                return true;
            }

            @Override
            public Integer next() {
                int currentElement = list.get(position);
                position = position - 1;
                if (position < 0) {
                    position = size() - 1;
                }
                return currentElement;
            }
        };
    }
}
