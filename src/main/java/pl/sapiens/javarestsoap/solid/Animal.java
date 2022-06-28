package pl.sapiens.javarestsoap.solid;

public abstract class Animal {
    abstract public void eat();
}

class Dog extends Animal {

    @Override
    public void eat() {
        System.out.println("wow hou");
        System.out.println("mniam");
    }
}

class HorsePolski extends Animal {

    @Override
    public void eat() {
        System.out.println("ihaaaa");
    }
}