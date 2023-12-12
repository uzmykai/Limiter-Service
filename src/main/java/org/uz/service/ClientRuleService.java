package org.uz.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.uz.model.Response.ResponseModel;
import org.uz.model.request.ClientRuleRequest;

@Service
public interface ClientRuleService {

    ResponseEntity<ResponseModel> createClientRule(ClientRuleRequest clientRuleRequest);
    ResponseEntity<ResponseModel> updateClientRule(ClientRuleRequest clientRuleRequest);

    ResponseEntity<ResponseModel> getClientRule(int id);

    ResponseEntity<ResponseModel> getClientRuleAll();

}
