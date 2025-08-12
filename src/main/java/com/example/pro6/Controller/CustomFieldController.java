package com.example.pro6.Controller;


import com.example.pro6.DTO.request.CustomFieldRequest;
import com.example.pro6.DTO.response.CustomFieldResponse;
import com.example.pro6.Library.ErrorCode;
import com.example.pro6.Model.CustomField;
import com.example.pro6.Resp.RespBean;
import com.example.pro6.Service.CustomFieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customFields")
public class CustomFieldController {

    @Autowired
    private CustomFieldService fieldService;

    @PostMapping("/create")
    public RespBean<CustomField> create(@RequestBody CustomFieldRequest.CreateCustomField customField) {
        try {
            return RespBean.ok(ErrorCode.ERROR_0_STR, fieldService.create(customField));
        } catch (Exception e) {
            return RespBean.error(ErrorCode.ERROR_500, ErrorCode.ERROR_500_STR, -1);
        }
    }

    @PostMapping("/update")
    public RespBean<CustomField> update(@RequestBody CustomField updated) {
        try {
            return RespBean.ok(ErrorCode.ERROR_0_STR, fieldService.update(updated.getId(), updated));
        } catch (Exception e) {
            return RespBean.error(ErrorCode.ERROR_500, ErrorCode.ERROR_500_STR, -1);
        }
    }
    @GetMapping("/getDetail")
    public RespBean<CustomField> getDetail(@RequestParam Long id) {
        try {
            return RespBean.ok(ErrorCode.ERROR_0_STR, fieldService.getDetail(id));
        } catch (Exception e) {
            return RespBean.error(ErrorCode.ERROR_404, ErrorCode.ERROR_404_STR, -1);
        }
    }
    @DeleteMapping("/delete")
    public RespBean<CustomField> delete(@RequestParam Long id) {
        try {
            return RespBean.ok(ErrorCode.ERROR_0_STR, fieldService.softDelete(id));
        } catch (Exception e) {
            return RespBean.error(ErrorCode.ERROR_500, ErrorCode.ERROR_500_STR, -1);
        }
    }

    @GetMapping("/getAll")
    public RespBean<List<CustomFieldResponse.All>> getAll() {
        try {
            return RespBean.ok(ErrorCode.ERROR_0_STR, fieldService.getAll());
        } catch (Exception e) {
            return RespBean.error(ErrorCode.ERROR_500, ErrorCode.ERROR_500_STR, -1);
        }
    }


}
