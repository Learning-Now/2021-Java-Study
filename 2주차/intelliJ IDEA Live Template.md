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
for (int i = 0; i < limit; i++) {
            
}
```
### 3-11. iter + Tab
```
for (String arg : args) {

}
```