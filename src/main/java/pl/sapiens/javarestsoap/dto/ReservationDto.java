package pl.sapiens.javarestsoap.dto;

import javax.json.bind.annotation.JsonbProperty;
import java.time.LocalDateTime;

// JSON representation
public record ReservationDto(
        Long id,
        String surname,
        @JsonbProperty("table_number")
        Integer tableNumber,
        LocalDateTime startReservation,
        LocalDateTime endReservation,
        String address,
        String customerComments
) {
}
