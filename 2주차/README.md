# 자바 코드 실습

- [x] java 11 jdk 다운받고 실행해보기

## 단축키 정리

### Alt + Enter
현재 컨텍스트에 대한 액션을 표시하여 뭐든지 수정하는 데 사용할 수 있다. 코드에서 오류가 발견된 경우 해당 오류 위에 커서를 놓고 Alt + Enter를 누르면 문제에 대한 수정 제안 목록이 표시된다. 경고와 제안이 표시된 곳에서도 Alt + Enter를 사용해 제안 중 하나를 수락할 수 있다. 

### F2
에디터에서 오류와 경고 사이를 F2를 사용해 다음 오류, 경고 또는 제안으로 이동할 수 있다. Alt + Enter 와 함께 사용해 모든 제안을 표시하고 하나를 선택하거나, Shift + Alt + Enter를 사용해 첫 번째 제안을 적용할 수 있다.

### Alt + 1
도구 창을 열 때에 사용할 수 있다. 이후 방향키를 통해 트리를 탐색할 수 있다.

### Esc
- 에디터에 다시 포커스가 위치하게 한다. 열린 도구창과 상관 없이 에디터에 다시 포커스가 위치하게 되어 코드 작업을 계속 수행할 수 있다. 또한, 변경 사항을 적용하지 않고 팝업 창을 닫을 때도 사용할 수 있다.

### Ctrl + B
심볼의 선언으로 이동한다. 예로, 필드 위에서 이를 누르면 커서가 해당 필드의 선언으로 이동한다. 또는 클래스 이름 위에서 누르면 해당 클래스 파일로 이동한다. Ctrl + Alt + B를 누르면 구현으로 이동할 수 있다.

### Alt + F7
어떤 항목이 사용된 모든 곳이 표시된다. 예로, 인터페이스 이름 위해서 누르면 이 인터페이스를 구현하는 것이 필드선언이든 클래스든 상관 없이 해당 인터페이스가 사용된 모든 곳이 검색 창에 표시된다.

### Ctrl + /, Shift + Ctrl + /
- Ctrl + /를 누르면 해당 코드 줄이 줄 주석으로 처리되고, 반대의 경우에는 주석처리가 사라진다. 
- Shift + Ctrl + /를 누르면 블록 주석을 추가할 수 있고, 반대의 경우에는 주석처리가 사라진다.

### Shift + Ctrl + Enter
현주 구문 완성기능이다. 보통은 코드 끝에 세미콜론을 추가한다. for-loop를 작성할 때에 자동으로 중괄호를 추가하고 블록 안에 커서를 배치한다. if문을 작성할 때에 괄호와 중괄호를 추가하고 커서를 배치한다.

### Shift + Ctrl + A
모든 액션과 설정을 검색할 수 있다. 

### Shift Shift
모든 항목을 검색할 수 있는 검색 상자가 열린다.

### Shift + Ctrl + Alt + T
refactoring hotkey. 심볼 또는 선택 영역 위에서 누르면 사용 가능한 리팩토링 옵션이 표시된다.

### Ctrl + Shift + F12
Maximize editor pane. in the editor, press this. IntelliJ hides all windows except the active editor.

### Alt + F12, Ctrl + Tab
Return to the editor from the commnad-line terminal
- press Alt + F12. Closes the terminal window.
- If you need to keep the terminal window open when you switch back to the active editor, press Ctrl + Tab.

### Shift + F12
Return to the default layout. To save the current layout as default, from the main menu select Window | Store Current Layout as Default. You can use the same shortcut Shift + F12 to restore the saved layout.

### F12
Jump to the last active window

### Alt + Home
Jump to the navigation bar

### [mastery of IntelliJ hotkey](https://www.jetbrains.com/help/idea/mastering-keyboard-shortcuts.html)


