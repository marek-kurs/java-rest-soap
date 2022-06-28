package pl.sapiens.javarestsoap.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//import javax.json.bind.annotation.JsonbProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "RESERVATIONS")
public class Reservation {

    @Id
    Long id;

    String surname;

    @Column(name = "TABLE_NUMBER")
//    @JsonbProperty("numer_stolika")
    Integer tableNumber;

    @Column(name = "START_RESERVATION")
    LocalDateTime startReservation;

    @Column(name = "END_RESERVATION")
    LocalDateTime endReservation;

    // TODO: migrate to Address class
    String address;

    @Column(name = "CUSTOMER_COMMENTS")
    String customerComments;
}
