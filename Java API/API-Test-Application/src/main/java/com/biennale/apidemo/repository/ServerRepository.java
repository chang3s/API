package com.biennale.apidemo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.biennale.apidemo.model.Server;

public interface ServerRepository extends MongoRepository<Server, String> {

	Server findServerById(String serverId);

    Server findServerByName(String name);

}
