package org.uz.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.uz.model.ClientRole;


@Service
public interface ClientRuleRepository extends CrudRepository<ClientRole, Integer> {
}
