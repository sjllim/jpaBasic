# JPA Basic Project

## 용어
- JPA (Java Persistence API)
  - 자바에서 데이터를 영구적으로 저장하고 관리하기 위한 응용 프로그래밍 인터페이스
  - 객체 지향 프로그래밍과 관계형 데이터베이스 사이의 매핑을 위한 표준 스펙
  - 객체와 관계형 데이터베이스 간의 매핑을 통해 데이터베이스 접근 및 데이터 조작 지원
  - https://spring.io/projects/spring-data-jpa

- Hibernate
  - JPA 구현체 중 하나
  - JPA 의 스펙을 준수하면서 객체와 데이터베이스 간의 매핑 구현
  - https://docs.jboss.org/hibernate/orm/6.5/quickstart/html_single/


## 설정 관련 참고
- application.properties (Oracle DB 기준 작성)
  - DB 접속 정보 설정
> spring.datasource.driver-class-name=oracle.jdbc.driver.OracleDriver <br/>
> spring.datasource.url=jdbc:oracle:thin:@//localhost:1521/xe <br/>
> spring.datasource.username=jpatest <br/>
> spring.datasource.password=jpatest

  -  사용 DB의 Hibernate Dialect 설정
> spring.jpa.database-platform=org.hibernate.dialect.OracleDialect

  - DB 스키마 작업 지정 (아래 설정은 Hibernate 실행될 때마다 기준)
    - none: 스키마 작업 수행하지 않음 (수동 처리)
    - create: 스키마 생성
    - create-drop: 스키마 생성 및 애플리케이션 종료 시 스키마 삭제
    - update: 스키마 갱신
    - validate: 스키마 유효성 검사
> spring.jpa.hibernate.ddl-auto=update