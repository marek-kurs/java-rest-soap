package pl.sapiens.javarestsoap.stream;

import java.util.List;
import java.util.function.Function;

public class StreamMain {

    public static void main(String[] args) {
        // Java 6
        // List<Person> persons = new ArrayList<Person>();

        // Java 7
        // List<Person> persons = new ArrayList<>();

        // Java 9
        // var persons it's the same as List<Persons> persons - shorter...
        // var persons = new ArrayList<Persons>();
        // var persons; without assignment it doesn't work!!!

        var persons = List.of(
                new Person("Maniek", "P", 38),
                new Person("Mateusz", "W.", 28),
                new Person("Adrian", "R", 16)
        );

        var filteredListOfNames = persons.stream()
                .filter(person -> person.age() > 18)
//                .map(new Function<Person, String>() {
//
//                    @Override
//                    public String apply(Person person) {
//                        return person.name();
//                    }
//                })
//                .map(person -> person.name())
                .map(person -> {
                    String name = person.name();
                    System.out.println(name);
                    return name;
                })
//                .forEach(s -> System.out.println("name: " + s));
                .toList();

        for (var name: filteredListOfNames) {
            System.out.println("name: " + name);
        }
    }
}
