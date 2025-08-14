package com.example.pro6.Service;

import com.example.pro6.DTO.request.CustomFieldRequest;
import com.example.pro6.DTO.response.CustomFieldResponse;
import com.example.pro6.Model.CustomField;
import com.example.pro6.Repository.CustomFieldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class CustomFieldImp implements CustomFieldService {

    @Autowired
    private CustomFieldRepository fieldRepository;

    public CustomField create(CustomFieldRequest.CreateCustomField customFieldRequest) {
        try {
            CustomField newCustomField = new CustomField();
            newCustomField.setFieldType(customFieldRequest.getFieldType());
            newCustomField.setKey(customFieldRequest.getKey());
            newCustomField.setName(customFieldRequest.getName());
            newCustomField.setOptions(customFieldRequest.getOptions());
            newCustomField.setIsRequired(customFieldRequest.getIsRequired());
            newCustomField.setProjectId(customFieldRequest.getProjectId());
            newCustomField.setCreatedAt(new Timestamp(System.currentTimeMillis()));
            newCustomField.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
            return fieldRepository.save(newCustomField);
        } catch (Exception e) {
            throw new RuntimeException("Error creating custom field: " + e.getMessage());
        }
    }

    public CustomField update(Long id, CustomField updated) {
        return fieldRepository.findById(id).map(field -> {
            field.setName(updated.getName());
            field.setKey(updated.getKey());
            field.setFieldType(updated.getFieldType());
            field.setIsRequired(updated.getIsRequired());
            field.setOptions(updated.getOptions());
            field.setProjectId(updated.getProjectId());

            return fieldRepository.save(field);

        }).orElseThrow(() -> new RuntimeException("Custom field not found"));
    }

    public List<CustomFieldResponse.All> getAll() {
        return fieldRepository.findAll().stream().map(field -> {
            CustomFieldResponse.All response = new CustomFieldResponse.All();
            response.setId(field.getId());
            response.setName(field.getName());
            response.setKey(field.getKey());
            response.setFieldType(field.getFieldType());
            response.setIsRequired(field.getIsRequired());
            response.setOptions(field.getOptions());
            response.setProjectId(field.getProjectId());
            response.setCreatedAt(field.getCreatedAt());
            response.setUpdatedAt(field.getUpdatedAt());
            return response;
        }).toList();
    }

    public CustomFieldResponse.Detail getDetail(Long id) {
        return fieldRepository.findById(id).map(field -> {
            CustomFieldResponse.Detail detail = new CustomFieldResponse.Detail();
            detail.setId(field.getId());
            detail.setName(field.getName());
            detail.setKey(field.getKey());
            detail.setFieldType(field.getFieldType());
            detail.setIsRequired(field.getIsRequired());
            detail.setOptions(field.getOptions());
            detail.setProjectId(field.getProjectId());
            detail.setCreatedAt(field.getCreatedAt());
            detail.setUpdatedAt(field.getUpdatedAt());
            return detail;
        }).orElseThrow(() -> new RuntimeException("Custom field not found"));
    }
    public Boolean softDelete(Long id) {
        try {
            Optional<CustomField> customFieldOpt = fieldRepository.findByIdAndIsDeletedFalse(id);
            if (customFieldOpt.isPresent()) {
                CustomField customField = customFieldOpt.get();
                customField.setIsDeleted(true);
                customField.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
                fieldRepository.save(customField);
                return true;
            }
            return false;
        } catch (Exception e) {
            System.err.println("Error soft deleting ticket: " + e.getMessage());
            return false;
        }
    }
}