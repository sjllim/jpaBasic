package com.kh.jpa.c_association_mapping.onetomany;

import com.kh.jpa.c_association_mapping.onetoone.Employee;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Department {
    @Id
    private Long id;

    /*
     * * @OneToMany : 일대다 관계.
     */
    /**
     * 부서의 직원목록 관련 매핑
     * 부서는 여러명의 직원이 있을 수 있음
     */
    @OneToMany
    @JoinColumn(name="department_id")
    private List<Employee> employees;
}
