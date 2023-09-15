package com.in28Minutes.demo;

import com.in28Minutes.demo.databaseDemo.PersonJdbcDAO;
import com.in28Minutes.demo.databaseDemo.entity.Person;
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
	PersonJdbcDAO personJdbcDAO;
	public static void main(String[] args) {
		SpringApplication.run(HosseinStudyHibernateApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		logger.info("\nperson {}",personJdbcDAO.findAll());
		System.out.printf("%s\n" ,personJdbcDAO.findAll());
		System.out.println("=============================");
		System.out.println(personJdbcDAO.findById(10001));
		System.out.println("How many rows effected:  " + personJdbcDAO.deleteById(10003));
		System.out.println(personJdbcDAO.insert(new Person(10003, "Hossein", "Rey", new Date())));
		System.out.println(personJdbcDAO.update(new Person(10003, "Mahan", "Tehran", new Date())));
	}
}
