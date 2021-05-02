# Stream의 특징
## Stream이란?

Stream은 Java8 에서 추가되었다. 기존 Java I/O에서 나오는 InputStream, OutputSteram과는 다른 것으로 함수형 프로그램에서 단계적으로 정의된 계산을 처리하기 위한 interface이다.

Stream은 Stream형태의 요소에 함수형 연산자를 지원해주는 class로 stream은 Array, collections와 같이 연속된 형태의 객체이다.

**Stream은 자료구조가 아니다.** 위와 같은 데이터를 입력으로 받아 method로 처리할 뿐이다. 

stream은 입력 받은 원래의 자료구조를 바꾸지는 못한다. 

대신, 파이프라인 형태로 연결된 method의 결과를 제공한다. 

원본 데이터를 바꾸지 못하는 특성 덕분에 side effect를 제거할 수 있다.

최종 연산자(terminal operation)는 stream의 끝을 의미하며 모든 연산자를 수행한 결과를 반환한다.

최종 연산자가지 모두 수행한 stream은 재활용할 수 없다.

- stream 예제

```java
int result = list.stream()// 스트림 생성
		.filter(...)// 중간 연산자
		.map(...)// 중간 연산자
		.count();// 최종 연산자
```

stream은 데이터의 흐름으로 배열 또는 컬렉션 인스턴스에 함수를 조합하여 원하는 결과를 필터링하고 가공된 결과를 손쉽게 처리할 수 있다.

Stream은 데이터 소스를 추상화하고 있으므로 데이터 소스에 상관 없이 같은 방식으로 처리할 수 있다는 장점이 있으며 데이터를 다루는 데 자주 사용되는 method들을 정의해두고 있어 기존 방식보다 간결하고 유연한 구현이 가능하다.

## Stream 연산 구조

Stream은 어떻게가 아니라 무엇을 할 것인지에 목적을 두고 사용해야 하며 연산의 파이프라인은 스트림 생성(Create) → 중간연산(Intermediate operating) → 최종연산(Final operation)의 형태를 가지며 이들은 .을 이용한 메소드 체이닝(Method Chaining)으로 구현된다.

```java
Collections 등 Object 집합.스트림생성().중간연산().최종연산();
```

중간연산 메소드는 리턴타입이 스트림이므로 계속해서 다른 스트림 메소드를 연결해서 사용할 수 있다.

최종연산 메소드는 리턴 타입이 스트림이 아닌 것으로 메소드 체이닝을 끝내는 역할을 한다.

최종연산이 실행 되어야 중간연산도 처리되기 때문에 중간연산들만으로 구성된 메소드 체인은 실행되지  않는다.

## 기존 방식과의 비교

### 기존 방식

```java

//동일한 데이터를 가지는 배열과 리스트를 선언.
//각각 데이터 정렬을 위한 메서드를 통해 데이터를 정렬.
//정렬된 값을 확인하기 위해 출력문을 이용해 출력.
String[] strArr = { "data1", "data2", "data3" }
List<String> strList = Arrays.asList(strArr);

//데이터 정렬을 위해 각각 Arrays, Collections 의 sort 메서드를 이용
//정렬한 다음 for 문을 이용해 결과를 출력하는 형식.
0
Arrays.sort(strArr);
Collections.sort(strList);

for(String str : strArr) {
  System.out.println(str);
}

for(String str : strList) {
  System.out.println(str);
}
```

### Stream API 사용

```java
//데이터 소스(배열 혹은 리스트)로 부터 스트림을 생성.
//정렬을 위해 sorted() 메서드를 호출.
//출력을 위해 forEach() 메서드를 호출.

strList.stream()
		.sorted()
		.forEach(System.out::println);
Arrays.stream(strArr)
		.sorted()
		.forEach(System.out::println);

//여기에서 forEach는 void forEach(Consumer<? super T> action) 로 정의되어 있음.
//Cosumer 함수형 인터페이스를 인자로 가진다. 
//메서드 레퍼런스를 사용하지 않고 람다식으로 표현하면 아래와 같다.

strList.stream()
		.sorted()
		.forEach(x -> System.out.println(x));
```

## Stream API 제공 method

### 생성 메소드

Collections, Array, String, File등으로부터 stream을 생성할 수 있다.

### Empty stream

비어 있는 스트림을 생성하기 위해서는 empty() 메소드를 사용한다.

