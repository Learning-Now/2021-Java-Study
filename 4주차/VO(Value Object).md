# [Java] VO(Value Object)
## 1. VO(Value Object)란
VO(Value Object)란 말 그대로 값 객체라는 의미를 가지고 있다. 즉, 데이터를 담는 객체이다.
VO는 데이터베이스에서 한 테이블에 대한 컬럼들과 매칭하여 사용하는 것으로 많이 사용된다.
VO의 핵심 역할은 **equals()** 와 **hashcode()** 를 오버라이딩 하는 것이다. 즉, VO 내부에 선언된 속성(필드)의 모든 값들이 VO 객체마다 값이 같아야 같은 객체라고 판별한다.

## 2. Value Object 기본 특성
**Value Object**에는 기본 특성이 있다.
> 1. Immutability(불변성) - 수정자(setter)가 없음
> 2. Value Equality(값 동등성) - 내부 값 동등성 검사
> 3. Self Validation(자가 유효성 검사) - 생성자에서 validate

### 2-1. Immutability(불변성) - 수정자(Setter)가 없음
Value Object는 **불변**이다.

불변이라는 뜻은 한번 생성되면 이후 내부 값을 바꿀 수 없음을 의미한다. 즉 **수정자(Setter)를 허용하지 않는다**는 말이다.

쉽게 말하면, 생성자에게 하나 혹은 그 이상의 파라미터가 주입돼서 객체가 만들어지면, 돌아갈 수 없음을 의미한다. 해당 객체는 **GC(Garbage Collector)** 에 의해 폐기될 때까지 동일함을 보장한다.

- Hassle-free Sharing(번거로움없는 공유)
  Value Object는 코드의 다른 부분에서 수정되지 않기 때문에 **Reference(참조)로 공유**할 수 있다. 이는 side effect를 피하기 위해 사용되는 코드의 복잡성과 부하를 극적으로 감소시키며, 멀티스레드 환경에서 그 이점이 뚜렷해진다.
- Improved Semantics(향상된 의미)
  불변성을 **"무의미한 생성자(Getter)를 Value Object에 추가하지 않는다."**라는 규칙과 결합해야 한다. 초기 클래스에는 생성자와 private 접근 지정자인 속성만 있어야 한다.

> ### Value Object를 조작하는 방법
> - 생성자 또는 정적 메소드를 통해 새 인스턴스 만들기
> - 현재 객체에서 다른 객체 생성하기
> - 내부 데이터를 추출해 다른 유형으로 변환하기
> - 정적 팩토리 메소드 패턴을 활용해 생성하기(생성자를 private하게 바꿈)

위와 같은 방법은 Value Object를 명확하게 해준다.
```java
final class ComplexNumber {
    private float realPart;
    private float complexPart;

    // 정적 메소드를 통해 새 인스턴스 만들기 
    public static ComplexNumber zero() {
        return new ComplexNumber(0, 0);
    }

    // 생성자를 통해 새 인스턴스를 만들기
    private ComplexNumber(float realPart, float complexPart) {
        this.realPart = realPart;
        this.complexPart = complexPart;
    }

		// 정적 팩토리 메소드 패턴을 활용하여 생성하기 (생성자를 private하게 바꿈)
	  public static ComplexNumber of(float realPart, float complexPart) {
        return new ComplexNumber(realPart, complexPart);
    }

    // 현재 객체에서 다른 객체를 생성하기
    public ComplexNumber add(ComplexNumber anotherComplexNumber) {
        return new ComplexNumber(
                realPart + anotherComplexNumber.realPart,
                complexPart + anotherComplexNumber.complexPart
        );
    }

    // 내부 데이터를 추출하여 다른 유형으로 변환하기
    public String toString() {
        return String.format("%f + %f i", realPart, complexPart);
    }
}
```

### 2-2. Value Equality(값 동등성) - 내부 값 동등성 검사
Value Object는 내부 값이 모둗 각각 동일한지 확인하여 동등성을 테스트할 수 있다.

> ### 동일성 vs 동등성
> **동일성**은 객체가 완전히 같은지 판단할 수 있는 성질이고, **동등성**은 객체가 같은 정보를 가지고 있는지 판단할 수 있는 성질이다.
> 동일성은 ```==```로 **주소값**을 비교하고, 동등성은 ```equals()```로 **내용**을 비교한다.

### 2-3. Self Validation(자가 유효성 검사) - 생성자에서 validate
Value Object는 context에서 유효한 값만 허용한다. 이는 유효하지 않은 값으로 Value Object를 만들 수 없음을 의미한다.

생성자가 주입될 때 값의 유효성을 확인해야 한다. 유효하지 않으면 의미있는 에러를 표출한다. 이는 객체의 인스턴스에 더이상 if가 없음을 의미한다. **모든 유효성 검사는 생성 시간**에 이루어진다.

## 3. 정리
객체를 Value Object로 만들기 위한 체크 리스트
- 불변하며 수정자(Setter)가 없다
- 도메인의 의미론을 반영한다
- 런타임동안 정보의 흐름과 변환 방법을 보여준다
- default나 쓸모없는 Getter 메소드가 없다
- private 속성을 가지며 다른 Value Object와 비교할 수 있다