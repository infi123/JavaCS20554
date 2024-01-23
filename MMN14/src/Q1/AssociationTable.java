package Q1;

import java.util.TreeMap;
import java.util.Iterator;

public class AssociationTable<K extends Comparable<K>, V> {
    private TreeMap<K, V> map;

    // Constructor for an empty table
    public AssociationTable() {
        this.map = new TreeMap<>();
    }

    // Constructor with arrays of keys and values
    public AssociationTable(K[] keys, V[] values) throws IllegalArgumentException {
        if (keys.length != values.length) {
            throw new IllegalArgumentException("Keys and values arrays must be of the same size");
        }
        this.map = new TreeMap<>();
        for (int i = 0; i < keys.length; i++) {
            this.map.put(keys[i], values[i]);
        }
    }

    // Add method
    public void add(K key, V value) {
        this.map.put(key, value);
    }

    // Get method
    public V get(K key) {
        return this.map.getOrDefault(key, null);
    }

    // Contains method
    public boolean contains(K key) {
        return this.map.containsKey(key);
    }

    // Remove method
    public boolean remove(K key) {
        return this.map.remove(key) != null;
    }

    // Size method
    public int size() {
        return this.map.size();
    }

    // KeyIterator method
    public Iterator<K> keyIterator() {
        return this.map.keySet().iterator();
    }
}