```java
Stream<String> streamEmpty = Stream.empty();
```

### Arrays.stream()

배열로부터 스트림을 생성하는 방법은 여러 가지가 있다.

```java
Stream<String> arrayStream = Stream.of("a", "b", "c");
String[] arr = new String[]{"a", "b", "c"};
Stream<String> arrayFullStream = Arrays.stream(arr);
Stream<String> arrayPartStream = Arrays.stream(arr, 1, 3);
```

### Collections.stream()

자바 컬렉션 인터페이스를 사용하는 Collection, List, Set은 stream()메소드와 parallelStream() 메소드를 사용할 수 있다.

Map의 경우 Key 혹은 Value 값만 리스트로 추출한 다음 스트림을 만들어 사용할 수 있다.

```java
Collection<String> collection = Arrays.asList("a", "b", "c");
Stream<String> collectionStream = collection.stream();

List<String> names = new ArrayList<>();
names.add("Kang");
names.add("Hong");
names.stream()
		.forEach(System.out::println);
```

### String Stream

문자열을 다루는 클래스인 String, StringBuffer, StringBuilder는 문자열 시퀀스를 반환하는 chars() 메소드를 가지고 있는데 이를 통해 스트림을 생성하게 된다.

```java
IntStream charsStream = "abc".chars();
String str = "Hello World";
str.chars().filter(....)
```

### File Stream

파일의 경우 자바 NIO의 Files 클래스를 이용해 문자열 스트림 생성이 가능하다.

```java
Path path = Paths.get("C:/Tmp/testfile.txt");
Stream<String> streamOfStrings = Files.lines(path);
Stream<String> streamWithCharset = Files.lines(path, Charset.forName("UTF-8"));
```

### build()

```java
tream<String> generatedStream = Stream.<String>builder()
        .add("Hello")
        .add("World")
        .build();
```

### generate()

크기를 지정하지 않으면 무한하기 때문에 특정 사이즈만큼 생성하려면 반드시 limit을 통해 최대 크기를 제한해야 한다.

```java
Stream<String> generatedStream = Stream.generate(() -> "gen").limit(5);
```

### iterate()

초기 값을 시작으로 계속해서 2씩 증가된 값을 생성한다.

generate()와 마찬가지로 크기를 지정하지 않으면 무한하기 때문에 limit을 통해 크기를 제한해야 한다.

```java
Stream<Integer> iteratedStream = Stream.iterate(30, n -> n + 2).limit(5);
```

### parallel stream

병렬 스트림은 내부적으로 fork & join 프레임워크를 이용해 자동적으로 연산을 병렬로 수행한다. 병렬처리를 구현하기 위해 개발자가 신경써야 하는 많은 부분을 해결할 수 있으며 스트림 생성시 parallel() 메소드를 실행하기만 하면 된다.

병렬 스트림 처리에서 병렬처리를 중단하려면 sequential()을 호출하면 된다.

```java
int sum = strStream.parallel()
		.mapToInt(s -> s.length())
		.sum();
```

## 기본 타입형 스트림

IntStream, LongStream , DoubleStream

제네릭을 사용하지 않고 기본 값을 생성하는 방법이다.

제네릭을 사용하지 않기 때문에 불필요한 오토 박싱이 발생하지 않는다.

## 중간 연산 메소드

- 스트림 필터링: filter(), distinct()
- 스트림 변환: map(), flatMap()
- 스트림 제한: limit(), skip()
- 스트림 정렬: sorted()
- 스트림 연산 결과 확인: peek()
- 타입 변환: asDoubleStream(), asLongStream(), boxed()

여기에서 사용 되는 예제들은 모두 다음과 같은 리스트 데이터를 사용한다고 가정 한다.

```java
List<Integer> intList = Arrays.asList(1,2,3);
List<String> strList = Arrays.asList("Hwang", "Hong", "Kang");
```

### filter(), distinct()

스트림 요소를 필터링 하기 위한 메소드다.

filter()는 스트림 요소마다 비교문을 만족(true)하는 요소로 구성된 스트림을 반환한다.

즉, 특정 조건에 맞는 값만 추리기 위한 용도로 사용한다.

distinct()는 요소들의 중복을 제거하고 스트림을 반환한다.

