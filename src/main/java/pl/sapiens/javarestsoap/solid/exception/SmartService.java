package pl.sapiens.javarestsoap.solid.exception;

public class SmartService {

    Service service = new Service();

    public void makeSmartProcessing() {
        try {
            service.processData();
        } catch (NoFileExistException e) {
            System.out.println("handled!!!!");
        }
    }
}
