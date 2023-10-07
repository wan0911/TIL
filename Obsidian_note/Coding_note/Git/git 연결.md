1. repo 파기 

2. `git init`

3. (master인 경우에만) git branch -M main : master > main으로 변경

4. git remote add origin (git repo 주소)
>[!info] git 원격 repo 연결하기
> - repo 연결 확인        
>	`git remote -v`
><br/>
>- remote 삭제, 원격 연결 끊기
>	`git remote remove <저장소 이름>`

5. git pull origin main
>[!info]
> 📌 반드시 pull부터 해줘야 한다!
   
6. `git add .`

7. `git commit -m “메세지”`

8. `git push origin main`



