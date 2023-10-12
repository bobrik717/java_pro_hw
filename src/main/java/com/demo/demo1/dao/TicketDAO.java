package com.demo.demo1.dao;

import com.demo.demo1.models.TicketModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TicketDAO {
    private List<TicketModel> db = new ArrayList<>();
    public TicketDAO() {
        super();
        for (int i = 1; i <= 10; i++) {
            db.add(new TicketModel(i, "SRC" + i, "desc " + i, i % 2 == 0));
        }
    }

    public List<TicketModel> list() {
        return db;
    }
}
