package org.uz.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.uz.model.Response.ResponseModel;
import org.uz.model.request.RuleRequest;

@Service
public interface RuleService {
    ResponseEntity<ResponseModel> createRule(RuleRequest request);

    ResponseEntity<ResponseModel> updateRule(RuleRequest request);

    ResponseEntity<ResponseModel> getRule(int id);

    ResponseEntity<ResponseModel> getRules();

    ResponseEntity<ResponseModel> deleteRule(int id);
}
