package pl.sapiens.javarestsoap.controller;

import lombok.extern.slf4j.Slf4j;
import pl.sapiens.javarestsoap.entity.Reservation;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.util.List;

import static javax.ws.rs.core.Response.Status.NOT_FOUND;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Slf4j
@Path("/reservations")
public class RestReservationController {

    private static final Reservation theOnlyOne = new Reservation(1L,
            "Pastuszka",
            13,
            LocalDateTime.now(),
            LocalDateTime.now().plusHours(2),
            "Main center",
            "Near window!!!");

    @GET
    public Response getReservations() {
        var dummyReservations = List.of(
                theOnlyOne
        );

        log.info("getting all reservations");
        log.info("number of found reservations: [{}]", dummyReservations.size());
        return Response.ok(dummyReservations).build();
    }

    @GET
    @Path("/{id}")
    public Response findReservationById(@PathParam("id") Long reservationId) {
        log.info("trying to find reservation by id: [{}]", reservationId);

        // TODO: replace with integration with service
        Response result;
        if (reservationId == 1L) {
            result = Response.ok(theOnlyOne).build();
        } else {
            result = Response.status(NOT_FOUND).build();
        }

        return result;
    }

    @POST
    public Response createReservation(Reservation toCreate) {
        log.info("trying to create reservation: [{}]", toCreate);
        // TODO: use service, add validation
        URI location = null;
        try {
            location = new URI("/reservations/2");
        } catch (URISyntaxException e) {
            log.error("Cannot create location header");
        }

        return Response.created(location).build();
    }
}
