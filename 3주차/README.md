# JAVA Code Convention

## Code Convention

code convention의 필요성

- 소프트웨어를 개발하는 일련의 모든 과정에 들어가는 비용 중 80%가 유지보수에 쓰여진다.
- 소프트웨어를 직접 개발한 개발자가 그 소프트웨어의 유지보수를 담당하는 경우는 드물다.
- code convention을 통해 다른 개발자가 그 소스코드를 처음 보았을 때 빠른 시간 안에 코드를 이해할 수 있도록 도와준다. 따라서 가독성이 높아진다.
- 개발자가 자신의 소소코드를 제품으로 팔려 한다면, 자신이 작성한 다른 소스코드들과 잘 어울리도록 package를 적절하게 구성할 필요가 있다.

## 줄 나누기
하나의 식이 한 줄에 들어가지 않을 때에는, 다음과 같은 원칙을 따라 두 줄로 나눈다.

- 콤마 후에 두 줄로 나눈다.
- 연산자(operator) 앞에서 두 줄로 나눈다.
- 레벨이 낮은 원칙보다는 레벨이 높은 원칙에 따라 두 줄로 나눈다.
- 앞줄과 같은 레벨의 식(expression)이 시작되는 새로운 줄은 앞줄과 들여쓰기를 일치시킨다.
- 만약 위의 원칙들이 코드를 더 복잡하게 하거나 오른쪽 끝을 넘어간다면, 대신에 8개의 빈 칸을 사용해 들여쓴다.
```java
someMethod(longExpresstion1, longExpression2, loneExpression3,
	longExpression4, longExpression5);

var = someMethod1(longExpression1,
		someMethod2(longExpression2,
			longExpression3));
```


다음은 메소드 선언을 들여쓰는 예제들이다. 첫번재는 일반적인 경우이다. 두번째 예제의 경우 일반적인 들여쓰기를 사용한다면 두번째 줄과 세번째 줄을 들여써야 하므로, 대신에 8개의 빈 칸을 이용하여 들여쓴다.
```java
//일반적인 들여쓰기
someMethod(int anArg, Object anotherArg, String yetAnotherArg,
	Object andStillAnother) {
}

//너무 멀리 들여쓰는 것을 피하기 위해 8개의 빈 칸으로 들여쓰기
private static synchronized horkingLongMethodName(int anArg,
	Object anotherArg, String yetAnotherArg,
	Object andStrillAnother) {
}
```

## 문(statements)
각각의 줄에는 최대한 하나의 문(statement)만 사용하도록 한다.
```
argv++;// 올바른 사용법
argc--;// 올바른 사용법
argv++; argc--;// 이렇게 작성하는 것은 피해라
```

복합문은 중괄호 "{ statements }"로 둘러싸여진 문들의 리스트를 포함하는 문이다. 일반적인 원칙은 아래와 같다.

- 둘러싸여진 문들은 복합문보다 한 단계 더 들여쓰기를 한다.
- 여는 중괄호 “{” 는 복합문을 시작하는 줄의 마지막에 위치해야 한다.
- 닫는 중괄호 “}” 는 새로운 줄에 써야하고, 복합문의 시작과 같은 들여쓰기를 한다.
- 중괄호들이 if-else 문이나 for 문 같은 제어 구조의 일부분으로 사용되어질 때에는 중괄호들이 모든 문들(단 하나의 문일 경우에도)을 둘러싸는데 사용되어져야 한다(이렇게 사용하는 것이 중괄호를 닫는 것을 잊어버리는 것 때문에 발생하는 버그를 만들지 않고, 문을 추가하는 것에 큰 도움을 준다).

값을 반환하는 return 문은 특별한 방법으로 더 확실한 return 값을 표현하는 경우를 제외하고는 괄호를 사용하지 않는 것이 좋다.

if-else 문
```java
if (condition) {
    statements;
}
  
if (condition) {
    statements;
} else {
    statements;
}
  
if (condition) {
    statements;
} else if (condition) {
    statements;
} else {
    statements;
}
```

