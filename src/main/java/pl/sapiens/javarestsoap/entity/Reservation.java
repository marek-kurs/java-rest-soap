package pl.sapiens.javarestsoap.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {

    Long id;

    String surname;

    Integer tableNumber;

    LocalDateTime startReservation;

    LocalDateTime endReservation;

    // TODO: migrate to Address class
    String address;

    String customerComments;
}
