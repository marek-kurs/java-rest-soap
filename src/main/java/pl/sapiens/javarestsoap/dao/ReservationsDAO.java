package pl.sapiens.javarestsoap.dao;

import lombok.extern.slf4j.Slf4j;
import pl.sapiens.javarestsoap.entity.Reservation;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
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

    public Reservation saveReservation(Reservation entityToSave) {
        if (entityToSave.getId() == null) {
            log.info("creation of new entity: [{}]", entityToSave);
            entityManager.persist(entityToSave);
        } else {
            log.info("updating of entity: [{}]", entityToSave);
            entityManager.merge(entityToSave);
        }

        return entityToSave;
    }
}
