package org.uz.model.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.uz.enums.Status;

import javax.validation.constraints.NotBlank;

@Data
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ClientRequest {
    @NotBlank(message = "ipAddress field required")
    private String ipAddress;
    @NotBlank(message = "status field required")
    private String status;
}
