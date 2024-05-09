package com.kh.jpa.b_core_concepts.repository;

import com.kh.jpa.b_core_concepts.entity.TestUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<TestUser, Long> {

    /*
     * * JpaRepository : CrudRepository 를 상속받는 인터페이스.
     *                   데이터베이스 작업 시 CRUD 외에도 페이징, 정렬, 동적 쿼리 작성 등 기능 제공
     *
     *      - save(T) : 엔티티 저장
     *      - findById(ID) : 주어진 ID에 해당하는 엔티티 검색
     *      - findAll() : 모든 엔티티 검색
     *      - delete(T) : 엔티티 삭제
     *
     * -------------------------------------------------------
     *
     * * CrudRepository : Repository 를 상속받은 인터페이스.
     *                    CRUD 기능 제공
     *      - save(T) : 엔티티 저장
     *      - findById(ID) : 주어진 ID에 해당하는 엔티티 검색
     *      - findAll() : 모든 엔티티 검색
     *      - count() : 저장된 엔티티의 수 검색
     *      - delete(T) : 엔티티 삭제
     *      - existsById(ID) : 주어진 ID에 해당하는 엔티티가 존재하는 지 여부
     *
     * -------------------------------------------------------
     *
     * * Repository : Spring Data 에서 제공하는 데이터 액세스 관련 추상화된 인터페이스
     *                CRUD 기능 제공
     */

    /*
     * * 메소드 명명 규칙
     *      1. 메소드의 이름은 'findBy', 'readBy', 'queryBy', 'countBy', 'deleteBy' 로 시작
     *      2. 그 뒤에는 엔티티의 필드명 또는 연관 관계의 필드명 사용
     *      3. 필드명 뒤에는 검색 조건을 표시하는 키워드 사용
     *          ( 'Equals', 'Like', 'GreaterThan', 'LessThan' 등)
     *      4. 필드명과 검색 조건 키워드 사이에는 연결어 사용 가능 ('And', 'Or' 등)
     *          - 조건이 있을 경우 매개변수의 필드명과 순서를 동일하게 맞춰줘야 함
     *            ex) deleteByNameAndAge(String name, int age) (O)
     *                deleteByAgeAndName(String name, int age) (X)
     *      5. 검색 조건 키워드 뒤에는 해당 필드의 타입과 맞는 값이나 매개변수가 사용됨
     */

    /**
     * 검색한 이름에 해당되는 유저 조회
     * @param name 검색할 이름
     * @return 이름에 해당하는 User 엔티티 객체
     */
    TestUser findByName(String name);

    /**
     * 저장된 나이가 입력된 나이보다 많은 유저 조회
     * @param age 나이
     * @return 조건에 해당하는 User 엔티티 객체
     */
    TestUser findByAgeGreaterThan(int age);

    /**
     * 이름과 나이에 해당하는 유저 삭제
     * @param name 이름
     * @param age 나이
     */
    void deleteByNameAndAge(String name, int age);

    /**
     * 20살 이상인 유저 검색 (Named Query)
     * @return 20살 이상인 유저 객체
     */
    List<TestUser> findAdult();
}
