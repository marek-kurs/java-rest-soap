package pl.sapiens.javarestsoap.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//import javax.json.bind.annotation.JsonbProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "Booking")
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

    @Column(name = "CREATION_TIMESTAMP")
    LocalDateTime creationTimestamp;

    @Column(name = "UPDATE_TIMESTAMP")
    LocalDateTime updateTimestamp;

    public Reservation(Long id, String surname, Integer tableNumber, LocalDateTime startReservation, LocalDateTime endReservation, String address, String customerComments) {
        this.id = id;
        this.surname = surname;
        this.tableNumber = tableNumber;
        this.startReservation = startReservation;
        this.endReservation = endReservation;
        this.address = address;
        this.customerComments = customerComments;
        // after adding new fields to class
        creationTimestamp = LocalDateTime.now();
        updateTimestamp = creationTimestamp;
    }

    // called once - during storing object inside db
    @PrePersist
    private void setCreationTimestamp() {
        LocalDateTime now = LocalDateTime.now();
        creationTimestamp = now;
        updateTimestamp = now;
    }

    // called each time entity is updated inside db
    @PreUpdate
    private void setUpdateTimestamp() {
        updateTimestamp = LocalDateTime.now();
    }
}
