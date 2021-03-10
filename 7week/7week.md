## 자바 기초

### 학습할 것 (필수)

- 자바 상속의 특징
- super 키워드
- 메소드 오버라이딩
- 다이나믹 메소드 디스패치 (Dynamic Method Dispatch)
    - 더블 디스패치
- 추상 클래스
- final 클래스
- Object 클래스

---

### 자바 상속의 특징

- 상속이란? 현실 세계에서 쓰이는 상속이란 말에 대해 생각해 보자 부모의 자산등을 자식에게 물려주는 의미로 많이 쓰는 단어 이다. 그렇다면 이 상속이 자바에서는 어떤 식으로 쓰이는지 한번 알아보도록 하자.

 **자바에서의 상속** 

- 객체 지향 프로그램에서 상속은 비슷한 의미로 작용한다. 현실 세계 처럼 부모가 자식에게 물려주는 의미로  부모 클래스의 멤버나 메소드를 자식의 클래스에게 물려줄수있다.
- 상속을 사용함으로 공통된 특징을 가지는 클래스에서  코드 중복을 줄여주고 부모 클래스의 멤버를 재사용 하면서 자식클래스의 간결함을 유지 시켜준다.
- 클래스간의 계층적 분리를 도와줘 분류, 관리의 이점이 있다.

**상속의 특징**

- 부모 클래스 → Super class

       자식 클래스 → Sub class

- 자바는 다중 상속을 지원 하지 X → extends 뒤에는 하나의 부모 클래스만 올수 있다.
- 상속 횟수에 제한 X
- 자바의 최상위 클래스는 Object 이다. 즉 자바의 모든 클래스는 Object 의 자손

**상속 방법**

1. 상속 방법

```java
class 자식클래스 extends 부모클래스{

}
```

2. 부모 클래스

```java
public class Tv {

	String
```

3. 자식 클래스

```java
public class Samsung extends Tv {
		
	String tvType;
}
```

---

## super 키워드

- 자바에서 자식 객체를 생성하면 부모객체의 메소드나 필드 값을 사용이 가능하다 그렇다면 자식 객체 생성시 부모객체는 생성이 되는게 아닌가? 그렇지 않다 자식 객체 생성시 부모 객체가 먼저 생성되고 이후에 자식 객체가 생성된다.

**super 키워드란?**

- super 키워드는 상속관계에서 부모 클래스의 필드나 메소드를 참조하기 위해서 사용된다. ( 부모 클래스의 메소드나 필드를 자식 클래스에서 재정의 했을경우에 부모클래스를 사용하기위해 사용한다 )
- 객체가 생성되기 위해서는 생성자가 필요하다 그렇다면 자식 객체 생성시 부모 객체는 어떻게 생성이 될까?

→ 이는 개발자가 따로 부모 객체의 생성자를 자식 클래스에 지정해 놓지 않았다면 컴파일러가

```java
super() 
```

를 통해 부모의 기본 생성자를 호출한다.

- 자식 클래스에서 부모 객체의 생성자를 호출하고 싶을 시에도 같은 방법으로 작성하면 된다.

---

## 메소드 오버라이딩

- 오버 라이딩은 상속관계에서 매우 중요하다 현실 세계에서 부모에게 자산을 물려 받았다고 생각을 하면 그 자산을 자신이 원하는 방식으로 사용을 한다. 이 원하는 방식으로 사용을 도와주는게 오버라이딩이다.

**오버라이딩**

- 상속은 extends 키워드를 통해 부모 클래스의 메소드나 필드를 물려 받게된다. 이때 물려 받았으면 그 자체를 같은 방식으로 사용 할 수 있지만 보통 재정의해 사용하는 경우가 많다. 이때 부모 클래스로 부터 상속 받은 메소드를 재정의 하는걸 오버라이딩이라 한다. 이렇게 재정의를 할 경우 부모의 메소드는 은닉되고 자식의 메소드가 호출된다.

```java
 public class Tv {
	
		 public void getInfo() {
					 System.out.print("티비 입니다.");
		}
}
```

```java
public class Samsung extends Tv {

	@Override
	public void getInfo() {
		System.out.print(" 삼성 티비 ");
	}
}
```

**규칙**

1. 부모의 메소드와 동일한 형태여야한다( 리턴타입, 이름, 매개변수)
2. 접근 제한자를 더 강하게 둘수 없다.
3. 새로운 예외 금지

---

## 다이나믹 메소드 디스패치

- 메소드 디스패치? 어떤 메소드를 호출할지 결정하는 과정

**Dynamic Dispatch**

- 런타임 시점에서는 어떤 메소드를 호출해야할지 모르고 추상 타입의 메소드를 호출하는 것만 알고 있는데 할당된 객체의 타입을 보고 메소드를 결정하는 것을 의미한다.

    예를 보고 이해를 해보자

```java
public class Tv {
	public void view() {
		System.out.println("티비를 보여줌");
	}
}

public class Samsung extends Tv {
	
	@Override
	public void view() {
		System.out.println("OLED 티비를 보여줌");
	}
}

public class Main {
	public static void main(String[] args) {
		Tv tv = new Tv(); // Tv 참조 Tv 객체
		Tv samsungTv = new Samsung(); // Tv 참조, 삼성 객체
	
		tv.view(); //참조와 객체가 동일
		samsungTv.view();// 참조와 객체가 다름 (상속) => 다이나믹 메소드 디스패치
	}
}
```

- 컴파일 시에는 참조 타입만 확인하지만 런타임시 JVM 이 객체 타입을 파악해 메소드를 실행시켜준다.

**Double Dispatch**

- Dispatch 가 연속적으로 이뤄지는것을 의미한다.

    바로 예를 보도록 하자

