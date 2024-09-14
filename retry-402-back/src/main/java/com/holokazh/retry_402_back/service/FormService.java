package com.holokazh.retry_402_back.service;

import com.holokazh.retry_402_back.model.Form;
import com.holokazh.retry_402_back.model.Level;
import com.holokazh.retry_402_back.repository.FormRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormService {

    private final FormRepository formRepository;
    private final LevelService levelService;

    public FormService(FormRepository formRepository, LevelService levelService) {
        this.formRepository = formRepository;
        this.levelService = levelService;
    }

    private List<Form> findAll() {
        return formRepository.findAll();
    }

    private Form findById(Long id) {
        return formRepository.findById(id);
    }

    public Form addFormToLevel(Long levelID,Form form) {
        Level level = levelService.findById(levelID);
        level.addForm(form);
        return formRepository.save(form);
    }

    private Form updateForm(int id, Form form) {
        form.setId(id);
        return formRepository.save(form);
    }

    private void deleteForm(int id) {
        formRepository.deleteById(id);
    }
}
