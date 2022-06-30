package pl.sapiens.javarestsoap.service;

import lombok.extern.slf4j.Slf4j;
import pl.sapiens.javarestsoap.dao.ReservationsDAO;
import pl.sapiens.javarestsoap.entity.Reservation;
import pl.sapiens.javarestsoap.exception.NoReservationFoundException;
import pl.sapiens.javarestsoap.exception.NoReservationFoundExceptionBetterOne;

import javax.inject.Inject;
import java.util.List;

@Slf4j
public class ReservationsService {

    @Inject
    private ReservationsDAO dataSource;

    public List<Reservation> getAllReservationsFromDataSource() {
        log.info("getting all reservations");
        var result = dataSource.findAllReservations();
        log.info("result: {}", result);
        return result;
    }

    public Reservation getReservationById(Long id) throws NoReservationFoundException {
        log.info("trying to find reservation by id: [{}]", id);
        var maybeReservation = dataSource.findReservationById(id);

        // get() - is safe only if element is present
//        if (maybeReservation.isPresent()) {
//            maybeReservation.get();
//        }

        return maybeReservation.orElseThrow(() -> new NoReservationFoundException("No reservation with id: " + id));
    }

    /**
     *
     * @param id
     * @return
     * @throws NoReservationFoundExceptionBetterOne
     */
    public Reservation getReservationByIdBetter(Long id) throws NoReservationFoundExceptionBetterOne {
        log.info("trying to find reservation by id: [{}]", id);
        var maybeReservation = dataSource.findReservationById(id);

        // get() - is safe only if element is present
//        if (maybeReservation.isPresent()) {
//            maybeReservation.get();
//        }

        return maybeReservation.orElseThrow(() -> new NoReservationFoundExceptionBetterOne("No reservation with id: " + id));
    }
}
