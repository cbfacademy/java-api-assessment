package com.cbfacademy.apiassessment;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

public class Inventory {
    private UUID Id;
    private String name;
    private String description;
    private Integer minimumQuantity;
    private Integer maximumQuantity;
    private LocalDateTime createdOn;

    public Inventory(String name, String descriprion, Integer minimumQuantity, Integer qmaximumQuantity) {
        this.name = name;
        this.description = descriprion;
        this.minimumQuantity = minimumQuantity;
        this.minimumQuantity = minimumQuantity;
        this.createdOn = LocalDateTime.now();
    }
    
    public Inventory() {
    }

    public Inventory(UUID id) {
        this.Id = id;
    }

    public UUID getId() {
        return Id;
    }

    public String getname() {
        return name;
    }

}


