import java.util.ArrayList;
import java.util.List;

import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;

public class Comparator {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        System.out.println("hello ============");
        persons.add(new Person(18,"Van A", 1));
        persons.add(new Person(25,"Van B", 4));
        persons.add(new Person(24,"Van C", 5));
        persons.add(new Person(22,"Van D", 2));
        persons.add(new Person(30,"Van E", 7));

        persons.sort(comparingInt(p -> p.age));
//~        persons.sort((p1,p2) -> p1.getAge() - p2.getAge());
        persons.forEach(System.out::println);
        System.out.println("======================================");
        persons.sort(comparing(Person::getName));
//~        persons.sort((p1,p2) -> p1.getName().compareTo(p2.getName()));

        persons.forEach(System.out::println);
    }
    static class Person{
        private int age;
        private String name;
        private int id;

        @Override
        public String toString() {
            return "Person{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    ", id=" + id +
                    '}';
        }

        public Person(int age, String name, int id) {
            this.age = age;
            this.name = name;
            this.id = id;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }
}