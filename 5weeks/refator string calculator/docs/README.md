# 문자열 계산기
- 정수를 입력 받아 사칙연산을 수행한다.

## 기능 요구사항
- 정수를 입력 받아 사친연산을 수행한다.
- 실수가 아닌 수를 피연산자로 입력할 경우에는 예외처리를 한다.
    - 실수가 아닌 수를 입력했음을 사용자에게 알릴 것.


## 객체 책임(아는 것과 하는 것)

### 입력
- 아는 것
    - 입력 값
    

- 하는 것
    - 입력 값 저장

### 연산
- 아는 것
    - 입력
    

- 하는 것
  - 연산처리


### 출력
- 아는 것


- 하는 것
    - 최종 연산 값 출력
    

### 예외처리
- 아는 것


- 하는 것
    - 나누기 0 에러 캐치
    - 피연산자 위치에 숫자가 아닌 입력이 오는 것 처리
    

## 구현할 기능

### 메인 화면
- [ ] 객체 모델링
- [ ] 메인화면 출력
- [ ] 보장된 숫자 입력
    - 보장된 숫자(실수와 Q만을 허용)
    - 보장된 숫자가 아닐 시 에러 출력
        - ```에러 발생. 입력값 : OOO```
    - 연산을 진행하기 위해 값을 버리고 다시 입력을 받음
- [ ] Q가 입력될 시, 종료
    
### 값 계산
- [ ] 연산을 수행
    - 연산 과정에서 어떤 수를 0으로 나눌 경우 에러 출력
        - ```에러 발생. 0으로 나눌 수 없습니다.```
    - 연산을 진행하기 위해 값을 버리고 다시 입력을 받음
    
- [ ] 최종 연산값을 출력


### 에러가 발생해도 서비스가 멈추지 않아야 한다

- [ ] 에러 핸들링