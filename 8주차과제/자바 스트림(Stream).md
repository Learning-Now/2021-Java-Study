# 자바 스트림(Stream) 정리

## 스트림(Stream)이란?
> 자바 8부터 추가된 컬렉션의 저장 요소를 하나씩 참조해 람다식으로 처리할 수 있도록 해주는 반복자  
> Iterator과 비슷한 역할을 하지만 람다식을 이용해 코드가 좀 더 간결할 수 있다.

1. 생성하기: 스트림 인스턴스 생성  
2. 가공하기: 필터링 및 맵핑 등 원하는 결과를 만들어가는 과정  
3. 결과 만들기: 최종적으로 결과를 만들어내는 작업

## 생성하기

### 배열 스트림
Arrays.stream 메소드를 이용
```
String[] strArr = new String[]{"김가나", "이다라", "박마바"};
Stream<String> stream = Arrays.stream(strArr);
Stream<String> streamOfArrayPart = 
  Arrays.stream(strArr, 1, 3); // 1~2 요소 ["이다라", "박마바"]
```
### 컬렉션 스트림
컬렉션 타입(Collection,List,Set) 은 stream 이용
```
public interface Collection<E> extends Iterable<E> {
  default Stream<E> stream() {
    return StreamSupport.stream(spliterator(), false);
  } 
  // ...
}
```
다음과 같이 생성
```
List<String> list = Arrays.asList("a", "b", "c");
Stream<String> stream = list.stream();
Stream<String> parallelStream = list.parallelStream(); // 병렬 처리 스트림
```

### Stream.builder()
스트림에 직접 원하는 값을 넣을 수 있고, build 메소드로 스트림을 리턴
```
Stream<String> builderStream = 
  Stream.<String>builder()
    .add("AB").add("CC").add("JJ")
    .build(); // [AB, CC, JJ]
```

### Stream.generate()
Supplier<T>에 해당하는 람다로 값을 넣을 수 있다. Supplier<T>는 인자는 없고 리턴값만 있는 함수형 인터페이스
```
public static<T> Stream<T> generate(Supplier<T> s) { ... }
```
이때 생성되는 스트림은 크기가 정해져있지 않기 때문에 특정 사이즈로 크기 제한 해야한다.
```
Stream<String> generatedStream = 
  Stream.generate(() -> "gen").limit(5); // [el, el, el, el, el]
```

## 가공하기
스트림을 리턴하기 때문에 여러 작업을 이어 붙여 작성 가능
```
List<String> names = Arrays.asList("Eric", "Elena", "Java");
```
위의 리스트를 대상으로 예제 코드를 작성

### Filtering
```
Stream<T> filter(Predicate<? super T> predicate);
```
```
Stream<String> stream = 
  names.stream()
  .filter(name -> name.contains("a"));
// [Elena, Java]
// 'a' 가 들어간 이름만 스트림 리턴됨
```

### Mapping
```
<R> Stream<R> map(Function<? super T, ? extends R> mapper);
```

```
Stream<String> stream = 
  names.stream()
  .map(String::toUpperCase);
// [ERIC, ELENA, JAVA]
```
toUpperCase로 대문자로 변환된 값들이 담긴 스트림 리턴

```
Stream<Integer> stream = 
  productList.stream()
  .map(Product::getAmount);
// [23, 14, 13, 23, 13]
```
Product 개체의 수량을 꺼내올 수 있다

## 결과 만들기
가공한 스트림으로 내가 사용할 결과값을 만들어내는 단계이다.

### Calculating
```
long count = IntStream.of(1, 3, 5, 7, 9).count();
long sum = LongStream.of(1, 3, 5, 7, 9).sum();
```
min(),max()와 같은 것도 가능

### Collecting
collect 메소드는 또 다른 종료 작업으로, Collector 타입의 인자를 받아 처리함
```
List<Product> productList = 
  Arrays.asList(new Product(23, "potatoes"),
                new Product(14, "orange"),
                new Product(13, "lemon"),
                new Product(23, "bread"),
                new Product(13, "sugar"));
```
다음 예제에는 이 Product 객체를 사용

### Collectors.toList()
스트림에서 작업한 결과를 담은 리스트로 반환한다.
```
List<String> collectorCollection =
  productList.stream()
    .map(Product::getName)
    .collect(Collectors.toList());
// [potatoes, orange, lemon, bread, sugar]

```

[출처, 더 많은 내용 참고](https://futurecreator.github.io/2018/08/26/java-8-streams/)