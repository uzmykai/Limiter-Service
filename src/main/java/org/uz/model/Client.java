package org.uz.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.uz.enums.Status;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table
public class Client extends BaseModel {
    @Column
    private String ipAddress;
    @Column
    private Status status;
    @Column
    private String dateCreated;
    @Column
    private String createdBy;
}
