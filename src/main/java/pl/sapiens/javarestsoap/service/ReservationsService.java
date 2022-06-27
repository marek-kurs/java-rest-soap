package pl.sapiens.javarestsoap.service;

import lombok.extern.slf4j.Slf4j;
import pl.sapiens.javarestsoap.dao.ReservationsDAO;
import pl.sapiens.javarestsoap.entity.Reservation;

import java.util.List;

@Slf4j
public class ReservationsService {

    private final ReservationsDAO dataSource = new ReservationsDAO();

    public List<Reservation> getAllReservationsFromDataSource() {
        log.info("getting all reservations");
        var result = dataSource.findAllReservations();
        log.info("result: {}", result);
        return result;
    }
}
