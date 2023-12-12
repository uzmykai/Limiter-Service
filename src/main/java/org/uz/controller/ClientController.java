package org.uz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.uz.model.Response.ResponseModel;
import org.uz.model.request.ClientRequest;
import org.uz.service.ClientService;

@RestController
@RequestMapping("/api/v1/uz/client")
public class ClientController {

    @Autowired
    ClientService clientService;

    @PostMapping("")
    private ResponseEntity<ResponseModel> CreateClient(
            @RequestBody ClientRequest clientRequest){
        return clientService.registerClient(clientRequest);
    }
    @PutMapping("")
    private ResponseEntity<ResponseModel> updateClient(
            @RequestBody ClientRequest clientRequest){
        return clientService.updateClient(clientRequest);
    }
    @GetMapping("/{ipAddress}")
    private ResponseEntity<ResponseModel> findClient(@PathVariable String ipAddress){
        return clientService.getClient(ipAddress);
    }
    @GetMapping("/all")
    private ResponseEntity<ResponseModel> findAllClient(){
        return clientService.getClients();
    }
}
