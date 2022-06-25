package pl.sapiens.javarestsoap.controller;

import lombok.extern.slf4j.Slf4j;
import pl.sapiens.javarestsoap.entity.Reservation;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Path("/reservations")
public class RestReservationController {

    @GET
    public Response getReservations() {
        var dummyReservations = List.of(
                new Reservation(1L,
                        "Pastuszka",
                        13,
                        LocalDateTime.now(),
                        LocalDateTime.now().plusHours(2),
                        "Main center",
                        "Near window!!!")
        );

        log.info("getting all reservations");
        log.info("number of found reservations: [{}]", dummyReservations.size());
        return Response.ok(dummyReservations).build();
    }
}
