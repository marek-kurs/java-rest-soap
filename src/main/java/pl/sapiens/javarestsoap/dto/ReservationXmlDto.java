package pl.sapiens.javarestsoap.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor // required by JAXB
@AllArgsConstructor
@Builder
@XmlRootElement(name = "reservations")
@XmlAccessorType(XmlAccessType.FIELD)
public class ReservationXmlDto {
    Long id;

    @XmlElement(name = "nazwisko")
    String surname;

    @XmlElement(name = "twoj_stolik")
    Integer tableNumber;
    LocalDateTime startReservation;
    LocalDateTime endReservation;
    String address;
    String customerComments;
}
