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
| byte | 1 | 0 | -128 ~ 127 |
| short | 2 | 0 | -32,768 ~ 32,767 |
| int | 4 | 0 | -2,147,483,648 ~ 2,147,483,647 |
| long | 8 | 0L | -9,223,372,036,854,775,808 ~ 9,223,372,036,854,775,807 |
| float | 4 | 0.0F | (3.4 X 10-38) ~ (3.4 X 1038) 의 근사값 |
| double | 8 | 0.0 | (1.7 X 10-308) ~ (1.7 X 10308) 의 근사값 |
| char | 2(유니코드) | '\u0000' | 0 ~ 65,535 |

## reference type 참조형 타입
- 기본형 타입을 제외한 타입들이 모두 reference type이다.
- 빈 객체를 의미하는 Null이 존재한다.
- 값이 저장되어 있는 곳의 주소값을 저장하는 공간으로 heap메모리에 저장된다.
- 문법상으로는 에러가 없지만 실행시켰을 때 에러가 나는 런타임 에러가 발생한다. e.g. 객체나 배열을 Null 값으로 받으면 NullPointException이 발생하므로 변수값을 넣어야 한다.

| 타입 | 예시 | 기본값 | 할당되는 메모리 크기 |
|---|:---:|---:|---:|
| 배열Array | int[] arr = new int[5]; | Null | 4byte |
| 열거Enumeration |  | Null | 4 |
| 클래스Class | String str = "test"; Student sujin = new Student(); | Null | 4 |
| 인터페이스Interface |  | Null | 4 |






# 2. 자바 기초
### 목표
자바의 primitive 타입, 변수 그리고 배열을 사용하는 방법을 익힌다.
### 정리할 것
- primitive 타입 종류와 값의 범위 그리고 기본 값
- primitive 타입과 레퍼런스 타입
- 리터럴
- 변수 선언 및 초기화하는 방법
- 변수의 스코프와 라이프타임
- 타입 변환, 캐스팅 그리고 타입 프로모션
- 1차 및 2차 배열 선언하기
- 타입 추론, var


# Reference
[자바 코딩 규칙](https://velog.io/@aidenshin/Java-%EC%9E%90%EB%B0%94-%EC%BD%94%EB%94%A9-%EA%B7%9C%EC%B9%99-Java-Code-Conventions) <br>
