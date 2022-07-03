package pl.sapiens.javarestsoap.service;

import lombok.extern.slf4j.Slf4j;
import pl.sapiens.javarestsoap.dao.ReservationsDAO;
import pl.sapiens.javarestsoap.entity.Reservation;
import pl.sapiens.javarestsoap.exception.NoReservationFoundException;
import pl.sapiens.javarestsoap.exception.NoReservationFoundExceptionBetterOne;

import javax.inject.Inject;
import javax.transaction.Transactional;
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

    // hibernate - pseudocode
    // var session = getSession()
    // session.beginTransaction();
    // do something - 1st insert
    //
    // session.commitTransaction();
    // session.close()
    //
    @Transactional // whole method is atomic - all or nothing
    public Reservation createNewReservation(Reservation entityToSave) {
        log.info("entity before saving to dao: [{}]", entityToSave);

        var result = dataSource.saveReservation(entityToSave);
        log.info("after saving: [{}]", result);
        return result;
    }
}