if문은 항상 중괄호를 사용한다.
```java
if (condition)// 이렇게 {}를 생략해서 사용하지 말자
	statement;


## 공백(Blank Spaces)
공백은 다음과 같은 경우에 사용한다.

- 괄호와 함께 나타나는 키워드는 공백으로 나누어야 한다.
```java
while (true) {
...
}
```

- 메소드 이름과 메소드의 여는 괄호 사이에 공백이 사용되어서는 안 된다. 이를 통해 메소드 호출과 키워드를 구별하는 데 도움이 된다.
- 공백은 인자(argument) 리스트에서 콤마 이후에 나타나야 한다.
- .을 제외한 모든 이항(binary) 연산자는 연산수들과는 공백으로 분리되어져야 한다. 공백은 단항연산자(++, --)의 경우에는 사용해서는 안 된다.
```java
a += c + d;
a = (a + b) / (c * d);
 
while (d++ = s++) {
    n++;
}
printSize("size is " + foo + "\n");
```

- for 문에서는 사용하는 세 개의 식(expression)들은 공백으로 구분해서 나누어야 한다.
```java
for (expr1; expr2; expr3)
```

- 변수의 타입을 변환하는 캐스트(cast)의 경우에는 공백으로 구분해야 한다.
```java
myMethod((byte) aNum, (Object) x);
myMethod((int) (cp + 5), ((int) (i + 3)) + 1);
```

## 명명(naming) 규칙
명명 규칙은 소스코드를 더 읽기 쉽게 만들어줌으로써 더 이해하기 쉽게 만들어 준다. 또한, 식별자(identifier)를 통해서 기능에 대한 정보도 얻을 수 있다. 예를 들자면, 그것이 상수인지 패키지인지 클래스인지를 알 수 있도록 도와준다.

### packages 명명 규칙
- 패키지 이름의 최상위 레벨은 항상 아스키문자에 포함되어 있는 소문자로 쓰고, 가장 높은 레벨의 도메인 이름 중 하나이어야 한다.
- 현재는 com, edu, gov, mil, net, org 또는 1981년 ISO Standard 316에 명시된 영어 두 문자로 표현되는 나라 구별 코드가 사용된다.
- 패키지 이름의 나머지 부분은 조직 내부의 명명 규칙을 따르면 된다. 이러한 규칙을 따라 만들어진 이름은 디렉토리 구조에서 디렉토리 이름으로도 사용된다.

### classes 명명 규칙
- 클래스 이름은 명사이어야 하며, 복합 단어일 경우 각 단어의 첫 글자는 대문자이어야 한다.
- 클래스 이름은 간단하고 명시적으로 작성해야 한다.
- 완전한 단어를 사용하고 두 문자어와 약어는 피하도록 한다.

### interfaces 명명 규칙
- 인터페이스 이름도 클래스 이름과 같은 대문자 사용 규칙을 적용해야 한다.

### methods 명명 규칙
- 메소드의 이름은 동사이어야 하며, 복합 단어일 경우 첫 단어는 소문자로 시작하고 그 이후에 나오는 단어의 문자는 대문자로 사용해야 한다.

### variables 명명 규칙
- 변수 이름의 첫 번째 문자는 소문자로 시작하고, 각각의 내부 단어의 첫 번째 문자는 대문자로 시작해야 한다.
- 변수 이름이 언더바_ 또는 달러$ 표시로 시작하는 것이 허용되지만 사용하지 않도록 주의하자.
- 이름이 짧지만 의미 있어야 한다.
- 이름의 선택은 그 변수의 사용 의도를 알아낼 수 있도록 의미적이어야 한다.
- 한 문자로만 이루어진 변수 이름은 암시적으로만 사용하고 버릴 변수일 경우를 제외하고는 피해야 한다.
- 보통의 임시 변수들의 이름은 interger일 경우엔느 i, j, k, m, n을 사용하고, character일 경우에는 c, d, e를 사용한다.

### constants 명명 규칙
- 클래스 상수로 선언된 변수들과 ANSI 상수들의 이름은 모두 대문자로 쓰고 각각의 단어는 언더바_로 분리해야 한다.
- 디버깅을 쉽게 하기 위해서 ANSI 상수들의 사용은 자제하도록 한다.


## 좋은 프로그래밍 습관

### 인스턴스 변수와 클래스 변수를 외부에 노출하지 말고 대신 접근을 제공
- 인스턴스 변수 또는 클래스 변수를 합당한 이유 없이 public으로 선언하지 말자. 인스턴스 변수들은 명시적으로 선언될 필요가 없는 경우가 많다.
- 인스턴스 변수가 public으로 선언되는 것이 적절한 경우는 클래스 자체가 어떤 동작(behavior)을 가지지 않는 데이터 구조(data structure)일 경우이다. 만약 class대신 struct를 사용해야 하는 경우라면 (java가 struct를 지원한다 가정) class의 인스턴스 변수들을 public으로 선언하는 것이 적합하다.

### 클래스 변수와 클래스 메소드는 클래스 이름을 사용하여 호출
- 클래스(static) 변수 또는 클래스 메소드를 호출하기 위해서 객체를 사용하는 것을 피해야 한다. 대신 클래스 이름을 사용하자.
```java
classMethod();// good
AClass.classMethod();// good
anObject.classMethod();// bad
```

### 숫자는 바로 사용하지 않고 선언해서 변수 이름으로 접근
- 숫자 상수는 카운트 값으로 for-loop에서 나타나는 -1, 0, 1을 제외하고는 숫자 자체를 코드에 사용하지 말자.

### 변수에 값을 할당할 때 주의할 것들
- 하나의 문(statement)에서 같은 값을 여러 개의 변수들에 할당하지 말자. 읽기 어렵게 된다.
```java
fooBar.fChar = barFoo.lchar = 'c';// bad
```

- 비교 연산자(equality operator: ==) 와 혼동되기 쉬운 곳에 할당 연산자(assignment operator: =)를 사용하지 말자.
```java
if (c++ = d++) {
    ...
}

