# 자바 기초
## CQRS
> CQRS는 Command and Query Responsibility Segregation(명령과 조회의 책임 분리)을 나타낸다. 이름처럼 시스템에서 명령을 처리하는 책임과 조회를 처리하는 책임을 분리하는 것이 CQRS의 핵심이다.

<img src = "https://blog.nebrass.fr/wp-content/uploads/cqrs-simple-diagram-886x1024.png" height="500">

- 명령(Command) : 시스템의 상태를 변경하는 작업
	- ex) 주문 취소, 배송 완료
- 쿼리(Query) : 시스템의 상태를 반환하는 작업
	- ex) 주문 목록
- 책임(Responsibility) : 구성 요소의 역할
	- 구성 요소 : 클래스, 함수, 모듈/패키지, 웹서버/DB

- 분리(Segregation) : 역할에 따라 구성 요소 나누기

### 명령과 조회에 단일 모델을 사용한다면?
🔍 명령과 쿼리가 다루는 데이터가 다르기 때문에 이도 저도 아닌 잡탕이 된다.
- 코드 역할/책임 모호
- 의미/가독성 등 나빠짐
- 유지보수성이 떨어짐
	- 명령과 쿼리는 코드 변경 빈도/사용자가 다르기 때문
	- 기능마다 요구하는 성능이 다르기 때문



