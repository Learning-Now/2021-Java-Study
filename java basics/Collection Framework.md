# Collection Framework
## 컬렉션 프레임워크란?

배열은 크기가 고정적이라 여러 비효율적인 문제가 생긴다. 

배열의 크기는 생성할 때 결정된다.

- 배열의 크기를 벗어나면 데이터를 더 이상 저장할 수 없다.
- 데이터를 삭제하면 해당 인덱스의 데이터는 비어있어 메모리가 낭비되는 문제가 발생한다.

이런 문제점들을 해결하기 위해 객체나 데이터들을 효율적을 관리, 추가, 삭제, 검색, 저장할 수 있는 자료구조들을 만들어 두었다. 이런 라이브러리를 컬렉션 프레임워크라고 한다.

![컬렉션 프레임워크]([https://blog.kakaocdn.net/dn/bdy438/btqEjPZKIY0/e5Wm8ZJmdRNza4tKBzaK6k/img.png](https://blog.kakaocdn.net/dn/bdy438/btqEjPZKIY0/e5Wm8ZJmdRNza4tKBzaK6k/img.png))

## List 컬렉션

컬렉션 프레임워크를 상속받고 있는 List 컬렉션은 객체를 일렬로 늘어놓은 구조를 가지고 있다. List 컬렉션은 객체를 인덱스를 관리하기 때문에 객체를 저장하면 자동 인덱스가 부여되고 인덱스로 객체를 검색, 삭제할 수 있는 기능을 제공한다.(인덱스에는 데이터가 저장되어 있는 참조 값을 가지고 있다.)

![List 컬렉션]([https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FbxhCVv%2FbtqEg09LXoG%2Fm26SctApZoPjJtRaAEmlSk%2Fimg.png](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FbxhCVv%2FbtqEg09LXoG%2Fm26SctApZoPjJtRaAEmlSk%2Fimg.png))

List 컬렉션은 객체 자체를 저장하는 것이 아니라 위와 같이 객체의 번지를 참조합니다. 동일한 객체를 중복 저장할 수 있는데 이 경우 동일한 번지가 참조됩니다. null도 저장이 가능한데 이 경우에는 해당 인덱스는 객체를 참조하지 않는다. List 컬렉션을 구현하는 대표적인 클래스들은 ArrayList, LinkedList, Vector가 있으며 이 3가지 클래스는 List 인터페이스를 같이 상속하고 있으므로 공통적으로 사용할 수 있는 메소드들이 많다. 

- List 클래스 주요 메소드

[제목 없음](https://www.notion.so/f9122f0852d3491b8f8c9735430501f4)

## Set 컬렉션

List 컬렉션은 선형구조를 가지고 있으므로 추가한 순서대로 저장돼어 순서를 유지했지만 Set 컬렉션은 저장 순서가 유지되지 않는다. Set 컬렉션은 순서 자체가 없어 인덱스로 객체를 검색해서 가져오는 get(index) 메소드도 존재하지 않는다. 대신 전체 객체를 대상으로 한 번씩 반복해서 가져오는 반복자(Iterator)를 제공한다. Iterator는 .iterator() 메소드를 호출하면 얻을 수 있다.

![Set 컬렉션]([https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FcLMuJG%2FbtqEgQzQaFv%2F18xV7JmoktO3gKPnYitGZ0%2Fimg.png](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FcLMuJG%2FbtqEgQzQaFv%2F18xV7JmoktO3gKPnYitGZ0%2Fimg.png))

또한 Set은 객체를 중복해서 저장할 수 없고 하나의 중복 저장이 안 되기에 null값도 하나만 저장할 수 있다. Set 컬렉션을 구현하는 대표적인 클래스들은 HashSet과 TreeSet이 있다. 이 2가지 클래스는 Set 인터페이스를 같이 상속하고 있으므로 공통적으로 사용할 수 있는 메소드들이 존재한다.

- Set 클래스 주요 메소드

[제목 없음](https://www.notion.so/8643a61c33a74b5a825cffb7fc4ab359)

## Map 컬렉션

Map 컬렉션은 키Key 와 값Value으로 구성된 객체를 저장하는 구조를 가지고 있는 자료구조이다. 키는 중복으로 저장할 수 없고 값은 중복으로 저장할 수 있으며 중복된 key값이 들어온다면 기존의 값은 없어지고 새로운 값으로 대치된다.

![Map 컬렉션]([https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FcDaHeK%2FbtqEjQx07Ng%2FPQSBhv0USEnMzQnzuMFw61%2Fimg.png](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FcDaHeK%2FbtqEjQx07Ng%2FPQSBhv0USEnMzQnzuMFw61%2Fimg.png))

Map은 Key와 Value라는 것을 한 쌍으로 갖는 자료형이다. Map은 리스트나 배열처럼 순차적으로(sequential) 해당 요소 값을 구하지 않고 key를 통해 value를 얻는다. Map 컬렉션을 구현하는 대표적인 클래스들은 HashMap, hashtable, LinkedHashMap, TreeMap 등이 있다.

- Map 클래스 주요 메소드

[제목 없음](https://www.notion.so/ca00a7b06d9c445c8fa05ad3f02ed378)

# Reference

- [자바 컬렉션 프레임워크 총정리. 티스토리]([https://coding-factory.tistory.com/550](https://coding-factory.tistory.com/550))
- [자바 ArrayList 사용법, 예제 총정리. 티스토리.[([https://coding-factory.tistory.com/551?category=758267](https://coding-factory.tistory.com/551?category=758267))