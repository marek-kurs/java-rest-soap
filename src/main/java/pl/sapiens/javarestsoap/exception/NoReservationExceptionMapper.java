package pl.sapiens.javarestsoap.exception;

import lombok.extern.slf4j.Slf4j;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Slf4j
@Provider
public class NoReservationExceptionMapper implements ExceptionMapper<NoReservationFoundExceptionBetterOne> {
    @Override
    public Response toResponse(NoReservationFoundExceptionBetterOne exception) {
        log.warn("handler for NoReservationFoundExceptionBetterOne is running", exception);
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}

// TODO: show example with server
// logging levels
// trace - least important
// debug
// info - standard level
// warning
// error - most important