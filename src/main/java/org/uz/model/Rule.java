package org.uz.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.uz.enums.RuleCategory;
import org.uz.enums.Status;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table
public class Rule extends BaseModel {
    @Column
    private String name;
    @Column
    private String description;
    @Column
    private RuleCategory category;
    @Column
    private Status status;
    @Column
    private String dateCreated;
    @Column
    private int maxSecondsPerRequest;
    @Column
    private int maxRequest;
    @Column
    private String createdBy;
}
