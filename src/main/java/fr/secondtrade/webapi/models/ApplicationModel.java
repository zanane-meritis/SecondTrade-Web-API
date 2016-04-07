package fr.secondtrade.webapi.models;


import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.secondtrade.businessdao.business.IBusiness;
import fr.secondtrade.businessdao.entities.Agent;
import fr.secondtrade.businessdao.entities.Investor;
import fr.secondtrade.businessdao.entities.Issuer;
import fr.secondtrade.webapi.helpers.Static;

@Component
public class ApplicationModel implements IBusiness{
	
	@Autowired
	private IBusiness business;
	
	// données provenant de la couche [métier]
	private List<Agent> agents; 
	private List<Investor> investors; 
	private List<Issuer> issuers; 
	// messages d'erreur
	private List<String> messages;
	
	@PostConstruct
	public void init() {
		// on récupère les médecins et les clients 
		try {
			agents = business.getAllAgents();
			investors = business.getAllInverstors(); 
			issuers = business.getAllIssuers();
			System.out.println("Size of issuers = "+issuers.size());
		} catch (Exception ex) {
			messages = Static.getErreursForException(ex);
		}
	}
	
	public List<String> getMessages() {
		return messages;
	}

	@Override
	public List<Agent> getAllAgents() {
		return agents;
	}

	@Override
	public Agent getAgentById(long id) {
		return business.getAgentById(id);
	}

	@Override
	public List<Investor> getAllInverstors() {
		return investors;
	}

	@Override
	public Investor getInvestorById(long id) {
		return business.getInvestorById(id);
	}

	@Override
	public Issuer getIssuerById(long id) {
		return business.getIssuerById(id);
	}

	@Override
	public List<Issuer> getAllIssuers() {
		return issuers;
	}
	
}
