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



## 스프링 빈을 등록하는 2가지 방법

### 컴포넌트 스캔과 자동 의존관계 설정

- ``@Component`` 에노테이션이 있으면 스프링 빈으로 자동 등록된다.
  - ``@Contoller``, ``@Service``, ``@Repository``은 ``@Component``를 가지고 있다.
- ``@ComponentScan``은 ``@Component``를 자동으로 스프링 빈에 등록하기 때문이다.



## 알아야 할 것

- JUnit Test
  - (org.junit.jupiter.api.Assertions) Assertions.assertThat 
  - (org.assertj.core.api.Assertions) Assertions.assertThrow