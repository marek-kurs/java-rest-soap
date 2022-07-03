package pl.sapiens.javarestsoap.method_reference;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import static java.lang.System.out;

public class Main {

    public static void main(String[] args) {
        var persons = List.<PersonRecord>of(
                new PersonRecord("jarek",
                        "k.",
                        18,
                        new Address("Poland", "Warsaw", "", "")),

                new PersonRecord("Andrew",
                        "Dudu",
                        15,
                        new Address("Poland", "Unknown", "", "151")),

                new PersonRecord("Jan",
                        "Kowalski",
                        55,
                        new Address("Poland", "Radom", "Główna", "11")),

                new PersonRecord("Jan",
                        "Kowalski",
                        40,
                        new Address("Poland", "Radom", "Główna", "11")),

                new PersonRecord("Jan",
                        "Kowalski",
                        80,
                        new Address("Poland", "Radom", "Główna", "11"))


        );

        // You cannot use again closed stream!!!
//        Stream<PersonRecord> personStream = persons.stream();
//        // with lambda
//        personStream
//                // void accept(T t);
//                .forEach(person -> {
//                    out.println(person);
//                });
//
//        // with method reference
//        personStream
//                // void accept(T t);
//                // functional programming
//                .forEach(out::println);
        // with lambda
        persons.stream()
                // void accept(T t);
                .forEach(person -> {
                    out.println(person);
                });

        // with method reference
        persons.stream()
                // void accept(T t);
                // functional programming
                .forEach(out::println);


        // if class implements Comparable it's called natural order
        // Comparator is used for custom object comparison - there can be more
        // than one way
        // cannot compare using sorted() method if class doesn't implement Comparable
//        persons.stream()
//                .sorted() // usuing natural class order - Comparable
//                .forEach(person -> out.println(person));

        out.println("Sorting by name");
        persons.stream()
                .sorted((person1, person2) -> person1.name().compareTo(person2.name()))
                .forEach(out::println);

        out.println("Sorting by age - sending custom comparator");
        persons.stream()
                // result lower than zero means it's first
                .sorted((o1, o2) -> o1.age() - o2.age())
                .forEach(out::println);

        out.println("Sorting by age - using method from PersonRecord - lambda version");
        persons.stream()
                .sorted((person1, person2) -> PersonRecord.comparePersonAge(person1, person2))
                .forEach(out::println);

        out.println("Sorting by age - using method from PersonRecord - method reference version");
        persons.stream()
                .sorted(PersonRecord::comparePersonAge) // sorted using given method
                .forEach(out::println);

        out.println("Sorting by name - extra features of Comparator");
        persons.stream()
                .sorted(Comparator.comparing(PersonRecord::name)
                        .thenComparing(PersonRecord::surname)
                        .thenComparingInt(PersonRecord::age)
                        .reversed())
                .forEach(out::println);
    }
}