```java
intList.stream()
		.filter(x -> x <= 2)
		.forEach(System.out::println);
//1,2

Arrays.asList(1,2,3,2,5).stream()
		.distinct()
		.forEach(System.out::println);
//1,2,3,5,
```

### map()

스트림의 각 요소마다 수행할 연산을 구현할 때 사용한다.

```java
intList.stream()
		.map(x -> x * x)
		.forEach(System.out::println);
//1,4,9
```

### flatMap()

기존의 요소를 새로운 요소로 대체한 스트림을 생성한다.

```java
Arrays.asList(intList, Arrays.asList(2,5)).stream()
		.flatMap(i -> i.stream())
		.forEach(System.out::println);
// 1,2,3,2,5

strList.stream()
		.flatMap(message -> Arrays.stream(message.split("an")))
		.forEach(System.out::println);
```

### limit()

스트림의 시작 요소로부터 인자로 전달된 인덱스까지의 요소를 추출해 새로운 스트림을 생성한다.

```java
intList.stream().
		.limit(2)
		.forEach(System.out::println);
// 1,2
```

### skip()

스트림의 시작 요소로부터 인자로 전달된 인덱스까지를 제외하고 새로운 스트림을 생성한다.

```java
intList.stream()
		.skip(2)
		.forEach(System.out::println);
//3
```

### sorted

스트림 요소를 정렬하는 메소드로 기본적으로 오름차순으로 정렬한다.

sorted()를 활용하는 방법은 몇 가지가 있다.

### peek()

결과 스트림의 요소를 사용해 추가로 동작을 수행한다.

원본 스트림을 이용하는 것이 아니므로 스트림 연산 과정에서 중간중간 결과를 확인할 때 사용할 수 있다.

최종 연산인 forEach()처럼 반복해서 요소를 처리하는 메소드이며 중간연산이므로 최종연산 메소드가 실행되지 않으면 지연되기 때문에 반드시 최종연산 메소드가 호출되어야 동작한다.

앞의 filter() 예제를 보면 최종 연산으로 forEach() 를 이용해 출력하고 있다.

**만일 최종 연산이 forEach() 가 sum() 이나 다른 최종연산이라면 값을 출력해볼 방법이 없다.**

그렇다고 변환된 컬렉션을 가지고 출력을 위해 다시 스트림 연산을 한다면 불편할 수 있다.

**이 경우 peak() 이 유용하게 사용될 수 있다.**

```java
int sum = intList.stream().filter(x -> x<=2)
	.peek(System.out::println)
	.mapToInt(Integer::intValue).sum();
System.out.println("sum: "+sum);
```

## 최종 연산 메소드

최종연산은 결과값만 리턴되므로 별도의 출력문을 연결해 사용하기 어렵다.

- 요소의 출력: forEach()
- 요소의 소모: reduce()
- 요소의 검색: anyFirst(), findAny()
- 요소의 검사: antMatch(), allMatch(), nonMatch()
- 요소의 통계: count(), min(), max()
- 요소의 연산: sum(), average()
- 요소의 수집: collect()

### forEach()

스트림의 요소들을 순환하면서 반복해서 처리해야 하는 경우 사용한다.

```java
intList.stream()
		.forEach(System.out::println); 
// 1,2,3

intList.stream()
		.forEach(x -> System.out.printf("%d : %d\n",x,x*x)); 
// 1,4,9
```

### reduce()

map 과 비슷하게 동작하지만 개별 연산이 아니라 누적연산이 이루어진다는 차이가 있다. 

두 개의 인자 즉, n, n+1을 가지며 연산 결과는 n이 되고 다시 다음 요소와 연산을 하게 된ㄴ다. 즉 1,2 번째 요소를 연산하고 그 결과와 3번째 요소를 연산하는 식이다.

```java
int sum = intList.stream().
		reduce((a,b) -> a + b.get();

System.out.println("sum: " + sum);
//6
```

### findFirst(), findAny()

두 메소드는 스트림에서 지정한 첫 번째 요소를 찾는 메소드이다.

보통 filter() 와 함께 사용되고 finAny()는 parallelStream() 에서 병렬 처리시 가장 먼저 발견된 요소를 찾는 메소드로 결과는 스트림 원소의 정렬 순서와 상관 없다.

```java
strList.stream().filter(s -> s.startsWith("H")).findFirst().ifPresent(System.out::println);  //Hwang
strList.parallelStream().filter(s -> s.startsWith("H")).findAny().ifPresent(System.out::println);  //Hwang or Hong
```

