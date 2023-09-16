package com.in28Minutes.demo;

import com.in28Minutes.demo.databaseDemo.PersonJdbc.PersonJPARepo;
import com.in28Minutes.demo.databaseDemo.PersonJdbc.PersonJdbcRepo;
import com.in28Minutes.demo.databaseDemo.entity.PersonForJDBC;
import com.in28Minutes.demo.databaseDemo.entity.PersonForJPA;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class HosseinStudyHibernateApplication implements CommandLineRunner {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	PersonJdbcRepo personJdbcRepo;
	@Autowired
	PersonJPARepo personJPARepo;
	public static void main(String[] args) {
		SpringApplication.run(HosseinStudyHibernateApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		logger.info("\nperson {}",personJdbcDAO.findAll());
		System.out.printf("%s\n" , personJdbcRepo.findAll());
		System.out.println("=============================");
		System.out.println(personJdbcRepo.findById(10001));
		System.out.println("How many rows effected:  " + personJdbcRepo.deleteById(10003));
		System.out.println(personJdbcRepo.insert(new PersonForJDBC(10003, "Hossein", "Rey", new Date())));
		System.out.println(personJdbcRepo.update(new PersonForJDBC(10003, "Mahan", "Tehran", new Date())));
		System.out.println("===============JPA===============");
		System.out.println(personJPARepo.findById(10002));
		personJPARepo.deleteById(1004);
		var personForJPA = new PersonForJPA(1004, "Mahnoosh", "Amol", new Date());
		System.out.println(personJPARepo.insert(personForJPA));
		personForJPA.setName("Mahnoosh Mo");
		System.out.println(personJPARepo.update(personForJPA));
		System.out.println(personJPARepo.findAll());
	}
}
