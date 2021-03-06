package org.sid;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.sid.dao.ContactRepository;
import org.sid.entities.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ContactsApplication implements CommandLineRunner{
	@Autowired
	private ContactRepository contactRepository;

	public static void main(String[] args) {
		SpringApplication.run(ContactsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		contactRepository.save(new Contact("ngounou", "youssouf", df.parse("12/01/1998"), 
				"youssoufngounou@gmail.com", 693659844, ""));
		contactRepository.save(new Contact("youssouf", "sokamte", df.parse("12/01/1998"), 
				"youssoufngounou@gmail.com", 693659844, ""));
		contactRepository.save(new Contact("sokamte", "joseph", df.parse("12/01/1998"), 
				"youssoufngounou@gmail.com", 693659844, ""));
		contactRepository.findAll().forEach(c->{
			System.out.println(c.getNom());
		});
	}

}
