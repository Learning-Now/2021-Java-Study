# [Java] intelliJ IDEA Live Template

## 1. Live Template이란
특정 **Abbreviation(축약형)**값을 입력하면 자주 쓰는 코드 구성을 불러오는 기능이다.

## 2. Live Template 확인하기
1. 우측 상단에 [IntelliJ IDEA] - [Preferences...]를 클린한다.

[![설정](https://images.velog.io/images/minide/post/a76df2bb-6a1e-4fb6-a976-77c9ec668d8a/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-07%20%EC%98%A4%EC%A0%84%209.51.40.png)](https://github.com/jeongyuneo/2021-Java-Study/blob/jeongyun/image/preferences.jpeg)

2. [Editor] - [Live Templates]를 선택하거나 우측 검색창에 'Live Templates'를 검색한다.

[![Live Templates 확인](https://images.velog.io/images/minide/post/3b0d8f2b-57b7-4aec-896c-088ca525561d/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-07%20%EC%98%A4%EC%A0%84%209.53.24.png)](https://github.com/jeongyuneo/2021-Java-Study/blob/jeongyun/image/livetemplates.jpeg)

3. 원하는 언어를 찾아 Live Template를 확인한다.

## 3. 자주 쓰이는 Java Live Template
### 3-1. psvm + Tab
```java
public static void main(String[] args){

        }
```
### 3-2. main + Tab
```java
public static void main(String[] args){

        }
```
### 3-3. sout + Tab
```java
System.out.println();
```
### 3-4. soutf + Tab
```java
System.out.printf("");
```
### 3-5. soutp + Tab
```java
System.out.println(method parameter names and values);
```
### 3-6. soutm + Tab
```java
System.out.println("curren class and method names");
```
### 3-7. soutv + Tab
```java
System.out.println(values);
```
### 3-8. serr + Tab
```java
System.err.println();
```
### 3-9. St + Tab
```java
String
```
### 3-10. fori + Tab
```java
for (int i = 0; i < ; i++) {

        }
```
### 3-11. iter + Tab
```
for (String arg : args) {

}
```

## 4. Live Template 만들기
1. 우측 상단에 [IntelliJ IDEA] - [Preferences...]를 클린한다.

[![설정](https://images.velog.io/images/minide/post/a76df2bb-6a1e-4fb6-a976-77c9ec668d8a/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-07%20%EC%98%A4%EC%A0%84%209.51.40.png)](https://github.com/jeongyuneo/2021-Java-Study/blob/jeongyun/image/preferences.jpeg)

2. [Editor] - [Live Templates]를 선택하거나 우측 검색창에 'Live Templates'를 검색한다.

[![Live Templates 확인](https://images.velog.io/images/minide/post/3b0d8f2b-57b7-4aec-896c-088ca525561d/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-07%20%EC%98%A4%EC%A0%84%209.53.24.png)](https://github.com/jeongyuneo/2021-Java-Study/blob/jeongyun/image/livetemplates.jpeg)

3. 원하는 언어를 선택하고 오른쪽에 [+]를 누르고 [1. Live Template]를 선택한다.

![](https://images.velog.io/images/minide/post/c2213c55-de6a-4b23-a8b1-98b75089a6a7/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-09%20%EC%98%A4%ED%9B%84%209.45.01.png)

4. [Abbre iation]에 원하는 단축어를 적고 [Description]에 간단한 설명을 적는다. [Description]은 생략해도 무방하다.
   [Template text]에 코드를 적는다.

![](https://images.velog.io/images/minide/post/047eaf5d-bf0d-478f-a78e-bd4bd50d774b/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-09%20%EC%98%A4%ED%9B%84%209.55.04.png)

5. 여기까지만 하고 적용하면 제대로 동작하지 않음을 알 수 있다.
   내가 만든 Live Template에서 오른쪽 마우스를 클릭하고 [Change context]를 선택한다.

![](https://images.velog.io/images/minide/post/54172bec-ce1c-4bf7-bc51-fa20381b7687/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-09%20%EC%98%A4%ED%9B%84%209.49.54.png)

6. Live Template에 해당하는 언어를 선택하고, 단축키에 맞는 context를 설정해준다.

![](https://images.velog.io/images/minide/post/472e1330-cec9-434f-a447-06063e89ba26/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-09%20%EC%98%A4%ED%9B%84%209.51.08.png)

설정 후 저장하면 내가 만든 Live Template을 사용할 수 있다.

![](https://images.velog.io/images/minide/post/5977ebfa-e7cf-411d-a986-e0551eead60c/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-09%20%EC%98%A4%ED%9B%84%209.51.25.png)