package org.uz.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.uz.model.Rule;



@Service
public interface RuleRepository extends CrudRepository<Rule,Integer> {
}
