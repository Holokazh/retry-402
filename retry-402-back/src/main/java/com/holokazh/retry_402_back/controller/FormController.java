package com.holokazh.retry_402_back.controller;

import com.holokazh.retry_402_back.model.Form;
import com.holokazh.retry_402_back.model.Level;
import com.holokazh.retry_402_back.service.FormService;
import com.holokazh.retry_402_back.service.LevelService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(path = "api/forms")
public class FormController {

    private final FormService formService;
    private final LevelService levelService;

    public FormController(FormService formService, LevelService levelService) {
        this.formService = formService;
        this.levelService = levelService;
    }

    @PostMapping(value = "{id}")
    public ResponseEntity<Form> addForm(@PathVariable Long id, @RequestBody Form form) {
        return ResponseEntity.ok(formService.addFormToLevel(id, form));
    }
}
