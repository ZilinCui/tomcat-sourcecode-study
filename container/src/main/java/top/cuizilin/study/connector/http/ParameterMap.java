package top.cuizilin.study.connector.http;

import java.util.HashMap;
import java.util.Map;

public class ParameterMap extends HashMap {
    public ParameterMap() {

        super();

    }


    /**
     * Construct a new, empty map with the specified initial capacity and
     * default load factor.
     *
     * @param initialCapacity The initial capacity of this map
     */
    public ParameterMap(int initialCapacity) {

        super(initialCapacity);

    }


    /**
     * Construct a new, empty map with the specified initial capacity and
     * load factor.
     *
     * @param initialCapacity The initial capacity of this map
     * @param loadFactor The load factor of this map
     */
    public ParameterMap(int initialCapacity, float loadFactor) {

        super(initialCapacity, loadFactor);

    }


    /**
     * Construct a new map with the same mappings as the given map.
     *
     * @param map Map whose contents are dupliated in the new map
     */
    public ParameterMap(Map map) {

        super(map);

    }


    // ------------------------------------------------------------- Properties


    /**
     * The current lock state of this parameter map.
     */
    private boolean locked = false;


    /**
     * Return the locked state of this parameter map.
     */
    public boolean isLocked() {

        return (this.locked);

    }


    /**
     * Set the locked state of this parameter map.
     *
     * @param locked The new locked state
     */
    public void setLocked(boolean locked) {

        this.locked = locked;

    }


    /**
     * The string manager for this package.


    // --------------------------------------------------------- Public Methods



    /**
     * Remove all mappings from this map.
     *
     * @exception IllegalStateException if this map is currently locked
     */
    public void clear() {
        super.clear();
    }


    /**
     * Associate the specified value with the specified key in this map.  If
     * the map previously contained a mapping for this key, the old value is
     * replaced.
     *
     * @param key Key with which the specified value is to be associated
     * @param value Value to be associated with the specified key
     *
     * @return The previous value associated with the specified key, or
     *  <code>null</code> if there was no mapping for key
     *
     * @exception IllegalStateException if this map is currently locked
     */
    public Object put(Object key, Object value) {
        return (super.put(key, value));
    }


    /**
     * Copy all of the mappings from the specified map to this one.  These
     * mappings replace any mappings that this map had for any of the keys
     * currently in the specified Map.
     *
     * @param map Mappings to be stored into this map
     *
     * @exception IllegalStateException if this map is currently locked
     */
    public void putAll(Map map) {
        super.putAll(map);

    }


    /**
     * Remove the mapping for this key from the map if present.
     *
     * @param key Key whose mapping is to be removed from the map
     *
     * @return The previous value associated with the specified key, or
     *  <code>null</code> if there was no mapping for that key
     *
     * @exception IllegalStateException if this map is currently locked
     */
    public Object remove(Object key) {
        return (super.remove(key));

    }

}
