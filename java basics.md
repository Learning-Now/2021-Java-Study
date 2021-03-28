# java basics

## CQRS

### CQRS란?

CQRS는 Command and Query Responsibility Segregation(명령과 조회의 책임 분리)을 나타낸다. 이름처럼 시스템에서 명령을 처리하는 책임과 조회를 처리하는 책임을 분리하는 것이
CQRS의 핵심이다.

- 명령: 시스템의 상태를 변경하는 작업
- 조회: 시스템의 상태를 반환하는 작업

모든 연산이 명령과 조회로 쉽게 양분되진 않는다. 개념적으로 어렵거나 동시성 등 기술적인 문제도 있다.

### 단순한 CQRS 적용

#### stereotypical 아키텍쳐

CQRS가 적용돼있지 않은 다계층 아키텍쳐

```java

```

## 디미터 법칙

객체 간 관계를 설정할 때 객체 간의 결합도를 효과적으로 낮출 수 있는 유용한 지침 중 하나로 꼽힌다.

객체 지향 생활 체조 원칙 중, 한 줄에 점을 하나만 찍는다.로 요약되기도 한다.

### Don't talk to strangers

디미터 법칙의 핵심은 객체 구조의 경로를 따라 멀리 떨어져 있는 낯선 객체에 메시지를 보내는 설계는 피하라는 것이다.

바꿔 말해서 객체는 내부적으로 보유하고 있거나 메시지를 통해 확보한 정보만 가지고 의사 결정을 내려야 하고 다른 객체를 탐색해 뭔가를 일어나게 해서는 안 된다.

이러한 핵심적인 내용 때문에 디미터 법칙은 Don’t Talk to Strangers(낯선 이에게 말하지 마라)라고도 불리고 한 객체가 알아야 하는 다른 객체를 최소한으로 유지하라는 의미로 Principle of
least knowledge(최소 지식 원칙)라고도 불린다.

```java
public class Post {
    private final List<Comment> comments;

    public Post(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Comment> getComments() {
        return comments;
    }
}
```

```java
public class Board {
    private final List<Post> posts;

    public Board(List<Post> posts) {
        this.posts = posts;
    }

    public void addComment(int postId, String content) {
        posts.get(postId).getComments().add(new Comment(content));
    }
    ...
}
```

바로 위에 있는 Board객체의 addComment메서드를 살펴보자. Board객체의 인스턴스 변수 posts에서 getter를 거듭해 멀리 떨어져 있는 낯선 객체 Comment를 추가하는 코드이다.

이처럼 getter가 줄줄이 이어지는 코드 형태가 디미터 법칙을 위반한 전형적인 코드 형태이다.

왜 낯선 객체에 메시지를 보내는 설계를 피해야 할까? 즉 디미터 법칙을 위반했을 때의 문제점은 무엇일까?

앞서 살펴봤던 Post객체에서 만약 인스턴스 변수가 List<Comment> comments에서 Comments라는 일급컬렉션 객체로 수정된다면 어떻게 될까?

```java
public class Post {
    private final Comments comments;

    public Post(Comments comments) {
        this.comments = comments;
    }

    public Comments getComments() {
        return comments;
    }
}
```

getter를 통해 Post객체의 List<Comment> comments를 사용하던 Board 객체의 addComment 메서드가 깨지게 된다.

```java
public class Board {
    private final List<Post> posts;

    public Board(List<Post> posts) {
        this.posts = posts;
    }

    //에러 발생
    public void addComment(int postId, String content) {
        posts.get(postId).getComments().add(new Comment(content));
    }
    ...
}
```

이처럼 Board객체의 addComment메서드 내에서 Post객체도 알고 Comment객체도 알고 있다면 Board객체는 Post객체의 변화에도 영향을 받고 Comment객체의 변화에도 영향을 받는다.

이러한 설계가 프로젝트 내에 즐비하다면 하나에 변화에 수많은 클래스들이 무너질 가능성이 있다. 즉 객체 간 결합도가 높아지고 객체 구조의 변화에 쉽게 무너진다. 변화에 유연히 대처하지 못하는 것이다.

### 규칙화

디미터 법칙은 **노출 범위를 제한하기 위해 객체의 모든 메소드는 다음에 해당하는 메소드만을 호출해야 한다.**고 말한다.

- 객체 자신의 메소드들
- 메소드의 파라미터로 넘어온 객체들의 메소드들
- 메소드 내부에서 생성, 초기화된 객체의 메소드들
- 인스턴스 변수로 가지고 있는 객체가 소유한 메소드들

