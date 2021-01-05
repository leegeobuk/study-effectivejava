package chapter3.clone;

public class HashTable<K, V> implements Cloneable {
    private Entry<K, V>[] buckets;

    public HashTable() {
        buckets = (Entry<K, V>[]) new Object[16];
    }

    public HashTable(Entry<K, V>[] buckets) {
        this.buckets = buckets;
    }

    @Override
    public HashTable<K, V> clone() {
        try {
            HashTable<K, V> result = (HashTable<K, V>) super.clone();
            result.buckets = (Entry<K, V>[]) new Object[buckets.length];
            for (int i = 0; i < buckets.length; i++)
                if (buckets[i] != null)
                    result.buckets[i] = buckets[i].deepCopy();
            return result;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    private static class Entry<K, V> {
        final K key;
        V val;

        Entry<K, V> next;

        public Entry(K key, V val, Entry<K, V> next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }

        Entry<K, V> deepCopy() {
            Entry<K, V> result = new Entry<>(key, val, next);
            for (Entry<K, V> p = result; p.next != null; p = p.next)
                p.next = new Entry<>(p.next.key, p.next.val, p.next.next);
            return result;
        }
    }

}
