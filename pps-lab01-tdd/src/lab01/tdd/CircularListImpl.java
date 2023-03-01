package lab01.tdd;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CircularListImpl implements CircularList {

    private final List<Integer> list = new ArrayList<>();
    private int position = 0;

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
    public Optional<Integer> next() {
        if (isEmpty()) {
            return Optional.empty();
        } else {
            int currentElement = list.get(position);
            position = position + 1;
            if (position >= list.size()) {
                position = 0;
            }
            return Optional.of(currentElement);
        }
    }

    @Override
    public Optional<Integer> previous() {
        if (isEmpty()) {
            return Optional.empty();
        }
        int currentElement = list.get(position);
        position = position - 1;
        if (position < 0) {
            position = size() - 1;
        }
        return Optional.of(currentElement);

    }

    @Override
    public void reset() {

    }
}
