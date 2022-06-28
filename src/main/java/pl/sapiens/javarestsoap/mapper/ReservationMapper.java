package pl.sapiens.javarestsoap.mapper;

import pl.sapiens.javarestsoap.dto.ReservationDto;
import pl.sapiens.javarestsoap.entity.Reservation;

public class ReservationMapper implements Mapper<Reservation, ReservationDto>{
    @Override
    public ReservationDto fromEntityToDto(Reservation entity) {
        return new ReservationDto(
                entity.getId(),
                entity.getSurname(),
                entity.getTableNumber(),
                entity.getStartReservation(),
                entity.getEndReservation(),
                entity.getAddress(),
                entity.getCustomerComments()
        );
    }

    @Override
    public Reservation fromDtoToEntity(ReservationDto reservationDto) {
        return Reservation.builder()
                .id(reservationDto.id())
                .surname(reservationDto.surname())
                .tableNumber(reservationDto.tableNumber())
                .startReservation(reservationDto.startReservation())
                .endReservation(reservationDto.endReservation())
                .address(reservationDto.address())
                .customerComments(reservationDto.customerComments())
                .build();
    }
}
