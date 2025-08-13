package com.example.pro6.Service;

import com.example.pro6.DTO.request.CustomFieldRequest;
import com.example.pro6.DTO.response.CustomFieldResponse;
import com.example.pro6.Model.CustomField;

import java.util.List;


public interface CustomFieldService {

    CustomField create(CustomFieldRequest.CreateCustomField customFieldRequest);

    CustomField update(Long id, CustomField updated);

    CustomFieldResponse.Detail getDetail(Long id);

    Boolean softDelete(Long id);

    List<CustomFieldResponse.All> getAll();

}