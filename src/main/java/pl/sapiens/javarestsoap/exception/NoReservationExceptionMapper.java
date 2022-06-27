package pl.sapiens.javarestsoap.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class NoReservationExceptionMapper implements ExceptionMapper<NoReservationFoundExceptionBetterOne> {
    @Override
    public Response toResponse(NoReservationFoundExceptionBetterOne exception) {
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}