## IntelliJ java live template
- C: Surround with Callable
- fori: Create iteration loop
- geti: Inserts singleton method getInstance
- I: Iterate Iterable or array
- ifn: Inserts 'if null' statement
- inn: Inserts 'if not null'statement
- inst: Checks object type with instanceof and down-casts it
- itar: Iterate elements of array
- itco: Iterelemnts of java.util.Collection
- iten: Iterate java.util.Enumeration
- iter: Iterate Iterable or array
- itit: Iterate java.util.Iterator
- itli: Iterate elemnts of java.util.List
- ittok: Iterate tokens from String
- lazy: Performs lazy initializtion
- List: Fetches last element of an array
- main: main() method declaration
- mn: Sets lesser value to a variable
- mx: Sets greater value to a variable
- prsf: private static final
- psf: public static final
- psfi: public static final int
- psfs: public static final String
- psvm: main() method delaration
- ritar: Iterate elemnts of array in reverse order
- RL: Surround with ReadWriteLock.readLock
- serr: System.err::println
- souf: Prints a formatted string to System.out
- sout: Prints a string to System.out
- soutc: System.out::println
- soutm: Prints current class and method names to System.out
- soutp: Prints method parameter names and values to System.out
- soutv: Prints a value to System.out
- St: String
- thr: throw new
- toar: Stores elements of java.util.Collection into array
- WL: Surrond with REadwriteLock.writeLock<br><br>
iterate means repeat sth.

## Iterator

### Iterator?
Iterator는 자바의 컬렉션 프레임워크에서 컬렉션에 저장되어 있는 요소들을 읽어오는 방법을 표준화한 것이다.<br>
컬렉션 프레임워크란 데이터를 저장하는 클래스들을 표준화한 설계이다.<br>
![컬렉션 프레임워크](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FkBiGg%2FbtqvRHqrCsc%2FnLsgMXBHArIcj0tdJ8ZRpK%2Fimg.png) <br>

### Iterator와 그 메소드
Set, List, Map 과 같은 데이터들의 집합체가 있다. Iterator는 이런 집합체로부터 정보를 얻어낸다. 집합체를 다룰 때는 개별적인 클래스에 대해 데이터를 읽는 방법을 알아야 하기 때문에 각 컬렉션에 접근이 힘들어진다. Iterator를 쓰게 되면 어떤 컬렉션이라도 동일한 방식으로 접근이 가능하여 그 안에 있는 항목들에 접근할 수 있는 방법을 제공한다. (다형성)<br>
Iterator Method 에는 hasNext(), next(), remove() 가 있다. 
- hasNext(): 읽어올 요소가 남아있는지 확인하는 메소드이다. 요소가 있으면 true, 없으면 false를 반환한다.
- next(): 다음 데이터를 반환한다.
- remove(): next()로 읽어온 요소를 삭제한다.



# 자바 기초

# JVM

## JVM?
- 기술적 정의: JVM은 코드를 실행하고 해당 코드에 대해 런타임 환경(JRE)을 제공하는 소프트웨어 프로그램에 대한 사양(Specification)이다.
- 일반적 정의: JVM은 자바 프로그램을 실행하는 방법이다. JVM의 설정을 구성한 다음 설정 사항에 따라 실행 중에 프로그램 리소스를 관리한다.

## JVM의 메모리 관리
JVM 실행에 있어 가장 일반적인 상호작용은 Heap과 Stack의 메모리 사용을 확인하는 것이다. 자바 이전에는 프로그래머가 메모리를 직접 관리했지만 자바에는 **Garbage Collector**를 제공한다. JVM은 Garbage Collection Processing을 통해 메모리를 관리한다. 이는 자바 프로그램에서 사용되지 않는 메모리를 지속적으로 찾아내서 제거한다. 즉, 실행 중인 JVM 내부에서 일어나는 것이다. 

