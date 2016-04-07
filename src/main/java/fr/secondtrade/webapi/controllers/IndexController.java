package fr.secondtrade.webapi.controllers;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.secondtrade.webapi.models.ApplicationModel;
import fr.secondtrade.webapi.models.Response;

@RestController
public class IndexController {
	
	@Autowired
	private ApplicationModel application;
	private List<String> messages;
	
	@PostConstruct
	public void init(){
		messages = application.getMessages();
	}
	
	@RequestMapping(value = "getAgentById", method = RequestMethod.GET)
	public Response getAgentById(){
		return new Response(0,application.getAgentById(1));
	}
	
}
