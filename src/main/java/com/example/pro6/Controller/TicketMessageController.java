package com.example.pro6.Controller;


import com.example.pro6.DTO.request.TicketMessageRequest;
import com.example.pro6.DTO.response.TicketMessageResponse;
import com.example.pro6.Library.ErrorCode;
import com.example.pro6.Model.TicketMessage;
import com.example.pro6.Resp.RespBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.pro6.Service.TicketMessageService;


@RestController
@RequestMapping("/api/ticket-messages")
public class TicketMessageController {

    @Autowired
    private TicketMessageService ticketMessageService;


    @PostMapping("/create")
    public RespBean<Long> createTicketMessage(@RequestBody TicketMessageRequest.CreatTicketMessage ticketMessage) {
        try {
            boolean isExist = ticketMessageService.checkExistTicketId(ticketMessage.getTicketId());
            if (!isExist) {
                return RespBean.error(ErrorCode.ERROR_404, ErrorCode.ERROR_404_STR, -1);
            }
            Long newticketMessage = ticketMessageService.create(ticketMessage);
            return RespBean.ok(ErrorCode.ERROR_0_STR, newticketMessage);
        } catch (Exception e) {
            return RespBean.error(ErrorCode.ERROR_500, ErrorCode.ERROR_500_STR, -1);
        }
    }

    @GetMapping("/all")
    public RespBean<TicketMessageResponse.Detail> getAllTicketMessages(@RequestParam (required = false) String status,
                                                                       @RequestParam (required = false) String priority,
                                                                       @RequestParam (required = false) String giveTo,
                                                                       @RequestParam (required = false) String typeAccident,
                                                                       @RequestParam (required = false) String CCs) {
        try {
            return RespBean.ok(ErrorCode.ERROR_0_STR, ticketMessageService.getAll(status, priority, giveTo, typeAccident, CCs));
        } catch (Exception e) {
            return RespBean.error(ErrorCode.ERROR_500, ErrorCode.ERROR_500_STR, -1);
        }
    }

    @GetMapping("/by-ticket-id")
    public RespBean<Long> getMessagesByTicketId(@RequestParam Long ticketId) {
        try {
            boolean isExist = ticketMessageService.checkExistTicketId(ticketId);
            if (!isExist) {
                return RespBean.error(ErrorCode.ERROR_404, ErrorCode.ERROR_404_STR, -1);
            }
            return RespBean.ok(ErrorCode.ERROR_0_STR, ticketMessageService.getMessagesByTicketId(ticketId));
        } catch (Exception e) {
            return RespBean.error(ErrorCode.ERROR_500, ErrorCode.ERROR_500_STR, -1);
        }
    }

    @GetMapping("/get-detail")
    public RespBean<TicketMessageResponse.All> getDetail(@RequestParam Long id) {
        try {
            boolean isExist = ticketMessageService.checkExistTicketMessage(id);
            if (!isExist) {
                return RespBean.error(ErrorCode.ERROR_404, ErrorCode.ERROR_404_STR, -1);
            }
            return RespBean.ok(ErrorCode.ERROR_0_STR, ticketMessageService.getDetail(id));
        } catch (Exception e) {
            return RespBean.error(ErrorCode.ERROR_500, ErrorCode.ERROR_500_STR, -1);
        }
    }

    @PostMapping("/update")
    public RespBean<TicketMessage> update(@RequestBody TicketMessage ticketMessage) {
        try {
            TicketMessage updated = ticketMessageService.update(ticketMessage);
            return RespBean.ok(ErrorCode.ERROR_0_STR, updated);
        } catch (Exception e) {
            return RespBean.error(ErrorCode.ERROR_500, ErrorCode.ERROR_500_STR, null);
        }
    }

    @DeleteMapping("/delete")
    public RespBean<TicketMessage> delete(@RequestParam Long id) {
        try {
            boolean isExist = ticketMessageService.checkExistTicketMessage(id);
            if (!isExist) {
                return RespBean.error(ErrorCode.ERROR_404, ErrorCode.ERROR_404_STR, -1);
            }
            TicketMessage deleted = ticketMessageService.delete(id);
            return RespBean.ok(ErrorCode.ERROR_0_STR, deleted);
        } catch (Exception e) {
            return RespBean.error(ErrorCode.ERROR_500, ErrorCode.ERROR_500_STR, null);
        }
    }

    @PostMapping("/create-customer")
    public RespBean<Long> createCustomer(@RequestBody TicketMessageRequest.CreatCustomer customerRequest){
        try {
            Long newCustomerId = ticketMessageService.createCustomer(customerRequest);
            return RespBean.ok(ErrorCode.ERROR_0_STR, newCustomerId);
        } catch (Exception e) {
            return RespBean.error(ErrorCode.ERROR_500, ErrorCode.ERROR_500_STR, -1);
        }
    }

