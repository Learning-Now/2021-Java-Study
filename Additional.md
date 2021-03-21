# Additional study
## Enum class란?
기존에는 final static String과 같은 방식으로 상수를 정의했지만 이는 문제가 발생하기 쉽다.

Enum은 열거형이라고 불리며, 서로 연관된 상수들의 집합을 의미한다.

## enum의 장점
- 코드가 단순해진다.
- 가독성이 높아진다.
- 인스턴스 생성과 상속을 방지하여 상수값의 타입 안정성이 보장된다.
- enum class를 사용해 새로운 상수들의 타입을 정의함으로 정의한 타입이외의 타입을 가진 데이터값을 컴파일시 체크한다.
- 키워드 enum을 사용하기 때문에 구현의 의도가 열거임을 분명히 할 수 있다.

```java
public class EnumExample {
 
       //기존에 상수를 정의하는 방법
    public static final String MALE = "MALE";
    public static final String FEMALE = "FEMALE";
    public static void main (String[] args) {
        String gender1;
         
        gender1 = EnumExample.MALE;
        gender1 = EnumExample.FEMALE;
         
        //MALE, FEMALE이 아닌 상수 값이 할당 될 때 
        //컴파일시 에러가 나지 않음. -> 문제점 발생.
        gender1 = "boy";
         
         
        Gender gender2;
        gender2 = Gender.MALE;
        gender2 = Gender.FEMAL;
         
        //컴파일 시 의도하지 않는 상수 값을 체크할 수 있음.
        //Enum으로 정의한 상수값만 할당 받을 수 있음.
        gender2 = "boy";
         
    }
     
}
//enum class를 이용해 Gender라는 새로운 상수들의 타입을 정의한다.
enum Gender {
    MALE,FEMAL;
}
```

- 기존의 상수 정의 방법에 따른 정의
```java
public static final String MALE = "MALE";
public static final String FEMALE = "FEMALE";
```

그리고 ```String gender1;``` 을 통해 우리가 정의한 상수타입과 같은 String 타입의 변수 gender1을 선언한다.

static 키워드를 통해 인스턴스없이 상수를 사용할 수 있도록 MALE, FEMALE 을 정의했기 때문에 아래와 같이 gender1의 각각 원하는 상수를 할당할 수 있다.
```java
gender1 = EnumExample.MALE;
gender1 = EnumExample.FEMALE;
```

하지만 이 코드는 ```gender1 = "boy";``` 와 같이 기대하지 않은 상수값이 할당될 수 있다. 이 유효성을 검사하는 로직이 들어가 있지 않다면, 런타임에러가 발생할 것이며, 엉뚱한 결과값을 얻을 수 있다.

이 문제를 해결하기 위해 enum을 활용할 수 있다.
```java
enum Gender {
    MALE,FEMALE;
}
```
위의 코드를 보면 enum을 통해 Gender라는 상수타입을 정의했다.
```java
Gender gender2;
```
gender2가 Gender 타입이기 때문에 다음과 같이 Gender타입인 MALE, FEMALE을 할당할 수 있다.
```java
gender2 = Gender.MALE;
gender2 = Gender.FEMALE;
```
여기서 enum class의 인스턴스를 따로 생성하지 않고 바로 MALE, FEMALE에 접근했다.

이것은 생략된 것으로 아래의 class와 같다.
```java
class Gender{
    public static final Gender MALE = new Gender();
    public static final Gender FEMALE = new Gender();
}
```

static이 생략되었을 뿐 엄연히 enum class안에 정의된 상수들은 static 변수 효과를 나타낸다.

여기에 아까처럼 ```gender2 = "boy";```실수로 값을 잘못 할당했을 경우다.

gender2라는 타입은 Gender라는 상수타입인데 String타입인 boy를 할당하려하면 컴파일에러가 발생된다.

즉, 컴파일시 우리가 기대하지 않은 상수값의 할당을 사전에 체크할 수 있는 것이다.


## Enum class
- Enum class는 다른 클래스와 마찬가지로 별도의 java파일, 클래스 안, 클래스 밖에서 선언이 가능하다.

### Enum class 사용하기

```java
public class Developer {
    public String name;
    public int career;
    public DevType type;

    public static void main(String[] args) {
        Developer developer = new Developer();
        
        developer.name = "홍길동";
        developer.career = 3;
        developer.type = DevType.WEB;

        System.out.println("개발자 이름: " + developer.name);
        System.out.println("개발자 경력: " + developer.career);
        System.out.println("직무파트  : " + developer.type);
    }
}

enum DevType{
    MOBILE, WEB, SERVER
}
```

```
//결과
개발자 이름: 홍길동
개발자 경력: 3
직무파트  : WEB
```


## Enum 메소드
<table>
<tr><td rowspan="3">Static Methods</td>
    <td>valueOf(String arg)</td>
    <td>String 값을 enum에서 가져옴. 값이 없으면 예외 발생</td></tr>
    <tr><td>valueOf(Class&lt;T&gt;class, String arg</td>
    <td>넘겨받은 class에서 String을 찾아, enum에 가져옴. valueOf(String arg)는 내부적으로 자기자신 Class를 가져옴.</td></tr>
    <tr><td>values()</td>
    <td>enum의 요소들을 순서대로 enum타입의 배열로 리턴. (ENUM$VALUES)의 카피임으로 자주 호출하지 않는 것을 권장</td></tr>
<tr><td rowspan="4">non Static Methods</td>
    <td>name()</td>
    <td>호출된 값의 이름을 String으로 리턴.</td></tr>
    <td>ordinal()</td>
    <td>해당 값이 enum에 정의된 순서를 리턴.</td></tr>
    <td>compareTo(E o)</td>
    <td>enum과 지정된 객체의 순서를 비교. 지정된 객체보다 작은 경우, 음의 정수를, 동일하면 0을, 크면 양의 정수 리턴.</td></tr>
    <td>equals(Object other)</td>
    <td>지정된 객체가 enum 정수와 같은 경우, true를 리턴.</td></tr>
</table>

enum class가 기본적으로 제공해주는 메소드를 이용해 다양하게 처리할 수 있다.

생성자를 private로 막아야 다른 곳에서 인스턴스를 생성해 동적으로 변화시킬 수 없게 막을 수 있다.








# Reference
- [티스토리. Enum이란?](https://limkydev.tistory.com/50)
- [티스토리. Enum의 사용법](https://limkydev.tistory.com/66)
- [Velog. 자바 Enum 기본 및 활용](https://velog.io/@kyle/%EC%9E%90%EB%B0%94-Enum-%EA%B8%B0%EB%B3%B8-%EB%B0%8F-%ED%99%9C%EC%9A%A9)
- [티스토리. 자바 enum클래스 (열거형 enumeration type)](https://mine-it-record.tistory.com/204)
- [티스토리. java 함수형 인터페이스 (Functional Interface)](https://inma.tistory.com/151)
- [Velog. Java Stream](https://velog.io/@gillog/Java-Stream-Class)
- [html 꺾쇠(<>), &기호 쓰기](http://mwultong.blogspot.com/2006/10/html-css-less-than-greater-than-sign.html)