findAny() 를 parallelStream() 과 함께 사용하는 경우 일반적으로 findFrist()와 결과가 같다.(반드시 보장되는 것은 아니다.)

arallelStream() 과 사용한 경우 실제 스트림 순서와는 다르게 선택될 수 있다.

findFirst()와 findAny()의 리턴값은 Optional이므로 ifPresent()를 이용해 출력한다.

### anyMatch(), allMatch(), nonMatch()

스트림의 요소 중 특정 조건을 만족하는 요소를 검사하는 메소드다.

원소 중 일부, 전체 혹은 일치하는 것이 없는 경우를 검사하고 boolean값을 리턴한다.

nonMatch()의 경우 일치하는 것이 하나도 없을 때 true를 리턴한다.

```java
boolean result1 = strList.stream().anyMatch(s -> s.startsWith("H"));  //true
boolean result2 = strList.stream().allMatch(s -> s.startsWith("H"));  //false
boolean result3 = strList.stream().noneMatch(s -> s.startsWith("T")); //true
System.out.printf("%b, %b, %b",result1,result2, result3);
```

### count(), min(), max()

스트림의 원소들로부터 전체개수, 최솟값, 최댓값을 구하기 위한 메소드다.

min(), max()의 경우 Comparator를 인자로 요구하고 있으므로 기본 Comparator들을 사용하거나 직접 람다 표현식으로 구현해야 한다.

```java
intList.stream()
		.count();
// 3
intList.stream()
		.filter(n -> n != 2)
		.count()
// 2
intList.stream()
		.min(Integer::compare)
		.ifPresent(System.out::println);
// 3

strList.stream()
		.count();
// 3
strList.stream()
		.min(String::compareToIgnoreCase)
		.ifPresent(System.out::println);
strList.stream()
		.max(String::compateTo)
		.ifPresent(System.out::println);
//Kang
```

### sum(), average()

스트림 원소들의 합계를 구하거나 평균을 구하는 메소드이다.

reduce(), map()을 이용해도 구현이 가능하다.

이 경우 리턴값이 Optional이기 때문에 ifPresent()를 이용해 갑슬 출력할 수 있다.

```java
intList.stream()
		.mapToInt(Integer::intValue)
		.sum();
// 6
intList.stream()
		.reduce((a,b) -> a + b)
		.ifPresent(System.out::println);
// 6

intList.stream()
		.mapToInt(Integer::intValue)
		.average();
// 2
intList.stream()
		.reduce((a, b) -> a + b)
		.map(n -> n / intList.size())
		.ifPresent(System.out::println);
// 2
```

### collect()

스트림의 결과를 모으기 위한 메소드로 Collectors 객체에 구현된 방법에 따라 처리하는 메소드다.

최종 처리 후 데이터를 변환하는 경우가 많기 때문에 자주 사용된다.

Collectors 의 메소드는 다음과 같다.

- 스트림을 열이나 컬렉션으로 변환: toArray(), toCollection(), toList(), toSet(), toMap()
- 요소의 통계와 연산 메소드와 같은 동작을 수행: counting(), maxBy(), minBy(),, summingInt(), averagingInt()
- 요소의 소모와 같은 동작을 수행: reducing(), joining()
- 요소의 그룹화와 분할: groupingBy(), partitioningBy()

```java
strList.stream()
		.map(String::toUpperCase)
		.collect(Collectors.joining("/"));
// Hwang/Hong/Kang
strList.stream()
		.collect(Collectors.toMap(k -> k, v -> v.length()));
// {Hong=4, Hwang=5, Kang=4}

intList.stream()
		.collect(Collectors.counting());
intList.stream()
		.collect(Collectors.maxBy(Integer::compare));
intList.stream()
		.collect(Collectors.reducing((a,b) -> a + b));
// 6
intList.stream()
		.collect(Collectors.summarizinInt(x -> x));
//IntSummaryStatistics{count=3, sum=6, min=1, average=2.000000, max=3}

Map<Boolean, List<String>> group = strList.stream()
		.collect(Collectors.groupingBy(s -> s.startsWtith("H")));
group.get(true).forEach(System.out::println);
// Hwang, Hong

Map<Boolean, List<String>> partition = strList.stream()
		.collect(Collectors.partitioningBy(s -> s.startsWith("H")));

partition.get(true).stream()
		.forEach(System.out::println);
// Hwang, Hong
```

