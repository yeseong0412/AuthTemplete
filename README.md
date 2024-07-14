## Kotlin + SpringBoot Auth Template
코프링으로 만든 JWT Auth Template입니다.

- [velog]() 에 자세한 설명을 적어뒀으니 참고 바랍니다.
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
