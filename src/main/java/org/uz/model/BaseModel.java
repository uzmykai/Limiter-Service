package org.uz.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;


@Data
@Entity
public class BaseModel {
    @Id
    private int id;
}
