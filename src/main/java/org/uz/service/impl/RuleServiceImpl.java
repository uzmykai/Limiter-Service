package org.uz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.uz.enums.RuleCategory;
import org.uz.enums.Status;
import org.uz.model.Response.ResponseModel;
import org.uz.model.Rule;
import org.uz.model.request.RuleRequest;
import org.uz.repository.RuleRepository;
import org.uz.service.RuleService;
import org.uz.utility.Constants;
import java.util.Date;
import java.util.Objects;
import java.util.Optional;

public class RuleServiceImpl implements RuleService {

    @Autowired
    RuleRepository repository;

    @Override
    public ResponseEntity<ResponseModel> createRule(RuleRequest request) {
       ResponseModel responseModel;

       var validateRuleResponse = validateRule(request);
       if(validateRuleResponse.getStatusCode().equals(HttpStatus.OK)){
           return validateRuleResponse;
       }

       Rule Rule = createRuleRequest(request);
       Rule rule = repository.save(Rule);

        responseModel = new ResponseModel(Constants.SUCCESS_CODE,
                Constants.SUCCESS_MESSAGE, Rule);
        return new ResponseEntity<>(responseModel, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseModel> updateRule(RuleRequest request) {

        var validateRuleResponse = validateRule(request);
        if(validateRuleResponse.getStatusCode().equals(HttpStatus.OK)){
            return validateRuleResponse;
        }

        Rule Rule = createRuleRequest(request);
        repository.save(Rule);

        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseModel> getRule(int id) {

        ResponseModel responseModel;

        Optional<Rule> Rule  = repository.findById(id);

        responseModel = new ResponseModel(Constants.SUCCESS_CODE,
                Constants.SUCCESS_MESSAGE, Rule);
        return new ResponseEntity<>(responseModel, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseModel> getRules() {
        ResponseModel responseModel;

        Iterable<Rule> Rule  = repository.findAll();

        responseModel = new ResponseModel(Constants.SUCCESS_CODE,
                Constants.SUCCESS_MESSAGE, Rule);
        return new ResponseEntity<>(responseModel, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseModel> deleteRule(int id) {
        repository.deleteById(id);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    private ResponseEntity<ResponseModel> validateRule(RuleRequest request){
        ResponseModel model;

        if(request.getMax_request() == 0){
            model = new ResponseModel(Constants.BAD_REQUEST_CODE,
                    "{}: invalid max request",Constants.BAD_REQUEST_MESSAGE);
            return new ResponseEntity<>(model,HttpStatus.BAD_REQUEST);

        }
        if(request.getMax_seconds_per_request() == 0){
           model =  new ResponseModel(Constants.BAD_REQUEST_CODE,
                   "{}: invalid max sec per request",Constants.BAD_REQUEST_MESSAGE);
            return new ResponseEntity<>(model,HttpStatus.BAD_REQUEST);
        }
        if(!Objects.equals(request.getStatus(), Status.INACTIVE.getName()) ||
                !Objects.equals(request.getStatus(), Status.ACTIVE.getName())){
            model =  new ResponseModel(Constants.BAD_REQUEST_CODE,
                    "{}: invalid status",Constants.BAD_REQUEST_MESSAGE);
            return new ResponseEntity<>(model,HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(null,HttpStatus.OK);
    }
    private Rule createRuleRequest(RuleRequest request){
        Rule Rule = new Rule();
        Rule.setName(request.getName());
        Rule.setDescription(request.getDescription());
        Rule.setCategory(RuleCategory.CUSTOMIZED);
        Rule.setStatus(getRuleStatus(request.getStatus()));
        Rule.setMaxRequest(request.getMax_request());
        Rule.setMaxSecondsPerRequest(request.getMax_seconds_per_request());
        Rule.setDateCreated((new Date()).toString());
        Rule.setCreatedBy("System");
        return Rule;
    }

    private Status getRuleStatus(String status){
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