// 다음과 같이 써야 한다
if ((c++ = d++) != 0) {
    ...
}
```

- 실행시 성능 향상을 위해서 할당문(assignment statement)안에 또 다른 할당문을 사용하지 말자.
```java
// 이렇게 사용하지 말자
d = (a = b + c) + r;

// 다음과 같이 써야 한다
a = b + c;
d = a + r;
```

### 그 외 신경써야 할 것들
- 괄호

연산자 우선순위 문제를 피하기 위해서 복합 연산자를 포함하는 경우에는 자유롭게 괄호를 사용하는 것이 좋은 생각이다. 
```java
if (a == b && c == d)     // 이렇게 사용하지 말자
if ((a == b) && (c == d)) // 이렇게 사용하자
```

- 반환 값

프로그램의 구조와 목적이 일치해야 한다.
```java
// 이렇게 사용하지 말자
if (booleanExpression) {
    return true;
} else {
    return false;
}

// 다음과 같이 써야 한다
return booleanExpression;
// 이렇게 사용하지 말자
if (condition) {
    return x;
}
return y;

// 다음과 같이 써야 한다
return (condition ? x : y);
```

- 조건 연산자 ? 이전에 나오는 식(expression)

삼항 연산자(ternary operator - ? : ) 에서 > 이전에 이항 연산자(binary operator)를 포함하는 식(expression)이 있는 경우에는, 꼭 괄호를 사용해야 한다.
```java
(x >= 0) > x : -x;
```


# 자바 기초

## primitive type 기본형 타입
- 8가지의 primitive type을 미리 정의하여 제공한다.
- 기본값이 있기 때문에 Null이 존재하지 않는다. 기본형 타입에 null을 넣고 싶다면 래퍼 클래스를 활용한다.
- 실제값을 저장하는 공간으로 stack 메모리에 저장된다.
- 컴파일 시점에 담을 수 있는 크기를 벗어나면 컴파일 에러가 발생한다.

| 타입 | 할당되는 메모리 크기 | 기본값 | 데이터의 표현 범위 |
|---|:---:|---:|---:|
| boolean | 1byte | false | true, false |
| byte | 1byte | 0 | -128 ~ 127 |
| short | 2byte | 0 | -32,768 ~ 32,767 |
| int | 4byte | 0 | -2,147,483,648 ~ 2,147,483,647 |
| long | 8byte | 0L | -9,223,372,036,854,775,808 ~ 9,223,372,036,854,775,807 |
| float | 4byte | 0.0F | (3.4 X 10-38) ~ (3.4 X 1038) 의 근사값 |
| double | 8byte | 0.0 | (1.7 X 10-308) ~ (1.7 X 10308) 의 근사값 |
| char | 2byte(유니코드) | '\u0000' | 0 ~ 65,535 |

## reference type 참조형 타입
- 기본형 타입을 제외한 타입들이 모두 reference type이다.
- 빈 객체를 의미하는 Null이 존재한다.
- 값이 저장되어 있는 곳의 주소값을 저장하는 공간으로 heap메모리에 저장된다.
- 문법상으로는 에러가 없지만 실행시켰을 때 에러가 나는 런타임 에러가 발생한다. e.g. 객체나 배열을 Null 값으로 받으면 NullPointException이 발생하므로 변수값을 넣어야 한다.

| 타입 | 예시 | 기본값 | 할당되는 메모리 크기 |
|---|:---:|---:|---:|
| 배열Array | int[] arr = new int[5]; | Null | 4byte |
| 열거Enumeration |  | Null | 4byte |
| 클래스Class | String str = "test"; Student sujin = new Student(); | Null | 4byte |
| 인터페이스Interface |  | Null | 4byte |


## 리터럴
프로그램에서 직접 표현한 값. 소스 코드의 고정된 값을 대표하는 용어
- 정수 리터럴
- 실수 리터럴
- 문자 리터럴
- 논리 리터럴
- 문자열 리터럴



### 정수 리터럴

2, 8, 10, 16진수 리터럴
```java
int a = 15;// 10진수 리터럴15
int b = 015;// 0으로 시작하는 8진수. 10진수13
int c = 0x15;// 0x로 시작하는 16진수. 10진수21
int d = 0b0101;// 0b로 시작하는 2진수. 10진수5
```

정수 리터럴은 int형으로 컴파일. long타입 리터럴은 숫자 뒤에 'L' 이나 'l'을 붙여 표시한다.



### 실수 리터럴

소수점 형태나 지수 형태로 표현한 값이다. 기본적으로 실수 타입 리터럴은 double타입으로 컴파일된다.
```java
double f = 0.1234;
double g = 1234E-4;
```

숫자 뒤에 f(float)나 d(double)을 명시적으로 붙이기도 한다. 다만 float은 f가 꼭 필요하고 double은 실수 타입의 기본형이므로 생략이 가능하다.
```java
float h = 0.1234f;
double i = 0.1234D;
```


### 문자 리터럴

단일 인용부호('')로 문자를 표현한다.
```java
char a = 'H'
char b = "한";
char c = \uae00// 유니코드 값
```

\u다음에 4자리 16진수로, 2바이트의 유니코드를 나타낸다.

- 특수문자 리터럴

| 특수문자 리터럴 | 의미 | 특수문자 리터럴 | 의미 |
|---|:---:|---:|---:|
| '\b | 백스페이스backspace | '\r' | 캐리지 리턴 carriage return |
| '\t' | 탭tab | '\"' | 이중 인용부호double quote |
| '\n' | 라인피드line feed | '\'' | 단인 인용부호single quote |
| '\f' | 폼피드form feed | '\\' | 백슬래시backslash |


### 문자열 리터럴
문자열은 **기본타입이 아니다.** ""로 문자열을 표현한다.

```java
String lter = "JAVA";
lter + 26 = "lter26"
```

### 논리 타입 리터럴, 그 외 리터럴
- boolean 타입 변수에 치환하거나 조건문에 이용
```java
boolean a = true;
boolean b = 10 > 0;// b 값은 true
boolean c = 0;// C와 달리 boolean타입으로 1, 0을 true, false로 사용할 수 없다.
```

- Null 리터럴. 레퍼런스에 대입해서 사용한다. 기본타입에는 사용이 불가하고 String같은 경우에는 사용가능하다.
```java
//int a = null;// error
String str = null;
str = "JAVA";
```


## 변수

변수를 사용하기 전에 저장하고자 하는 데이터종류나 크기에 따라 반드시 자료형을 붙여서 변수를 선언하여야 한다.

### 변수란?
- 메모리(RAM)에 데이터를 저장할 공간이다. 

데이터를 사용하다보면 재사용의 순간이 생긴다. 변수는 해당 데이터를 저장해 놓은 그릇이라고 생각하면 된다. 변수에 값을 저장하려면 자바에서는 변수를 선언하고 값을 초기화해주면 된다.

### 변수의 명명 규칙
보통의 경우 아래의 상황을 따른다.
- 카멜 케이스: 복수의 단어로 형성된 복합어에서 각 단어의 첫 글자를 대문자로 표기하는 형식
- 파스칼 케이스: 첫 글자를 대문자로 표기하는 카멜케이스
- 스네이크 케이스: 모두 대문자로 단어를 언어스코어_로 구분하는 형식

### 변수 선언과 초기화
```java
public class ResultObject {
    int number;
    String name;
    number = 123;
    String name = "BLINK_ONCE";
}
```

## 변수의 스코프(영역)과 라이프타임

- 변수의 스코프(영역)이란?

변수에 접근하거나 접근할 수 있는 유효 범위/영역이다. 개발자는 자신이 선언한 또는 선언된 변수에 접근할 수 있는 영역에 대해서 이해해야한다. 일반적인 규칙은 변수가 선언된 블록 내에서만 액세스 할 수 있다는 것이다. 블록은 왼쪽 중괄호 {로 시작하고 오른쪽 중괄호 }로 끝난다.

- 변수의 라이프타임이란?

변수가 메모리에서 살아있는 기간
<br>
<br>

자바에서 변수의 스코프와 라이프타임은 아래와 같다.

### instance variables

**정의** : 클래스 내부와 모든 메소드 및 블록 외부에서 선언된 변수
**scope** : 정적 메소드를 제외한 클래스 전체
**라이프타임** : 객체가 메모리에 남아있을 때까지

- 예시
```java
class test{

//여기부터

