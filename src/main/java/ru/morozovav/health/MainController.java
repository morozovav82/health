package ru.morozovav.health;

import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;

@RestController
public class MainController {

    @GetMapping("health")
    public HealthResponse health() throws UnknownHostException {
        System.out.println(LocalDateTime.now() + " Start health. Host: " + InetAddress.getLocalHost().getHostName());
        return new HealthResponse("OK");
    }

    @GetMapping("livenessProbe")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void livenessProbe() throws UnknownHostException {
        System.out.println(LocalDateTime.now() + " Start livenessProbe. Host: " + InetAddress.getLocalHost().getHostName());
    }

    @GetMapping("readinessProbe")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void readinessProbe() throws UnknownHostException {
        System.out.println(LocalDateTime.now() + " Start readinessProbe. Host: " + InetAddress.getLocalHost().getHostName());
    }
}
