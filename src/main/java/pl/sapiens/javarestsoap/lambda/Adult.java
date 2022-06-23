package pl.sapiens.javarestsoap.lambda;

@FunctionalInterface
interface Adult {
    boolean isAdult(int age);

    default boolean myFriend(int age) {
        return false;
    }
}
