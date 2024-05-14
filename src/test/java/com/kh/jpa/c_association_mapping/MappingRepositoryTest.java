package com.kh.jpa.c_association_mapping;

import com.kh.jpa.c_association_mapping.onetoone.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MappingRepositoryTest {

    @Autowired
    MappingRepository mappingRepository;

    @Test
    void one2one() {
        List<Employee> list = mappingRepository.findAll();
        print("===============================");
        for (Employee e : list) {
            print(e);
        }
        print("===============================");
    }

    private void print(Object str) {
        System.out.println(str);
    }

}