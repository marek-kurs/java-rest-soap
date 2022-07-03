package pl.sapiens.javarestsoap.method_reference;

public record PersonRecord(
        String name,
        String surname,
        int age,
        Address address
) {
    // > 0 = is older
    // == 0 = the same age
    // < 0 = this person is younger
    int comparePersonAge(PersonRecord other) {
        return age - other.age;
    }
}

record Address(
        String country,
        String city,
        String street,
        String zipCode
) {
}
