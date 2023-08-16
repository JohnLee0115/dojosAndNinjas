package com.john.dojosandninjas.repositories;

import org.springframework.data.repository.CrudRepository;

import com.john.dojosandninjas.models.Ninja;

public interface NinjaRepository extends CrudRepository<Ninja, Long>{
	
}
