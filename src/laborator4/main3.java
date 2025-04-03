package laborator4;

import java.util.*;

public class main3 {

    static class Person {
        String name;
        int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return name + " (" + age + ")";
        }
    }

    public class CollectionsExample {
        public void main(String[] args) {
            // Exercițiul 4.6.1 - Liste, Sortare, Filtrare
            List<Person> people = new ArrayList<>();
            people.add(new Person("Alice", 25));
            people.add(new Person("Bob", 30));
            people.add(new Person("Charlie", 22));

            people.sort(Comparator.comparingInt(p -> p.age));
            System.out.println("Lista sortată: " + people);

            people.removeIf(p -> p.age < 25);
            System.out.println("Lista filtrată (vârsta >= 25): " + people);

            // Exercițiul 4.6.2 - Seturi pentru eliminarea duplicatelor
            Set<Person> personSet = new HashSet<>(people);
            personSet.add(new Person("Alice", 25));
            personSet.add(new Person("David", 40));
            System.out.println("Setul de persoane: " + personSet);

            // Exercițiul 4.6.3 - Map-uri pentru asociere cheie-valoare
            Map<String, Integer> ageMap = new HashMap<>();
            for (Person p : people) {
                ageMap.put(p.name, p.age);
            }
            System.out.println("Harta nume-vârstă: " + ageMap);
            System.out.println("Vârsta lui Alice: " + ageMap.get("Alice"));
        }
    }

}
