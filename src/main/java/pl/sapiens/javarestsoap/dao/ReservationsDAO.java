package pl.sapiens.javarestsoap.dao;

import pl.sapiens.javarestsoap.entity.Reservation;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ReservationsDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public ReservationsDAO() {
    }

    public List<Reservation> findAllReservations() {
        String jpqlQuery = """
            select b
            from Booking b
        """;

        return entityManager.createQuery(jpqlQuery, Reservation.class).getResultList();
    }

    public Optional<Reservation> findReservationById(Long id) {
        return Optional.ofNullable(entityManager.find(Reservation.class, id));
    }
}
