package org.uz.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.uz.enums.Status;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class ClientRole extends BaseModel{
    @Column
    private int clientId;
    @Column
    private int ruleId;
    @Column
    private Status status;
    @Column
    private String dateCreated;
    @Column
    private String createdBy;
}
