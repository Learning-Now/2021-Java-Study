# Stream.forEach, for-loop
자바에서 Stream은 배열, 컬렉션 등의 요소를 하나씩 참조해 함수형 인터페이스(람다식)를 통해 반복적인 작업의 처리를 가능하게 해준다. Stream이 반복적인 일의 처리가 가능하므로, 반복문(for-loop등)을 대신해 Stream을 사용하는 경우가 많다.

하지만 무조건 반복문 대신 Stream을 써야하는 것을 아니다.

## Stream 사용에 대해

Stream을 쓰면 가독성도 올라가고 중첩된 for, if stmt 여러 개를 보는 것보다 훨씬 읽기 쉽고 이해하기도 편해진다.

간단한 리스트 순회 예시를 봐도 알 수 있다.

```java
// for-loop
for (int i = 0; i < list.size(); i++{
	System.out.println(list.get(i));
}

// enhanced for-each
for (String item : list) {
	System.out.println(item);
}

//stream.forEach()
list.stream()
		.forEach(System.out::println);
```

하지만 남용은 금물이다.

특히 모든 요소를 순회하는 Stream.forEach() 사용에 대해선 생각해볼 필요가 있다.

## 언제 주의해야 할까

- Stream의 forEach는 요소를 돌면서 실행되는 stream연산의 최종 작업이다. 보통 System.out.println메소드를 넘겨서 결과를 출력할 때 사용한다.

Stream.forEach()를 사용할 때, 로직이 들어가 있는 경우 자신이 Stream을 잘 활용하고 있는 건지 생각해봐야 한다.

**종료 조건이 있는 로직을 구현할 때 주의해야 한다.**

Stream 자체를 강제적을 종료시키는 방법은 없다. 무언가 강제적인 종료 조건에 대한 로직이 있는 for-loop를 stream.forEach()로 구현한다면, 기존 for-loo에 비해 비효율이 발생한다.

```java
// for-loop
for (int i = 0; i < 100; i++) {
	if (i > 50) {
		break;
		// 50호 돌고 반복을 종료한다.
	}
}

IntStream.range(1, 100).forEach(i -> {
		if (i > 50) {
			return;
			// 각 수행에 대해 다음 수행을 막을 뿐이다.
			// 100번 모두 조건을 확인한 후에 종료한다.
		}
	System.out.println(i);
});
```

위의 예시처럼 반복문이라고 무작정 stream.forEach()를 사용하게 되면 동작은 정상적으로 할지 몰라도 for문에 비해 비효율이 발생할 수 있다.

```java
IntStream.range(1, 100)
		.filter(i -> i <= 50)
		.forEach(System.out::println);

```

물론, Stream은 지연 연산을 하기 대문에 100번 모두 검사를 하긴 하지만 Stream.forEach()의 올바른 사용은 위처럼 forEach()를 최종 연산으로만 사용하는 것이다. 굳이 Stream.forEach()내에 로직이 들어가지 않더라도, 중간 연산인 filter, map, sort 등을 통해 충분히 로직을 수행할 수 있다.

- forEach연산은 최종 연ㅅ나 중 기능이 가장 적고 가장 '덜' 스트림답기 때문에, forEach연산은 스트림 계산 결과를 보고할 때(주로 input기능)만 사용하고 계산하는 데는 쓰지 말자.

```java
public void validateInput() {
    List<String> names = splitInputByComma();
        if (CollectionUtils.isEmpty(names)) {
            throw new IllegalArgumentException(LENGTH_ERROR_MESSAGE);
        }
    names.stream()
         .forEach(Input::validateNameLength);
}
```

```java
pieces.keySet()
      .forEach(
           positionKey -> model.addAttribute(
               positionKey,pieces.get(positionKey)));
```

위의 두 예제를 살펴보면 짧고 간단한 로직이라서 가독성 측면에서는 큰 문제를 생기지 않는다.

하지만 forEach 내부에 로직이 하나라도 더 추가된다면 **동시성 보장이 어려워지고 가독성이 떨어질** 위험이 있다.

또한 Stream의 의도를 벗어나게 된다. 본래 forEach는 스트림의 종료를 우히ㅏㄴ 연산이다. 로직을 수행하는 역할은 Stream을 반환하는 중간 연산이 해야하는 일이다.

```java
public void validateInput() {
    List<String> names = splitInputByComma();
    if (CollectionUtils.isEmpty(names)) {
        throw new IllegalArgumentException(LENGTH_ERROR_MESSAGE);
    }
    for (String name : names) {
        validateNameLength(name);
    }
}
```

```java
for (String positionKey: pieces.keySet()) {
    model.addAttribute(positionKey, pieces.get(positionKey));
}
```

Stream.forEach() 대신 향상된 for문을 사용해도 충분히 가독성 좋은 코드가 될 수 있다. 

즉, 조건 혹은 로직이 추가된다면 forEach 내부를 손봐야 하는 것이 아니라, Stream의 다양한 연산 도구(filter, map 등)를 활용하거나 반복문 혹은 forEach가 아닌 다른 최종연산을 사용하는 것이 올바른 방향이다.

- Steam의 본래 목적과 장점을 해치는 잘못된 사용은 지양하자.

편리하기 위해 사용한 stream이 가독성을 해치고 성능도 저하시킨다면 사용할 이유가 없기 때문이다.

# Reference

- [우테코. githubio. Stream의 foreach와 for-loop는 다르다.]([https://woowacourse.github.io/javable/post/2020-05-14-foreach-vs-forloop/](https://woowacourse.github.io/javable/post/2020-05-14-foreach-vs-forloop/))