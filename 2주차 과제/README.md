# 1. 자바 코드 실습
## 1-1. 단축키 정리
### Code Edit
- Ctrl + Shift + F10 : main 메소드 실행
- Ctrl + d : 줄 복사
- Ctrl + y : 줄 제거
- Ctrl + Shift + j : 하위 줄과 연결
- Ctrl + Shift + 방향키(↕) : 줄 이동

### Focus Edit
- Ctrl + 방향키 : 단어별 이동
- Ctrl + Shift + 방향키(↔) : 단어별 선택
- Home, End : 라인 첫/끝 이동
- Shift + Home + End : 라인 전체 선택
- Page Up/Down : Page Up, Page Down
- F2 : 오류 라인으로 자동 포커스

### Find
- Ctrl + f : 현재 파일에서 검색
- Ctrl + r : 현재 파일에서 교체
- Ctrl + Shift + f : 전체에서 검색
- Ctrl + Shift + r : 전체에서 교체
- Ctrl + Shift + n : 파일 검색
- Ctrl + Shift + Alt + n : 메서드 검색
- Ctrl + Shift + a : Action 검색
- Ctrl + e : 최근 열었던 파일 목록 보기
- Ctrl + Shift + e : 최근 수정한 파일 목록 보기

### 자동완성
- Ctrl + Space : 기본 자동완성
- Ctrl + Shift + Space : 스마트 자동완성
- Ctrl + Space + Space : static method 자동완성
- Alt + Insert : getter/setter/생성자 자동완성
- Ctrl + i : Override method 자동완성

### Refactor
- Ctrl + Alt + v : 변수 추출하기
- Ctrl + Alt + p : 파라미터 추출하기
- Ctrl + Alt + m : 메서드 추출하기
- F6 : inner 클래스 추출하기
- Shift + F6 : 이름 일괄 변경하기
- Ctrl + Shift + F6 : 타입 일괄 변경하기
- Ctrl + Alt + o : Import 정리하기
- Ctrl + Alt + l : 코드 자동 정렬하기

### Debug
- Ctrl + F8 : Break Point 걸기 
- Shift + F9 : Debug모드로 실행하기(이전 실행문 재실행)
- F9 : 다음 Break Point로 넘어가기
- F8 : 다음 라인으로 넘어가기
- F7 : 해당 라인 안의 다음 메서드로 들어가기
- Shift + F8 : 현재 포커스를 밖으로 빼기
- Alt + F8 : 현재 Breaking 상태에서 즉시 코드 실행하기

## 1-2. Live template 정리
### main + Tab
```java
public static void main(String args[]){
}
```

### pvsm + Tab
```java
public static void main(String args[]){
}
```

### sout + Tab
```java
System.out.println();
```

### St + Tab
```java 
String
```

### fori + Tab
```java
for (int i = 0; i < ; i++) {
}
```

# 2. 자바 기초
## 2-1. JVM이란 무엇인가
JVM이란 JAVA Virtual Machine, 자바 가상 머신의 약자를 따서 줄여 부르는 용어이다.
JVM 역할은 자바 애플리케이션을 클래스 로더를 통해 읽어 들여 자바 API와 함께 실행하는 것이다.
그리고 JVM은 JAVA와 OS사이에서 중개자 역할을 수행하여 JAVA가 OS에 구애받지 않고 재사용을 가능하게 해준다.
그리고 가장 중요한 메모리관리, Garbage collection을 수행하며 JVM은 스택기반의 가상머신이다.

## 2-2. 컴파일 하는 방법
1. Program.java 파일이 있는 디렉토리 경로로 이동
2. 컴파일 - javac 명령을 이용해서 .java파일을 컴파일 하여 .class 실행파일을 생성
3. 실행파일(.class)을 실행

## 2-3. 실행하는 방법
1. 프로그램이 실행되면 JVM은 OS로부터 이 프로그램이 필요로 하는 메모리를 할당받는다.
2. 자바 컴파일러(javac)가 자바 소스코드(.java)를 읽어들여 자바 바이트코드(.class)로 변환시킨다.
3. Class Loader를 통해 class파일들을 JVM으로 로딩한다.
4. 로딩된 class파일들은 Execution engine을 통해 해석된다.
5. 해석된 바이트 코드는 Runtime Date Areas에 배치되어 실질적인 수행이 이루어지게 된다.

