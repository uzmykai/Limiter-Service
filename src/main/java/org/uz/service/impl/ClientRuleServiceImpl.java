package org.uz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.uz.enums.Status;
import org.uz.model.ClientRule;
import org.uz.model.Response.ResponseModel;
import org.uz.model.request.ClientRuleRequest;
import org.uz.repository.ClientRuleRepository;
import org.uz.service.ClientRuleService;
import org.uz.utility.Constants;

import java.util.Date;
import java.util.Optional;

public class ClientRuleServiceImpl implements ClientRuleService {

    @Autowired
    ClientRuleRepository clientRuleRepository;

    @Override
    public ResponseEntity<ResponseModel> createClientRule(ClientRuleRequest clientRuleRequest) {
        ResponseModel responseModel;
        ClientRule clientRule = createClientRuleModel(clientRuleRequest);
        clientRule = clientRuleRepository.save(clientRule);

        responseModel = new ResponseModel(Constants.SUCCESS_CODE,
                Constants.SUCCESS_MESSAGE, clientRule);
        return new ResponseEntity<>(responseModel, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseModel> updateClientRule(ClientRuleRequest clientRuleRequest) {
        ClientRule clientRule = createClientRuleModel(clientRuleRequest);
        clientRuleRepository.save(clientRule);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<ResponseModel> getClientRule(int id) {
        ResponseModel responseModel;
        Optional<ClientRule> clientRule = clientRuleRepository.findById(id);

        responseModel = new ResponseModel(Constants.SUCCESS_CODE,
                Constants.SUCCESS_MESSAGE, clientRule);
        return new ResponseEntity<>(responseModel, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseModel> getClientRuleAll() {
        ResponseModel responseModel;
        Iterable<ClientRule> clientRule = clientRuleRepository.findAll();

        responseModel = new ResponseModel(Constants.SUCCESS_CODE,
                Constants.SUCCESS_MESSAGE, clientRule);
        return new ResponseEntity<>(responseModel, HttpStatus.OK);
    }


    private ClientRule createClientRuleModel(ClientRuleRequest clientRuleRequest){
        ClientRule clientRule = new ClientRule();
        clientRule.setClientId(clientRuleRequest.getClientId());
        clientRule.setRuleId(clientRuleRequest.getRuleId());
        clientRule.setStatus(getClientRuleStatus(clientRuleRequest.getStatus()));
        clientRule.setDateCreated(new Date().toString());
        clientRule.setCreatedBy("System");
        return clientRule;
    }
    private Status getClientRuleStatus(String status){
        if(status.equals(Status.ACTIVE.getName())){
            return Status.ACTIVE;
        }
        else if(status.equals(Status.INACTIVE.getName())){
            return Status.INACTIVE;
        }
        else{
            return Status.ACTIVE;
        }

    }

}
