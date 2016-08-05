package fr.aoufi.springsampleannotation.dao;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import fr.aoufi.springsampleannotation.model.Personne;

@Repository
@Profile("jdbc")
public class PersonneJDBCDAO implements PersonneDAO {

	public Personne save(Personne personne) {
		System.out.println("Méthode JDBC");
		return null;
	}

}
