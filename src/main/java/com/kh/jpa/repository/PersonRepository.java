package com.kh.jpa.repository;

import com.kh.jpa.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    /*
     * * 레포지토리 (Repository) : 데이터베이스와 상호작용하기 위한 인터페이스
     *   - JPA 의 엔티티를 CRUD 하는 데 사용
     *   - JPA 내에서 사용할 작업에 대하여 인터페이스를 정의하면 해당 인터페이스를 구현하는 클래스를 생성
     *
     *   - JpaRepository<T, K> 를 상속
     */

    /**
     * 주어진 사람 정보(Person)을 저장
     * 
     * @param person 저장할 사람 정보
     * @return 저장된 Person 엔티티 객체
     */
    Person save(Person person);

    /**
     * 주어진 ID에 해당하는 Person 엔티티를 조회
     * @param id 사용자 id 정보
     * @return 주어진 ID에 해당하는 Person 엔티티를 포함한 Optional 객체
     */
    Optional<Person> findById(Long id);
    
    /*
     * Optional : 값의 존재 여부를 나타내는 래퍼클래스 (wrapper class)
     *            값이 있을 수도 있고, 없을 수도 있는 상황에 주로 사용 (메소드 반환 값이 null 이 될 수 있는 경우)
     * 
     *   - null 체크를 명확하게 할 수 있으며, NullPointerException 을 방지 할 수 있음
     *     => 값이 있는 경우 해당 값을 감싸고, 없는 경우 빈 Optional 객체를 나타냄
     */

}