//package pl.sapiens.javarestsoap;
//
//import pl.sapiens.javarestsoap.controller.RestReservationController;
//
//import javax.ws.rs.core.Response;
//
//// under the hood :)
//public class TomEEMain {
//    RestReservationController controller = new RestReservationController();
//
//    public Response getAll(Long id) {
//        try {
//            var result = controller.findReservationById(id);
//            return Response.ok(result).build();
//        } catch (Exception e) {
//            return Response.status(500).build();
//        }
//    }
//}
