import java.util.*;

import static java.util.Objects.deepEquals;

public class MyMap<K, V> implements Map<K, V> {

    List<MapContent> linkedList = new LinkedList<>();

    @Override
    public int size() {
        return linkedList.size();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        // проверка  наличия конкретнного элемента по key
        return false;
}

    @Override
    public boolean containsValue(Object value) {
        // проверка  наличия конкретнного элемента по key
        return false;
    }

    @Override
    public V get(Object key) {

        for (MapContent content : linkedList) {
            if (content.key.hashCode() == key.hashCode()) {
                if (content.key.equals(key)) {
                    return content.value;
                }
            }
        }

        return null;
    }

    @Override
    public V put(K key, V value) {
        MapContent mapContent = new MapContent(key, value);
        linkedList.add(mapContent);
        return null;
    }

    @Override
    public V remove(Object key) {
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set<K> keySet() {
        return null;
    }

    @Override
    public Collection<V> values() {
        return null;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }

private class MapContent {
    K key;
    V value;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MapContent that = (MapContent) o;
        return Objects.equals(key, that.key) &&
                Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {

        return Objects.hash(key, value);
    }

    public MapContent(K key, V value) {
        this.key = key;
        this.value = value;
    }
}
}
