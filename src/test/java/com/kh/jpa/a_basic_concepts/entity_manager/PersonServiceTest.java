package com.kh.jpa.a_basic_concepts.entity_manager;

import com.kh.jpa.a_basic_concepts.entity.Person;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PersonServiceTest {

    Logger logger = LoggerFactory.getLogger(PersonServiceTest.class);

    @Autowired
    PersonService pService;

    @Test
    public void addPerson() {
        String[] persons = {"이하늬", "정우성", "황정민", "류준열", "고윤정",
                            "정해인", "박서준", "김혜수", "한효주", "김태리"};

        for (String name : persons) {
            pService.savePerson(name);
        }
    }

    @Test
    public void getPerson() {
        int count = pService.getTotalPersonCount();

        logger.info("저장되어 있는 사람 수 ==> {}", count);

        for (int i = 1; i <= count; i++) {
            Person p = pService.getPerson((long)i);
            logger.info("Person ===> {}", p);
        }
    }

    @Test
    public void removePerson() {
        try {
            Person p = pService.getPersonByName("황정민");

            logger.info("remove target ===> {}",p);
            pService.removePerson(p.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void updatePerson() {
        try {
            Person p = pService.getPersonByName("한효주");

            logger.info("update target ===> {}",p);
            pService.updatePerson(p.getId(), "배우 한효주");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}