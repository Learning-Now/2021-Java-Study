## git working flow

### working Tree
local 저장소는 세 개로 구성되어 있다. <br>
1. 작업 디렉토리(working dir): local. 실제 파일들로 이루어져 있다.
1. 인덱스(index): 준비영역(staging area)의 역할을 한다. git index, staging area라고 부른다.
1. HEAD: 최종 확정본(commit).

## git repos

### 1. 서버에 있는 저장소를 clone

### 1. 기존 프로젝트를 git저장소로
- git init 
.git이라는 하위 디렉토리를 만든다.  .git디렉토리에는 저장소의 skeleton이 있다.
- 이후 staging해서 commit

## track

### tracked file

아래와 같은 상황
- modified.
- staged.
- already contained.
## command

### git status

아래와 같은 내용을 포함한다.
- tracked file
- modified file
- untracked file
- working branch

### git add

파일을 새로 추적할 수 있다.
1. git add [file-name]
1. git add *
1. git add *.*
1. git add .: 명령어가 실행된 폴더 이내의 모든 것
1. git add -A: 작업 폴더의 모든 것(전부)
1. git add -p: 현재 변경된 코드들의 파일들을 하나씩 보여주고, 해당 파일을 스테이지에 올릴 것인지, 올리지 않을 것인지 바로 선택할 수 있다. 이는 다음과 같은 효과를 가진다. (git status/git diff/git add) 혹은 (git status/git diff/git checkout --[file-name]). 

### git commit

1. git commit -m "message": stage한 후 modify하면 다시 unstage됨. 이후 다시 staging필요.
1. git commit -am "message": a option을 추가하면 tracked file은 자동으로 staging area에 추가함.

### git fetch
- git fetch: origin 저장소에서 합치지 않고 지역 브랜치로 변경 사항 가져오기
- git fetch [remote-repos]: remote repos에서 합치지 않고 local repos로 변경 사항 가져오기

### git pull
- git pull: origin 저장소에서 변경 사항을 가져와 current branch에 합치기
- [remote-repos]: remote repos에서 변경 사항을 가져와 current branch에 합치기

### git rm

- git에서 파일을 제거하는 것. git rm [file] 앞의 명령어를 수행하면 file을 staging area와 working dir에서 삭제한다. 앞의 명령어 없이 파일을 수정하거나 staging area에 추가했다면 -f option을 통해 강제로 삭제할 수 있다.

- git rm --cached [file-name]: staging area에서만 삭제하고 working dir에는 남겨두는 명령어이다. (untrack by git)<br>
.gitignore file에 추가하는 것을 빼먹었거나 대용량 로그파일 혹은 컴파일된 파일인 .a 파일을 올리는 등의 실수를 했을 때 사용한다.<br>
여러 개의 file이나 dir을 한번에 삭제하고 싶다면 git rm 명령에 file-glob 패턴을 사용하면 된다. e.g.(git rm  log/\*.log), (git rm \*~)

### git push

git push [remote-repos-name] [branch-name] (clone했을 경우 자동으로 origin으로 생성된다.) e.g.(git push -u origin main), u option은 push하기 전에 remote repos로부터 local repos를 업데이트해준다.

### .gitignore

always untrack particular file. e.g.(*.[oa]), (*~). .gitignore file 입력 패턴.
- 아무것도 없는 줄이나, #로 시작하는 줄은 무시한다.
- Standard Glob pattern을 사용한다.
- dir는 /를 끝에 사용하는 것으로 표현한다.
- !로 시작하는 패턴의 파일은 무시하지 않는다.

## Undo

### edit-commit
--amend option: staging area를 사용해 commit하는 것.<br>
마지막으로 commit한 후 modify가 없다면 직전 commit과 모든 것이 같음. commit-message변경할 수 있음. <br>
commit을 했는데 untracked file을 추가하고 싶다면 뒤의 예시를 따른다. e.g.(git commit -m "initial commit"/git add forgotten-file/git commit --amend). 이 경우 커맨드 3개는 모두 하나의 커밋으로 기록되며, 두 번째 commit은 첫 번째 commit을 덮어쓴다.

