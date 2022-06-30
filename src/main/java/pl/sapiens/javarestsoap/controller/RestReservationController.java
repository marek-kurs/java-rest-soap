package pl.sapiens.javarestsoap.controller;

import lombok.extern.slf4j.Slf4j;
//import org.slf4j.Logger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.sapiens.javarestsoap.dto.ReservationDto;
import pl.sapiens.javarestsoap.dto.ReservationXmlDto;
import pl.sapiens.javarestsoap.entity.Reservation;
import pl.sapiens.javarestsoap.exception.NoReservationFoundException;
import pl.sapiens.javarestsoap.mapper.ReservationMapper;
import pl.sapiens.javarestsoap.service.ReservationsService;

import javax.inject.Inject;
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

    // below line is the same as @Slf4j
//        private static final Logger log = LoggerFactory.getLogger(RestReservationController.class);
    private static final Reservation theOnlyOne = new Reservation(1L,
            "Pastuszka",
            13,
            LocalDateTime.now(),
            LocalDateTime.now().plusHours(2),
            "Main center",
            "Near window!!!");

    @Inject
    private ReservationsService businessLogic;
    private final ReservationMapper reservationMapper = new ReservationMapper();

    @GET
    public Response getReservations() {
        log.info("getting all reservations");
        var reservations = businessLogic.getAllReservationsFromDataSource();
        var reservationsDtos = reservations.stream()
                .map(reservation -> reservationMapper.fromEntityToDto(reservation))
                .toList();
        return Response.ok(reservationsDtos).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Response getReservationsAsXml() {
        ReservationXmlDto result = ReservationXmlDto.builder()
                .id(1L)
                .surname("maniek")
                .tableNumber(14)
                .startReservation(LocalDateTime.now())
                .build();

        return Response.ok(result).build();
    }
    // old way - using checked exceptions - really old - don't do it:)
//    @GET
//    @Path("/{id}")
//    public Response findReservationById(@PathParam("id") Long reservationId) {
//        log.info("trying to find reservation by id: [{}]", reservationId);
//
//        Response result;
//        try {
//            Reservation found = businessLogic.getReservationById(reservationId);
//            result = Response.ok(found).build();
//        } catch (NoReservationFoundException e) {
//            result = Response.status(NOT_FOUND).build();
//        }
//
//        return result;
//    }

    @GET
    @Path("/{id}")
    public Response findReservationById(@PathParam("id") Long reservationId) {
        log.info("trying to find reservation by id: [{}]", reservationId);

        Response result;
        Reservation found = businessLogic.getReservationByIdBetter(reservationId);
        result = Response.ok(reservationMapper.fromEntityToDto(found)).build();

        return result;
    }

    @POST
    public Response createReservation(ReservationDto toCreate) {
        log.info("trying to create reservation: [{}]", toCreate);
        var entityToSave = reservationMapper.fromDtoToEntity(toCreate);
        var entityAfterSaving = businessLogic.createNewReservation(entityToSave);
        URI location = null;
        try {
            location = new URI("/reservations/" + entityAfterSaving.getId());
        } catch (URISyntaxException e) {
            log.error("Cannot create location header");
        }

        return Response.created(location).build();
    }
}
