package pl.sapiens.javarestsoap.solid;

public class Feeder {
    // follows open-close principle :)
    void nakarm(Animal animal) {
        animal.eat();
    }

    void nakarm(Dog dog) {

    }

    void nakarm(HorsePolski kóń) {

    }
}
