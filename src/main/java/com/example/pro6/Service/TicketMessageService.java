package com.example.pro6.Service;

import com.example.pro6.DTO.request.TicketMessageRequest;
import com.example.pro6.DTO.response.TicketMessageResponse;
import com.example.pro6.Model.TicketMessage;


import java.util.List;
import java.util.Optional;


public interface TicketMessageService {

    List<TicketMessageResponse.Detail> getAll(String status, String priority, String giveTo,String typeAccident,String CCs );

    Long create(TicketMessageRequest.CreatTicketMessage ticketMessageRequest);

    boolean checkExistTicketId(Long ticketId);

    boolean checkExistTicketMessage(Long ticketId);

    Optional<TicketMessage> getMessagesByTicketId(Long ticketId);

    TicketMessageResponse.All getDetail(Long id);

    TicketMessage update( TicketMessage updatedData);

    TicketMessage delete(Long id);

    Long createCustomer(TicketMessageRequest.CreatCustomer customerRequest);

    Long createAccident(TicketMessageRequest.CreateAccident accidentRequest);

    Long createComplaints(TicketMessageRequest.CreateComplaints complaintsRequest);

    Long createProduct(TicketMessageRequest.CreateProduct productRequest);

    Long createOther(TicketMessageRequest.CreateOther otherRequest);

    TicketMessageResponse.CustomerDetail getCustomerDetail(Long id);

    TicketMessageResponse.AccidentDetail getAccidentDetail(Long id);

    TicketMessageResponse.ComplaintsDetail getComplaintsDetail(Long id);

    TicketMessageResponse.ProductDetail getProductDetail(Long id);

    TicketMessageResponse.OtherDetail getOtherDetail(Long id);

    TicketMessageRequest.CreatCustomer updateCustomer(TicketMessageRequest.CreatCustomer customerRequest);

    TicketMessageRequest.CreateAccident updateAccident(TicketMessageRequest.CreateAccident accidentRequest);

    TicketMessageRequest.CreateComplaints updateComplaints(TicketMessageRequest.CreateComplaints complaintsRequest);

    TicketMessageRequest.CreateProduct updateProduct(TicketMessageRequest.CreateProduct productRequest);

    TicketMessageRequest.CreateOther updateOther(TicketMessageRequest.CreateOther otherRequest);
}


