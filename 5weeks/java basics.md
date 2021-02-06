# 자바 기초

# 제어문(Control Flow Statement)
- 프로그램 실행 흐름을 개발자가 원하는 방향으로 바꿀 수 있도록 해주는 것
- 일반적으로 조건식과 실행 구문인 중괄호(블럭, {})으로 구성되어 있다.

### 제어문의 종류
- 조건문(decision-making statements): if-statement, switch-statement 
  - 선택문
- 반복문(looping statements): for-statement, while-statement
- 분기문(branching statements): break, continue, return



## 조건문 if-statement

### 조건문 if
if문은 주어진 조건식이 참이면 값을 산출하고 거짓이면 실행하지 않는다.
```java
public class JavaExam{
    public static void main(String[] args) {
        
        int score = 95;

        if (score >= 90) {
            System.out.println("90보다 크거나 같다");
        }

        if (score < 90) {
            System.out.println("90보다 작다");
        }
    }
}
```

결과값
> 90보다 크거나 같다.

### 조건문 if-else

```java
public class IfElseExam {
    public static void main(String[] args) {
        int a = 10;
        if (a % 2 == 0) {
            System.out.println(a + "는 짝수");// 실행
        } else {
            System.out.println(a + "는 홀수");
        }
    }
}
```

```java
public class IfElseExam2 {
    public static void main(String[] args) {
        int a = 10, b =20, c = 9, max;
        if (a > b && a > c) {
            max = a;
        } else {
            if (b > c) {
                max = b;
            } else {
                max = c;
            }
        }
        System.out.println("max = " + max);
    }
}
```

### 조건문 if-else if

```java
public class ElseIfExam {
    public static void main(String[] args) {
        int age = 22;
        if (age >= 20 && age < 30) {
            System.out.println("20대");
        } else if (age < 20) {
            System.out.println("10대 이하");
        } else {
            System.out.println("30대 이상");
        }
    }
}
```

## 조건문(선택문) switch-statement

### 선택문 switch

```java
public class SwitchExam {
    public static void main(String[] args) {
        int diceScore = 3;

        switch (diceScore) {
            case 1:
                System.out.println("score 1");
                break;
            case 2:
                System.out.println("score 2");
                break;
            case 3:
                System.out.println("score 3");
                break;
            case 4:
                System.out.println("score 4");
                break;
            case 5:
                System.out.println("score 5");
                break;
            case 6:
                System.out.println("score 6");
                break;    
        }
    }
}
```

## 반복문 for-statement

### 반복문 for

- e.g. for-statement
```java
public class ForExam {
    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            System.out.println("'i' is : " + i);
        }
    }
}
```

- e.g. for infinity loop
```
for (int i = 0; true; i++){
    System.out.println("'i' is : " + i);
}
```

```
for ( ; ; ){
    System.out.println("hi");
}
```

> break를 통해 loop를 탈출할 수 있다.

### 반복문 다중 for

- e.g. 다중 for. 구구단
```java
public class MultiForExam {
    public static void main(String[] args) {
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                System.out.println(i + "*" + j + "=" + (i*j) + " ");
            }
            System.out.println("");// next line
        }
    }
}
```

## 반복문 while-statement

### 반복문 while

```java
public class WhileExam {
    public static void main(String[] args) {
        int i = 0;// 도와주는 변수 선언

        while (i < 10) {// 소괄호 안에 조건
            i++;
        }
    }
}
```

### 반복문 while infinity loop
```java
public class WhileExam {
    public static void main(String[] args) {
        while (true) {
            // 무한 루프
        }
    }
}
```

### 반복문 do while
```java
public class WhileExam {
    public static void main(String[] args) {
        do {
            System.out.println("hello");
        } while (false);
    }
}
```
조건이 false여도 do 블럭 안의 코드를 한 번은 실행한다.

### for문과 while문
- for: 도와주는 변수를 조건식에서 선언 할 경우 for문이 끝나면 사라진다.
- while: 밖에서 선언하기 때문에 사라지지 않는다.
