package com.biennale.apidemo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.biennale.apidemo.exception.NotFoundException;
import com.biennale.apidemo.model.Server;
import com.biennale.apidemo.repository.ServerRepository;

@RestController
public class Controller {

	private Logger logger = LoggerFactory.getLogger(Controller.class);

	@Autowired
	private ServerRepository ServerRepository;

	@GetMapping(value = "/")
	public List<Server> getAllServers() {
		logger.info("Getting all Servers.");
		return ServerRepository.findAll();
		//System.out.println("404");
		//return null;
	}

	@GetMapping(value = "/{serverId}")
	public Server getServerById(@PathVariable String serverId) {
		Server mServer = ServerRepository.findServerById(serverId);
		if(mServer == null){
			throw new NotFoundException("404 Resource Not Found");
		}
		logger.info("Getting server with ID: {}", serverId);
		return mServer;
		
	}

	@GetMapping(value = "/find/{serverName}")
	public Server getServerByName(@PathVariable String serverName) {
		Server nServer = ServerRepository.findServerByName(serverName);
		if(nServer == null){
			throw new NotFoundException("404 Resource Not Found");
		}
		logger.info("Getting server with name: {}", serverName);
		return nServer;
		
	}

	@PostMapping(value = "/create")
	public Server addServer(@RequestBody Server server) {
		logger.info("Saving server.");
		return ServerRepository.save(server);
	}

	@PutMapping(value = "/update/{serverId}")
	public Server updateServer(@PathVariable String serverId, @RequestBody Server server) {
		logger.info("Updating server with ID: {}", serverId);
		server.setId(serverId);
		return ServerRepository.save(server);
	}

	@DeleteMapping(value = "/delete/{serverId}")
	public void deleteServer(@PathVariable String serverId) {
		logger.info("Deleting server with ID: {}", serverId);
		ServerRepository.deleteById(serverId);
	}
}
