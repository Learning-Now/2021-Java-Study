# 3주차 과제 : 자바 타입 이해하기

---
## 자바 코드 실습
> Java Code Convention 이 무엇이고 왜 필요한가

* Java Code Convention 은 한글로 해석하면 자바 코드 규칙이다.
 그렇다면 왜 Code Convention을 알아야 하는가? 일단 위에서도 말했듯이 해석하면 규칙이다 규칙은 ![](https://images.velog.io/images/donglee99/post/76086da9-b869-4f87-b566-6f0f9247c1f0/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-14%20%EC%98%A4%ED%9B%84%208.18.17.png)
 이란 뜻을 가지고 있다. 즉 여러 사람이 자바라는 언어를 쓰니까 우리가 한글이나 영어의 문법을 배우고 문법에 맞게 문장을 작성해야 다른 사람들이 쉽게 알아 볼 수 있듯이 자바도 정해진 문법에 따라 코드를 짜야지 내가 짠 코드를 다른 사람이 알아보기 쉽다. _즉 코드의 가독성을 위해서 코드 컨벤션을 지켜야 한다._
 * 보통 개발자와 소프트웨어를 유지 보수하는 사람이 다른 경우가 많다 이때 가독성이 떨어진다면 과연 소프트웨어의 유지 보수가 제대로 이뤄질수있을까? 그렇지 않다 이 때문에 더더욱 코드 컨벤션을 지켜야 한다.
 * 가독성이 좋다 -> 이해도가 높아진다 -> 유지보수가 편하다 -> 소프트 웨어 개발 비용이 줄어든다
 
** 자바 코드 컨벤션 **
 ### 1. 파일 공통 요건
 * 모든 소스, 텍스트 문서의 인코딩은 _UTF-8_로 통일 되어야 함.
 * 새줄 문자는 LF 를 사용한다.
 * 파일의 마지막 새줄은 LF 로 끝나야 한다.
 * 확장자
 <table>
  <tr>
    <th>파일 형태</th>
    <th>확장자</th>
  </tr>
  <tr>
    <td>자바 소스 </td>
    <td>.java</td>
  </tr>
  <tr>
  	<td>자바 바이트 코드 </td>
    <td>.class</td>
  </tr>
  </table>
  * 공통으로 시작되는 파일 이름
  <table>
  <tr>
    <th>파일 이름</th>
    <th>사용</th>
  </tr>
  <tr>
    <td>GNUmakefile make </td>
    <td>파일 이름으로 사용, 소프트웨어를 빌드 할 때 gnumake 명령어 사용</td>
  </tr>
  <tr>
  	<td>README </td>
    <td>특정 디렉토리의 내용을 요악하는 파일 이름으로 사용</td>
  </tr>
  </table>
 
### 2. 이름
* 식별자에는 영문/숫자/_만 허용된다.
	
    * 변수, 클래스, 메서드 모두 영어와 숫자 _ 만 사용할수 있다 ( - 는 사용할수 없다)
* 한국어 발음 대로 표기 금지
	
    * 간단하게 말하면 사과를 sagwa가 아닌 apple 로 표기한다는 것이다. ( 한국어의 고유 명사는 제외 )
* 대문자로 표기할 약어 명시
	
     * 클래스 명, 변수명에 쓰일 단어중 모든 글자를 대문자로 표기할 약어 목록을 프로젝트별로 명시적으로 정의 한다.(간단하게 말하면 약어 목록에 정리가 되어있는 약어가 아니면 약어의 앞의 문자만 대문자로 표기하고 나머지는 소문자로 표기한다
     _글로만 봤을 때 바로 이해가 안돼서 바로 예를 보면_
     
     	1. 대문자로 표기될 약어 목록 정의 X => HttpApiUrl
        
        	
          2. API 만 약어목록 정의 => HttpAPIUrl
 * 패키지 이름은 소문자로
 	
    * 패키지의 이름은 소문자로 작성하고 (_) 대문자 섞지 X
    ``` java
    package com.donglee99.javastudy
    ```
* 클래스/인터페이스 이름에 대문자 카멜 표기법
	![](https://images.velog.io/images/donglee99/post/e0ae4e7e-f3dd-4e2b-8e86-a13b79540a2f/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-15%20%EC%98%A4%ED%9B%84%201.44.23.png)
    * 카멜 표기법은 단어의 첫 글자를 대문자로 표기하는 표기법이다.
    ``` java
    public class Donglee99{
    }
* 클래스 이름에 명사 사용
	
    * 클래스 이름은 명사나 명사절로 짓는다.
    ``` java
    public class Sum{
    }
    ```
* 인터페이스 이름에 명사/형용사 사용
	
    * 인터페이스의 이름은 명사절 or 형용사절 로 짓는다
    ``` java
    public interface Donglee99{
    }
* 테스트 클래스는 Test로 끝나야함
	
    * JUnit등으로 작성한 테스트 코드를 담은 클래스는 마지막에 Test 를 붙인다 ( 스프링 할때 많이 나오더라... )
    ``` java
    public class PostsApiControllerTest{
    }
* 메서드의 이름에 소문자 카멜법 적용, 메서드 이름은 동사/전치사로 시작
	
    * 이건 toString() 을 생각하면 이해하기 쉽다. 
    To + String 인데 소문자 카멜 표기법으로 인해 단어의 첫 문자가 소문자가 되고 그 다음 오는 단어의 첫 문자가 대문자가 되어 toString() 이 된다. 
    ``` java
    toString() renderHtml()
    ```
 * 상수는 대문자와 언더스코어로 구성
 	
    * 상태를 가지지 않고 static final로 선언되어있는 필드를 상수라 하는데 이 상수는 대문자로 작성하고 복합어는 (_)로 구분한다.
    ``` java
    public final int UNLIMITED = -1;
    public final String POSTAL_CODE_EXPERESSION = "POST";
* 변수에 소문자 카멜표기법 적용
	
    * ``` java
    private int authorized;
    private String accessToken;
    ```
* 임시 변수를 제외 하고는 한글자 금지
	
    * 메서드 블럭 범위 이상의 생명주기를 가지는 변수에는 1글자로 된 이름 사용 X but 반복된 인덱스나 람다 표현식의 파라미터등의 짧은 범위의 임시 변수에는 사용 가능
    
### 3. 선언
_클래스, 필드, 메서드 import등의 소스 구성요소 선언시 규칙_

* 소스파일 하나당 한개의 탑레벨 클래스 담기
	
    ``` java
    public class Donglee99{
    	class Dong99{
        }
    }
    ```
 * static import 에만 wild card 허용
 	
    * wild card = * 를 의미하며 클래스 import 시 static import 가 아니라면 와일드 카드를 사용하지 않는다.
    ``` java
    import java.util.List;
    import java.util.Scanner;
    
    import java.util.*; ==> X
    ```
* 제한자 선언 순서
	
    * public -> protected -> private -> abstract -> static -> final -> transient -> volatile -> synchronized -> native -> strictfp
* 한줄에 한 문장, 하나의 선언문엔 하나의 변수
	
    * 간혹 코딩하다가 보면 띄어쓰기를 까먹고 안해서 한줄에 여러 변수를 선언 하는 경우가 있었는데 옳지 않다.
    ``` java
    int a = 9;
    int b = 1;
    int a,b => x
    int a;
    int b;
    ```
* 배열에서 대괄호는 타입 뒤에 선언
``` java
	
    int [] arr; ==> 맞는 표현
    int arr []; ==> 틀린 표현
```
* long 형 마지막에 L 붙이기
	
    * long 형의 숫자 마지막에 L 을 붙여준다 대문자여야 한다.

### 들여쓰기

* 하드탭 사용
	
    * Tab을 사용하고 스페이스 사용 X
* 탭의 크기는 4개의 스페이스
	
    * 1Tab = 4Space
* 블럭 들여쓰기
	
    * 클래스, 메서드, 제어문등의 코드블럭이 생길때마다 1Tab
    
### 중괄호

* K&R 스타일로 중괄호 선언 
	
    * 이말은 예로 보는게 편하다
    ``` java
    if(i==a)
    {
   	cnt++;
    } ==> X
    
    if(i==a) {
    cnt++;
    } ==> o
    ```
* 닫는 중괄호와 같은 줄에 else, catch,finally,while 선언
	
    * 바로 예를 보면
    ``` java
    if (i == a) {
   	}
    else if {
    }
    else if {
    }  ==> 틀린 표현
    
    if (i == a) {
    } else if {
    } else if {
    } ==> 맞는 표현
    ```
* 빈블럭에 새줄 없이 중괄호 닫기 허용
	
```java
public void Donglee99() {}
```
* 조건/ 반복문에 중괄호 필수
``` java
if (i == a) return false; ==> X

if (i == a) {
	return false;
} ==> O
```


### 줄바꿈

_ 작성한 명령어의 길이가 너무 길어 가독성이 떨어지게 됨을 방지 하기위한 규칙이다 _
* 최대 줄 너비는 120
* package,import 선언문은 한줄로
* 줄바꿈후 추가 들여쓰기 (한줄에 표기하려 했던 코드를 줄바꿈 할시)
* 줄바꿈 허용 위치 (```extend```,```implements```,```throws``` ,```(()``` ,```(,)``` 선언후 ,```.``` 전, 연산자 전)

### 빈줄

_빈 줄은 명령문 그룹의 영역을 표시하기 위해 사용_
* ```package``` 선언후 빈줄 삽입 ( 패키지 선언후 한줄 띄기)

* ```import``` 선언의 순서와 빈 줄 삽입
	
    * 1. static imports
      2. ```java.```
      3. ```javax.```
      4. ```org.```
      5. ```net.```
      6. 8~10을 제외한 com.*
      7. 1~6, 8~10을 제외한 패키지에 있는 클래스
      8. ```com.nhncorp```
      9. ```com.navercorp.```
      10. ```com.naver.```
      (간단하게 생각하면 같은 패키지에서 파생된것들끼리 묶어준다)
 * 메소드 사이에 빈줄 삽입
 
### 공백
* 공백으로 줄을 끝내지 않는다
* 대괄호([]) 뒤에 공백을 넣어준다
* 중괄호의 시작전, 종료후 공백 삽입
* 제어문 키워드(_ex) if_)와 여는 소괄호() 사이에 공백 삽입
* 식별자와 여는 소괄호 사이에 공백 미삽입
``` java
 @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }
```   
* 타입 캐스팅에 쓰이는 소괄호 내부에 공백 미삽입
``` java
int a = (int)b;
```
* 제네릭스 산괄호 (<,>) 의 공백 규칙
	
    * 제네릭스 메서드 선언 일 때만 앞에 < 공백 삽입
    * < > ```>```앞```<```뒤로 공백 사용 X
    * 밑의 경우 제외하고는 > 뒤에 공백 삽입
    ```java
    public static <A extends Annotation> A find(AnnotatedElement elem, Class<A> type) { // 제네릭스 메서드 선언
    List<Integer> l1 = new ArrayList<>(); // '(' 가 바로 이어질때
    List<String> l2 = ImmutableList.Builder<String>::new; // 메서드 레퍼런스가 바로 이어질 때
    int diff = Util.<Integer, String>compare(l1, l2); // 메서드 이름이 바로 이어질 때
```
```

* 콤마/ 구분자 세미콜론의 뒤에만 공백 삽입
* 콜론 앞 뒤로 공백 삽입
* 주석 문 기호 전후의 공백 삽입

[참고](https://naver.github.io/hackday-conventions-java/)

---
## 자바 기초
>목표
자바의 프리미티브 타입, 변수 그리고 배열을 사용하는 방법을 익힙니다.

---
### 프리미티브 타입 종류와 값의 범위 그리고 기본 값
** 타입 이란? **
* 해당 데이터가 메모리에 어떻게 저장되고, 프로그램에서 어떻게 처리되어야 하는지 명시적으로 알려주는 것.

** 프로미티브 타입 이란? **
* 프로미티브 타입은 기본형으로도 불리며 논리형과 숫자형 문자열 형등의 기본적인 데이터 타입을 의미한다.

<table>
  <th>
    타입
  </th>
  <th>
    설명
  </th>
  <th>
    사이즈
  </th>
  <th>
    값의 범위
  </th>
  <th>
    기본 값
  </th>
  <tr>
    <td>
      byte
    </td>
    <td>
      부호 있는 정수값
    </td>
    <td>
      8bit
    </td>
    <td>
      -128 ~ 127
    </td>
    <td>
      0
    </td>
  </tr>
  <tr>
    <td>
      short
    </td>
    <td>
      부호 있는 정수값
    </td>
    <td>
      16bit
    </td>
    <td>
      -32768 ~ 32767
    </td>
    <td>
      0
    </td>
  </tr>
  <tr>
    <td>
      int
    </td>
    <td>
      부호 있는 정수값
    </td>
    <td>
      32bit
    </td>
    <td>
      -2147483648 ~ 2147483647
    </td>
    <td>
      0
    </td>
  </tr>
  <tr>
    <td>
      long
    </td>
    <td>
      부호 있는 정수값
    </td>
    <td>
      64bit
    </td>
    <td>
      -9223372036854775808 ~ 9223372036854775807
    </td>
    <td>
      0L
    </td>
  </tr>
   <tr>
    <td>
      char
    </td>
    <td>
      유니코드 문자
    </td>
    <td>
      16bit
    </td>
    <td>
      '\u0000' ~ 'uFFFF' (16비트 유니코드 문자 데이터)
    </td>
    <td>
      '\u0000'
    </td>
  </tr>
    <tr>
    <td>
      float
    </td>
    <td>
      IEEE754부동소수점수
    </td>
    <td>
      32bit
    </td>
    <td>
      1.4E-45 ~ 3.4028235E38
    </td>
    <td>
      0.0d
    </td>
  </tr>
  <tr>
    <td>
      double
    </td>
    <td>
      IEEE754부동소수점수
    </td>
    <td>
      64bit
    </td>
    <td>
      4.9E-324 ~ 1.7976931348623157E308
    </td>
    <td>
      0.0d
    </td>
  </tr>
    <tr>
    <td>
      boolean
    </td>
    <td>
      논리값
    </td>
    <td>
      1bit
    </td>
    <td>
      true / false
    </td>
    <td>
      false
    </td>
  </tr>
  </table>
  
 
 
 
 

** 레퍼런스 타입 **

<table>
  <th>
    타입
  </th>
  <th>
    예시
  </th>
  <th>
    기본값
  </th>
  <th>
    할당되는 메모리의 크기
  </th>
  <tr>
    <td>
      배열(Array)
    </td>
    <td>
      int[] arr = new int[5];
    </td>
    <td>
      Null
    </td>
    <td>
      4 byte
    </td>
    </tr>
   <tr>
    <td>
      열거(Enumeration)
    </td>
    <td>
      RED, ORANGE, YELLOW, GREEN
    </td>
    <td>
      Null
    </td>
    <td>
      4 byte
    </td>
    </tr>
   <tr>
    <td>
      클래스(Class)
    </td>
    <td>
      String str = "test"; <br>
      Student sujin = new Student();
    </td>
    <td>
      Null
    </td>
    <td>
      4 byte
    </td>
    </tr>
   <tr>
    <td>
      인터페이스(Interface)
    </td>
    <td>
      public interface Bank {
 
    </td>
    <td>
      Null
    </td>
    <td>
      4 byte
    </td>
    </tr>
      
</table>
  

  
---
### 프리미티브 타입과 래퍼런스 타입


** 자바의 기본형 타입 (프리미티브 타입) **
* 자바에서는 총 8개의 타입 (위의 표 참조) 을 미리 정의하여 제공 한다.
* 실제 값을 저장 하는 공간으로 스택 (Stack) 메모리에 저장된다.
* 만약 컴파일 시점에 담을 수 있는 크기를 벗어나면 컴파일 에러가 발생한다. ( 실제 백준을 풀때 이때문에 에러가 나는 경우가 많았다... )

** 참조형 타입 (Reference Type) **
* 기본 타입(프로미티브 타입)을 제외한 타입들이 모두 참조형 타입이다. 
* 빈 객체를 의미하는 Null이 존재한다.
* 값이 저장되어있는 곳의 주소값을 저장하는 공간인 힙(Heap)에 메모리가 저장된다.
* 문법상으로는 에러가 없지만 실행 시켰을때 에러나 나는 런타임 에러 발생한다 NullException이 발생하지 않도록 변수값을 꼭 넣어준다.
---
### 리터럴

** 리터럴 이란? **
* 리터럴은 데이터 그 자체를 의미하며 변수에 넣는 변하지 않는 데이터를 의미한다.
* ex)
``` java
	int a = 1;
```
		a =변수, 1 = 리터럴
        
** 리터럴의 종류 **
* 리터럴의 종류
	
    * 정수형 (Interger)
    * 실수형 (floating point)
    * 부울형 (boolean)
    * 문자형 (charactor)
    * 문자열 (String)
    
** 리터럴과 데이터 타입의 차이 **
* 리터럴 = 실제 프로그램 코드에 나와있다.
* 데이터 타입 = 리터럴에 관한 정보 (리터럴에 들어갈 변수가 얼마나 많은 메모리 공간을 차지하나, 어떤 범위의 값이 들어갈 수 있는가에 대한 정보

** 리터럴을 사용하는 이유 **
* 리터럴을 사용하는 이유는 데이터 타입의 표현을 명확하게 하기 위해서 이다. 
``` java
	int i = 10;
    	long j = 10;
```
이때 10이 어떤 타입인지 구분 하기 힘들다 이를 구분하기 위해 리터럴을 사용하는것이다.
[참조](https://m.blog.naver.com/PostView.nhn?blogId=simba222&logNo=193021821&proxyReferer=https:%2F%2Fwww.google.com%2F)


---
### 변수 선언 및 초기화하는 방법
** 변수란? **
* 변수는 데이터를 저장하는 메모리 영역을 의미한다.

** 변수의 선언 **
* 👍 자바에서 변수를 사용하기 전에는 꼭 선언 , 초기화를 해줘야 한다!!
* 선언 하는 방법
	
    1. 변수의 선언만 하는 방법
    2. 변수 선언과 동시에 초기화 하는 방법
* 변수의 선언만 하는 방법 
	
    * 먼저 변수를 선언 하여 메모리를 할당 받은 후 나중에 변수를 초기화 하는 방법으로 이 방법을 한후 변수의 초기화를 해주지 않으면 쓰레기 값이 들어가게 된다.
    ``` java
    int num;
    num = 10;
    ``` 
* 변수의 선언과 동시에 초기화 하는 방법
	
    * 자바에서는 변수 선언과 동시에 값을 초기화 할 수 있다. (내가 써본 언어 대부분이 가능했던것 같다)
    ``` java
    int num1 = 10;
    ``` 
_선언하고자하는 타입과 초기화 하려는 타입이 다를 경우 선언 불가능!_
    
[참고](http://www.tcpschool.com/java/java_datatype_variable)

---
### 변수의 스코프와 라이프타임


** 변수의 스코프 **
* 변수의 스코프란 프로그램 상에서 변수를 사용 가능한 범위를 나타낸다.
``` java
public class ValableScopeExam{

        int globalScope = 10;   // 인스턴스 변수 

        public void scopeTest(int value){   
            int localScope = 10;
            System.out.println(globalScope);
            System.out.println(localScpe);
            System.out.println(value);
        }
    }
``` 
* 위 코드에서 globalScope 의 사용 범위는 ValableScopeExam의 내부에 있는 전체 에서 사용이 가능 하지만 localScope 는 ValableScopeExam에서는 사용이 불가능 하고 scopeTest안에서만 사용 가능하다.

** static **
* static은 고정 이란 의미를 가지고 있다. Static이라는 키워드를 사용하면 Static 변수와 Static 메소드를 만들수 있는데 이를 정적 필드와 정적 메소드라고 하며 합쳐서 정적 멤버(클래스 멤버)라고도 한다. 
* 정적 멤버는 객체에 소속된 멤버가 아니라 클래스에 고정 된 멤버이며 클래스 로더가 클래스를 로딩할때 메소드 메모리 영역에 클래스별로 관리가 되어 클래스 로딩이 끝나면 바로 사용이 가능하다. 
![](https://images.velog.io/images/donglee99/post/104b9341-92c2-410c-b72a-dd48a2036543/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-15%20%EC%98%A4%ED%9B%84%202.24.34.png)
* 정적 멤버는 Heap이 아닌 Static 영역에 할당 되며 이 static 영역에 할당된 메모리는 모든 객체가 공유를 하며 하나의 멤버를 언제든지 참조가 가능하다.

![](https://images.velog.io/images/donglee99/post/5e42c9e2-fa91-44f2-b2de-f5d64787cef1/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-15%20%EC%98%A4%ED%9B%84%202.36.52.png)

![](https://images.velog.io/images/donglee99/post/9b19bc37-ca68-4785-9489-6be1933e74a6/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-15%20%EC%98%A4%ED%9B%84%202.37.13.png)

* 위 코드를 보면 dong은 static으로 hyun 은 인스턴스 변수로 선언을 하였다 그후 클래스 객체를 2개 선언 한후 d1 클래스에서만 증가를 해줬는데 d2클래스를 출력했을때 static 으로 선언한 값이 증가 한것을 볼수 있다. 이는 static으로 선언된 변수는 모든 인스턴스가 하나의 저장 공간을 공유 하기 때문이다. (나는 보통 cnt 값을 셀때 쓴다)
* Static 영역에 할당된 메모리는 모든 객체가 공유하여 하나의 멤버를 어디서든지 참조할 수 있는 장점을 가진다. 하지만 이점이 단점이 될때도 있다. 만약 카운터 같은 모든 영역에서 공유하돼 하나만 선언되어야하는 변수가 아니고 각각의 영역에서 다른 메모리 값을 가지며 사용되는 변수에 static 을 선언하면 그 코드는 오답이 될것이다. 따라서 static을 사용할때는 남발하면 안되고 상황에 맞게 고려해가면서 써야한다.

** 변수의 라이프 타임 **
* 변수의 메모리가 살아있는 기간이다.
	
    * 인스턴스 변수 = 객체가 메모리에 남아있을때 까지.
    * 클래스 변수(static) = 프로그램이 끝날때까지 메모리가 로드되는 동안
[참고](https://programmers.co.kr/learn/courses/5/lessons/231)

---
### 타입 변환, 캐스팅 그리고 타입 프로모션


** 자바 타입 변환 **
* 타입 변환의 종류
	
    * 자동 타입 변환 (묵시적)
    * 강제 타입 변환 (명시적)
* 자동 타입 변환
	
    * 프로그램 실행 도중에 자동으로 타입 변환이 일어난다.
    * 작은 크기를 가지는 타입이 큰 크기를 가지는 타입에 저장될 때 변환이 일어나는데 타입별 크기는
    1. byte(1)
    2. short(2)
    3. int(4)
    4. long(8)
    5. float(4)
    6. double(8)
    ex)
    ```  java
    int intVal = 10;
    long longVal = intVal; // 자동 타입 변환이 이루어짐
    // 음수가 저장될수있는 byte,int 는 char 타입으로 자동 변환 불가
    ```
* 강제 타입 변환
	
    * 큰 크기의 타입을 작은 타입으로 변환 할때 자동으로 변환 되지 않아 강제로 타입을 변환해 줘야한다.
    ex)
    ``` java
    int intVal = 12345;
    char charVal = (char)intVal;
    ``` 
    _이때 값손실이 나지 않게 범위를 체크해야한다_
    
---
### 1차 배열 및 2차 배열 선언하기

** 1차 배열 선언하기 **
``` java
int[] arr1; 
int arr1[];
```
* 위와 아래 둘다 맞는 표현이지만 자바 코드 컨벤션에 의하면 위에 표기식이 맞는 표현이다.

** 1차원 배열 초기화 하기 **
``` java
int[] arr1;
int arr1 = new int[3];
```
* 이때 배열을 초기화 하면 기본 값이 0 으로 셋팅이 된다.

** 1차원 배열을 선언과 동시에 초기화 하기 **
``` java
int[] arr1 = new int[10];
```
* 이때도 배열을 기본 값 0으로 지정된다.

** 1차원 배열에 원하는 값 집어 넣기 **
``` java
int [] arr1 = {1, 2, 3, 4};
```
* 위의 결과는 배열 사이즈 4의 [1, 2, 3, 4] 가 만들어진다.

** 2차원 배열 선언 **
* 2차원 배열의 선언
``` java
int[][] arr;
```
* 2차원 배열의 초기화
``` java
int[][] arr;
arr = new int[1][1];
```
* 2차원 배열의 선언과 초기화 동시에 하기
``` java
int[][] arr = new int[1][1];
```
* 2차원 배열에 원하는 값 저장 하기;
``` java
int[][] arr = {{1, 2, 3}, {4, 5, 6}};
```

---
### 타입 추론, var
** 타입 추론(Type Inference)**
* 타입 추론은 정적 타이핑을 지원 하는 언어에서 타입이 정해져 있지 않은 변수에 대해 컴파일러가 자동으로 변수의 타입을 추론해 낼수 있도록 하는 기능이다.
* 타입 추론이 가능 하다 -> 코드량이 줄어든다, 코드의 가독성이 높아진다.
_예젼에 노드 js 를 공부할때 var 을 정말 많이 봤었었는데 이제 자바10이상부터는 자바에서도 var 사용이 가능하다 한다._
* 자바 8이 등장 하고부터 람다에서 타입 추론을 할 수 있게 되었다.
``` java
	BinaryOperator <Integer> add = (x, y)-> x + y;
```
* 제네릭 (Generic)
	
    * 제네릭 타입을 사용해 컴파일 과정에서 타입을 체크해 잘못된 타입 사용을 제거한다.
    ex)
    
  ``` java
    public class TestGeneric<T> {
    public T sample;

    	public void showYourType()
    	{
        		if(sample instanceof Integer)
            		System.out.println("Integer 타입이군요!!");
       			else if(sample instanceof String)
            		System.out.println("String 타입이군요!!");
    	}
        }
  ```
  위의 TestGeneric클래스의 멤버 변수 sample 은 T라는 타입을 가지는데 이 T는 존재하는 타입이 아니다. T는 나중에 인스턴스 생성시 결정된다.
  
  ``` java
  public class Main{
    public static void main(String[] args)
    {
        TestGeneric<String> stringType = new TestGeneric<String>();
        TestGeneric<Integer> integerType = new TestGeneric<Integer>();

		stringType.sample = "Hello";
		integerType.sample = 1;

        stringType.showYourType();
        integerType.showYourType();
    }
}
```
```
위의 코드에서 <> 안에 들어가는 타입에 의해 T의 타입이 결정되는걸 알수있다. 이처럼 인스턴스를 생성시에 타입이 명시되어 형변환이 필요없다. (이는 밑에 나올 var 과는 조금 다른것 같다. var 은 리터럴 값을 파악해 타입을 컴파일시 추론 하는 반면에 위의 제네릭은 사람이 직접 지정을 하는게 내가 생각하는 타입추론과는 조금 다른것 같다)

* 이전 자바에서는 자바의 변수를 선언 할때 변수 타입을 명시해줬었다.
``` java
String str = "Java-Study";
```
* 하지만 var 을 사용하면 변수의 타입을 생략 해주어도 된다. 변수의 타입을 생략해도 리터럴 캆을 컴파일시 스스로 분석해 변수 타입을 초기화 해준다.
``` java
var str = "Java-Study";
```
* var 값은 초기화 값이 있는 지역 변수로만 선언이 가능하다.
* var 은 변수명으로 선언이 가능하다.
``` java
int int = 1; //불가능
int var = 1; //가능
```
* Var는 런타임 오버헤드가 없다.
* Var 은 초기화 없이 사용이 불가능 하다.
* Var 타입 변수에는 Null 값이 들어갈수 없다.
	
    * 생각 해보면 Null 값은 어떤 변수타입도 아니기 때문이다.
    
* 주의
	
    * 자바 7의 다이아몬드 연산자 방식을 var 과 함께 사용하면 컴파일 에러가 발생한다.
    ``` java
    var message = new ArrayList<>(); //불가능
    ```
    * 그 이유는 <> 연산자 방식을 사용하면 컴파일러가 타입을 유추할수있는 정보가 없기 때문에 var로 타입을 유추 할 수 없게 된다. 
---
> 이번 과제를 하면서 느낀건데 그 동안 자바 컨벤션을 무시하고 코드를 작성하는 경우가 많았던것 같다. 앞으로는 최대한 자바 컨벤션을 지켜가면서 코드를 작성해야겠다.

  