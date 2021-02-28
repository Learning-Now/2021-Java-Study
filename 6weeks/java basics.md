# java class

## class
OOP에서 모든 데이터를 객체(object)로 취급하며, 이러한 객체가 프로그래밍의 중심이 된다.

사물 하나 하나를 기능별로 묶어서 사용하는 것. 각 클래스 안에서 역할에 따라 각 클래스의 기능을 서술해 나감.

사람에 따라, 같은 프로그램을 만들더라도 여러 관점으로 만들 수 있다.

자바에서는 어떤 것이든 클래스 안에 속해있다.
```
public class <class-name> {
    public static void main(Stirng[] args){
    // 프로그램 시작 지점
    }
}
```

### class의 구조
#### 멤버변수(field)
- 클래스 안의 기능을 끄집어 내어 사용할 때 이용.
- 저장할 공간

#### 메소드(method)
- 기능을 나타낸다.
- ()가 항상 붙어 있다.

#### 생성자(constructor)
처음에 값을 넣어줄 때 사용.(default value)


```
public class ClassName {

    // 멤버변수
    int a;
    int b;

    // constructor
    ClassName() {
        a = 10;
        b = 15;
    }

    // method
    public static void main(String[] args) {
        // 프로그램 시작 지점
    }
}
```

아래와 같이 멤버 변수에 static을 붙여줄 경우, 메모리를 정적으로 사용하겠다는 의미. 메모리 주소 위치가 바뀌지 않는다.
> staic int a = 10;

### instance
자바에서 클래스를 사용하기 위해서는 우선 해당 클래스 타입의 객체(object)를 선언해야 한다.

이렇게 클래스로부터 객체를 선언하는 과정을 클래스의 인스턴스 화라고 한다.

또한, 이렇게 선언된 해당 클래스 타입의 객체를 인스턴스(instance)라고 한다. 

> 인스턴스란 메모리에 할당된 객체를 의미한다

자바에서는 하나의 클래스로부터 여러 개의 인스턴스를 생성할 수 있다.

이렇게 생성된 인스턴스는 독립된 메모리 공간에 저장된 자신만의 필드를 가질 수 있다. 

하지만 해당 클래스의 모든 메소드(method)는 해당 클래스에서 생성된 모든 인스턴스가 공유한다.


### class 선언(declaration)
자바는 객체를 만들기 위해 반드시 클래스를 먼저 만들어야 한다. 클래스는 객체를 만들기 위한 일종의 틀이다.
- 붕어빵: 객체
- 붕어빵 틀: 클래스

```
// Car class declaration
public calss Car { }
```

```
// Car object
public class CarExam {
    public static voi main(String[] args) {
        Car c1 = new Car();
        Car c2 = new Car();
    }
}
```

- new 연산자는 new 연산자 뒤에 오는 생성자를 이용해 메모리에 객체를 만들라는 명령.
- 메모리에 만들어진 객체를 인스턴스(instance)라고도 한다.
- 이렇게 만들어진 객체를 참조하는 변수가 c1, c2 이다.
- 위의 코드가 실행되면 Car라는 객체가 2개 만들어지고 각각의 객체를 참조하는 c1과 c2변수가 선언된다.


## new operator
해당 클래스 타입의 인스턴스(객체)를 생성해주는 역할을 담당한다. 

new 연산자를 통해 메모리(Heap area)에 데이터를 저장할 공간을 할당 받고 그 공간의 참조값(reference value/hash code)를 객체에게 반환해 주고 이어서 생성자를 호출한다. 인스턴스를 다루기 위해서는 new 연산자를 통해 참조값을 저장한 객체로만 접근이 가능하다.

- 형태
> ClassName referenceVariable = new ClassName();

- 인스턴스(객체)를 생성할 때 사용하는 코드이다.
- 객체 변수가 실제 데이터가 아닌 참조 값을 갖는다는 정보가 포함돼 있다.

```
class NewExSub {
    public void sum(int a, int b){ // int a=0, int b=20;
        int sum=0, odd=0, even=0; // 초기값 설정
        for(int i=a; i<=b; i++){
            sum += i; // 총합 합계
            if(i%2==0){
                even += i; // 짝수합
            }else{
                odd += i; // 홀수합
            }
        }
        System.out.println(a+"~"+b+"까지의 합:"+sum);
        System.out.println(a+"~"+b+"까지의 짝수합:"+even);
        System.out.println(a+"~"+b+"까지의 홀수합:"+odd);
    }
}

public class NewEx01 {
    public static void main(String[] args) {
        NewExSub nes = null; // NewExSub 타입의 nes 객체 선언
        nes = new NewExSub(); 
        // new : 인스턴스 생성, Heap 메모리 공간 할당, 객체(nes)에게 참조값 리턴
        System.out.println(nes); // 출력 : @15db9742(참조값)
        nes.sum(0, 20); // 객체 참조값 이용 NewExSub의 sum메소드 호출 / 매게변수 전달
    }
}
```

