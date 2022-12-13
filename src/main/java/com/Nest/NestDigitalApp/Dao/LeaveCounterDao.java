package com.Nest.NestDigitalApp.Dao;

import com.Nest.NestDigitalApp.model.LeaveCounter;

import org.springframework.data.repository.CrudRepository;


public interface LeaveCounterDao extends CrudRepository<LeaveCounter, Integer> {


}
