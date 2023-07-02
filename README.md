## 👋 안녕하세요! 환영합니다! 저희 프로젝트 관련 설명드리도록 하겠습니다.

#### 대출상품 추천 웹 애플리케이션 프로젝트 입니다.

###### 2023.05.02 ~ 06.26 동안 Spring Boot 와 React 와 Python 를 사용해 구현했습니다.
###### 이 프로젝트를 통해 이루고자 한 목표는 Spring과 react에 연동 방식 및 Python의 라이브러리 및 프레임워크를 직접 사용해 보려고 하였습니다.
###### 프로젝트 구현 과정 동안 회원 인증/인가, Rest api 연동 및 Python의 Data 수집 및 react와 연결을 고민하며 코드를 작성하였습니다.

## ✨ 접근 방식

#### 과정1 : React + java + SpringBoot + JPA + DB [my sql ]기반의 웹어플리케이션 개발

#### 과정2: Python 기반의 데이터분석: 수집(web scraping) + 정제(numpy,pandas) + 분석 + 시각화(ELK)

#### 과정3: Python 기반의 데이터 예측: AI 알고리즘 [ex)선형회귀, 로지스틱 회귀, DNN]을 활용하여 데이터 예측 시스템 구축

###### 언어는 Java를 사용하였으며, 회원과 게시판 기능은 React 및 Springboot를 통해서 구현하였습니다.

###### 또한, 과정2는 Python을 통해서 공공Api에 접근하여 데이터를 수집 및 정제하고, ELk를 통해서 해당 부분을 시각화하여 React로 다시 보여지도록 설정하였습니다

###### 과정3는 파이썬을 통해서 데이터를 훈련시켜, 회원에 맞는 대출 상품을 추천하게 만들었습니다.

## 📚 목차

- 사용 기술
- 프로젝트 구조
- 구현 기능
- 구현 설명 및 화면
- Python 기반의 데이터 분석
- Python 기반의 데이터 예측
- ERD 모델

## 🕹 사용 기술

### Back-end

+ JAVA (11)
+ MAVEN
+ jjwt (0.9.1)
+ JPA
+ React
+ Python (3.11.3)
+ Flask
+ ELK
+ mysql

## ✴️ 구현기능

* **회원 기능**
  - Spring Security,jwt
  - 로그인/로그아웃
  - 회원가입/탈퇴, 회원정보 수정
    
* **게시판 기능**
  - 게시글 작성/수정/삭제
  - 첨부 파일 기능
  - 댓글 기능

## ✅ 구현기능 설명

### (1) 회원기능

**- Spring Security -**
###### # WebSecurityConfigurerAdapter은 Spring Security에서 보안 구현을 담당하는 핵심 클래스입니다.
###### # UserDetailsService를 통해 사용자 정보를 로드하고, UsernamePasswordAuthenticationToken을 사용하여 로그인 요청을 인증합니다.
###### # OncePerRequestFilter를 사용하여 JWT 유효성을 검사하고, 인증된 사용자의 세부 정보를 로드하고 권한을 확인합니다.
###### # AuthenticationEntryPoint는 인증되지 않은 액세스에 대한 오류를 처리하고 401을 반환합니다.
###### # Repository는 데이터베이스 작업을 처리하는 UserRepository와 RoleRepository를 포함합니다.
###### # Controller는 요청을 처리하며, AuthController는 회원 가입 및 로그인을 처리하고, TestController에는 역할 기반 검증이 있는 보호된 리소스에 액세스하는 메서드가 있습니다.
###### # WebSecurityConfig은 SecurityFilterChain filterChain을 확장합니다.
###### # UserDetailsServiceImpl은 UserDetailsService를 구현합니다.
###### # UserDetailsImpl은 UserDetails를 구현합니다.
###### # AuthEntryPointJwt는 AuthenticationEntryPoint를 구현합니다.
###### # AuthTokenFilter는 OncePerRequestFilter를 확장합니다.
###### # JwtUtils는 JWT 생성, 구문 분석, 유효성 검사를 위한 메서드를 제공합니다.
###### # 컨트롤러는 회원 가입/로그인 요청 및 인증된 요청을 처리합니다.
###### # 리포지토리에는 Spring Data JPA JpaRepository를 확장하는 인터페이스가 있습니다.
###### # 모델은 인증(User) 및 권한(Role)을 위한 두 가지 주요 모델을 정의합니다.
###### # 페이로드는 요청 및 응답 객체를 위한 클래스를 정의하고 application.properties 파일을 사용하여 Spring Datasource, Spring Data JPA 및 앱 속성을 구성합니다.


https://github.com/Hooddduck/BKHJ-backend/assets/125169764/20bde107-e186-4225-9bc1-6e4f48be3731



## Dependency
– If you want to use PostgreSQL:
```xml
<dependency>
  <groupId>org.postgresql</groupId>
  <artifactId>postgresql</artifactId>
  <scope>runtime</scope>
</dependency>
```
– or MySQL:
```xml
<dependency>
  <groupId>mysql</groupId>
  <artifactId>mysql-connector-java</artifactId>
  <scope>runtime</scope>
</dependency>
```
## Configure Spring Datasource, JPA, App properties
Open `src/main/resources/application.properties`
- For PostgreSQL:
```
spring.datasource.url= jdbc:postgresql://localhost:5432/testdb
spring.datasource.username= postgres
spring.datasource.password= 123

spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation= true
spring.jpa.properties.hibernate.dialect= org.hibernate.dialect.PostgreSQLDialect

# Hibernate ddl auto (create, create-drop, validate, update)
spring.jpa.hibernate.ddl-auto= update

# App Properties
bezkoder.app.jwtSecret= bezKoderSecretKey
bezkoder.app.jwtExpirationMs= 86400000
```
- For MySQL
```
spring.datasource.url= jdbc:mysql://localhost:3306/testdb?useSSL=false
spring.datasource.username= root
spring.datasource.password= 123456

spring.jpa.properties.hibernate.dialect= org.hibernate.dialect.MySQL5InnoDBDialect
spring.jpa.hibernate.ddl-auto= update

# App Properties
bezkoder.app.jwtSecret= bezKoderSecretKey
bezkoder.app.jwtExpirationMs= 86400000
```
## Run Spring Boot application
```
mvn spring-boot:run
```

## Run following SQL insert statements
```
INSERT INTO roles(name) VALUES('ROLE_USER');
INSERT INTO roles(name) VALUES('ROLE_MODERATOR');
INSERT INTO roles(name) VALUES('ROLE_ADMIN');
```
