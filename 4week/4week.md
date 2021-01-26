# 4주차 과제 : 자바 코드 작성해보기

## 1. 자바 코드 실습
---
* 정리할 것
    1. 역할, 책임, 협력(객체지향의 사실과 오해) → 제일 중요한것은 메세지다
    2. vo(불변객체)
   
---
목차
* [자바 코드의 실습](#자바-코드의-실습)
	
    * 역할, 책임, 협력
    	
        * [객체 지향의 사실과 오해](#객체-지향의-사실과-오해)
        	
            * [객체 지향의 Goal](#객체-지향의-Goal)
            * [객체 지향이란?](#객체-지향이란?)
            * [객체 지향의 중요한 3가지 개념](#객체-지향의-중요한-3가지-개념)
            * [협력](#협력)
            * [책임](#책임)
            * [역할](#역할)
            * [메시지](#메시지)
            * [캡슐화](#캡슐화)
     * [VO(불변 객체)](#VO(불변-객체))
        	
* 자바 기초
	
    * [산술 연산자](#산술-연산자)
    * [비트 연산자](#비트-연산자)
    * [관계 연산자](#관계-연산자)
    * [논리 연산자](#논리-연산자)
    * [instanceof](#instanceof)
    * [assignment(=) operator](#assignment(=)-operator)
    * [화살표(->) 연산자](#화살표(->)-연산자)
    * [3항 연산자](#3항-연산자)
    * [연산자 우선 순위](#연산자-우선-순위)
    * [(optional) java13, switch 연산자](#(optional)-java13.-switch-연산자)

 
### 객체 지향의 사실과 오해

> 객체 지향의 사실과 오해에 대해 알아보려면 우선 객체 지향이 뭔지에 대해서 알아야 한다. 우리는 지금 자바 스터디를 하고있다. 자바가 객체 지향 언어라는 것은 알고있지만 객체 지향에대해 따로 생각해본적은 없었다. 그렇다면 객체 지향이란?

---

#### 객치 지향의 Goal
* 객체지향의 목표는 실제 세계를 모방하는것이 아니다. 새로운 세계를 창조하는 것이다.
	
    * 이 말에 예를 들자면 실제 세계의 커피라는 객체를 생각 해보자 ![](https://images.velog.io/images/donglee99/post/92b4d646-afde-43ab-a6a2-00210380ef54/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-20%20%EC%98%A4%ED%9B%84%2012.25.30.png) 
    * 이커피는 실제 세계의 커피 이다. 그렇다면 객체 지향에서 커피는 객체가 될수있다. 현실세계와 객체지향언어에서의 커피의 차이점은 **현실 세계의 커피는 스스로 온도를 조절 할 수 없고 양도 조절할 수 없다.** 하지만 **객체 지향에서의 커피는 스스로 온도 조절이 가능하고 양 조절도 가능하다.** 이처럼 객체 지향은 실제를 모방하는 것이 아니라 새로운 세계를 창조한다는 말이 성립이 된다.
	
    
_ 그래서 객체 지향은?_
자바를 생각하면서 객체 지향을 떠올리면 가장 먼저 떠오르는것은 클래스 이다. 비록 다른 사람의 글을 보면서 글을 적고 있지만 이 사람 처럼 수업 시간에 배웠던것 처럼 자바 => 클래스 가 공감이 된다. 우리 학교도 수업시간에 자바를 하면 클래스만 주구장창 배웠기 떄문이다.

코딩의 관점에서 본다면 클래스가 객체를 만들기위한 틀, 도구이기에 객체지향을 클래스 라고 착각할수가 있다. 객체지향의 주인공은 클래스가 아니라 객체 이다. 이 객체를 분류 하기 위한 것이 클래스 이다. 따라서 코드를 담는 클래스의 관점이 아닌 메시지를 주고 받는 객체의 관점으로 애플리케이션을 바라 보아야 한다.

---

#### 객체 지향 이란? 
* 객체 지향은 시스텀을 상호작용하는 자율적인 객체들을 공동체로 바라보고 이 객체를 이용해 시스템을 분할 하는 방법이다.
* 자율적인 객체란 스스로 자기자신의 상태와 행위를 조절 할 수있는 객체이다.
* 객체는 시스템을 구현하기위해 다른 객체와 메세지(유일한 의사소통 수단)로 협력을 한다. 각 객체는 협력 내에서 정해진 역할을 수행하며 이 역할에 대한 책임을 가지게 된다.
* 메시지를 수신한 객체는 메시지를 처리하기 위해 적합한 메서드를 스스로 선택을 한다.
* 객체는 상태와 행동을 함께 지닌 실체라고 정의를 하며 이말은 객체가 협력에 참여하기위해서는 어떤 행동을 해야한다면 그 행동을 하기위해 필요한 상태도 지녀야 한다. (객체는 상태와 행위를 함께 지니고 있음)

#### 객체 지향의 중요한 3가지 개념 
	
    1. 협력 
	2. 역할
	3. 책임
    
* 카페를 가는 것으로 위 3가지를 다뤄 보면
	
    * 카페에서 주문을 한다 = 나 ( 요청 ) 판매자 ( 응답 ) = 협력
    * 나, 판매자의 위치 = 역할
    * 나 = 구매를 한다. ,판매자 = 손님의 요청을 받고 응답을 하는 행위를 한다 = 책임
* 객체의 세계에서는 협력이라는 문맥이 객체의 행동 방식을 결정하게 된다.
* 객체지향 개발에서 가장 중요한 능력은 책임을 능숙하게 소프트웨어 객체에 할당하는것이다.

---

#### 협력 

* 특정한 책임을 수행하는 역할들 간의 연쇄적인 요청과 응답을 통해 목표를 달성한다.
(사용자가 최종적으로 인식하게 되는 시스템의 기능 = 객체들의 협력의 결과)
* 혼자만의 힘으로 해결하기 힘든 문제를 여러 사람이 함께 해결한다. 이과정에서 요청 -> 응답의 연쇄적인 흐름이 발생하게 된다. 이 요청과 응답은 협력하는 객체의 책임을 정의 하게 된다.

---

#### 책임 
* 애플리케이션의 기능은 좀 더 작은 책임으로 분할되며 책임은 적절한 역할을 수행할수 있는 객체에 의해 수행된다. ( 객체 지향 설계 = > 적절한 객체에 적절한 책임을 할당함으로 부터 시작)
**?**(그렇다면) ![](https://images.velog.io/images/donglee99/post/6034c6cf-ed9d-41a4-b817-50262ed6da49/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-26%20%EC%98%A4%ED%9B%84%2012.33.50.png) 이 질문에 나는 이렇게 생각한다 _책임이 아래 처럼 하는것을 본다면 다른 객체의 행동 시작 시키거나, 객체의 활동을 제어하고 조절 하는 것이라고 명시해 두었는데  생각해보면 이 책임을 행하는 것은 결국은 객체이다 객체가 책임을 다해 다른 객체에 메세지를 통해 요청을 하는 것이고 결국 관점에 따라 객체가 먼저 일수도있고 책임이 먼저일수도 있다 생각한다._
* 책임의 분류
	
    * 하는 것 (doing)
    	
        * 객체를 생성, 계산등의 스스로 하는 것
        * 다른 객체의 행동 시작 시키는 것
        * 다른 객체의 활동을 제어하고 조절 하는것
    * 아는 것 (knowing)
    	
        * 개인적인 정보에 대해 아는 것
        * 관련된 객체에 대해 아는 것
        * 자신이 유도하거나 계산할 수 있는 것에 대해 아는 것
        
(그냥 내 생각인데 이는 자바에서 코드를 짤때 메서드를 호출해 직접 상태를 변형 시키거나 다른 객체의 상태를 변형 시키는 것, 이때 변환 시킬 객체를 아는 것 등을 의미하는것 같다)
* 책임과 메시지
	
    * 위의 doing, knowing을 보면 자신의 상태를 변환 시키는것들도 있지만 다른 객체에 관여 하는것도 많다 이때 객체의 유일한 의사소통 수단인 메시지가 사용된다는 사실을 유추해 낼수 있다.
    * 너무 추상적인 메시지는 의도가 변형될수있으므로 구체적이여한다.
        * 추상적인 메시지에 예를 들면 "만약에 디저트를 만들어라" 라는 메세지가 있다고 하면 이에 대한 책임을 가지는 객체는 무슨 디저트를 만들어야 할지 모르게 되므로 메세지를 보낸 의도와 다른 결과가 도출될수 있다. 

---

#### 역할 
* 역할은 관련성이 높은 책임의 집합으로
	
    * 동시에 여려객체가 동일 역할을 수행 할수있다.
    * 역할은 대체 가능성을 의미한다.
    (객체의 자율성 보장이라는 성질때문이다.
    또 객체는 서로 협력을 하고 각자의 역할에 책임을 가지기 때문이다.)
    * 각 객체는 책임 수행 방법을 자율적으로 선택 가능하다.
    
---
#### 메시지 
* What/Who 사이클
	
    * 책임-주도 설계의 핵심은 어떤 행위가 필요한지 검토후 이를 수행할 객체를 결정하는 것이다.
    이과정을 What/Who 사이클이라 한다.
   * What/Who 사이클의 의미는 객체 사이의 협력 관계를 설계하기위해 어떤 행위 What를 수행할것이고 누가 수행Who 할것인가를 결정하는 것인데 이때 어떤 행위 = 메시지 이다.
   * 객체가 어떤 메시지를 수신하고 처리할 수 있는냐에 따라 객체의 책임이 결정된다.
* 묻지 말고 시켜라
	
    * 메시지 송신자는 수신자에대한 정보를 모르기 때문에 캐물을 수 없다. 단지 자신이 전송한 메시지를 잘 처리할 것이라고 믿고 전송한다.
    * 객체는 다른 객체의 상태를 묻지 말아야 한다. 객체가 다른 객체의 상태를 묻는 다는 것은 메시지 전송 이전에 객체가 가져야 하는 상태에 관해 너무 많이 고민 하고 있다는 증거이다.
* 메시지를 믿어라
	
    * 메시지는 전송 시점에 자신이 전송한 메시지를 수신할수 있다면 협력하는 객체의 종류가 무엇인지는 중요하지 않게 된다. (커피를 주문 하는 시점에 누가 주문을 받던지 상관이 없다 나는 커피만 받으면 된다)
    * 중요한것은 수신한 객체가 메시지를 정확하게 이해하고 메시지를 전송한 객체가 의도한대로 요청을 처리할 수 있는지 여부다. (커피를 받는 그 자체)
    * 메시지를 이해할 수 있다면 다양한 타입의 객체로 협력 대상을 자유롭게 교체 가능 -> 설계의 유연 (다형성)
---
#### 캡슐화 
* 객체의 자율성을 보전하기 위해 구현을 외부로 부터 감추는 것
* 객체는 상태와 행위가 함께 캡슐화 되어 충분히 협력적이고 자율적인 존재가 된다.( _간단하게 어렸을때 문방구에서 뽑기를 하면 캡슐안에 장난감이 들어있다. 이 캡슐은 안에 장난감을 보호하기위한 케이스 같은 역할이였다. 이처럼 객체 지향 언어에서도 객체를 보호, 보전을 위해 캡슐과 같은 케이스로 객체를 감쌌다고 생각하면 쉽다_ )
	
    * 상태와 행위의 캡슐화
    	
        * 객체는 상태와 행위의 조합으로 객체자체가 상태와 행위를 하나의 단위로 묶는 자율적인 실체가 된다 이를 데이터 캡슐화 라고 칭한다.
    * 사적인 캡슐화
    	
        * 객체는 외부의 객체가 자신의 내부를 제어, 관찰이 불가능하게 막는다.

---
#### Reference
* [객체지향의 사실과 오해](https://jongmin92.github.io/2019/02/10/Programming/object_oriented_facts_and_misunderstandings/)
* [객체지향의 사실과 오해 정리](https://jheloper.github.io/2020/02/object-oriented-facts-and-misunderstandings-01/)
* [TIL/객체지향의 사실과 오해](https://github.com/cheese10yun/TIL/blob/master/OOP/객체지향의사실과오해.md#협력)
---
### VO(불변 객체)

> Immutable Object란? 객체 지향 프로그래밍에서 불변 객체는 생성후 그 상태를 바꿀수 없는 객체를 의미한다. 당연히 반대인 가변 객체도 있다. 가변 객체로 생성후 불변객체로의 변환도 가능하다. 객체의 전체가 불변인 경우도 있고, C++에서 Const 데이터 멤버 처럼 일부 속성만 불변인 경우도 있다. 또 경우에 따라서는 내부 속성이 변화 해도 외부에서 그 객체의 상태가 변하기 않는다고 보이면 불변 객체로 보기도 한다. 불변 객체를 사용시 복제나 비교를 위한 조작을 단순화 할수 있으며, 성능 개선에 도움을 준다. 하지만 객체가 변경이 가능한 데이터를 많이 가지고 있다면 오히려 부적적할 경우가 있다.

#### 자바에서의 Immutable Class 
* 자바에서의 Immutable Class 는 String, Boolean, Integer, Float, Long 등등이 있다. 이 클래스들은 Heap 영역에서 변경이 불가능 한거지 재할당을 못하는 것은 아니다.
``` java
String str = "abc";
str = "cba";
```
위 코드 처럼 재할당이 가능하다. = str 이 처음에 "abc" 를 참조했는데 이 값이 "cba" 로 바뀌는 것이아니라 "cba"라는 새로운 객체가 생기고 그 객체를 str 이 재참조 하는것이다. 이때 "abc" 는 아무도 참조를 하고있지 않게 된다.

_그렇다면 계속 str에 재할당을 한다면 객체가 생성된채로 낭비가 된다는 것인데 이는 어떻게 처리하는게 옳은 방법일까?_

* String vs String Builder
	
    * String Builder 는 String 과 다르게 mutable 하기 때문에 변경을 하더라고 새로운 객체를 만들지 않고 기존 할당된 값을 수정 한다. 즉 문자열 변경과 연산을 하는 경우 기존의 버퍼 크기를 늘리거나 줄이면서 유연한 동작이 가능하게 된다.


* 불변 클래스의 예
``` java
class ImmutableClass {
	private final int age;
    private final String name;
    
    public ImmutableClass(int age, String name) {
    	this.age = age;
        this.name = name;
    }
}

```
위의 코드는 외부에서 수정이 불가능한 불변 객체가 된다.
불변 객체가 된 가장 큰이유는 멤버 변수를 private final로 선언하고 setter를 구현하지 않았기 때문이다.


``` java
class MutableClass {
	public  int age;
    public  String name;
    
    public MutableClass(int age, String name) {
    	this.age = age;
        this.name = name;
    }
}

```
위 코드는 외부에서 수정이 가능하므로 불변 객체가 X

#### Immutable Object 만들기

* Immutable Object 를 만들때 기본적으로는 필드에 final을 사용하고 Setter를 구현 하지않는다.
이는 불변객체의 필드가 모두 원시 타입일 경우에만 가능하고, 참조 타입일 경우엔 추가적인 작업이 필요하다.

** 원시타입만 있는 경우 **
``` java
public class BaseObject {
    private int value;
    
    public BaseObject(final int value) {
    	this.value = value;
    }
    
    public void setValue(int new Value) {
    	this.value = newValue;
    }
}

```
* 위의 객체는 불변 객체가 아니다 setter 도 존재하고 필드도 final로 선언되어있지 않다.
필드에 원시 타입만 있으므로 이는 final 키워드로 불변 객체로 만들수 있다.

``` java
public class BaseObject {
    private final int value;
    
    public BaseObject(final int value) {
    	this.value = value;
    }

}

```

* 위의 코드는 final과 setter 의 삭제로 불변 객체로 만들어 주었다. 따라서 위 객체의 value 를 변경하기 위해서는 재할당 하는 방법 밖에 없다.

** 참조 타입이 있는 경우 **
* 참조 타입이 있는 경우는 final을 사용하고 setter를 작성하지 않는 것으로 불변 객체를 만들수 없다.

``` java
public class Animal {
    private final Age age;
    
    public Animal(final Age age) {
    	this.age = age;
    }
    
    public Age getAge() {
    	return age;
    }
}
class Age {
    
    private int value;

    public Age(final int value) {
        this.value = value;
    }

    public void setValue(final int value) {
        this.value = value;
    }
    
    public int getValue() {
    	return value;
    }
}

```
* 위 Animal 클래스는 final 을 사용하고 Setter 를 구현하지 않았지만 불변 객체가 아니다 그이유는 클래스 필드인 Age 값이 변경이 가능하기 때문이다. 따라서 Animal 클래스가 불변 객체가 될려면 Age 클래스도 불변 객체가 되어야 한다. 즉 참조 변수도 불변 객체 여야 한다.
** Array 경우 **
```java
public class ArrayObject {

    private final int[] array;

    public ArrayObject(final int[] array) {
        this.array = Arrays.copyOf(array,array.length);
    }


    public int[] getArray() {
        return (array == null) ? null : array.clone();
    }
}
```
* 배열의 경우 생성자에서 배열을 받아 copy해서 저장 했고 getter를 clone 으로 반환하게 하면 불변객체로 만들수있다. (배열을 그대로 참조 or 그대로 반환시 내부 값이 변경될수도있다.)
* **List 경우**
List의 경우에도 Array와 동일하게 생성시에 생성자 인자를 그대로 참조 하지않고 새로운 List를 만들어 값을 복사해야한다. (Getter를 이용한 수정을 막기 위해 ```collection.unmodifiableList```를 사용
```java
  import java.util.Collections;
  import java.util.List;

  public class ListObject {

      private final List<Animal> animals;

      public ListObject(final List<Animal> animals) {
          this.animals = new ArrayList<>(animals);
      } // this.animals에 새롭게 리스트를 만들어 대입

      public List<Animal> getAnimals() {
          return Collections.unmodifiableList(animals); //getter방지
      }
  }

```
---
#### Reference
* [java Immutable Object(불변객체)](https://velog.io/@conatuseus/Java-Immutable-Object불변객체)


<br>
<br>

## 자바 기초
---

### Goal
> 자바가 제공하는 다양한 연산자를 학습하자.

* 연산자 : 어떠한 기능을 수행하는 기호
* 피연산자 : 연산자의 작업 대상( 변수, 상수, 리터럴, 수식)

_ 주의_ : 우선순위가 같은 연산자들은 연산의 진행 방향에 따라 연산순서가 정해짐
![](https://images.velog.io/images/donglee99/post/68fa0df1-c74b-414f-bcf7-69f4eb341b23/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-20%20%EC%98%A4%ED%9B%84%208.29.59.png)

---

### 산술 연산자

* 산술 연산자는 가장 많이 사용하는 연산자로 수식 계산에 사용되는 연산자 이다.
  <table>
    <tr>
    <th>구분</th>
    <th>연산자</th>
    <th>의미</th>
    </tr>
    <tr>
      <td>
      </td>
      <td>
        +
      </td>
      <td>
        더하기
      </td>
    </tr>
    <tr>
      <td>
      </td>
      <td>
        -
      </td>
      <td>
        빼기
      </td>
    </tr>
     <tr>
      <td>
              산술 연산자
      </td>
      <td>
        *
      </td>
      <td>
        곱하기
      </td>
    </tr>
     <tr>
      <td>
      </td>
      <td>
        /
      </td>
      <td>
        나누기
      </td>
    </tr>
     <tr>
      <td>
      </td>
      <td>
        %
      </td>
      <td>
        나머지 값 구하기
      </td>
    </tr>
  </table>
  
🏳️ int 보다 크기가 작은 타입은 int로 변환
* byte, char, short -> int

🏳️ 피연산자 중 표현범위가 큰 타입으로 형변환
  * byte + short -> int + int = int
  * char + int -> int + int = int


1. 사칙연산자 (+, -, /, *)
	
     ```java
    int a = 1000000;
    int b = 1000000;
    long c = a * b;
    System.out.println(c);
   	// -727379968
    ```
    * 이는 int 의 연산이 진행된후 long으로 자동형변환이 되면서 쓰레기 값이 대입되어서 그렇다. 바른 결과를 얻을려면 long형에서 연산을 진행 했어야 한다.
    ```java
    
    char c = 'a' + 1;
    System.out.println(c);
   	// b
    ```
    * 위 코드는 a가 아스키 코드 값으로 변환되어 +1 연산을 수행후 다시 char 로 변환이(컴파일러에 의한 자동변환) 진행되어 값이 b 가 나오게 된다. 하지만 만약 
    ```java
    char c = 'a'
    char c1 = c + 1;
    System.out.println(c);
  	// 오류
    ```
    * 이처럼 대입후 연산을 하게 되면 컴파일러가 미리 계산을 할수 없게 되어 오류가 발생하게 된다.
2. 나머지 연산자 (%)
	
    * 나머지 연산자는 왼쪽의 피연산자들을 오른쪽 피연산자로 나눈후 나머지 값을 리턴하는 연산자 이다. (주로 홀수, 짝수, 배수검사에 사용)
    ```java
    int a = 5;
    int b = 3;
    int c = a % b;
    System.out.println(c);
   	// 2
    ```
    
3. 쉬프트 연산자 ( <<. >>, >>>)

   * 쉬프트 연산자는 정수형 변수에만 사용 가능하다. 피연산자의 각 자리를 오른쪽 또는 왼쪽으로 이동한다 해서 쉬프트 연산자로 이름이 붙여졌다.
   * ```<<``` 연산자 : 피연산자의 부호에 상관없이 자리를 왼쪽으로 이동시키면서 빈칸을 0 으로 채움
   * ```>>``` 연산자 : 오른쪽으로 이동 시키기 때문에 음수인 경우 부호를 유지 시켜주기 위해서 음수인 경우 빈자리 1로 채움
   * ``` >>> ``` 연산자 : 부호에 상관없이 항상 0 으로 빈자리를 채움
 _ 모두 두개의 피연산자를 가짐 ( 이항연산자 )_



---

### 비트 연산자
* 비트 연산자 (&, |, ^)
	
    * 비트 연산자는 말 그대로 이진 비트 연산을 수행한다.
    * 실수형 float, double 을 제외한 모든 기본형에 사용이 가능하다.
* OR(|)연산자
	
    * 피연산자 중 어느 한쪽이 1 이면 결과는 1이다.
* AND(&)연산자
	
    * 피연산자 둘 모두 1이여야 결과가 1이다.
* XOR(^)연산자
	
    * 피연산자가 서로 다를 경우에 결과 1이다.
    <table>
    <tr>
      <th>
        x
      </th>
      <th>
        y
      </th>
      <th>
        x|y
      </th>
      <th>
        x&y
      </th>
      <th>
        x^y
      </th>
    </tr>
    <tr>
      <td>
        1
      </td>
      <td>
        1
      </td>
      <td>
        1
      </td>
      <td>
        1
      </td>
      <td>
        0
      </td>
    </tr>
     <tr>
      <td>
        1
      </td>
      <td>
        0
      </td>
      <td>
        1
      </td>
      <td>
        0
      </td>
       <td>
         1
       </td>
    </tr>
     <tr>
      <td>
        0
      </td>
      <td>
        1
      </td>
      <td>
        1
      </td>
      <td>
        0
      </td>
       <td>
         1
       </td>
    </tr>
     <tr>
      <td>
        0
      </td>
      <td>
        0
      </td>
      <td>
        0
      </td>
      <td>
        0
      </td>
       <td>
         0
       </td>
    </tr>
   </table>
   
* 이 표를 보면 좀더 이해가 편하다.
![](https://images.velog.io/images/donglee99/post/7fb466eb-67a2-4311-8768-05d7dd1d0e73/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-20%20%EC%98%A4%ED%9B%84%209.10.50.png)

---

### 관계 연산자
* 관계 연산자 ( >, <, >=, <=, ==, != )
	
    * 비교 연산자라고도 부르며 부등호라 생각하면 쉽다.
    * 관계 연산자의 결과는 boolean 값으로 반환되며 나는 산술연산자보다 관계 연산자를 더 자주 사용하는것 같다. (주로 조건문과 함께 많이 사용한다)
    *
    ![](https://images.velog.io/images/donglee99/post/dcd6a3c2-5452-4cd3-ad9c-c68c7710567a/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-20%20%EC%98%A4%ED%9B%84%209.17.36.png)
    * ex) 
    ```java
    int a = 3;
    int b = 4;
    if ( a < b ) {
     System.out.println(true);
     } else {
     System.out.println(false);
     }
     // true
    ``	

---

### 논리 연산자

* 논리 연산자 (&&, ||) 
	
    * 논리연산자는 피연산자로 boolean 형 또는 boolean 형 값을 결과로 하는 조건식만을 허용한다.
* OR(||)연산자 
	
    * 피연산자중 한쪽이 true 면 true 이다
* AND(&&)연산자
	
   * 피연산자 두 쪽 모두 true 여야 true   
&nbsp;_1학년때부터 정말 많이 봐온 연산자지만 아직도 가끔 헷갈린다_
 <table>
    <tr>
      <th>
        x
      </th>
      <th>
        y
      </th>
      <th>
        x||y
      </th>
      <th>
        x&&y
      </th>
    </tr>
    <tr>
      <td>
        true
      </td>
      <td>
        true
      </td>
      <td>
        true
      </td>
      <td>
        true
      </td>
    </tr>
     <tr>
      <td>
        true
      </td>
      <td>
        false
      </td>
      <td>
        true
      </td>
      <td>
        false
      </td>
    </tr>
     <tr>
      <td>
        false
      </td>
      <td>
        true
      </td>
      <td>
        false
      </td>
      <td>
        true
      </td>
    </tr>
     <tr>
      <td>
        false
      </td>
      <td>
        false
      </td>
      <td>
        false
      </td>
      <td>
        false
      </td>
    </tr>
   </table>
* ex) 
```java
    char x = 'j';
    if ( (x >= 'a' && x<= 'z') {
    	System.out.println("유효");
    } else {
    	System.out.println("유효X");
    }
    // 유효
    
```

---

### instanceof

* instanceof( 참조 연산자 )
	
    * 참조변수가 참조하고 있는 인스턴스의 타입을 알아보기 위해(간단하게 객체의 타입을 알아보기 위한) 주로 사용하며 조건문과 함께 사용된다. (주로 부모 객체인지 자식 객체인지 확인할때 쓴다)
    * instanceof 의 왼쪽 피연산자로는 참조변수, 오른쪽 피연산자에는 타입(클래스명)이 피연산자로 위치한다. 이때 결과 값은 boolean값으로 반환된다. (true = 참조변수(왼쪽)가 검사한 타입(오른쪽)으로 형변환이 가능하다는 뜻)
    * Ex)
    ```java
    class A{}
    class B extends A{}
    class instanceofEx01 {
    
      public static void main(String[] args) {
          A a = new A();
          B b = new B();

          System.out.println("a instanceof A : " + (a instanceof A));
          System.out.println("b instanceof A : " + (b instanceof A));
          System.out.println("a instanceof B : " + (a instanceof B));
          System.out.println("b instanceof B : " + (b instanceof B));
      }
   }
   // a : 부모
   // b : 자식
   // true
   // true
   // false
   // true
   
   ```
    

---


### assignment(=) operator
* 대입 연산자 (assignment operator)
	
    * 대입 연산자는 변수에 값을 할당할때 사용되는 이항 연산자 이다. 피연산자들의 결합 방향은 오른쪽에서 원쪽이다.
    <table>
  	<tr>
      <th>
        대입 연산자
      </th>
      <th>
        설명
      </th>
    </tr>
  	<tr>
      <td>
        =
      </td>
      <td>
        왼쪽의 피연산자에 오른쪽 피연산자 대입
      </td>
    </tr>
    <tr>
        <td>
          +=
        </td>
        <td>
          왼쪽의 피연산자에 오른쪽의 피연산자를 더한후, 그 결과 값을 왼쪽의 피연산자를 대입
        </td>
      </tr>
    <tr>
        <td>
          -=
      </td>
        <td>
          왼쪽의 피연산자에 오른쪽의 피연산자를 뺀후, 그 결과 값을 왼쪽의 피연산자를 대입
        </td>
    </tr>
    <tr>
        <td>
          *=
        </td>
        <td>
          왼쪽의 피연산자에 오른쪽의 피연산자를 곱한후, 그 결과 값을 왼쪽의 피연산자를 대입
        </td>
    </tr>
  <tr>
        <td>
          /=
        </td>
        <td>
          왼쪽의 피연산자에 오른쪽의 피연산자를 나눈후, 그 결과 값을 왼쪽의 피연산자를 대입
        </td>
    </tr>
  <tr>
        <td>
          %=
        </td>
        <td>
          왼쪽의 피연산자에 오른쪽의 피연산자를 나눈후, 그 나머지 값을 왼쪽의 피연산자를 대입
        </td>
    </tr>
  <tr>
        <td>
          &=
        </td>
        <td>
          왼쪽의 피연산자에 오른쪽의 피연산자와 비트 & 연산후, 그 결과 값을 왼쪽의 피연산자를 대입
        </td>
    </tr>
  <tr>
        <td>
          |=
        </td>
        <td>
          왼쪽의 피연산자에 오른쪽의 피연산자와 |연산후, 그 결과 값을 왼쪽의 피연산자를 대입
        </td>
    </tr>
  <tr>
        <td>
          ^=
        </td>
        <td>
          왼쪽의 피연산자에 오른쪽의 피연산자와 ^연산후, 그 결과 값을 왼쪽의 피연산자를 대입
        </td>
    </tr>
  <tr>
        <td>
          <<=
        </td>
        <td>
          왼쪽의 피연산자에 오른쪽의 피연산자만큼 왼쪽 시프트 후, 그 결과 값을 왼쪽의 피연산자를 대입
        </td>
    </tr>
  <tr>
        <td>
          >>=
        </td>
        <td>
          왼쪽의 피연산자에 오른쪽의 피연산자만큼 부호 유지 오른쪽 시프트후, 그 결과 값을 왼쪽의 피연산자를 대입
        </td>
    </tr>
  <tr>
        <td>
          >>>=
        </td>
        <td>
          왼쪽의 피연산자에 오른쪽의 피연산자만큼 부호에 상관없이 오른쪽 시프트 후, 그 결과 값을 왼쪽의 피연산자를 대입
        </td>
    </tr>
  	</table>

---


### 화살표(->) 연산자
> 람다함수란? 프로그래밍 언어에서 사용되는 개념으로 익명함수를 지칭한다. 람다 대수는 이름이 필요가 없다.

** 익명 클래스란? **
* 익명 클래스는 클래스의 instantiation과 동시에 클래스를 정의하는 클래스를 의미하며 특정 클래스가 여러번 호출 되지 않거나, 클래스 내부에 필드나 여러개의 메소드를 정의할 필요가 있을때 익명 클래스로 정의해 사용한다.
* 익명 클래스의 특징으로는 new 를 사용하고 instantiation시 파라미터가 없다.

* 화살표 연산자는, 익명함수라고 불리는 람다식의 등장으로 사용되는 연산자다.(자바 8 버전부터 사용한다 한다)
* 기본 형태 
```(매개변수목록) -> { 함수몸체 }```
* ex) 
```java
        // Thread - traditional
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World.");
            }
        }).start();
	
```
	를 람다식으로 변형 하면
```java
// Thread - Lambda Expression
new Thread(()->{
	System.out.println("Hello World.");
}).start();
```
	처럼 변형시킬수 있다. 이 처럼 람다식을 사용하게 되면 코드의 간결성이 높아지고 가독성이 높아지게 된다.

---


### 3항 연산자

* 삼항 연산자 = 조건 연산자
  ```java
if () {
    
  } else if {
            
  }
    
  ```
  * 위 코드 처럼 if 문을 사용하게 되면 코드가 길어지는 경우가 많다. 코드가 길어지게 되면 가독성이 떨어지게 되고 결국 이해하기 힘들어지는 단점이 생기게 된다. 이를 해결하기 위해 삼항연산자를 사용해 보자. ( _개인적으로 삼항연산자를 별로 접해보지 못해서 차라리 코드가 길면 길지 삼항연산자로 보면 더 이해가 안간다_ )
  * 기본 형태 ```(boolean) ? c(true일경우) : d(false일경우)```
  * ex) 
  ```java
 	int a = 1;
    int b= (a == 1) ? 1 : 0;
    // a가 1일 경우 1반환 false 일 경우 0 을 b 에 대입;
 ```
 == 
 ```java
 int a = 1;
 int b = 0;
 if ( a == 1) {
 	b = 1;
 } else {
 	b = 0;
 }
 ```

---



### (optional) java 13. switch 연산자
* switch 연산자
	
    * 스위치 연산자라 하면 기존의 자바 문법의 switch 를 생각 할것이다. 
    * 기존의 스위치문은 break 를 걸지 않으면 자신이 속한 case 를 진행후 스위치 문을 탈출 하지 않고 다음 case 를 거치게 된다.
    ```java
    switch (day) {
    	case Monday:
        	break;
        case Friday:
        case Sunday:
    }
    ```
    위 코드의 문제점은 break 문으로 인해 오류가 나는 경우가 많다는 점이다. 실제 학교 과제를 할때에 break 문을 잘못 걸어두어 오류가 발생하는 경우도 많았고 디버깅을 하는 과정에 코드 가독성이 떨어서 쉽게 찾지 못해 수정하는데 시간이 많이 소요되는 경우가 많았다.
    * 이를 해결하기 위해 자바 12에서는 switch문에 ->연산자를 사용할수 있게 되었다.
    ```java
    switch (day) {
    	case Monday ->  numDay = 1: 
        case Friday -> numDay =2:
        case Sunday -> numDay =3:
    }
    ```
    case 의 label 이 매칭이 되면 -> 이후 코드를 실행하고 switch문을 탈출하게 된다.
    * 그렇다면 자바 13에서는 무엇이 추가가 된것인가?
    자바 13에서는 12에서 break를 사용해 반환을 하던 방식에서
    yield 를 사용해 반환 하는 방식으로 바꼈다.
    **자바 12**
    ```java
    switch (day) {
    	case Monday:
        	break 1; 
        case Friday -> numDay =2:
        case Sunday -> numDay =3:
    }
    ```
    **자바 13**
    ```java
    switch (day) {
    	case Monday:
        	yield 1; 
        case Friday -> numDay =2:
        case Sunday -> numDay =3:
    }
    ```


---

### Reference
* [세바의 코딩 교실](https://programmer-seva.tistory.com/9?category=615256)
* [문돌이의 it](https://improver.tistory.com/140)



