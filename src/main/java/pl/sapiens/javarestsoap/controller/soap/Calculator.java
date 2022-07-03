package pl.sapiens.javarestsoap.controller.soap;

import javax.jws.WebService;

@WebService
public interface Calculator {

    int sum(int a, int b);
}