### unstage-file
두 개의 modified file을 따로 commit하려 했으나, 실수로 같이 git index에 올렸을 경우에 사용할 수 있다.<br>
git status command를 통해 본다면 (use "git reset HEAD ..." to unstage)와 같은 문구를 볼 수 있다. e.g.(git reset HEAD [file-name.file-extension]


### edit-modified-file
- first, use git status command. and e.g. as follows.
- (use "git add ..." to update what will be committed), (use "git checkout -- ..." to discard changed in working dir)

## branch

### generate-branch
- git branch: show local branch list
- git branch -r: show remote branch list
- git branch -a: show both branch
- git branch [new-branch-name]: 현재 브랜치에서 새로운 브랜치 생성하기
- git checkout [branch-name]: 다른 브랜치 체크아웃
- git checkout -b [new-branch-name]: 현재 브랜치에서 새로운 브랜치 생성하고 체크아웃
- git checkout -m [branch-name] [new-branch-name]: 브랜치를 옮기거나 이름 변경 (새로운 브랜치가 존재하지 않을 경우)
- git checkout -M [branch-name] [new-branch-name]: 브랜치를 옮기거나 이름 변경 (새로운 브랜치가 존재할 경우 무조건 덮어쓰기)
- git merge [branch-name]: 다른 브랜치를 현재 브랜치로 합치기
- git merge --no-commit [branch-name]: 커밋하지 않고 합치기
- git cherry-pick [commit-name]: 선택하여 합치기
- git cherry-pick -n [commit-name]: 커밋하지 않고 선택하여 합치기
- git merge --squash [branch-name]: 브랜치의 이력을 다른 브랜치에 합치기
- git branch -d [branch-want-del]: 브랜치 삭제하기 (삭제할 브랜치가 현재 브랜치에 합쳐졌을 경우에만)
- git branch -D [branch-want-del]: 브랜치 삭제하기 (삭제할 브랜치가 현재 브랜치에 합쳐지지 않았어도)

## log-of-git

### git log
- git log: 모든 이력 보기
- -p: 변경사항을 보여주는 패치와 함께 로그 표시
- -[num]: 숫자만큼의 항목만 보이도록 로그 개수 제한
- -20 -p: 20개의 항목과 패치가 보임
- --before="2days": 2일 전까지의 커밋 로그 표시
- -1 HEAD-3 또는 -1 HEAD^^^: HEAD보다 세 개 이전의 커밋 로그 표시
- --pretty-oneline: 각 항목의 로그 한 줄씩 보기
- --stat: 각 항목마다 영향 받은 줄의 통계 보기
- --name-status: 커밋할 시점의 파일 상태 보기

### git diff
- git diff: current working tree와 index의 차이점 보기
- --cached: index와 repos의 차이점 보기
- HEAD: working tree와 repos의 차이점 보기
- [starting-point]: working tree와 특정 지점 간의 차이점 보기 (starting-point는 commit-name, branch-name, tag-name이 될 수 있다.)
- [starting-point] [[ending-point]]: 저장소의 두 지점 사이의 차이점 보기
- --stat [starting-point] [[ending-point]]: 차이점의 통계 보기
- git blame [file]: file의 commit info 줄 단위로 보기

## usually-use-command

- $ git branch -> 로컬 branch 확인 
- $ git branch -r 서버 branch 확인 
- $ git checkout -b 브랜치명 브랜치를 만들고 바로 이동 
- $ git branch -d(D) test 브랜치 삭제 
- $ git status 현재상태(머지나 추가사항) 확인 
- $ git add 경로 에러를 해결하고 추가하여 에러해결 
- $ git stash 임시저장 
- $ git stash pop 임시저장한파일 불러오기 
- $ git remote prune origin 깃랩에서 삭제한거 서버와 동기화 
- $ git push origin :브랜치네임 서버에서 삭제하기 
- $ git remote 
- $ git push origin dev 
- $ git config http.postBuffer 104857600 git오류시 해결 
- $ git merge --squash dev 
- $ git merge --no-ff feature- : 새로운 가지 따서 merge(관리상 용이) 
- $ git clone 주소 
- $ git remote set-url origin 주소 : gitlap 저장소 변경시 설정 
- $ git remote -v : gitlap 저장소 주소 확인 // 고아 브랜치 만드는 방법 
- $ git checkout master 
- $ git checkout --orphan c_YYMMDD_CAMPAIGNNAME 
- $ git rm -rf . 
- $ git push origin c_YYMMDD_CAMPAIGNNAME