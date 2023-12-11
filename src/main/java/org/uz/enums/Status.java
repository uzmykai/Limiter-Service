package org.uz.enums;

import lombok.Getter;

@Getter
public enum Status {

    ACTIVE(1,"active"),
    INACTIVE(2, "inactive"),
    DELETE(3,"deleted");

    private final int id;
    private final String name;

    Status(int id, String name){
        this.id = id;
        this.name = name;
    }

}
