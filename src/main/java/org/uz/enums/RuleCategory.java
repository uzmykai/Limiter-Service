package org.uz.enums;

import lombok.Data;
import lombok.Getter;

@Getter
public enum RuleCategory {

  DEFAULT(1,"default"),
  CUSTOMIZED(2, "customized");

  final int id;
  final String name;
  RuleCategory(int id, String name){
      this.id = id;
      this.name = name;
  }

}
