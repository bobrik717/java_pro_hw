package com.demo.demo1.services;

import com.demo.demo1.dao.TicketDAO;
import com.demo.demo1.models.TicketModel;

import java.util.Arrays;
import java.util.List;

public class TicketService {
    private TicketDAO ticketDAO;
    public TicketService() {
        super();
        ticketDAO = new TicketDAO();
    }
    public String getList() {
        List<TicketModel> list = ticketDAO.list();
        String[] tickets = new String[list.size()];
        int count = 0;
        for (TicketModel item : list) {
            tickets[count] = item.toString();
            count++;
        }

        return Arrays.toString(tickets);
    }
    public String getUnbookedList() {
        List<TicketModel> list = ticketDAO.list();
        String[] tickets = new String[countUnbooked()];
        int count = 0;
        for (TicketModel item : list) {
            if (!item.isBooked()) {
                tickets[count] = item.toString();
                count++;
            }
        }

        return Arrays.toString(tickets);
    }

    public Boolean bookTicket(TicketModel request) {
        List<TicketModel> list = ticketDAO.list();
        for (TicketModel item : list) {
            if (!item.isBooked() && item.getId() == request.getId()) {
                item.setBooked(true);
                return true;
            }
        }
        return false;
    }

    protected int countUnbooked() {
        List<TicketModel> list = ticketDAO.list();
        int count = 0;
        for (TicketModel item : list) {
            if (!item.isBooked()) {
                count++;
            }
        }

        return count;
    }
}
