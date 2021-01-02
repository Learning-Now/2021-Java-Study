# 1주차 과제 설명

## Git bash 사용법

### 기본 명령어
- 화면 초기화 : Ctrl + L
- 한 행의 처음과 끝 : Ctrl + A, Ctrl + E
- 목록보기 : ls, dir
- 파일의 내용보기 : cat
- 특정문자를 검색 : grep
- 디렉터리로 이동 : cd
- 디렉터리 생성 : mkdir
- 파일 삭제 : rm
- 파일 생성 : touch

### git init //현재 디렉토리를 로컬저장소로 설정한다.

### git status //로컬저장소의 현재 상태를 보여준다.

### git add //파일을 준비영역으로 옮긴다.
- git add a.html : a.html 파일만 추가
- git add . : 워킹 디렉터리 내 모든 파일을 추가
- git add -i : 명령 프롬프트에서 상호작용하면서 추가

### git commit //준비영역의 파일을 로컬저장소에 저장한다.
- git commit : 에디터가 출력되고, 에디터에서 커밋 메시지 입력 후 저장하면 커밋됨
- git commit -m "" : 간단한 커밋 메시지를 입력 후 커밋

### git log //로컬저장소의 커밋 이력을 조회한다.

### git remote //로컬저장소와 원격저장소를 연결한다.
- git remote add origin [자신의 Github 원격저장소 주소] : Github 원격저장소와 연결한다
- git remote -v : 연결된 원격저장소 확인한다.

### git push //원격저장소에 저장한다

### git pull //지역브랜치를 원격브랜치에 푸싱하기

### git diff //워킹 디렉터리와 다른 커밋을 비교한다
- git diff : 현재 브랜치의 마지막 커밋과의 차이점 비교
- git diff [Commit ID] : 특정 커밋과의 차이점 비교

### git branch //브랜치를 생성, 수정, 삭제를 한다
- git branch : 브랜치 보기
- git branch[브랜치명] : 브랜치 보기
- git branch -m [브랜치명] [바꿀이름] : 브랜치 수정
- git branch -d [브랜치명] : 브랜치 삭제

### git checkout //워킹 디렉터리의 소스를 특정 커밋 또는 특정 브랜치로 변경한다
- git checkout [브랜치명] : 특정 브랜치로 워킹 디렉터리 변경
- git checkout [Commit ID]: 특정 커밋으로 워킹 디렉터리 변경

### git merge //다른 두 개의 브랜치 소스를 병합한다.
- git checkout master 
- git merge develop

## 마크다운 사용법
1. 헤더 : 제목, 문단별 제목을 쓰고 싶을 때
	# 제목 1단계 : #1개
	## 제목 2단계 : #2개
	### 제목 3단계 : #3개
	#### 제목 4단계 : #4개
	##### 제목 5단계 : #5개
	###### 제목 6단계 : #6
2. 수평선 : 내용을 명시적으로 구분하고 싶을 때
 ---
3. 엔터키 (줄바꿈, 개행) : 라인을 바꾸고 싶을 때  
 띄어쓰기 2번 입력  
4. 목록 : 요소를 나열할 때
 + 플러스
 - 마이너스
 * 별표 

5. 강조 : 문장 내 강조하고 싶은 단어를 눈에 띄게
 __언더바 2개 : 볼드 진하게__  
 _언더바 1개 : 이탤릭체(기울여서)_  
 ~~취소선~~  
 <u>밑줄</u>  
 __볼드로 진하게 만들다가*이탤릭으로 기울이고*다시 볼드로__  

6. 인용구 : 인용할 경우 또는 분위기 전환시에도
 > 마크다운
 >> 마크다운이란?
 >>> 마크다운 사용법

7. 링크 : 클릭하면 다른 페이지, 다른부분으로 이동 가능
 유형1(`설명어`를 클릭하면 URL로 이동) : [마크다운 설명](https://theorydb.github.io/envops/2019/05/22/envops-blog-how-to-use-md/ "마우스를 올려놓으면 말풍선이 나옵니다.")  
 유형2(URL 보여주고 `자동연결`) : <https://theorydb.github.io/envops/2019/05/22/envops-blog-how-to-use-md/>  
 유형3(동일 파일 내 `문단 이동`) : [동일파일 내 문단 이동](#markdown의-반드시-알아야-하는-문법)  

8. 이미지 : 이미지 보여주기  
 유형1(`이미지` 삽입) :  
 ![이미지](https://pixabay.com/get/52e5d0444a5bab14f6d1867dda3536781537d9e452507740_1920.jpg "cat")

 유형2(` 사이즈를 조절`하고 싶은 경우 HTML 태그로 처리) :
 <img src="https://pixabay.com/get/52e5d0444a5bab14f6d1867dda3536781537d9e452507740_1920.jpg" width="300" height="200">

 유형3(이미지 삽입 후, `링크 걸기`)
 [![이미지](https://pixabay.com/get/52e5d0444a5bab14f6d1867dda3536781537d9e452507740_1920.jpg)](https://pixabay.com/)

## Branch 만드는법

### git branch
- 지역 브랜치 목록 보기

### git branch -r
- 원격 브랜치 목록 보기

### git branch -a
- 지역과 원격을 포함한 모든 브랜치 목록 보기

### git branch <새로운 브랜치>
- 현재 브랜치에서 새로운 브랜치 생성하기 

### git checkout <브랜치>
- 다른 브랜치 체크아웃 하기

### git checkout -b <새로운 브랜치>
- 현재 브랜치에서 새로운 브랜치 생성하고 체크아웃하기

### git branch <새로운 브랜치> <브랜치를 생성할 위치>
- 다른 시작 지점에서 브랜치 생성하기

### git branch -f <기존 브랜치> [<브랜치를 생성할 위치>]
- 기존 브랜치를 새로운 브랜치로 덮어쓰기

### git checkout -m <기존 브랜치> <새로운 브랜치>
- 브랜치를 옮기거나 브랜치명 변경하기 : <새로운 브랜치>가 존재하지 않을 경우

### git checkout -M <기존 브랜치> <새로운 브랜치>
- 브랜치를 옮기거나 브랜치명 변경하기 : 무조건 덮어쓰기

### git merge <브랜치>
- 다른 브랜치를 현재 브랜치로 합치기

### git merge --no-commit <브랜치>
- 커밋하지 않고 합치기

### git cherry-pick <커밋명>
- 선택하여 합치기

### git cherry-pick-n <커밋명>
- 커밋하지 않고 선택하여 합치기

### git merge --squash <브랜치>
- 브랜치의 이력을 다른 브랜치에 합치기

### git branch -d <삭제할 브랜치>
- 브랜치 삭제하기 : 삭제할 브랜치가 현재 브랜치에 합쳐졌을 경우

### git branch -D <삭제할 브랜치>
- 브랜치 삭제하기 : 삭제할 브랜치가 현재 브랜치에 합쳐지지 않을 경우

### git push origin --delete <삭제할 브랜치>
- Remote branch 삭제

### git push origin : <삭제할 브랜치>
- Remote branch 삭제
