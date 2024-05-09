package com.kh.jpa;

import com.kh.jpa.a_basic_concepts.entity.Person;
import com.kh.jpa.a_basic_concepts.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.NoSuchElementException;

@SpringBootTest
class JpaApplicationTests {

	@Autowired
	PersonRepository personRepository;


	@Test
	void contextLoads() {

		Person p = new Person();
		p.setName("Anna");

		personRepository.save(p);
		Person saved = personRepository.findById(p.getId())
				.orElseThrow(NoSuchElementException::new);

		System.out.println(saved);

	}

}
