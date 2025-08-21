package com.example.pro6.Controller;

import com.example.pro6.DTO.request.TicketRequest;
import com.example.pro6.DTO.response.TicketResponse;
import com.example.pro6.Library.ErrorCode;
import com.example.pro6.Model.Ticket;
import com.example.pro6.Resp.RespBean;
import com.example.pro6.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping("/create")
    public RespBean<Integer> create(@RequestBody TicketRequest.CreatTicket ticket) {
        try {
            return RespBean.ok(ErrorCode.ERROR_0_STR, ticketService.create(ticket));
        } catch (Exception e) {
            return RespBean.error(ErrorCode.ERROR_500, ErrorCode.ERROR_500_STR, -1);
        }
    }

    @GetMapping("/all")
    public RespBean<TicketResponse.All> getDetail(@RequestParam(required = false) String business,
                                                  @RequestParam(required = false) String status,
                                                  @RequestParam(required = false) String priority,
                                                  @RequestParam(required = false) String giveTo,
                                                  @RequestParam(required = false) String serialNumber){
        try {
            return RespBean.ok(ErrorCode.ERROR_0_STR, ticketService.getDetail(business, status, priority, giveTo, serialNumber));
        } catch (Exception e) {
            System.out.println("Error in getDetail: " + e);
            return RespBean.error(ErrorCode.ERROR_500, ErrorCode.ERROR_500_STR, null);
        }
    }

    @GetMapping("/detail")
    public RespBean<TicketResponse.Detail> getDetail(@RequestParam Long id) {
        try {
            return RespBean.ok(ErrorCode.ERROR_0_STR, ticketService.getDetail(id));
        } catch (Exception e) {
            return RespBean.error(ErrorCode.ERROR_500, ErrorCode.ERROR_500_STR, -1);
        }
    }

    @PostMapping("/update")
    public RespBean<Ticket> update(@RequestBody Ticket ticket) {
        try {
            return RespBean.ok(ErrorCode.ERROR_0_STR, ticketService.update(ticket));
        } catch (Exception e) {
            return RespBean.error(ErrorCode.ERROR_500, ErrorCode.ERROR_500_STR, -1);
        }
    }

    @DeleteMapping("/delete")
    public RespBean<Boolean> delete(@RequestParam Long id) {
        try {
            return RespBean.ok(ErrorCode.ERROR_0_STR, ticketService.softDelete(id));
        } catch (Exception e) {
            System.out.println("Error in delete: " + e.getMessage());
            return RespBean.error(ErrorCode.ERROR_500, ErrorCode.ERROR_500_STR, false);
        }
    }

    @GetMapping("/detail-with-messages")
    public RespBean<TicketResponse.All> getTicketWithMessages(@RequestParam Long ticketId) {
        try {
            return RespBean.ok(ErrorCode.ERROR_0_STR, ticketService.getTicketWithMessages(ticketId));
        } catch (Exception e) {
            return RespBean.error(ErrorCode.ERROR_500, ErrorCode.ERROR_500_STR, -1);
        }
    }

    @GetMapping("/by-status")
    public RespBean<Ticket> getByStatus(@RequestParam (required = false) Integer page , @RequestParam (required = false) Integer size, @RequestParam String status) {
        try {
            return RespBean.ok(ErrorCode.ERROR_0_STR, ticketService.getPageStatus(page, size, status));
        } catch (Exception e) {
            return RespBean.error(ErrorCode.ERROR_500, ErrorCode.ERROR_500_STR, null);
        }
    }

    @PostMapping("/update-reception")
    public RespBean<Ticket> updateReception(@RequestBody TicketRequest.UpdateReception request) {
        try {
            ticketService.updateIsReception(request);
            return RespBean.ok(ErrorCode.ERROR_0_STR, true);
        } catch (Exception e) {
            System.out.println("Error in update reception: " + e.getMessage());
            return RespBean.error(ErrorCode.ERROR_500, ErrorCode.ERROR_500_STR, false);
        }
    }

}


