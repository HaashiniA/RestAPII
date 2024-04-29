package com.example.ce1.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="employee")
public class HaashiniEmployee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;
    @OneToOne(mappedBy = "employee",cascade = CascadeType.REMOVE,fetch = FetchType.LAZY)
    @JsonManagedReference
    HaashiniAddress address;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public HaashiniAddress getAddress() {
        return address;
    }
    public void setAddress(HaashiniAddress address) {
        this.address = address;
    }
    
}
