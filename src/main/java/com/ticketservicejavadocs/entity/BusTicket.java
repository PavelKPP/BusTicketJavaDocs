package com.ticketservicejavadocs.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class BusTicket {
    private long id;
    private String type;
    private LocalDateTime dateTime;
    private BigDecimal price;

    public BusTicket(long id, String type, LocalDateTime dateTime, BigDecimal price) {
        this.id = id;
        this.type = type;
        this.dateTime = dateTime;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        BusTicket busTicket = (BusTicket) object;

        if(!Objects.equals(id, busTicket.id)) return false;
        if(!Objects.equals(type, busTicket.type)) return false;
        if(!Objects.equals(dateTime, busTicket.dateTime)) return false;
        return !Objects.equals(price, busTicket.price);

    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, dateTime, price);
    }
}