```java
public class Test {
	public static void main (String [] args) {
		Lists<SmartPhone> phoneList = Arrays.asList(new Iphone(), new Gallaxy());
	Game game = new Game();
	phoneList.forEach(game::play);
	}
}

interface SmartPhone {
}
class Iphone implements SmartPhone {
}
class Gallaxy implements SmartPhone {
}

class Game {
	public void play(SmartPhone phone) {
		System.out.println(phone.getClass().getSimpleName());
	}
}
```

- 스마트폰을 순회 하면서 게임을 하는데 리스트 인터페이스를 타입 파라미터로 전달해서 동적 디스패치로 인한 출력 내용이 모두 달라야 한다. 그렇다면 어떻게 구현을 해야할까

```java
class Game {
	public void play(SmartPhone phone) {
		if (phone instanceof Iphone)
			System.out.println(phone.getClass.getSimpleName());
	}
		if (phone instancedof Gallaxy)
			System.out.println(phone.getClass.getSimpleName());
	}
}
```

- 이렇게 코딩을 작성하게 된다면 SmartPhone의  class 가 늘어 나게 된다면 Game 클래스를 수정해줘야한다 객체지향적이지 않다.

따라서 다음과 같은 방법으로 수정해 줘야한다

```java
public class Test {
	public static void main (String [] args) {
		Lists<SmartPhone> phoneList = Arrays.asList(new Iphone(), new Gallaxy());
	Game game = new Game();
	phoneList.forEach(game::play);
	}
}

interface SmartPhone {
	void game(Game game);
}
class Iphone implements SmartPhone {
	@Override
	public void game(Game game) {
		System.out.println(this.getClass().getSimpleName());
	}
}
class Gallaxy implements SmartPhone {
	@Override
		public void game(Game game) {
			System.out.println(this.getClass().getSimpleName());
		}
	}
}

class Game {
	public void play(SmartPhone phone) {
		phone.game(this);	
	}
}
```

- 기존 Game 클래스의 로직을 자기 Phone 자신이 처리하게 수정 했다. 이때 디스패치가 두번 발생하게 된다. play() 메소드를 찾기 위한 정적 디스패치, game() 메소드를 호출하는 객체를 찾기위한 동적 디스패치 = > 이를 더블 디스패치라 한다.

---

## 추상 클래스

- 추상 클래스란 하나 이상의 추상 메소드를 포함 하는 클래스이다. 추상 메소드의 경우 선언만 존재하고 따로 구현을 되어 있지 않다. 구현은 함수의 본체에서 하고 선언 부에 (abstract) 키워드를 넣어준다.

**추상 클래스와 일반 클래스의 차이**

- 추상 클래스는 추상 메서드를 포함하고 객체화가 불가능 하다는 점만 제외 하면 일반 클래스와 크게 다르지 않다. (즉 생성자, 멤버 변수, 일반 메서드 가질수 있음)

ex)

```java
àbstract class Tv {
	public String tvName;
	public void View() {
		System.out.println("TvOn");
	}
	abstract void getMaker();
}

class Samsung extends Tv {
	public void View() {
		System.out.println("SamsungTv on");
	}
	void getMaker() {
		System.out.println("Samsung");
	}
}
```

- 추상 메소드의 접근 지정자로는 private 불가능

 ⇒ private 지정시 다른 클래스가 상속을 받을수 없다

- 추상 클래스는 다른 클래스에서 공통으로 가져야하는 메소드를 정의해준다.
- 어떤 추상클래스를 상속 받은 자식 클래스에서 추상 메소드를 구현 하지 않았다면 자식 클래스도 추상 클래스가 되어야함.

---

## Final 클래스

- 자바에서 final의 의미는 최종적이라는 의미를 가지고 있다. ⇒ final 키워드가 붙게 된다면 프로그램 실행중 수정이 불가능 하다.

**Final 클래스란?**

- 클래스를 선언시 앞에 final 키워드를 붙이면 final 클래스가 되는데 이는 수정이 불가능한 클래스를 의미한다.
- 주로 자기가 만든 클래스를 상속이 불가능하게 하고 싶을때 사용을 한다.

**Final 메소드란?**

- 위와 동일하게 수정이 불가능한 메소드를 의마하는데 클래스에 final 이 붙지 않은경우 클래스는 상속이 가능하지만 메소드에 final이 붙어있으면 재정의가 불가능하다.

---

## Object 클래스

- 자바에서 상속은 중요한 부분을 차지한다. 우리는 상속을 하지 않았다고 생각하지만 클래스를 생성하는것 부터 이미 상속을 사용하게된다.
- 자바의 모든 클래스는 암묵적으로 Object 클래스를 상속 받고 있다. = Object 는 모든 클래스의 조상
- Object 가 지니고 있는 메소드
    1. clone()
    2. equals()
    3. finalize()
    4. getClass()
    5. hashCode()
    6. notify()
    7. toString() 
    8. wait()

---

## REFERNCE

[https://scshim.tistory.com/210](https://scshim.tistory.com/210)

[https://velog.io/@dion/백기선님-온라인-스터디-6주차-상속](https://velog.io/@dion/%EB%B0%B1%EA%B8%B0%EC%84%A0%EB%8B%98-%EC%98%A8%EB%9D%BC%EC%9D%B8-%EC%8A%A4%ED%84%B0%EB%94%94-6%EC%A3%BC%EC%B0%A8-%EC%83%81%EC%86%8D)

[https://multifrontgarden.tistory.com/133](https://multifrontgarden.tistory.com/133)

[https://studymake.tistory.com/423](https://studymake.tistory.com/423)

[https://opentutorials.org/course/1223/6241](https://opentutorials.org/course/1223/6241)