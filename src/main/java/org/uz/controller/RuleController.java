package org.uz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.uz.model.Response.ResponseModel;
import org.uz.model.request.RuleRequest;
import org.uz.service.RuleService;

@RestController
@RequestMapping("/api/v1/uz/rule")
public class RuleController {
    @Autowired
   RuleService ruleService;

    @PostMapping("")
    private ResponseEntity<ResponseModel> CreateRule(
            @RequestBody RuleRequest ruleRequest){
        return ruleService.createRule(ruleRequest);
    }
    @PutMapping("")
    private ResponseEntity<ResponseModel> updateRule(
            @RequestBody RuleRequest ruleRequest){
        return ruleService.updateRule(ruleRequest);
    }
    @GetMapping("/{id}")
    private ResponseEntity<ResponseModel> findRule(@PathVariable int id){
        return ruleService.getRule(id);
    }
    @GetMapping("/all")
    private ResponseEntity<ResponseModel> findAllClientRule(){
        return ruleService.getRules();
    }
}
