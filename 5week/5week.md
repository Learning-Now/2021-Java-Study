# 5주차: 자바 익숙해지기

## 자바 기초
---
![](https://images.velog.io/images/donglee99/post/84ef5abe-62f5-42ad-abc2-0a45990744d3/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-02-03%20%EC%98%A4%ED%9B%84%208.50.23.png)
### Goal
> 자바가 제공하는 제어문을 학습하세요.

---
### 선택문
** 선택문 이란? **
* 선택문은 Java 언어에서 특정 데이터 값에 대한 수행할 구문을 정하는 문법을 선택문이라고 한다. (Switch Case 문이라고도 한다.)
* 다중 if문을 좀더 가독성 높게 처리 하기위한 방안으로 볼수 있음
~~_switch 문은 c, c++, python 에서 모두 비슷하게 쓰인다_~~

** switch 문의 예제 **
```java
int number = 10;
switch(number) {
	case 1:
    		System.out.println("number = 1");
	case 5:
    		System.out.println("number = 5");
    	case 10:
        	System.out.println("number = 10");
 }
```
* switch 문의 break는 필수 요소 였지만 자바 버젼이 올라감에 따라 문법의 변화가 생겨 break가 없이 사용이 가능 하게 되었다 
[더보기](https://velog.io/@donglee99/4주차-과제-자바-코드-작성해보기#(optional)-java13.-switch-연산자)

---
### 반복문
** 반복문이란? **
* 반복문은 특정 조건에 만족하는만큼 코드를 반복 시켜 실행을 하게 해주는 구문이다. (코드라인의 수를 줄여준다.) _반복문을 여러개 중첩하게 되면 실행속도가 저하될수있으니 상황에 맞게 잘 적용해야하며 최적화된 방법을 찾도록 노력해야한다_

** 반복문 예제(for, while, do-while) **
#### for 가장 기본적인 형태 (C++ 형식)
```java
    for( 초기화 식; 조건식; 증감식 ) {
        code;
    }
```

   ex)
  ```java
  for (int i = 0; i < 10; i++) {
      System.out.println(i);
  }
  // 초기화, 조건, 증감식이 모두 존재하는 경우 (따로 break 필요X)
  -----------------------------------------------------
  int i = 0;
  for (; i < 10; i++) {
      System.out.println(i);
  }
  // 조건, 증감식만 존재 (따로 break 필요X)
  -----------------------------------------------------
  for (int i = 0;; i++) {
      System.out.println(i);
  }
  //따로 break 를 걸어주지 않으면 무한 반복
  -----------------------------------------------------
  for (;;) {
      System.out.println(i);
  }
  //따로 break 를 걸어주지 않으면 무한 반복
  -----------------------------------------------------
  ```
* 다중 for문
```java
for(int i = 0; i< 10; i++) {
	for(int j = 0; j<10; j++){
    		System.out.print(j);
        }
        System.out.println();
}

/*
0123456789
0123456789
    .
    .
    .
0123456789
i -> 0 (j -> 0~9)
i -> 1 (j -> 0~9)
    .
    .
    .
i -> 9 (j -> 0~9)
*/
```
위 처럼 다중 포문은 for문안에 for문을 또 넣어 반복을 진행하는데 실행시간이 늘어나는 주된 이유가 되니 조심해야한다.

#### While문
* for 문과 비슷하지만 문법이 살짝 다르다
```java
int i = 0;
while(i<10) {
	i++;
}
// while 문에는 조건식만 넣고 증감식과 선언식은 따로둔다.
-----------------------------------------------------
for (int i = 0; i < 10; i++) {
	
}
//위 while 문과 같은 식이다.
-----------------------------------------------------
while(true) {
	
}
// while의 무한루프문
```
_ while 문도 다중 while이 가능하다_

#### do while 문
* 조건이 true, false 상관없이 무조건 한번은 실행한다.
``` java
do {
	System.out.print("1회 실행");
} while(false);
// 출력 : 1회 실행
```
---