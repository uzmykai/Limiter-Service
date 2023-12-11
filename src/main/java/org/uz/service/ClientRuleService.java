package org.uz.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.uz.model.ClientRole;
import org.uz.model.Response.ResponseModel;

@Service
public interface ClientRuleService {
    ResponseEntity<ResponseModel> updateClientRule(ClientRole clientRole);

}
