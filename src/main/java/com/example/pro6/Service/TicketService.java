package com.example.pro6.Service;


import com.example.pro6.DTO.request.TicketRequest;
import com.example.pro6.DTO.response.TicketResponse;
import com.example.pro6.Model.Ticket;

import java.util.List;

public interface TicketService {

    Integer create(TicketRequest.CreatTicket ticketRequest);

    List<TicketResponse.All> getDetail(String business, String status, String priority, String giveTo,String serialNumber);

    TicketResponse.Detail getDetail(Long id);

    Ticket update(Ticket updated);

    Boolean softDelete(Long id);

    TicketResponse.AllWithMessages getTicketWithMessages(Long ticketId);

    List<Ticket> getPageStatus(Integer page, Integer size, String status);

    Ticket updateIsReception(TicketRequest.UpdateReception request);

}
