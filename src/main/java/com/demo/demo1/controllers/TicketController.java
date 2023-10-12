package com.demo.demo1.controllers;

import com.demo.demo1.models.TicketModel;
import com.demo.demo1.repository.TicketRepository;
import com.demo.demo1.services.TicketService;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tickets")
public class TicketController {
    @Autowired
    private TicketService service;
    private final TicketRepository ticketsRepository;

    public TicketController(TicketRepository ticketsRepository) {
        this.ticketsRepository = ticketsRepository;
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
    public ResponseEntity<String>  book(@RequestBody @Validated TicketModel body) {
        if (service.bookTicket(body)) {
            return new ResponseEntity<>("success", HttpStatus.OK);
        }

        return new ResponseEntity<>("un success", HttpStatus.FORBIDDEN);
    }

    @GetMapping("/all")
    public Iterable<TicketModel> findAllEmployees() {
        return this.ticketsRepository.findAll();
    }

    @PostConstruct
    void fillDb() {
        System.out.println("tickets controller created");
    }
}
