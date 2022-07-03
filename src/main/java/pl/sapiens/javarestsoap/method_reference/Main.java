package pl.sapiens.javarestsoap.method_reference;

import java.util.List;

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
