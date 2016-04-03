package fr.secondtrade.webapi.controllers;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.secondtrade.webapi.models.ApplicationModel;

public class IndexController {
	
	@Autowired
	private ApplicationModel application;
	private List<String> messages;
	
	@PostConstruct
	public void init(){
		messages = application.getMessages();
	}
	
	/*@RequestMapping(value = "/", method = RequestMethod.GET)
	public Response 
	*/
}
