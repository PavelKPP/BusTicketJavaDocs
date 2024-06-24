package com.ticketservicejavadocs.service;

import com.ticketservicejavadocs.entity.BusTicket;

import java.math.BigDecimal;
import java.util.Map;

public class BusTicketService {


    /**
     * add ticket to the in-memory storage
     * @param ticketStorage is the ticket storage.
     * @param ticket the instance of the ticket to be stored
     * {@code ticketStorage} expected to be a Hashmap.
     */
    public void addTicket(Map<Long, BusTicket> ticketStorage, BusTicket ticket) {
        ticketStorage.put(ticket.getId(), ticket);
    }

    /**
     * removes ticket to the in-memory storage
     * @param ticketStorage is the ticket storage.
     * @param ticket the instance of the ticket to be stored.
     * {@code ticketStorage} expected to be a Hashmap.
     */
    public void removeTicket(Map<Long, BusTicket> ticketStorage, BusTicket ticket) {
        if(ticketStorage.containsKey(ticket.getId())){
            ticketStorage.remove(ticket.getId());
            System.out.println("ticket has been removed");
        } else {
            System.out.println("there is no ticket with this id");
        }
    }

    /**
     * add ticket to the in-memory storage
     * @param ticketStorage is the ticket storage.
     * @param id the id of ticket which expected to be found.
     * @throws com.endeca.portal.data.KeyNotFoundException if there is no ticket with needed id.
     * {@code ticketStorage} expected to be a Hashmap.
     */
    public void getTicketById(Map<Long, BusTicket> ticketStorage, long id) {
        BusTicket busTicket = ticketStorage.get(id);
        System.out.println(busTicket.toString());
    }


    /**
     * add ticket to the in-memory storage
     * @param ticketStorage is the ticket storage.
     * @param type the type of ticket which expected to be found.
     * @param priceFrom starting price range of the ticket which is expected to be found.
     * @param priceTo ending price range of the ticket which is expected to be found.
     * {@code ticketStorage} expected to be a Hashmap.
     * {@code priceFrom} expected to be > 0
     * {@code priceTo} should be in the range of BigDecimal
     */
    public void getTicketByTypeAndPrice(Map<Long, BusTicket> ticketStorage, String type,
                                        BigDecimal priceFrom, BigDecimal priceTo) {
        for(Map.Entry<Long, BusTicket> ticketEntry : ticketStorage.entrySet()) {
           BusTicket busTicket = ticketEntry.getValue();
            if((busTicket.getType() == type) &&
                    (busTicket.getPrice().compareTo(priceFrom) >= 0) &&
                    (busTicket.getPrice().compareTo(priceTo) <= 0)) {
                System.out.println(busTicket.toString());
            }
        }
    }


}
