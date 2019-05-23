package com.lin.repository;


import com.lin.node.Person;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonRepository extends GraphRepository<Person>{
	 List<Person> findByName(@Param("name") String name);
}
