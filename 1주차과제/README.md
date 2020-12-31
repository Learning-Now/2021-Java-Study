# 2021-java-study
2021 자바 스터디 저장 공간


# 깃 bash 명령어

##커맨드 창 명령어
Ctrl + L : 화면 초기화
$ cd[이동할 하위 디렉토리명] : 디렉토리 이동
$ mkdir [현재 경로에 생성할 디렉토리명] : 디렉토리 생성
$ git rm -r [삭제할 디렉토리명] : 디렉토리 삭제
$ ls : 디렉토리 목록 조회
$ cat : 파일 내용 조회

##리모트 저장소 연결 명령어
$ git remote add origin [자신의 깃허브 원격저장소 주소] : 리모트 저장소에 깃허브 원격 저장소 연결정보 추가
$ git init : 리모트 저장소 초기화
$ git remote show[리모트 저장소 이름] : 리모트 저장소 연결정보 조회
$ git remote -v : 리모트 저장소 연결조회
$ git remote rm [삭제할 저장소 이름] : 리모트 저장소 삭제

##커밋 이력 조회
$ git status : 깃허브 커밋 상태 조회
$ git log : 커밋 이력 상세 조회

## 깃허브 커밋
$ git pull [리모트 저장소이름][브랜치이름] : 리모트 저장소 변경사항 불러오기-PULL
$git push[리모트저장소이름][브랜치이름] : 리모트 저장소 변경사항 올리기-PUSH
$git commit -m '[커밋설명]' : 변경사항 저장 - COMMIT

##브랜치
$ git branch : 브랜치 확인
$ git branch -r : 서버 브랜치 확인


# 마크다운 사용법

## 헤더
- 글머리 1~6까지 지원
```
# This is a H1
## This is a H2
### This is a H3
#### This is a H4
##### This is a H5
###### This is a H6
```

## 목록
- 순서있는 목록은 숫자와 점 이용
```
1. 첫번째
2. 두번째
3. 세번째
```

- 순서 없는 목록 (글머리 기호 *,+,- 지원)
```
* 1단계
 - 2단계
  + 3단계
```
* 1단계
 - 2단계
  + 3단계


## 코드
- 4개의 공백 또는 하나의 탭으로 들여쓰기 만나면 변환되기 시작해 들여쓰지 않은 행 만날때까지 변환

```
normal paragraph

	code block

end
```
를 실제 적용하면
normal paragraph

	code block

end


한줄 띄어쓰지 않으면 인식이 제대로 되지않는다.


### 코드 블럭

<pre><code>{code}</code></pre> 방식 & 코드블럭코드(```) 이용방식

```
<pre>
<code>
public class MyApplication {
  public static void main(String[] args) {
    System.out.println("Hello, World");
  }

}
</code>
</pre>
```
* * *
```
```
public class BootSpringBootApplication {
  public static void main(String[] args) {
    System.out.println("Hello, Honeymon");
  }
}
```
```

## 수평선
- 수평선을 만든다. 페이지 나누기 용도로 많이 사용
```
* * *
***
*****
- - -
-------------------
```

- 적용 예시
* * *
***
*****
- - -
-------------------

## 링크
- 참조 링크
```
[link keyword][id]

[id]: URL "Optional Title here"

// code
Link: [Google][googlelink]

[googlelink]: https://google.com "Go google"
```
예시:
[link keyword][id]

[id]: URL "Optional Title here"

// code
Link: [Google][googlelink]

[googlelink]: https://google.com "Go google"


- 외부 링크
```
사용문법: [Title](link)
적용예: [Google](https://google.com, "google link")
```

예시:
사용문법: [Title](link)
적용예: [Google](https://google.com, "google link")

- 자동 연결
```
일반적인 URL 혹은 이메일주소인 경우 적절한 형식으로 링크를 형성한다.

* 외부링크: <http://example.com/>
* 이메일링크: <address@example.com>
```

## 강조
```
*single asterisks*
_single underscores_
**double asterisks**
__double underscores__
~~cancelline~~
```

예시:
*single asterisks*
_single underscores_
**double asterisks**
__double underscores__
~~cancelline~~


## 이미지

```
![Alt text](/path/to/img.jpg)
![Alt text](/path/to/img.jpg "Optional title")
```

크기 설정:
```
<img src="/path/to/img.jpg" width="450px" height="300px" title="px(픽셀) 크기 설정" alt="RubberDuck"></img><br/>
<img src="/path/to/img.jpg" width="40%" height="30%" title="px(픽셀) 크기 설정" alt="RubberDuck"></img>
```


## 줄바꿈
- 3칸이상 띄어쓰기를 하면 줄이 바뀜


# 브랜치 만드는 법

##브랜치 만들기
```
$ git branch TEST // TEST라는 이름의 branch 생성
$ git checkout branchName // master에서 TEST branch로 변경

//branch 생성 & checkout 한번에 하려면
$git checkout -b branchName
```

##브랜치에 push 하기
```
$git add test.txt
$git commit -m "add text file"
$git push origin TEST
```

push 할때 origin [branchName]으로


