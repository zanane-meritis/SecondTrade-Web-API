package fr.secondtrade.webapi.controllers;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.secondtrade.webapi.models.ApplicationModel;
import fr.secondtrade.webapi.models.Response;

@Controller
public class IndexController {
	
	@Autowired
	private ApplicationModel application;
	private List<String> messages;
	
	@PostConstruct
	public void init(){
		messages = application.getMessages();
	}
	
	@RequestMapping(value = "index", method = RequestMethod.GET)
	public Response index(){
		return new Response(200,"index");
	}
	
}