    int x, y;// instance var
    static int result;
    
    void add(int a, int b){
        x = a;
        y = b;
        int sum = x + y;
        System.out.println("Sum = " + sum);
    }

//여기까지

    public static void main(String[] args){
        Sample obj = new Sample();
        obj.add(10, 20);
    }
}
```

### class variables
**정의** : 클래스 내부, 모든 블록 외부에서 선언되고 static으로 표시된 변수
**scope** : 클래스 전체
**라이프타임** : 프로그램이 끝날 때까지, 또는 클래스가 메모리에 로드되는 동안

- 예시(result(class variable)의 scope)
```java
class test{

//여기부터

    int x, y;// instance var
    static int result;
    
    void add(int a, int b){
        x = a;
        y = b;
        int sum = x + y;
        System.out.println("Sum = " + sum);
    }
    public static void main(String[] args){
        Sample obj = new Sample();
        obj.add(10, 20);
    }

//여기까지

}
```

### local variables

**정의** : 인스턴스 및 클래스 변수가 아닌 모든 변수
**scope** : 선언된 블록 내에 있음
**라이프타임** : 컨트롤이 선언된 블롤을 떠날 때까지

- 예시(a, b(local variables)의 scope)
```java
class test{
    int x, y;// instance var
    static int result;

//여기부터
    
