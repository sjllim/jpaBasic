package com.kh.jpa;

import com.kh.jpa.a_basic_concepts.entity.Person;
import com.kh.jpa.a_basic_concepts.repository.PersonRepository;
import com.kh.jpa.b_core_concepts.entity.TestUser;
import com.kh.jpa.b_core_concepts.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.NoSuchElementException;

@SpringBootTest
class JpaApplicationTests {

	@Autowired
	PersonRepository personRepository;

	@Autowired
	UserRepository userRepository;

	@Test
	void contextLoads() {

		// aBasicConcepts();
		// bCoreConcepts();
	}

	void aBasicConcepts() {
		Person p = new Person();
		p.setName("Anna");

		personRepository.save(p);
		Person saved = personRepository.findById(p.getId())
				.orElseThrow(NoSuchElementException::new);

		System.out.println("------------ 결과 --------------");
		System.out.println(saved);
		System.out.println("--------------------------------");
	}

	void bCoreConcepts() {
		userRepository.save(new TestUser("아이유", 30));
		userRepository.save(new TestUser("짱구", 7));

		List<TestUser> list = userRepository.findAdult();

		System.out.println("------------ 결과 --------------");
		for (TestUser a : list) {
			System.out.println(a);
		}
		System.out.println("--------------------------------");
	}
}
