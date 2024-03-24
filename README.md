# <p align="center"> Project Naong! : Backend Repository</p>
- 리팩토링 진행 중입니다. (2024.03.18 ~ )

<div align ="center">
  <img src = "https://github.com/Jinseop-Sim/Naong/assets/71700079/aa6c47cd-284a-434d-9d1e-aded7434fb76">
  </br>
  
  <a href = "https://github.com/Jun2-Lee/Toy_project">
   <img src="https://img.shields.io/badge/GitRepo-181717?style=flat&logo=GitHub&logoColor=white&link=https://jinseop-sim.github.io/">
  </a>
  <a href = "http://3.36.144.128:8080/naong-api">
   <img src="https://img.shields.io/badge/Naong!-FF9E0F?style=flat&logo=ASKfm&logoColor=white&link=https://www.instagram.com/_35yed">
   </a>
</div>  
</br>

> :cat: Project 나옹!(나눠주세옹)은 대한민국의 고생하는 :house: 자취생들과 함께하는 플랫폼입니다.  

> 💸 부담스러운 음식 배달비를 함께 나누어 낼 수 있습니다.  

> 🥔 너무 많은 재료를 사서 버리게 될 때, 따뜻한 마음으로 나눌 수 있습니다.  

> 🥕 재료를 사고 싶지만 작은 양은 팔지 않을 때, 공동 구매로 따뜻한 마음을 표현할 수 있습니다!  

## :family: Team Member
<div align="center">

|심진섭|이준희|조예봄|이지수|김태영|
|:-:|:-:|:-:|:-:|:-:|
|<img src="https://avatars.githubusercontent.com/u/71700079?s=400&u=9e9338f1a22b811003f826b00c9b797a01aea381&v=4" width="100" height="100">|<img src="https://avatars.githubusercontent.com/u/80378041?v=4" width="100" height="100">|<img src="https://avatars.githubusercontent.com/u/71700079?s=400&u=39746e5ac607c719261bdd5a8fc0108a290ba975&v=4" width="100" height="100">|<img src="https://avatars.githubusercontent.com/u/101401447?v=4" width="100" height="100">|<img src="https://avatars.githubusercontent.com/u/100909703?v=4" width="100" height="100">|
|Backend|Backend|Design|Frontend|Frontend|
|[Github](https://github.com/Jinseop-Sim)|[Github](https://github.com/Jun2-Lee)|-|[Github](https://github.com/dlwltn0430)|[Github](https://github.com/taeyomi)|

</div>
   
## Architecture
![_서버 아키텍처 drawio](https://github.com/Jinseop-Sim/Naong/assets/71700079/a5d45783-4004-43a4-a346-2b35f4ebe5a1)  

- Java Springboot
  - 안정성이 검증된 프레임워크인 Springboot를 채택하였습니다.
  - Interpreter가 아닌 Compiler로, 빠른 실행 속도가 장점입니다.
- Spring Data JPA
  - DB에 접근할 수 있는 ORM 중 호환성이 좋은 JPA를 사용하였습니다.
- Maria DB (RDS)
- Spring Security
  - 사용자의 인증을 위해 Spring Security를 사용하였습니다.
- Redis
  - Refresh Token의 저장을 위해 사용되었습니다.
  - DB에 저장하지 않아 Token의 탈취 위험을 줄이고 DB 조회 빈도를 줄일 수 있습니다.
  - Access Token의 재발급에 사용됩니다.
- AWS EC2
  - EC2 환경에 백엔드 서버를 배포하였습니다.
- AWS S3
  - S3 Bucket에 프론트엔드를 배포하여 외부에서 접근할 수 있도록 했습니다.
  - 프로필 사진, 게시글 첨부 사진 등 이미지 관리에도 사용되었습니다.
- OAuth 2.0
  - 소셜 로그인 서비스를 구현하기 위해, 카카오 로그인 API를 사용하였습니다.

## Responsibility
- 회원가입 및 로그인 인증 구현
  - 소셜 로그인 API 적용
- 공동 구매, 나눔 게시글 기능 목록 구현
  - 공동 구매, 나눔 게시글 상세 페이지 데이터 전달
- 마이페이지 구현
- 일정 기능 구현
- 쪽지 기능 구현
  - WebSocket이 아닌, 단순 REST API 형태의 쪽지 구현
 
## Git Convention
- ```Feat : XXX``` : 개발한 기능을 Commit 할 때 사용합니다.
- ```Fix : XXX``` : 기능이나 타 요소에 대한 수정이 진행되었을 때 사용합니다.
- ```Refactor : ``` : 기존 코드를 리팩토링했을 때 사용합니다.
- ```Docs : XXX``` : 문서에 대한 수정이 발생했을 때 사용합니다.
- ```Delete : XXX``` : 문서, 파일 등을 삭제했을 때 사용합니다.
