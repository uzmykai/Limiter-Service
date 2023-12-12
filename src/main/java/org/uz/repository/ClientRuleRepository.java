package org.uz.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.uz.model.ClientRule;


@Service
public interface ClientRuleRepository extends CrudRepository<ClientRule, Integer> {
}
