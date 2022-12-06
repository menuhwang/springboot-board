# 게시판 구현

멋쟁이 사자처럼 13팀의 스프링부트 연습 프로젝트입니다.

학습한 내용을 활용하여 간단한 게시판을 구현해봅니다.

## 주의사항

**DB 연결 정보, Secret Key와 같은 보안 사항을 푸시하지 않도록 주의해주세요!!**

## 브랜치

member/{name} 으로 새로운 브랜치를 생성하여 작업하고 푸시해주세요.

ex) member/minwoo

---
# Step 1 : 게시글 기능

게시글 Entity를 설계하고 CRUD를 구현.

+ C : Create
+ R : Read
+ U : Update
+ D : Delete

## 요구사항

+ 게시글에는 작성자, 제목, 본문이 들어갑니다. (게시글 id도 포함)
+ Request, Response DTO를 활용.

## Endpoint

### 게시글 조회

`GET /api/v1/boards/{id}`

### 게시글 등록

`POST /api/v1/boards`

### 게시글 수정

`PUT /api/v1/boards/{id}`

### 게시글 삭제

`DELETE /api/v1/boards/{id}`

# Step 2 : 댓글 기능

댓글 Entity를 설계하고 CRUD를 구현.

## 요구사항

+ 댓글에 작성자와 댓글을 작성할 수 있도록 해주세요.
+ 댓글과 게시글 사이에 연관관계를 설정해주세요.
+ Restful하게 Endpoint를 설계해주세요.