    void add(int a, int b){
        x = a;
        y = b;
        int sum = x + y;
        System.out.println("Sum = " + sum);
    }

//여기까지

    public static void main(String[] args){
        Sample obj = new Sample();
        obj.add(10, 20);
    }
}
```


## 타입변환 (타입 캐스팅, 타입 프로모션)
자바에서 연산은 동일한 데이터 타입에서 가능하다. 하지만, 서로 다른 데이터 타입끼리 연산이 필요할 때가 있다. 이러경우 변수의 데이터 타입을 바꿔주는 작업이 필요하다. 이것이 데이터 타입 변환, 형변환이다. 형변환에는 크게 자동 형변환(promotion, 묵시적 타입 변환)과 강제 형변환(casting명시적 타입 변환)이 있다. 

### 자동 형변환(promotion)
프로그램 실행 도중에 자동적으로 형변환이 일어나는 것이다. 프로모션은 작은 메모리 크기의 데이터 타입을 큰 메모리 크기의 데이터 타입으로 변환하는 행위를 말한다.
- 프로모션 예시
```java
byte a = 10;
itn b = a;// byte 데이터 타입의 변수인 a를 int데이터 타입의 변수인 b에 저장
```

- 프로모션되는 순서

byte(1) < short(2) < int(4) < long(8) < float(4) < double(8)
<br>
long 데이터 타입에서 float데이터 타입으로 프로모션이 가능하다. 표현할 수 있는 값의 범위가 float 더 크기때문이다. 

### 강제 형변환(casting)
특정 조건을 갖추지 못했지만 형변환을 해야할 경우에 사용한다.
```java
int intValue = 1;
byte byteValue = intValue;
```
위와 같은 경우 데이터 값이 1이므로 byte의 데이터 타입 범위 안에 충분히 들어가는 값이다. 하지만 4byte 크기의 정보를 1byte에 넣는 것은 불가능하다. 캐스팅은 아래와 같이 할 수 있다.
```java
int intValue = 1;
byte byteValue = (byte) intValue;
```

- 주의사항
```java
int intValue = 2053464574;
byte buteValue = (bute) intValue;
```
위와 같이 캐스팅하는 값이 데이터 타입 범위를 벗어나게 되면 int 데이터 타입 앞의 3byte 만큼의 데이터를 무시한 채 가져오게 되어 byteValue에는 -2라는 값이 저장된다.



## 배열

동일한 자료형의 데이터를 연속된 공간에 저장하기 위한 자료구조이다. 연관된 데이터를 저장하기 위한 변수의 선언을 줄여주며, 반복문 등을 이용하여 계산과 같은 과정을 쉽게 처리할 수 있다.

### 1차원 배열

- 배열을 선언하고 동시에 요소를 초기화하는 방식(C style)
```java
public class ArrayEx01 {
	public static void main(String[] args) {
		String[] beer = {"Kloud", "Cass", "Asahi", "Guinness", "Heineken"};
		    // 인덱스 번호 :   0  ,    1   ,   2   ,     3      ,     4
		System.out.println(beer[0]); // Kloud
		System.out.println(beer[1]); // Cass
		System.out.println(beer[2]); // Asahi
		System.out.println(beer[3]); // Guinness
		System.out.println(beer[4]); // Heineken
	}
}
```
- new를 통해 heap에 생성하는 방식
```java
public class ArrayEx03 {
	public static void main(String[] args) {
		int[] num = new int[3]; // 크기가 3인 배열 생성
		num[0] = 10; // 0번 index에 값 할당
		num[1] = 15; // 1번 index에 값 할당
		num[2] = 13; // 2번 index에 값 할당
		for (int i = 0; i < num.length; i++) {
			System.out.println(num[i]);
		}
	}
}
```

### 2차원 배열
2차원 배열의 선언 방법은 아래와 같다.
```java
data-type var-name[][] = new data-type[size][size];
data-type[][] var-name = new data-type[size][size];
data-type[] var-name[] = new data-type[size][size];

int a[][] = new int[4][5];
int[][] a = new int[4][5];
int[] a[] = new int[4][5];
```




## 타입 추론, var



# Reference
[자바 코딩 규칙](https://velog.io/@aidenshin/Java-%EC%9E%90%EB%B0%94-%EC%BD%94%EB%94%A9-%EA%B7%9C%EC%B9%99-Java-Code-Conventions) <br>
[프로모션, 캐스팅](https://stage-loving-developers.tistory.com/8)