- toMap()을 사용해서 문자열 스트림의 값을 키로 하고 문자열의 길이를 값으로 하는 맵으로 변환
- counting, maxBy, reducing은 각각 count(), max9), reuce() 메소드와 동일한 결과
- summarizinInt는 IntSummaryStatistics를 리턴하여 count, sum, min, average, max 값을 참조할 수 있음
- groupingBy는 특정 조건에 따라 데이터를 구분해서 저장
- partitioningBy는 특정 조건으로 데이터를 두 그룹으로 나누어 저장

## 스트림 Streams

자바 8에서 추가한 스트림은 람다를 활용한 수 있는 기술 중 하나이다. 자바 8 이전에는 배열 또는 컬렉션 인스턴스를 다루는 방법은 for 또는 foreach 문을 돌면서 요소 하나씩 꺼내서 다루는 방법이었다. 간단한 경우라면 상관 없지만 로직이 복잡해질수록 코드의 양이 많아져 여러 로직이 섞이게 되고, 메소드를 나눌 경우 루프를 여러 번 도는 경우가 발생한다.

스트림은 '데이터의 흐름'이다. 배열 또는 컬렉션 인스턴스에 함수 여러 개를 조합해서 원하는 결과를 필터링하고 가공된 결과를 얻을 수 있다. 또한 람다를 이용해서 코드의 양을 줄이고 간결하게 표현할 수 있다. 즉, 배열과 컬렉션을 함수형으로 처리할 수 있다.

또 하나의 장점은 간단하게 병렬처리(multi-threding)가 가능하다는 점이다. 하나의 작업을 둘 이상의 작업으로 잘게 나눠서 동시에 진행하는 것을 병렬처리(parallen processing)라고 한다. 즉 쓰레드를 이용해 많은 요소들을 빠르게 처리할 수 있다.

스트림에 대한 내용은 크게 세 가지로 나눌 수 있다.

- 생성하기: 스트림 인스턴스 생성.
- 가공하기: 필터링(filtering) 및 맵핑(mapping) 등 원하는 결과를 만들어가는 중간 작업(intermediate operations).
- 결과 만들기: 최종적으로 결과를 만들어내는 작업(terminal operations).
- 전체 → 맵핑 → 필터링1 → 필터링2 → 결과 만들기 → 결과물

## 생성하기

보통 배열과 컬렉션을 이용해 스트림을 만들지만 이 외에도 다양한 방법으로 스트림을 만들 수 있다.

### 배열 스트림