    @PostMapping("/create-accident")
    public RespBean<Long> createAccident(@RequestBody TicketMessageRequest.CreateAccident accidentRequest) {
        try {

            Long newAccidentId = ticketMessageService.createAccident(accidentRequest);
            return RespBean.ok(ErrorCode.ERROR_0_STR, newAccidentId);
        } catch (Exception e) {
            return RespBean.error(ErrorCode.ERROR_500, ErrorCode.ERROR_500_STR, -1);
        }
    }

    @PostMapping("/create-complaints")
    public RespBean<Long> createComplaints(@RequestBody TicketMessageRequest.CreateComplaints complaintsRequest) {
        try {
            Long newComplaintsId = ticketMessageService.createComplaints(complaintsRequest);
            return RespBean.ok(ErrorCode.ERROR_0_STR, newComplaintsId);
        } catch (Exception e) {
            return RespBean.error(ErrorCode.ERROR_500, ErrorCode.ERROR_500_STR, -1);
        }
    }

    @PostMapping("/create-product")
    public RespBean<Long> createProduct(@RequestBody TicketMessageRequest.CreateProduct productRequest) {
        try {
            Long newProductId = ticketMessageService.createProduct(productRequest);
            return RespBean.ok(ErrorCode.ERROR_0_STR, newProductId);
        } catch (Exception e) {
            return RespBean.error(ErrorCode.ERROR_500, ErrorCode.ERROR_500_STR, -1);
        }
    }

    @PostMapping("/create-other")
    public RespBean<Long> createOther(@RequestBody TicketMessageRequest.CreateOther otherRequest) {
        try {
            Long newOtherId = ticketMessageService.createOther(otherRequest);
            return RespBean.ok(ErrorCode.ERROR_0_STR, newOtherId);
        } catch (Exception e) {
            return RespBean.error(ErrorCode.ERROR_500, ErrorCode.ERROR_500_STR, -1);
        }
    }

    @GetMapping("/get-customer")
    public RespBean<TicketMessageResponse.CustomerDetail> getCustomer(@RequestParam Long id) {
        try {
            boolean isExist = ticketMessageService.checkExistTicketMessage(id);
            if (!isExist) {
                return RespBean.error(ErrorCode.ERROR_404, ErrorCode.ERROR_404_STR, -1);
            }
            return RespBean.ok(ErrorCode.ERROR_0_STR, ticketMessageService.getCustomerDetail(id));
        } catch (Exception e) {
            return RespBean.error(ErrorCode.ERROR_500, ErrorCode.ERROR_500_STR, -1);
        }
    }

    @GetMapping("/get-accident")
    public RespBean<TicketMessageResponse.AccidentDetail> getAccident(@RequestParam Long id) {
        try {
            boolean isExist = ticketMessageService.checkExistTicketMessage(id);
            if (!isExist) {
                return RespBean.error(ErrorCode.ERROR_404, ErrorCode.ERROR_404_STR, -1);
            }
            return RespBean.ok(ErrorCode.ERROR_0_STR, ticketMessageService.getAccidentDetail(id));
        } catch (Exception e) {
            return RespBean.error(ErrorCode.ERROR_500, ErrorCode.ERROR_500_STR, -1);
        }
    }

    @GetMapping("/get-complaints")
    public RespBean<TicketMessageResponse.ComplaintsDetail> getComplaints(@RequestParam Long id) {
        try {
            boolean isExist = ticketMessageService.checkExistTicketMessage(id);
            if (!isExist) {
                return RespBean.error(ErrorCode.ERROR_404, ErrorCode.ERROR_404_STR, -1);
            }
            return RespBean.ok(ErrorCode.ERROR_0_STR, ticketMessageService.getComplaintsDetail(id));
        } catch (Exception e) {
            return RespBean.error(ErrorCode.ERROR_500, ErrorCode.ERROR_500_STR, -1);
        }
    }

    @GetMapping("/get-product")
    public RespBean<TicketMessageResponse.ProductDetail> getProduct(@RequestParam Long id) {
        try {
            boolean isExist = ticketMessageService.checkExistTicketMessage(id);
            if (!isExist) {
                return RespBean.error(ErrorCode.ERROR_404, ErrorCode.ERROR_404_STR, -1);
            }
            return RespBean.ok(ErrorCode.ERROR_0_STR, ticketMessageService.getProductDetail(id));
        } catch (Exception e) {
            return RespBean.error(ErrorCode.ERROR_500, ErrorCode.ERROR_500_STR, -1);
        }
    }

    @GetMapping("/get-other")
    public RespBean<TicketMessageResponse.OtherDetail> getOther(@RequestParam Long id) {
        try {
            boolean isExist = ticketMessageService.checkExistTicketMessage(id);
            if (!isExist) {
                return RespBean.error(ErrorCode.ERROR_404, ErrorCode.ERROR_404_STR, -1);
            }
            return RespBean.ok(ErrorCode.ERROR_0_STR, ticketMessageService.getOtherDetail(id));
        } catch (Exception e) {
            return RespBean.error(ErrorCode.ERROR_500, ErrorCode.ERROR_500_STR, -1);
        }
    }
}