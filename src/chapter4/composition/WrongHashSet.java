package chapter4.composition;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class WrongHashSet<E> extends HashSet<E> {
    private int addCount = 0;

    public WrongHashSet() {
    }

    public WrongHashSet(int initialCapacity, float loadFactor) {
        super(initialCapacity, loadFactor);
    }

    @Override
    public boolean add(E e) {
        addCount++;
        return super.add(e);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        addCount += c.size();
        return super.addAll(c);
    }

    public int getAddCount() {
        return addCount;
    }

    public static void main(String[] args) {
        WrongHashSet<String> s = new WrongHashSet<>();
        s.addAll(List.of("tick", "taktack", "boom"));
        System.out.println(s.getAddCount());
    }
}
