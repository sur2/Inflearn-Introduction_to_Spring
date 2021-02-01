# Inflearn-Introduction_to_Spring
[인프런] 김영한님의 스프링 입문 - 코드로 배우는 스프링 부트, 웹 MVC, DB 접근 기술



## 알아가는 것

- 컨트롤러에서 리턴 값으로 문자를 반환하면 뷰 리졸버(viewResolver)가 화면을 찾아서 처리한다.
  - 스프링 부트 템플릿엔진 기본 viewName 매핑
  - ``resources:templates/`` + (ViewName) + ``.html``



- Gredle Project Build 하는 법(bash shell) (windows cmd의 경우 ``./``를 제외)
  - gradlew가 있는 경로에서 명령어: ``./gradlew build``
  - 삭제 명령어: ``./gradlew clean`` or ``./gradlew clean build``
    삭제 시 주의 할 것! build 폴더를 삭제하기 때문에 다른 프로세스가 build 폴더를 사용해서는 안됨!
  - ``./build/libs``의 jar 실행 명령어: ``java -jar`` + (jar 파일명) +  ``.jar`` 
  



- @ResponseBody가 달린 컨트롤러의 메서드는 정적, 동적 웹 페이지가 아닌 객체(.json)를 반환한다.
  - ViewResolver에 가지 않는다.
  - HttpMessageConverter의 Defualt는 json이지만 xml로 반환 할 수 있다.



- Optional<T>
  - `` return Optional.ofNullable(Object);`` 객체가 Null이면 Null을 반환, 그렇지 않으면 객체를 반환
  - `.stream().findAny();`



- AtomicLong, ConCurrentHashMap



- JUnit @Test
  - ``Assertions.assertThat(object01).isEqualTo(object02)``: object01과 object02를 hashcode를 비교한다.
  - 테스트는 실행은 코드 순서를 보장 받지 못 한다. 즉, 테스트 메서드가 끝나면 데이터를 Clear 해주어야 한다.
    - 테스트는 서로 순서, 의존관계 없이 설계되어야 한다.
  - @AfterEach는 @Test 실행이 단위마다 끝날 때 마다 실행된다.
    - 반대로 @Test 실행 전에 작업을 실행 할 수 있는 @BeforeEach 또한 존재한다.
  - 원하는 클래스를 테스트 할 때는  Class를 선언한 곳에서 Create Test를 하면 된다.(Windows 기준 ``Ctrl`` + ``Shift`` + ``T``)
  - 테스트 메서드는 한글로 적어도 무방하다.
  - 테스트 기법: givne, when, then 패턴
    - given: 무언가 주어졌을 때
    - when: 이 것을 실행 했을 때
    - then: 결과로 나와야 할 것
  



- 여러 곳에서 하나의 객체를 사용할 때는 스프링 컨테이너에 빈으로 등록한다.
  - 즉, 싱글톤으로 등록된다. 그러나 설정을 통해 싱글톤이 되지 않도록  사용할 수 있다.



- HTTP 메서드는 form 태그 하위 input 태그의 name 속성과 스프링 컨트롤러의 파라메터에 해당하는 클래스의 인스턴스 변수와 매칭됨



- Controller에서 Model 객체를 파라메터로 View에게 넘겨 줄 수 있다.



- JDBC
  1. DataSource
     1. Connection (DB 연결)
     2. PreparedStatement (Qurey)
     3. ResultSet (결과반환)



- @SpringbootTest
  - 테스트 시 스프링 컨테이너와 함께 실행된다.



- @Transactional
  - Query 후  Commit이 되어야 트랜잭션이 발생됨
  - 트랜잭션을 롤백해버린다면? Query 하기 전으로 돌아간다.
  - Test 할 때 `@Transaction`를 사용하면 트랜잭션을 롤백하기 때문에 다음 Test 시 DB에 영향을 주지 않는다.



- 단위 테스트 vs 통합 테스트
  - 단위 테스트: 각 서비스 별 자바 코드 테스트가 더 나은 테스트 일 수 있다.
  - 복합 테스트: 스프링 컨테이너를 실행하여 복합적인 테스트가 필요할 수 도 있다.



- 스프링 JdbcTemplate
  - Jdbc API의 반복적인 부분을 제거할 수 있다. 





## 객체지향 설계 원칙 SOLID

### SOLID - SRP



### SOLID - 개방폐쇄 원칙(Open-Closed Principle)

​	확장에는 열려있고, 수정, 변경에는 닫혀있다.

- 스프링의 DI(Dependency Injection)을 사용하면 **기존의 코드를 전혀 손대지 않고, 설정만으로 구현 클래스를 변경** 할 수 있다. 







## 스프링 빈을 등록하는 2가지 방법

### 1. 컴포넌트 스캔과 자동 의존관계 설정

- ``@Component`` 에노테이션이 있으면 스프링 빈으로 자동 등록된다.
  - ``@Contoller``, ``@Service``, ``@Repository``은 ``@Component``를 가지고 있다.
- ``@ComponentScan``은 ``@Component``를 자동으로 스프링 빈에 등록하기 때문이다.

### 2. 설정 파일을 통해 직접 등록하는 방법

- 1. ``@Configuration`` 선언된 클래스를 ComponentScan할 수 있는 경로에 정의한다.
  2. ``@Bean``을 스프링빈에 등록할 개체를 반환하는 함수에 선언한다.
- 이 방법으로 ``@Service``, ``@Repository``을 대체할 수 있다.
- 스프링 빈에 등록할 객체가 정형화 되지 않거나, 상황에 따라 구현 클래스를 변경해야 할 때 이 방법을 사용한다.



### 의존성 주입(Dependency Injection)에는 필드 주입, setter 주입, 생성자 주입이 있다.

- `@Autowired`를 사용하여 의존성을 주입할 수 있다.(생성자 주입일 경우 생성자가 하나이면 `@Autowired`생략 가능)

#### 의존관계가 실행중에 동적으로  변경하는 경우는 거의 없으므로 생성자 주입을 권장한다.

- setter 주입의 경우 접근지정자가 public이기 때문에 의도치 않은 변경 등이 문제가 된다.



## 알아야 할 것

- JUnit Test
  - (org.junit.jupiter.api.Assertions) Assertions.assertThat 
  - (org.assertj.core.api.Assertions) Assertions.assertThrow