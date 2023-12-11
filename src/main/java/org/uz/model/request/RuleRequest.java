package org.uz.model.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;


import javax.validation.constraints.NotBlank;

@Data
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class RuleRequest {
    @NotBlank(message = "name field is required")
    private String name;
    @NotBlank(message = "description field is required")
    private String description;
    @NotBlank(message = "status field is required")
    private String status;
    private int max_seconds_per_request;
    private int max_request;
}
