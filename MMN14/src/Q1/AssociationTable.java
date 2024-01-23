package Q1;

import java.util.TreeMap;
import java.util.Iterator;

/**
 * The AssociationTable class provides a generic implementation of a sorted associative table.
 * It uses a TreeMap to maintain a sorted collection of key-value pairs.
 * The key type K must implement the Comparable interface.
 *
 * @param <K> the type of keys maintained by this table, must be Comparable
 * @param <V> the type of mapped values
 */
public class AssociationTable<K extends Comparable<K>, V> {
    private TreeMap<K, V> map;

    /**
     * Constructs an empty AssociationTable.
     */
    public AssociationTable() {
        this.map = new TreeMap<>();
    }

    /**
     * Constructs an AssociationTable with the specified keys and values.
     * The keys and values are added to the table in the order they appear in the arrays.
     *
     * @param keys   an array of keys
     * @param values an array of values corresponding to the keys
     * @throws IllegalArgumentException if the lengths of keys and values arrays are not equal
     */
    public AssociationTable(K[] keys, V[] values) throws IllegalArgumentException {
        if (keys.length != values.length) {
            throw new IllegalArgumentException("Keys and values arrays must be of the same size");
        }
        this.map = new TreeMap<>();
        for (int i = 0; i < keys.length; i++) {
            this.map.put(keys[i], values[i]);
        }
    }

    /**
     * Adds or updates a key-value pair in the table.
     *
     * @param key   the key to be added or updated
     * @param value the value associated with the key
     */
    public void add(K key, V value) {
        this.map.put(key, value);
    }

    /**
     * Retrieves the value associated with a specific key.
     *
     * @param key the key whose associated value is to be returned
     * @return the value associated with the specified key, or null if the key is not found
     */
    public V get(K key) {
        return this.map.getOrDefault(key, null);
    }

    /**
     * Checks if a specific key exists in the table.
     *
     * @param key the key whose presence in the table is to be tested
     * @return true if the table contains the specified key
     */
    public boolean contains(K key) {
        return this.map.containsKey(key);
    }

    /**
     * Removes the key-value pair associated with a specific key.
     *
     * @param key the key whose associated key-value pair is to be removed
     * @return true if the key was found and the associated key-value pair was removed
     */
    public boolean remove(K key) {
        return this.map.remove(key) != null;
    }

    /**
     * Returns the number of key-value pairs in the table.
     *
     * @return the size of the table
     */
    public int size() {
        return this.map.size();
    }

    /**
     * Returns an iterator over the keys in the table in ascending order.
     *
     * @return an iterator over the keys in the table
     */
    public Iterator<K> keyIterator() {
        return this.map.keySet().iterator();
    }
}
