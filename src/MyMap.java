import java.util.*;

public class MyMap<K, V> implements Map<K, V> {

    private List<MapContent> linkedList = new LinkedList<>();

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
        for (MapContent content : linkedList) {
            if (content.key.hashCode() == key.hashCode()) {
                if (content.key.equals(key)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        for (MapContent content : linkedList) {
            if (content.value.hashCode() == value.hashCode()) {
                if (content.value.equals(value)) {
                    return true;
                }
            }
        }

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
        if (linkedList.size() != 0) {
            for (MapContent content : linkedList) {
                if (content.key.hashCode() == key.hashCode()) {
                    if (content.key.equals(key)) {
                        V value1 = content.value;
                        content.key = key;
                        content.value = value;
                        return value1;
                    }
                }
            }
        }

        MapContent mapContent = new MapContent(key, value);
        linkedList.add(mapContent);
        return null;
    }

    @Override
    public V remove(Object key) {
        for (MapContent content : linkedList) {
            if (key.hashCode() == content.key.hashCode()) {
                if (content.key.equals(key)) {
                    linkedList.remove(content);
                    return content.value;
                }
            }
        }
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        for (Entry<? extends K, ? extends V> entry : m.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }


    @Override
    public void clear() {
        linkedList.clear();
    }

    @Override
    public Set<K> keySet() {
        Set<K> set = new HashSet<>();
        for (MapContent content : linkedList) {
            set.add(content.key);
        }
        return set;
    }

    @Override
    public Collection<V> values() {
        Collection<V> collection = new HashSet<>();
        for (MapContent content : linkedList) {
            collection.add(content.value);
        }
        return collection;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return new HashSet<>(linkedList);
    }

     private class MapContent implements Entry<K, V> {
        private K key;
        private V value;

        MapContent(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            return this.value = value;
        }

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

    }
}
