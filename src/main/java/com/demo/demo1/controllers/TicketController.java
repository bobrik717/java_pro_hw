package com.demo.demo1.controllers;

import com.demo.demo1.models.TicketModel;
import com.demo.demo1.services.TicketService;
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
    public String index() {
        return service.getList();
    }

    @GetMapping("/unbooked")
    public String unbooked() {
        return service.getUnbookedList();
    }

    @PostMapping("/book")
    public String book(@RequestBody TicketModel body) {
        if (service.bookTicket(body)) {
            return "success";
        }

        return "un success";
    }
}
