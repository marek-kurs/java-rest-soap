package pl.sapiens.javarestsoap.memory_management;

public class Two {
    public void two() {
        System.out.println("start of two()");
        Three three = new Three();
        three.three();
        System.out.println("end of two()");
    }
}
