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
                        content.key = key;
                        content.value = value;
                        return null;
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
                }
            }
        }
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        //void putAll(Map<? extends K, ? extends V> map): добавляет в коллекцию все объекты из отображения map
    }

    @Override
    public void clear() {
        //void clear(): очищает коллекцию
    }

    @Override
    public Set<K> keySet() {
        return null;
        //Set<K> keySet(): возвращает набор всех ключей отображения
    }

    @Override
    public Collection<V> values() {
        //Collection<V> values(): возвращает набор всех значений отображения
        return null;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
        //Set<Map.Entry<K, V>> entrySet(): возвращает набор элементов коллекции. Все элементы представляют объект Map.Entry
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
