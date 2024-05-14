package com.kh.jpa.c_association_mapping;

import com.kh.jpa.c_association_mapping.onetoone.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MappingRepository extends JpaRepository<Employee, Long> {
    // https://docs.spring.io/spring-data/jpa/reference/repositories/query-keywords-reference.html
}
