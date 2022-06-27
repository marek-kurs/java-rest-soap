package pl.sapiens.javarestsoap.dao;

import pl.sapiens.javarestsoap.entity.Reservation;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ReservationsDAO {

    private List<Reservation> reservations = new ArrayList<>();

    public ReservationsDAO() {
        reservations.add(new Reservation(1L,
                "Pastuszka",
                13,
                LocalDateTime.now(),
                LocalDateTime.now().plusHours(2),
                "Main center",
                "Near window!!!"));
    }

    public List<Reservation> findAllReservations() {
        return reservations;
    }
}
