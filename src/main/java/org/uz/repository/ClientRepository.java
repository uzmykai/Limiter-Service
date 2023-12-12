package org.uz.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.uz.model.Client;

@Service
public interface ClientRepository extends CrudRepository<Client,String> {

    public Iterable<Client> findByIpAddress(String ipAddress);

    public void deleteByIpAddress(String ipAddress);

}
