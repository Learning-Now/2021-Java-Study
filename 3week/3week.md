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
	
    * 카멜 표기법은 단어의 첫 글자를 대문자로 표기하는 표기법이다.
    ``` java
    public class Donglee99{
    }
* 클래스 이름에 명사 사용
	
    * 클래스 이름은 명사나 명사절로 짓는다.
    ``` java
    public class sum{
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
	
    * 이는 위에서 메서드 이름 부분에 예를 들어놨으니 생략 하겠다.
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
---

### 프리미티브 타입 종류와 값의 범위 그리고 기본 값
---
### 프리미티브 타입과 래퍼런스 타입
---
### 리터럴
---
### 변수 선언 및 초기화하는 방법
---
### 변수의 스코프와 라이프타임
---
### 타입 변환, 캐스팅 그리고 타입 프로모션
---
### 1차 및 2차 배열 선언하기
---
### 타입 추론, var  