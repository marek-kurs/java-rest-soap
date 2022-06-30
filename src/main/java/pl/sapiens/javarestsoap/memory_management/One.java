package pl.sapiens.javarestsoap.memory_management;

public class One {
    private Two two = new Two();
    void one() {
        String s = "s"; // String s = new String("s");
        System.out.println("one - start");
        two.two();
        System.out.println("one - end");
    }
}
