## git의 repository 구조
- 작업 폴더(Working Directory)
- 인덱스(Staging Area)
- 저장소(Head-Repository)

|작업 폴더|인덱스|저장소|
|------|------|------|
|실제 파일들로 이루어짐|준비 영역<br>(add)|최종 확정본<br>(commit)|

## git 명령어
### - git init
: 새로운 git 저장소(repository)를 생성
- 현재 디렉토리를 기준으로 git 저장소 생성
  -> 디렉토리 내부에 .git 디렉토리가 생성됨

### - git config
: 설정 내용을 확인 또는 변경
- user.name과 user.email을 전역(--global)으로 설정
```
$ git config --global user.name "username"
$ git config --global user.email "useremail"
```
- 전역(--global)으로 설정된 user.name과 user.email을 삭제
```
$ git config --unset --global user.name
$ git config --unset --global user.email
```
- 전체 config 리스트 보기
```
$ git config --list
```

### - git status
: 파일의 상태(작업 폴더와 인덱스의 상태)를 확인

### - git add
: 작업 폴더상의 변경을 인덱스에 추가
- 작업 폴더의 변경 내용의 일부만 인덱스에 넘김
```
$ git add <파일/디렉토리 경로>
```
- 현재 폴더의 모든 변경 내용을 인덱스로 넘김
```
$ git add .
```
- 작업 폴더 내의 모든 변경 내용을 인덱스로 넘김
```
$ git add -A
```
> - **git add -A** 는 작업 폴더 상에 어디에 위치하든 항상 동일하게 모든 변경 내용을 인덱스로 넘김
- **git add .** 는 명령어를 실행한 폴더 이하에서 발생한 변경 내용만 포함하며, 해당 폴더 기준으로 상위 폴더의 변경 내용을 포함하지 않고 넘김

- 각 변경 사항을 터미널에서 직접 눈으로 하나씩 확인하면서 인덱스로 넘기거나 또는 제외함
```
$ git add -p
```

### - git rm
: 파일을 삭제
- 작업 폴더에는 파일을 남겨두고 인덱스에서만 파일 제거
```
$ git rm --cached
```

### - git commit
: 변경된 내용을 저장소에 추가
- 에디터를 열지 않고 터미널에서 바로 메시지를 입력
```
$ git commit -m "설명"
```
- 신규 파일을 제외하고 트래킹하는 모든 파일의 변경사항을 인덱스에 넘김과 동시에 저장소에 넘김
```
$ git commit -am "설명"
```
- 이전 commit에 현재 변경 내용 추가
  -> 에디터가 뜨면서 마지막 커밋 메시지를 수정하는 화면이 나오면 저장하고 에디터를 닫으면(:wq) 이전 커밋에 변경내용이 추가됨
```
$ git commit --amend
```

### - git log
: 커밋 기록 조회
-> 가장 위에 나오는 내역이 가장 최근 내역

### - git reset
: 특정 지점의 과거 커밋으로 이동하고 이동된 이후의 커밋 삭제
- 돌아가려는 커밋으로 돌아가서 그 이후의 모든 내용을 삭제
```
$ git reset --hard "돌아가려는 커밋"
```
- 돌아가려는 커밋으로 돌아가서 그 이후의 내용이 지워지지 않고, 해당 내용의 인덱스도 지워지지 않음
```
$ git reset --soft "돌아가려는 커밋"
```
- git reset의 default값으로, 돌아가려는 커밋으로 돌아가서 그 이후의 내용들은 남아있지만 인덱스는 초기화됨
```
$ git reset --mixed "돌아가려는 커밋"
```

### - git revert
: 특정 지점의 과거 커밋으로 이동하고 변경 내역을 유지
- 커밋을 되돌림**(이력이 남음)**
```
$ git revert "되돌릴 커밋"
```

### - git branch
: 현재 내가 위치한(로컬에서의) 브랜치 확인
- 브랜치 생성
```
$ git branch "브랜치명"
```
- 브랜치 삭제
```
$ git brach -d "브랜치명"
```
- 로컬+원격 브랜치 확인
```
$ git branch -a
```

### - git checkout
: 브랜치로 이동
- 해당 브랜치로 이동
```
$ git checkout "브랜치명"
```
- 브랜치 생성 후 해당 브랜치로 바로 이동
```
$ git checkout -b "브랜치명"
```

### - git merge
: 브랜치의 변화 가져옴
```
$ git merge "가져올 브랜치명`
```

### - git rebase
: 현재 브랜치의 base를 합칠 브랜치가 가리키는 커밋을 가리키게 하고 저장해두었던 변경사항을 차례대로 적용
```
$ git rebase "합칠 브랜치명"
```

### - git remote
: 원격 저장소 관리
- 원격 저장소 주소 등록
```
$ git remote add "원격저장소명" "주소"
```
- 원격 저장소 주소 삭제
```
$ git remote remove "원격저장소명"
```

### - git push
: 원격저장소에 커밋을 저장
- 폴더의 현 브랜치에 커밋된 내용을 "원경저장소명"의 "브랜치명"에 올림
```
$ git push "원격저장소명" "브랜치명"
```
- 원격저장소의 브랜치 삭제
```
$ git push -d "원격저장소명" "브랜치명"
```

### - git pull
: 원격저장소의 커밋들을 로컬저장소로 가져와서 merge
- "원격저장소명"의 내용이 "브랜치명"으로 복사됨
```
$ git pull "원격저장소명" "브랜치명"
```

### - git clone
: 원격저장소의 프로젝트를 내려받음
- 저장소의 내용을 다운로드받고 자동으로 init됨
```
$ git clone "저장소주소"
```

### - git fetch
: 원격저장소의 커밋들을 로컬저장소로 가져옴
-> 원래 내용과 바뀐 내용과의 차이를 알 수 있음