## 자바 프로그램 실행과정
1. 프로그램이 실행되면 JVM은 OS로부터 프로그램이 필요로 하는 메모리를 할당받는다. JVM은 이 메모리를 용도에 따라 여러 영역으로 나누어 관리한다.
1. 자바 컴파일러(javac)가 자바 소스코드(.java)를 읽어들여 자바 바이트코드(.class)로 변환시킨다.
1. Class Loader를 통해 class파일들을 JVM으로 로딩한다.
1. 로딩된 class파일들은 Execution engine을 통해 해석된다.
1. 해석된 바이트코드는 Runtime Data Areas에 배치되어 실질적인 수행이 이루어지게 된다. 
이 실행과정 속에서 JVM은 필요에 따라 Thread Synchronization과 GC( [Garbage Collection](https://d2.naver.com/helloworld/1329) )같은 관리작업을 수행한다. 
![jvm](https://img1.daumcdn.net/thumb/R800x0/?scode=mtistory2&fname=https%3A%2F%2Ft1.daumcdn.net%2Fcfile%2Ftistory%2F25616D45576B854C3F)

## JVM 구성

### 클래스 로더(Class Loader)
JVM내로 클래스(.class)파일을 로드하고, 링크를 통해 배치하는 작업을 수행하는 모듈이다. Runtime 시에 동적으로 클래스를 로드한다. jar파일 내 저장된 클래스들을 JVM위에 탑재하고 사용하지 않는 클래스들은 메모리 위에서 삭제한다.(컴파일러의 역할을 한다.) 자바는 동적코드, 컴파일 타임이 아니라 런타임에 참조한다. 즉, 클래스를 처음으로 참조할 때, 해당 클래스를 로드하고 링크한다는 것이다. 그 역할을 클래스 로더가 수행한다.

### 실행 엔진(Execution Engine)
클래스를 실행시키는 역할이다. 클래스 로더가 JVM내의 Runtime Data Areas에 바이트코드를 배치시키고, 이것은 실행엔진에 의해 실해오딘다. 자바 바이트코드는 기계가 바로 수행할 수 있는 언어보다는 비교적 인간이 보기 편한 형태로 써진 것이다. 그래서 실행 엔진은 이와 같은 바이트코드를 실제로 JVM내부에서 기계가 실행할 수 있는 형태로 변경한다. 이 때 Interpreter방식과 JIT(Just In Time)두 가지 방식을 사용한다.

### Interpreter
실행 엔진은 자바 바이트코드를 명령어 단위로 읽어서 실행한다. 한 줄씩 수행하기 때문에 느리다.

### JIT compiler
Interpreter 방식의 단점을 보완하기 위해 도입된 것이다. Interpreter 방식으로 실행하다가 적절한 시점에 바이트코드 전체를 컴파일하여 Native code로 변경하고, 이후에는 더 이상 Interpreting하지 않고 Native code로 직접 실행하는 방식이다. Native code는 cache에 보관하기 때문에 한 번 컴파일된 코드는 빠르게 수행하게 된다. 하지만 JIT Compiler가 컴파일하는 과정은 바이트코드를 Interpreting하는 것보다 훨씬 오래걸리므로 한 번만 실행되는 코드라면 컴파일하지 않고 Interpreting하는 것이 유리하다. 따라서 JIT Compiler를 사용하는 JVM들은 내부적으로 해당 메소드가 얼마나 자주 수행되는지 체크하고, 일정 정도를 넘을 때에만 컴파일을 수행한다.

### Garbage Collector
GC를 수행하는 모듈(Thread)이다.

## Runtime Data Area
프로그램을 수행하기 위해 OS에서 할당받은 메모리 공간이다.
![Runtime Data Area](https://t1.daumcdn.net/cfile/tistory/992EE9465D08E9B903)

### PC Register
Thread가 시작될 때 생성되며 생성될 때마다 생성되는 공간으로 Thread마다 하나씩 존재한다. Thread가 어떤 부분을 무슨 명령으로 실행해야 할지에 대한 기록을 하는 부분으로 현재 수행 중인 JVM 명령의 주소를 갖는다.

### JVM Stack Area
프로그램 실행과정에서 임시로 할당되었다가 메소드를 빠져나가면 바로 소멸되는 특성의 데이터를 저장하기 위한 영역이다. 각종 형태의 변수나 임시 데이터, 스레드나 메소드의 정보를 저장한다. 메소드 호출 시마다 각각의 Stack frame(해당 메소드만을 위한 공간)이 생성된다. 메소드 수행이 끝나면 프레임 별로 삭제한다. 메소드 안에서 사용되는 값들(Local Variable)을 저장한다. 또 호출된 메소드의 매개변수, 지역변수, 리턴 값 및 연산 시 일어나는 값들을 임시로 저장한다.

### Native Method Stack
자바 프로그램이 컴파일되어 생성되는 바이트코드가 아닌 실제 실행할 수 있는 기계어로 작성된 프로그램을 실행시키는 영역이다. 자바가 아닌 다른 언어로 작성된 코드를 위한 공간이다. JAVA Native Interface를 통해 바이트코드로 전환하여 저장하게 된다. 일반 프로그램처럼 Kernel이 스택을 잡아 독자적으로 프로그램을 실행시키는 영역이다. 이부분을 통해 C code를 실행시켜 Kernel에 접근할 수 있다.

### Method Area(Class area, Static area)
클래스 정보를 처음 메모리 공간에 올릴 때 초기화되는 대상을 저장하기 위한 메모리 공간이다. 올라가게 되는 메소드의 바이트코드는 프로그램의 흐름을 구성하는 바이트코드이다. 자바 프로그램은 main 메소드의 호추렝서부터 계속된 메소드의 호출로 흐름을 이어가기 때문이다. 대부분 인스턴스의 생성도 메소드 내에서 명령하고 호출한다. 사실상 컴파일된 바이트코드의 대부분이 메소드 바이트코드이기 때문에 거의 모든 바이트코드가 올라간다 본다. 이 공간에는 Runtime Constant Pool이라는 별도의 관리 영역도 함께 존재한다. 이는 상수 자료형을 저장하여 참조하고 중복을 막는 역할을 수행한다.<br>
여기에 올라가는 정보는 아래와 같다.
1. Filed Information: 멤버변수의 이름, 데이터 타입, 접근 제어자에 대한 정보
1. Method Information: 메소드의 이름, 리턴타입, 매개변수, 접근제어자에 대한 정보
1. Type Information: class인지 interface인지의 여부 저장 /type의 속성, 전체 이름, super class의 전체 이름(interface이거나 object인 경우 제외)

Method Area는 클래스 데이터를 위한 공간. Heap영역은 객체를 위한 공간이다. Heap과 마찬가지로 **GC의 관리 대상**이다.


### Heap(힙 영역)
객체를 저장하는 가상 메모리 공간이다. new연산자로 생성된 객체와 배열을 저장한다. 물론 class area영역에 올라온 클래스들만 객체로 생성할 수 있다. <br>
![Heap](https://img1.daumcdn.net/thumb/R800x0/?scode=mtistory2&fname=https%3A%2F%2Ft1.daumcdn.net%2Fcfile%2Ftistory%2F273DE43656FA92B60D) <br>
Heap은 세 부분으로 나뉜다. 

#### Permanent Generation
생성된 객체들의 정보의 주소값이 저장된 공간이다. Class loader에 의해 load되는 class, method 등에 대한 Meta정보가 저장되는 영역이고 JVM에 의해 사용된다. Reflection을 사용하여 동적으로 클래스가 로딩되는 경우에 사용된다. 내부적으로 Reflection 기능을 자주 사용하는 Spring Framework를 이용할 경우 이 영역을 신경써야 한다.

#### New/Young Generation
- Eden: 객체들이 최초로 생성되는 공간
- Survivor 0 / 1: Eden에서 참조되는 객체들이 저장되는 공간

#### Old Generation
New area에서 일정 시간 참조되고 있는, 살아남은 객체들이 저장되는 공간. Eden 영역에 객체가 가득차게 되면 첫번째 GC(minor GC)가 발생한다. Eden영역에 있는 값들을 survivor 1 영역에 복사하고 이 영역을 제외한 나머지 영역의 객체를 삭제한다. 


# Compile JAVA in Terminal
1. 소스코드를 작성한 후 .java 확장자로 저장한다. (test.java 라고 하자.)
1. cmd를 실행한다.
1. 작성한 자바소스코드가 있는 디렉토리까지 이동한다.
1. 컴파일하기 위한 명령어 javac test.java 입력.
1. 그럼 컴파일된 후 클래스 이름으로 .class확장자를 가진 파일이 생성된다. (Hello.class 라고 하자.)
1. class 파일은 java Hello 명령어를 통해 실행시킬 수 있다.


# 바이트코드

## 자바 컴파일러
자바 컴파일러는 자바로 작성한 자바 소스코드를 JVM이 이해할 수 있는 자바 바이트코드로 변환한다. 자바 컴파일러는 javac.exe라는 .exe파일 형태로 존재한다.

## 자바 바이트코드 (JAVA bytecode)
자바 바이트코드란 JVM이 이해할 수 있는 언어로 변환된 자바 소드코드이다. 자바 컴파일러에 의해 변환되는 코드의 명령어 크기가 1바이트이기에 자바 바이트코드라 불린다. 확장자는 .class이다. 자비 바이트 코드는 JVM만 설치돼 있다면 어떤 OS에서라도 실행가능하다. <br>
즉, 컴파일 타임 환경에서 자바 컴파일러를 거친 후 생기는 .class 확장자의 파일이며 이는 클래스 로더로 이동한다.


# JDK와 JRE
JVM은 프로그램을 실행하는 자바 플랫폼 구성요소다. JRE는 JVM을 생성하는 디스크 상의 부분이다. JDK는 개발자들이 JVM과 JRE에 의해 실행되고 구동될 수 있는 자바 프로그램을 생성할 수 있게 해준다.<br>
JDK를 다운로드하면 호환 버전의 JRE가 포함되고 JRE 에는 기본 JCM이 포함된다.

## JDK와 JRE?
JDK는 자바 기반 소프트웨어를 개발하기 위한 도구들로 이뤄진 패키지인데 비해, JRE는 자바 코드를 실행하기 위한 도구들로 구성된 패키지이다. <br>
JRE는 단지 자바 프로그램을 구동하기 위한 독립형 구성요소로써 사용될 수도 있지만, 동시에 JDK의 일부이기도 하다. 자바 프로그램을 구동하는 것이 자바 프로그램 개발의 일환이기 때문에 JDK는 JRE를 필요로 한다. 
![JDK, JRE](https://miro.medium.com/max/636/1*8oNn6HxcWFmrCsgUt27k0w.jpeg)

## JDK
- 기술적 정의: JDK는 컴파일러와 클래스 라이브러리를 포함하는, 자바 플랫폼 사양서의 구현이다.
- 일반적인 정의: JDK는 개발자가 자바 기반 애플리케이션 개발을 위해 다운로드하는 소프트웨어 패키지다.

## JDK와 자바 컴파일러
모든 JDK는 자바 애플리케이션 구동에 이용되는 환경이 JRE뿐만 아니라, 자바 컴파일러도 포함하고 있다. 컴파일러는 평범한 텍스트인 원시(raw) .java 파일을 받아서 실행 가능한 .class 파일로 만드는 기능이 있는 소프트웨어다.

## JRE

### 런타임 환경
소프트웨어 프로그램을 실행하기 위해서는 실행할 환경이 필요하다. 런타임 환경은 프로그램 실행을 위해 클래스 파일을 로드하고 메모리 및 기타 시스템 리소스에 대한 엑세스를 확보한다. 과거에는 대부분의 소프트웨어가 OS를 Runtime Environment로 사용했다. 프로그램은 해당 프로그램이 위치한 컴퓨터 내에서 실행됐지만 리소스 엑세스는 운영체제 설정에 의존했다. 여기서 리소스란 메모리, 프로그램 파일, 종속성 등이다. JRE는 자바에서 이런 틀을 바꿨다.

### JRE
소프트웨어는 시스템 하드웨어 위에 위치하는 일련의 계층으로 볼 수 있다. 각 계층은 그 위의 계층이 사용하거나 필요한 서비스를 제공한다. JRE는 OS위에서 실행되면서 자바를 위한 부가적인 서비스를 제공하는 소프트웨어 계층이다. JRE는 다양한 운영체제의 요철을 매끄럽게 다듬에 자바 프로그램이 거의 모든 운영체제에서 수정 없이 실행될 수 있도록 한다. 또한 Automatic memory management는 프로그래머가 메모리 할당과 재할당을 수동으로 조작할 필요가 없게 해주는 JRE의 가장 중요한 서비스 중 하나다.

### JRE와 JVM의 상호작용
JVM은 라이브 자바 프로그램 실행을 담당하는 실행 소프트웨어 시스템이다. JRE는 자바 코드를 받아서 필요한 라이브러리와 결합한 다음 이 코드를 실행할 JVM을 시작하는 온디스크 시스템이다. JRE에는 자바 프로램 실행에 필요한 라이브러리와 소프트웨어가 포함된다. 예를 들어 Java class loader는 JRE의 일부다. 이는 컴파일된 자바 코드를 메모리로 로드하고 적잘한 자바 클래스 라이브러리에 이 코드를 연결한다. JVM은 JRE에 의해 생성되는 것이다. <br>
![JRE, JVM](https://files.itworld.co.kr/archive/image/2018/09/jre-100771531-medium.jpg)



# 참고자료
[JVM](https://asfirstalways.tistory.com/158) <br>
[JDK](https://www.itworld.co.kr/news/110817) <br>
[JRE](https://www.itworld.co.kr/news/110768)