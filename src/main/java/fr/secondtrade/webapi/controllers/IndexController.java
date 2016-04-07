package fr.secondtrade.webapi.controllers;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.secondtrade.businessdao.entities.Agent;
import fr.secondtrade.businessdao.entities.Issuer;
import fr.secondtrade.webapi.helpers.Static;
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
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public Response index(){
		return new Response(0,"index");
	}
	
	public Response getAgentById(long id){
		Agent agent = null;
		try{
			agent = application.getAgentById(id);
		}catch(Exception e1){
			return new Response(1,Static.getErreursForException(e1));
		}
		if(agent==null){
			return new Response(2,null);
		}
		return new Response(0,agent);
	}
	
	@RequestMapping(value = "/getAllAgents", method = RequestMethod.GET)
	public Response getAllAgents(){
		if(messages != null){
			return new Response(-1,messages);
		}
		try {
			return new Response(0,application.getAllAgents());
		} catch (Exception e) {
			return new Response(1,Static.getErreursForException(e));
		}
	}
	
	
	public Response getIssuerById(long id){
		Issuer issuer = null;
		try{
			issuer = application.getIssuerById(id);
		}catch(Exception e1){
			return new Response(1,Static.getErreursForException(e1));
		}
		if(issuer==null){
			return new Response(2,null);
		}
		return new Response(0,issuer);
	}
	
	@RequestMapping(value = "/getAllIssuers", method = RequestMethod.GET)
	public Response getAllIssuers(){
		if(messages != null){
			return new Response(-1,messages);
		}
		try {
			return new Response(0,application.getAllIssuers());
		} catch (Exception e) {
			return new Response(1,Static.getErreursForException(e));
		}
	}
	
}
