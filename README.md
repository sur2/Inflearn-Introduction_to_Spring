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