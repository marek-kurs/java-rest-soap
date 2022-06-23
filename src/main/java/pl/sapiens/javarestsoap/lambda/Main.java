package pl.sapiens.javarestsoap.lambda;

import javax.enterprise.inject.spi.Producer;
import java.util.Optional;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {
        System.out.println(getNick() != null ? getNick().length() : 0);

        maybeNick()
                .map(nick -> nick.length())
                .ifPresent(integer -> System.out.println("Nick len: " + integer));

        // very old java - always
        Lambdable oldWay = new LabdableNicImpl();

        // we don't know class name - till 1.7
        Lambdable anonymousWay = new Lambdable() {
            @Override
            public String getNick() {
                return "maniek";
            }
        };

        Lambdable anonymousWay2 = new Lambdable() {
            @Override
            public String getNick() {
                return "maniek";
            }
        };

        Lambdable newWay = () -> "maniek";
        Supplier<String> standardSupplier = () -> "maniek";
        Adult checker = (age) -> {
            System.out.println("checking......");
            return age > 18;
        };
    }

    static Optional<String> maybeNick() {
        return Optional.ofNullable(null);
    }
    static String getNick() {
        return null;
    }
}
