# escape

## 요구사항
- 게시물의 CRUD api 생성
- 데이터베이스를 사용하지 않을 것
- 초당 100건의 처리속도를 보장.
- 중복 생성시 duplicate 500 error
- 존재하지 않는 데이터 제거시 not exist 500 error



#curl 
-- curl -X GET http://localhost:8080/products/testId1 // id로 product 조회
-- curl -X GET http://localhost:8080/products         // products 조회 

