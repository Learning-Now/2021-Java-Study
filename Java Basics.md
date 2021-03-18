# 7weeks java basics

## 자바 상속
상속은 자식이 부모로부터 무언가를 물려받는 것이다.

자바에서 상속을 사용하면 아래와 같은 장점이 있다.
- 중복된 코드를 줄일 수 있다.
- 유지 보수가 편리하다.
- 통일성이 있다.
- 다형성을 구현할 수 있다.


유의할 점
- 자식 클래스는 부모 클래스로부터 메소드와 필드를 물려받아 사용한다.
- 부모 클래스는 자식 클래스에서 정의한 메소드나 필드를 사용하지 못한다.
	- 자식 = 자신 + 부모 / 부모 = 자신
- 자식 클래스는 여러 부모 클래스로부터 상속 받지 못한다. (단일상속만 가능하다.)
- 부모 클래스는 여러 자식 클래스에게 상속이 가능하다.
- 자식 클래스가 더 다양한 기능이 가능하므로 자식 클래스로 인스턴스를 생성하는 것이 효율적이다.


- Animal.java
```java
public class Animal {
    String name;

    public void setName(String name) {
        this.name = name;
    }
}
```

- Dog.java
```
public class Dog extends Animal {

}
```

클래스 상속을 위해서는 **extends**라는 키워드를 사용한다.
```자식클래스 extends 부모클래스```

여기서 Dog 클래스는 Animal 클래스를 상속받는다.

Dog 클래스에 name이라는 객체변수와 setName이라는 메소드를 만들지 않았지만 Animal 클래스를 상속 받았기 때문에 그대로 사용가능하다.

```java
public class Dog extends Animal {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.setName("poppy");
        System.out.println(dog.name);
    }
}
```

위와 같이 main 메소드를 구현하고 실행하면 poppy라는 문자열이 출력된다.


### IS-A 관계
Dog클래스는 Animal클래스를 상속받았다. 즉, Dog는 Animal의 하위 개념이라고 할 수 있겠다. 이런 경우 Dog는 Animal에 포함되기 때문에 "개는 동물이다"라고 표현할 수 있다.

자바는 이러한 관계를 IS-A 관계라고 표현한다. 즉 "Dog is a Animal" 과 같이 말할 수 있는 관계를 IS-A 관계라고 한다.

이렇게 IS-A 관계(상속관계)에 있을 때 자식 객체는 부모 클래스의 자료형인 것처럼 사용할 수 있다.

```Animal dog = new Dog(); // 가능```
따라서 위와 같이 작성할 수 있다.

```Dog dog = new Animal() // 불가능```
하지만 위와 같이는 불가능하다.


### 메소드 오버라이딩 (Method overriding)

- HouseDog.java
```java
public class HouseDog extends Dog {
    public void sleep() {
        System.out.println(this.name+" zzz in house");
    } 

    public static void main(String[] args) {
        HouseDog houseDog = new HouseDog();
        houseDog.setName("happy");
        houseDog.sleep();
    }
}
```
HouseDog 클래스에 Dog 클래스와 동일한 형태(입출력이 동일)의 sleep 메소드를 구현하면 HouseDog 클래스의 sleep 메소드가 Dog 클래스의 sleep 메소드보다 더 높은 우선순위를 갖게 되어 HouseDog 클래스의 sleep 메소드가 호출되게 된다.

이렇게 부모클래스의 메소드를 자식클래스가 동일한 형태로 또다시 구현하는 행위를 메소드 오버라이딩(Method Overriding)이라고 한다.


### 서브 클래스/슈퍼 클래스의 생성자 호출 및 실행
new에 의해 서브 클래스의 객체가 생성될 때
- 슈퍼 클래스 생성자와 서브 클래스 생성자 모두 실행됨
- 호출 순서
	- 서브 클래스의 생성자가 먼저 호출, 서브 클래스의 생성자는 실행 전 슈퍼 클래스 생성자 호출
- 실행 순서
	- 슈퍼 클래스의 생성자가 먼저 실행된 후 서브 클래스의 생성자 실행

