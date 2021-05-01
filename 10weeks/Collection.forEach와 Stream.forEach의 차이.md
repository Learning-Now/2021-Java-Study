# Collection.forEach와 Stream.forEach의 차이
```java
public void print(List<Integer> nums) {
	nums.forEach(System.out::println);
	nums.stream().forEach(System.out::println); 
}
```
Collection.forEach는 따로 객체를 생성하지 않고 forEach 메서드를 호출한다. forEach 메서드는 Iterable 인터페이스의 default 메서드인데, Collection 인터페이스에서 Iterable 인터페이스를 상속하고 있기에 바로 호출할 수 있는 것이다.

```java
public interface Iterable<T> { 
	default void forEach(Consumer<? super T> action) { 
		Objects.requireNonNull(action);
		for (T t : this) {
			 action.accept(t); 
		} 
	} 
	... 
} 
public interface Collection<E> extends Iterable<E> {
	... 
}
```
반면에 Stream.forEach는 Collection 인터페이스의 default 메서드 stream()으로 Stream 객체를 생성해야만 forEach를 호출할 수 있다.

## parallelStream
stream 메소드로 생성한 Stream.forEach를 했을 땐 Collection.forEach와 별 차이가 없었지만 Collection 인터페이스의 또다른 Stream 객체 생성 메소드 parallelStream()을 사용해서 Stream.forEach를 한다면 그 차이점이 명확하다.

```java
public void print() {
	List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
	System.out.println("Collection.forEach 출력 시작");
	nums.forEach(System.out::println);
	System.out.println("Stream.forEach 출력 시작");
	nums.parallelStream().forEach(System.out::println);
}

//실행 결과
Collection.forEach 출력 시작
1
2
3
4
5
Stream.forEach 출력 시작
3
4
1
5
2
```
parallelStream 메소드로 생성한 Stream 객체는 여러 스레드에서 스트림을 실행하기 때문에 forEach를 했을 때 실행 순서가 매번 달라지며 예측 불가능하다.

## Reference
- [Collection.forEach와 Stream.forEach는 뭐가 다를까?](https://dundung.tistory.com/247)