import com.sun.org.apache.xpath.internal.operations.Equals;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        MyMap<MyKey, MyValue> myMap = new MyMap<>();
        MyValue one = new MyValue("Tata", "Smit");


        //MyMap<String, MyValue> myMap1 = new MyMap<>();
        //System.out.println(myMap1.put("1", one));
        //MyValue value = myMap1.get("1");
        //System.out.println(value.name + " " + value.secondname);


        System.out.println("size = " + myMap.size());
        System.out.println("Empty? " + myMap.isEmpty());

        System.out.println("Contains1 (false) " + myMap.containsKey(new MyKey(7)));
        System.out.println("Contains2 (false) " + myMap.containsKey(new MyKey(0)));
        System.out.println("Contains3 (false) " + myMap.containsValue(one));

        System.out.println("Get " + myMap.get(new MyKey(3)));

        myMap.put(new MyKey(7), one);

        MyValue value = myMap.get(new MyKey(7));
        System.out.println(value.name + " " + value.secondname);

        System.out.println("Contains4 (true) " + myMap.containsKey(new MyKey(7)));
        System.out.println("Contains5 (false) " + myMap.containsKey(new MyKey(0)));
        System.out.println("Contains6 (true) " + myMap.containsValue(one));
        System.out.println("Contains7 (false) " + myMap.containsValue(new MyValue("T", "S")));

        System.out.println("size = " + myMap.size());
        System.out.println("Empty? " + myMap.isEmpty());

        myMap.put(new MyKey(6), new MyValue("S", "D"));

        value = myMap.get(new MyKey(6));
        System.out.println(value.name + " " + value.secondname);

        System.out.println("Contains8 (true) " + myMap.containsKey(new MyKey(7)));
        System.out.println("Contains9 (true) " + myMap.containsKey(new MyKey(6)));
        System.out.println("Contains10 (false) " + myMap.containsKey(new MyKey(3)));
        System.out.println("Contains11 (true) " + myMap.containsValue(one));
        System.out.println("Contains12 (true) " + myMap.containsValue(new MyValue("S", "D")));
        System.out.println("Contains13 (false) " + myMap.containsValue(new MyValue("T", "S")));

        System.out.println("? size = " + myMap.size());


        value = myMap.put(new MyKey(7), new MyValue("T", "S"));
        System.out.println(value.name + " " + value.secondname);

        value = myMap.get(new MyKey(7));
        System.out.println(value.name + " " + value.secondname);

        System.out.println("Contains14 (true) " + myMap.containsKey(new MyKey(7)));
        System.out.println("Contains15 (true) " + myMap.containsKey(new MyKey(6)));
        System.out.println("Contains16 (false) " + myMap.containsKey(new MyKey(3)));
        System.out.println("Contains17 (false) " + myMap.containsValue(one));
        System.out.println("Contains18 (true) " + myMap.containsValue(new MyValue("S", "D")));
        System.out.println("Contains19 (true) " + myMap.containsValue(new MyValue("T", "S")));

        myMap.put(new MyKey(3), new MyValue("Se", "Da"));
        myMap.put(new MyKey(4), new MyValue("Ta", "Smi"));
        myMap.put(new MyKey(1), new MyValue("Tat", "Sm"));

        System.out.println("size = " + myMap.size());

        myMap.remove(new MyKey(3));

        System.out.println("size = " + myMap.size());

        MyMap<MyKey, MyValue> myMap2 = new MyMap<>();
        System.out.println("(myMap2)size = " + myMap2.size());
        myMap2.putAll(myMap);
        System.out.println("(myMap2)size = " + myMap2.size());



        Map<MyKey, MyValue> map = new HashMap<>();
        map.put(new MyKey(56), new MyValue("A", "S"));
        map.put(new MyKey(44), new MyValue("I", "S"));
        map.put(new MyKey(7), new MyValue("I", "S"));

        myMap.putAll(map);

        System.out.println("size = " + myMap.size());

        for (MyKey key : myMap.keySet()) {
            System.out.print(key.age + " ");
        }
        System.out.println();

        for (MyValue value1 : myMap.values()) {
            System.out.println(value1.name + " " + value1.secondname);
        }
        System.out.println("size _ = " + myMap.size());

        for (Map.Entry<MyKey,
                MyValue> entry : myMap.entrySet()) {
            MyKey key = entry.getKey();
            value = entry.getValue();
            System.out.println(key.age + " " + value.name + " " + value.secondname);
        }

        myMap.clear();
        System.out.println("size = " + myMap.size());

    }

    static class MyValue {
        String name;
        String secondname;

        public MyValue(String name, String secondname) {
            this.name = name;
            this.secondname = secondname;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            MyValue myValue = (MyValue) o;
            return Objects.equals(name, myValue.name) &&
                    Objects.equals(secondname, myValue.secondname);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, secondname);
        }
    }

    static class MyKey {
        Integer age;

        public MyKey(Integer age) {
            this.age = age;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            MyKey myKey = (MyKey) o;
            return Objects.equals(age, myKey.age);
        }

        @Override
        public int hashCode() {

            return Objects.hash(age);
        }
    }
}
