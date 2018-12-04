package org.sid;


import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.sid.Entity.Contact;
import org.sid.dao.ContactRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	
	private ContactRepositry contactRepositry;
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		DateFormat df= new SimpleDateFormat("dd/MM/yyyy");
		contactRepositry.save(new Contact("wael", "yakoubi", df.parse("30/11/1990"),0445555));
		contactRepositry.findAll().forEach(c->{
			System.out.println(c.getNom());
		});
	}
}
