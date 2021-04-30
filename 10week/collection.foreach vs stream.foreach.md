---

# **Collection.forEach 와 Stream.forEach 의 차이**

---

## Stream의 foreach와 for-loop는 다르다.

- stream 은 java8 부터 람다와 함께 제공된 방법이며 컬렉션 요소를 하나씩 참조해 함수형 인터페이스를 통한 반복적 처리를 가능하게 해준다.

- 이에 for문을 stream으로 대신해 처리하는 경우가 빈번하다.

**하지만 무턱대고 아무곳에서나 for문을 stream으로 바꿔 구현하는 행위는 옳지 않다.**

- 물론 Stream을 사용하면 가독성이 높아져 코드 이해도가 높아진다. 하지만 다음 예시에서는 사용을 다시 생각해 봐야할 필요가 있다.

## 🤔   **만약 Stream의 모든 요소를 도는 forEach를 사용시 종료 조건이 있는 경우에는 어떡할까?**

- 일단 Stream 에서 강제적으로 루프를 탈출 할 수 있는 방법은 없다.

![https://s3-us-west-2.amazonaws.com/secure.notion-static.com/82dc64e7-1599-473e-a586-8f92e1e40e1b/_2021-04-29__11.11.17.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/82dc64e7-1599-473e-a586-8f92e1e40e1b/_2021-04-29__11.11.17.png)

- 다음 코드의 결과를 보면 같은 결과 값을 내지만 기존의 for 문에서는 50까지 수행이되면 이후는 수행 되지 않고 반복문이 종료가 되지만 stream 을 사용한 아래의 코드는 return이후 코드만 처리되지 않을뿐 50이 넘어서도 모든 조건을 확인 후에 종료하게 된다.

![https://s3-us-west-2.amazonaws.com/secure.notion-static.com/32e7a32a-0778-423e-acb6-bff49ad79166/_2021-04-29__11.12.21.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/32e7a32a-0778-423e-acb6-bff49ad79166/_2021-04-29__11.12.21.png)

- 다음과 같이 같은 조건문을 가지더라도 모든 조건을 다 확인하는 stream에서는 중간에 종료가 불가능 하여 비효율 적이다. forEach 연산의 올바른 사용법인 Filter 를 쓰더라도 stream은 지연 연산을 지원 하기 때문에 100번 모두를 검사하게 된다.
- 또한 forEach연산을 최종 연산중 가장 기능이 적고 Stream 스럽지 못하므로 print 문을 사용할때만 쓰자.

---

## Collection.forEach 와 Stream.forEach 의 차이점

![https://s3-us-west-2.amazonaws.com/secure.notion-static.com/2b59e6d0-45e5-489c-99af-ce367ebb60e0/_2021-04-29__11.46.29.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/2b59e6d0-45e5-489c-99af-ce367ebb60e0/_2021-04-29__11.46.29.png)

- 코드만 봤을 경우에는 그렇게 큰 차이는 없다.
- Collection.forEach의 경우 따로 객체를 생성하지 않고 forEach메소드를 호출하는데 Iterable 인터페이스를 상속하고 있기 때문이다.
- stream.forEach의 경우는 Collection 인터페이스의 메소드인 stream() 을 통해 stream 객체를 생성해야만  forEach 호출이 가능하다.
- 출력문을 봐도 별 차이가 없다.

    ![https://s3-us-west-2.amazonaws.com/secure.notion-static.com/dbed982b-2a70-4c9c-859c-ad6c93703462/_2021-04-29__12.07.44.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/dbed982b-2a70-4c9c-859c-ad6c93703462/_2021-04-29__12.07.44.png)

- 하지만 동시성 부분에서는 차이가 있다.

**동시성** 

- Collection.forEach의 경우는 중간 과정에 삭제하는 조건문을 넣어두고 수정을 감지하면 Exception을 터트리는 구조로 코드를 작성하면 변경과 동시에 Exception 을 터트린다. (ConcurrentModificationException)
- 반면 Stream.forEach의 경우에는 다르다 Collection 때 처럼 수정을 감지하는 코드를 작성해 놓으면 Stream 은 리스트를 모두 순회 하고 예외를 던진다. (NulPointerException)

- Collection의 경우에는 Iterator을 사용하고 Stream은 spliterator을 사용한다. 아래의 [Collections.java](http://collections.java) 의 코드를 보면 Synchronized 키워드가 붙어 있다. 반면 stream에는 붙어있지 않다.

    ![https://s3-us-west-2.amazonaws.com/secure.notion-static.com/d5d8eb35-1b32-4693-82e8-3dd59da18eba/_2021-04-29__12.28.13.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/d5d8eb35-1b32-4693-82e8-3dd59da18eba/_2021-04-29__12.28.13.png)

- 결론적으로 둘은 큰 차이가 없지만 단순 반복을 위한 forEach면 Stream사용보다 일반 collection 의 foreach사용을 권장한다.

---

## Reference

[https://woowacourse.github.io/javable/post/2020-05-14-foreach-vs-forloop/](https://woowacourse.github.io/javable/post/2020-05-14-foreach-vs-forloop/)

[https://woowacourse.github.io/javable/post/2020-09-30-collection-stream-for-each/](https://woowacourse.github.io/javable/post/2020-09-30-collection-stream-for-each/)