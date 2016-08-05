package fr.aoufi.springsampleannotation.runtime;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fr.aoufi.springsampleannotation.conf.ApplicationConfiguration;
import fr.aoufi.springsampleannotation.model.Personne;
import fr.aoufi.springsampleannotation.service.PersonneServiceImpl;

public class Runtime {

	public static void main(String[] args) {

		System.setProperty("spring.profiles.active", "jpa");

		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);

		for (String string : applicationContext.getBeanDefinitionNames()) {
			System.out.println(string);
		}
		
		PersonneServiceImpl personneService = (PersonneServiceImpl) applicationContext.getBean("personneServiceImpl");

		personneService = applicationContext.getBean(PersonneServiceImpl.class);

		personneService = applicationContext.getBean("personneServiceImpl", PersonneServiceImpl.class);

		personneService.save(new Personne());
		
		((ConfigurableApplicationContext) applicationContext).close();
	}

}