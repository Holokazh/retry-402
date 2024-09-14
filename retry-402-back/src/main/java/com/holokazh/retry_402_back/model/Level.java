package com.holokazh.retry_402_back.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Level {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "level_id", referencedColumnName = "id", nullable = false)
    private List<Form> forms;

    public Level() {
    }

    public Level(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addForm(Form form) {
        this.forms.add(form);
    }

    public void addForms(List<Form> listForms) {
        this.forms.addAll(listForms);
    }

    public void setForms(List<Form> listForms) {
        this.forms = listForms;
    }

    public List<Form> getForms() {
        return this.forms;
    }
}
