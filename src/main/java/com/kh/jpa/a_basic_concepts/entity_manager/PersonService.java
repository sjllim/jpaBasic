package com.kh.jpa.a_basic_concepts.entity_manager;

import com.kh.jpa.a_basic_concepts.entity.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonService {

    /*
        - 영속성 컨텍스트 (persistence context)
          : 엔티티의 생명 주기를 관리하는 JPA 개념
            엔티티가 영속성 컨텍스트에 포함되면 JPA가 엔티티를 관리하고 분리되면 더 이상 관리하지 않음

          * persist : 새로운 엔티티를 영속성 컨텍스트에 추가
          * find : 데이터베이스에서 엔티티 검색
          * detach : 엔티티를 영속성 컨텍스트에서 분리
          * merge : 분리된 엔티티의 변경 사항을 영속성 컨텍스트에 반영
          * remove : 엔티티를 영속성 컨텍스트에서 삭제하고 데이터베이스에서 제거
          * createQuery : SQL과 유사함. 엔티티를 대상으로 쿼리 작성
            + setParameter : 쿼리 파라미터 설정 시 사용. 위치 기반으로 설정 (ex. ?1)
            + getResultList : 쿼리를 실행하고 결과를 리스트로 반환
     */
    @PersistenceContext     // or even @Autowired
    EntityManager entityManager;

    @Transactional                          // 메소드에 트랜잭션 적용
    public void savePerson(String name) {

        Person p = new Person();
        p.setName(name);
        entityManager.persist(p);                           // 영속성 컨텍스트에 객체를 저장 => 데이터베이스에 저장

    }

    @Transactional(readOnly = true)         // 읽기 전용 옵션 추가 (readOnly = true)
    public Person getPerson(Long id) {

        Person p = entityManager.find(Person.class, id);    // 기본키(PK)에 해당하는 엔티티를 데이터베이스에서 조회하여 반환
        entityManager.detach(p);                            // 영속성 컨텍스트에서 분리
        return p;

    }

    @Transactional
    public void updatePerson(Long id, String name) {

        Person p = getPerson(id);
        entityManager.detach(p);
        p.setName(name);
        entityManager.merge(p);                             // 변경된 엔티티를 영속성 컨텍스트에 병합하여 데이터베이스에 반영될 수 있도록 함

    }

    @Transactional(readOnly = true)
    public Person getPersonByName(String name) {
        // JPQL (Java Persistence Query Language) 쿼리 생성. 엔티티를 대상으로 주어진 값과 일치하는 엔티티 조회
        return (Person) entityManager.createQuery("select p from Person p where p.name = ?1")
                .setParameter(1, name)          // 위에 작성된 쿼리에서 첫 번째 파라미터(?1)를 name 변수의 값으로 설정
                .getSingleResult();
    }

    @Transactional(readOnly = true)
    public int getTotalPersonCount() {
        // count 함수 사용 시 결과가 Long 으로 처리됨.
        Long count = (Long)entityManager.createQuery("select count(*) from Person p")
                .getSingleResult();     // 쿼리 실행 결과를 단일 결과로 가져옴
        return count.intValue();
    }

    @Transactional
    public void removePerson(Long id) {

        Person p = entityManager.find(Person.class, id);
        if (p != null)
            entityManager.remove(p);                        // 영속성 컨텍스트에서 해당 엔티티를 삭제

    }
}
