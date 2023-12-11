package org.uz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.uz.enums.Status;
import org.uz.model.Client;
import org.uz.model.Response.ResponseModel;
import org.uz.model.request.ClientRequest;
import org.uz.repository.ClientRepository;
import org.uz.service.ClientService;
import org.uz.utility.Constants;

import java.util.Date;
import java.util.Objects;

public class ClientServiceImpl implements ClientService {

    @Autowired
    ClientRepository clientRepository;

    @Override
    public ResponseEntity<ResponseModel> registerClient(ClientRequest request) {
        ResponseModel responseModel;
        var validateClientResponse = validateClientRequest(request);
        if(validateClientResponse.getStatusCode().equals(HttpStatus.OK)){
            return validateClientResponse;
        }

        Client client = createClientModel(request);
        client = clientRepository.save(client);

        responseModel = new ResponseModel(Constants.SUCCESS_CODE,
                Constants.SUCCESS_MESSAGE, client);
        return new ResponseEntity<>(responseModel, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseModel> updateClient(ClientRequest request) {
        var validateClientResponse = validateClientRequest(request);
        if(validateClientResponse.getStatusCode().equals(HttpStatus.OK)){
            return validateClientResponse;
        }

        Client client = createClientModel(request);
        clientRepository.save(client);

        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<ResponseModel> getClient(String ipAddress) {
        ResponseModel responseModel;

        Iterable<Client> clientModel = clientRepository.findByIpAddress(ipAddress);

        responseModel = new ResponseModel(Constants.SUCCESS_CODE,
                Constants.SUCCESS_MESSAGE, clientModel);
        return new ResponseEntity<>(responseModel, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseModel> getClients() {
        ResponseModel responseModel;

        Iterable<Client> clientModels  = clientRepository.findAll();

        responseModel = new ResponseModel(Constants.SUCCESS_CODE,
                Constants.SUCCESS_MESSAGE, clientModels);
        return new ResponseEntity<>(responseModel, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseModel> deleteClient(String ipAddress) {

       clientRepository.deleteByIpAddress(ipAddress);

        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    private ResponseEntity<ResponseModel> validateClientRequest(ClientRequest request){
        ResponseModel model;
        if(!Objects.equals(request.getStatus(), Status.INACTIVE.getName()) ||
                !Objects.equals(request.getStatus(), Status.ACTIVE.getName())){
            model =  new ResponseModel(Constants.BAD_REQUEST_CODE,
                    "{}: invalid status",Constants.BAD_REQUEST_MESSAGE);
            return new ResponseEntity<>(model,HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(null,HttpStatus.OK);
    }
    private Client createClientModel(ClientRequest request){
        Client client = new Client();
        client.setStatus(getClientStatus(request.getStatus()));
        client.setDateCreated((new Date()).toString());
        client.setCreatedBy("System");
        return client;
    }

    private Status getClientStatus(String status){
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
