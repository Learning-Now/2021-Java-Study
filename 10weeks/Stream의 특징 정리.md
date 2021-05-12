# Stream 특징 정리
## map()
- 스트림의 각 요소마다 수행할 연산을 구현할 때 사용한다.
```java
intList.stream().map(x -> x*x).forEach(System.out::println); // 1,4,9
```

## filter()
- 스트림 요소를 필터링 하기 위한 메소드이다.
- filter()는 스트림 요소마다 비교문을 만족하는 요소로 구성된 스트림을 반환한다.
- 특정 조건에 맞는 값만 추리기 위한 용도로 사용한다.
```java
intList.stream().filter(x -> x<=2).forEach(System.out::println);  // 1,2
```

## sorted()
- 스트림 요소를 정렬하는 메소드로 기본적으로 오름차순으로 정렬한다.
- sorted() 활용하는 방법은 몇 가지가 있는데 스트림 원소가 Comparable 인터페이스를 구현하고 있는 상태라면 다음과 같이 하면 된다.

Comparable 인터페이스 구현은 오름차순이라고 가정한다.
```java
Arrays.asList(1,4,3,2).stream().sorted().forEach(System.out::println); // 1,2,3,4
Arrays.asList(1,4,3,2).stream().sorted((a,b) -> b.compareTo(a)).forEach(System.out::println); // 4,3,2,1
Arrays.asList(1,4,3,2).stream().sorted( (a,b) -> -a.compareTo(b)).forEach(System.out::println); // 4,3,2,1
```
두번째와 세번째 방법은 오름차순 구현을 활용해 내림차순으로 처리할 때 사용할 수 있는 방법 이다.
내림차순 정렬을 위한 또다른 방법은 -a.compareTo(b) 를 사용하는 것인데 직관적이지 못해 권장하지는 않는다.
  
정렬에 사용되는 또다른 방법은 Comparator를 사용하는 것으로 새로운 정렬 조건을 지정하고자 한다면 sorted((a,b) -> { })와 같이 코드를 작성하면 된다.
```java
Arrays.asList(1,4,3,2).stream().sorted( Comparator.reverseOrder()).forEach(System.out::println); // 4,3,2,1
```

## distinct()
- distict()는 요소들의 중복을 제거하고 스트림을 반환한다.
```java
Arrays.asList(1,2,3,2,5).stream().distinct().forEach(System.out::println); // 1,2,3,5
```

## limit()
- 스트림의 시작 요소로부터 인자로 전달된 인덱스까지의 요소를 추출해 새로운 스트림을 생성한다.
```java
intList.stream().limit(2).forEach(System.out::println); // 1,2
```

## forEach()
- 스트림의 요소들을 순환하면서 반복해서 처리해야 하는 경우 사용한다.
```java
intList.stream().forEach(System.out::println); // 1,2,3
intList.stream().forEach(x -> System.out.printf("%d : %d\n",x,x*x)); // 1,4,9
```

## Reference
- [[Java] Stream](https://velog.io/@gillog/Java-Stream-Class)