#### 서브 클래스에서 슈퍼 클래스의 생성자 선택
- 상속 관계에서의 생성자
	- 슈퍼 클래스와 서브 클래스 각각 여러 생성자 작성 가능
- 서브 클래스 생성자 작성 원칙
	- 서브 클래스 생성자에서 슈퍼 클래스 생성자 하나 선택
- 서브 클래스에서 슈퍼 클래스의 생성자를 선택하지 않는 경우
	- 컴파일러가 자동으로 슈퍼 클래스의 기본 생성자 선택
- 서브 클래스에서 슈퍼 클래스의 생성자를 선택하는 방법
	- super() 이용


아래는 서브 클래스의 생성자가 슈퍼 클래스의 생성자를 선택하지 않은 경우이다.

이때 컴파일러는 서브 클래스의 기본 생성자에 대해 자동으로 슈퍼 클래스의 기본 생성자와 짝을 맺는다.
```java
class A{
    public A() {
        System.out.println("constructor A");
    }
    public A(int x) {
        ...
    }
}

class B extends A {
    public B() {
        System.out.println("constructor B");
    }
}

public class ConstructorEx2 {
    public static void main(String[] args) {
        B b;
        b = new B(); // call constructor
    }
}    
```


아래는 슈퍼 클래스에 기본 생성자가 없어 오류가 난 경우이다.
```java
public class Example {
    class A {
        public A(int x) {
            System.out.println("생성자 A");
        }
    }

    class B extends A {
        public B() {
            System.out.println("생성자 B");
        }
    }

    public class ConstructorEx2 {
        public static void main(String[] args) {
            B b;
            b = new B();
        }
    }
}

```

B()에 대한 짝, A()를 찾을 수 없다. 컴파일러에 의해 implict super constructor A() is undefined. Must explicitly invoke another constructo 오류 발생.



아래는 서브 클래스의 생성자가 슈퍼 클래스의 생성자를 선택하지 않은 경우이다.

```java
public class Example {
    class A {
        public A() {
            System.out.println("생성자 A");
        }

        public A(int x) {
            System.out.println("매개변수 생성자 A");
        }
    }

    class B extends A {
        public B() {
            System.out.println("생성자 B");
        }

        public B(int x) {
            System.out.println("매개변수 생성자 B");
        }
    }

    public class ConstructorEx2 {
        public static void main(String[] args) {
            B b;
            b = new B(5);
        }
    }
}

```

```
실행결과

생성자 A
매개변수 생성자 B
```

#### super()
- 서브 클래스에서 명시적으로 슈퍼 클래스의 생성자 선택 호출
	- super(parameter);
	- 인자를 이용하여 슈퍼 클래스의 적당한 생성자 호출
	- 반드시 서브 클래스 생성자 코드의 제일 첫 라인에 와야 함


아래는 super()를 이용한 사례이다.

```java
public class Example {
    class A {
        public A() {
            System.out.println("생성자 A");
        }

        public A(int x) {
            System.out.println("매개변수 생성자 A");
        }
    }

    class B extends A {
        public B() {
            System.out.println("생성자 B");
        }

        public B(int x) {//x = 5
            super(x);
            System.out.println("매개변수 생성자 B");
        }
    }

    public class ConstructorEx2 {
        public static void main(String[] args) {
            B b;
            b = new B(5);
        }
    }
}

```


#### super
super는 자식 클래스가 부모 클래스로부터 상속받은 멤버를 참조할 때 사용하는 참조 변수이다.

 클래스 내의 멤버변수와 지역변수의 이름이 같을 경우 구분을 위해 this를 사용하듯이 부모 클래스와 자식 클래스의 멤버의 이름이 같을 경우 super를 사용한다.

this와 super는 인스턴스의 주소값을 저장하는데 static 메서드(클래스 메서드)와는 무관하게 사용된다.

```java
class JavaApp {
    public static void main(String[] args) {
        Child child = new Child();
        child.childMethod();
    }
}
 
class Parent {
    int x = 10;
}
 
class Child extends Parent {
    int x = 20;
 
    void childMethod() {
        System.out.println("x=" + x);
        System.out.println("this.x=" + this.x);
        System.out.println("super.x=" + super.x);
    }
}
```

