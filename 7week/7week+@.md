### **자바 문자열**

### **업캐스팅(upcasting) vs 다운캐스팅(downcasting)**

### **인터페이스(interface)**

---

## 자바 문자열

# JAVA String 클래스 정리

> String 클래스

- 스트링은 자바에서 Char 타입의 불편함을 해소 시켜주는 매우 편리한 존재이다. 그럼 이 편리한 클래스가 어떤 형식으로 구현되어있는지 살펴보자.

![https://images.velog.io/images/donglee99/post/caf2ec2d-2d66-432f-85d0-8fd6c20fddd0/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-03-07%20%EC%98%A4%ED%9B%84%204.19.45.png](https://images.velog.io/images/donglee99/post/caf2ec2d-2d66-432f-85d0-8fd6c20fddd0/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-03-07%20%EC%98%A4%ED%9B%84%204.19.45.png)

- 위처럼 스트링 클래스 내부를 까보면 결국은 Char 배열로 생성된 불변 객체 값이다.

---

**스트링 클래스 선언** 

- 스트링은 원시 타입처럼 보여서 원시타입으로 착각 할 수 있다. 하지만 스트링은 원시타입이 아니며 참조형 객체 클래스이다. 또한 불변 객체로 동일한 객체가 공유되면서 사용된다 이는 뒤에 예시로 확인 해보겠다.
- 스트링 클래스는 2가지의 선언 방법이 있다.
    1. 리터럴
    2. new 를 사용한 선언

**리터럴** 

```
String text = "text";

```

**New** 

```

String text = new String("text");

```

둘다 print 를 해보면 값은 똑같이 나온다 하지만 둘은 분명한 차이가 있다.

☝️ 리터럴로 선언된 String 클래스는 선언시 객체가 String constant pool 에 저장이되는 반면 new 는 Heap 영역에 저장이 된다. 다음 예를 보자

```

String text = new String("text");
String text2 = "text";

System.out.print(text == text2); // false

```

💁 ** false 가 나오는 이유가 뭘까? **
위에서 언급한 리터럴과 new 의 선언 시 저장되는 객체의 위치 때문이다. `text` 과 `text2` 의 값은 모두 text 라는 값을 가지고 있다. 하지만 객체가 다르다 `text` `String constant pool` 에 저장된 객체를 갖고 있고 `text2`는 `Heap` 영역에 저장되어있는 객체이다 따라서 1차적으로 객체가 다르기 때문에 단순비교인 `==` 로는 두 객체의 값을 비교할수는 없다.

```

String text = "text";
String text2 = "text";

System.out.print(text == text2); // true

```

💁 ** true 가 나오는 이유가 뭘까? **
이는 `text` 생성시 `string constant pool`에 "text" 값을 지닌 `String` 객체 하나가 생성된다. 이후 `text2` 생성시 `String` 클래스는 불변 객체이기 때문에 미리 `intern()` 메서드에서 탐색이 되어 미리 생성된 객체가 공유되어 단순 비교인 == 에 true 값이 나오게 된다.

🤔 **intern() 은 뭐지?**

간단하게 설명하면 String constant pool 에서 문자열을 조회하여 존재시 그 객체를 반환, 아닐 경우 등록 하는 메서드다 = 이를 통해 불변객체가 가지는 동일한 객체를 공유할 수 있는 특징을 사용할수 있고 동일한 객체가 하나만 생기게 할수도 있다.

---

## equals

- 위에서 단순 비교를 통해 비교를 값을 비교시 원하는 결과가 안나오는 경우가 많았다. String 객체를 비교시 == 보다는 equals 를 많이 사용한다.

    ![https://images.velog.io/images/donglee99/post/9ab1eb84-6a08-4f2c-9907-a022ae3a8996/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-03-07%20%EC%98%A4%ED%9B%84%204.59.01.png](https://images.velog.io/images/donglee99/post/9ab1eb84-6a08-4f2c-9907-a022ae3a8996/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-03-07%20%EC%98%A4%ED%9B%84%204.59.01.png)

- equals 의 코드를 보면 equals 는 String 객체의 Value 값 자체를 비교하는 것을 볼수있다. 이점이 단순 비교와 가장 큰 차이점이고 String 객체 비교시 equals 를 많이 사용하는 이유이다.

```

String text = new String("text");
String text2 = "text";

System.out.print(text == text2); // false
System.out.print(text.equals(text2); // true

```

- 다음과 같은 비교에서 단순비교는 false 값이 반환되고 equals 를 사용한 비교시는 true 값이 반환되는 이유가 Value 값을 비교하냐 객체의 주소값을 비교하냐 차이이다.

---

## 이 외의 메소드 들

 **length();**

- 문자열의 길이 반환 (int)

```

String text = new String("text");

System.out.print(text.length()); // 4

```

**isEmpty();** 

- 객체의 value가 비어있는지 아닌지 반환 (boolean) (string = ""; 시 비어있다고 판단)

```

String text = new String("text");

System.out.print(text.isEmpty()); // false

```

- * indexOf(); **
- 해당 문자의 위치를 int 로 반환 (존재 X 경우 -1 반환)

```

String text = new String("text");

System.out.print(text.indexOf(t))); // 1

```

- * substring(); **
- 인덱스를 자를때 사용한다

```

String text = new String("text");

System.out.print(text.substring(0,2)); // te

```

- * replaceAll(); **
- 문자열 교체

```

String text = new String("text");

System.out.print(text.replaceAll("text", "word"); // word

```

- * split(); **
- 문자열을 파라미터 기준으로 찢어 String 형 배열로 반환

```
	String str2 = "apple,banana,orange";
	String[] array1 = str2.split(",");
	System.out.println(Arrays.toString(array1));

	[apple, banana, orange]

```

---

## 업 캐스팅과 다운 캐스팅

**업 캐스팅**

- 캐스팅 ⇒ 타입 변환
- 업캐스팅?
    - 자바는 자식 클래스가 부모의 클래스의 필드값, 메소드를 상속 받는다. ⇒ 자식 클래스가 부모 클래스로 취급을 할 수 있다.
    - 이때 업 캐스팅이란 자식 클래스의 객체가 부모 클래스 타입으로 형변환이 되는것을 의미한다.

        예로 Tv ← 삼성Tv 

```java
class Tv {
	String tvName;
	String id;
	
	public Tv(String tvName) {
		this.tvName = tvName;
	}
}
class Samsung extends Tv {
	String type;
	
	public Samsung(String tvName) {
		super(tvName);
	}
}
```

- 위의 코드를 보면 Samsung 클래스는 Tv 의 상속을 받아 Tv의 tvName 멤버에 값을 할당 하고 있다.

```java
public class Main {
	public static void main (String [] args) {
		Tv tv;
		Samsung samsung = new Samsung("samsungTv");
		tv = samsung;

		System.out.println(tv.tvName); //정상
		System.out.println(tv.type); // 컴파일 오류
```

- 다음과 같이 사용할때 부모 클래스에 자식 클래스를 할당하고 부모 클래스를 건드는건 문제가 발생하지 않는다 하지만 자식클래스의 멤버나 메소드를 건들경우에 문제가 발생하게 된다. ( Samsung의 인스턴스가 사라지는건 아님)

**다운 캐스팅**

- 자식 클래스가 부모 클래스로 변환 됐을 시 자식 클래스는 잠시 가려진다 이때 다시 자식 클래스를 원래대로 되돌릴때 사용한다.
- 다운 캐스팅으로 자식클래스로 되돌릴경우 타입을 명시해야 한다.

```java
public class Main {
	public static void main (String [] args) {
		Tv tv;
		Samsung samsung = new Samsung("samsungTv");
		tv = samsung;
		samsung = (Samsung)tv;
```

---

## 인터페이스

- 자바에서의 인터페이스 역할
- 개발자 사이의 코드 규약
- 공통적인 메소드나 필드를 추상화
- 추상 메서드의 모음 ( 구현부가 없는 메소드의 모음 )

![https://s3-us-west-2.amazonaws.com/secure.notion-static.com/f96b09b7-83ed-4d7d-afde-abc027241913/_2021-03-13__12.37.18.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/f96b09b7-83ed-4d7d-afde-abc027241913/_2021-03-13__12.37.18.png)

☝️ 인터페이스 내에서 필드 멤버를 선언 하기 위해서는 public static final 로 선언 해야함!

☝️구현부가 없다 → 사용시 구현을 해야한다, 인터페이스 내에 있는 모든 메소드를 구현해주어야 한다.

☝️ 인터페이스를 사용하게 되면 자바에서 단일 상속 밖에 하지 못하는 단점을 해소시켜주어 다중 상속이 가능하게 해준다.

![https://s3-us-west-2.amazonaws.com/secure.notion-static.com/d77e7ea3-998f-4187-94d8-9167031b1772/_2021-03-13__12.39.55.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/d77e7ea3-998f-4187-94d8-9167031b1772/_2021-03-13__12.39.55.png)

**인터페이스와 상속의 차이**

- 다형성을 활용하기 위해 자바에서는 상속과 인터페이스를 사용한다. 둘중 뭘 사용할지는 개발자의 몫이고 판단을 도와주는 기준은 다음과 같다
1. 상속 보다는 위임을 사용하다.
2. 다형성을 위한 것이라면 클래스 상속보다 인터페이스 구현을 하라.
- 대부분은 상속을 추천하지 X, 상속시 변화가 발생하는 순간 상속 구조가 깨질 우려가 있으며 이때 발생하는 비용도 어마어마 하다.

---

## reference

[https://velog.io/@codemcd/인터페이스Interface](https://velog.io/@codemcd/%EC%9D%B8%ED%84%B0%ED%8E%98%EC%9D%B4%EC%8A%A4Interface)

[https://kutar37.tistory.com/entry/자바-String-클래스의-메소드](https://kutar37.tistory.com/entry/%EC%9E%90%EB%B0%94-String-%ED%81%B4%EB%9E%98%EC%8A%A4%EC%9D%98-%EB%A9%94%EC%86%8C%EB%93%9C)[https://www.latera.kr/blog/2019-02-09-java-string-intern/](https://www.latera.kr/blog/2019-02-09-java-string-intern/)

[https://lbmmbl.tistory.com/29](https://lbmmbl.tistory.com/29)