## 2-4. 바이트코드란 무엇인가
자바 가상 머신이 이해할 수 있는 언어로 변환된 자바 소스코드를 의미한다.
자바 컴파일러에 의해 변환되는 코드의 명령어 크기가 1바이트라서 자바 바이트코드라고 불리며
이러한 자바 바이트 코드의 확장자는 .class이다. 자바 바이트코드는 자바 가상 머신만 설치되어 있으면
어떤 운영체제에서라도 실행 될 수 있다.

## 2-5. JIT 컴파일러란 무엇이며 어떻게 동작하는가
인터프리터 방식의 단점을 보완하기 위해 도입된 컴파일러이다. 인터프리터 방식으로 실행하다가 
적절한 시점에 바이트코드 전체를 컴파일하여 네이티브 코드로 변경하고, 이후에는 더 이상 인터프리팅
하지 않고 네이티브 코드로 직접 실행하는 방식이다. 네이티브 코드는 캐시에 보관하기 때문에 한 번 컴파일된 코드는 빠르게 수행하게 된다.
물론 Jit 컴파일러가 컴파일하는 과정은 바이트코드를 인터프리팅 하는 것보다 훨씬 오래걸리므로
한 번만 실행되는 코드라면 컴파일하지 않고 인터프리팅 하는 것이 유리하다. 따라서 Jit 컴파일러를 사용하는
JVM들은 내부적으로 해당 메서드가 얼마나 자주 수행되는지 체크하고, 일정 정도를 넘을 때에만 컴파일을 수행한다.

## 2-6. JVM 구성 요소
### Class Loader
JVM내로 클래스(.class파일)을 로드하고, 링크를 통해 배치하는 작업을 수행하는 모듈이다.
Runtime 시에 동적으로 클래스를 로드한다. jar 파일 내 저장된 클래스들을 JVM 위에 탑재하고 
사용하지 않는 클래스들은 메모리에서 삭제한다. 

### Execution Engine
클래스를 실행시키는 역할이다. 클래스 로더가 JVM 내의 런타임 데이터 영역에 바이트 코드를 배치시키고,
이것은 실행엔진에 의해 의해 실행된다. 자바 바이트코드는 기계가 바로 수행할 수 있는 언어보다는 비교적 인간이
보기 편한 형태로 기술된 것이다. 그래서 실행 엔진은 이와같은 바이트 코드를 실제로 JVM 내부에서 기계가 실행할 수 있는
형태로 변경한다.

### Interpreter
실행엔진은  자바 바이트 코드를 명령어 단위로 읽어서 실행한다. 하지만 이 방식은 인터프리터 언어의 단점을 그대로 갖고 있다.
한 줄씩 수행하기 때문에 느리다는 것이다.

### JIT compiler 
2-5 참고.

### Garbage Collector
동적으로 할당된 메모리 중 사용되지 않는 메모리를 반환한다.
실행 시기는 JVM이 OS에 메모리를 추가적으로 요청했을 때 실행되고, 
24시간 내내 돌아가는 서버 프로그램의 경우, JVM이 한가한 시점에 실행된다.

### Runtime Data Area
프로그램을 수행하기 위해 OS에서 할당받은 메모리 공간

## 2-7. JDK와 JRE의 차이

![](https://t1.daumcdn.net/cfile/tistory/99342B425C11E80C15)

### JDK
| JDK(Java Development Kit) : 자바 프로그래밍 시 필요한 컴파일러 등 포함
- JDK는 개발을 위해 필요한 도구(javac, java등)들을 포함한다.
- JDK를 설치하면 JRE도 같이 설치된다.
- 즉 JDK = JRE + @ 라고 생각하면 된다.

### JRE
| JRE(Java Runtime Enviroment) : 컴파일된 자바 프로그램을 실행시킬 수 있는 자바 환경
- JRE는 JVM이 자바 프로그램을 동작시킬 때 필요한 라이브러리 파일들과 기타 파일들을 가지고 있다.
- JRE는 JVM의 실행환경을 구현했다고 할 수 있다.
- 자바 프로그램을 실행시키기 위해선 JRE를 반드시 설치해야한다.
- 하지만 자바 프로그래밍 도구는 포함되어있지 않기 때문에 자바 프로그래밍을 하기 위해선 JDK가 필요하다.