스트림을 이용하기 위해서는 먼저 생성해야 한다. 스트림은 배열 또는 컬렉션 인스턴스를 이용해서 생성할 수 있다. 배열은 다음과 같이 [Arrays.stream](http://arrays.stream) 메소드를 사용한다.

```java
String[] arr = new String[]{"a", "b", "c"};
Stream<String> stream = Arrays.stream(arr);
Stream<String> stream0fArrayPart = Arrays.stream(arr, 1, 3);// 1~2 요소 [b, c]
```

### 컬렉션 스트림

컬렉션 타입(Collection, List, Set)의 경우 인터페이스에 추가된 디폴트 메소드 stream을 이용해서 스트림을 만들 수 있다.

```java
public interface Collection<E> extends Iterable<E> {
  default Stream<E> stream() {
    return StreamSupport.stream(spliterator(), false);
  } 
  // ...
}
```

그러면 다음과 같이 생성할 수 있다.

```java
List<String> list = Arrays.asList("a", "b", "c");
Stream<String> stream = list.stream();
Stream<String> parallelStream = list.parallelStream(); // 병렬 처리 스트림
```

### 비어 있는 스트림

비어 있는 스트림(empty streams)도 생성할 수 있다. 언제 빈 스트림이 필요할까? 빈 스트림은 요소가 없을 때 null 대신 사용할 수 있다.

```java
public Stream<String> streamOf(List<String> list) {
  return list == null || list.isEmpty() 
    ? Stream.empty() 
    : list.stream();
}
```

### Stream.builder()

빌더(Builder)를 사용하면 스트림에 직접적으로 원하는 값을 넣을 수 있다. 마지막에 build 메소드로 스트림을 리턴한다.

```java
Stream<String> builderStream = 
  Stream.<String>builder()
    .add("Eric").add("Elena").add("Java")
    .build(); // [Eric, Elena, Java]
```

### Stream.generate()

generate 메소드를 이용하면 Supplier<T> 에 해당하는 람다로 값을 넣을 수 있다. Supplier<T>는 인자는 없고 리턴 값만 있는 함수형 인터페이스이다. 람다에서 리턴하는 값이 들어간다.

```java
public static<T> Stream<T> generate(Supplier<T> s) {...}
```

이때 생성되는 스트림은 크기가 정해져있지 않고 무한하기 때문에 특정 사이즈로 최대 크기를 제한해야 한다.

```java
Stream<String> generatedStream = Stream.generate(() -> "gen").limit(5); // [el, el, el, el, el]
```

5개의 "gen"이 들어간 스트림이 생성된다.

### Stream.iterate()

iterate 메소드를 이용하면 초기값과 해당 값을 다루는 람다를 이용해서 스트림에 들어갈 요소를 만든다. 아래에서는 30이 초기값이고 값이 2씩 증가하는 값들이 들어가게 된다. 즉 요소가 다음 요소의 인풋으로 들어간다. 이 방법도 스트림의 사이즈가 무한하기 때문에 특정 사이즈로 제한해야 한다.

```java
Stream<Integer> iteratedStream = 
  Stream.iterate(30, n -> n + 2).limit(5); // [30, 32, 34, 36, 38]
```

### 기본 타입형 스트림

제네릭을 사용하면 리스트나 배열을 이용해서 기본 타입(int, long, double) 스트림을 생성할 수 있다. 하지만 제네릭을 사용하지 않고 직접적으로 해당 타입의 스트림을 다룰 수도 있다. range와 rangeClosed 는 범위의 차이가 잇다. 두 번째 인자인 종료지점이 포함되느냐 안 되느냐의 차이를 가진다.

```java
IntStream intStream = IntStream.range(1, 5); // [1, 2, 3, 4]
LongStream longStream = LongStream.rangeClosed(1, 5); // [1, 2, 3, 4, 5]
```

제네릭을 사용하지 않기 때문에 불필요한 오토토박싱이 일어나지 않는다. 필요한 경우 boxed 메소드를 이용해서 박싱할 수 있다.

```java
Stream<Integer> boxedIntStream = IntStream.range(1, 5).boxed();
```

자바 8의 Random 클래스는 난수를 가지고 세 가지 타입의 스트림(IntStream, LongStream, doubleStream)을 만들어낼 수 있다. 쉽게 난수 스트림을 생성해서 여러 가지 후속 작업을 취할 수 있어 유용하다.

```java
DoubleStream doubles = new Random().doubles(3); // 난수 3개 생성
```

### 스트림 연결하기

Stream.concat 메소드를 이용해 두 개의 스트림을 연결해서 새로운 스트림을 만들어낼 수 있다.

```java
Stream<String> stream1 = Stream.of("Java", "Scala", "Groovy");
Stream<String> stream2 = Stream.of("Python", "Go", "Swift");
Stream<String> concat = Stream.concat(stream1, stream2);
// [Java, Scala, Groovy, Python, Go, Swift]
```

## 가공하기

전체 요소 중에서 다음과 같은 API를 이용해 원하는 것만 뽑아낼 수 있다. 이러한 가공 단계를 중간 작업(intermediate operations)이라고 하는데, 이러한 작업은 스트림을 리턴하기 때문에 여러 작업을 이어 붙여서(chaining)작성할 수 있다.

```java
List<String> names = Arrays.asList("Eric", "Elena", "Java");
```

아래 예저들은 위의 리스트를 대상으로 한다.

### Filtering

필터는 스트림 내 요소들을 하나씩 평가해서 걸러내는 작업이다. 인자로 받는 Perdicate 는 boolean을 리턴하는 함수형 인터페이스로 평가식이 들어가게 된다.

```java
Stream<T> filter(Predicate<? super T> predicate);
```

```java
Stream<String> stream = 
  names.stream()
  .filter(name -> name.contains("a"));
// [Elena, Java]
```

스트림의 각 요소에 대해서 평가식을 실행하게 되고 'a'가 들어간 이름만 들어간 스트림이 리턴된다.                                    

### Mapping

  맵은 스트림 내 요소들을 하나씩 특정 값으로 변환해준다. 이때 값을 변환하기 위한 람다를 인자로 받는다.

```java
<R> Stream<R> map(Function<? super T, ? extends R> mapper);
```

스트림에 들어가 있는 값이 input이 되어서 특정 로직을 거친 후 output이 되어 리턴되는 새로운 스트림에 담기게 된다. 이러한 작업을 맵핑이라고 한다.

아래는 스트림 내 String의 toUpperCase 메소드를 실행해서 대문자로 변환한 값들이 단긴 스트림을 리턴하는 예제이다.

```java
Stream<String> stream =
	names.stream()
	.map(String::toUpperCase);
// [ERIC, ELENA, JAVA]
```

다음처럼 요소 내 들어있는 Product 개체의 수량을 꺼내올 수도 있다. 각 '상품'을 '상품의 수량'으로 맵핑하는 것이다.

```java
Stream<Integer> stream =
	productList.stream()
	.map(Product::getAmount);
// [23, 14, 13, 23, 13]
```

### Sorting

정렬의 방법은 다른 정렬과 마찬가지로 Comparator를 이용한다.

```java
Stream<T> sorted();
Stream<T> sorted(Comparator<? super T> comparator);
```

인자 없이 그냥 호출할 경우 오름차순으로 정렬한다.

```java
IntStream.of(14, 11, 20, 39, 23)
	.sorted()
	.boxed()
	.collect(Collectiors.toList());
// [11, 14, 20, 23, 39]
```

인자를 넘기는 경우와 비교해보자. 스트링 리스트에서 알파벳 순으로 정렬한 코드와  Comparator를 넘겨서 역순으로 정렬한 코드이다.

```java
List<String> lang = 
  Arrays.asList("Java", "Scala", "Groovy", "Python", "Go", "Swift");

lang.stream()
	.sorted()
	 .collect(Collectors.toList());
// [Go, Groovy, Java, Python, Scala, Swift]

lang.stream()
	.sorted(Comparator.reverseOrdeder())
	.collect(Collectors.toList());
// [Swift, Scala, Python, Java, Groovy, Go]
```

Comparator의 comparte 메소드는 두 인자를 비교해서 값을 리턴한다.

```java
int compare(T o1, T o2)
```

기본적으로 Comparator 사용법과 동일하다. 이를 이용해서 문자열 길이를 기준으로 정렬하자.

```java
lang.stream()
	.sorted(Comparator.comparingInt(String::length))
	.collect(Collectors.toList());
// [Go, Java, Scala, Swift, Groovy, Python]

lang.stream()
	.sorted((s1, s2) -> s2.length() - s1.length())
	.collect(Collectors.toList());
// [Groovy, Python, Scala, Swift, Java, Go]
```

### Iterating

스트림 내 요소들 각각을 대상으로 특정 연산을 수행하는 메소드로는 peek이 있다. 'peek'은 그냥 확인해본다는 단어 뜻처럼 특정 결과를 반환하는 않는 함수형 인터페이스 Consumer 를 인자로 받는다.

```java
Stream<T> peek(Consumer<? super T> acton);
```

따라서 스트림 내 요소들 각각에 특정 작업을 수행할 뿐 결과에 영향을 미치지 않는다. 다음처럼 작업을 처리하는 중간에 결과를 확인해볼 때 사용할 수 있다.

```java
int sum = IntStream.of(1, 3, 5 , 7, 9)
	.peek(System.out::println)
	.sum();
```

## 결과 만들기

가공한 스트림을 가지 내가 사용할 결과값으로 만들어내는 단계이다. 따라서 스트림을 끝내는 최종 작업(terminal operations)이다.

### Calcuating

스트림 API는 다양한 종료 작업을 제공한다. 최소, 최대, 합, 평균 등 기본형 타입으로 결과를 만들어낼 수 있다.

```java
long count = IntStream.of(1, 3, 5, 7, 9).count();
long sum = LongStream.of(1, 3, 5, 7, 9).sum();
```

만약 스트림이 비어 있는 경우 count와 sum은 0을 출력하면 된다. 하지만 평균, 최소, 최대의 경우에는 표현할 수 없기 때문에 Optional을 이용해 리턴한다.

```java
OptionalInt min = IntStream.of(1, 3, 5, 7, 9).min();
OptionalInt max = IntStream.of(1, 3, 5, 7, 9).max();
```

스트림에서 바로  ifPresent 메소드를 이용해서 Optional을 처리할 수 있다.

```java
DoubleStream.of(1.1, 2.2, 3.3, 4.4, 5.5)
	.average()
	.ifPresent(System.out::println);
```

이 외에도 사용자가 원하는대로 결과를 만들어내기 위해 reduce와 collect 메소드를 제공한다.

# Java 스트림 Stream

배열의 원소를 가공하는 데 있어 아래와 같은 것을 사용할 수 있다.

- map: 요소들을 특정 조건에 해당하는 값으로 변환해 준다.(요소들을 대소문자 변형 등의 작업을 하고 싶을 때)
- filter: 요소들을 조건에 따라 걸러내는 작업을 해준다. (길이의 제한, 특정문자포함 등의 작업을 하고 싶을 때)
- sorted: 요소들을 정렬해주는 작업을 해준다.

요소들의 가공이 끝났다면 리턴해줄 결과를 collect를 통해 만들어준다.

## Test Set

```java
ArrayList<string> list = new ArrayList<>(Arrays.asList("Apple","Banana","Melon","Grape","Strawberry"));

System.out.println(list);

//[Apple, Banana, Melon, Grape, Strawberry]
```

### map

```java
list.stream().map(s->s.toUpperCase());
list.stream().map(String::toUpperCase);
```

리스트의 요소들을 대문자로 변경해준다.

요소들을 대문자로 가공했다면 collect를 이용해 결과를 리턴받을 수 있고, forEach를 이용해 바로 출력해볼 수 있다.

```java
System.out.println(list.stream()
		.map(s->s.toUpperCase())
		.collect(Collectors.joining(" ")));
//APPLE BANANA MELON GRAPE STRAWBERRY

System.out.println(list.stream()
		.map(s->s.toUpperCase())
		.collect(Collectors.toList()));
//[APPLE, BANANA, MELON, GRAPE, STRAWBERRY]

System.out.println(list.stream()
		.map(String::toUpperCase)
		.collect(Collectors.toList()));
//[APPLE, BANANA, MELON, GRAPE, STRAWBERRY]

list.stream()
		.map(String::toUpperCase)
		.forEach(s -> System.out.println(s));
//APPLE
//BANANA
//MELON
//GRAPE
//STRAWBERRY
```

Collectors.joining을 이용해 리스트의 조인을 기준으로 배치할 수 있다.  String으로 리턴한다.

Collectors.toList를 이용해 리스트로 리턴 받을 수 있다.

forEach를 이용해 요소마다 각각 작업을 할 수 있다.

### filter

```java
list.stream()
		.filter(t->t.length()>5)
```

filter는 요소를 특정 기준으로 걸러낼 수 있다.

요소의 크기가 5이상인 값만 뽑아낸다.

```java
System.out.println(list.stream()
		.filter(t->t.length()>5)
		.collect(Collectors.joining(" ")));
// Banana Strawberry

System.out.println(list.stream()
		.filter(t->t.length()>5)
		.collect(Collectors.toList()));
// [Banana, Strawberry]
```

마찬가지로 filter로 가공한 결과를 얻을 수 있다.

### sorted

```java
list.stream()
		.sorted()
```

리스트의 요소를 정렬한다.

```java
System.out.println(list.stream()
		.sorted()
		.collect(Collectors.toList()));
//[Apple, Banana, Grape, Melon, Strawberry]
```

# Reference

- [Java 스트림 Stream (1) 총정리]([https://futurecreator.github.io/2018/08/26/java-8-streams/](https://futurecreator.github.io/2018/08/26/java-8-streams/))
- [Java 스트림 Stream (2) 고급]([https://futurecreator.github.io/2018/08/26/java-8-streams-advanced/](https://futurecreator.github.io/2018/08/26/java-8-streams-advanced/))
- [자바 스트림Stream(map, filter, sorted / collect, foreach)]([https://dpdpwl.tistory.com/81](https://dpdpwl.tistory.com/81))
- [Java8의 stream distinct 사용 방법 및 예제. chacha.]([https://codechacha.com/ko/java8-stream-distinct/](https://codechacha.com/ko/java8-stream-distinct/))
- [Stream?. Velog.]([https://velog.io/@gillog/Java-Stream-Class](https://velog.io/@gillog/Java-Stream-Class))