# CQRS

---

## CQRS 란?

- Command and Query Responsibility Segregation (명령과 조회의 책임 분리) 의 약자이며 이름 처럼 시스템의 명령을 처리하는 책임 / 조회를 처리하는 책임 분리

💁 명령 : CQRS 에서 시스템의 상태를 변경하는 작업

💁 조회 : CQRS 에서 시스템의 상태를 반환하는 작업

간단하게 CRUD ⇒ CUD / R

---

## 🤔 CQRS이 왜 생겨났는가?

- 전통적인 CRUD 아키텍쳐 기반에서 application 은 운영하다 보면  Domain Model 의 복잡도가 점점 증가 하고 이에 따라 유지 보수의 Cost 도 높아지며 Domain Model 의 변질까지 생기는 경우가 있다.

- 이에 DDD(Domain Model Design) 의 문제점을 해결하기 위해 CQRS가 생겨 나게 됐다.

---

## CQRS 예시

![https://s3-us-west-2.amazonaws.com/secure.notion-static.com/3d67082a-3273-4dd6-9096-89f51eeeaeb7/_2021-03-22__11.05.42.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/3d67082a-3273-4dd6-9096-89f51eeeaeb7/_2021-03-22__11.05.42.png)

- 위 그림은 CQRS 가 적용되지 않은 애플리케이션의 모델이다. 이는 간단한 애플리케이션에는 적합하지만 복잡해 질수록 위에서 말했던 문제점이 발생되게 된다.
    - 모양이 다른 DTO 의 반환
    - 병렬작업시 경합 발생
    - 정보 검색을 위한 쿼리의 복잡성으로 성능 저하
    - 각 엔티티가 읽기 및 쓰기 작업의 대상이 되어 잘못된 데이터 노출

**CQRS 적용시**

![https://s3-us-west-2.amazonaws.com/secure.notion-static.com/06c4bda0-0818-4ff7-b5c8-946e62fa02aa/_2021-03-22__11.25.12.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/06c4bda0-0818-4ff7-b5c8-946e62fa02aa/_2021-03-22__11.25.12.png)

- Read / Write 분리
- 명령 데이터 중심이 아닌 작업 기반
- 명령 동기 X 비동기
- 쿼리가 데이터 베이스 수정 X

읽기 저장소는 쓰기 저장소의 읽기 전용 복제본이거나 읽기 및 쓰기 저장소가 전혀 다른 구조일수 있다. 

![https://s3-us-west-2.amazonaws.com/secure.notion-static.com/d2d90f98-1bc8-4c86-be49-f6c86e55581c/_2021-03-22__12.36.04.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/d2d90f98-1bc8-4c86-be49-f6c86e55581c/_2021-03-22__12.36.04.png)

읽기 전용 복제본을 여러개 사용하면 읽기 전용 복제본이 응용 프로그램 인스턴스에 가까운 위치에 있는 분산 시나리오에서 쿼리 성능을 향상 시킬수 있다.

CQRS의 일부 구현에서는 이벤트 소싱 패턴 ( 각 이벤트의 변경에 대한 값을 저장 해놓는 집합 도메인은 현재 상태만 기록함 )을 사용한다. 이는 다른 구성요소를 알리는데 동일한 이벤트를 사용할수있다는 이점을 가지고 있고 쿼리보다 효과적이다. But 복잡성을 추가하게 된다.

---

## ? 그렇다면 CQRS 언제 사용을 할까

- 여러 사용자가 동일한 데이터를 동시에 엑세스하는 공동작업시
- 복잡한 도메인 모델을 사용하는 프로세스를 구현할때
- 데이터의 성능을 데이터 쓰기의 성능과 별도로 세부적으로 조정해야 할때
- 개발자가 쓰기, 읽기에 각각 집중을 할때

**권장 하지 않는 경우**

- 도메인, 비즈니스 규칙이 간단할때
- 간단한 CRUD 스타일로 작업이 충분할때

---

## Reference

[https://code-masterjung.tistory.com/80](https://code-masterjung.tistory.com/80)

[https://www.popit.kr/cqrs-eventsourcing/](https://www.popit.kr/cqrs-eventsourcing/)

[https://justhackem.wordpress.com/2016/09/17/what-is-cqrs/](https://justhackem.wordpress.com/2016/09/17/what-is-cqrs/)