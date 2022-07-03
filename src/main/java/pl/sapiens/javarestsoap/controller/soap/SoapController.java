package pl.sapiens.javarestsoap.controller.soap;

import javax.jws.WebService;
// wsdl - info about all operations
// we're using xml to ask about service
// put in postman this xml in body and use post method
//<soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/">
//<soap:Body>
//<ns1:sum xmlns:ns1="http://soap.controller.javarestsoap.sapiens.pl/">
//<arg0>4</arg0>
//<arg1>6</arg1>
//</ns1:sum>
//</soap:Body>
//</soap:Envelope>

// you should receive this response:
//<soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/">
//<soap:Body>
//<ns2:sumResponse xmlns:ns2="http://soap.controller.javarestsoap.sapiens.pl/">
//<return>10</return>
//</ns2:sumResponse>
//</soap:Body>
//</soap:Envelope>
// wsdl is available at url: http://localhost:8080/java-rest-soap-1.0-SNAPSHOT/CalculatorService?wsdl=Calculator.wsdl
@WebService(
        endpointInterface = "pl.sapiens.javarestsoap.controller.soap.Calculator", // we don't need @WebMethod thanks to this
        serviceName = "CalculatorService", // used to expose endpoint on the web
        targetNamespace = "http://soap.controller.javarestsoap.sapiens.pl/wsdl"
)
public class SoapController implements Calculator {

    @Override
    public int sum(int a, int b) {
        return a + b;
    }
}
