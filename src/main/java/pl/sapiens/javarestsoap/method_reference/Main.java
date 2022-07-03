package pl.sapiens.javarestsoap.method_reference;

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


    }
}
