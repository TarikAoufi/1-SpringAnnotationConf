package fr.aoufi.springsampleannotation.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.aoufi.springsampleannotation.dao.PersonneDAO;
import fr.aoufi.springsampleannotation.model.Personne;

@Service // stéréotype de component pour les beans de type service
//@Lazy
public class PersonneServiceImpl implements PersonneService {

	/* @Autowired injection possible sur l'attribut directement en private (pas
	   besoin de getters/setter) mais rend l'utilisation du bean pour le test
	   unitaire compliqué
	*/
	private PersonneDAO personneDAO;

	public PersonneServiceImpl() {
	}

	// @Autowired // Injection possible via le constructeur. 
	// Dépendance obligatoire, object immutable
	public PersonneServiceImpl(PersonneDAO personneDAO) {
		this.personneDAO = personneDAO;
	}

	@PostConstruct // Définit la méthode d'initialisation du bean
	public void init() {
		System.out.println("Methode d'initialisation");
	}

	@PreDestroy // Définit la méthode de destruction du bean (appelé après l'appel de la méthode close de l'applicationContext)
	public void destroy() {
		System.out.println("Methode de destruction");
	}

	@Override
	public void save(Personne personne) {
		personneDAO.save(personne);
	}

	public PersonneDAO getPersonneDAO() {
		return personneDAO;
	}

	@Autowired // (required = false) // Injection possible via le setter.
				// Avantage : dépendance optionnelle
	public void setPersonneDAO(PersonneDAO personneDAO) {
		this.personneDAO = personneDAO;
	}

}