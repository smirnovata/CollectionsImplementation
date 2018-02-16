import com.sun.org.apache.xpath.internal.operations.Equals;

import java.util.Objects;

public class Main {

    public static void main(String[] args) {
        MyMap<MyKey, MyValue> myMap = new MyMap<>();
        MyValue one = new MyValue("Tata", "Smit");


        MyMap<String, MyValue> myMap1 = new MyMap<>();
        System.out.println(myMap1.put("1", one));
        MyValue value = myMap1.get("1");
        System.out.println(value.name + " " + value.secondname);


        //System.out.println(myMap.size());
        //System.out.println(myMap.isEmpty());

        //System.out.println(myMap.containsKey(7));
        //System.out.println(myMap.containsKey(0));

        //System.out.println(myMap.containsValue(one));

        System.out.println(myMap.put(new MyKey(7), one));
        value = myMap.get(new MyKey(7));
        System.out.println(value.name + " " + value.secondname);

        System.out.println(myMap.put(new MyKey(7), one));
        value = myMap.get(new MyKey(7));
        System.out.println(value.name + " " + value.secondname);


        //System.out.println(myMap.get(new MyKey(7)));
        //System.out.println(value.name + " " + value.secondname);
        System.out.println(myMap.get(new MyKey(6)));
        //System.out.println(value.name + " " + value.secondname);


        //System.out.println(myMap.size());
        //System.out.println(myMap.isEmpty());

        //System.out.println(myMap.containsKey(7));
        //System.out.println(myMap.containsKey(6));

        //System.out.println(myMap.containsValue(one));
    }

    static class MyValue {
        String name;
        String secondname;

        public MyValue(String name, String secondname) {
            this.name = name;
            this.secondname = secondname;
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