```java
// 실행 결과

x=20
this.x=20
super.x=10
```

## 메소드 오버라이딩
부모 클래스로부터 상속받은 메소드를 자식 클래스에서 재정의하여 사용하는 것이다.

```java
class SuperClass {
    public void method (parameter 1, parameter2){
        ...
    }
}
class SubClass extends SuperClass {
    public void method (parameter 1, parameter2){
        ...
    }
}
```

메소드 오버라이딩을 위해서는 조건을 맞추어야 한다. 
- 메소드의 이름
- 리턴 타입
- 매개변수의 갯수
- 매개변수의 자료형
- 매개변수의 순서

위의 조건을 부모 클래스와 동일하게 자식 클래스에서 작성해야 한다.

**접근지정자**는 부모클래스와 동일하게 사용하지만 접근 범위를 넓게 지정할 수는 있다. (e.g. default -> public)

```java
class SuperClass {
    public void check() {
        System.out.println("부모 메소드");
    }

    public void sum(int x, int y) {
        int sum = 0;
        for (int i = x; i <= y; i++) {
            sum += i;
        }
        System.out.println("합계 : " + sum);
    }
}

class SubClass extends SuperClass {
    public void check() { // 메소드 오버라이딩
        System.out.println("자식 메소드");
    }

    public void sum(int x, int y) { // 메소드 오버라이딩
        int sum = 0, odd = 0, even = 0;
        for (int i = x; i <= y; i++) {
            sum += i;
            if (i % 2 == 0) {
                even += i;
            } else {
                odd += i;
            }
        }
        System.out.print("합계 : " + sum);
        System.out.println("(짝수 합 : " + even + " / 홀수 합 : " + odd + ")");
//		super.sum(x, y); // 부모 메소드 호출
    }
}

public class OverridingEx01 {
    public static void main(String[] args) {
        SubClass sub = new SubClass();
        sub.check();
        sub.sum(0, 10);
    }
}
```

부모 클래스에서 2개의 메소드를 정리하였고 자식 클래스에서 부모 클래스를 상속 받아 메소드를 재정의했다. main 메소드에서 자식 클래스로 인스턴스를 생성하고 메소드를 각각 호출한 결과 자식 클래스의 메소드로 데이터가 출력되는 것을 확인할 수 있다.

즉, 부모의 메소드는 은닉되고 자식 클래스의 재정의된 메소드만 호출된다. 이때 부모의 메소드를 호출하고 싶다면 ```super.메소드명```으로 호출이 가능하다.


## 다이나믹 메소드 디스패치 (Dynamic Method Dispatch)
다이나믹 메소드 디스패치는 자바의 테크닉 중 하나로 런타임에 오버라이딩 된 메소드가 실행되는 것을 의미한다.

이는 참조 타입이 부모타입인 경우에도 동작하므로 런타임 시점에 다형성을 만족하도록 할 수 있다.

```java
public class Animal {
    public void move() {
        System.out.println("Animals can move");
    }
}

public class Dog extends Animal {
    @Override
    public void move() {
        System.out.println("Dogs can walk and run");
    }
}

public class Main {

    public static void main(String[] args) {
        Animal a = new Animal(); // Animal 참조, Animal 객체
        Animal b = new Dog(); // Animal 참조, Dog 객체

        a.move(); // Animal 클래스에 정의된 메서드 실행
        b.move(); // Dog 클래스에 정의된 메서드가 실행됨(다이나믹 메소드 디스패치)
    }
}
```

```
// 결과

Animals can move
Dogs can walk and run
```

b는 Animal 타입을 참조하지만 Dog 클래스에 정의된 move 메소드가 실행된다. 

컴파일 타임에는 참조 타입만 확인하지만, 런타임에는 JVM이 객체의 타입을 파악하고 극 객체에 정의된 메소드를 실행한다.


## 추상 클래스
추상 클래스는 abstract 라는 키워드가 추가된 클래스이다. 이 클래스는 추상 메소드를 포함하고 있거나, 포함하지 않을 수 있다. 추상 클래스 자체는 인스턴스화를 할 수 없지만, 서브 클래싱을 할 수는 있습니다. 

