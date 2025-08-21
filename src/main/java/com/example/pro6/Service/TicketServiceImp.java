package com.example.pro6.Service;

import com.example.pro6.DTO.request.TicketRequest;
import com.example.pro6.DTO.response.TicketMessageResponse;
import com.example.pro6.DTO.response.TicketResponse;
import com.example.pro6.Model.Ticket;
import com.example.pro6.Repository.TicketMessageRepository;
import com.example.pro6.Repository.TicketRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

@Service

public class TicketServiceImp implements TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private TicketMessageRepository messageRepository;

    @Override
    public Integer create(TicketRequest.CreatTicket ticketRequest) {
        try {
            Ticket newticket = new Ticket();
            String serial;
            do {
                serial = generateSerialNumber();
            } while (ticketRepository.existsBySerialNumber(serial));

            newticket.setSerialNumber(serial);
            newticket.setCreatedByCode(ticketRequest.getCreatedByCode());
            newticket.setBusiness(ticketRequest.getBusiness());
            newticket.setContact(ticketRequest.getContact());
            newticket.setStatus(ticketRequest.getStatus());
            newticket.setAssignedToCode(ticketRequest.getAssignedToCode());
            newticket.setPriority(ticketRequest.getPriority());
            newticket.setGiveTo(ticketRequest.getGiveTo());
            newticket.setName(ticketRequest.getName());
            newticket.setIsDeleted(false);
            newticket.setIsReception(false);
            newticket.setCreatedAt(new Timestamp(System.currentTimeMillis()));
            newticket.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
            ticketRepository.save(newticket);

            return 1;
        } catch (Exception e) {
            System.out.println("Error creating ticket: " + e.getMessage());
            return -1;
        }
    }

    private String generateSerialNumber() {
        int randomNum = new Random().nextInt(10_000_000);
        return String.format("%07d", randomNum);
    }

    public TicketResponse.AllWithMessages getTicketWithMessages(Long ticketId) {
        try {
            Ticket ticket = ticketRepository.findById(ticketId)
                    .orElseThrow(() -> new RuntimeException("Ticket not found"));

            TicketResponse.AllWithMessages ticketDto = new TicketResponse.AllWithMessages();
            BeanUtils.copyProperties(ticket, ticketDto);
            List<TicketMessageResponse.All> messages = messageRepository.findByTicketId(ticketId)
                    .stream()
                    .map(m -> {
                        TicketMessageResponse.All dto = new TicketMessageResponse.All();
                        BeanUtils.copyProperties(m, dto);
                        return dto;
                    })
                    .collect(Collectors.toList());
            ticketDto.setMessages(messages);
            return ticketDto;

        } catch (Exception e) {
            System.out.println("Error getting ticket with messages: " + e.getMessage());
            return null;
        }
    }

    public List<TicketResponse.All> getDetail(String business, String status, String priority, String giveTo, String serialNumber) {
        List<Ticket> tickets = ticketRepository.searchAll(business, status, priority, giveTo, serialNumber);
        List<TicketResponse.All> result = new ArrayList<>();
        try {
            for (Ticket ticket : tickets) {
                TicketResponse.All dto = new TicketResponse.All();

                dto.setName(ticket.getName());
                dto.setBusiness(ticket.getBusiness());
                dto.setContact(ticket.getContact());
                dto.setStatus(ticket.getStatus());
                dto.setPriority(ticket.getPriority());
                dto.setCreatedByCode(ticket.getCreatedByCode());
                dto.setAssignedToCode(ticket.getAssignedToCode());
                dto.setGiveTo(ticket.getGiveTo());
                dto.setCreatedAt(ticket.getCreatedAt());
                dto.setUpdatedAt(ticket.getUpdatedAt());
                dto.setSerialNumber(ticket.getSerialNumber());
                result.add(dto);
            }
            return result;
        } catch (Exception e) {
            System.out.println("Error getting ticket details: " + e.getMessage());
            return null;
        }
    }

    public Ticket updateIsReception(TicketRequest.UpdateReception request) {
        Ticket ticket = ticketRepository.findById(request.getId())
                .orElseThrow(() -> new RuntimeException("Ticket ID không tồn tại"));
        ticket.setIsReception(request.getIsReception());
        return ticketRepository.save(ticket);
    }

    @Override
    public TicketResponse.Detail getDetail(Long id) {
        Optional<Ticket> optionalTicket = ticketRepository.findByIdAndIsDeletedFalse(id);
        try {
            if (optionalTicket.isEmpty()) {
                throw new RuntimeException("Không tìm thấy ticket với ID: " + id);
            }

            Ticket ticket = optionalTicket.get();
            TicketResponse.Detail detail = new TicketResponse.Detail();
            detail.setId(ticket.getId());
            detail.setSerialNumber(ticket.getSerialNumber());
            detail.setName(ticket.getName());
            detail.setGiveTo(ticket.getGiveTo());
            detail.setContact(ticket.getContact());
            detail.setBusiness(ticket.getBusiness());

            return detail;
        } catch (Exception e) {
            System.out.println("Error get detail ticket: " + e.getMessage());
        }
        return null;
    }

    @Override
    public Ticket update(Ticket updated) {
        return ticketRepository.findById(updated.getId()).map(ticket -> {
            ticket.setName(updated.getName());
            ticket.setSerialNumber(updated.getSerialNumber());
            ticket.setGiveTo(updated.getGiveTo());
            ticket.setContact(updated.getContact());
            ticket.setBusiness(updated.getBusiness());
            ticket.setCreatedByCode(updated.getCreatedByCode());
            ticket.setStatus(updated.getStatus());
            ticket.setPriority(updated.getPriority());
            ticket.setAssignedToCode(updated.getAssignedToCode());
            ticket.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
            return ticketRepository.save(ticket);
        }).orElseThrow(() -> new RuntimeException("Ticket not found"));
    }

    public Boolean softDelete(Long id) {
        try {
            Optional<Ticket> ticketOpt = ticketRepository.findByIdAndIsDeletedFalse(id);
            if (ticketOpt.isPresent()) {
                Ticket ticket = ticketOpt.get();
                ticket.setIsDeleted(true);
                ticket.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
                ticketRepository.save(ticket);
                return true;
            }
            return false;
        } catch (Exception e) {
            System.err.println("Error soft deleting ticket: " + e.getMessage());
            return false;
        }
    }

    public List<Ticket> getPageStatus(Integer page, Integer size, String status) {
        try {
            Integer offset = (page - 1) * size;
            System.out.println("page" + offset);
            return ticketRepository.findByStatus(offset, size, status);
        } catch (Exception e) {
            System.err.println("Error getting tickets by status: " + e.getMessage());
            return null;
        }
    }
}











