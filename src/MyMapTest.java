import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class MyMapTest {

    @Test
    public void size() {
        Assert.assertEquals(new MyMap<Integer, String>().size(), 0);
    }

    @Test
    public void isEmpty() {
        Assert.assertTrue(new MyMap<Integer, String>().isEmpty());
    }

    @Test
    public void putSizeEmptyContains() {

        Map<Integer, String> map = new MyMap<>();

        map.put(1, "1");

        Assert.assertEquals(map.size(), 1);

        Assert.assertFalse(map.isEmpty());

        Assert.assertTrue(map.containsKey(1));
        Assert.assertTrue(map.containsValue("1"));

        Assert.assertFalse(map.containsKey(2));
        Assert.assertFalse(map.containsValue("2"));

    }

    @Test
    public void putReturn() {
        Map<Integer, String> map = new MyMap<>();

        map.put(1, "1");

        Assert.assertEquals("1", map.put(1, "2"));
        Assert.assertEquals(map.size(), 1);

        Assert.assertEquals(1, map.size());
    }


    @Test
    public void get() {
        Map<Integer, String> map = new MyMap<>();
        map.put(1, "1");
        Assert.assertEquals(map.get(1), "1");
    }

    @Test
    public void remove() {
        Map<Integer, String> map = new MyMap<>();
        Assert.assertNull(map.remove(1));
        map.put(1, "1");
        Assert.assertEquals("1", map.remove(1));
        Assert.assertTrue(map.isEmpty());
    }

    @Test
    public void putAll() {
        Map<Integer, String> map = new MyMap<>();
        Map<Integer, String> map1 = new HashMap<>();
        map1.put(1, "1");
        map1.put(2, "2");
        map.putAll(map1);
        Assert.assertEquals(map.size(), 2);
    }


    @Test
    public void clear() {
        Map<Integer, String> map = new MyMap<>();
        map.put(1, "1");
        map.put(2, "2");
        Assert.assertFalse(map.isEmpty());
        map.clear();
        Assert.assertTrue(map.isEmpty());
    }

    @Test
    public void keySet() {
        Map<Integer, String> map = new MyMap<>();
        map.put(2, "2");
        map.put(1, "1");
        Set<Integer> set = new HashSet<>(Arrays.asList(1, 2));
        Assert.assertEquals(map.keySet(), set);
    }

    @Test
    public void values() {
        Map<Integer, String> map = new MyMap<>();
        map.put(2, "2");
        map.put(1, "1");
        Set<String> set = new HashSet<>(Arrays.asList("1", "2"));
        Assert.assertEquals(map.values(), set);
    }

    @Test
    public void entrySet() {
        Map<Integer, String> map = new MyMap<>();
        map.put(2, "3");
        map.put(1, "5");
        Assert.assertNotNull(map.entrySet());
    }
}