```java
class Demeter {
    private Member member;

    public myMethod(OtherObject other) {
        // ...
    }

    public okLawOfDemeter(Paramemter param) {
        myMethod();     // 1. 객체 자신의 메서드
        param.paramMethod();    // 2. 메서드의 파라미터로 넘어온 객체들의 메서드
        Local local = new Local();
        local.localMethod();    // 3. 메서드 내부에서 생성, 초기화된 객체의 메서드
        member.memberMethod();   // 4. 인스턴스 변수로 가지고 있는 객체가 소유한 메서드
    }
}
```

위의 규칙을 지켜서 최대한 노출 범위를 제한하면 좀 더 에러가 적고, 변화에 유연히 대처할 수 있는 클래스를 만들 수 있다.

### 주의사항

- 자료구조라면 디미터 법칙을 거론할 필요가 없다.

객체라면 내부 구조를 숨겨야 하므로 디미터 법칙을 지켜야 한다.

하지만 자료구조라면 당연히 내부 구조를 노출해야 하므로 디미터 법칙이 적용되지 않는다.

- 하나의 '.'을 강제하는 규칙이 아니다.

디미터 법칙은 객체 지향 생활 체조 원칙 중 한 줄에 점을 하나만 찍는다.로 요약되기도 한다.

```java
IntStream.of(1,15,3,20).filter(x->x>10).count();
```

하지만 위 코드는 디미터 법칙과 객체 지향 생활 체조 원칙을 위반한 코드가 아니다.

디미터 법칙은 결합도와 관련된 법칙이고 결합도가 문제 되는 것은 객체의 내부 구조가 외부로 노출되는 경우이다. 위 코드는 IntStream의 내부 구조가 노출되지 않았다. 단지 IntStream을 다른
IntStream으로 변환할 뿐, 객체를 둘러싸고 있는 캡슐은 유지한다.

한 줄에 하나 이상의 점을 찍는 모든 케이스가 객체 지향 생활 체조 원칙 및 디미터 법칙을 위반하는 것은 아니다. 객체 내부 구현에 대한 어떤 정보도 외부로 노출하지 않는다면 괜찮다.

## 일급 컬렉션

일급 컬렉션이란 단어는 객체지향 생활제초 파트에서 언급되었다.

> 규칙 8: 일급 콜렉션 사용
이 규칙의 적용은 간단하다.
콜렉션을 포함한 클래스는 반드시 다른 멤버 변수가 없어야 한다.
각 콜렉션은 그 자체로 포장돼 있으므로 이제 콜렉션과 관련된 동작은 근거지가 마련된셈이다.
필터가 이 새 클래스의 일부가 됨을 알 수 있다.
필터는 또한 스스로 함수 객체가 될 수 있다.
또한 새 클래스는 두 그룹을 같이 묶는다든가 그룹의 각 원소에 규칙을 적용하는 등의 동작을 처리할 수 있다.
이는 인스턴스 변수에 대한 규칙의 확실한 확장이지만 그 자체를 위해서도 중요하다.
콜렉션은 실로 매우 유용한 원시 타입이다.
많은 동작이 있지만 후임 프로그래머나 유지보수 담당자에 의미적 의도나 단초는 거의 없다. - 소트웍스 앤솔로지 객체지향 생활체조편


```java
Map<String, String> map = new HashMap<>();
map.put("1", "A");
map.put("2", "B");
map.put("3", "C");
```

위의 코드를 아래와 같이 wrapping 하는 것을 이야기 한다.
```java
public class GameRanking {

    private Map<String, String> ranks;

    public GameRanking(Map<String, String> ranks) {
        this.ranks = ranks;
    }
}
```

collection을 wrapping 하면서, 그 외 다른 멤버 변수가 없는 상태를 일급 컬렉션이라 한다.

wrapping을 통해 얻는 이점은 아래와 같다.

- 비지니스에 종속적인 자료구조
- collection의 불변성을 보장
- 상태와 행위를 한 곳에서 관리
- 이름이 있는 컬렉션


### 비지니스에 종속적인 자료구조













# Reference

- [CQRS](https://justhackem.wordpress.com/2016/09/17/what-is-cqrs/)
- [디미터 법칙](https://woowacourse.github.io/javable/post/2020-06-02-law-of-demeter/)
- [일급 컬렉션](https://jojoldu.tistory.com/412)