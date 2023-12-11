package org.uz.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.uz.model.Response.ResponseModel;
import org.uz.model.request.ClientRequest;

@Service
public interface ClientService {

    ResponseEntity<ResponseModel> registerClient(ClientRequest request);

    ResponseEntity<ResponseModel> updateClient(ClientRequest request);

    ResponseEntity<ResponseModel> getClient(String ipAddress);

    ResponseEntity<ResponseModel> getClients();

    ResponseEntity<ResponseModel> deleteClient(String ipAddress);
}
