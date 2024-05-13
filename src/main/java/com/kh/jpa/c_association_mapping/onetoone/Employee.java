package com.kh.jpa.c_association_mapping.onetoone;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Employee {

    /*
     * * 관계 매핑 : 객체 간의 관계를 테이블 간의 관계로 매핑하는 과정
     */

    @Id
    private Long id;
    /*
     * * @OneToOne : 일대일 관계.
     *   - @JoinColumn : 외래키 컬럼 지정
     */
    @OneToOne
    @JoinColumn(name = "parking_spot_id")
    private ParkingSpot parkingSpot;
}
