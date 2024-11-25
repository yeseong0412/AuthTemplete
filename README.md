## Kotlin + SpringBoot Auth Template
코프링으로 만든 JWT Auth Template입니다. <br>
오른쪽 위 Star 옆에 Use this template 를 누른 뒤 Create a new repository를 누르시면 이 코드를 바탕으로 새로운 repository를 빠르게 생성하실 수 있습니다.(제 커밋은 사라지니 걱정마세요!)

- [velog](https://velog.io/@yeseong0412/Spring-%EC%84%9C%EB%B2%84%EA%B0%9C%EB%B0%9C%ED%95%98%EB%A9%B4%EC%84%9C-%EC%95%84%EC%A7%81-JWT%EB%A5%BC-%EB%AA%A8%EB%A5%B8%EB%8B%A4%EA%B3%A0) 에 자세한 설명을 적어뒀으니 참고 바랍니다.
- Access/Refresh 를 지원합니다.
- JWT 로직 부분에 Error 핸들링을 지원합니다.
- 참조시 yml 파일에 jwt.secret는 본인의 코드로 변경하는걸 추천드립니다.


### 코드 기능
#### Register (회원가입)
##### /user/register
Request
```json
{
    "email" : "test@test.com",
    "name" : "양예성",
    "password" : "12345678"
}
```
Response
```json
{
    "status": 200,
    "state": "OK",
    "message": "회원가입 성공"
}
```
#### Login (로그인)
##### /user/login
Request
```json
{
    "email" : "test@test.com",
    "password" : "12345678"
}
```
Response
```json
{
    "status": 200,
    "state": "OK",
    "message": "로그인 성공",
    "data": {
        "accessToken": "Bearer eyJhbGciOiJIUzI1NiJ9.eyJpZCI6MSwiZW1haWwiOiJ5ZXNlb25nMDQxMkBuYXZlci5jb20iLCJyb2xlIjoiUk9MRV9VU0VSIiwiaWF0IjoxNzIwOTU4MzU5LCJleHAiOjE3MjA5NjQzNTl9.QKTeOOLNVF4phUNaXvjqAaOlifi1DwZOoW_iS_GRbDw",
        "refreshToken": "Bearer eyJhbGciOiJIUzI1NiJ9.eyJpZCI6MSwiZW1haWwiOiJ5ZXNlb25nMDQxMkBuYXZlci5jb20iLCJyb2xlIjoiUk9MRV9VU0VSIiwiaWF0IjoxNzIwOTU4MzU5LCJleHAiOjE3MjE4MjIzNTl9.mq2LWPEGyzHhCCI_Jn4n9bnbdiWzBgtO4U816I1rkoU"
    }
}
```
#### Refresh
##### /user/refresh
Request
```json
{
    "refreshToken" : "eyJhbGciOiJIUzI1NiJ9.eyJpZCI6MSwiZW1haWwiOiJ5ZXNlb25nMDQxMkBuYXZlci5jb20iLCJyb2xlIjoiUk9MRV9VU0VSIiwiaWF0IjoxNzIwOTU2NjQxLCJleHAiOjE3MjA5NjI2NDF9.IRChX7ungNumYHMtRMdnWizDH3C7bw78GNyaRWUlwZI"
}
```
Response
```json
{
    "status": 200,
    "state": "OK",
    "message": "리프레시 성공 !",
    "data": "Bearer eyJhbGciOiJIUzI1NiJ9.eyJpZCI6MSwiZW1haWwiOiJ5ZXNlb25nMDQxMkBuYXZlci5jb20iLCJyb2xlIjoiUk9MRV9VU0VSIiwiaWF0IjoxNzIwOTU3MTM4LCJleHAiOjE3MjA5NjMxMzh9.bvhpmz3C7TjSsygJlFYYd7tlrx5525MiSTUUWiu6QTs"
}
```

#### Error 핸들링을 지원하여 오류시 아래와 같은 오류핸들링을 지원합니다.
##### 빈 토큰으로 요청시
```json
{
    "status": 403,
    "state": "FORBIDDEN",
    "message": "토큰을 넣어주세요."
}
```

##### 토큰이 만료됬을경우
```json
{
    "status": 403,
    "state": "FORBIDDEN",
    "message": "토큰이 만료되었어요"
}
```

##### 토큰이 아닌 이상한 문자열 헤더에 담아 보낼시
```json
{
    "status": 401,
    "state": "UNAUTHORIZED",
    "message": "토큰이 구조가 이상하거나 데이터가 일치하지 않아요"
}
```

##### 비정상적인 토큰일시
```json
{
    "status": 401,
    "state": "UNAUTHORIZED",
    "message": "JWT 처리과정에서 알수없는 오류가 발생했어요"
}
```
