package com.holokazh.retry_402_back.controller;

import com.holokazh.retry_402_back.model.Form;
import com.holokazh.retry_402_back.service.FormService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(path = "api/forms")
public class FormController {

    private final FormService formService;

    public FormController(FormService formService) {
        this.formService = formService;
    }

    @PostMapping(value = "{id}")
    public ResponseEntity<Form> addForm(@PathVariable Long id, @RequestBody Form form) {
        return ResponseEntity.ok(formService.addFormToLevel(id, form));
    }
}
