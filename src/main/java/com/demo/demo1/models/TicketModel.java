package com.demo.demo1.models;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tickets")
public class TicketModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String src;
    private String description;
    private boolean isBooked;

    public TicketModel() {}

    public TicketModel(int id, String src, String description, boolean isBooked) {
        this.id = id;
        this.src = src;
        this.description = description;
        this.isBooked = isBooked;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TicketModel that = (TicketModel) o;
        return id == that.id && isBooked == that.isBooked && Objects.equals(src, that.src) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, src, description, isBooked);
    }

    @Override
    public String toString() {
        return "TicketModel{id=" + id + ", src='" + src + "', description='" + description + "', isBooked=" + isBooked + '}';
    }
}