## method declaration
### 매개변수도, 리턴하는 것도 없는 형태의 메소드
- 리턴하는 것이 없을 경우 리턴 타입은 void로 작성한다.
```
public class MyClass{
    public void method1(){
        System.out.println("method1이 실행됩니다.");
    }
}
```

### 정수를 받아들인 후, 리턴하지 않는 메소드
- 받아들이는 값은 어떤 타입이라도 상관없다.
- 받아들이는 값의 수는 여러 개일 수 있다. 여러 개일 경우 콤마(,)로 구분한다.
```
public class MyClass{   
    public void method2(int x){
        System.out.println(x + " 를 이용하는 method2입니다.");
    }
}
```

### 아무것도 받아들이지 않고, 정수를 반환하는 메소드
- 리턴하는 값 앞에 return이라는 키워드를 사용한다.
- 메소드 이름 앞에는 리턴하는 타입을 적어준다.
- 리턴타입은 하나만 사용할 수 있다. 리턴하는 타입은 어떤 타입이라도 상관없다.
```
public class Test {
    public int method3(){
        System.out.println("method3이 실행됩니다.");
        
        return 10;
    }
}

```

### 정수를 2개 매개변수로 받고, 아무것도 반환하지 않는 메소드
```
public class Test {
    public int method4(int x, int y){
        System.out.println(x + ", " + y + "를 이용하는 method4입니다.");
    }
}
```

### 정수를 한 개 받은 후, 정수를 반환하는 메소드
```
public class Test {
    public int method5(int y){
        System.out.println(y + "를 이용하는 method5입니다.");
        
        return 5;
    }
}
```

## constructor declaration
생성자는 new 연산자를 통해서 인스턴스를 생성할 때 반드시 호출이 되고 제일 먼저 실행되는 일종의 메소드(메소드와는 조금 다르다)이다.

생성자는 인스턴스 변수(e.g. field)를 초기화 시키는 역할을 한다.

- 생성자 선언 방법
```
public Class(parameter) {
    ...
}
```

Class라는 부분은 생성자를 정의하는 클래스의 이름과 동일하게 적어줘야 한다. public과 parameter부분은 필수가 아니다.

### default constuctor
```
public class ConstructorEx01{
    // public ContructorEx01() { } // default constructor 자동 생성


    public static void main(String[] args) {
        ConstructorEx01 ce = new ConstructorEx01; // 인스턴스 생성 및 생성자 호출
    }
}
```

위와 같은 경우에는 자동으로 주석처리된 부분인 기본 생성자가 생성자의 역할을 한다.

```
public class Test {
    public Test(String a){// a = 사용자 정의
        System.out.println(a + "생성자 호출 성공");
    }

    public static void main(String[] args){
        Test t = new Test("사용자 정의");// 매개변수를 갖는 생성자 호출
        //Test t2 = new Test(); // 컴파일 에러
    }
}
```

매개변수를 갖는 생성자를 정의하였고 main 메소드에서 생성자를 호출하였다. 출력 결과는 "사용자 정의 생성자 호출 성공"이다. 그 다음 줄의 주석 처리된 부분은 기본 생성자를 호출하지만 컴파일 에러가 발생된다. 사용자가 정의한 생성자가 있어서 기본 생성자를 더 이상 자동으로 만들어주지 않기 때문이다.

## this 키워드
자바에서 제공하는 this 키워드는 인스턴스 자기 자신을 가리키는 키워드이다. this 키워드를 통해 클래스 메소드 및 생성자에서 자기 자신의 데이터를 업데이트하거나 조작할 수 있다.

this 키워드는 이 클래스를 기반으로 생성된 **인스턴스를 가리키는 참조**이다. 인스턴스를 가리키는 참조와 인스턴스 자체는 다르다.
```
public class ThisExample {

    private String name;
    private Integer age;
    private String address;

    public ThisExample() {
        this.name = "KBS";
        this.age = 19;
        this.address = "Seoul";
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ThisExample returnThisExample() {
        return this;
    }

}
```



# Reference
- [constructor declaration](http://blog.naver.com/PostView.nhn?blogId=heartflow89&logNo=220955879645)
- [자바 this](https://engkimbs.tistory.com/873)