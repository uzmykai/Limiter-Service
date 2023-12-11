package org.uz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.uz.model.ClientRole;
import org.uz.model.Response.ResponseModel;
import org.uz.repository.ClientRuleRepository;
import org.uz.service.ClientRuleService;

public class ClientRuleServiceImpl implements ClientRuleService {

    @Autowired
    ClientRuleRepository clientRuleRepository;

    @Override
    public ResponseEntity<ResponseModel> updateClientRule(ClientRole clientRole) {
        clientRuleRepository.save(clientRole);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

}
