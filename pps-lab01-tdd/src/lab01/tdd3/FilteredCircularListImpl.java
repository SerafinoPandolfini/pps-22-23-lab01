package lab01.tdd3;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class FilteredCircularListImpl implements FilteredCircularList {

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
        }
        int currentElement = list.get(position);
        position = position + 1;
        if (position >= size()) {
            position = 0;
        }
        return Optional.of(currentElement);
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
        position = 0;
    }

    @Override
    public Optional<Integer> filteredNext(Predicate<Integer> condition) {
        int startPosition = position;
        do {
            Optional<Integer> value = next();
            if (value.isPresent() && condition.test(value.get())) {
                    return value;
            }
        } while (startPosition != position);
        return Optional.empty();
    }
}
