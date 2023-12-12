package org.uz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.uz.model.Response.ResponseModel;
import org.uz.model.request.ClientRuleRequest;
import org.uz.service.ClientRuleService;

@RestController
@RequestMapping("/api/v1/uz/client-rule")
public class ClientRuleController {

    @Autowired
    ClientRuleService clientRuleService;

    @PostMapping("")
    private ResponseEntity<ResponseModel> CreateClientRule(
            @RequestBody ClientRuleRequest clientRuleRequest){
        return clientRuleService.createClientRule(clientRuleRequest);
    }
    @PutMapping("")
    private ResponseEntity<ResponseModel> updateClientRule(
            @RequestBody ClientRuleRequest clientRuleRequest){
        return clientRuleService.updateClientRule(clientRuleRequest);
    }
    @GetMapping("/{id}")
    private ResponseEntity<ResponseModel> findClientRule(@PathVariable int id){
        return clientRuleService.getClientRule(id);
    }
    @GetMapping("/all")
    private ResponseEntity<ResponseModel> findAllClientRule(){
        return clientRuleService.getClientRuleAll();
    }
}