추상 메소드는 아래와 같이 선언할 수 있다.
```java
abstract void moveTo(double deltaX, double deltaY);
```
- 유의점: 구현하지 않고 ```{}```대신 세미콜론```;```이 뒤에 붙는다.

클래스에 추상메소드가 포함된 경우에는 반드시 그 클래스는 추상클래스어야 한다.
```java
public avstract class Graphic Object {
    // field
    // ceoncrete method
    abstract void draw();
}
```
추상 클래스가 서브 클래싱 될 때, 서브 클래스는 보통 부모 클래스의 모든 추상 메소드를 구현하여 제공한다. 그러나 그렇지 않은 경우에는 역시 추상클래스라고 볼 수 있다.

interface에서 abstract 키워드를 사용하지 않는 이유는 ```default```, ```static```을 제외한 모든 메소드는 암시적으로 abstract 가 붙어있다고 판단하기 때문이다. (사용할 수 있지만 붙이지 않는다.)


## final 키워드
final 키워드는 변경불가능의 의미를 가진다. 

- 변수: 읽기 전용
- 메소드: 오버라이드 불가 
	-  생성자에서 호출되는 메소드는 final로 선언하는 편이 바람직하다. 오버라이딩으로 동작을 변경할 수 있기 때문이다.(의도치 않은 변경 방지)
- 클래스: 서브클래싱 할 수 없음 (확장 불가)


## Object 클래스
Object 클래스는 java에서 특별한 의미를 갖는 클래스이다. 모든 클래스의 직간접적 슈퍼클래스이고, ```java.lang```패키지에 존재한다.

Object 클래스는 매개변수 없는 생성자를 가지고 있다.

아래는 Object 클래스에서 상속되는 메소드이다.
- ```protected Object clone() throws CloneNotSupportedException```: 이 객체의 복사본을 만들고 반환하는 메소드이다. 예외가 발생하는 경우는 복제 불가능한 경우이다. 간단하게는 ```Cloneable```인터페이스를 구현해서 사용할 수 있다. 기본 형태는 ```native```메소드이다.
- ```public boolean equals(Object obj)```: 다른 객체와 비교해서 다른 객체와 이 객체가 같은지를 나타내는 동등성 비교를 수행한다. 내부 구현은 ```==```동일성 비교여서 오버라이딩을 해주지 않으면 기본적으로 동일성 비교를 수행한다. 이 메소드를 오버라이딩해서 동등성 비교의 기준을 마련할 수 있고, 이 메소드를 오버라이딩 할 때에는 아래의 ```hashCode()```메소드 또한 오버라이딩 해야한다.
- ```protected void finalize() throws Throwable```: 가비지 컬렉터가 객체에 대한 참조가 없는 경우 호출하는 메소드이다. 실행될지 불확실하기 때문에 중요한 코드를 여기에 두면 안 된다.
- ```public final Class getClass()```: 객체의 런타임 클래스를 호출한다. Reflection을 사요알 때, 종종 사용하게 된다.
- ```public int hashCose()```: 객체의 해시코드 값을 반환한다. 두 객체가 같으면 해시코드도 같아야하기 때문에 ```equals()```를 오버라이딩할 때 hashCode() 또한 오버라이딩 해야 한다.
- ```public String toString()```: 객체의 문자열 형태를 반환한다. 기본적으로는 거의 의미 없는 정보를 보여주기에 프로그래머는 이 메소드의 오버라이딩을 통해 객체가 유용한 정보를 반환하도록 정의해야 한다. (항상 오버라이딩을 고려해라)


오버라이딩할 수 없도록 final로 선언된 ```notify()```, ```notifyAll()```, ```wait()``` 메소드는 독립적으로 실행되는 스레드간의 동기화에 사용된다.



# Reference
- [Velog. 자바 6주차 상속](https://velog.io/@dion/%EB%B0%B1%EA%B8%B0%EC%84%A0%EB%8B%98-%EC%98%A8%EB%9D%BC%EC%9D%B8-%EC%8A%A4%ED%84%B0%EB%94%94-6%EC%A3%BC%EC%B0%A8-%EC%83%81%EC%86%8D)
