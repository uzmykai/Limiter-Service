package org.uz.model.request;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ClientRuleRequest {
    private int clientId;
    private int ruleId;
    @NotBlank(message = "status field is required")
    private String status;
}
