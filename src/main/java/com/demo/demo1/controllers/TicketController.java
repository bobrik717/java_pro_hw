package com.demo.demo1.controllers;

import com.demo.demo1.models.TicketModel;
import com.demo.demo1.services.TicketService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tickets")
public class TicketController {
    private TicketService service;
    public TicketController() {
        super();
        service = new TicketService();
    }

    @GetMapping("")
    public ResponseEntity<String> index(@RequestHeader("my-custom-header") String customHeader, HttpServletRequest request) {
        System.out.println(customHeader);
        System.out.println(request.getHeader("my-custom-header"));
        return new ResponseEntity<>(service.getList(), HttpStatus.OK);
    }

    @GetMapping("/unbooked")
    public ResponseEntity<String>  unbooked() {
        return new ResponseEntity<>(service.getUnbookedList(), HttpStatus.OK);
    }

    @PostMapping("/book")
    public ResponseEntity<String>  book(@RequestBody TicketModel body) {
        if (service.bookTicket(body)) {
            return new ResponseEntity<>("success", HttpStatus.OK);
        }

        return new ResponseEntity<>("un success", HttpStatus.FORBIDDEN);
    }
}
